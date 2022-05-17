let neatStss = new Vue({
    el: "#neatStss",
    data:
        {
            params:
                {
                    eagrDivCd   : 'HIST' , //섭취집계_구분_코드
                    mmelYn      : 'MORN' ,     //아침_여부
                    amelYn      : '' ,     //점심_여부
                    emelYn      : '' ,     //저녁_여부
                    stndDtFr    : '' ,     //기준_일자_Fr
                    stndDtTo    : '' ,     //기준_일자_To
                    stndMmFr    : '' ,     //기준_월_Fr
                    stndMmTo    : '' ,     //기준_월_To
                    perdDivCd   : 'DAY',   //기간_구분_코드
                    sexCd       : '' ,     //성별_코드
                    ageYcntFr   : '' ,     //나이_년수_Fr
                    ageYcntTo   : '' ,     //나이_년수_To
                    occrDivCd   : '1' ,    //발생_구분_코드
                    totalCount  : 0  ,
                    rowCount    : 30 ,
                    currentPage : 1  ,
                    currentIndex: 0
                },
            title:
                {
                    text:'결식건수'
                },
            code :
                {
                    eagrDivCdList : [] , //섭취집계_구분_코드_리스트
                    perdDivList   : [] , //기간_구분_코드_리스트
                    stndDtList    : [] , //기준_일자_리스트
                    sexCdList     : [] , //성별_코드_리스트
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
                //섭취집계_구분_코드
                getCommonCodeList('EAGR_DIV_CD',$this.code.eagrDivCdList);
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
                        url    : "/stat/hc/neatStss/searchNeatStssColList.ab",
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
                            $this.searchNeatStssList(true);
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
                        colModels.push( {name:data.stndDt , index:data.stndDt , label:data.stndDt ,  width: 80, align:"center"} );
                    }
                }

                $("#neat_list").jqGrid("GridUnload");
                $("#neat_list").jqGrid($.extend(true, {}, commonGridOptions(), {
                    datatype : "local",
                    mtype    : 'post',
                    pginput  : false,
                    height   : 60,
                    url      : '/stat/hc/neatStss/searchNeatStssList.ab',
                    colModel : colModels
                    ,
                    onSelectRow: function(rowId, status, e){

                        $this.updateNeatChart(rowId);
                    }

                }));

                resizeJqGridWidth("neat_list", "neat_list_wrapper");

            },
            initChart: function ()
            {
                let $this = this;

                if ($this.chartNeat != null )  $this.chartNeat.destroy();
                let dataNeat = {
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

                let optionsNeat = {
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

                let ctxNeat = document.getElementById('neatChart').getContext('2d');

                let configNeat = {
                    type   : 'bar',
                    data   : dataNeat,
                    options: optionsNeat,
                    plugins: [ChartDataLabels]
                };

                $this.chartNeat = new Chart(ctxNeat, configNeat);
            },
            searchNeatStssList: function(isSearch )
            {
                let $this  = this;
                let params = $.extend(true, {}, $this.params);

                if ( isSearch )
                {
                    params.currentPage = 1;
                    params.currentIndex = 0;
                }


                $("#neat_list").setGridParam
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
                            $this.updateNeatChart(1);
                        }
                    }
                }).trigger("reloadGrid");

            },
            // 평균 운동시간 차트
            updateNeatChart: function(rowId)
            {
                let $this = this;


                var gridData      = $("#neat_list").getRowData(rowId);
                let gridColModel  = $("#neat_list").jqGrid("getGridParam","colModel");
                var neatLabels = [];
                var neatData   = [];

                if(rowId == '1')
                {
                    $this.title.text = '결식건수';
                }else
                {
                    $this.title.text = '결식율(%)';
                }

                if(gridData != null)
                {
                    for (let data in gridColModel)
                    {
                        if(gridColModel[data].name != 'divCd')
                        {
                            neatLabels.push(gridColModel[data].name);
                            neatData.push(gridData[gridColModel[data].name]);
                        }
                    }
                }

                let dataNeat = {
                    labels : neatLabels,
                    datasets: [
                        {
                            label:$this.title.text,
                            data: neatData,
                            borderColor : "#d6e5eb",
                            backgroundColor: "#d6e5eb",
                            order : 1,
                            datalabels:{
                                display:false
                            }
                        } ,
                        {
                            label: '',
                            data: neatData,
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

                $this.chartNeat.data = dataNeat;
                $this.chartNeat.update();
            },
            //섭취집계_구분_코드_변경 시
            changeEagrDiv: function(value)
            {
                let $this = this;
                if(value=='QUST'){
                    $this.params.perdDivCd = 'WEEK' ;
                    $this.params.mmelYn = 'MORN';
                    $this.params.amelYn = '';
                    $this.params.emelYn = '';
                }

            },

            //식품별 섭취 통계 엑셀 다운로드
            downloadExcel: function()
            {
                let $this = this;
                let params = $.extend(true, {}, $this.params);

                AjaxUtil.post({
                    dataType: 'binary',
                    url     : "/stat/hc/neatStss/searchNeatStssList/excel.ab",
                    param   : params,
                    success : function(response){
                        saveFileLocal(response, 'neatList.xls');
                    },
                    error: function(response){
                        Swal.alert([response, 'error']);
                    }
                });
            },
            resetSearchParam: function()
            {
                let $this = this;

                $this.params =
                    {
                        eagrDivCd   : 'HIST' , //섭취집계_구분_코드
                        mmelYn      : 'MORN' , //아침_여부
                        amelYn      : '' ,     //점심_여부
                        emelYn      : '' ,     //저녁_여부
                        stndDtFr    : '' ,     //기준_일자_Fr
                        stndDtTo    : '' ,     //기준_일자_To
                        stndMmFr    : '' ,     //기준_월_Fr
                        stndMmTo    : '' ,     //기준_월_To
                        perdDivCd   : 'DAY',   //기간_구분_코드
                        sexCd       : '' ,     //성별_코드
                        ageYcntFr   : '' ,     //나이_년수_Fr
                        ageYcntTo   : '' ,     //나이_년수_To
                        occrDivCd   : '1' ,    //발생_구분_코드
                        totalCount  : 0  ,
                        rowCount    : 30 ,
                        currentPage : 1  ,
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
            $this.updateNeatChart(value);
        },
    },
    mounted: function() {
        let self = this;
        $(document).ready(function() {
            self.initialize();
        });
    }
});