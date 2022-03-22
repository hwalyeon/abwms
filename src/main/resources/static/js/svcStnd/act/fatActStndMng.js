let fatActStndMng = new Vue({
    el: "#fatActStndMng",
    data:
        {
            params:
                {
                    userId           : '' ,
                    currFatJudgCd    : '' ,    // 현재_비만_판정_코드
                    currFatJudgNm    : '' ,    // 현재_비만_판정_명
                    prdtFatJudgCd    : '' ,    // 예측_비만_판정_코드
                    prdtFatJudgNm    : '' ,    // 예측_비만_판정_명
                    palCd            : '' ,    // 신체활동수준_코드
                    palNm            : '' ,    // 신체활동수준_명
                    fatActRmrk       : '' ,    // 비만_활동_비고
                    paging           : 'Y',
                    totalCount       : 0  ,
                    rowCount         : 30 ,
                    currentPage      : 1  ,
                    currentIndex     : 0
                },
            code:
                {
                    fatJudgCdList    : [],
                    palCdList        : []
                },
        },
    methods:
        {
            initialize: function()
            {
                let $this = this;

                $this.initValue();
                $this.initCodeList();
            },
            initValue: function()
            {
              let $this = this;
              $this.userId = SessionUtil.getUserId();
            },
            initCodeList : function()
            {
                let $this = this;
                getCommonCodeList('FAT_JUDG_CD',$this.code.fatJudgCdList, '');
                getCommonCodeList('PAL_CD',$this.code.palCdList, function()
                {
                    $this.initGrid();
                    $this.searchFatActStndList(true);
                })
            },
            initGrid: function()
            {  
                let $this = this;
                let colModels =
                [
                    {name: "crud"               , index: "crud"                 , label:"crud"                          , hidden:true},
                    {name: "currFatJudgCd"      , index: "currFatJudgCd"        , label: "현재비만판정 코드"               , width: 80        , align: "center"  , editable: false},
                    {name: "currFatJudgNm"      , index: "currFatJudgNm"        , label: "현재비만판정 명"                 , width: 80       , align: "center"   , editable: false},
                    {name: "prdtFatJudgCd"      , index: "prdtFatJudgCd"        , label: "예측비만판정 코드"               , width: 80        , align: "center"  , editable: false},
                    {name: "prdtFatJudgNm"      , index: "prdtFatJudgNm"        , label: "예측비만판정 명"                 , width: 80       , align: "center"   , editable: false},
                    {name: "palCd"              , index: "palCd"                , label: "신체활동수준 코드"               , width: 80        , align: "center"  , editable: false},
                    {name: "palNm"              , index: "palNm"                , label: "신체활동수준 명"                 , width: 80       , align: "center"   , editable: false},
                    {name: "fatActRmrk"         , index: "fatActRmrk"           , label: "비만활동 비고"                  , width: 500       , align: "center"  , editable: false},
                    {name: "regDt"              , index: "regDt"                , label: "등록일자"                       , width: 80       , align: "center"  , formatter: function(cellValue) { return formatDate(cellValue);  }},
                    {name: "regTm"              , index: "regTm"                , label: "등록시각"                       , width: 80       , align: "center"  , formatter: function(cellValue) { return formatTime(cellValue);  }},
                    {name: "regUserId"          , index: "regUserId"            , label: "등록사용자 ID"                  , width: 80        , align: "center"}  ,
                    {name: "uptDt"              , index: "uptDt"                , label: "수정일자"                       , width: 80       , align: "center"  , formatter: function(cellValue) { return formatDate(cellValue);   }},
                    {name: "uptTm"              , index: "uptTm"                , label: "수정시각"                       , width: 80       , align: "center"  , formatter: function(cellValue) { return formatTime(cellValue);   }},
                    {name: "uptUserId"          , index: "uptUserId"            , label: "수정사용자 ID"                  , width: 80        , align: "center"} ,
                    {name: "fatActStndPop"     , index: "fatActStndPop"         , label: "상세정보 보기"                   , width: 80       , align: "center"  ,
                        formatter: function(cellValue, options, rowObject) {
                            return '<input type="button" class="btn btn-xs btn-outline btn-success" onclick="fatActStndMng.regFatActStndPop(\'' + rowObject.currFatJudgCd + '\', \'' + rowObject.prdtFatJudgCd + '\', \'' + rowObject.palCd + '\')" value="상세보기" data-toggle="modal" data-target="#fatActStndDetlPopup" />';
                        }
                    }
                ];

                $("#fatActStnd_list").jqGrid("GridUnload");
                $("#fatActStnd_list").jqGrid($.extend(true, {}, commonEditGridOptions(),
                {
                    datatype    : "local",
                    mtype       : 'post',
                    url         : '/svcStnd/act/fatActStndMng/searchFatActStndList.ab',
                    pager       : '#fatActStnd_pager_list',
                    height      : 405,
                    colModel : colModels,
                    onPaging : function(data) {
                        onPagingCommon(data, this, function(resultMap)
                        {
                            $this.params.currentPage  = resultMap.currentPage;
                            $this.params.rowCount     = resultMap.rowCount;
                            $this.params.currentIndex = resultMap.currentIndex;
                            $this.searchFatActStndList(false);
                        })
                    },
                    afterSaveCell : function (rowid , colId , val, e ){
                        if("C" !== $("#fatActStnd_list").getRowData(rowid).crud && "D" !== $("#fatActStnd_list").getRowData(rowid).crud) {
                            $("#fatActStnd_list").setRowData(rowid, {crud:"U"});
                        }
                    }
                }));
                resizeJqGridWidth("fatActStnd_list", "fatActStnd_list_wrapper");
            },
            searchFatActStndList: function(isSearch)
            {
                let $this = this;
                let params = $.extend(true, {}, $this.params);

                if ( isSearch )
                {
                    params.currentPage = 1;
                    params.currentIndex = 0;
                }

                $("#fatActStnd_list").setGridParam(
                    {
                        datatype    : "json",
                        postData    : JSON.stringify(params),
                        page        : 1,
                        loadComplete: function (response)

                        {
                            if (0 === response["rtnData"].result)
                            {
                                Swal.alert(['조회할 내용이 없습니다.', "info"]);
                            }
                        }
                    }).trigger("reloadGrid");
            },
            downloadExcel : function()
            {
                let $this = this;
                let params = $.extend(true, {}, $this.params);

                AjaxUtil.post(
                    {
                        dataType    : 'binary',
                        url         : "/svcStnd/act/fatActStndMng/searchFatActStndList/excel.ab",
                        param: params,
                        success: function(response)
                        {
                            saveFileLocal(response, 'fatActStndMng.xls');
                        },
                        error: function (response)
                        {
                            Swal.alert([response, 'error']);
                        }
                    });
            },
            palStndNmVal:function(){
                let $this = this;
            },
            currFatJudgStndNmVal:function(){
                let $this = this;
            },
            prdtFatJudgStndNmVal:function(){
                let $this = this;
            },
            regFatActStndPop: function(currFatJudgCd, prdtFatJudgCd, palCd) {
                fatActStndDetl.initPage(currFatJudgCd, prdtFatJudgCd, palCd);
            },
            resetSearchParam: function() {
                let $this = this;
                $this.params = {
                    currFatJudgCd    : '' ,    // 현재_비만_판정_코드
                    prdtFatJudgCd    : '' ,    // 예측_비만_판정_코드
                    palCd            : '' ,    // 신체활동수준_코드
                    paging           : 'Y',
                    totalCount       : 0  ,
                    rowCount         : 30 ,
                    currentPage      : 1  ,
                    currentIndex     : 0
                }
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