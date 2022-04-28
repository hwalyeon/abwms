let apiStndMng = new Vue({
    el: "#apiStndMng",
    data: {
    	params: {
    		svrId: '',
            svrNm: '',
            apiUrl: '',
    		paging: 'Y',
    		totalCount: 0,
            rowCount: 30,
            currentPage: 1,
            currentIndex: 0
    	}
	},
	
    methods: {

        initialize: function() {
        	
        	let $this = this;
        	
        	$this.initCodeList();
        	
        	$this.initGrid();
        	
        	$this.searchApiList(true);

        },
        initCodeList: function() {
        	
        },
        initGrid: function() {
        	        	        	
        	let colModels = [
                {name: "svrId"     , index: "svrId"     , label: "서버 ID"     , width: 80, align: "center"},
                {name: "svrNm"     , index: "svrNm"     , label: "서버 명"     , width: 80, align: "center"},
                {name: "apiUrl"    , index: "apiUrl"    ,  label: "API_URL"   , width: 80, align: "center"},
                {name: "regDt"     , index: "regDt"     , label: "등록일자"     , width: 80          , align: "center"
                    , formatter: function(cellValue, options, rowObject) { return formatDate(cellValue);  }},
                {name: "regTm"     , index: "regTm"     , label: "등록시각"     , width: 80          , align: "center"
                    , formatter: function(cellValue, options, rowObject) { return formatTime(cellValue);  }},
                {name: "regUserId" , index: "regUserId" , label: "등록사용자ID" , width: 80          , align: "center"},
                {name: "uptDt"     , index: "uptDt"     , label: "수정일자"     , width: 80          , align: "center"
                    , formatter: function(cellValue, options, rowObject) { return formatDate(cellValue);  }},
                {name: "uptTm"     , index: "uptTm"     , label: "수정시각"     , width: 80          , align: "center"
                    , formatter: function(cellValue, options, rowObject) { return formatTime(cellValue);  }},
                {name: "uptUserId" , index: "uptUserId" , label: "수정사용자ID" , width: 80          , align: "center"},
                {name: "apiStndDetlPop", index: "apiStndDetlPop", label: "사용자 정보보기", width: 80, align: "center",
                    formatter: function(cellValue, options, rowObject) {
                        return '<input type="button" class="btn btn-xs btn-outline btn-success" onclick="apiStndMng.regUserPop(\'' + rowObject.svrId + '\')" value="상세보기" data-toggle="modal" data-target="#apiStndDetlPopup" />';
                    }
                }
            ];
  
            $("#user_list").jqGrid("GridUnload");
           	$("#user_list").jqGrid($.extend(true, {}, commonGridOptions(), {
            	datatype: "local",
            	mtype: 'post',
                url: '/cmon/stnd/searchApiList.ab',
                pager: '#user_pager_list',
				height: 550,
                colModel: colModels,
                onPaging : function(data) {
                    onPagingCommon(data, this, function(resultMap) {
                        $this.params.currentPage  = resultMap.currentPage;
                        $this.params.rowCount     = resultMap.rowCount;
                        $this.params.currentIndex = resultMap.currentIndex;
                        $this.searchApiList(false);
                    })
                }
            }));

            resizeJqGridWidth("user_list", "user_list_wrapper");                        
        },
        searchApiList: function(isSearch) {
			
			let $this = this;
            let params = $.extend(true, {}, $this.params);
			
            if ( isSearch ) {
                params.currentPage = 1;
                params.currentIndex = 0;
            }
            
			$("#user_list").setGridParam({
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
                url: "/cmon/stnd/searchApiList/excel.ab",
                param: params,
                success: function(response) {
                	saveFileLocal(response, 'apiStndMng.xls');
                },
                error: function (response) {
                    Swal.alert([response, 'error']);
                }
            });
		},
		regUserPop: function(userId) {
			apiStndDetl.initPage(userId);
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