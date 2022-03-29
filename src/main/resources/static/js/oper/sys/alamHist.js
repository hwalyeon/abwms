let alamHist = new Vue({
    el: "#alamHist",
    data: {
        params: {
            emtrDtFr    :'',
            entrDtTo    :'',
            sendDttm    :'',
            guarNo      :'',
            guarNm      :'',
            guarTelNo   :'',
            stdtNo      :'',
            stdtnm      :'',
            alamChnlCd  :'',
            alamTypeCd  :'',
            alamTitl    :'',
            sendRsltCd  :'',
            regDt       :'',
            regTm       :'',
            regUserId   :'',
            uptDt       :'',
            uptTm       :'',
            uptUserId   :'',
            mmDd        :'THIS_MONTH',
            paging      :'Y',
            totalCount  : 0,
            rowCount    : 30,
            currentPage : 1,
            currentIndex: 0
        },
        code:{
            mmDdList            : [] ,
            alamChnlCdList      : [] ,
            alamTypeCdList      : [] ,
        },
    },


    methods: {

        initialize: function() {

            let $this = this;

            $this.initValue();

            $this.initCodeList();

            $this.initGrid();

            $this.searchLocHistList(true);

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
            getCommonCodeList('ALAM_CHNL_CD', $this.code.alamChnlCdList);
            getCommonCodeList('ALAM_TYPE_CD', $this.code.alamTypeCdList);
        },
        initGrid: function()
        {
            let $this = this;
            let colModels = [
                {name: "crud"              , index: "crud"           , label: "crud"		 , hidden: true                                  },
                {name: "sendDttm"          , index: "sendDttm"       , label: "발생일시"		 , width: 80     , align: "center" },
                {name: "guarNo"            , index: "guarNo"         , label: "보호자번호"	 , width: 80     , align: "center" },
                {name: "guarNm"            , index: "guarNm"         , label: "보호자명"	     , width: 110    , align: "center" },
                {name: "guarTelNo"         , index: "guarTelNo"      , label: "보호자전화번호"	 , width: 80     , align: "center" },
                {name: "stdtNo"            , index: "stdtNo"         , label: "학생번호"		 , width: 80     , align: "center" },
                {name: "stdtNm"            , index: "stdtNm"         , label: "학생명"	     , width: 80     , align: "center" },
                {name: "alamChnlCd"        , index: "alamChnlCd"     , label: "채널종류"	     , width: 110    , align: "center" },
                {name: "alamTypeCd"        , index: "alamTypeCd"     , label: "알림유형"       , width: 110    , align: "center" },
                {name: "alamTitl"          , index: "alamTitl"       , label: "알림제목"	     , width: 110    , align: "center" },
                {name: "sendRsltCd"        , index: "sendRsltCd"     , label: "발송여부"		 , width: 110     , align: "center" }
            ];

            $("#grid_list").jqGrid("GridUnload");
            $("#grid_list").jqGrid($.extend(true, {}, commonGridOptions(), {
                datatype: "local",
                mtype: 'post',
                url: '/oper/sys/alamHist/searchAlamHistList.ab',
                pager: '#grid_pager_list',
                height: 450,
                colModel: colModels,
                onPaging : function(data) {
                    onPagingCommon(data, this, function(resultMap) {
                        $this.params.currentPage  = resultMap.currentPage;
                        $this.params.rowCount     = resultMap.rowCount;
                        $this.params.currentIndex = resultMap.currentIndex;
                        $this.searchLocHistList(false);
                    })
                },
            }));

            resizeJqGridWidth("grid_list", "grid_list_wrapper");
        },
        searchAlamHistList: function(isSearch) {

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
        },

        locSearchDetlPopup: function() {
            locSearchDetl.initialize();
        },

        stdtInfoDetlPopup: function(stdtNo, guarNo) {
            stdtInfoDetl.initPage(stdtNo, guarNo);
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
                url: "/oper/sys/alamHist/searchAlamHistList/excel.ab",
                param: params,
                success: function(response)
                {
                    saveFileLocal(response, 'locHist.xls');
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
                mmDd:'THIS_MONTH',
                plcClssCd:'',
                schlNm:'',
                guarNm:'',
                guarNo:'',
                stdtNm:'',
                stdtNo:'',
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
