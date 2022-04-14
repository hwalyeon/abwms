let fatPrdtStndMng = new Vue({
    el: "#fatPrdtStndMng", //위험감정_상태_기준
    data:
    {
    	params:
        {
            userId          : ''  ,
            fatJudgCd       : ''  , //비만_판정_코드
            fatpJudgCd      : ''  , //비만예측_판정_코드
    		paging          : 'Y' ,
    		totalCount      : 0   ,
            rowCount        : 30  ,
            currentPage     : 1   ,
            currentIndex    : 0
        },
        code:
        {
            fatJudgCdList   : []  , //비만_판정_코드_리스트
            fatpJudgCdList  : []  , //비만예측_판정_코드_리스트
        },
	},
    methods:
    {
        initialize: function()
        {
        	let $this = this;

            $this.initValue();
        	$this.initCodeList();
        	$this.initGrid();
            $this.searchFatPrdtList(true);
        },
        initValue: function()
        {
            let $this = this;
            $this.userId = SessionUtil.getUserId();
        },
        initCodeList : function()
        {
            let $this = this;

            getCommonCodeList('FAT_JUDG_CD',$this.code.fatJudgCdList);  //비만_판정_코드_리스트
            getCommonCodeList('FAT_JUDG_CD',$this.code.fatpJudgCdList); //비만예측_판정_코드_리스트

        },
        initGrid: function()
        {
        	 let $this = this;				                                                             
             
        	let colModels = [
                {name: "crud"               , index: "crud"               , label: "crud"                  , hidden: true },
                {name: "fatJudgCd"          , index: "fatJudgCd"          , label: "비만 판정 코드"         , hidden: true },
                {name: "fatpJudgCd"         , index: "fatpJudgCd"         , label: "비만 예측 판정 코드"    , hidden: true },
                {name: "fatJudgCdNm"        , index: "fatJudgCdNm"        , label: "비만 판정 코드명"       , align: "center"   , width: 150  },
                {name: "fatpJudgCdNm"       , index: "fatpJudgCdNm"       , label: "비만 예측 판정 코드명"  , align: "center"   , width: 150  },
                {name: "fatpEvalSmry"       , index: "fatpEvalSmry"       , label: "비만예측 평가 요약"     , align: "center"   , width: 150   },
                {name: "fatpEvalCntn"       , index: "fatpEvalCntn"       , label: "비만예측 평가 내용"     , align: "center"   , width: 350   },
                {name: "regDt"              , index: "regDt"              , label: "등록 일자"              , align: "center"   , width: 100   },
                {name: "regTm"              , index: "regTm"              , label: "등록 시각"              , align: "center"   , width: 100    },
                {name: "regUserId"          , index: "regUserId"          , label: "등록 사용자 ID"         , align: "center"   , width: 100    },
                {name: "uptDt"              , index: "uptDt"              , label: "수정 일자"              , align: "center"   , width: 100   },
                {name: "uptTm"              , index: "uptTm"              , label: "수정 시각"              , align: "center"   , width: 100   },
                {name: "uptUserId"          , index: "uptUserId"          , label: "수정 사용자 ID"         , align: "center"   , width: 100   },
                {name: "fatPrdtStndDetlPop" , index: "fatPrdtStndDetlPop" , label: "상세정보보기"           , align: "center"   , width: 100   ,
                    formatter: function(cellValue, options, rowObject) {
                        return '<input type="button" class="btn btn-xs btn-outline btn-success" onclick="fatPrdtStndMng.regFatPrdtStndDetlPop(\'' + rowObject.fatJudgCd + '\',\'' + rowObject.fatpJudgCd + '\')" value="상세보기" data-toggle="modal" data-target="#fatPrdtStndDetlPopup" />';
                    }
                }
                
            ];
  
            $("#fatPrdt_list").jqGrid("GridUnload");
           	$("#fatPrdt_list").jqGrid($.extend(true, {}, commonEditGridOptions(),
            {
            	datatype : "local",
            	mtype    : 'post'  ,
                url      : '/svcStnd/fat/fatPrdtStndMng/searchFatPrdtList.ab',
                pager    : '#fatPrdt_pager_list',
				height   : 405     ,
                colModel : colModels,
                onPaging : function(data)
                {
                    onPagingCommon(data, this, function(resultMap)
                    {
                        $this.params.currentPage  = resultMap.currentPage;
                        $this.params.rowCount     = resultMap.rowCount;
                        $this.params.currentIndex = resultMap.currentIndex;
                        $this.searchFatPrdtList(false);
                    })
                },
                afterSaveCell : function (rowid , colId , val, e )
                {

                    if($("#fatPrdt_list").getRowData(rowid).crud != "C" && $("#fatPrdt_list").getRowData(rowid).crud != "D" )
                    {
                        $("#fatPrdt_list").setRowData(rowid, {crud:"U"});
                    }
                }
            }));
            resizeJqGridWidth("fatPrdt_list", "fatPrdt_list_wrapper");
        },
        searchFatPrdtList: function(isSearch)
        {
			let $this     = this;
            let params = $.extend(true, {}, $this.params);
			
            if ( isSearch )
            {
                params.currentPage = 1;
                params.currentIndex = 0;
            }
            
			$("#fatPrdt_list").setGridParam(
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
        regFatPrdtStndDetlPop: function(fatJudgCd, fatpJudgCd) {
			fatPrdtStndDetl.initPage(fatJudgCd, fatpJudgCd);
        },
		downloadExcel : function()
        {
			let $this = this;
			let params = $.extend(true, {}, $this.params);
			
			AjaxUtil.post(
{
				dataType : 'binary',
                url            : "/svcStnd/dgem/dgemStndMng/searchFatPrdtList/excel.ab",
                param     : params,
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
		resetSearchParam: function()
        {
			let $this = this;
			$this.params =
            {
                userId          : ''  ,
                fatJudgCd       : ''  , //비만_판정_코드
                fatpJudgCd      : ''  , //비만예측_판정_코드
                paging          : 'Y' ,
                totalCount      : 0   ,
                rowCount        : 30  ,
                currentPage     : 1   ,
                currentIndex    : 0
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