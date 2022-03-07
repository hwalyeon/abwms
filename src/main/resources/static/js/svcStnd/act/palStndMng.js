let palStndMng = new Vue({
    el: "#palStndMng",
    data:
        {
            params:
                {
                    userId           : ''  ,
                    palCd            : ''  ,    // 신체활동수준_코드
                    palValFr         : ''  ,    // 신체활동수준_값_FROM
                    palValTo         : ''  ,    // 신체활동수준_값_TO
                    paging           : 'Y',
                    totalCount       : 0  ,
                    rowCount         : 30 ,
                    currentPage      : 1  ,
                    currentIndex     : 0
                },
            code:
                {
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
                getCommonCodeList('ACT_LEVL_CD',$this.code.palCdList, function()
                {
                    $this.initGrid();
                    $this.searchPalStndList(true);
                })
            },
            initGrid: function()
            {  
                let $this = this;
                let palCdList = commonGridCmonCd($this.code.palCdList);
                let colModels =
                [
                    {name:"crud"                , index: "crud"                 , label:"crud"                          , hidden:true},
                    {name: "palCd"              , index: "palCd"                , label: "신체활동수준 코드"               , width: 80        , align: "center"  , editable: false},
                    {name: "palNm"              , index: "palNm"                , label: "신체활동수준 명"                 , width: 80       , align: "center" , editable: false},
                    {name: "palValFr"           , index: "palValFr"             , label: "신체활동수준 값 From"            , width: 80        , align: "right" , editable: false   , editrules:{number:true}},
                    {name: "palValTo"           , index: "palValTo"             , label: "신체활동수준 값 To"              , width: 80        , align: "right" , editable: false   , editrules:{number:true}},
                    {name: "palEatRmrk"         , index: "palEatRmrk"           , label: "신체활동수준 섭취 비고"           , width: 700       , align: "center" , editable: false},
                    {name: "regDt"              , index: "regDt"                , label: "등록일자"                       , width: 80       , align: "center"  , formatter: function(cellValue, options, rowObject) { return formatDate(cellValue);  }},
                    {name: "regTm"              , index: "regTm"                , label: "등록시각"                       , width: 80       , align: "center"  , formatter: function(cellValue, options, rowObject) { return formatTime(cellValue);  }},
                    {name: "regUserId"          , index: "regUserId"            , label: "등록사용자 ID"                  , width: 80       , align: "center"},
                    {name: "uptDt"              , index: "uptDt"                , label: "수정일자"                       , width: 80       , align: "center"  , formatter: function(cellValue, options, rowObject) { return formatDate(cellValue);   }},
                    {name: "uptTm"              , index: "uptTm"                , label: "수정시각"                       , width: 80       , align: "center"  , formatter: function(cellValue, options, rowObject) { return formatTime(cellValue);   }},
                    {name: "uptUserId"          , index: "uptUserId"            , label: "수정사용자 ID"                  , width: 80        , align: "center"},
                    {name: "palStndPop"         , index: "palStndPop"           , label: "상세정보 보기"                   , width: 80       , align: "center",
                        formatter: function(cellValue, options, rowObject) {
                            return '<input type="button" class="btn btn-xs btn-outline btn-success" onclick="palStndMng.regPalStndPop(\'' + rowObject.palCd + '\')" value="상세보기" data-toggle="modal" data-target="#palStndDetlPopup" />';
                        }
                    }
                ];

                $("#palStnd_list").jqGrid("GridUnload");
                $("#palStnd_list").jqGrid($.extend(true, {}, commonEditGridOptions(),
                {
                    datatype  : "local",
                    mtype      : 'post',
                    url            : '/svcStnd/act/palStndMng/searchPalStndList.ab',
                    pager       : '#palStnd_pager_list',
                    height      : 405,
                    colModel : colModels,
                    onPaging : function(data) {
                        onPagingCommon(data, this, function(resultMap)
                        {
                            $this.params.currentPage  = resultMap.currentPage;
                            $this.params.rowCount     = resultMap.rowCount;
                            $this.params.currentIndex = resultMap.currentIndex;
                            $this.searchPalStndList(false);
                        })
                    },
                    afterSaveCell : function (rowid , colId , val, e ){
                        if($("#palStnd_list").getRowData(rowid).crud != "C" && $("#palStnd_list").getRowData(rowid).crud != "D" ) {
                            $("#palStnd_list").setRowData(rowid, {crud:"U"});
                        }
                    }
                }));
                resizeJqGridWidth("palStnd_list", "palStnd_list_wrapper");
            },
            searchPalStndList: function(isSearch)
            {
                let $this = this;
                let params = $.extend(true, {}, $this.params);

                if ( isSearch )
                {
                    params.currentPage = 1;
                    params.currentIndex = 0;
                }

                $("#palStnd_list").setGridParam(
                    {
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
            downloadExcel : function()
            {
                let $this = this;
                let params = $.extend(true, {}, $this.params);

                AjaxUtil.post(
                    {
                        dataType: 'binary',
                        url: "/svcStnd/act/palStndMng/searchPalStndList/excel.ab",
                        param: params,
                        success: function(response)
                        {
                            saveFileLocal(response, 'palStndMng.xls');
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
            regPalStndPop: function(palCd) {
                palStndDetl.initPage(palCd);
            },
            resetSearchParam: function() {
                let $this = this;
                $this.params = {
                    palCd            : ''  ,    // 신체활동수준_코드
                    palValFr         : ''  ,    // 신체활동수준_값_FROM
                    palValTo         : ''  ,    // 신체활동수준_값_TO
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