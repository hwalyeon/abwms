let avalActStss = new Vue({
    el: "#avalActStss",
    data:
        {
            params:
                {
                    stndDtFr    : '' ,
                    stndDtTo    : '' ,
                    stndMmFr    : '' ,
                    stndMmTo    : '' ,
                    perdDivCd   : 'DAY',
                    occrDivCd   : '02',
                    sexCd       : '' ,
                    ageYcntFr   : '' ,
                    ageYcntTo   : '' ,
                    totalCount  : 0  ,
                    rowCount    : 30 ,
                    currentPage : 1  ,
                    currentIndex: 0
                },
            code :
                {
                    perdDivList : [] ,
                    stndDtList  : [] ,
                    sexCdList   : []
                },
        },
    mixins: [statComponent],
    methods:
        {

            initialize: function()
            {
                let $this = this;

                $this.initCodeList();

                $this.initChart();

                $this.setDatepicker();

                $this.initData();

                $this.initSearch();
            },
            initCodeList: function()
            {
                let $this = this;

                $this.statCodeList();
            },
            // 기본 날짜 세팅
            initData : function ()
            {
                let $this = this;

                $this.statInitData();
            },
            initSearch: function()
            {
                let $this = this;

                if(!$this.isValid())
                {
                    return false;
                }

                AjaxUtil.post(
                    {
                        url    : "/stat/hc/avalActStss/searchAvalActStssColList.ab",
                        param  : $this.params,
                        success: function(response)
                        {
                            $this.code.stndDtList = [];
                            if ( !!response.rtnData.stndDtList && response.rtnData.stndDtList.length > 0 ) {
                                $.each(response.rtnData.stndDtList, function(index, item) {
                                    $this.code.stndDtList.push({'stndDt':item.stndDt});
                                });
                            }
                            // 차트초기화 및 조회
                            $this.initGrid();
                            $this.searchAvalActStssList(true);
                        },
                        error: function (response) {
                            Swal.alert([response, 'error']);
                        }
                    });
            },
            initGrid: function()
            {
                let $this = this;

                let colModels =
                    [
                        {name: "divCd", index: "divCd", label: "구분", width:80, align: "center" },
                        {name: "avgActTcntMcnt", index: "avgActTcntMcnt", label: "전체 운동시간(분)", width:80, align: "center" },
                        {name: "avgCalCsumQty", index: "avgCalCsumQty", label: "전체 칼로리섭취량(g)", width:80, align: "center" }
                    ];

                if($this.code.stndDtList.length > 0){
                    for(var i in $this.code.stndDtList ){
                        var data = $this.code.stndDtList[i];
                        colModels.push( {name:data.stndDt , index:data.stndDt , label:data.stndDt ,  width: 80} );
                    }
                }

                $("#avalAct_list").jqGrid("GridUnload");
                $("#avalAct_list").jqGrid($.extend(true, {}, commonGridOptions(), {
                    datatype : "local",
                    mtype    : 'post',
                    pginput  : false,
                    height   : 30,
                    url      : '/stat/hc/avalActStss/searchAvalActStssList.ab',
                    colModel : colModels
                }));

                resizeJqGridWidth("avalAct_list", "avalAct_list_wrapper");

            },
            initChart: function ()
            {
                let $this = this;

                if ($this.chartAvalAct != null )  $this.chartAvalAct.destroy();
                let dataAvalAct = {
                    labels  : [],
                    datasets: [
                        {
                            label: '성장지수',
                            data: [],
                            borderColor : "#fcdd84",
                            backgroundColor: "#0000ff",
                            order : 1
                        } ,
                        {
                            label: '',
                            data: [],
                            borderColor: "#f60636",
                            backgroundColor: "#f50940",
                            type: 'line',
                            order: 0
                        }
                    ]
                };

                let optionsAvalAct = {
                    responsive : false,
                    plugins: {
                        legend: {
                            position: 'top',
                            display : true
                        },
                        tooltip : {
                            enabled : true
                        }
                    }
                };

                let ctxAvalAct = document.getElementById('avalActChart').getContext('2d');

                let configAvalAct = {
                    type   : 'bar',
                    data   : dataAvalAct,
                    options: optionsAvalAct,
                    plugins: [ChartDataLabels]
                };

                $this.chartAvalAct = new Chart(ctxAvalAct, configAvalAct);
            },
            searchAvalActStssList: function(isSearch )
            {
                let $this  = this;
                let params = $.extend(true, {}, $this.params);

                if ( isSearch )
                {
                    params.currentPage = 1;
                    params.currentIndex = 0;
                }


                $("#avalAct_list").setGridParam
                ({
                    datatype    : "json",
                    postData    : JSON.stringify(params),
                    page        : 1,
                    loadComplete: function (response)
                    {
                        if ( response.rtnData.result == 0 )
                        {
                            Swal.alert(['조회할 내용이 없습니다.', "info"]);
                        }else
                        {
                            $this.updateAvalActChart();
                        }
                    }
                }).trigger("reloadGrid");

            },
            // 평균 칼로리 섭취 차트
            updateAvalActChart: function()
            {
                let $this = this;

                var gridData      = $("#avalAct_list").getRowData(1);
                let gridColModel  = $("#avalAct_list").jqGrid("getGridParam","colModel");
                var avalActLabels = [];
                var avalActData   = [];

                if(gridData != null)
                {
                    for (let data in gridColModel)
                    {
                        if(gridColModel[data].name != 'divCd')
                        {
                            avalActLabels.push(gridColModel[data].name);
                            avalActData.push(gridData[gridColModel[data].name]);
                        }
                    }
                }

                let dataAvalAct = {
                    labels : avalActLabels,
                    datasets: [
                        {
                            label: '평균 칼로리 섭취',
                            data: avalActData,
                            borderColor : "#d6e5eb",
                            backgroundColor: "#d6e5eb",
                            order : 1,
                            datalabels:{
                                display:false
                            }
                        } ,
                        {
                            label: '',
                            data: avalActData,
                            borderColor: "#FBD5B0",
                            backgroundColor: "#FBD5B0",
                            type: 'line',
                            order: 0,
                            datalabels:{
                                display:true
                            }
                        }
                    ]
                };

                $this.chartAvalAct.data = dataAvalAct;
                $this.chartAvalAct.update();

            },
            /**/
            downloadExcel: function()
            {
                let $this = this;

            },
            resetSearchParam: function()
            {
                let $this = this;

                $this.params =
                    {
                        stndDtFr: '',
                        stndDtTo: '',
                        stndMmFr: '',
                        stndMmTo: '',
                        perdDivCd: 'DAY',
                        occrDivCd: '02',
                        sexCd: '',
                        ageYcntFr: '',
                        ageYcntTo: '',
                        totalCount: 0,
                        rowCount: 30,
                        currentPage: 1,
                        currentIndex: 0
                    }

                $this.initData();
            },

        },
    computed: {

    },
    watch: {

    },
    mounted: function() {
        let self = this;
        $(document).ready(function() {
            self.initialize();
        });
    }
});
