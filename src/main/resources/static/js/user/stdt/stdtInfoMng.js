let stdtInfoMng = new Vue({
    el: "#stdtInfoMng",
    data: {
        params: {
            entrDtFr       : '' ,  //가입_일자_From
            entrDtTo       : '' ,  //가입_일자_To
            entrDt         :'',
            guarNo         :'',
            guarNm         :'',
            currLocNm      : '',
            telNo          :'',
            sposNm         :'',
            stdtNo         :'',
            stdtNm         :'',
            plcClssNm      :'',
            locNm          :'',
            dgemStatNm     :'',
            strsIdx        :'',
            gidx        :'',
            fidx         :'',
            bandId         :'',
            telNo          :'',
            blthId         :'',
            sexNm          :'',
            bithDt         :'',
            locNo          :'',
            locNm          :'',
            bithDt         :'',
            bandStatNm     :'',
            mindStrsStatNm :'',
            physStrsStatNm :'',
            useCbeeAmt     :'',
            cbeeBal        :'',
            guarTelNo      :'',
            mmDd           :'THIS_MONTH',
            paging         :'Y',
            totalCount     : 0,
            rowCount       : 30,
            currentPage    : 1,
            currentIndex   : 0
        },
        code:{
            mentGrowJudgCdList : [],
            mmDdList :           []
        },
    },


    methods: {

        initialize: function() {

            let $this = this;

            $this.initValue();

            $this.initCodeList();

            $this.initGrid();

            $this.setDatepicker();

            $this.searchStdtInfoList(true);

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
                {name: "guarNoTemp"        , index: "guarNoTemp"        , label: "보호자번호"			, width: 80     , align: "center"  , hidden: true},
                {name: "guarTelNo"    , index: "guarTelNo"    , label: "보호자전화번호" , width: 80     , align: "center"  , formatter: function(cellValue, options, rowObject){
                        let guarTelNoTemp = phoneFormatter(cellValue);
                        return `<a data-toggle="modal" class="links" data-target="#guarInfoDetlPopup" data-guar data-placement="bottom" title="${cellValue}" data-guar-no="${rowObject.guarNo}" >${cellValue}</a>`;},hidden:true},
                {name: "entrDt"            , index: "entrDt"            , label: "가입일자"		 	, width: 80     , align: "center"  , formatter: function(cellValue, options, rowObject) { return formatDate(cellValue);}, fixed: true},
                {name: "guarNo"            , index: "guarNo"            , label: "보호자번호"         , width: 80     , align: "center"  , formatter: function(cellValue, options, rowObject){
                        return `<a data-toggle="modal" class="links" data-target="#guarInfoDetlPopup" data-guar data-placement="bottom" title="${cellValue}" data-guar-no="${rowObject.guarNo}">${cellValue}</a>`;},fixed:true},
                {name: "guarNm"            , index: "guarNm"            , label: "보호자명"	        , width: 80     , align: "center"  , formatter: function(cellValue, options, rowObject){
                        return `<a data-toggle="modal" class="links" data-target="#guarInfoDetlPopup" data-guar data-placement="bottom" title="${cellValue}" data-guar-no="${rowObject.guarNo}">${cellValue}</a>`;},fixed:true},
                {name: "prntNo"            , index: "prntNo"            , label: "학부모번호"	        , width: 80     , align: "center"  , fixed:true},
                {name: "prntNm"            , index: "prntNm"            , label: "학부모명1"	        , width: 80     , align: "center"  , fixed:true },
                {name: "prntNm2"           , index: "prntNm2"           , label: "학부모명2" 	    , width: 100    , align: "center"  , fixed:true },
                {name: "stdtNo"            , index: "stdtNo"            , label: "학생번호"		 	, width: 80     , align: "center"  , fixed: true},
                {name: "stdtNm"            , index: "stdtNm"            , label: "학생명"		 	, width: 80     , align: "center"  , fixed: true},
                {name: "telNo"            , index: "telNo"              , label: "전화번호"		    , width: 100    , align: "center"  , fixed: true  ,formatter: function(cellValue, options, rowObject) {
                        let telNoTemp = phoneFormatter(cellValue);
                        return `<a data-toggle="modal" class="links" data-target="#bandOpenInfoDetlPopup" data-band data-placement="bottom" title="${telNoTemp}" data-band-id="${rowObject.bandId}">${telNoTemp}</a>`;}},
                {name: "plcClssNm"         , index: "plcClssNm"         , label: "현재위치분류"		, width: 80     , align: "center" , fixed: true},
                {name: "currLocNm"         , index: "currLocNm"         , label: "현재위치(주소)"	    , width: 250    , align: "center" , fixed: true},
                {name: "dgemStatNm"        , index: "dgemStatNm"        , label: "위험감정상태"	 	, width: 80     , align: "center" , fixed: true},
                {name: "strsIdx"           , index: "strsIdx"           , label: "스트레스상태"   	, width: 80     , align: "center" , fixed: true},
                {name: "gidx"           , index: "gidx"           , label: "성장상태"		 	, width: 80     , align: "center" , fixed: true},
                {name: "fidx"            , index: "fidx"            , label: "비만상태"		 	, width: 80     , align: "center" , fixed: true},
                {name: "bandId"           , index: "bandId"             , label: "밴드ID"		    , width: 80     , align: "center" , fixed: true  , formatter: function(cellValue, options, rowObject) {
                        return `<a data-toggle="modal" class="links" data-target="#bandOpenInfoDetlPopup" data-band data-placement="bottom" title="${cellValue}" data-band-id="${rowObject.bandId}">${cellValue}</a>`;}},
                {name: "blthId"           , index: "blthId"             , label: "블루투스ID"         , width: 100    , align: "center" , fixed: true  , formatter: function(cellValue, options, rowObject) {
                        return `<a data-toggle="modal" class="links" data-target="#bandOpenInfoDetlPopup" data-band data-placement="bottom" title="${cellValue}" data-band-id="${rowObject.bandId}">${cellValue}</a>`;}},
                {name: "sexNm"             , index: "sexNm"             , label: "성별"  		 	, width: 80     , align: "center" , fixed: true},
                {name: "bithDt"            , index: "bithDt"            , label: "생년월일"		 	, width: 80     , align: "center"
                    , formatter: function(cellValue, options, rowObject) { return formatDate(cellValue);}           , fixed: true},
                {name: "locNo"             , index: "locNo"             , label: "소속학교번호"	 	, width: 100    , align: "center" , fixed: true},
                {name: "locNm"             , index: "locNm"             , label: "소속학교명"		 	, width: 100    , align: "center" , fixed: true},
                {name: "age"               , index: "age"               , label: "(만)나이"  		, width: 80     , align: "center" , fixed: true},
                {name: "bandOpenStatNm"        , index: "bandOpenStatNm"        , label: "밴드<br/>개통상태"  , width: 60     , align: "center" , fixed: true  , formatter: function(cellValue, options, rowObject) {
                        return `<a data-toggle="modal" class="links" data-target="#bandOpenInfoDetlPopup" data-band data-placement="bottom" title="${cellValue}" data-band-id="${rowObject.bandId}">${cellValue}</a>`;}},
                {name: "bandStatNm"        , index: "bandStatNm"        , label: "밴드<br/>현재상태"  , width: 60     , align: "center" , fixed: true},
                {name: "mindStrsStatNm"    , index: "mindStrsStatNm"    , label: "신체적스트레스상태" 	, width: 110    , align: "center" , fixed: true},
                {name: "physStrsStatNm"    , index: "physStrsStatNm"    , label: "정신적스트레스상태" 	, width: 110    , align: "center" , fixed: true},
                {name: "useTotal"          , index: "useTotal"          , label: "캐시비 적립 총액"	, width: 125    , align: "center"
                    , formatter: function(cellValue, options, rowObject) { return numberFormat(cellValue);}         , fixed: true},
                {name: "saveTotal"         , index: "saveTotal"         , label: "캐시비 사용 금액" 	, width: 110    , align: "center"
                    , formatter: function(cellValue, options, rowObject) { return numberFormat(cellValue);}         , fixed: true},
                {name: "cbeeBal"           , index: "cbeeBal"           , label: "캐시비 현재 잔액" 	, width: 110    , align: "center"
                    , formatter: function(cellValue, options, rowObject) { return numberFormat(cellValue);}         , fixed: true},
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
                {name: "stdtInfoDetlPopup" , index: "stdtInfoDetlPopup" , label: "상세정보보기"        , width: 80    , align: "center",fixed: true,
                    formatter: function(cellValue, options, rowObject) {
                        return '<input type="button" class="btn btn-xs btn-outline btn-success" onclick="stdtInfoMng.stdtInfoDetlPopup(\'' + rowObject.stdtNo + '\' , \'' + rowObject.guarNo + '\' )" value="상세보기" data-toggle="modal" data-target="#stdtInfoDetlPopup" />';
                    }
                }

            ];



            $("#grid_list").jqGrid("GridUnload");
            $("#grid_list").jqGrid($.extend(true, {}, commonGridOptions(), {
                datatype: "local",
                mtype: 'post',
                url: '/user/stdt/stdtInfoMng/searchStdtInfoList.ab',
                pager: '#grid_pager_list',
                height: 385,
                colModel: colModels,
                onPaging : function(data) {
                    onPagingCommon(data, this, function(resultMap) {
                        $this.params.currentPage  = resultMap.currentPage;
                        $this.params.rowCount     = resultMap.rowCount;
                        $this.params.currentIndex = resultMap.currentIndex;
                        $this.searchStdtInfoList(false);
                    })
                },
                gridComplete: function() {
                    let grid = this;

                    $(grid).tableRowSpan(["prntNm","prntNm2","stdtNo","locNo","stdtNm","telNo","plcClssNm",
                                                  "currLoc","currLocNm","dgemStatNm","strsIdx","gidx","fidx",
                                                  "bandId","blthId","sexNm","bithDt","locNm","age","bandStatNm",
                                                  "mindStrsStatNm","physStrsStatNm","useTotal","saveTotal","cbeeBal",
                                                  "prntInfoDetlPopup","stdtInfoDetlPopup","prntNo"], "stdtNo");
                    //밴드 상세 팝업 생성
                    $("#grid_list").find('A.links[data-band]').on('click', function(e) {
                        stdtInfoMng.regBandOpenInfoDetlPopup($(e.target).data('band-id'));
                    });
                    //학부모정보 상세 팝업
                    $("#grid_list").find('A.links[data-prnt]').on('click', function(e) {
                        stdtInfoMng.regPrntInfoDetlPopup($(e.target).data('band-id'),$(e.target).data('prnt-no'),$(e.target).data('sex-cd'))
                    });
                    //보호자(사용자)정보 상세 팝업
                    $("#grid_list").find('A.links[data-guar]').on('click', function(e) {
                        stdtInfoMng.regGuarInfoDetlPopup( $(e.target).data('guar-no'));
                    });
                }
            }));

            resizeJqGridWidth("grid_list", "grid_list_wrapper");
        },


        searchStdtInfoList: function(isSearch) {

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

        stdtInfoDetlPopup: function(stdtNo, guarNo) {
            stdtInfoDetl.initPage(stdtNo, guarNo, function(){ stdtInfoMng.searchStdtInfoList(true)});
        },

        stdtRegDetlPopup: function() {
            stdtRegDetl.initPage();
        },
        regBandOpenInfoDetlPopup: function(bandId) {
            bandOpenInfoDetl.initPage(bandId, function(){  stdtInfoMng.searchStdtInfoList(true) });
        },
        //보호자(사용자)정보 상세 팝업
        regGuarInfoDetlPopup:function(guarNo) {
            guarInfoDetl.initPage( guarNo, function(){stdtInfoMng.searchStdtInfoList(true)});
        },
        //학부모정보 상세 팝업
        regPrntInfoDetlPopup: function(bandId, prntNo, sexCd) {
            prntInfoDetl.initPage(prntNo, sexCd, function(){ stdtInfoMng.searchStdtInfoList(true) });
        },
        downloadExcel : function()
        {
            let $this = this;
            let params = $.extend(true, {}, $this.params);

            AjaxUtil.post({
                dataType: 'binary',
                url: "/user/stdt/stdtInfoMng/searchStdtInfoList/excel.ab",
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
