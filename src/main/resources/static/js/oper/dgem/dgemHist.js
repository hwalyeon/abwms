let dgemHist = new Vue({
    el: "#dgemHist",
    data: {
        params: {
            stdtNo         :'',
            dgemHistSeq    :'',
            dgemDt         :'',
            dgemTm         :'',
            dgemIdx        :'',
            dgemStatCd     :'',
            dgemStatCntn   :'',
            dgemSmryCntn   :'',
            locHistNo      :'',
            currLatVal     :'',
            currLonVal     :'',
            locMesuDttm    :'',
            actDivCd       :'',
            hbitStatCd     :'',
            plcClssCd      :'',
            tempStatCd     :'',
            judgNo         :'',
            rmrk           :'',
            dgemAlamNo     :'',
            locNm          :'',
            guarNo         :'',
            guarNm         :'',
            guarTelNo      :'',
            mmDd           :'THIS_MONTH',
            paging         :'Y',
            totalCount     : 0,
            rowCount       : 30,
            currentPage    : 1,
            currentIndex   : 0
        },
        code:{
            mmDdList :           []
        },
    },


    methods: {

        initialize: function() {

            let $this = this;

            $this.initValue();

            $this.initCodeList();

            $this.initGrid();

            $this.searchDgemHistList(true);

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
            getCommonCodeList('GROW_JUDG_CD',$this.code.mentGrowJudgCdList);
        },
        initGrid: function()
        {
            let $this = this;
            let colModels = [
                {name: "crud"              , index: "crud"              , label: "crud"		 	    , hidden: true                },
                {name: "guarNoTemp"        , index: "guarNoTemp"        , label: "보호자번호"			, width: 80     , align: "center" , hidden: true},
                {name: "stdtNo"            , index: "stdtNo"            , label: "학생번호"		 	, width: 80     , align: "center" , fixed: true},
                {name: "dgemHistSeq"       , index: "dgemHistSeq"       , label: "위험감정 이력순번"	, width: 110    , align: "center" , fixed: true},
                {name: "dgemDt"            , index: "dgemDt"            , label: "위험감정 일자"		, width: 80     , align: "center" , fixed: true},
                {name: "dgemTm"            , index: "dgemTm"            , label: "위험감정 시각"		, width: 80     , align: "center" , fixed: true},
                {name: "dgemIdx"           , index: "dgemIdx"           , label: "위험감정 지수"	    , width: 80     , align: "center" , fixed: true},
                {name: "dgemStatCd"        , index: "dgemStatCd"        , label: "위험감정 상태코드"	, width: 110    , align: "center" , fixed: true},
                {name: "dgemStatCntn"      , index: "dgemStatCntn"      , label: "위험감정 요약내용"   , width: 110    , align: "center" , fixed: true},
                {name: "dgemSmryCntn"      , index: "dgemSmryCntn"      , label: "위험감정 상태내용"	, width: 110    , align: "center" , fixed: true},
                {name: "locHistNo"         , index: "locHistNo"         , label: "위치이력 번호"		, width: 80     , align: "center" , fixed: true},
                {name: "currLatVal"        , index: "currLatVal"        , label: "현재위도 값"		, width: 80     , align: "center" , fixed: true},
                {name: "currLonVal"        , index: "currLonVal"        , label: "현재경도 값"  		, width: 80     , align: "center" , fixed: true},
                {name: "locMesuDttm"       , index: "locMesuDttm"       , label: "위치측정일시"	 	, width: 100    , align: "center" , fixed: true},
                {name: "actDivCd"          , index: "actDivCd"          , label: "활동구분코드"		, width: 100    , align: "center" , fixed: true},
                {name: "hbitStatCd"        , index: "hbitStatCd"        , label: "심박상태코드"  		, width: 80     , align: "center" , fixed: true},
                {name: "plcClssCd"         , index: "plcClssCd"         , label: "장소분류코드" 	    , width: 110    , align: "center" , fixed: true},
                {name: "tempStatCd"        , index: "tempStatCd"        , label: "체온상태코드"    	, width: 110    , align: "center" , fixed: true},
                {name: "judgNo"            , index: "judgNo"            , label: "판정번호" 	        , width: 110    , align: "center" , fixed: true},
                {name: "rmrk"              , index: "rmrk"              , label: "비고" 	            , width: 110    , align: "center" , fixed: true},
                {name: "dgemAlamNo"        , index: "dgemAlamNo"        , label: "위험감정알림번호" 	, width: 110    , align: "center" , fixed: true},
                {name: "locNm"             , index: "locNm"             , label: "학교명"        	, width: 110    , align: "center" , fixed: true},
                {name: "guarNo"            , index: "guarNo"            , label: "보호자번호" 	    , width: 110    , align: "center" , fixed: true},
                {name: "guarNm"            , index: "guarNm"            , label: "보호자명" 	        , width: 110    , align: "center" , fixed: true},
                {name: "guarTelNo"         , index: "guarTelNo"         , label: "보호자전화번호" 	    , width: 110    , align: "center" , fixed: true},
                {name: "regDt"             , index: "regDt"             , label: "등록일자"           , width: 80     , align: "center"
                    , formatter: function(cellValue, options, rowObject) { return formatDate(cellValue);}           , hidden: true },
                {name: "regTm"             , index: "regTm"             , label: "등록시각"           , width: 80     , align: "center"
                    , formatter: function(cellValue, options, rowObject) { return formatTime(cellValue);}           , hidden: true },
                {name: "regUserId"         , index: "regUserId"         , label: "등록사용자ID"       , width: 80     , align: "center"  , hidden: true},
                {name: "uptDt"             , index: "uptDt"             , label: "수정일자"           , width: 80     , align: "center"
                    , formatter: function(cellValue, options, rowObject) { return formatDate(cellValue);}           , hidden: true },
                {name: "uptTm"             , index: "uptTm"             , label: "수정시각"           , width: 80     , align: "center"
                    , formatter: function(cellValue, options, rowObject) { return formatTime(cellValue);}           , hidden: true },
                {name: "uptUserId"         , index: "uptUserId"         , label: "수정사용자ID"       , width: 80     , align: "center"  , hidden: true},
                {name: "stdtInfoDetlPopup" , index: "stdtInfoDetlPopup" , label: "상세정보보기"       , width: 80    , align: "center",fixed: true,
                    formatter: function(cellValue, options, rowObject) {
                        return '<input type="button" class="btn btn-xs btn-outline btn-success" onclick="stdtInfoMng.stdtInfoDetlPopup(\'' + rowObject.stdtNo + '\' , \'' + rowObject.guarNo + '\' )" value="상세보기" data-toggle="modal" data-target="#stdtInfoDetlPopup" />';
                    }
                }

            ];



            $("#grid_list").jqGrid("GridUnload");
            $("#grid_list").jqGrid($.extend(true, {}, commonGridOptions(), {
                datatype: "local",
                mtype: 'post',
                url: '/oper/dgem/dgemHist/searchDgemHistList.ab',
                pager: '#grid_pager_list',
                height: 450,
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

                    $(grid).tableRowSpan(["dgemHistSeq","dgemDt","dgemTm","dgemIdx","dgemStatCd","dgemStatCntn","dgemSmryCntn",
                                                  "locHistNo","currLatVal","currLonVal","locMesuDttm","actDivCd","hbitStatCd",
                                                  "plcClssCd","tempStatCd","judgNo","rmrk","dgemAlamNo","locNm","stdtNo"], "stdtNo");
                    //밴드 상세 팝업 생성
                    $("#grid_list").find('A.links[data-band]').on('click', function(e) {
                        stdtInfoMng.regBandOpenInfoDetlPopup($(e.target).data('band-id'))
                    });
                    //보호자 상세 팝업 생성
                    $("#grid_list").find('A.links[data-guar-tel]').on('click', function(e) {
                        bandOpenInfoMng.regGuarInfoDetlPopup($(e.target).data('band-id'),$(e.target).data('guar-tel-no'))
                    });
                    //학부모정보 상세 팝업
                    $("#grid_list").find('A.links[data-prnt]').on('click', function(e) {
                        guarInfoMng.regPrntInfoDetlPopup($(e.target).data('band-id'),$(e.target).data('prnt-no'),$(e.target).data('sex-cd'))
                    });
                    //보호자(사용자)정보 상세 팝업
                    $("#grid_list").find('A.links[data-guar]').on('click', function(e) {
                        guarInfoMng.regGuarInfoDetlPopup($(e.target).data('band-id'),$(e.target).data('guar-no'),$(e.target).data('stdt-no'))
                    });
                }
            }));

            resizeJqGridWidth("grid_list", "grid_list_wrapper");
        },
        searchDgemHistList: function(isSearch) {

            let $this = this;
            let params = $.extend(true, {}, $this.params);
            if ( isSearch ) {
                params.currentPage = 1;
                params.currentIndex = 0;
            }

            $("#grid_list").setGridParam({
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
        setData: function(data) {
            console.log(data);
            let $this = this;
            $this.params.stdtNo = data.stdtNo;
            $this.params.stdtNm = data.stdtNm;
            $this.params.guarNo = data.guarNo;
            $this.params.guarNm = data.guarNm;
            $this.params.locNm  = data.locNm;
        },
        stdtGuarDetlPopup: function() {
            stdtGuarDetl.initialize();
            console.log("테스트는 성공 ㅋ");
        },

        locSearchDetlPopup: function() {
            locSearchDetl.initialize();
        },

        stdtInfoDetlPopup: function(stdtNo, guarNo) {
            stdtInfoDetl.initPage(stdtNo, guarNo);
        },

        stdtRegDetlPopup: function() {
            stdtRegDetl.initPage();
        },
        regBandOpenInfoDetlPopup: function(bandId) {
            bandOpenInfoDetl.initPage(bandId, function(){  stdtInfoMng.searchDgemHistList(true) });
        },
        regSposInfoDetlPopup: function(guarNo) {
            prntInfoDetl.initPage(guarNo);
        },
        //보호자(사용자)정보 상세 팝업
        regGuarInfoDetlPopup: function(bandId,guarNo,stdtNo) {
            guarInfoDetl.initPage(bandId,guarNo,stdtNo, function(){ guarInfoMng.searchGuarInfoList(true) });
        },
        //학부모정보 상세 팝업
        regPrntInfoDetlPopup: function(bandId, prntNo, sexCd) {
            prntInfoDetl.initPage(bandId, prntNo, sexCd, function(){ guarInfoMng.searchGuarInfoList(true) });
        },
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
                    saveFileLocal(response, 'stdtInfoMng.xls');
                },
                error: function (response)
                {
                    Swal.alert([response, 'error']);
                }
            });
        },

        resetSearchParam: function() {
            let $this = this;
            $this.params = {
                stdtNo:'',
                mmDd:'THIS_MONTH',
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
