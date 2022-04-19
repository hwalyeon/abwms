let qnaMng = new Vue({
    el: "#qnaMng", //질의응담_기본
    data:
    {
    	params:
        {
            userId       : ''  ,
            qnaNo        : ''  , //질의응답_번호
            qustGuarNo   : ''  , //지문_보호자_번호
            qustDtFr     : ''  , //질문_일자(FROM)
            qustDtTo     : ''  , //질문_일자(To)
            bDPer        : 'THIS_MONTH'  , //질문_일자_기간
            qustCntn     : ''  , //질문_내용
            ansDtFr      : ''  , //답변_일자(FROM)
            ansDtTo      : ''  , //답변_일자(To)
            bDPerAns     : 'THIS_MONTH'  , //답변_일자_기간
            ansCntn      : ''  , //답변_내용
    		paging       : 'Y' ,
    		totalCount   : 0   ,
            rowCount     : 30  ,
            currentPage  : 1   ,
            currentIndex : 0
        },
        code:
        {
            bDPerList      : [] , //질문_일자_기간_리스트
            bDPerAnsList   : [] , //답변_일자_기간_리스트
        },
	},
    methods:
    {
        initialize: function()
        {
        	let $this = this;

            $this.initValue();
        	$this.initCodeList();
/*        	$this.initGrid();
            $this.searchDgemList(true);*/
            $this.setDatepicker();
        },
        initValue: function()
        {
            let $this = this;
            $this.userId = SessionUtil.getUserId();
        },
        initCodeList : function()
        {
            let $this = this;
            $this.code.bDPerList    = CodeUtil.getPeriodDateList(); //질문_일자_기간_리스트
            //질문_일자_기간_리스트 기본 값 세팅
            const termsQust = getPeriodDate($this.params.bDPer);
            this.params.qustDtFr = termsQust.strDt;
            this.params.qustDtTo = termsQust.endDt;

            $this.code.bDPerAnsList = CodeUtil.getPeriodDateList(); //답변_일자_기간_리스트
            //답변_일자_기간_리스트 기본 값 세팅
            const termsAns = getPeriodDate($this.params.bDPerAns);
            this.params.ansDtFr = termsAns.strDt;
            this.params.ansDtTo = termsAns.endDt;

        },
        initGrid: function()
        {
        	let $this = this;
        	let colModels =
            [
                {name: "crud"           , index: "crud"           , label: "crud"         , hidden: true    },
                {name: "qnaNo"          , index: "qnaNo"          , label: "QnA 번호"     , align: "center"  },
                {name: "qustDt"         , index: "qustDt"         , label: "질문 일자" 	  , align: "center" },
                {name: "qustGuarNo"     , index: "qustGuarNo"     , label: "질문자 번호"   , align: "center" },
                {name: "guarNm"         , index: "guarNm"         , label: "질문자 명" 	  , align: "center" },
                {name: "qustTitl"       , index: "qustTitl"       , label: "질문 제목" 	  , align: "left"   },
                {name: "qustCntn"       , index: "qustCntn"       , label: "질문 내용"     , align: "left"   },
                {name: "ansDt"          , index: "ansDt"          , label: "답변 일자" 	  , align: "center" },
                {name: "ansTm"          , index: "ansTm"          , label: "답변 시각" 	  , align: "center" },
                {name: "ansCntn"        , index: "ansCntn"        , label: "답변 내용" 	  , align: "left"   },
                {name: "ansUserId"      , index: "ansUserId"      , label: "답변자ID" 	  , align: "left"   },
                {name: "regDt"          , index: "regDt"          , label: "등록일자"      , align: "center" , formatter: function(cellValue, options, rowObject) { return formatDate(cellValue);}  },
                {name: "regTm"          , index: "regTm"          , label: "등록시각"      , align: "center" , formatter: function(cellValue, options, rowObject) { return formatTime(cellValue);}  },
                {name: "regUserId"      , index: "regUserId"      , label: "등록사용자ID"  , align: "center" },
                {name: "uptDt"          , index: "uptDt"          , label: "수정일자"      , align: "center" , formatter: function(cellValue, options, rowObject) { return formatDate(cellValue);}  },
                {name: "uptTm"          , index: "uptTm"          , label: "수정시각"      , align: "center" , formatter: function(cellValue, options, rowObject) { return formatTime(cellValue);}  },
                {name: "uptUserId"      , index: "uptUserId"      , label: "수정사용자ID"  , align: "center" }
            ];
  
            $("#qna_list").jqGrid("GridUnload");
           	$("#qna_list").jqGrid($.extend(true, {}, commonGridOptions(),
            {
            	datatype : "local",
            	mtype    : 'post'  ,
                url      : '/cmon/blbd/qnaMng/searchQnaList.ab',
                pager    : '#qna_pager_list',
				height   : 405     ,
                colModel : colModels,
                onPaging : function(data)
                {
                    onPagingCommon(data, this, function(resultMap)
                    {
                        $this.params.currentPage  = resultMap.currentPage;
                        $this.params.rowCount     = resultMap.rowCount;
                        $this.params.currentIndex = resultMap.currentIndex;
                        $this.searchQnaList(false);
                    })
                },
                onSelectRow: function(rowId, status, e)
                {
                    let $this = this;
                    let item  = $('#qna_list').jqGrid('getRowData', rowId);
                    //질의응답 상세 팝업 호출 함수 호출
                    $this.regQnaDetlPop(item.qnaNo);

                },
            }));
            resizeJqGridWidth("qna_list", "qna_list_wrapper");
        },
        searchQnaList: function(isSearch)
        {
			let $this     = this;
            let params = $.extend(true, {}, $this.params);
			
            if ( isSearch )
            {
                params.currentPage = 1;
                params.currentIndex = 0;
            }
			$("#qna_list").setGridParam(
			{
                datatype : "json",
                postData : JSON.stringify(params),
                page     : 1,
                loadComplete: function (response)
                {
                    if ( response.rtnData.result == 0 )
                    {
                        Swal.alert(['조회할 내용이 없습니다.', "info"]);
                    }
                }
            }).trigger("reloadGrid");
		},
        //질의응답 상세 팝업 호출
		regQnaDetlPop: function(qnaNo)
        {
			qnaDetl.initPage(qnaNo);
        },

        //기준_일자 선택
        setDatepicker : function() {
            let $this = this;

            if($this.params.bDPer!=='')
              {$this.params.bDPer = '' ;}

            if($this.params.bDPerAns!=='')
              {$this.params.bDPerAns = '' ;}
            //질문_일자_From
            $('#qustDtFrPicker').datepicker({
                todayBtn: "linked",
                keyboardNavigation: false,
                forceParse: false,
                calendarWeeks: true,
                autoclose: true,
                todayHighlight: true,
            }).on("changeDate", function() {
                $this.params.qustDtFr = $('#qustDtFr').val();
            });
            //질문_일자_To
            $('#qustDtToPicker').datepicker({
                todayBtn: "linked",
                keyboardNavigation: false,
                forceParse: false,
                calendarWeeks: true,
                autoclose: true,
                todayHighlight: true,
            }).on("changeDate", function() {
                $this.params.qustDtTo = $('#qustDtTo').val();
            });
            //답변_일자_From
            $('#ansDtFrPicker').datepicker({
                todayBtn: "linked",
                keyboardNavigation: false,
                forceParse: false,
                calendarWeeks: true,
                autoclose: true,
                todayHighlight: true,
            }).on("changeDate", function() {
                $this.params.ansDtFr = $('#ansDtFr').val();
            });
            //답변_일자_To
            $('#ansDtToPicker').datepicker({
                todayBtn: "linked",
                keyboardNavigation: false,
                forceParse: false,
                calendarWeeks: true,
                autoclose: true,
                todayHighlight: true,
            }).on("changeDate", function() {
                $this.params.ansDtTo = $('#ansDtTo').val();
            });
        },

        //질문_일자_기간_선택
        bDPerSelect: function() {
            let $this = this;
            const termsQust = getPeriodDate($this.params.bDPer);
            this.params.qustDtFr = termsQust.strDt;
            this.params.qustDtTo = termsQust.endDt;
        },

        //답변_일자_기간_선택
        bDPerAnsSelect: function() {
            let $this = this;
            const termsAns = getPeriodDate($this.params.bDPerAns);
            this.params.ansDtFr = termsAns.strDt;
            this.params.anstDtTo = termsAns.endDt;
        },

        downloadExcel : function()
        {
			let $this = this;
			let params = $.extend(true, {}, $this.params);
			
			AjaxUtil.post(
{
				dataType : 'binary',
                url      : "/cmon/blbd/qnaMng/searchQnaList/excel.ab",
                param    : params,
                success  : function(response)
                {
                	saveFileLocal(response, 'qnaMng.xls');
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
                userId       : ''  ,
                qnaNo        : ''  , //질의응답_번호
                qustGuarNo   : ''  , //지문_보호자_번호
                qustDtFr     : ''  , //질문_일자(FROM)
                qustDtTo     : ''  , //질문_일자(To)
                bDPer        : 'THIS_MONTH'  , //질문_일자_기간
                qustCntn     : ''  , //질문_내용
                ansDtFr      : ''  , //답변_일자(FROM)
                ansDtTo      : ''  , //답변_일자(To)
                bDPerAns     : 'THIS_MONTH'  , //답변_일자_기간
                ansCntn      : ''  , //답변_내용
                paging       : 'Y' ,
                totalCount   : 0   ,
                rowCount     : 30  ,
                currentPage  : 1   ,
                currentIndex : 0
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