let eatHist = new Vue({
    el: "#eatHist", //섭취_이력
    data:
    {
    	params:
        {
            userId         : '' ,
            stndDtFr       : '' , //기준_일자(FROM)
            stndDtTo       : '' , //기준_일자(To)
            bDPer          : 'THIS_MONTH' , //기준_일자_기간
            stdtNo         : '' , //학생_번호
            stdtNm         : '' , //학생_명
            fmenuNm        : '' , //식단표_명
            mmelYn         : '' , //아침_여부
            amelYn         : '' , //점심_여부
            emelYn         : '' , //저녁_여부
            smelYn         : '' , //간식_여부
            mmelStarvYn    : '' , //아침_결식_여부
            guarNo         : '' , //보호자_번호
            guarNm         : '' , //보호자_명
            locNm          : '' , //학교(학원)명
    		paging         : 'Y',
    		totalCount     : 0  ,
            rowCount       : 30 ,
            currentPage    : 1  ,
            currentIndex   : 0
        },
        code:
        {
            bDPerList          : [] , //기준_일자_기간_리스트
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
            $this.searchEatHistList(true);
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

            //기준_일자_기간_리스트
            $this.code.bDPerList = CodeUtil.getPeriodDateList();
            const terms = getPeriodDate($this.params.bDPer);
            this.params.stndDtFr = terms.strDt;
            this.params.stndDtTo = terms.endDt;
        },
        initGrid: function()
        {
            let $this = this;
        	let colModels =
            [
                {name: "stndDt"       , index: "stndDt"        , label: "기준 일자" 	         ,  width: 50 , align: "center" },
                {name: "locNm"        , index: "locNm"         , label: "학교 명" 	             ,  width: 50 , align: "center" },
                {name: "stdtNo"       , index: "stdtNo"        , label: "학생 번호" 	         ,  width: 50 , align: "center" },
                {name: "stdtNm"       , index: "stdtNm"        , label: "학생 명" 	             ,  width: 50 , align: "center" },
                {name: "mmelFmenuSeq" , index: "mmelFmenuSeq"  , label: "아침 식단 번호"	         ,  width: 50 , align: "center" ,formatter: function(cellValue, options, rowObject) {
                        if(WebUtil.isNull(cellValue)) return '';
                        else return `<a data-toggle="modal" class="links" data-target="#eatHistDetlPopup" data-eatDetl data-placement="bottom" title="${cellValue}" data-fmenu-seq="${rowObject.mmelFmenuSeq}" data-guar-no="${rowObject.guarNo}">${cellValue}</a>`;}},
                {name: "mmelFmenuNm"  , index: "mmelFmenuNm"   , label: "아침 식단 명"            , width: 50 , align: "center"  ,formatter: function(cellValue, options, rowObject) {
                        if(WebUtil.isNull(cellValue)) return '';
                        else return `<a data-toggle="modal" class="links" data-target="#eatHistDetlPopup" data-eatDetl data-placement="bottom" title="${cellValue}" data-fmenu-seq="${rowObject.mmelFmenuSeq}" data-guar-no="${rowObject.guarNo}">${cellValue}</a>`;}},
                {name: "amelFmenuSeq" , index: "amelFmenuSeq"  , label: "점심 식단 번호"          , width: 50 , align: "center"  ,formatter: function(cellValue, options, rowObject) {
                        if(WebUtil.isNull(cellValue)) return '';
                        else return `<a data-toggle="modal" class="links" data-target="#eatHistDetlPopup" data-eatDetl data-placement="bottom" title="${cellValue}" data-fmenu-seq="${rowObject.amelFmenuSeq}" data-guar-no="${rowObject.guarNo}">${cellValue}</a>`;}},
                {name: "amelFmenuNm"  , index: "amelFmenuNm"   , label: "점심 식단 명"            , width: 50 , align: "center"  ,formatter: function(cellValue, options, rowObject) {
                        if(WebUtil.isNull(cellValue)) return '';
                        else return `<a data-toggle="modal" class="links" data-target="#eatHistDetlPopup" data-eatDetl data-placement="bottom" title="${cellValue}" data-fmenu-seq="${rowObject.amelFmenuSeq}" data-guar-no="${rowObject.guarNo}">${cellValue}</a>`;}},
                {name: "emelFmenuSeq" , index: "emelFmenuSeq"  , label: "저녁 식단 번호"          , width: 50 , align: "center"  ,formatter: function(cellValue, options, rowObject) {
                        if(WebUtil.isNull(cellValue)) return '';
                        else return `<a data-toggle="modal" class="links" data-target="#eatHistDetlPopup" data-eatDetl data-placement="bottom" title="${cellValue}" data-fmenu-seq="${rowObject.emelFmenuSeq}" data-guar-no="${rowObject.guarNo}">${cellValue}</a>`;}},
                {name: "emelFmenuNm"  , index: "emelFmenuNm"   , label: "저녁 식단 명"            , width: 50 , align: "center"  ,formatter: function(cellValue, options, rowObject) {
                        if(WebUtil.isNull(cellValue)) return '';
                        else return `<a data-toggle="modal" class="links" data-target="#eatHistDetlPopup" data-eatDetl data-placement="bottom" title="${cellValue}" data-fmenu-seq="${rowObject.emelFmenuSeq}" data-guar-no="${rowObject.guarNo}">${cellValue}</a>`;}},
                {name: "smelFmenuSeq" , index: "smelFmenuSeq"  , label: "간식 식단 번호"          , width: 50 , align: "center"  ,formatter: function(cellValue, options, rowObject) {
                        if(WebUtil.isNull(cellValue)) return '';
                        else return `<a data-toggle="modal" class="links" data-target="#eatHistDetlPopup" data-eatDetl data-placement="bottom" title="${cellValue}" data-fmenu-seq="${rowObject.smelFmenuSeq}" data-guar-no="${rowObject.guarNo}">${cellValue}</a>`;}},
                {name: "smelFmenuNm"  , index: "smelFmenuNm"   , label: "간식 식단 명"            , width: 50 , align: "center" ,formatter: function(cellValue, options, rowObject) {
                        if(WebUtil.isNull(cellValue)) return '';
                        else return `<a data-toggle="modal" class="links" data-target="#eatHistDetlPopup" data-eatDetl data-placement="bottom" title="${cellValue}" data-fmenu-seq="${rowObject.smelFmenuSeq}" data-guarNo-id="${rowObject.guarNo}">${cellValue}</a>`;}},
                {name: "telNo"        , index: "telNo"         , label: "학생(밴드)<br/>전화번호" , width: 50 , align: "center"  ,formatter:function(cellValue, options, rowObject){ return phoneFormatter(cellValue);}},
                {name: "guarNo"       , index: "guarNo"        , label: "보호자 번호"             , width: 50 , align: "center" },
                {name: "guarNm"       , index: "guarNm"        , label: "보호자 명"               , width: 50 , align: "center" },
                {name: "guarTelNo" 	  , index: "guarTelNo" 	   , label: "보호자<br/>전화번호"     , width: 50 , align: "center"  ,formatter:function(cellValue, options, rowObject){ return phoneFormatter(cellValue);}}
            ];
            $("#eatHist_list").jqGrid("GridUnload");
           	$("#eatHist_list").jqGrid($.extend(true, {}, commonGridOptions(),
            {
            	datatype : "local",
            	mtype    : 'post'  ,
                url      : '/oper/hc/eatHist/searchEatHistList.ab',
                pager    : '#eatHist_pager_list',
				height   : 405     ,
                colModel : colModels,
                onPaging : function(data)
                {
                    onPagingCommon(data, this, function(resultMap)
                    {
                        $this.params.currentPage  = resultMap.currentPage;
                        $this.params.rowCount     = resultMap.rowCount;
                        $this.params.currentIndex = resultMap.currentIndex;
                        $this.searchEatHistList(false);
                    })
                },
                gridComplete: function ()
                {
                    let grid = this;

                    $(grid).tableRowSpan(["stdtNo", "stdtNm", "locNm", "telNo"], "stdtNo");
                    $(grid).tableRowSpan(["guarNo", "guarNm", "guarTelNo"], "guarNo");

                    //섭취_상세
                    $("#eatHist_list").find('A.links[data-eatDetl]').on('click', function(e) {
                        eatHist.regEatHistDetlPopup($(e.target).data('fmenu-seq'),$(e.target).data('guar-no'))
                    });
                }
            }));
            resizeJqGridWidth("eatHist_list", "eatHist_list_wrapper");
        },
        //섭취_이력 리스트 조회
        searchEatHistList: function(isSearch)
        {
			let $this     = this;
            let params = $.extend(true, {}, $this.params);

            //유효성_검증
            if ( !this.isValid() ) {
                return false;
            }
            if ( isSearch )
            {
                params.currentPage = 1;
                params.currentIndex = 0;
            }
			$("#eatHist_list").setGridParam(
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
        //섭취_이력 리스트 엑셀 다운로드
		downloadExcel : function()
        {
			let $this = this;
			let params = $.extend(true, {}, $this.params);

			AjaxUtil.post(
       {
				dataType : 'binary',
                url      : "/oper/hc/eatHist/searchEatHistList/excel.ab",
                param    : params,
                success  : function(response)
                {
                	saveFileLocal(response, 'eatHist.xls');
                },
                error    : function (response)
                {
                    Swal.alert([response, 'error']);
                }
            });
		},
        //기준_일자 선택
        setDatepicker : function() {
            let $this = this;
            if($this.params.bDPer!=='')
            {$this.params.bDPer = '' ;}

            $('#stndDtFrPicker').datepicker({
                todayBtn: "linked",
                keyboardNavigation: false,
                forceParse: false,
                calendarWeeks: true,
                autoclose: true,
                todayHighlight: true,
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
        },
        //기준_일자_기간_선택
        bDPerSelect: function()
        {
            let $this = this;
            const terms = getPeriodDate($this.params.bDPer);
            this.params.stndDtFr = terms.strDt;
            this.params.stndDtTo = terms.endDt;
        },
        //유효성_검증
        isValid: function() {

            let $this = this;

            if( ((WebUtil.isNotNull($this.params.stndDtFr)) && (WebUtil.isNull($this.params.stndDtTo))) || ((WebUtil.isNotNull($this.params.stndDtTo)) && (WebUtil.isNull($this.params.stndDtFr))) )
            {
                Swal.alert(['나머지 기준 일자를 선택하세요.', 'info']);
                return false;
            }
            if( ((WebUtil.isNotNull($this.params.stndDtFr) && WebUtil.isNotNull($this.params.stndDtTo)) && $this.params.stndDtFr > $this.params.stndDtTo) )
            {
                Swal.alert(['정확한 기준 일자를 선택하세요.', 'info']);
                return false;
            }
            return true;
        },
        mmelStarvYnCk: function(){
          let $this = this;

           $this.params.mmelYn      = 'N';
        },
        mmelYnCk: function(){
          let $this = this;

           $this.params.mmelStarvYn      = '';
        },
        //섭취_이력 상세
        regEatHistDetlPopup: function(fmenuSeq, guarNo) {
            eatHistDetl.initPage(fmenuSeq, guarNo);
        },
		resetSearchParam: function()
        {
			let $this = this;
			$this.params =
            {
                userId         : '' ,
                stndDtFr       : '' , //기준_일자(FROM)
                stndDtTo       : '' , //기준_일자(To)
                bDPer          : 'THIS_MONTH' , //기준_일자_기간
                stdtNo         : '' , //학생_번호
                stdtNm         : '' , //학생_명
                fmenuNm        : '' , //식단표_명
                mmelYn         : '' , //아침_여부
                amelYn         : '' , //점심_여부
                emelYn         : '' , //저녁_여부
                smelYn         : '' , //간식_여부
                mmelStarvYn    : '' , //아침_결식_여부
                guarNo         : '' , //보호자_번호
                guarNm         : '' , //보호자_명
                locNm          : '' , //학교(학원)명
                paging         : 'Y',
                totalCount     : 0  ,
                rowCount       : 30 ,
                currentPage    : 1  ,
                currentIndex   : 0
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