let gfixHist = new Vue({
    el: "#gfixHist", //성장/비만_지수_이력
    data:
    {
    	params:
        {
            userId         : '' ,
            gfixDtFr       : '' , //성장비만지수_일자(FROM)
            gfixDtTo       : '' , //성장비만지수_일자(To)
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
        },
        code:
        {
            bDPerList      : [] , //기준_일자_기간_리스트
            sexCdList      : [] , //성별_코드_리스트
            growJudgCdList : [] , //성장_판정__코드 리스트
            fatJudgCdList  : [] , //비만_판정_코드_리스트
            fatEstmCdList  : [] , //비만_예측_코드_리스트
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
            //$this.searchGfixHistList(true);
            $this.setDatepicker();
            document.getElementById("stdtNo").focus();
        },
        initValue: function()
        {
            let $this = this;
            $this.userId = SessionUtil.getUserId();

            //기준_일자_기간 기본 값 세팅(이번 달)
            $this.code.bDPerList = CodeUtil.getPeriodDateList();
            const terms = getPeriodDate($this.params.bDPer);
            this.params.gfixDtFr = terms.strDt;
            this.params.gfixDtTo = terms.endDt;
        },
        initCodeList : function()
        {
            let $this = this;

            getCommonCodeList('SEX_CD'       , $this.code.sexCdList      ); //성별_코드_리스트
            getCommonCodeList('GROW_JUDG_CD' , $this.code.growJudgCdList ); //성장_판정__코드 리스트
            getCommonCodeList('FAT_JUDG_CD'  , $this.code.fatJudgCdList  ); //비만_판정_코드_리스트
            getCommonCodeList('FAT_ESTM_CD'  , $this.code.fatEstmCdList  ); //비만_예측_판정_코드_리스트
        },
        initGrid: function()
        {
            let $this = this;
        	let colModels =
            [
                {name: "gfixDt"       , index: "gfixDt"       , label: "기준일자" 	             , width: 100 , align: "center" ,formatter:function(cellValue, options, rowObject){ return formatDate(cellValue);},fixed:true},
                {name: "locNm"        , index: "locNm"        , label: "학교명" 	             , width: 120 , align: "left"   ,fixed:true},
                {name: "stdtNo"       , index: "stdtNo"       , label: "학생번호" 	             , width:  60 , align: "center" ,fixed:true},
                {name: "stdtNm"       , index: "stdtNm"       , label: "학생명" 	             , width: 100 , align: "center" ,fixed:true},
                {name: "sexCdNm"      , index: "sexCdNm"      , label: "성별"	                 , width:  60 , align: "center" ,fixed:true},
                {name: "ageYcnt"      , index: "ageYcnt"      , label: "나이(년)"                , width:  80 , align: "center" ,fixed:true,formatter:function(cellValue){ if (cellValue==null || cellValue=='') return '-'; else return cellValue+" 세";}},
                {name: "ageMcnt"      , index: "ageMcnt"      , label: "나이(개월)"              , width:  80 , align: "center" ,fixed:true,formatter:function(cellValue){ if (cellValue==null || cellValue=='') return '-'; else return cellValue+" 개월";}},
                {name: "hghtVal"      , index: "hghtVal"      , label: "키"                      , width:  80 , align: "center" ,fixed:true,formatter:function(cellValue){ if (cellValue==null || cellValue=='') return '-'; else return cellValue+" ㎝";}},
                {name: "wghtVal"      , index: "wghtVal"      , label: "몸무게"                  , width:  80 , align: "center" ,fixed:true,formatter:function(cellValue){ if (cellValue==null || cellValue=='') return '-'; else return cellValue+" ㎏";}},
                {name: "calEatQty"    , index: "calEatQty"    , label: "칼로리 섭취/일"          , width:  80 , align: "right"  ,fixed:true,formatter:function(cellValue){ if (cellValue==null || cellValue=='') return '-'; else return cellValue+" ㎉";}},
                {name: "calCsumQty"   , index: "calCsumQty"   , label: "칼로리 소모/일"          , width:  80 , align: "right"  ,fixed:true,formatter:function(cellValue){ if (cellValue==null || cellValue=='') return '-'; else return cellValue+" ㎉";}},
                {name: "gidx"         , index: "gidx"         , label: "성장지수"                , width:  60 , align: "center" ,fixed:true},
                {name: "growJudgCdNm" , index: "growJudgCdNm" , label: "성장 판정"               , width: 100 , align: "center" ,fixed:true},
                {name: "fidx"         , index: "fidx"         , label: "비만지수"                , width:  60 , align: "center" ,fixed:true},
                {name: "fatJudgCdNm"  , index: "fatJudgCdNm"  , label: "비만 판정"               , width: 100 , align: "center" ,fixed:true},
                {name: "fatpIdx"      , index: "fatpIdx"      , label: "비만예측지수"            , width:  60 , align: "center" ,fixed:true,formatter:function(cellValue){ if (cellValue==null || cellValue=='') return '-'; else return phoneFormatter(cellValue);}},
                {name: "fatpJudgCdNm" , index: "fatpJudgCdNm" , label: "비만 예측"               , width:  90 , align: "center" ,fixed:true,formatter:function(cellValue){ if (cellValue==null || cellValue=='') return '(설문안함)'; else return phoneFormatter(cellValue);}},
                {name: "palVal"       , index: "palVal"       , label: "신체활동수준<br>(PAL)"   , width:  80 , align: "right"  ,fixed:true},
                {name: "telNo"        , index: "telNo"        , label: "학생(밴드)<br/>전화번호" , width: 100 , align: "center" ,fixed:true ,formatter:function(cellValue){ return phoneFormatter(cellValue);}},
                {name: "guarNo"       , index: "guarNo"       , label: "보호자 번호"             , width: 100 , align: "center" ,fixed:true},
                {name: "guarNm"       , index: "guarNm"       , label: "보호자 명"               , width: 100 , align: "center" ,fixed:true},
                {name: "guarTelNo" 	  , index: "guarTelNo" 	  , label: "보호자<br/>전화번호"     , width: 100 , align: "center" ,fixed:true, formatter:function(cellValue){ return phoneFormatter(cellValue);}},
                {name: "gfixIdx"      , index: "gfixIdx"       , label: "기준" 	                 , width: 100 , align: "center" ,fixed:true , hidden:true}
            ];
            $("#gfixHist_list").jqGrid("GridUnload");
           	$("#gfixHist_list").jqGrid($.extend(true, {}, commonGridOptions(),
            {
            	datatype : "local",
            	mtype    : 'post'  ,
                url      : '/oper/hc/gfixHist/searchGfixHistList.ab',
                pager    : '#gfixHist_pager_list',
				height   : 316     ,
                colModel : colModels,
                autowidth: false,
                onPaging : function(data)
                {
                    onPagingCommon(data, this, function(resultMap)
                    {
                        $this.params.currentPage  = resultMap.currentPage;
                        $this.params.rowCount      = resultMap.rowCount;
                        $this.params.currentIndex = resultMap.currentIndex;
                        $this.searchGfixHistList(false);
                    })
                },
                gridComplete: function () {
                    let grid = this;

//                    $(grid).tableRowSpan(["locNm","stdtNo","stdtNm","sexCdNm", "ageYcnt","ageMcnt", "hghtVal","wghtVal","telNo"], "stdtNo");
//                    $(grid).tableRowSpan(["gfixDt","calEatQty","calCsumQty","growIdx","gidx","growJudgCdNm", "fidx","fatJudgCdNm", "fatpIdx","fatpJudgCdNm","palVal"], "gfixIdx");
//                    $(grid).tableRowSpan(["guarNo","guarNm","guarTelNo"], "guarNo");
                }
            }));
            resizeJqGridWidth("gfixHist_list", "gfixHist_list_wrapper");
        },
        // 조회검증
        checkSearch: function()
        {
        	let $this = this;
        	$this.searchGfixHistList(true);
        },
        //성장/비만_지수_이력 리스트 조회
        searchGfixHistList: function(isSearch)
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
			$("#gfixHist_list").setGridParam(
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
        //성장/비만_지수_이력 리스트 엑셀 다운로드
		downloadExcel : function()
        {
			let $this = this;
			let params = $.extend(true, {}, $this.params);

			AjaxUtil.post(
       {
				dataType : 'binary',
                url      : "/oper/hc/gfixHist/searchGfixHistList/excel.ab",
                param    : params,
                success  : function(response)
                {
                	saveFileLocal(response, 'gfixHist.xls');
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

            $('#gfixDtFrPicker').datepicker({
                todayBtn: "linked",
                keyboardNavigation: false,
                forceParse: false,
                calendarWeeks: true,
                autoclose: true,
                todayHighlight: true,
            }).on("changeDate", function() {
                $this.params.gfixDtFr = $('#gfixDtFr').val();
            });
            $('#gfixDtToPicker').datepicker({
                todayBtn: "linked",
                keyboardNavigation: false,
                forceParse: false,
                calendarWeeks: true,
                autoclose: true,
                todayHighlight: true,
            }).on("changeDate", function() {
                $this.params.gfixDtTo = $('#gfixDtTo').val();
            });
        },
        //성장지수_추이분석_탭_열기
        regGidxStss: function()
        {
            let menuNo = 'S210';
            let params = $.extend(true, {}, this.params);
            top.navigation.openMenuByMenuNo(menuNo, "gfixHist", params);
            top.index.$emit('SET_PARAM', params);
        },
        //비만지수_추이분석_탭_열기
        regFidxStss: function()
        {
            let menuNo = 'S220';
            let params = $.extend(true, {}, this.params);
            top.navigation.openMenuByMenuNo(menuNo, "gfixHist2", params);
            top.index.$emit('SET_PARAM', params);
        },
        //비만예측지수_추이분석_탭_열기
        regFatpStss: function()
        {
            let menuNo = 'S230';
            let params = $.extend(true, {}, this.params);
            top.navigation.openMenuByMenuNo(menuNo, "gfixHist3", params);
            top.index.$emit('SET_PARAM', params);
        },
        //기준_일자_기간_선택
        bDPerSelect: function()
        {
            let $this = this;
            const terms = getPeriodDate($this.params.bDPer);
            this.params.gfixDtFr = terms.strDt;
            this.params.gfixDtTo = terms.endDt;
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
            if( ((WebUtil.isNotNull($this.params.gfixDtFr)) && (WebUtil.isNull($this.params.gfixDtTo))) || ((WebUtil.isNotNull($this.params.gfixDtTo)) && (WebUtil.isNull($this.params.gfixDtFr))) )
            {
                Swal.alert(['나머지 기준 일자를 선택하세요.', 'info']);
                return false;
            }
            if( ((WebUtil.isNotNull($this.params.gfixDtFr) && WebUtil.isNotNull($this.params.gfixDtTo)) && $this.params.gfixDtFr > $this.params.gfixDtTo) )
            {
                Swal.alert(['정확한 기준 일자를 선택하세요.', 'info']);
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
                gfixDtFr       : '' , //성장비만지수_일자(FROM)
                gfixDtTo       : '' , //성장비만지수_일자(To)
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
        $(document).ready(function()
        {
            self.initialize();
            top.index.$on('GET_PARAM', function(params) {
                self.setParam(params);
                self.searchGfixHistList(true);
            });
            self.setParam();
            self.searchGfixHistList(true);
        });
    }
});