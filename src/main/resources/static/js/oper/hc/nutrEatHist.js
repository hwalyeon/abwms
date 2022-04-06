let nutrEatHist = new Vue({
    el: "#nutrEatHist", //영양소_섭취_이력
    data:
    {
        codeCnt : 0,
    	params:
        {
            userId       : '' ,
            stndDtFr     : '' , //기준_일자(FROM)
            stndDtTo     : '' , //기준_일자(To)
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
            bDPerList    : [] , //기준_일자_기간_리스트
            nutrCdNmList : []   //영양소코드명
        },
	},
    methods:
    {
        initialize: function()
        {
        	let $this = this;

            $this.initValue();
        	$this.initCodeList();
            $this.searchNutrEatHistList(true);
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
            //영양소_코드_명_리스트
            AjaxUtil.post(
                {
                    url: "/svcStnd/nutr/ddNutrEatStndMng/searchNutrCdNmList.ab",
                    param: {},
                    success: function(response) {
                        $this.code.nutrCdNmList = [];
                        if ( !!response.rtnData.result && response.rtnData.result.length > 0 ) {
                            $.each(response.rtnData.result, function(index, item) {
                                $this.code.nutrCdNmList.push({'cdVal':item.nutrCd, 'cdNm':item.nutrNm});
                            });
                        }
                        $this.codeCnt += 1;
                    },
                    error: function (response) {
                        Swal.alert([response, 'error']);
                    }
                });

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
                    {name: "stndDt"           , index: "stndDt"           , label: "기준 일자" 	            ,  width: 80 , align: "center" , fixed: true },
                    {name: "locNm"            , index: "locNm"            , label: "학교 명" 	            ,  width: 120 , align: "center", fixed: true },
                    {name: "stdtNo"           , index: "stdtNo"           , label: "학생 번호" 	            ,  width: 80 , align: "center" , fixed: true },
                    {name: "stdtNm"           , index: "stdtNm"           , label: "학생 명" 	            ,  width: 80 , align: "center" , fixed: true },
                ];

            if($this.code.nutrCdNmList.length > 0){
                for(var i in $this.code.nutrCdNmList ){
                    var data = $this.code.nutrCdNmList[i];
                    if(data.cdVal === 'VIT_B' || data.cdVal === 'AMNO' || data.cdVal==='EPA_DHA'){
                        colModels.push( {name:toCamelCase(data.cdVal)  , index:toCamelCase(data.cdVal)    , label:data.cdNm + "("+data.cdVal+")" , width: 80 ,  align: "center", fixed: true } );
                    }else {
                        colModels.push( {name:toCamelCase(data.cdVal)  , index:toCamelCase(data.cdVal)    , label:data.cdNm + "("+data.cdVal+")"  , width: 80 , align: "center",  fixed: true } );
                    }
                }
            }
            colModels.push({name: "telNo"     , index: "telNo"     , label: "학생(밴드)<br/>전화번호" , width: 120 , align: "center" ,fixed: true ,formatter:function(cellValue, options, rowObject){ return phoneFormatter(cellValue);}});
            colModels.push({name: "guarNo"    , index: "guarNo"    , label: "보호자 번호"             , width: 120 , align: "center" ,fixed: true });
            colModels.push({name: "guarNm"    , index: "guarNm"    , label: "보호자 명"               , width: 120 , align: "center" ,fixed: true });
            colModels.push({name: "guarTelNo" , index: "guarTelNo" , label: "보호자<br/>전화번호"     , width: 120 , align: "center" ,fixed: true  ,formatter:function(cellValue, options, rowObject){ return phoneFormatter(cellValue);}});


            $("#nutrEatHist_list").jqGrid("GridUnload");
            $("#nutrEatHist_list").jqGrid($.extend(true, {}, commonGridOptions(3000,''),
                {
                    datatype  : "local",
                    mtype     : 'post',
                    url       : '/oper/hc/nutrEatHist/searchNutrEatHistList.ab',
                    pager     : '#nutrEatHist_pager_list',
                    height    : 405,
                    autowidth : false,
                    colModel  : colModels,
                    afterSaveCell : function (rowid , colId , val, e ){

                        if(colId === 'vitB1' || colId === 'vitB2' || colId === 'nia' || colId === 'dfe' || colId === 'vitB12'){
                            let vaiBTemp = parseFloat(WebUtil.nvl(rowData.vitB1 , '0')) + parseFloat(WebUtil.nvl(rowData.vitB2, '0')) +parseFloat(WebUtil.nvl(rowData.nia, '0'))+ (WebUtil.nvl(parseFloat(rowData.dfe, '0')) / 1000) + (WebUtil.nvl(parseFloat(rowData.vitB12, '0')) / 1000);
                            $("#nutrEatHist_list").setRowData(rowid, {vitB: Math.round(vaiBTemp * 10)/10});
                        }else if(colId === 'ile' || colId === 'leu' || colId === 'val'){
                            let amnoTemp = parseFloat(WebUtil.nvl(rowData.ile, '0')) + parseFloat(WebUtil.nvl(rowData.leu, '0')) +parseFloat(WebUtil.nvl(rowData.val, '0'));
                            $("#nutrEatHist_list").setRowData(rowid, {amno: Math.round(amnoTemp * 10)/10});
                        }else if(colId === 'epa' || colId === 'dha'){
                            let epaDhaTemp = parseFloat(WebUtil.nvl(rowData.epa, '0')) + parseFloat(WebUtil.nvl(rowData.dha, '0'));
                            $("#nutrEatHist_list").setRowData(rowid, {epaDha: Math.round(epaDhaTemp * 10)/10});
                        }
                    },
                    gridComplete: function () {
                        let grid = this;

                        $(grid).tableRowSpan(["locNm","stdtNo","stdtNm","telNo"], "stdtNo");
                        $(grid).tableRowSpan(["guarNo","guarNm","guarTelNo"], "guarNo");
                        $(grid).tableRowSpan(["stndDt","cal","prtn","carb","ca","fe","mg","na","vitD3","vitB","vitB1","nia","dfe","chl","fapu","epa","dha","dfib","epaDha","vitB12","vitB2","zn","ile","leu","val","amno","fat"], "stndDt");
                    }
                }));

            $("#nutrEatHist_list").jqGrid("setGroupHeaders",{
                useColSpanStyle: true,
                groupHeaders: [
                    {startColumnName: 'vitB', numberOfColumns: 6, titleText: '비타민_B(비타민B1,B2,B12,나이아신,엽산)'},
                    {startColumnName: 'amno', numberOfColumns: 4, titleText: '아미노산'},
                    {startColumnName: 'epa', numberOfColumns: 3, titleText: 'EPA+DHA'}
                ]
            });

            resizeJqGridWidth("nutrEatHist_list", "nutrEatHist_list_wrapper");
        },
        //영양소_섭취_이력 리스트 조회
        searchNutrEatHistList: function(isSearch)
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
        //영양소_섭취_이력 리스트 엑셀 다운로드
		downloadExcel : function()
        {
			let $this = this;
			let params = $.extend(true, {}, $this.params);

			AjaxUtil.post(
       {
				dataType : 'binary',
                url      : "/oper/hc/nutrEatHist/searchNutrEatHistList/excel.ab",
                param    : params,
                success  : function(response)
                {
                	saveFileLocal(response, 'nutrEatHist.xls');
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
    computed:
    {
    },
    watch:
        {
            'codeCnt' : function (value){
                let $this = this;
                if(value ===  1){
                    $this.initGrid();
                    $this.searchNutrEatHistList(true);
                }
            }
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