let notiMng = new Vue({
    el: "#notiMng",
    data: {
    	params: {
            blbdNo:'',
            blbdStrtDt:'',
            blbdExprDt:'',
            blbdTypeCd:'',
            blbdTitl:'',
            blbdCntn:'',
            srchCnt:'',
            alamYn:'',
            blbdPeri: 'THIS_MONTH',
            regDt:'',
            regTm:'',
            regUserId:'',
    		paging: 'Y',
    		totalCount: 0,
            rowCount: 30,
            currentPage: 1,
            currentIndex: 0
    	},
        code:
        {
            blbdPeriList : []
        },
	},
	
    methods: {

        initialize: function() {
        	
        	let $this = this;
        	
        	$this.initCodeList();
        	
        	$this.initGrid();

            $this.setDatepicker();

        	$this.searchNotiList(true);

        	document.getElementById("blbdNo").focus();
        },
        initCodeList: function() {
            let $this = this;
            $this.code.blbdPeriList    = CodeUtil.getPeriodDateList();

            const period = getPeriodDate($this.params.blbdPeri);
            this.params.blbdStrtDt = period.strDt;
            this.params.blbdExprDt = period.endDt;
        },
        initGrid: function() {
        	        	        	
        	let colModels = [
                {name: "blbdNo"     , index: "blbdNo"     , label: "게시번호"     , width: 80, align: "center"},
                {name: "blbdStrtDt" , index: "blbdStrtDt" , label: "게시시작 일자" , width: 80, align: "center"
                    , formatter: function(cellValue, options, rowObject) { return formatDate(cellValue);  }},
                {name: "blbdExprDt" , index: "blbdExprDt" , label: "게시만기 일자" , width: 80, align: "center"
                    , formatter: function(cellValue, options, rowObject) { return formatDate(cellValue);  }},
                {name: "blbdTypeCd" , index: "blbdTypeCd" , label: "게시유형 코드" , hidden: true},
                {name: "blbdTypeNm" , index: "blbdTypeNm" , label: "게시유형"     , width: 80, align: "center"},
                {name: "blbdTitl"   , index: "blbdTitl"   , label: "게시제목"     , width: 150},
                {name: "blbdCntn"   , index: "blbdCntn"   , label: "게시내용"     , width: 200},
                {name: "srchCnt"    , index: "srchCnt"    , label: "조회건수"     , width: 80, align: "center"},
                {name: "alamYn"     , index: "alamYn"     , label: "알림여부"     , width: 80, align: "center"},
                {name: "regDt"      , index: "regDt"      , label: "등록일자"     , width: 80, align: "center"
                    , formatter: function(cellValue, options, rowObject) { return formatDate(cellValue);  }},
                {name: "regTm"      , index: "regTm"      , label: "등록시각"     , width: 80, align: "center"
                    , formatter: function(cellValue, options, rowObject) { return formatTime(cellValue);  }},
                {name: "regUserId"  , index: "regUserId"  , label: "등록사용자ID" , width: 80, align: "center"},
                {name: "uptDt"      , index: "uptDt"      , label: "수정일자"     , width: 80, align: "center"
                    , formatter: function(cellValue, options, rowObject) { return formatDate(cellValue);  }},
                {name: "uptTm"      , index: "uptTm"      , label: "수정시각"     , width: 80, align: "center"
                    , formatter: function(cellValue, options, rowObject) { return formatTime(cellValue);  }},
                {name: "uptUserId"  , index: "uptUserId"  , label: "수정사용자ID" , width: 80, align: "center"},
                {name: "notiDetlPop", index: "notiDetlPop", label: "사용자 정보보기", width: 80, align: "center",
                    formatter: function(cellValue, options, rowObject) {
                        return '<input type="button" class="btn btn-xs btn-outline btn-success" onclick="notiMng.regUserPop(\'' + rowObject.blbdNo + '\')" value="상세보기" data-toggle="modal" data-target="#notiDetlPopup" />';
                    }
                }
            ];
  
            $("#noti_list").jqGrid("GridUnload");
           	$("#noti_list").jqGrid($.extend(true, {}, commonGridOptions(), {
            	datatype: "local",
            	mtype: 'post',
                url: '/cmon/blbd/searchNotiList.ab',
                pager: '#noti_pager_list',
				height: 450,
                colModel: colModels,
                onPaging : function(data) {
                    onPagingCommon(data, this, function(resultMap) {
                        $this.params.currentPage  = resultMap.currentPage;
                        $this.params.rowCount     = resultMap.rowCount;
                        $this.params.currentIndex = resultMap.currentIndex;
                        $this.searchNotiList(false);
                    })
                }
            }));

            resizeJqGridWidth("noti_list", "noti_list_wrapper");                        
        },
        // 조회검증
        checkSearch: function()
        {
        	let $this = this;
        	$this.searchNotiList(true);
        },
        searchNotiList: function(isSearch) {
			
			let $this = this;
            let params = $.extend(true, {}, $this.params);
            
            if ( isSearch ) {
                params.currentPage = 1;
                params.currentIndex = 0;
            }
            
			$("#noti_list").setGridParam({
                datatype: "json",
                postData: JSON.stringify(params),
                page: 1,
                loadComplete: function (response) {
                    console.log(response.rtnData.result);
                    if ( response.rtnData.result == 0 ) {
                        Swal.alert(['조회할 내용이 없습니다.', "info"]);
                    }
                }
            }).trigger("reloadGrid");
		},
		downloadExcel : function() {
			
			let $this = this;
			
			let params = $.extend(true, {}, $this.params);
			
			AjaxUtil.post({
				dataType: 'binary',
                url: "/cmon/blbd/searchNotiList/excel.ab",
                param: params,
                success: function(response) {
                	saveFileLocal(response, 'NotiMng.xls');
                },
                error: function (response) {
                    Swal.alert([response, 'error']);
                }
            });
		},
		regUserPop: function(blbdNo) {
			notiDetl.initPage(blbdNo);
		},
        setDatepicker : function() {
            let $this = this;

            $('#blbdStrtDtPicker').datepicker({
                todayBtn: "linked",
                keyboardNavigation: false,
                forceParse: false,
                calendarWeeks: true,
                autoclose: true,
                todayHighlight: true,
            }).on("changeDate", function() {
                $this.params.blbdStrtDt = $('#blbdStrtDt').val();
            });

            $('#blbdExprDtPicker').datepicker({
                todayBtn: "linked",
                keyboardNavigation: false,
                forceParse: false,
                calendarWeeks: true,
                autoclose: true,
                todayHighlight: true,
            }).on("changeDate", function() {
                $this.params.blbdExprDt = $('#blbdExprDt').val();
            });
        },

        blbdPeriSelect: function() {
            let $this = this;
            const period = getPeriodDate($this.params.blbdPeri);
            this.params.blbdStrtDt = period.strDt;
            this.params.blbdExprDt = period.endDt;
        },

        resetSearchParam: function() {
			let $this = this;
			$this.params = {
				userId: '',
	    		userNm: '',
	    		blngNm: '',
	    		telNo: '',
	    		mtelNo: '',
	    		mailAddr: '',
	    		paging: 'Y',
	    		totalCount: 0,
	            rowCount: 30,
	            currentPage: 1,
	            currentIndex: 0
	    	}
		}
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