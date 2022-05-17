let btchJobHist = new Vue({
    el: "#btchJobHist",
    data: {
        params: {
            entrDtFr    :'',
            entrDtTo    :'',
            endDtFr    :'',
            endDtTo    :'',
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
            mmDd2       :'',
            paging      :'Y',
            totalCount  : 0,
            rowCount    : 30,
            currentPage : 1,
            currentIndex: 0
        },
        code:{
            mmDdList           : [] ,
            mmDdList2          : [] ,
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

            $this.setDatepicker();

        },
        initValue: function() {
            let $this = this;
            $this.code.mmDdList  = CodeUtil.getPeriodDateList();
            $this.code.mmDdList2 = CodeUtil.getPeriodDateList();
            const terms = getPeriodDate($this.params.mmDd);
            this.params.entrDtFr = terms.strDt;
            this.params.entrDtTo = terms.endDt;
//          this.params.endDtFr  = terms.strDt;
//          this.params.endDtTo  = terms.endDt;
        },
        mmDdSelect: function()
        {
            let $this = this;
            const terms = getPeriodDate($this.params.mmDd);
            this.params.entrDtFr = terms.strDt;
            this.params.entrDtTo = terms.endDt;
        },
        mmDdSelect2: function()
        {
            let $this = this;
            const terms = getPeriodDate($this.params.mmDd2);
            this.params.endDtFr = terms.strDt;
            this.params.endDtTo = terms.endDt;
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
                {name: "crud"           , index: "crud"           , label: "crud"		 , hidden: true                     },
                {name: "jobHistNo"      , index: "jobHistNo"      , label: "작업이력번호", width:  45     , align: "center" },
                {name: "strtDt"         , index: "strtDt"         , label: "시작일자"	 , width:  50     , align: "center" , formatter: function(cellValue, options, rowObject) { return formatDate(cellValue);}},
                {name: "endDt"          , index: "endDt"          , label: "종료일자"	 , width:  50     , align: "center" , formatter: function(cellValue, options, rowObject) { return formatDate(cellValue);}},
                {name: "jobId"          , index: "jobId"          , label: "작업ID"		 , width:  60     , align: "left"   },
                {name: "jobNm"          , index: "jobNm"          , label: "작업명"		 , width:  70     , align: "left"   },
                {name: "rmrk"           , index: "rmrk"           , label: "비고"		 , width:  80     , align: "left"   },
                {name: "rsltCd"         , index: "rsltCd"         , label: "결과코드"	 , width:  40     , align: "center" },
                {name: "rsltCntn"       , index: "rsltCntn"       , label: "결과내용"	 , width: 300     , align: "left"   }
            ];

            $("#grid_list").jqGrid("GridUnload");
            $("#grid_list").jqGrid($.extend(true, {}, commonGridOptions(), {
                datatype: "local",
                mtype: 'post',
                url: '/oper/sys/btchJobHist/searchBtchJobHistList.ab',
                pager: '#grid_pager_list',
                height: 400,
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
        setDatepicker : function() {
            let $this = this;
            if($this.params.bDPer!=='')
            {$this.params.bDPer = '' ;}

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
            
            $('#endDtFrPicker').datepicker({
                todayBtn: "linked",
                keyboardNavigation: false,
                forceParse: false,
                calendarWeeks: true,
                format: 'yyyy-mm-dd',
                autoclose: true,
                todayHighlight: true,
            }).on("changeDate", function() {
                $this.params.endDtFr = $('#endDtFr').val();
            });
            
            $('#endDtToPicker').datepicker({
                todayBtn: "linked",
                keyboardNavigation: false,
                forceParse: false,
                calendarWeeks: true,
                format: 'yyyy-mm-dd',
                autoclose: true,
                todayHighlight: true,
            }).on("changeDate", function() {
                $this.params.endDtTo = $('#endDtTo').val();
            });
            
        },
        downloadExcel : function()
        {
            let $this = this;
            let params = $.extend(true, {}, $this.params);

            AjaxUtil.post({
                dataType: 'binary',
                url: "/oper/sys/btchJobHist/searchBtchJobHistList/excel.ab",
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
                mmDd2:'',
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
