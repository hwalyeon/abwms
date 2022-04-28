let cbeeStss = new Vue({
    el: "#cbeeStss",
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
                        url    : "/stat/etc/cbeeStss/searchCbeeStssColList.ab",
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
                            $this.searchCbeeStssList(true);
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
                        colModels.push( {name:data.stndDt , index:data.stndDt , label:data.stndDt ,  width: 80, align:"center", formatter:"integer"} );
                    }
                }

                $("#cbeeStss_list").jqGrid("GridUnload");
                $("#cbeeStss_list").jqGrid($.extend(true, {}, commonGridOptions(), {
                    datatype : "local",
                    mtype    : 'post',
                    pginput  : false,
                    height   : 60,
                    url      : '/stat/etc/cbeeStss/searchCbeeStssList.ab',
                    colModel : colModels
                }));

                resizeJqGridWidth("cbeeStss_list", "cbeeStss_list_wrapper");

            },
            initChart: function ()
            {
                let $this = this;

                if ($this.chartCbeeStss != null )  $this.chartCbeeStss.destroy();
                let dataCbeeStss = {
                    labels  : [],
                    datasets: [
                        {
                            label: '캐시비 사용금액',
                            data: [],
                            borderColor : "#d6e5eb",
                            backgroundColor: "#d6e5eb",
                            order : 1
                        } ,
                    ]
                };

                let optionsCbeeStss = {
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

                let ctxCbeeStss = document.getElementById('cbeeStssChart').getContext('2d');

                let configCbeeStss = {
                    type   : 'bar',
                    data   : dataCbeeStss,
                    options: optionsCbeeStss,
                    plugins: [ChartDataLabels]
                };

                $this.chartCbeeStss = new Chart(ctxCbeeStss, configCbeeStss);
            },
            searchCbeeStssList: function(isSearch )
            {
                let $this  = this;
                let params = $.extend(true, {}, $this.params);

                if ( isSearch )
                {
                    params.currentPage = 1;
                    params.currentIndex = 0;
                }


                $("#cbeeStss_list").setGridParam
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
                            $this.updateCbeeStssChart();
                        }
                    }
                }).trigger("reloadGrid");

            },
            // 캐시비 사용금액 차트
            updateCbeeStssChart: function()
            {
                let $this = this;

                var gridData      = $("#cbeeStss_list").getRowData(1);
                let gridColModel  = $("#cbeeStss_list").jqGrid("getGridParam","colModel");
                var cbeeStssLabels = [];
                var cbeeStssData   = [];

                if(gridData != null)
                {
                    for (let data in gridColModel)
                    {
                        if(gridColModel[data].name != 'divCd')
                        {
                            cbeeStssLabels.push(gridColModel[data].name);
                            cbeeStssData.push(gridData[gridColModel[data].name]);
                        }
                    }
                }

                let dataCbeeStss = {
                    labels : cbeeStssLabels,
                    datasets: [
                        {
                            label: '캐시비 사용금액',
                            data: cbeeStssData,
                            borderColor : "#d6e5eb",
                            backgroundColor: "#d6e5eb",
                            order : 1,
                            datalabels:{
                                display:false
                            }
                        } ,
                        {
                            label: '',
                            data: cbeeStssData,
                            borderColor: "#FBD5B0",
                            backgroundColor: "#FBD5B0",
                            type: 'line',
                            order: 0,
                            datalabels:{
                                display:true,
                                formatter:function(value,context) {
                                    return WebUtil.addThousandComma(value);
                                }
                            }
                        }
                    ]
                };

                $this.chartCbeeStss.data = dataCbeeStss;
                $this.chartCbeeStss.update();

            },
            //캐시비 사용금액 통계 엑셀 다운로드
            downloadExcel: function()
            {
                let $this = this;
                let params = $.extend(true, {}, $this.params);

                AjaxUtil.post({
                    dataType: 'binary',
                    url: "/stat/etc/cbeeStss/searchCbeeStssList/excel.ab",
                    param: params,
                    success: function(response) {
                        saveFileLocal(response, 'cbeeStssList.xls');
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
