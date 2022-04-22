let dzoneStss = new Vue({
    el: "#dzoneStss",
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
                    text:'발생건수'
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
                        url    : "/stat/dgem/dzoneStss/searchDzoneStssColList.ab",
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
                            $this.searchDzoneStssList(true);
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

                $("#dzoneStss_list").jqGrid("GridUnload");
                $("#dzoneStss_list").jqGrid($.extend(true, {}, commonGridOptions(), {
                    datatype : "local",
                    mtype    : 'post',
                    pginput  : false,
                    height   : 60,
                    url      : '/stat/dgem/dzoneStss/searchDzoneStssList.ab',
                    colModel : colModels
                    ,
                    onSelectRow: function(rowId, status, e){

                        $this.updateDzoneStssChart(rowId);
                    }

                }));

                resizeJqGridWidth("dzoneStss_list", "dzoneStss_list_wrapper");

            },
            initChart: function ()
            {
                let $this = this;

                if ($this.chartDzoneStss != null )  $this.chartDzoneStss.destroy();
                let dataDzoneStss = {
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

                let optionsDzoneStss = {
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

                let ctxDzoneStss = document.getElementById('dzoneStssChart').getContext('2d');

                let configDzoneStss = {
                    type   : 'bar',
                    data   : dataDzoneStss,
                    options: optionsDzoneStss,
                    plugins: [ChartDataLabels]
                };

                $this.chartDzoneStss = new Chart(ctxDzoneStss, configDzoneStss);
            },
            searchDzoneStssList: function(isSearch )
            {
                let $this  = this;
                let params = $.extend(true, {}, $this.params);

                if ( isSearch )
                {
                    params.currentPage = 1;
                    params.currentIndex = 0;
                }


                $("#dzoneStss_list").setGridParam
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
                            $this.updateDzoneStssChart(1);
                        }
                    }
                }).trigger("reloadGrid");

            },
            // 평균 운동시간 차트
            updateDzoneStssChart: function(rowId)
            {
                let $this = this;

                console.log(rowId);

                if(rowId==1){
                    $this.title.text ='발생건수'
                }else{
                    $this.title.text ='발생학생수'
                }



                var gridData      = $("#dzoneStss_list").getRowData(rowId);
                let gridColModel  = $("#dzoneStss_list").jqGrid("getGridParam","colModel");
                var dzoneStssLabels = [];
                var dzoneStssData   = [];

                if(gridData != null)
                {
                    for (let data in gridColModel)
                    {
                        if(gridColModel[data].name != 'divCd')
                        {
                            dzoneStssLabels.push(gridColModel[data].name);
                            dzoneStssData.push(gridData[gridColModel[data].name]);
                        }
                    }
                }

                let dataDzoneStss = {
                    labels : dzoneStssLabels,
                    datasets: [
                        {
                            label: $this.title.text,
                            data: dzoneStssData,
                            borderColor : "#d6e5eb",
                            backgroundColor: "#d6e5eb",
                            order : 1,
                            datalabels:{
                                display:false
                            }
                        } ,
                        {
                            label: '',
                            data: dzoneStssData,
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

                $this.chartDzoneStss.data = dataDzoneStss;
                $this.chartDzoneStss.update();

            },
            //평균 운동시간 통계 엑셀 다운로드
            downloadExcel: function()
            {
                let $this = this;
                let params = $.extend(true, {}, $this.params);

                AjaxUtil.post({
                    dataType: 'binary',
                    url: "/stat/dgem/dzoneStss/searchDzoneStssList/excel.ab",
                    param: params,
                    success: function(response) {
                        saveFileLocal(response, 'dzonStssList.xls');
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
            $this.updateDzoneStssChart(value);
        },
    },
    mounted: function() {
        let self = this;
        $(document).ready(function() {
            self.initialize();
        });
    }
});
