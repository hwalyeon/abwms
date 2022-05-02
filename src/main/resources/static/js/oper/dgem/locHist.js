let locHist = new Vue({
    el: "#locHist",
    data: {
        params: {
            emtrDtFr    :'',        //일자_From
            entrDtTo    :'',        //일자_To
            schlNm      :'',        //학교명
            occrDttm    :'',        //발생일시
            locNm       :'',        //장소
            stdtNo      :'',        //학생번호
            stdtNm      :'',        //학생명
            plcClssCd   :'DZONE',   //장소분류
            latVal      :'',        //위도
            lonVal      :'',        //경도
            nearLocNo   :'',        //위치명
            addrBase    :'',        //주소
            telNo       :'',        //학생 전화번호
            guarNo      :'',        //보호자번호
            guarNm      :'',        //보호자명
            guarTelNo   :'',        //보호자 전화번호
            regDt       :'',        //등록일자
            regTm       :'',        //등록시각
            regUserId   :'',        //등록사용자ID
            uptDt       :'',        //수정일자
            uptTm       :'',        //수정시각
            uptUserId   :'',        //수정사용자ID
            mmDd        :'THIS_MONTH',
            paging      :'Y',
            totalCount  : 0,
            rowCount    : 30,
            currentPage : 1,
            currentIndex: 0
        },
        code:{
            mmDdList           : [] , //일자_리스트
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
            getCommonCodeList('PLC_CLSS_CD' , $this.code.plcClssCdList);  //장소_구분_코드_리스트
        },
        initGrid: function()
        {
            let $this = this;
            let colModels = [
                {name: "crud"              , index: "crud"              , label: "crud"		 	 , hidden: true                    },
                {name: "occrDttm"          , index: "occrDttm"          , label: "발생일시"		 , width: 80     , align: "center" },
                {name: "schlNm"            , index: "schlNm"            , label: "학교명"		 , width: 80     , align: "center" },
                {name: "stdtNo"            , index: "stdtNo"            , label: "학생번호"	     , width: 110    , align: "center" },
                {name: "stdtNm"            , index: "stdtNm"            , label: "학생명"		 , width: 80     , align: "center" },
                {name: "locNm"             , index: "locNm"             , label: "장소"		     , width: 80     , align: "center" },
                {name: "plcClssCd"         , index: "plcClssCd"         , label: "장소분류"	     , width: 80     , align: "center" },
                {name: "latVal"            , index: "latVal"            , label: "위도"	         , width: 110    , align: "center" },
                {name: "lonVal"            , index: "lonVal"            , label: "경도"           , width: 110    , align: "center" },
                {name: "nearLocNo"         , index: "nearLocNo"         , label: "위치명"	     , width: 110    , align: "center" },
                {name: "addrBase"          , index: "addrBase"          , label: "주소"		     , width: 110     , align: "center"},
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
                height: 399,
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
        //(학생 및 보호자 번호 , 학교명) 팝업 Grid 값 부모창 input 값에 삽입
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
        //학생 및 보호자 search 팝업
        stdtGuarDetlPopup: function() {
            stdtGuarDetl.initialize(this.setData);
        },
        //학교명 search 팝업
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
        //초기화
        resetSearchParam: function() {
            let $this = this;
            $this.params = {
                mmDd:'',
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
