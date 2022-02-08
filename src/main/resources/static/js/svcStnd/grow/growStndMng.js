let growStndMng = new Vue({
    el: "#growStndMng",
    data:
    {
    	params:
        {
    		dgemStatCd : ''  ,      //위험감정_상태_코드
    		paging          : 'Y',
    		totalCount    : 0  ,
            rowCount     : 30,
            currentPage : 1  ,
            currentIndex: 0
        },
        code:
        {
    	    dgemStatCdList : []
        },
	},
    methods:
    {
        initialize: function()
        {
        	let $this = this;
        	
        	$this.initCodeList();
        	
        	$this.initGrid();
        	
        	$this.searchDgemList(true);
        },
        initCodeList : function()
        {
            let $this = this;
            //위험감정상태 코드 목록 조회
            getCommonCodeList('DGEM_STAT_CD', $this.code.dgemStatCdList);
        },
        initGrid: function()
        {
        	let colModels = [
                {name: "dgemStatCd"     , index: "dgemStatCd"     , label: "위험감정상태코드"    , width: 80         , align: "center"},
                {name: "dgemStatCntn"  , index: "dgemStatCntn"  , label: "위험감정상태내용"    , width: 80         , align: "center"},
                {name: "regDt"                , index: "regDt"                 , label: "등록일자"                  , width: 80          , align: "center"},
                {name: "regTm"               , index: "regTm"               , label: "등록시각"                   , width: 80          , align: "center"},
                {name: "regUserId"          , index: "regUserId"         , label: "등록사용자ID"            , width: 80          , align: "center"},
                {name: "uptDt"                , index: "uptDt"                , label: "수정일자"                    , width: 80          , align: "center"},
                {name: "uptTm"               , index: "uptTm"               , label: "수정시각"                   , width: 80          , align: "center"},
                {name: "uptUserId"          , index: "uptUserId"         , label: "수정사용자ID"            , width: 80          , align: "center"}
            ];
  
            $("#dgem_list").jqGrid("GridUnload");
           	$("#dgem_list").jqGrid($.extend(true, {}, commonGridOptions(), {
            	datatype: "local",
            	mtype: 'post',
                url: '/svcStnd/dgem/dgemStndMng/searchDgemList.ab',
                pager: '#dgem_pager_list',
				height: 405,
                colModel: colModels,
                onPaging : function(data) {
                    onPagingCommon(data, this, function(resultMap) {
                        $this.params.currentPage  = resultMap.currentPage;
                        $this.params.rowCount     = resultMap.rowCount;
                        $this.params.currentIndex = resultMap.currentIndex;
                        $this.searchDgemList(false);
                    })
                }
            }));
            resizeJqGridWidth("dgem_list", "dgem_list_wrapper");
        },
        searchDgemList: function(isSearch)
        {
			let $this = this;
            let params = $.extend(true, {}, $this.params);
			
            if ( isSearch )
            {
                params.currentPage = 1;
                params.currentIndex = 0;
            }
            
			$("#dgem_list").setGridParam(
			{
                datatype: "json",
                postData: JSON.stringify(params),
                page: 1,
                loadComplete: function (response)
                {
                    if ( response.rtnData.result == 0 )
                    {
                        Swal.alert(['조회할 내용이 없습니다.', "info"]);
                    }
                }
            }).trigger("reloadGrid");
		},
		downloadExcel : function()
        {
			let $this = this;
			let params = $.extend(true, {}, $this.params);
			
			AjaxUtil.post({
				dataType: 'binary',
                url: "/svcStne/dgem/dgemStndMng/searchDgemList/excel.ab",
                param: params,
                success: function(response)
                {
                	saveFileLocal(response, 'dgemStndMng.xls');
                },
                error: function (response)
                {
                    Swal.alert([response, 'error']);
                }
            });
		},
		resetSearchParam: function() {
			let $this = this;
			$this.params = {
                dgemStatCd: '',      //위험감정_상태_코드
                paging: 'Y',
                totalCount: 0,
                rowCount: 30,
                currentPage: 1,
                currentIndex: 0
	    	}
		}
    },
    computed:
    {
    },
    watch:
    {
    },
    mounted: function()
    {
        let self = this;
        $(document).ready(function()
        {
            self.initialize();
        });
    }
});