let actHist = new Vue({
    el: "#actHist", //활동_이력
    data:
    {
    	params:
        {
            userId       : '' ,
            stndDtFr     : '' , //기준_일자(FROM)
            stndDtTo     : '' , //기준_일자(To)
            bDPer        : 'THIS_MONTH' , //기준_일자_기간
            stdtNo       : '' , //학생_번호
            stdtNm       : '' , //학생_명
            actClssCd    : '' , //활동_분류_코드
            actCd        : '' , //활동_코드
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
            bDPerList     : [] , //기준_일자_기간_리스트
            actClssCdList : [] , //활동_분류_코드_리스트
            actCdList     : [] , //활동_코드_리스트
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
            $this.searchStrsHistList(true);
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

            //활동_분류_코드_리스트
            getCommonCodeList('ACT_CLSS_CD' , $this.code.actClssCdList);

            //활동_코드_리스트
            $this.actCdList();
        },
        initGrid: function()
        {
            let $this = this;
        	let colModels =
            [
                {name: "stndDt"      , index: "stndDt"      , label: "기준 일자" 	               ,  width: 50 , align: "center" },
                {name: "stdtNo"      , index: "stdtNo"      , label: "학생 번호" 	               ,  width: 50 , align: "center" },
                {name: "stdtNm"      , index: "stdtNm"      , label: "학생 명" 	                   ,  width: 50 , align: "center" },
                {name: "locNm"       , index: "locNm"       , label: "학교 명" 	                   ,  width: 50 , align: "center" },
                {name: "actNm"       , index: "actNm"       , label: "활동명"	                   ,  width: 50 , align: "center" },
                {name: "actMcnt"     , index: "actMcnt"     , label: "활동시간(분)"                 , width: 50 , align: "center" },
                {name: "rpetActCnt"  , index: "rpetActCnt"  , label: "발생 건수<br/>(반복 활동 수)"  , width: 50 , align: "center" },
                {name: "calCsumQty"  , index: "calCsumQty"  , label: "칼로리 소모량"                , width: 50 , align: "center" },
                {name: "judgNo"      , index: "judgNo"      , label: "판정 번호"                    , width: 50 , align: "center" },
                {name: "telNo"       , index: "telNo"       , label: "학생(밴드)<br/>전화번호"      , width: 50 , align: "center"  ,formatter:function(cellValue, options, rowObject){ return phoneFormatter(cellValue);}},
                {name: "guarNo"      , index: "guarNo"      , label: "보호자 번호"                  , width: 50 , align: "center" },
                {name: "guarNm"      , index: "guarNm"      , label: "보호자 명"                    , width: 50 , align: "center" },
                {name: "guarTelNo" 	 , index: "guarTelNo" 	, label: "보호자<br/>전화번호"          , width: 50 , align: "center"  ,formatter:function(cellValue, options, rowObject){ return phoneFormatter(cellValue);}}
            ];
            $("#actHist_list").jqGrid("GridUnload");
           	$("#actHist_list").jqGrid($.extend(true, {}, commonGridOptions(),
            {
            	datatype : "local",
            	mtype    : 'post'  ,
                url      : '/oper/hc/actHist/actHistList.ab',
                pager    : '#actHist_pager_list',
				height   : 405     ,
                colModel : colModels,
                onPaging : function(data)
                {
                    onPagingCommon(data, this, function(resultMap)
                    {
                        $this.params.currentPage  = resultMap.currentPage;
                        $this.params.rowCount     = resultMap.rowCount;
                        $this.params.currentIndex = resultMap.currentIndex;
                        $this.searchStrsHistList(false);
                    })
                },
                gridComplete: function () {
                    let grid = this;

                    $(grid).tableRowSpan(["stndDt","stdtNo","stdtNm","locNm","telNo"], "stdtNo");
                    $(grid).tableRowSpan(["actNm", "actMcnt","rpetActCnt", "calCsumQty","judgNo"], "actNm");
                }
            }));
            resizeJqGridWidth("actHist_list", "actHist_list_wrapper");
        },
        //활동_이력리스트 조회
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
			$("#actHist_list").setGridParam(
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
        //활동_이력리스트 엑셀 다운로드
		downloadExcel : function()
        {
			let $this = this;
			let params = $.extend(true, {}, $this.params);

			AjaxUtil.post(
       {
				dataType : 'binary',
                url      : "/oper/hc/actHist/actHistList/excel.ab",
                param    : params,
                success  : function(response)
                {
                	saveFileLocal(response, 'actHist.xls');
                },
                error    : function (response)
                {
                    Swal.alert([response, 'error']);
                }
            });
		},
        //활동_코드_리스트 조회
        actCdList : function()
        {
            let $this = this;
            let params = $.extend(true, {}, $this.params);

            $this.code.actCdList = [];

            AjaxUtil.post({
                url    : "/oper/hc/actHist/searchActCdList.ab",
                param  : params,
                success: function (response) {
                    console.log(response);
                    if (!!response.rtnData.result) {
                        $.each(response.rtnData.result, function (index, item) {
                            $this.code.actCdList.push({'cdVal': item.actCd, 'cdNm': item.actNm});
                        });
                    }
                    console.log($this.code.actCdList);
                },
                error: function (response) {
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
                format: 'yyyy-mm-dd',
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
                format: 'yyyy-mm-dd',
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
        //활동_구분_코드 선택
        actClssCdSelect: function()
        {
            let $this = this;
            $this.params.actCd = '';
            $this.actCdList();
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
		resetSearchParam: function()
        {
			let $this = this;
			$this.params =
            {
                userId       : '' ,
                stndDtFr     : '' , //기준_일자(FROM)
                stndDtTo     : '' , //기준_일자(To)
                bDPer        : 'THIS_MONTH' , //기준_일자_기간
                stdtNo       : '' , //학생_번호
                stdtNm       : '' , //학생_명
                actClssCd    : '' , //활동_분류_코드
                actCd        : '' , //활동_코드
                locNm        : '' , //학교(학원)명
                guarNo       : '' , //보호자_번호
                guarNm       : '' , //보호자_명
                paging       : 'Y',
                totalCount   : 0  ,
                rowCount     : 30 ,
                currentPage  : 1  ,
                currentIndex : 0
	    	}
		}
    },
    computed: {
    },
    watch:  {
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