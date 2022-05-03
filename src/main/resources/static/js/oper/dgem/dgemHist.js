let dgemHist = new Vue({
    el: "#dgemHist",
    data: {
        params: {
            entrDtFr       :'',  //일자_From
            entrDtTo       :'',  //일자_To
            stdtNo         :'',  //학생번호
            dgemHistSeq    :'',  //위험감정 이력순번
            dgemDt         :'',  //위험감정 일자
            dgemTm         :'',  //위험감정 시각
            dgemIdx        :'',  //위험감정 지수
            dgemStatCd     :'',  //위험감정 상태코드
            dgemStatCntn   :'',  //위험감정 요약내용
            dgemSmryCntn   :'',  //위험감정 상태내용
            locHistNo      :'',  //위치이력 번호
            currLatVal     :'',  //현재위도 값
            currLonVal     :'',  //현재경도 값
            locMesuDttm    :'',  //위치측정일시
            actDivCd       :'',  //활동구분코드
            hbitStatCd     :'',  //심박상태코드
            plcClssCd      :'',  //장소분류코드
            tempStatCd     :'',  //체온상태코드
            judgNo         :'',  //판정번호
            rmrk           :'',  //비고
            dgemAlamNo     :'',  //위험감정알림번호
            locNm          :'',  //학교명
            guarNo         :'',  //보호자번호
            guarNm         :'',  //보호자명
            guarTelNo      :'',  //보호자전화번호
            mmDd           :'THIS_MONTH',
            paging         :'Y',
            totalCount     : 0,
            rowCount       : 30,
            currentPage    : 1,
            currentIndex   : 0
        },
        code:{
            mmDdList           : [] , //일자_리스트
            hbitStatCdList     : [] , //심박_상태_코드_리스트
            plcClssCdList      : [] , //장소_구분_코드_리스트
            tempStatCdList     : [] , //체온_상태_코드_리스트
            dgemStatCdList     : [] , //위험감정_상태_코드_리스트
        },
    },


    methods: {

        initialize: function() {

            let $this = this;

            $this.initValue();

            $this.initCodeList();

            $this.initGrid();

            $this.searchDgemHistList(true);

            $this.setDatepicker();

        },
        initValue: function() {
            let $this = this;
            $this.code.mmDdList = CodeUtil.getPeriodDateList();
            const terms = getPeriodDate($this.params.mmDd);
            this.params.entrDtFr = terms.strDt;
            this.params.entrDtTo = terms.endDt;
        },
        mmDdSelect: function()
        {
            let $this = this;
            const terms = getPeriodDate($this.params.mmDd);
            this.params.entrDtFr = terms.strDt;
            this.params.entrDtTo = terms.endDt;
        },
        initCodeList: function() {
            let $this = this;
            getCommonCodeList('HBIT_STAT_CD', $this.code.hbitStatCdList);  //심박_상태_코드_리스트
            getCommonCodeList('TEMP_STAT_CD', $this.code.tempStatCdList);  //체온_상태_코드_리스트
            getCommonCodeList('PLC_CLSS_CD' , $this.code.plcClssCdList );  //장소_구분_코드_리스트
            getCommonCodeList('DGEM_STAT_CD', $this.code.dgemStatCdList);  //위험감정_상태_코드_리스트
        },
        initGrid: function()
        {
            let $this = this;
            let colModels = [
                {name: "crud"              , index: "crud"              , label: "crud"		 	    , hidden: true                                  },
                {name: "guarNoTemp"        , index: "guarNoTemp"        , label: "보호자번호"			, width: 80     , align: "center" , hidden: true},
                {name: "stdtHistSeq"       , index: "stdtHistSeq"       , label: "학생이력"			, width: 80     , align: "center" , hidden: true},
                {name: "stdtGuarNm"        , index: "stdtGuarNm"        , label: "학생이력"			, width: 80     , align: "center" , hidden: true},
                {name: "stdtNo"            , index: "stdtNo"            , label: "학생번호"	        , width: 80     , align: "center" , fixed:true , formatter: function(cellValue, options, rowObject){
                        if(WebUtil.isNull(cellValue)) return '<input type="button" class="btn btn-xs btn-outline btn-success" onclick="dgemHist.regStdtInfoDetlPopup(\'' + rowObject.stdtNo + '\', \'' + rowObject.guarNo + '\')" value="신규" data-toggle="modal" data-target="#stdtRegDetlPopup" />';
                        else return`<a data-toggle="modal" class="links" data-target="#stdtInfoDetlPopup" data-stdt data-placement="bottom" title="${cellValue}" data-guar-no="${rowObject.guarNo}" data-stdt-no="${rowObject.stdtNo}">${cellValue}</a>`;}},
                {name: "dgemHistSeq"       , index: "dgemHistSeq"       , label: "위험감정 이력순번"	, width: 110    , align: "center" , fixed: true},
                {name: "dgemDt"            , index: "dgemDt"            , label: "위험감정 일자"		, width: 80     , align: "center" , fixed: true},
                {name: "dgemTm"            , index: "dgemTm"            , label: "위험감정 시각"		, width: 80     , align: "center" , fixed: true},
                {name: "dgemIdx"           , index: "dgemIdx"           , label: "위험감정 지수"	    , width: 80     , align: "center" , fixed: true},
                {name: "dgemStatCd"        , index: "dgemStatCd"        , label: "위험감정 상태코드"	, width: 110    , align: "center" , fixed: true},
                {name: "dgemStatCntn"      , index: "dgemStatCntn"      , label: "위험감정 요약내용"   , width: 110    , align: "center" , fixed: true},
                {name: "dgemSmryCntn"      , index: "dgemSmryCntn"      , label: "위험감정 상태내용"	, width: 110    , align: "center" , fixed: true},
                {name: "locHistNo"         , index: "locHistNo"         , label: "위치이력 번호"		, width: 80     , align: "center" , fixed: true},
                /*{name: "currLatVal"        , index: "currLatVal"        , label: "현재위도 값"		, width: 80     , align: "center" , fixed: true},
                {name: "currLonVal"        , index: "currLonVal"        , label: "현재경도 값"  		, width: 80     , align: "center" , fixed: true},
                {name: "locMesuDttm"       , index: "locMesuDttm"       , label: "위치측정일시"	 	, width: 100    , align: "center" , fixed: true},*/
                {name: "actDivCd"          , index: "actDivCd"          , label: "활동구분코드"		, width: 100    , align: "center" , fixed: true},
                {name: "hbitStatCd"        , index: "hbitStatCd"        , label: "심박상태코드"  		, width: 100    , align: "center" , fixed: true},
                {name: "plcClssCd"         , index: "plcClssCd"         , label: "장소분류코드" 	    , width: 110    , align: "center" , fixed: true},
                {name: "tempStatCd"        , index: "tempStatCd"        , label: "체온상태코드"    	, width: 110    , align: "center" , fixed: true},
                {name: "judgNo"            , index: "judgNo"            , label: "판정번호" 	        , width: 110    , align: "center" , fixed: true},
                {name: "rmrk"              , index: "rmrk"              , label: "비고" 	            , width: 110    , align: "center" , fixed: true},
                {name: "dgemAlamNo"        , index: "dgemAlamNo"        , label: "위험감정알림번호" 	, width: 110    , align: "center" , fixed: true},
                {name: "locNm"             , index: "locNm"             , label: "학교명"        	, width: 150    , align: "center" , fixed: true},
                {name: "guarNo"            , index: "guarNo"            , label: "보호자번호" 	    , width: 110    , align: "center" , fixed: true},
                {name: "guarNm"            , index: "guarNm"            , label: "보호자명" 	        , width: 110    , align: "center" , fixed: true},
                {name: "guarTelNo"         , index: "guarTelNo"         , label: "보호자전화번호" 	    , width: 110    , align: "center" , fixed: true},
            ];



            $("#dgem_list").jqGrid("GridUnload");
            $("#dgem_list").jqGrid($.extend(true, {}, commonGridOptions(), {
                datatype: "local",
                mtype: 'post',
                url: '/oper/dgem/dgemHist/searchDgemHistList.ab',
                pager: '#dgem_pager_list',
                height: 350,
                colModel: colModels,
                onPaging : function(data) {
                    onPagingCommon(data, this, function(resultMap) {
                        $this.params.currentPage  = resultMap.currentPage;
                        $this.params.rowCount     = resultMap.rowCount;
                        $this.params.currentIndex = resultMap.currentIndex;
                        $this.searchDgemHistList(false);
                    })
                },
                gridComplete: function() {
                    let grid = this;

                    $(grid).tableRowSpan(["stdtNo","dgemHistSeq","dgemDt","dgemTm","dgemIdx","dgemStatCd","dgemStatCntn","dgemSmryCntn",
                        "locHistNo","currLatVal","currLonVal","locMesuDttm","actDivCd","hbitStatCd","plcClssCd","tempStatCd","judgNo","rmrk","dgemAlamNo","locNm"], "stdtHistSeq");
                    $(grid).tableRowSpan(["stdtNo","locNm","guarNo","guarNm","guarTelNo"], "stdtGuarNm");

                    //학생정보 상세 팝업
                    $("#dgem_list").find('A.links[data-stdt]').on('click', function(e) {
                        dgemHist.regStdtInfoDetlPopup($(e.target).data('stdt-no'), $(e.target).data('guar-no'))
                    });
                }
            }));

            resizeJqGridWidth("dgem_list", "dgem_list_wrapper");
        },
        searchDgemHistList: function(isSearch) {

            let $this = this;
            let params = $.extend(true, {}, $this.params);
            if ( isSearch ) {
                params.currentPage = 1;
                params.currentIndex = 0;
            }

            $("#dgem_list").setGridParam({
                datatype: "json",
                postData: JSON.stringify(params),
                page: 1,
                loadComplete: function (response) {
                    if ( response.rtnData.result == 0 ) {
                        Swal.alert(['조회할 내용이 없습니다.', "info"]);
                    }
                }
            }).trigger("reloadGrid");
        },
        //학생정보상세 팝업
        regStdtInfoDetlPopup: function(stdtNo, guarNo){
            stdtInfoDetl.initPage(stdtNo, guarNo, function(){ dgemHist.searchDgemHistList(true) });
        },
        //학생 및 보호자 정보 search 팝업
        stdtGuarDetlPopup: function() {
            let $this = this;
            stdtGuarPopup.initPage({ callback : function(rowData) {
                    $this.params.stdtNo = rowData.stdtNo;
                    $this.params.stdtNm = rowData.stdtNm;
                    $this.params.guarNo = rowData.guarNo;
                    $this.params.guarNm = rowData.guarNm;
            }});
        },
        //학교명 정보 search 팝업
        locSearchDetlPopup: function() {
            let $this = this;
            locSearchPopup.initPage( { callback : function(rowData) {
                $this.params.locNm = rowData.locNm;
            }});
        },
        setDatepicker : function() {
            let $this = this;
            $('#entrDtFrPicker').datepicker({
                todayBtn: "linked",
                keyboardNavigation: false,
                forceParse: false,
                calendarWeeks: true,
                format: 'yyyy-mm-dd',
                autoclose: true,
                todayHighlight: true,
            }).on("changeDate", function() {
                $this.params.entrDtFr = $('#entrDtFr').val();
            });
            $('#entrDtToPicker').datepicker({
                todayBtn: "linked",
                keyboardNavigation: false,
                forceParse: false,
                calendarWeeks: true,
                format: 'yyyy-mm-dd',
                autoclose: true,
                todayHighlight: true,
            }).on("changeDate", function() {
                $this.params.entrDtTo = $('#entrDtTo').val();
            });
        },
        //엑셀 다운로드
        downloadExcel : function()
        {
            let $this = this;
            let params = $.extend(true, {}, $this.params);

            AjaxUtil.post({
                dataType: 'binary',
                url: "/oper/dgem/dgemHist/searchDgemHistList/excel.ab",
                param: params,
                success: function(response)
                {
                    saveFileLocal(response, 'dgemHist.xls');
                },
                error: function (response)
                {
                    Swal.alert([response, 'error']);
                }
            });
        },
        //초기화
        resetSearchParam: function() {
            let $this = this;
            $this.params = {
                stdtNo:'',
                mmDd:'',
                paging: 'Y',
                totalCount: 0,
                rowCount: 30,
                currentPage: 1,
                currentIndex: 0
            }
        }
    },
    computed: {

    },
    watch: {

    },
    mounted: function() {
        let self = this;
        $(document).ready(function() {
            self.initialize();
        });
    }
});
