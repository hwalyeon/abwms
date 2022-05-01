let foodEatStss = new Vue({
    el: "#foodEatStss",
    data:
        {
            params:
                {
                    stndDtFr    : '' ,
                    stndDtTo    : '' ,
                    stndMmFr    : '' ,
                    stndMmTo    : '' ,
                    perdDivCd   : 'DAY',
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
                    text:''
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
                        url    : "/stat/hc/foodEatStss/searchFoodEatStssColList.ab",
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
                            $this.searchFoodEatStssList(true);
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
                        {name: "foodNm", index: "foodNm", label: "구분", width:80, align: "center" }
                    ];

                if($this.code.stndDtList.length > 0){
                    for(var i in $this.code.stndDtList ){
                        var data = $this.code.stndDtList[i];
                        colModels.push( {name:data.stndDt , index:data.stndDt , label:data.stndDt ,  width: 80, align:"center"} );
                    }
                }

                $("#foodEat_list").jqGrid("GridUnload");
                $("#foodEat_list").jqGrid($.extend(true, {}, commonGridOptions(), {
                    datatype : "local",
                    mtype    : 'post',
                    pginput  : false,
                    height   : 180,
                    url      : '/stat/hc/foodEatStss/searchFoodEatStssList.ab',
                    colModel : colModels
                    ,
                    onSelectRow: function(rowId, status, e){

                        $this.updateFoodEatChart(rowId);
                    }

                }));

                resizeJqGridWidth("foodEat_list", "foodEat_list_wrapper");

            },
            initChart: function ()
            {
                let $this = this;

                if ($this.chartFoodEat != null )  $this.chartFoodEat.destroy();
                let dataFoodEat = {
                    labels  : [],
                    datasets: [
                        {
                            label: '평균 칼로리 섭취량('+$this.title.text+')',
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

                let optionsFoodEat = {
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

                let ctxFoodEat = document.getElementById('foodEatChart').getContext('2d');

                let configFoodEat = {
                    type   : 'bar',
                    data   : dataFoodEat,
                    options: optionsFoodEat,
                    plugins: [ChartDataLabels]
                };

                $this.chartFoodEat = new Chart(ctxFoodEat, configFoodEat);
            },
            searchFoodEatStssList: function(isSearch )
            {
                let $this  = this;
                let params = $.extend(true, {}, $this.params);

                if ( isSearch )
                {
                    params.currentPage = 1;
                    params.currentIndex = 0;
                }


                $("#foodEat_list").setGridParam
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
                            $this.updateFoodEatChart(1);
                        }
                    }
                }).trigger("reloadGrid");

            },
            // 평균 운동시간 차트
            updateFoodEatChart: function(rowId)
            {
                let $this = this;


                var gridData      = $("#foodEat_list").getRowData(rowId);
                let gridColModel  = $("#foodEat_list").jqGrid("getGridParam","colModel");
                var foodEatLabels = [];
                var foodEatData   = [];

                $this.title.text = gridData.foodNm;

                if(gridData != null)
                {
                    for (let data in gridColModel)
                    {
                        if(gridColModel[data].name != 'foodNm')
                        {
                            foodEatLabels.push(gridColModel[data].name);
                            foodEatData.push(gridData[gridColModel[data].name]);
                        }
                    }
                }

                let dataFoodEat = {
                    labels : foodEatLabels,
                    datasets: [
                        {
                            label:'평균 칼로리 섭취량('+$this.title.text+')',
                            data: foodEatData,
                            borderColor : "#d6e5eb",
                            backgroundColor: "#d6e5eb",
                            order : 1,
                            datalabels:{
                                display:false
                            }
                        } ,
                        {
                            label: '',
                            data: foodEatData,
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

                $this.chartFoodEat.data = dataFoodEat;
                $this.chartFoodEat.update();

            },
            //식품별 섭취 통계 엑셀 다운로드
            downloadExcel: function()
            {
                let $this = this;
                let params = $.extend(true, {}, $this.params);

                AjaxUtil.post({
                    dataType: 'binary',
                    url     : "/stat/hc/foodEatStss/searchFoodEatStssList/excel.ab",
                    param   : params,
                    success : function(response){
                        saveFileLocal(response, 'foodEatList.xls');
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
                        stndDtFr: '',
                        stndDtTo: '',
                        stndMmFr: '',
                        stndMmTo: '',
                        perdDivCd: 'DAY',
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
