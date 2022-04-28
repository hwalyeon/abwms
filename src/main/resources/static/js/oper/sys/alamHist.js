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

            $this.searchAlamHistList(true);

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
                height: 400,
                colModel: colModels,
                onPaging : function(data) {
                    onPagingCommon(data, this, function(resultMap) {
                        $this.params.currentPage  = resultMap.currentPage;
                        $this.params.rowCount     = resultMap.rowCount;
                        $this.params.currentIndex = resultMap.currentIndex;
                        $this.searchAlamHistList(false);
                    })
                },
            }));

            resizeJqGridWidth("grid_list", "grid_list_wrapper");
        },
        searchAlamHistList: function(isSearch) {

            let $this = this;
            let params = $.extend(true, {}, $this.params);
            if (isSearch) {
                params.currentPage = 1;
                params.currentIndex = 0;
            }

            $("#grid_list").setGridParam({
                datatype: "json",
                postData: JSON.stringify(params),
                page: 1,
                loadComplete: function (response) {
                    if (response.rtnData.result == 0) {
                        Swal.alert(['조회할 내용이 없습니다.', "info"]);
                    }
                }
            }).trigger("reloadGrid");
        },
            //보호자 번호 팝업 Grid 값 부모창 input 값에 삽입
            setData: function(data) {
                console.log(data);
                let $this = this;
                if(data.stdtNo !== undefined && data.stdtNm !== undefined && data.guarNo !== undefined && data.guarNm !== undefined)
                {
                    $this.params.stdtNo = data.stdtNo;
                    $this.params.stdtNm = data.stdtNm;
                    $this.params.guarNo = data.guarNo;
                    $this.params.guarNm = data.guarNm;
                }
                if(data.locNm !== undefined)
                {
                    $this.params.locNm  = data.locNm;
                }
            },

        //학생 및 보호자 정보 search 팝업
        stdtGuarDetlPopup: function() {
            stdtGuarDetl.initialize(this.setData);
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
                mmDd        :'',
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
