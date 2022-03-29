let btchJobHist = new Vue({
    el: "#btchJobHist",
    data: {
        params: {
            emtrDtFr    :'',
            entrDtTo    :'',
            schlNm      :'',
            occrDttm    :'',
            locNm       :'',
            stdtNo      :'',
            stdtNm      :'',
            locNm       :'',
            plcClssCd   :'DZONE',
            latVal      :'',
            lonVal      :'',
            nearLocNo   :'',
            addrBase    :'',
            telNo       :'',
            guarNo      :'',
            guarNm      :'',
            guarTelNo   :'',
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
            mmDdList           : [] ,
            plcClssCdList      : [] , //장소_구분_코드_리스트
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
            getCommonCodeList('GROW_JUDG_CD', $this.code.mentGrowJudgCdList);
            getCommonCodeList('HBIT_STAT_CD', $this.code.hbitStatCdList); //심박_상태_코드_리스트
            getCommonCodeList('TEMP_STAT_CD', $this.code.tempStatCdList); //체온_상태_코드_리스트
            getCommonCodeList('PLC_CLSS_CD' , $this.code.plcClssCdList);  //장소_구분_코드_리스트
            getCommonCodeList('DGEM_STAT_CD', $this.code.dgemStatCdList); //위험감정_상태_코드_리스트
        },
        initGrid: function()
        {
            let $this = this;
            let colModels = [
                {name: "crud"              , index: "crud"              , label: "crud"		 	 , hidden: true                                  },
                {name: "occrDttm"          , index: "occrDttm"          , label: "발생일시"		 , width: 80     , align: "center" },
                {name: "schlNm"            , index: "schlNm"            , label: "학교명"		 , width: 80     , align: "center" },
                {name: "stdtNo"            , index: "stdtNo"            , label: "학생번호"	     , width: 110    , align: "center" },
                {name: "stdtNm"            , index: "stdtNm"            , label: "학생명"		 , width: 80     , align: "center" },
                {name: "locNm"             , index: "locNm"             , label: "장소"		     , width: 80     , align: "center" },
                {name: "plcClssCd"         , index: "plcClssCd"         , label: "장소분류"	     , width: 80     , align: "center" },
                {name: "latVal"            , index: "latVal"            , label: "위도"	         , width: 110    , align: "center" },
                {name: "lonVal"            , index: "lonVal"            , label: "경도"           , width: 110    , align: "center" },
                {name: "nearLocNo"         , index: "nearLocNo"         , label: "위치명"	     , width: 110    , align: "center" },
                {name: "addrBase"          , index: "addrBase"          , label: "주소"		     , width: 110     , align: "center" },
                {name: "telNo"             , index: "telNo"             , label: "학생 전화번호"	 , width: 80     , align: "center" },
                {name: "guarNo"            , index: "guarNo"            , label: "보호자번호"  	 , width: 80     , align: "center" },
                {name: "guarNm"            , index: "guarNm"            , label: "보호자명"	 	 , width: 100    , align: "center" },
                {name: "guarTelNo"         , index: "guarTelNo"         , label: "보호자 전화번호"  , width: 100    , align: "center" }
            ];

            $("#grid_list").jqGrid("GridUnload");
            $("#grid_list").jqGrid($.extend(true, {}, commonGridOptions(), {
                datatype: "local",
                mtype: 'post',
                url: '/oper/dgem/locHist/searchLocHistList.ab',
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
                gridComplete: function() {
                    let grid = this;

                    $(grid).tableRowSpan(["occrDttm","schlNm","stdtNo","stdtNm","locNm","plcClssCd","latVal","lonVal","nearLocNo","addrBase"
                                                 ,"telNo","regDt","regTm","regUserId","uptDt","uptTm","uptUserId"], "stdtNo");
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
        searchLocHistList: function(isSearch) {

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
                url: "/oper/dgem/locHist/searchLocHistList/excel.ab",
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
