let dgemStss = new Vue({
    el: "#dgemStss",
    data: {
        params: {
            stndDtFr:'',
            stndDtTo:'',
            stndMmFr:'',
            stndMmTo:'',
            perdDivCd : 'DAY',
            occrDivCd : '02',
            sexCd : '',
            ageYcntFr : '',
            ageYcntTo : '',
            totalCount: 0,
            rowCount: 30,
            currentPage: 1,
            currentIndex: 0
        },
        code : {
            perdDivList : [],
            stndDtList: [],
            growJudgCdList : [],
            sexCdList : []
        },
        chartGidx : null,
        chartGidxJudg : null,
    },
    mixins: [statComponent],
    methods: {

        initialize: function() {

            let $this = this;

            $this.initCodeList();

            $this.initChart();

            $this.setDatepicker();

            $this.initData();

            $this.initSearch();
        },

        // 기본 날짜 세팅
        initData : function (){
            let $this = this;
            $this.statInitData();
        },

        initCodeList: function() {
            let $this = this;
            $this.statCodeList();
        },
        initSearch : function() {
            let $this = this;

            if(!$this.isValid()){
                return false;
            }

            AjaxUtil.post({
                url: "/stat/dgem/dgemStss/searchDgemStssColList.ab",
                param: $this.params,
                success: function(response) {
                    $this.code.stndDtList = [];
                    if ( !!response.rtnData.stndDtList && response.rtnData.stndDtList.length > 0 ) {
                        $.each(response.rtnData.stndDtList, function(index, item) {
                            $this.code.stndDtList.push({'stndDt':item.stndDt});
                        });
                    }
                    $this.code.growJudgCdList = [];
                    if ( !!response.rtnData.growJudgCdList && response.rtnData.growJudgCdList.length > 0 ) {
                        $.each(response.rtnData.growJudgCdList, function(index, item) {
                            $this.code.growJudgCdList.push({'cdVal':item.cdVal, 'cdNm':item.cdNm});
                        });
                    }

                    // 차트초기화 및 조회
                    $this.initGrid();
                    $this.searchDgemStssList(true);
                },
                error: function (response) {
                    Swal.alert([response, 'error']);
                }
            });
        },
        initGrid: function() {

            let $this = this;

            let colModels = [
                {name: "divCd"      , index: "divCd"      , label: "구분"   , width: 80, align: "center"}
            ];

            if($this.code.stndDtList.length > 0){
                for(var i in $this.code.stndDtList ){
                    var data = $this.code.stndDtList[i];
                    colModels.push( {name:data.stndDt , index:data.stndDt , label:data.stndDt ,  width: 80} );
                }
            }

            $("#gidx_list").jqGrid("GridUnload");
            $("#gidx_list").jqGrid($.extend(true, {}, commonGridOptions(), {
                datatype: "local",
                mtype: 'post',
                pginput : false,
                height: 30,
                url: '/stat/dgem/dgemStss/searchDgemStssList.ab',
                colModel: colModels
            }));

            resizeJqGridWidth("gidx_list", "gidx_list_wrapper");



            let colModelsJudg = [
                {name: "divCd"      , index: "divCd"      , label: "구분"   , width: 100, align: "center"},
                {name: "total"      , index: "total"      , label: "TOTAL"   , width: 80, align: "center"}
            ];

            if($this.code.growJudgCdList.length > 0){
                for(var i in $this.code.growJudgCdList ){
                    var data = $this.code.growJudgCdList[i];
                    colModelsJudg.push( {name:data.cdVal , index:data.cdVal , label:data.cdNm ,  width: 80} );
                }
            }

            $("#gidxJudg_list").jqGrid("GridUnload");
            $("#gidxJudg_list").jqGrid($.extend(true, {}, commonGridOptions(), {
                datatype: "local",
                mtype: 'post',
                pginput : false,
                height: 60,
                url: '/stat/dgem/dgemStss/searchDgemJudgList.ab',
                colModel: colModelsJudg
            }));


            resizeJqGridWidth("gidxJudg_list", "gidxJudg_list_wrapper");
        },

        initChart: function (){
            let $this = this;
            if ($this.chartGidx != null )  $this.chartGidx.destroy();
            if ($this.chartGidxJudg != null ) $this.chartGidxJudg.destroy();
            let dataGidx = {
                labels : [],
                datasets: [
                    {
                        label: '위험감정지수',
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

            let dataGidxJudg = {
                labels : [],
                datasets: [
                    {
                        data: [],
                        borderColor : "#fcdd84",
                        backgroundColor: "#0000ff"
                    }
                ]
            };

            let optionsGidx = {
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

            let optionsGidxJudg = {
                responsive : false,
                plugins: {
                    legend: {
                        display : true
                    },
                    tooltip : {
                        enabled : true
                    }
                }
            };

            let ctxGidx = document.getElementById('gidxChart').getContext('2d');
            let ctxGidxJudg = document.getElementById('gidxJudgChart').getContext('2d');

            let configGidx = {
                type : 'bar',
                data : dataGidx,
                options: optionsGidx,
                plugins: [ChartDataLabels]
            };



            let configGidxJudg = {
                type : 'pie',
                data : dataGidxJudg,
                options: optionsGidxJudg,
                plugins: [ChartDataLabels]
            };

            $this.chartGidx = new Chart(ctxGidx, configGidx);
            $this.chartGidxJudg = new Chart(ctxGidxJudg, configGidxJudg);
        },

        // 위험감정지수 차트
        updateGidxChart: function() {
            let $this = this;

            var gridData = $("#gidx_list").getRowData(1);
            let gridColModel = $("#gidx_list").jqGrid("getGridParam","colModel");

            var gidxLabels = [];
            var gidxData = [];

            if(gridData != null){
                for (let data in gridColModel) {
                    if(gridColModel[data].name != 'divCd') {
                        gidxLabels.push(gridColModel[data].name);
                        gidxData.push(gridData[gridColModel[data].name]);
                    }
                }
            }

            let dataGidx = {
                labels : gidxLabels,
                datasets: [
                    {
                        label: '위험감정지수',
                        data: gidxData,
                        borderColor : "#d6e5eb",
                        backgroundColor: "#d6e5eb",
                        order : 1,
                        datalabels:{
                            display:false
                        }
                    } ,
                    {
                        label: '',
                        data: gidxData,
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

            $this.chartGidx.data = dataGidx;
            $this.chartGidx.update();

        },

        // 성장판정상태 차트
        updateGidxJudgChart: function() {
            let $this = this;

            var gridData = $("#gidxJudg_list").getRowData(1);
            var gridData2 = $("#gidxJudg_list").getRowData(2);
            let gridColModel = $("#gidxJudg_list").jqGrid("getGridParam","colModel");

            var gidxLabels = [];
            var gidxData = [];
            var gidxColor = [];

            if(gridData != null){
                for (let data in gridColModel) {
                    if(gridColModel[data].name != 'divCd' &&  gridColModel[data].name != 'total') {
                        gidxLabels.push(gridColModel[data].label);
                        if($this.params.occrDivCd == '01') {
                            gidxData.push(gridData[gridColModel[data].name]);
                        }else {
                            gidxData.push(gridData2[gridColModel[data].name]);
                        }
                    }
                }
            }

            let dataGidxJudg = {
                labels : gidxLabels,
                datasets: [
                    {
                        data: gidxData,
                        borderColor : ["#fcf8f8" , "#fcf8f8" , "#fcf8f8", "#fcf8f8", "#fcf8f8"],
                        backgroundColor: ["#FEAFAB" , "#FBD5B0" , "#D6E5EB", "#D9F1F2", "#FBDEE2"],
                        datalabels:{
                            display:true,
                            color:'black',
                            font:{size:20},
                            formatter:function(value,context) {
                                var idx = context.dataIndex;
                                var labelText = "";
                                for (let data in gridColModel) {
                                    if(context.chart.data.labels[idx] == gridColModel[data].label ) {
                                        if($this.params.occrDivCd == '01') {
                                            labelText = gridData[gridColModel[data].name] + "건";
                                        }else {
                                            labelText = gridData2[gridColModel[data].name] + '%';
                                        }
                                        break;
                                    }
                                }

                                return labelText;
                            }
                        }
                    }
                ]
            };

            $this.chartGidxJudg.data = dataGidxJudg;
            $this.chartGidxJudg.update();

        },

        // 조회
        searchDgemStssList: function(isSearch) {
            let $this = this;
            let params = $.extend(true, {}, $this.params);

            if ( isSearch ) {
                params.currentPage = 1;
                params.currentIndex = 0;
            }

            $("#gidx_list").setGridParam({
                datatype: "json",
                postData: JSON.stringify(params),
                page: 1,
                loadComplete: function (response) {
                    if ( response.rtnData.result == 0 ) {
                        Swal.alert(['조회할 내용이 없습니다.', "info"]);
                    }
                    $this.updateGidxChart();
                }
            }).trigger("reloadGrid");


            $("#gidxJudg_list").setGridParam({
                datatype: "json",
                postData: JSON.stringify(params),
                page: 1,
                loadComplete: function (response) {
                    if ( response.rtnData.result == 0 ) {
                        Swal.alert(['조회할 내용이 없습니다.', "info"]);
                    }
                    $this.updateGidxJudgChart();

                }
            }).trigger("reloadGrid");

        },

        downloadExcel : function() {

            let $this = this;

            let params = $.extend(true, {}, $this.params);

            AjaxUtil.post({
                dataType: 'binary',
                url: "/stat/dgem/dgemStss/searchDgemStssList/excel.ab",
                param: params,
                success: function(response) {
                    saveFileLocal(response, 'dgemList.xls');
                },
                error: function (response) {
                    Swal.alert([response, 'error']);
                }
            });
        },

        resetSearchParam: function() {
            let $this = this;
            $this.params = {
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
            // $this.initChart();
            // $this.initGrid();

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
