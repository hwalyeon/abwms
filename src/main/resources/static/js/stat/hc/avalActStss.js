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
                occrDivCd   : '1',
                sexCd       : '' ,
                ageYcntFr   : '' ,
                ageYcntTo   : '' ,
                totalCount  : 0  ,
                rowCount    : 30 ,
                currentPage : 1  ,
                currentIndex: 0
            },
            title:
            {
                text:'운동시간(분)'
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

                $this.params.occrDivCd = '1';
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
                        {name: "divCd", index: "divCd", label: "구분", width:80, align: "center" }
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
                    height   : 60,
                    url      : '/stat/hc/avalActStss/searchAvalActStssList.ab',
                    colModel : colModels
                    ,
                    onSelectRow: function(rowId, status, e){

                        $this.updateAvalActChart(rowId);
                    }

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
                            label: $this.title.text,
                            data: [],
                            borderColor : "#d6e5eb",
                            backgroundColor: "#d6e5eb",
                            order : 1
                        } ,
                        {
                            label: '',
                            data: [],
                            borderColor: "#FBD5B0",
                            backgroundColor: "#FBD5B0",
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
                            display : false
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
                            $this.updateAvalActChart(1);
                        }
                    }
                }).trigger("reloadGrid");

            },
            // 평균 운동시간 차트
            updateAvalActChart: function(rowId)
            {
                let $this = this;

                console.log(rowId);

                if(rowId==1){
                    $this.title.text ='운동시간(분)'
                }else{
                    $this.title.text ='칼로리소모량(㎉)'
               }



                var gridData      = $("#avalAct_list").getRowData(rowId);
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
                            label: $this.title.text,
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
            //평균 운동시간 통계 엑셀 다운로드
            downloadExcel: function()
            {
                let $this = this;
                let params = $.extend(true, {}, $this.params);

                AjaxUtil.post({
                    dataType: 'binary',
                    url: "/stat/hc/avalActStss/searchAvalActStssList/excel.ab",
                    param: params,
                    success: function(response) {
                        saveFileLocal(response, 'avalActList.xls');
                    },
                    error: function (response) {
                        Swal.alert([response, 'error']);
                    }
                });
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
                        occrDivCd: '1',
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
        'params.occrDivCd': function(value) {
            let $this = this;
            $this.updateAvalActChart(value);
        },
    },
    mounted: function() {
        let self = this;
        $(document).ready(function() {
            self.initialize();
        });
    }
});
