let cbeeHist = new Vue({
    el: "#cbeeHist", //캐시비 이력
    data:
    {
    	params:
        {
            userId       : '' ,
            occrDttmFr   : '' , //발생_일시(FROM)
            occrDttmTo   : '' , //발생_일시(To)
            bDPer        : 'THIS_MONTH' , //기준_일자_기간
            stdtNo       : '' , //학생_번호
            stdtNm       : '' , //학생_명
            locNm        : '' , //학교(학원)명
            guarNo       : '' , //보호자_번호
            guarNm       : '' , //보호자_명
    		paging       : 'Y',
    		totalCount   : 0  ,
            rowCount     : 30 ,
            currentPage  : 1  ,
            currentIndex : 0
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
            //$this.searchCbeeHistList(true);
            $this.setDatepicker();
            document.getElementById("stdtNm").focus();
        },
        initValue: function()
        {
            let $this = this;
            $this.userId = SessionUtil.getUserId();

            //기준_일자_기간_리스트
            $this.code.bDPerList = CodeUtil.getPeriodDateList();
            const terms = getPeriodDate($this.params.bDPer);

            this.params.occrDttmFr = terms.strDt;
            this.params.occrDttmTo = terms.endDt;
        },
        initCodeList : function()
        {
            let $this = this;

        },
        initGrid: function()
        {
            let $this = this;
        	let colModels =
            [
                {name: "occrDttm"    , index: "occrDttm"    , label: "발생일시" 	             , width:  80 , align: "center" , formatter: function(cellValue) { return formatTimestamp(cellValue);}},
                {name: "locNm"       , index: "locNm"       , label: "학교명" 	                 , width: 120 , align: "left"   },
                {name: "stdtNo"      , index: "stdtNo"      , label: "학생번호" 	             , width:  80 , align: "center" },
                {name: "stdtNm"      , index: "stdtNm"      , label: "학생명" 	                 , width:  80 , align: "center" },
                {name: "useCbeeAmt"  , index: "useCbeeAmt"  , label: "발생금액"                  , width:  80 , align: "right"  , formatter: function(cellValue) { return numberFormat(cellValue) + " 원 ";  }},
                {name: "cbeeUseCdNm" , index: "cbeeUseCdNm" , label: "발생구분"                  , width:  50 , align: "left"   },
                {name: "cbeeBal"     , index: "cbeeBal"     , label: "누적잔액"                  , width:  80 , align: "right"  , formatter: function(cellValue) { return numberFormat(cellValue) + " 원 ";  }},
                {name: "telNo"       , index: "telNo"       , label: "학생(밴드)<br/>전화번호"   , width:  80 , align: "center"  ,formatter: function(cellValue) { return phoneFormatter(cellValue);}},
                {name: "guarNo"      , index: "guarNo"      , label: "보호자 번호"               , width:  80 , align: "center" },
                {name: "guarNm"      , index: "guarNm"      , label: "보호자 명"                 , width:  80 , align: "center" },
                {name: "guarTelNo" 	 , index: "guarTelNo" 	, label: "보호자<br/>전화번호"       , width:  80 , align: "center" , formatter:function(cellValue)  { return phoneFormatter(cellValue);}}
            ];
            $("#cbeeHist_list").jqGrid("GridUnload");
           	$("#cbeeHist_list").jqGrid($.extend(true, {}, commonGridOptions(),
            {
            	datatype : "local",
            	mtype    : 'post'  ,
                url      : '/oper/cbee/cbeeHist/cbeeHistList.ab',
                pager    : '#cbeeHist_pager_list',
				height   : 365     ,
                colModel : colModels,
                onPaging : function(data)
                {
                    onPagingCommon(data, this, function(resultMap)
                    {
                        $this.params.currentPage  = resultMap.currentPage;
                        $this.params.rowCount     = resultMap.rowCount;
                        $this.params.currentIndex = resultMap.currentIndex;
                        $this.searchCbeeHistList(false);
                    })
                },
                gridComplete: function () {
                    let grid = this;


                }
            }));
            resizeJqGridWidth("cbeeHist_list", "cbeeHist_list_wrapper");
        },
        // 조회검증
        checkSearch: function()
        {
        	let $this = this;
        	$this.searchCbeeHistList(true);
        },
        //캐시비 이력 리스트 조회
        searchCbeeHistList: function(isSearch)
        {
			let $this  = this;
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
			$("#cbeeHist_list").setGridParam(
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
        //캐시비 이력 리스트 엑셀 다운로드
		downloadExcel : function()
        {
			let $this = this;
			let params = $.extend(true, {}, $this.params);

			AjaxUtil.post(
       {
				dataType : 'binary',
                url      : "/oper/cbee/cbeeHist/cbeeHistList/excel.ab",
                param    : params,
                success  : function(response)
                {
                	saveFileLocal(response, 'cbeeHist.xls');
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
            $this.params.occrDttmFr = '' ;
            $this.params.occrDttmTo = '' ;

            const terms = getPeriodDate($this.params.bDPer);
            this.params.occrDttmFr = terms.strDt;
            this.params.occrDttmTo = terms.endDt;
        },
        //기준_일자 선택
        setDatepicker : function() {
            let $this = this;
            if($this.params.bDPer!=='')
            {$this.params.bDPer = '' ;}

            $('#occrDttmFrPicker').datepicker({
                todayBtn: "linked",
                keyboardNavigation: false,
                forceParse: false,
                calendarWeeks: true,
                autoclose: true,
                todayHighlight: true,
            }).on("changeDate", function() {
                $this.params.occrDttmFr = $('#occrDttmFr').val();
            });
            $('#occrDttmToPicker').datepicker({
                todayBtn: "linked",
                keyboardNavigation: false,
                forceParse: false,
                calendarWeeks: true,
                autoclose: true,
                todayHighlight: true,
            }).on("changeDate", function() {
                $this.params.occrDttmTo = $('#occrDttmTo').val();
            });
        },
        //유효성_검증
        isValid: function() {

            let $this = this;

            if( ((WebUtil.isNotNull($this.params.occrDttmFr)) && (WebUtil.isNull($this.params.occrDttmTo))) || ((WebUtil.isNotNull($this.params.occrDttmTo)) && (WebUtil.isNull($this.params.occrDttmFr))) )
            {
                Swal.alert(['나머지 기준 일자를 선택하세요.', 'info']);
                return false;
            }
            if( ((WebUtil.isNotNull($this.params.occrDttmFr) && WebUtil.isNotNull($this.params.occrDttmTo)) && $this.params.occrDttmFr > $this.params.occrDttmTo) )
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
                userId       : '' ,
                occrDttmFr   : '' , //발생_일시(FROM)
                occrDttmTo   : '' , //발생_일시(To)
                bDPer        : 'THIS_MONTH' , //기준_일자_기간
                stdtNo       : '' , //학생_번호
                stdtNm       : '' , //학생_명
                locNm        : '' , //학교(학원)명
                guarNo       : '' , //보호자_번호
                guarNm       : '' , //보호자_명
                paging       : 'Y',
                totalCount   : 0  ,
                rowCount     : 30 ,
                currentPage  : 1  ,
                currentIndex : 0
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
                self.searchCbeeHistList(true);
            });
            self.setParam();
            self.searchCbeeHistList(true);
        });
    }
});