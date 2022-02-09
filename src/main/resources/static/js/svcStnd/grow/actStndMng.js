let actStndMng = new Vue({
    el: "#actStndMng",
    data:
        {
            params:
                {
                    actCd            : ''  ,    // 활동_코드
                    actNm           : ''  ,    // 활동_명
                    actClssCd      : ''  ,    // 활동_분류_코드
                    paging          : 'Y',
                    totalCount    : 0  ,
                    rowCount     : 30,
                    currentPage : 1  ,
                    currentIndex: 0
                },
            code:
                {
                    actClssCdList       : [],  // 활동_분류_코드 리스트
                    actCdNmList       : [],  // 활동_코드_명 리스트
                },
        },
    methods:
        {
            initialize: function()
            {
                let $this = this;

                $this.initCodeList();

                $this.initGrid();

                $this.searchActStndList(true);
            },
            initCodeList : function()
            {

                let $this = this;
                // 활동_분류_코드 리스트_조회
                AjaxUtil.post({
                    url: "/svcStnd/grow/actStndMng/actClssCdList.ab",
                    param: {},
                    success: function(response) {

                        $this.code.actClssCdList = [];
                        if ( !!response.rtnData.result && response.rtnData.result.length > 0 ) {
                            $.each(response.rtnData.result, function(index, item) {
                                $this.code.actClssCdList.push({'cdVal':item.actClssCd});
                            });
                        }
                    },
                    error: function (response) {
                        Swal.alert([response, 'error']);
                    }
                });

                // 활동_코드_명 리스트_조회
                AjaxUtil.post({
                    url: "/svcStnd/grow/actStndMng/actCdNmList.ab",
                    param: {},
                    success: function(response) {
                        $this.code.actCdNmList = [];
                        if ( !!response.rtnData.result && response.rtnData.result.length > 0 ) {
                            $.each(response.rtnData.result, function(index, item) {
                                $this.code.actCdNmList.push({'cdVal':item.actCd, 'cdNm':item.actNm});
                            });
                        }
                    },
                    error: function (response)
                    {
                        Swal.alert([response, 'error']);
                    }
                });
            },
            initGrid: function()
            {  
                let $this = this;
                let colModels =
                [
                    {name: "sortOrd"             , index: "sortOrd"             , label: "정렬순서"                    , width: 80          , align: "center"},
                    {name: "actCd"                 , index: "actCd"               , label: "활동코드"                    , width: 80         , align: "center"},
                    {name: "actNm"               , index: "actNm"              , label: "활동명"                        , width: 80         , align: "center"},
                    {name: "actClssCd"          , index: "actClssCd"         , label: "활동분류코드"             , width: 80         , align: "center"},
                    {name: "actDesc"             , index: "actDesc"            , label: "활동설명"                    , width: 80          , align: "center",  hidden:true},
                    {name: "metVal"              , index: "metVal"             , label: "MET 값"                        , width: 80          , align: "center"},
                    {name: "metMinCfct"      , index: "metMinCfct"       , label: "MET 분당 환산계수"   , width: 80          , align: "center"},
                    {name: "regDt"                , index: "regDt"                , label: "등록일자"                    , width: 80          , align: "center"
                    , formatter: function(cellValue, options, rowObject) { return formatDate(cellValue);                                              }},
                    {name: "regTm"               , index: "regTm"               , label: "등록시각"                   , width: 80          , align: "center"
                    , formatter: function(cellValue, options, rowObject) { return formatTime(cellValue);                                              }},
                    {name: "regUserId"          , index: "regUserId"         , label: "등록사용자ID"            , width: 80          , align: "center"},
                    {name: "uptDt"                , index: "uptDt"                , label: "수정일자"                   , width: 80          , align: "center"
                    , formatter: function(cellValue, options, rowObject) { return formatDate(cellValue);                                              }},
                    {name: "uptTm"               , index: "uptTm"               , label: "수정시각"                   , width: 80          , align: "center"
                    , formatter: function(cellValue, options, rowObject) { return formatTime(cellValue);                                              }},
                    {name: "uptUserId"          , index: "uptUserId"         , label: "수정사용자ID"            , width: 80          , align: "center"}
                ];

                $("#actStnd_list").jqGrid("GridUnload");
                $("#actStnd_list").jqGrid($.extend(true, {}, commonGridOptions(),
                {
                    datatype  : "local",
                    mtype      : 'post',
                    url            : '/svcStnd/grow/actStndMng/actStndList.ab',
                    pager       : '#actStnd_pager_list',
                    height      : 405,
                    colModel : colModels,
                    onPaging : function(data) {
                        onPagingCommon(data, this, function(resultMap)
                        {
                            $this.params.currentPage  = resultMap.currentPage;
                            $this.params.rowCount     = resultMap.rowCount;
                            $this.params.currentIndex = resultMap.currentIndex;
                            $this.searchActStndList(false);
                        })
                    }
                }));
                resizeJqGridWidth("actStnd_list", "actStnd_list_wrapper");
            },
            searchActStndList: function(isSearch)
            {
                let $this = this;
                let params = $.extend(true, {}, $this.params);

                if ( isSearch )
                {
                    params.currentPage = 1;
                    params.currentIndex = 0;
                }

                $("#actStnd_list").setGridParam(
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
                        url: "/svcStnd/grow/actStndMng/searchActStndList/excel.ab",
                        param: params,
                        success: function(response)
                        {
                            saveFileLocal(response, 'actStndMng.xls');
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
                    actCd            : ''  ,    // 활동_코드
                    actClssCd      : ''  ,    // 활동_분류_코드
                    paging          : 'Y',
                    totalCount    : 0  ,
                    rowCount     : 30,
                    currentPage : 1  ,
                    currentIndex: 0
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