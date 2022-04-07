let gidxStss = new Vue({
    el: "#gidxStss",
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

            var nowDate = new Date();

            $this.params.stndDtFr =moment(nowDate).add(-7, "days").format(dateFormatPattern);
            $this.params.stndDtTo =moment(nowDate).add(-1, "days").format(dateFormatPattern);

            $this.params.perdDivCd = 'DAY';
            $this.params.occrDivCd = '02';
        },

        initCodeList: function() {
            let $this = this;
            $this.code.perdDivList = CodeUtil.getPeriodDivList();
            getCommonCodeList('SEX_CD',$this.code.sexCdList);
        	
        },
        initSearch : function() {
            let $this = this;

            if(!$this.isValid()){
                return false;
            }

            AjaxUtil.post({
                url: "/stat/hc/gidxStss/searchGidxStssColList.ab",
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
                    $this.searchGidxStssList(true);
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
                url: '/stat/hc/gidxStss/searchGidxStssList.ab',
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
                url: '/stat/hc/gidxStss/searchGidxJudgList.ab',
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
                plugins: [{}]
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

        // 성장지수 차트
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
                        label: '성장지수',
                        data: gidxData,
                        borderColor : "#fcdd84",
                        backgroundColor: "#D6E5EB",
                        order : 1
                    } ,
                    {
                        label: '',
                        data: gidxData,
                        borderColor: "#FBD5B0",
                        backgroundColor: "#FBD5B0",
                        type: 'line',
                        order: 0
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

        setDatepicker : function() {
            let $this = this;

            $('#stndDtFrPicker').datepicker({
                todayBtn: "linked",
                keyboardNavigation: false,
                forceParse: false,
                calendarWeeks: true,
                autoclose: true,
                todayHighlight: true,
                maxDate : -1,
            }).on("changeDate", function() {
                $this.params.stndDtFr = $('#stndDtFr').val();
            });

            $('#stndDtToPicker').datepicker({
                todayBtn: "linked",
                keyboardNavigation: false,
                forceParse: false,
                calendarWeeks: true,
                autoclose: true,
                todayHighlight: true,
            }).on("changeDate", function() {
                $this.params.stndDtTo = $('#stndDtTo').val();
            });


            $('#stndMmFrPicker').datepicker({
                todayBtn: "linked",
                keyboardNavigation: false,
                forceParse: false,
                calendarWeeks: true,
                format: datepickerFormatMmPattern,
                startView: "months",
                minViewMode: "months",
                autoclose: true,
                todayHighlight: true,
            }).on("changeDate", function() {
                $this.params.stndMmFr = $('#stndMmFr').val();
            });

            $('#stndMmToPicker').datepicker({
                todayBtn: "linked",
                keyboardNavigation: false,
                forceParse: false,
                calendarWeeks: true,
                format: datepickerFormatMmPattern,
                startView: "months",
                minViewMode: "months",
                autoclose: true,
                todayHighlight: true,
                maxDate : "-1m"
            }).on("changeDate", function() {
                $this.params.stndMmTo = $('#stndMmTo').val();
            });
        },

        isValid : function (){
            let $this = this;
            if($this.params.perdDivCd === 'DAY') {
                const day = moment($this.params.stndDtTo, 'YYYY-MM-DD').diff($this.params.stndDtFr, 'days');
                if (day > 14) {
                    Swal.alert(["일자별 조회기간은 최대 14을 넘길 수 없습니다.", "warning"]);
                    return false;
                }

                if ( day < 0 ) {
                    Swal.alert(['기간 일자를 확인하시기 바랍니다.', 'info']);
                    return false;
                }

                if($this.params.stndDtTo != null && $this.params.stndDtTo != ''){
                    var stndDate = moment(new Date()).add(-1, "days").format(dateFormatPattern);
                    if($this.params.stndDtTo > stndDate){
                        Swal.alert(["전일까지만 조회 가능합니다.", "warning"]);
                        return false;
                    }
                }

                if(($this.params.stndDtTo == null || $this.params.stndDtTo == '') && ($this.params.stndDtFr == null || $this.params.stndDtFr != '')){
                    Swal.alert(["기간을 입력하여 주시기 바랍니다.", "warning"]);
                    return false;
                }

                if(($this.params.stndDtFr != null && $this.params.stndDtFr != '' && ($this.params.stndDtTo == null || $this.params.stndDtTo == ''))
                    || ($this.params.stndDtTo != null && $this.params.stndDtTo != '' && ($this.params.stndDtFr == null || $this.params.stndDtFr == '')) ){
                    Swal.alert(["기간을 입력하여 주시기 바랍니다.", "warning"]);
                    return false;
                }
            }else if($this.params.perdDivCd === 'WEEK' || $this.params.perdDivCd === 'MONTH') {

                const day = moment($this.params.stndMmTo, 'YYYY-MM').diff($this.params.stndMmFr, 'months');

                if(this.params.perdDivCd === 'MONTH'){
                    if (day > 11) {
                        Swal.alert(["월별 조회기간은 최대 1년을 넘길 수 없습니다.", "warning"]);
                        return false;
                    }
                }else if ($this.params.perdDivCd === 'WEEK'){
                    if (day > 2) {
                        Swal.alert(["주차별 조회기간은 최대 3개월을 넘길 수 없습니다.", "warning"]);
                        return false;
                    }
                }

                if ( day < 0 ) {
                    Swal.alert(['기간 일자를 확인하시기 바랍니다.', 'info']);
                    return false;
                }

                if($this.params.stndMmTo != null && $this.params.stndMmTo != ''){
                    var stndMm = moment(new Date()).add(-1, "month").format(dateFormatPattern);
                    if($this.params.stndMmTo > stndMm){
                        Swal.alert(["전월까지만 조회 가능합니다.", "warning"]);
                        return false;
                    }
                }

                if(($this.params.stndMmTo == null || $this.params.stndMmTo == '') && ($this.params.stndMmFr == null || $this.params.stndMmFr != '')){
                    Swal.alert(["기간을 입력하여 주시기 바랍니다.", "warning"]);
                    return false;
                }

                if(($this.params.stndMmFr != null && $this.params.stndMmFr != '' && ($this.params.stndMmTo == null || $this.params.stndMmTo == ''))
                    || ($this.params.stndMmTo != null && $this.params.stndMmTo != '' && ($this.params.stndMmFr == null || $this.params.stndMmFr == '')) ){
                    Swal.alert(["기간을 입력하여 주시기 바랍니다.", "warning"]);
                    return false;
                }

            }


            if($this.params.ageYcntFr != null && $this.params.ageYcntFr != '' && $this.params.ageYcntTo != null && $this.params.ageYcntTo != '' ){
                if(WebUtil.toNumber($this.params.ageYcntFr)  < 3 || WebUtil.toNumber($this.params.ageYcntTo) < 3 ){
                    Swal.alert(["나이는 3세 이상 부터 조회가 가능합니다.", "warning"]);
                    return false;
                }

                if(WebUtil.toNumber($this.params.ageYcntFr) > 19 || WebUtil.toNumber($this.params.ageYcntTo) > 19 ){
                    Swal.alert(["나이는 19세 까지 조회가 가능합니다.", "warning"]);
                    return false;
                }

                if(Number($this.params.ageYcntFr) > Number($this.params.ageYcntTo)){
                    Swal.alert(["나이를 확인하여 주시기 바랍니다.", "warning"]);
                    return false;
                }
            }

            if(($this.params.ageYcntFr != null && $this.params.ageYcntFr != '' && ($this.params.ageYcntTo == null || $this.params.ageYcntTo == ''))
               || ($this.params.ageYcntTo != null && $this.params.ageYcntTo != '' && ($this.params.ageYcntFr == null || $this.params.ageYcntFr == '')) ){
                    Swal.alert(["나이의 시작/종료 둘 다 입력하여 주시기 바랍니다.", "warning"]);
                    return false;
            }

            return true;

        },

        
        // 조회
		searchGidxStssList: function(isSearch) {
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
        changePerdDiv : function (){
            let $this = this;
            $this.params.stndDtFr = '';
            $this.params.stndDtTo = '';
            $this.params.stndMmFr = '';
            $this.params.stndMmTo = '';
        },
		downloadExcel : function() {
			
			let $this = this;
			
			let params = $.extend(true, {}, $this.params);
			
			AjaxUtil.post({
				dataType: 'binary',
                url: "/stat/hc/gidxStss/searchGidxStssList/excel.ab",
                param: params,
                success: function(response) {
                	saveFileLocal(response, 'gidxList.xls');
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
