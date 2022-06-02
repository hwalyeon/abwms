let strsStss = new Vue({
    el: "#strsStss",
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
            strsTypeCd : '',
            subStrsTypeCd : '',
    		totalCount: 0,
            rowCount: 30,
            currentPage: 1,
            currentIndex: 0
    	},
    	code : {
    	    perdDivList : [],
            stndDtList: [],
            strsStatCdList : [],
            sexCdList : []
    	},
        chartStrs : null,
        chartStrsJudg : null,
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
            
            document.getElementById("ageYcntFr").focus();
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
        // 조회검증
        checkSearch: function()
        {
        	let $this = this;

        	$this.initSearch();
        },
        initSearch : function() {
            let $this = this;

            var ageFr = $this.params.ageYcntFr;
            var ageTo = $this.params.ageYcntTo;
            
            if (WebUtil.isNull(ageFr) && WebUtil.isNull(ageTo) == false) $this.params.ageYcntFr =  4;
            if (WebUtil.isNull(ageTo) && WebUtil.isNull(ageFr) == false) $this.params.ageYcntTo = 18;
            
            if(!$this.isValid()){
                return false;
            }

            AjaxUtil.post({
                url: "/stat/hc/strsStss/searchStrsStssColList.ab",
                param: $this.params,
                success: function(response) {
                    $this.code.stndDtList = [];
                    if ( !!response.rtnData.stndDtList && response.rtnData.stndDtList.length > 0 ) {
                        $.each(response.rtnData.stndDtList, function(index, item) {
                            $this.code.stndDtList.push({'stndDt':item.stndDt});
                        });
                    }
                    // 그리드 초기화 및 조회
                    $this.initStrsGrid();
                    $this.searchStrsStssList(true);
                },
                error: function (response) {
                    Swal.alert([response, 'error']);
                }
            });
        },

        initStrsStatCdList : function (){
            let $this = this;

            if(WebUtil.isNotNull($this.params.strsTypeCd)){
                $this.params.subStrsTypeCd = $this.params.strsTypeCd;
            } else {
                let rowData = null;

                if($("#strs_list").jqGrid("getGridParam","selrow") != null) {
                    rowData = $("#strs_list").getRowData($("#strs_list").jqGrid("getGridParam","selrow") + "");
                }
                else {
                    rowData = $("#strs_list").getRowData(1 + "");
                }
                $this.params.subStrsTypeCd = rowData.strsTypeCd;
            }

            AjaxUtil.post({
                url: "/stat/hc/strsStss/searchStrsStatColList.ab",
                param: $this.params,
                success: function(response) {
                    $this.code.strsStatCdList = [];
                    if ( !!response.rtnData.strsStatCdList && response.rtnData.strsStatCdList.length > 0 ) {
                        $.each(response.rtnData.strsStatCdList, function(index, item) {
                            $this.code.strsStatCdList.push({'cdVal':item.cdVal, 'cdNm':item.cdNm});
                        });

                        // 그리드 초기화 및 조회
                        $this.initStrsJudgGrid();
                        $this.searchStrsJudgList(true);
                    }
                },
                error: function (response) {
                    Swal.alert([response, 'error']);
                }
            });
        },

        initStrsGrid : function (){
            let $this = this;

            let colModels = [
                {name: "strsTypeCd"      , index: "strsTypeCd"      , label: "구분"   , width: 80, align: "center", hidden: true},
                {name: "strsTypeNm"      , index: "strsTypeNm"      , label: "구분"   , width: 80, align: "center"}
            ];

            if($this.code.stndDtList.length > 0){
                for(var i in $this.code.stndDtList ){
                    var data = $this.code.stndDtList[i];
                    colModels.push( {name:data.stndDt , index:data.stndDt , label:data.stndDt ,  width: 80, align:"center"} );
                }
            }

            $("#strs_list").jqGrid("GridUnload");
            $("#strs_list").jqGrid($.extend(true, {}, commonGridOptions(), {
                datatype: "local",
                mtype: 'post',
                pginput : false,
                height: 90,
                url: '/stat/hc/strsStss/searchStrsStssList.ab',
                colModel: colModels,
                onSelectRow: function(rowId, status, e){
                    $this.updateStrsChart();
                    $this.initStrsStatCdList();
                }
            }));

            resizeJqGridWidth("strs_list", "strs_list_wrapper");
        },

        initStrsJudgGrid: function() {
            let $this = this;
            let colModelsJudg = [
                {name: "divCd"      , index: "divCd"      , label: "구분"   , width: 100, align: "center"},
                {name: "total"      , index: "total"      , label: "TOTAL"   , width: 80, align: "center"}
            ];

            if($this.code.strsStatCdList.length > 0){
                for(var i in $this.code.strsStatCdList )
                {
                    var data = $this.code.strsStatCdList[i];
                    colModelsJudg.push( {name:data.cdVal , index:data.cdVal , label:data.cdNm ,  width: 80, align:"center"} );
                }
            }

            $("#strsJudg_list").jqGrid("GridUnload");
            $("#strsJudg_list").jqGrid($.extend(true, {}, commonGridOptions(), {
                datatype: "local",
                mtype: 'post',
                pginput : false,
                height: 90,
                url: '/stat/hc/strsStss/searchStrsJudgList.ab',
                colModel: colModelsJudg
            }));

            resizeJqGridWidth("strsJudg_list", "strsJudg_list_wrapper");
        },

        initChart: function (){
            let $this = this;
            if ($this.chartStrs != null )  $this.chartStrs.destroy();
            if ($this.chartStrsJudg != null ) $this.chartStrsJudg.destroy();
            let dataStrs = {
                labels : [],
                datasets: [
                    {
                        label: '스트레스지수',
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

            let dataStrsJudg = {
                labels : [],
                datasets: [
                    {
                        data: [],
                        borderColor : "#fcdd84",
                        backgroundColor: "#0000ff"
                    }
                ]
            };

            let optionsStrs = {
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

            let optionsStrsJudg = {
                responsive : false,
                plugins: {
                    legend: {
                        position: 'right',
                        display : true
                    },
                    tooltip : {
                        enabled : true
                    }
                }
            };

            let ctxStrs = document.getElementById('strsChart').getContext('2d');
            let ctxStrsJudg = document.getElementById('strsJudgChart').getContext('2d');

            let configStrs = {
                type : 'bar',
                data : dataStrs,
                options: optionsStrs,
                plugins: [ChartDataLabels]
            };



            let configStrsJudg = {
                type : 'pie',
                data : dataStrsJudg,
                options: optionsStrsJudg,
                plugins: [ChartDataLabels]
            };

            $this.chartStrs = new Chart(ctxStrs, configStrs);
            $this.chartStrsJudg = new Chart(ctxStrsJudg, configStrsJudg);
        },

        // 스트레스지수 차트
        updateStrsChart: function() {
            let $this = this;

            let rowData = null;

            if($("#strs_list").jqGrid("getGridParam","selrow") != null) {
                rowData = $("#strs_list").getRowData($("#strs_list").jqGrid("getGridParam","selrow") + "");
            }
            else {
                rowData = $("#strs_list").getRowData(1 + "");
            }

            var gridData = rowData;
            let gridColModel = $("#strs_list").jqGrid("getGridParam","colModel");

            var strsLabels = [];
            var strsData = [];

            if(gridData != null){
                for (let data in gridColModel) {
                    if(gridColModel[data].name != 'strsTypeNm' && gridColModel[data].name != 'strsTypeCd') {
                        strsLabels.push(gridColModel[data].name);
                        strsData.push(gridData[gridColModel[data].name]);
                    }
                }
            }

            let dataStrs = {
                labels : strsLabels,
                datasets: [
                    {
                        label: gridData.strsTypeNm + ' 지수',
                        data: strsData,
                        borderColor : "#d6e5eb",
                        backgroundColor: "#d6e5eb",
                        order : 1,
                        datalabels:{
                            display:false
                        }
                    } ,
                    {
                        label: '',
                        data: strsData,
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

            $this.chartStrs.data = dataStrs;
            $this.chartStrs.update();

        },

        // 스트레스판정상태 차트
        updateStrsJudgChart: function() {
            let $this = this;

            var gridData = $("#strsJudg_list").getRowData(1);
            var gridData2 = $("#strsJudg_list").getRowData(2);
            let gridColModel = $("#strsJudg_list").jqGrid("getGridParam","colModel");

            var strsLabels = [];
            var strsData = [];
            var strsColor = [];

            if(gridData != null){
                for (let data in gridColModel) {
                    if(gridColModel[data].name != 'divCd' &&  gridColModel[data].name != 'total') {
                        strsLabels.push(gridColModel[data].label);
                        if($this.params.occrDivCd == '01') {
                            strsData.push(gridData[gridColModel[data].name]);
                        }else {
                            strsData.push(gridData2[gridColModel[data].name]);
                        }
                    }
                }
            }

            let dataStrsJudg = {
                labels : strsLabels,
                datasets: [
                    {
                        data: strsData,
                        borderColor : ["#fcf8f8" , "#fcf8f8" , "#fcf8f8", "#fcf8f8", "#fcf8f8"],
                        backgroundColor: ["#D6E5EB", "#D9F1F2" , "#FBD5B0" , "#FBDEE2","#FEAFAB"],
                        datalabels:{
                            display:true,
                            color:'black',
                            font:{size:15},
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

            $this.chartStrsJudg.data = dataStrsJudg;
            $this.chartStrsJudg.update();

        },

        // 조회
		searchStrsStssList: function(isSearch) {
            let $this = this;
            let params = $.extend(true, {}, $this.params);

            if ( isSearch ) {
                params.currentPage = 1;
                params.currentIndex = 0;
            }

			$("#strs_list").setGridParam({
                datatype: "json",
                postData: JSON.stringify(params),
                page: 1,
                loadComplete: function (response) {
                    if ( response.rtnData.result == 0 ) {
                        Swal.alert(['조회할 내용이 없습니다.', "info"]);
                    }
                    $this.updateStrsChart();
                    $this.initStrsStatCdList();
                }
            }).trigger("reloadGrid");

		},

        searchStrsJudgList: function(isSearch) {
            let $this = this;

            let params = $.extend(true, {}, $this.params);

            if ( isSearch ) {
                params.currentPage = 1;
                params.currentIndex = 0;
            }

            $("#strsJudg_list").setGridParam({
                datatype: "json",
                postData: JSON.stringify(params),
                page: 1,
                loadComplete: function (response) {
                    if ( response.rtnData.result == 0 ) {
                        Swal.alert(['조회할 내용이 없습니다.', "info"]);
                    }
                    $this.updateStrsJudgChart();

                }
            }).trigger("reloadGrid");

        },

		downloadExcel : function() {
			
			let $this = this;
			
			let params = $.extend(true, {}, $this.params);
			
			AjaxUtil.post({
				dataType: 'binary',
                url: "/stat/hc/strsStss/searchStrsStssList/excel.ab",
                param: params,
                success: function(response) {
                	saveFileLocal(response, 'strsList.xls');
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
                strsTypeCd : '',
                subStrsTypeCd : '',
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
        'params.occrDivCd': function() {
            let $this = this;
            $this.updateStrsJudgChart();
        },

    },
    mounted: function() {
        let self = this;
        $(document).ready(function() {
            self.initialize();
        });
    }
});
