let strsHist = new Vue({
    el: "#strsHist", //스트레스_지수_이력
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
            sexCdList          : [] , //성별_코드_리스트
            strsStatCdList     : [] , //스트레스_상태_코드_리스트
            mindStrsStatCdList : [] , //정신적_스트레스_상태_코드_리스트
            physStrsStatCdList : [] , //신체적_스트레스_상태_코드_리스트
            strsCopeStatCdList : [] , //스트레스_대처_상태_코드_리스트
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
            //$this.searchStrsHistList(true);
            $this.setDatepicker();
        },
        initValue: function()
        {
            let $this = this;
            $this.userId = SessionUtil.getUserId();

            //기준_일자_기간_리스트
            $this.code.bDPerList = CodeUtil.getPeriodDateList();
            const terms = getPeriodDate($this.params.bDPer);
            this.params.strsJudgDttmFr = terms.strDt;
            this.params.strsJudgDttmTo = terms.endDt;
        },
        initCodeList : function()
        {
            let $this = this;

            getCommonCodeList('SEX_CD'            , $this.code.sexCdList         ); //성별_코드_리스트
            getCommonCodeList('STRS_STAT_CD'      , $this.code.strsStatCdList    ); //스트레스_상태_코드_리스트
            getCommonCodeList('STRS_STAT_CD'      , $this.code.mindStrsStatCdList); //정신적_스트레스_상태_코드_리스트
            getCommonCodeList('STRS_STAT_CD'      , $this.code.physStrsStatCdList); //신체적_스트레스_상태_코드_리스트
            getCommonCodeList('STRS_COPE_STAT_CD' , $this.code.strsCopeStatCdList); //신체적_스트레스_상태_코드_리스트
        },
        initGrid: function()
        {
            let $this = this;
        	let colModels =
            [
                {name: "strsJudgDttm"     , index: "strsJudgDttm"     , label: "발생 일시" 	                 , width: 120 , align: "center" ,fixed:true ,formatter:function(cellValue, options, rowObject){ return formatTimestamp(cellValue);}},
                {name: "stdtNo"           , index: "stdtNo"           , label: "학생번호" 	                 , width:  60 , align: "center" ,fixed:true},
                {name: "stdtNm"           , index: "stdtNm"           , label: "학생명" 	                 , width:  80 , align: "center" ,fixed:true},
                {name: "sexCdNm"          , index: "sexCdNm"          , label: "성별"	                     , width:  60 , align: "center" ,fixed:true},
                {name: "ageYy"            , index: "ageYy"            , label: "나이<br>(년)"                , width:  60 , align: "center" ,fixed:true},
                {name: "ageMm"            , index: "ageMm"            , label: "나이<br>(개월)"              , width:  60 , align: "center" ,fixed:true},
                {name: "strsIdx"          , index: "strsIdx"          , label: "스트레스지수"                , width:  80 , align: "center" ,fixed:true},
                {name: "strsStatCdNm"     , index: "strsStatCdNm"     , label: "스트레스 상태"               , width:  80 , align: "center" ,fixed:true},
                {name: "mindStrsPnt"      , index: "mindStrsPnt"      , label: "스트레스 점수<br>(정신적)"   , width:  80 , align: "center" ,fixed:true},
                {name: "mindStrsStatCdNm" , index: "mindStrsStatCdNm" , label: "스트레스 상태<br>(정신적)"   , width:  80 , align: "center" ,fixed:true},
                {name: "physStrsPnt"      , index: "physStrsPnt"      , label: "스트레스 점수<br>(신체적)"   , width:  80 , align: "center" ,fixed:true},
                {name: "physStrsStatCdNm" , index: "physStrsStatCdNm" , label: "스트레스 상태<br>(신체적)"   , width:  80 , align: "center" ,fixed:true},
                {name: "strsCopePnt"      , index: "strsCopePnt"      , label: "스트레스 점수<br>(대처점수)" , width:  80 , align: "center" ,fixed:true},
                {name: "strsCopeStatCd"   , index: "strsCopeStatCd"   , label: "스트레스<br>대처능력"        , width:  80 , align: "center" ,fixed:true},
                {name: "hbitMdan"         , index: "hbitMdan"         , label: "심박수<br>중간값"            , width:  80 , align: "center" ,fixed:true},
                {name: "avgHbitCnt"       , index: "avgHbitCnt"       , label: "평균 심박수<br>(분당)"       , width:  70 , align: "center" ,fixed:true},
                {name: "abnmHbitCnt"      , index: "abnmHbitCnt"      , label: "이상<br>심박수"              , width:  80 , align: "center" ,fixed:true},
                {name: "judgNo"           , index: "judgNo"           , label: "판정번호"                    , width:  80 , align: "center" ,fixed:true},
                {name: "strsProcStatNm"   , index: "strsProcStatNm"   , label: "판정상태"                    , width:  80 , align: "center" ,fixed:true},
                {name: "locNm"            , index: "locNm"            , label: "학교명" 	                 , width: 120 , align: "left"   ,fixed:true},
                {name: "guarNo"           , index: "guarNo"           , label: "보호자 번호"                 , width:  80 , align: "center" ,fixed:true},
                {name: "guarNm"           , index: "guarNm"           , label: "보호자 명"                   , width:  80 , align: "center" ,fixed:true},
                {name: "guarTelNo" 	      , index: "guarTelNo" 	      , label: "보호자<br/>전화번호"         , width:  80 , align: "center" ,fixed:true ,formatter:function(cellValue, options, rowObject){ return phoneFormatter(cellValue);}},
                {name: "telNo"            , index: "telNo"            , label: "학생(밴드)<br/>전화번호"     , width:  80 , align: "center" ,fixed:true ,formatter:function(cellValue, options, rowObject){ return phoneFormatter(cellValue);}}
            ];
            $("#strsHist_list").jqGrid("GridUnload");
           	$("#strsHist_list").jqGrid($.extend(true, {}, commonGridOptions(),
            {
            	datatype : "local",
            	mtype    : 'post'  ,
                url      : '/oper/hc/strsHist/strsHistList.ab',
                pager    : '#strsHist_pager_list',
				height   : 316     ,
				autowidth:false,
                colModel : colModels,
                onPaging : function(data)
                {
                    onPagingCommon(data, this, function(resultMap)
                    {
                        $this.params.currentPage  = resultMap.currentPage;
                        $this.params.rowCount      = resultMap.rowCount;
                        $this.params.currentIndex = resultMap.currentIndex;
                        $this.searchStrsHistList(false);
                    })
                },
                gridComplete: function () {
                    let grid = this;

//                    $(grid).tableRowSpan(["strsJudgDttm","locNm","stdtNo","stdtNm","sexCdNm", "ageYy","ageMm","telNo"], "stdtNo");
                }
            }));
            resizeJqGridWidth("strsHist_list", "strsHist_list_wrapper");
        },
        // 조회검증
        checkSearch: function()
        {
        	let $this = this;
        	$this.searchStrsHistList(true);
        },
        //스트레스_지수_이력 리스트 조회
        searchStrsHistList: function(isSearch)
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
			$("#strsHist_list").setGridParam(
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
                url      : "/oper/hc/strsHist/strsHistList/excel.ab",
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
        //기준_일자 선택
        setDatepicker : function() {
            let $this = this;
            if($this.params.bDPer!=='')
            {$this.params.bDPer = '' ;}

            $('#strsJudgDttmFrPicker').datepicker({
                todayBtn: "linked",
                keyboardNavigation: false,
                forceParse: false,
                calendarWeeks: true,
                autoclose: true,
                todayHighlight: true,
            }).on("changeDate", function() {
                $this.params.strsJudgDttmFr = $('#strsJudgDttmFr').val();
            });
            $('#strsJudgDttmToPicker').datepicker({
                todayBtn: "linked",
                keyboardNavigation: false,
                forceParse: false,
                calendarWeeks: true,
                autoclose: true,
                todayHighlight: true,
            }).on("changeDate", function() {
                $this.params.strsJudgDttmTo = $('#strsJudgDttmTo').val();
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
        //유효성_검증
        isValid: function() {

            let $this = this;

            if ((WebUtil.isNotNull($this.params.ageFr)) && (WebUtil.isNull($this.params.ageTo)))
            {
                $this.params.ageTo = 18;
                return false;
            }
            if ((WebUtil.isNotNull($this.params.ageTo)) && (WebUtil.isNull($this.params.ageFr)))
            {
                $this.params.ageFr = 4;
                return false;
            }
            if ((WebUtil.isNotNull($this.params.ageFr) && WebUtil.isNotNull($this.params.ageTo)) &&parseInt($this.params.ageFr) > parseInt($this.params.ageTo)){
                Swal.alert(['정확한 나이 범위를 입력하세요.', 'info']);
                return false;
            }
            if  (WebUtil.isNull($this.params.strsJudgDttmFr))
            {
                Swal.alert(['기준일자(FROM)는 반드시 입력해야 합니다.', 'info']);
                document.getElementById("strsJudgDttmFr").focus();
                return false;
            }
            if  (WebUtil.isNull($this.params.strsJudgDttmTo))
            {
                Swal.alert(['기준일자(TO)는 반드시 입력해야 합니다.', 'info']);
                document.getElementById("strsJudgDttmTo").focus();
                return false;
            }
            return true;
        },
        //stdtInfoDetl 화면에서 팝업 호출 시 param 값 세팅
        setParam: function(param) {
            let $this =this;

            let params;
            if (WebUtil.isNull(param)) {
                params = WebUtil.getStorageData('window:stdtInfoDetl:params', true);
            } else {
                params = param;
            }

            WebUtil.removeStorageData('window:stdtInfoDetl:params');

            if(params != null && WebUtil.isNotNull(params.stdtNo)){
                $this.params.stdtNo = params.stdtNo;
            }
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
            $this.initValue();
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
        $(document).ready(function() {
            self.initialize();
            top.index.$on('GET_PARAM', function(params) {
                self.setParam(params);
                self.searchStrsHistList(true);
            });
            self.setParam();
            self.searchStrsHistList(true);
        });
    }
});