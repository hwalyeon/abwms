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
            dgemStssCdList : [],
            sexCdList : []
        },
        chartDgem : null,
        chartDgemStss : null,
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
                    $this.code.dgemStssCdList = [];
                    if ( !!response.rtnData.dgemStssCdList && response.rtnData.dgemStssCdList.length > 0 ) {
                        $.each(response.rtnData.dgemStssCdList, function(index, item) {
                            $this.code.dgemStssCdList.push({'cdVal':item.cdVal, 'cdNm':item.cdNm});
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

            $("#dgem_list").jqGrid("GridUnload");
            $("#dgem_list").jqGrid($.extend(true, {}, commonGridOptions(), {
                datatype: "local",
                mtype: 'post',
                pginput : false,
                height: 30,
                url: '/stat/dgem/dgemStss/searchDgemStssList.ab',
                colModel: colModels
            }));

            resizeJqGridWidth("dgem_list", "dgem_list_wrapper");



            let colModelsStss = [
                {name: "divCd"      , index: "divCd"      , label: "구분"   , width: 100, align: "center"},
                {name: "total"      , index: "total"      , label: "TOTAL"   , width: 80, align: "center"}
            ];

            if($this.code.dgemStssCdList.length > 0){
                for(var i in $this.code.dgemStssCdList ){
                    var data = $this.code.dgemStssCdList[i];
                    colModelsStss.push( {name:data.cdVal , index:data.cdVal , label:data.cdNm ,  width: 80} );
                }
            }

            $("#dgemStss_list").jqGrid("GridUnload");
            $("#dgemStss_list").jqGrid($.extend(true, {}, commonGridOptions(), {
                datatype: "local",
                mtype: 'post',
                pginput : false,
                height: 60,
                url: '/stat/dgem/dgemStss/searchDgemJudgList.ab',
                colModel: colModelsStss
            }));


            resizeJqGridWidth("dgemStss_list", "dgemStss_list_wrapper");
        },

        initChart: function (){
            let $this = this;
            if ($this.chartDgem != null )  $this.chartDgem.destroy();
            if ($this.chartDgemStss != null ) $this.chartDgemStss.destroy();
            let dataDgem = {
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

            let dataDgemStss = {
                labels : [],
                datasets: [
                    {
                        data: [],
                        borderColor : "#fcdd84",
                        backgroundColor: "#0000ff"
                    }
                ]
            };

            let optionsDgem = {
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

            let optionsDgemStss = {
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

            let ctxDgem = document.getElementById('dgemChart').getContext('2d');
            let ctxDgemStss = document.getElementById('dgemStssChart').getContext('2d');

            let configDgem = {
                type : 'bar',
                data : dataDgem,
                options: optionsDgem,
                plugins: [ChartDataLabels]
            };



            let configDgemStss = {
                type : 'pie',
                data : dataDgemStss,
                options: optionsDgemStss,
                plugins: [ChartDataLabels]
            };

            $this.chartDgem = new Chart(ctxDgem, configDgem);
            $this.chartDgemStss = new Chart(ctxDgemStss, configDgemStss);
        },

        // 위험감정지수 차트
        updateDgemChart: function() {
            let $this = this;

            var gridData = $("#dgem_list").getRowData(1);
            let gridColModel = $("#dgem_list").jqGrid("getGridParam","colModel");

            var dgemLabels = [];
            var dgemData = [];

            if(gridData != null){
                for (let data in gridColModel) {
                    if(gridColModel[data].name != 'divCd') {
                        dgemLabels.push(gridColModel[data].name);
                        dgemData.push(gridData[gridColModel[data].name]);
                    }
                }
            }

            let dataDgem = {
                labels : dgemLabels,
                datasets: [
                    {
                        label: '위험감정지수',
                        data: dgemData,
                        borderColor : "#d6e5eb",
                        backgroundColor: "#d6e5eb",
                        order : 1,
                        datalabels:{
                            display:false
                        }
                    } ,
                    {
                        label: '',
                        data: dgemData,
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

            $this.chartDgem.data = dataDgem;
            $this.chartDgem.update();

        },

        // 위험감정상태 차트
        updateDgemStssChart: function() {
            let $this = this;

            var gridData = $("#dgemStss_list").getRowData(1);
            var gridData2 = $("#dgemStss_list").getRowData(2);
            let gridColModel = $("#dgemStss_list").jqGrid("getGridParam","colModel");

            var dgemLabels = [];
            var dgemData = [];
            var dgemColor = [];

            if(gridData != null){
                for (let data in gridColModel) {
                    if(gridColModel[data].name != 'divCd' &&  gridColModel[data].name != 'total') {
                        dgemLabels.push(gridColModel[data].label);
                        if($this.params.occrDivCd == '01') {
                            dgemData.push(gridData[gridColModel[data].name]);
                        }else {
                            dgemData.push(gridData2[gridColModel[data].name]);
                        }
                    }
                }
            }

            let dataDgemStss = {
                labels : dgemLabels,
                datasets: [
                    {
                        data: dgemData,
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

            $this.chartDgemStss.data = dataDgemStss;
            $this.chartDgemStss.update();

        },

        // 조회
        searchDgemStssList: function(isSearch) {
            let $this = this;
            let params = $.extend(true, {}, $this.params);

            if ( isSearch ) {
                params.currentPage = 1;
                params.currentIndex = 0;
            }

            $("#dgem_list").setGridParam({
                datatype: "json",
                postData: JSON.stringify(params),
                page: 1,
                loadComplete: function (response) {
                    if ( response.rtnData.result == 0 ) {
                        Swal.alert(['조회할 내용이 없습니다.', "info"]);
                    }
                    $this.updateDgemChart();
                }
            }).trigger("reloadGrid");


            $("#dgemStss_list").setGridParam({
                datatype: "json",
                postData: JSON.stringify(params),
                page: 1,
                loadComplete: function (response) {
                    if ( response.rtnData.result == 0 ) {
                        Swal.alert(['조회할 내용이 없습니다.', "info"]);
                    }
                    $this.updateDgemStssChart();

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
