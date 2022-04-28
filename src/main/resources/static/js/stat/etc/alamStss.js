let alamStss = new Vue({
    el: "#alamStss",
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
            alamTypeCd : '',
    		totalCount: 0,
            rowCount: 30,
            currentPage: 1,
            currentIndex: 0
    	},
    	code : {
    	    perdDivList : [],
            stndDtList: [],
            sexCdList : [],
            alamTypeCdList : [],
    	},
        chartAlam : null,
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

            getCommonCodeList('ALAM_TYPE_CD',$this.code.alamTypeCdList);
        },
        initSearch : function() {
            let $this = this;

            if(!$this.isValid()){
                return false;
            }

            AjaxUtil.post({
                url: "/stat/etc/alamStss/searchAlamStssColList.ab",
                param: $this.params,
                success: function(response) {
                    $this.code.stndDtList = [];
                    if ( !!response.rtnData.stndDtList && response.rtnData.stndDtList.length > 0 ) {
                        $.each(response.rtnData.stndDtList, function(index, item) {
                            $this.code.stndDtList.push({'stndDt':item.stndDt});
                        });
                    }

                    // 차트초기화 및 조회
                    $this.initGrid();
                    $this.searchAlamStssList(true);
                },
                error: function (response) {
                    Swal.alert([response, 'error']);
                }
            });
        },
        initGrid: function() {
        	
        	let $this = this;
        	
        	let colModels = [
                {name: "alamTypeCd"      , index: "alamTypeCd"      , label: "구분"   , width: 80, align: "center", hidden:true},
                {name: "alamTypeNm"      , index: "alamTypeNm"      , label: "구분"   , width: 80, align: "center"}
            ];

            if($this.code.stndDtList.length > 0){
                for(var i in $this.code.stndDtList ){
                    var data = $this.code.stndDtList[i];
                    colModels.push( {name:data.stndDt , index:data.stndDt , label:data.stndDt ,  width: 80} );
                }
            }
  
            $("#alam_list").jqGrid("GridUnload");
           	$("#alam_list").jqGrid($.extend(true, {}, commonGridOptions(), {
            	datatype: "local",
            	mtype: 'post',
                pginput : false,
            	height: 190,
                url: '/stat/etc/alamStss/searchAlamStssList.ab',
                colModel: colModels,
                onSelectRow: function(rowId, status, e){
                    $this.updateAlamChart();
                }
            }));

            resizeJqGridWidth("alam_list", "alam_list_wrapper");

        },

        initChart: function (){
            let $this = this;
            if ($this.chartAlam != null )  $this.chartAlam.destroy();

            let dataAlam = {
                labels : [],
                datasets: [
                    {
                        label: '알림 건수',
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


            let optionsAlam = {
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

            let ctxAlam = document.getElementById('alamChart').getContext('2d');

            let configAlam = {
                type : 'bar',
                data : dataAlam,
                options: optionsAlam,
                plugins: [ChartDataLabels]
            };

            $this.chartAlam = new Chart(ctxAlam, configAlam);
        },

        // 알림지수 차트
        updateAlamChart: function() {
            let $this = this;

            let rowData = null;

            if($("#alam_list").jqGrid("getGridParam","selrow") != null) {
                rowData = $("#alam_list").getRowData($("#alam_list").jqGrid("getGridParam","selrow") + "");
            }
            else {
                rowData = $("#alam_list").getRowData(1 + "");
            }

            var gridData = rowData;

            let gridColModel = $("#alam_list").jqGrid("getGridParam","colModel");

            var alamLabels = [];
            var alamData = [];

            if(gridData != null){
                for (let data in gridColModel) {
                    if(gridColModel[data].name != 'alamTypeCd' &&  gridColModel[data].name != 'alamTypeNm') {
                        alamLabels.push(gridColModel[data].name);
                        alamData.push(gridData[gridColModel[data].name]);
                    }
                }
            }

            let alamLabel = "알림";

            if(WebUtil.isNotNull(gridData.alamTypeNm)) alamLabel = gridData.alamTypeNm;

            let dataAlam = {
                labels : alamLabels,
                datasets: [
                    {
                        label: alamLabel +  ' 건수',
                        data: alamData,
                        borderColor : "#d6e5eb",
                        backgroundColor: "#d6e5eb",
                        order : 1,
                        datalabels:{
                            display:false
                        }
                    } ,
                    {
                        label: '',
                        data: alamData,
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

            $this.chartAlam.data = dataAlam;
            $this.chartAlam.update();

        },


        // 조회
		searchAlamStssList: function(isSearch) {
            let $this = this;
            let params = $.extend(true, {}, $this.params);

            if ( isSearch ) {
                params.currentPage = 1;
                params.currentIndex = 0;
            }
            
			$("#alam_list").setGridParam({
                datatype: "json",
                postData: JSON.stringify(params),
                page: 1,
                loadComplete: function (response) {
                    if ( response.rtnData.result == 0 ) {
                        Swal.alert(['조회할 내용이 없습니다.', "info"]);
                    }
                    $this.updateAlamChart();
                }
            }).trigger("reloadGrid");
		},

		downloadExcel : function() {
			
			let $this = this;
			
			let params = $.extend(true, {}, $this.params);
			
			AjaxUtil.post({
				dataType: 'binary',
                url: "/stat/etc/alamStss/searchAlamStssList/excel.ab",
                param: params,
                success: function(response) {
                	saveFileLocal(response, 'alamList.xls');
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
                alamTypeCd: '',
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
