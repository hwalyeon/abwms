let nutrEatHist = new Vue({
    el: "#nutrEatHist", //스트레스_지수_이력
    data:
    {
    	params:
        {
            userId         : '' ,
            strsJudgDttmFr : '' , //스트레스_판정_일시(FROM)
            strsJudgDttmTo : '' , //스트레스_판정_일시(To)
            bDPer          : 'THIS_MONTH' , //기준_일자_기간
            stdtNo         : '' , //학생_번호
            stdtNm         : '' , //학생_명
            ageFr          : '' , //나이(FROM)
            ageTo          : '' , //나이(To)
            sexCd          : '' , //성별_코드
            guarNo         : '' , //보호자_번호
            guarNm         : '' , //보호자_명
            strsStatCd     : '' , //스트레스_상태_코드
            mindStrsStatCd : '' , //정신적_스트레스_상태_코드
            physStrsStatCd : '' , //신체적_스트레스_상태_코드
            strsCopeStatCd : '' , //스트레스_대처_상태_코드
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
            sexCdList          : [] , //성별_코드
            strsStatCdList     : [] , //스트레스_상태_코드
            mindStrsStatCdList : [] , //정신적_스트레스_상태_코드
            physStrsStatCdList : [] , //신체적_스트레스_상태_코드
            strsCopeStatCdList : [] , //스트레스_대처_상태_코드
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
            $this.searchNutrEatHistList(true);
        },
        initValue: function()
        {
            let $this = this;
            $this.userId = SessionUtil.getUserId();

            //기준_일자_기간 기본 값 세팅(이번 달)
            $this.code.bDPerList = CodeUtil.getPeriodDateList();
            const terms = getPeriodDate($this.params.bDPer);
            this.params.strsJudgDttmFr = terms.strDt;
            this.params.strsJudgDttmTo = terms.endDt;
        },
        initCodeList : function()
        {
            let $this = this;

            getCommonCodeList('SEX_CD'            , $this.code.sexCdList         ); //성별_코드
            getCommonCodeList('STRS_STAT_CD'      , $this.code.strsStatCdList    ); //스트레스_상태_코드
            getCommonCodeList('STRS_STAT_CD'      , $this.code.mindStrsStatCdList); //정신적_스트레스_상태_코드
            getCommonCodeList('STRS_STAT_CD'      , $this.code.physStrsStatCdList); //신체적_스트레스_상태_코드
            getCommonCodeList('STRS_COPE_STAT_CD' , $this.code.strsCopeStatCdList); //신체적_스트레스_상태_코드
        },
        initGrid: function()
        {
            let $this = this;
        	let colModels =
            [
                {name: "strsJudgDttm"     , index: "strsJudgDttm"     , label: "발생 일시" 	            ,  width: 50 , align: "center" },
                {name: "locNm"            , index: "locNm"            , label: "학교 명" 	            ,  width: 50 , align: "center" },
                {name: "stdtNo"           , index: "stdtNo"           , label: "학생 번호" 	            ,  width: 50 , align: "center" },
                {name: "stdtNm"           , index: "stdtNm"           , label: "학생 명" 	            ,  width: 50 , align: "center" },
                {name: "sexCdNm"          , index: "sexCdNm"          , label: "성별"	                ,  width: 50 , align: "center" },
                {name: "ageYy"            , index: "ageYy"            , label: "나이(년)"                , width: 50 , align: "center" },
                {name: "ageMm"            , index: "ageMm"            , label: "나이(개월)"              , width: 50 , align: "center" },
                {name: "strsStatCdNm"     , index: "strsStatCdNm"     , label: "스트레스 상태"           , width: 50 , align: "center" },
                {name: "mindStrsStatCdNm" , index: "mindStrsStatCdNm" , label: "정신적 상태"             , width: 50 , align: "center" },
                {name: "physStrsStatCdNm" , index: "physStrsStatCdNm" , label: "신체적 상태"             , width: 50 , align: "center" },
                {name: "strsCopeStatCd"   , index: "strsCopeStatCd"   , label: "대처 능력"               , width: 50 , align: "center" },
                {name: "telNo"            , index: "telNo"            , label: "학생(밴드)<br/>전화번호" , width: 50 , align: "center"  ,formatter:function(cellValue, options, rowObject){ return phoneFormatter(cellValue);}},
                {name: "guarNo"           , index: "guarNo"           , label: "보호자 번호"             , width: 50 , align: "center" },
                {name: "guarNm"           , index: "guarNm"           , label: "보호자 명"               , width: 50 , align: "center" },
                {name: "guarTelNo" 	      , index: "guarTelNo" 	      , label: "보호자<br/>전화번호"     , width: 50 , align: "center"  ,formatter:function(cellValue, options, rowObject){ return phoneFormatter(cellValue);}}
            ];
            $("#nutrEatHist_list").jqGrid("GridUnload");
           	$("#nutrEatHist_list").jqGrid($.extend(true, {}, commonGridOptions(),
            {
            	datatype : "local",
            	mtype    : 'post'  ,
                url      : '/oper/hc/nutrEatHist/nutrEatHistList.ab',
                pager    : '#nutrEatHist_pager_list',
				height   : 405     ,
                colModel : colModels,
                onPaging : function(data)
                {
                    onPagingCommon(data, this, function(resultMap)
                    {
                        $this.params.currentPage  = resultMap.currentPage;
                        $this.params.rowCount      = resultMap.rowCount;
                        $this.params.currentIndex = resultMap.currentIndex;
                        $this.searchNutrEatHistList(false);
                    })
                }
            }));
            resizeJqGridWidth("nutrEatHist_list", "nutrEatHist_list_wrapper");
        },
        //스트레스_지수_이력 리스트 조회
        searchNutrEatHistList: function(isSearch)
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
			$("#nutrEatHist_list").setGridParam(
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
        //스트레스_지수_이력 리스트 엑셀 다운로드
		downloadExcel : function()
        {
			let $this = this;
			let params = $.extend(true, {}, $this.params);

			AjaxUtil.post(
       {
				dataType : 'binary',
                url      : "/oper/hc/nutrEatHist/nutrEatHistList/excel.ab",
                param    : params,
                success  : function(response)
                {
                	saveFileLocal(response, 'strsHist.xls');
                },
                error    : function (response)
                {
                    Swal.alert([response, 'error']);
                }
            });
		},
        //기준_일자_기간_선택
        bDPerSelect: function()
        {
            let $this = this;
            const terms = getPeriodDate($this.params.bDPer);
            this.params.strsJudgDttmFr = terms.strDt;
            this.params.strsJudgDttmTo = terms.endDt;
        },
        //기준_일자_선택
        bDSelect: function()
        {
            let $this = this;
            $this.params.bDPer ='';
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
            if( ((WebUtil.isNotNull($this.params.strsJudgDttmFr)) && (WebUtil.isNull($this.params.strsJudgDttmTo))) || ((WebUtil.isNotNull($this.params.strsJudgDttmTo)) && (WebUtil.isNull($this.params.strsJudgDttmFr))) )
            {
                Swal.alert(['나머지 기준 일자를 선택하세요.', 'info']);
                return false;
            }
            if( ((WebUtil.isNotNull($this.params.strsJudgDttmFr) && WebUtil.isNotNull($this.params.strsJudgDttmTo)) && $this.params.strsJudgDttmFr > $this.params.strsJudgDttmTo) )
            {
                Swal.alert(['정확한 기준 일자를 선택하세요.', 'info']);
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
                strsJudgDttmFr : '' , //스트레스_판정_일시(FROM)
                strsJudgDttmTo : '' , //스트레스_판정_일시(To)
                bDPer          : 'THIS_MONTH' , //기준_일자_기간
                stdtNo         : '' , //학생_번호
                stdtNm         : '' , //학생_명
                ageFr          : '' , //나이(FROM)
                ageTo          : '' , //나이(To)
                sexCd          : '' , //성별_코드
                guarNo         : '' , //보호자_번호
                guarNm         : '' , //보호자_명
                strsStatCd     : '' , //스트레스_상태_코드
                mindStrsStatCd : '' , //정신적_스트레스_상태_코드
                physStrsStatCd : '' , //신체적_스트레스_상태_코드
                strsCopeStatCd : '' , //스트레스_대처_상태_코드
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