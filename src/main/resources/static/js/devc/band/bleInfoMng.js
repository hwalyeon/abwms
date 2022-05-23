let bleInfoMng = new Vue({
    el: "#bleInfoMng",
    data:
    {
        params:
        {
            userId         : '' ,
            bleInstDtFr    : '' ,  //기준_일자From
            bleInstDtTo    : '' ,  //기준_일자To
            eorgNo         : '' ,  //교육시설번호
            eorgNm         : '' ,  //교육시설명
            addr           : '' ,  //주소
            bDPer          : 'PRE_SIX_MONTH' ,  //기준_일자 _이번달
            paging         : 'Y',//
            totalCoun      : 0  ,
            rowCount       : 30 ,
            currentPage    : 1  ,
            currentIndex   : 0
        },
        code:
        {
            bDPerList : []
        },
    },
    methods:
    {
        initialize: function()
        {
            let $this = this;
            $this.initValue();
            $this.setDatepicker();
            $this.initCodeList();
            $this.initGrid();
            $this.searchBleInfoList(true);
        },
        initValue: function()
        {
            let $this    = this;
            $this.userId = SessionUtil.getUserId();
            //이번 달 기본 값 세팅
            $this.code.bDPerList = CodeUtil.getPeriodDateList();
            const terms = getPeriodDate($this.params.bDPer);
            this.params.bleInstDtFr = terms.strDt;
            this.params.bleInstDtTo = terms.endDt;
        }, //기간_선택

        initCodeList : function()
        {
            let $this = this;

        },
        initGrid: function()
        {
            let $this              = this;
            let colModels =
            [
                {name: "bleId"             , index: "bleId"             , label: "BLE ID"       , align:"center" , width:100               },
                {name: "bleInstDt"         , index: "bleInstDt"         , label: "BLE설치일자"  , align:"center" , width:100 , formatter: function(cellValue, options, rowObject) { if(WebUtil.isNull(cellValue)) return ''; else return formatDate(cellValue); }},
                {name: "bleInstTm"         , index: "bleInstTm"         , label: "BLE설치시간"  , align:"center" , width:100 , formatter: function(cellValue, options, rowObject) { if(WebUtil.isNull(cellValue)) return ''; else return formatTime(cellValue); }},
                {name: "plcCd"             , index: "plcCd"             , label: "장소코드"     , align:"center" , width:100 , hidden:true },
                {name: "plcNm"             , index: "plcNm"             , label: "장소명"       , align:"center" , width:100               },
                {name: "locNo"             , index: "locNo"             , label: "위치번호"     , align:"center" , width:100 , hidden:true },
                {name: "locNm"             , index: "locNm"             , label: "위치명"       , align:"left"   , width:100               },
                {name: "addrBase"          , index: "addrBase"          , label: "위치주소"     , align:"left"   , width:200               },
                {name: "rmrk"              , index: "rmrk"              , label: "비고"         , align:"left"   , width:200               },
                {name: "bleDetl"           , index: "bleDetl"           , label: "상세정보보기" , align:"center" , width: 100   ,
                    formatter: function(cellValue, options, rowObject) {
                        return '<input type="button" class="btn btn-xs btn-outline btn-success" onclick="bleInfoMng.regBleInfo(\'' + rowObject.bleId + '\')" value="상세보기" data-toggle="modal" data-target="#bleInfoDetlPopup" />';
                    }
                }
            ];

            $("#bleInfo_list").jqGrid("GridUnload");
            $("#bleInfo_list").jqGrid($.extend(true, {}, commonGridOptions(),
            {
                datatype : "local",
                mtype    : 'post',
                url      : '/devc/band/bleInfoMng/searchBleInfoList.ab',
                pager    : '#bleInfo_pager_list',
                height   : 450,
                autowidth: false,
                colModel : colModels,
                onPaging : function(data) {
                    onPagingCommon(data, this, function(resultMap)
                    {
                        $this.params.currentPage  = resultMap.currentPage;
                        $this.params.rowCount     = resultMap.rowCount;
                        $this.params.currentIndex = resultMap.currentIndex;
                        $this.searchBleInfoList(false);
                    })
                }
            }));
            resizeJqGridWidth("bleInfo_list", "bleInfo_list_wrapper");
        },
        //picker초기화
        setDatepicker : function() {
            let $this = this;

            $('#bleInstDtFrPicker').datepicker({
                todayBtn: "linked",
                keyboardNavigation: false,
                forceParse: false,
                calendarWeeks: true,
                autoclose: true,
                todayHighlight: true,
            }).on("changeDate", function() {
                $this.params.bleInstDtFr = $('#bleInstDtFr').val();
            });

            $('#bleInstDtToicker').datepicker({
                todayBtn: "linked",
                keyboardNavigation: false,
                forceParse: false,
                calendarWeeks: true,
                autoclose: true,
                todayHighlight: true,
            }).on("changeDate", function() {
                $this.params.bleInstDtTo = $('#bleInstDtTo').val();
            });
        },
        //기준_일자_기간_선택
        bDPerSelect: function()
        {
            let $this = this;
            const terms = getPeriodDate($this.params.bDPer);
            this.params.bleInstDtFr = terms.strDt;
            this.params.bleInstDtTo = terms.endDt;
        },

        // 조회검증
        checkSearch: function()
        {
        	let $this = this;
        	$this.searchBleInfoList(true);
        },
        // ble정보 조회
        searchBleInfoList: function(isSearch)
        {
            let $this = this;
            //유효성_검증
            if ( !$this.isValid() ) {
                return false;
            }

            let params = $.extend(true, {}, $this.params);

            if ( isSearch )
            {
                params.currentPage = 1;
                params.currentIndex = 0;
            }
            $("#bleInfo_list").setGridParam({
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
        regBleInfo : function (bleId){
            bleInfoDetl.initPage(bleId);
        },
        //유효성_검증
        isValid: function()
        {
            let $this = this;

            if( ((WebUtil.isNotNull($this.params.bleInstDtFr)) && (WebUtil.isNull($this.params.bleInstDtTo))) || ((WebUtil.isNotNull($this.params.bleInstDtTo)) && (WebUtil.isNull($this.params.bleInstDtFr))) )
            {
                Swal.alert(['시작기준 일자 or 종료기준 일자를 선택하세요.', 'info']);
                return false;
            }
            if( ((WebUtil.isNotNull($this.params.bleInstDtFr) && WebUtil.isNotNull($this.params.bleInstDtTo)) && $this.params.bleInstDtFr > $this.params.bleInstDtTo) )
            {
                Swal.alert(['정확한 기준 일자를 선택하세요.', 'info']);
                return false;
            }
            return true;
        },
        downloadExcel : function()
        {
            let $this = this;
            let params = $.extend(true, {}, $this.params);

            AjaxUtil.post({
                dataType: 'binary',
                url: "/devc/band/bleInfoMng/searchBleInfo/excel.ab",
                param: params,
                success: function(response)
                {
                    saveFileLocal(response, 'bleInfoMng.xls');
                },
                error: function (response)
                {
                    Swal.alert([response, 'error']);
                }
            });
        },

        resetSearchParam: function()
        {
            let $this = this;
            $this.params =
            {
                 userId         : '' ,
                 bleInstDtFr    : '' ,  //기준_일자From
                 bleInstDtTo    : '' ,  //기준_일자To
                 eorgNo         : '' ,  //교육시설번호
                 eorgNm         : '' ,  //교육시설명
                 addr           : '' ,  //주소
                 bDPer          : 'TISH_MONTH' ,  //기준_일자 _이번달
                 paging         : 'Y',
                 totalCoun      : 0  ,
                 rowCount       : 30 ,
                 currentPage    : 1  ,
                 currentIndex   : 0
            }
            //이번 달 기본 값 세팅
            $this.bDPerSelect();
        }
    },
    computed:
    {
    },
    watch:
    {

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