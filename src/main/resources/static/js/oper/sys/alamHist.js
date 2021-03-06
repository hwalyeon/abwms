let alamHist = new Vue({
    el: "#alamHist",
    data: {
        params: {
            entrDtTo    :'',
            sendDttm    :'',
            occrDttm    :'',
            guarNo      :'',
            guarNm      :'',
            guarTelNo   :'',
            stdtNo      :'',
            stdtnm      :'',
            alamChnlCd  :'',
            alamTypeCd  :'',
            alamTitl    :'',
            sendRsltCd  :'',
            alamCntn    :'',
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
            sendRsltCdList      : [] ,
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
            document.getElementById("guarNm").focus();
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
            getCommonCodeList('SEND_RSLT_CD', $this.code.sendRsltCdList);
        },
        initGrid: function()
        {
            let $this = this;
            let colModels = [
                {name: "crud"        , index: "crud"        , label: "crud"          , hidden: true                   },
                {name: "occrDttm"    , index: "occrDttm"    , label: "????????????"      , width:  80   , align: "center" , formatter: function(cellValue, options, rowObject) { return formatTimestamp(cellValue);}},
                {name: "guarNo"      , index: "guarNo"      , label: "???????????????"    , width:  50   , align: "center" },
                {name: "guarNm"      , index: "guarNm"      , label: "????????????"      , width:  50   , align: "center" },
                {name: "guarTelNo"   , index: "guarTelNo"   , label: "?????????????????????", width:  80   , align: "center" , formatter: function(cellValue, options, rowObject) { return phoneFormatter(cellValue);}},
                {name: "stdtNo"      , index: "stdtNo"      , label: "????????????"      , width:  50   , align: "center" },
                {name: "stdtNm"      , index: "stdtNm"      , label: "?????????"        , width:  50   , align: "center" },
                {name: "alamChnlCd"  , index: "alamChnlCd"  , label: "????????????"      , width:  50   , align: "center" },
                {name: "alamTypeCd"  , index: "alamTypeCd"  , label: "????????????"      , width:  50   , align: "center" },
                {name: "alamTitl"    , index: "alamTitl"    , label: "????????????"      , width: 110   , align: "left"   },
                {name: "sendRsltCd"  , index: "sendRsltCd"  , label: "????????????"      , width:  60   , align: "center" },
                {name: "sendDttm"    , index: "sendDttm"    , label: "????????????"      , width:  80   , align: "center" , formatter: function(cellValue, options, rowObject) { return formatTimestamp(cellValue);}},
                {name: "alamCntn"    , index: "alamCntn"    , label: "????????????"      , width: 200   , align: "center" }
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
        // ????????????
        checkSearch: function()
        {
        	let $this = this;
        	$this.searchAlamHistList(true);
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
                        Swal.alert(['????????? ????????? ????????????.', "info"]);
                    }
                }
            }).trigger("reloadGrid");
        },

        //?????? ??? ????????? ?????? search ??????
        stdtGuarDetlPopup: function() {
            let $this = this;
            stdtGuarPopup.initPage({ callback : function(rowData) {
                    $this.params.stdtNo = rowData.stdtNo;
                    $this.params.stdtNm = rowData.stdtNm;
                    $this.params.guarNo = rowData.guarNo;
                    $this.params.guarNm = rowData.guarNm;
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
                mmDd        :'THIS_MONTH',
                entrDtFr    :'',
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
            $this.initValue();
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
