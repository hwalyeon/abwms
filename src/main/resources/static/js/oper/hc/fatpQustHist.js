let fatpQustHist = new Vue({
    el: "#fatpQustHist", //비만예측설문조사_이력
    data:
    {
    	params:
        {
            userId         : '' ,
            stndDtFr       : '' , //기준_일자(FROM)
            stndDtTo       : '' , //기준_일자(FROM)
            bDPer          : 'THIS_MONTH' , //기준_일자_기간
            stdtNo         : '' , //학생_번호
            stdtNm         : '' , //학생_명
            ageFr          : '' , //나이(FROM)
            ageTo          : '' , //나이(To)
            sexCd          : '' , //성별_코드
            fatpIdxFr      : '' , //비만예측_지수_Fr
            fatpIdxTo      : '' , //비만예측_지수_To
    		paging         : 'Y',
    		totalCount     : 0  ,
            rowCount       : 30 ,
            currentPage    : 1  ,
            currentIndex   : 0
        },
        code:
        {
            bDPerList      : [] , //기준_일자_기간_리스트
            sexCdList      : [] , //성별_코드_리스트
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
            $this.searchFatpQustHistList(true);
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

            getCommonCodeList('SEX_CD', $this.code.sexCdList); //성별_코드_리스트
        },
        initGrid: function()
        {
            let $this = this;
        	let colModels =
            [
                {name: "stndDt"       , index: "stndDt"       , label: "기준 일자" 	                            , align: "center"    },
                {name: "stdtNo"       , index: "stdtNo"       , label: "학생 번호" 	                            , align: "center"    },
                {name: "stdtNm"       , index: "stdtNm"       , label: "학생 명" 	                            , align: "center"    },
                {name: "sexCd"        , index: "sexCd"        , label: "성별"	                                , align: "center"    },
                {name: "ageYcnt"      , index: "ageYcnt"      , label: "나이(년)"                               , align: "center"   },
                {name: "qustNo1"      , index: "qustNo1"     , label: "주 평균 </br>라면 섭취 횟수"              , align: "center"   , width: 250 },
                {name: "qustNo2"      , index: "qustNo2"     , label: "주 평균</br>음료수 섭취 횟수"             , align: "center"   , width: 250 },
                {name: "qustNo3"      , index: "qustNo3"     , label: "주 평균</br>패스트푸드 섭취 횟수"         , align: "center"   , width: 250 },
                {name: "qustNo4"      , index: "qustNo4"     , label: "주 평균</br>육류 섭취 횟수"               , align: "center"  , width: 250  },
                {name: "qustNo5"      , index: "qustNo5"     , label: "주 평균</br>유제품 섭취 횟수"             , align: "center"   , width: 250 },
                {name: "qustNo6"      , index: "qustNo6"     , label: "주 평균</br>과일 섭취 횟수"               , align: "center"   , width: 250 },
                {name: "qustNo7"      , index: "qustNo7"     , label: "주 평균</br>야채 (김치 제외) 섭취 횟수"   , align: "center" , width: 250 },
                {name: "qustNo8"      , index: "qustNo8"     , label: "주 평균</br>아침 결식 횟수"               , align: "center" , width: 250 },
                {name: "fatpBmiVal"   , index: "fatpBmiVal"   , label: "비만 예측 BMI"                          , align: "center" },
                {name: "fatpIdx"      , index: "fatpIdx"      , label: "비만 예측지수"                          , align: "center"  },
                {name: "fatpJudgCd"   , index: "fatpJudgCd"   , label: "비만 예측</br>판정코드"                 , align: "center"  },
                {name: "fatpJudgDesc" , index: "fatpJudgDesc" , label: "비만 예측</br>판정설명"                 , align: "center"  }
            ];
            $("#fatpQustHist_list").jqGrid("GridUnload");
           	$("#fatpQustHist_list").jqGrid($.extend(true, {}, commonGridOptions(),
            {
            	datatype : "local",
            	mtype    : 'post'  ,
                url      : '/oper/hc/fatpQustHist/searchFatpQustHistList.ab',
                pager    : '#fatpQustHist_pager_list',
				height   : 465     ,
                colModel : colModels,
                onPaging : function(data)
                {
                    onPagingCommon(data, this, function(resultMap)
                    {
                        $this.params.currentPage  = resultMap.currentPage;
                        $this.params.rowCount      = resultMap.rowCount;
                        $this.params.currentIndex = resultMap.currentIndex;
                        $this.searchFatpQustHistList(false);
                    })
                },
                gridComplete: function () {
                    let grid = this;
                    $(grid).tableRowSpan(["stdtNo", "stdtNm", "sexCd","ageYcnt"], "stdtNo");
                }
            }));
            resizeJqGridWidth("fatpQustHist_list", "fatpQustHist_list_wrapper");
        },
        //비만예측설문조사_이력 리스트 조회
        searchFatpQustHistList: function(isSearch)
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
			$("#fatpQustHist_list").setGridParam(
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
        //비만예측설문조사_이력 리스트 엑셀 다운로드
		downloadExcel : function()
        {
			let $this = this;
			let params = $.extend(true, {}, $this.params);

			AjaxUtil.post(
       {
				dataType : 'binary',
                url      : "/oper/hc/fatpQustHist/searchFatpQustHistList/excel.ab",
                param    : params,
                success  : function(response)
                {
                	saveFileLocal(response, 'fatpQustHist.xls');
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

            if( ((WebUtil.isNotNull($this.params.ageFr)) && (WebUtil.isNull($this.params.ageTo))) || ((WebUtil.isNotNull($this.params.ageTo)) && (WebUtil.isNull($this.params.ageFr))) )
            {
                Swal.alert(['나머지 나이 범위를 입력하세요.', 'info']);
                return false;
            }
            if ((WebUtil.isNotNull($this.params.ageFr) && WebUtil.isNotNull($this.params.ageTo)) &&parseInt($this.params.ageFr) > parseInt($this.params.ageTo)){
                Swal.alert(['정확한 나이 범위를 입력하세요.', 'info']);
                return false;
            }
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
            if( ((WebUtil.isNotNull($this.params.fatpIdxFr)) && (WebUtil.isNull($this.params.fatpIdxTo))) || ((WebUtil.isNotNull($this.params.fatpIdxTo)) && (WebUtil.isNull($this.params.fatpIdxFr))) )
            {
                Swal.alert(['나머지 비만예측지수를 선택하세요.', 'info']);
                return false;
            }
            if( ((WebUtil.isNotNull($this.params.fatpIdxFr) && WebUtil.isNotNull($this.params.fatpIdxTo)) && $this.params.fatpIdxFr > $this.params.fatpIdxTo) )
            {
                Swal.alert(['정확한 비만예측지수를 입력하세요.', 'info']);
                return false;
            }
            return true;
        },
		resetSearchParam: function()
        {
			let $this = this;
			$this.params =
            {
                userId         : '' ,
                stndDtFr       : '' , //성장비만지수_일자(FROM)
                stndDtTo       : '' , //성장비만지수_일자(To)
                bDPer          : 'THIS_MONTH' , //기준_일자_기간
                stdtNo         : '' , //학생_번호
                stdtNm         : '' , //학생_명
                ageFr          : '' , //나이(FROM)
                ageTo          : '' , //나이(To)
                sexCd          : '' , //성별_코드
                guarNo         : '' , //보호자_번호
                guarNm         : '' , //보호자_명
                growJudgCd     : '' , //성장_판정_코드
                fatJudgCd      : '' , //비만_판정_코드
                fatpJudgCd     : '' , //비만_예측_판정_코드
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