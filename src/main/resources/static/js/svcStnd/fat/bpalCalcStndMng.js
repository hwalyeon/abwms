let bpalCalcStndMng = new Vue({
    el: "#bpalCalcStndMng",
    data:
        {
            params:
                {
                    ageYcntFr      : ''  ,     // 나이_년수_FROM
                    sexCd            : ''   ,    // 성별_코드
                    paging          : 'Y',
                    totalCount    : 0  ,
                    rowCount     : 30,
                    currentPage : 1  ,
                    currentIndex: 0
                },
            code:
                {
                    ageYcntFrList      : [],  // 나이_년수_FROM 리스트
                    sexCdList             : [{cdVal:'MALE', cdNm:'남성'},{cdVal:'FEMALE', cdNm:'여성'}] // 성별_리스트
                },
        },
    methods:
        {
            initialize: function()
            {
                let $this = this;

                $this.initCodeList();

                $this.initGrid();

                $this.searchBpalCalcStndList(true);
            },
            initCodeList : function()
            {
                let $this = this;
                // 나이_년수_리스트_조회
                AjaxUtil.post({
                    url: '/svcStnd/fat/bpalCalcStndMng/ageYcntFromList.ab',
                    param: {},
                    success: function(response) {

                        $this.code.ageYcntFrList = [];
                        if ( !!response.rtnData.result && response.rtnData.result.length > 0 ) {
                            $.each(response.rtnData.result, function(index, item) {
                                $this.code.ageYcntFrList.push({'cdVal':item.ageYcntFr});
                            });
                        }
                    },
                    error: function (response) {
                        Swal.alert([response, 'error']);
                    }
                });
            },
            initGrid: function()
            {  
                let $this = this;
                let colModels =
                [
                    {name: "sexCd"               , index: "sexCd"                 , label: "성별코드"                    , width: 80          , align: "center"},
                    {name: "fnGetcdnm"       , index: "fnGetcdnm"        , label: "성별"                            , width: 80         , align: "center"},
                    {name: "ageYcntFr"         , index: "ageYcntFr"          , label: "나이(FROM)"               , width: 80         , align: "center"},
                    {name: "ageYcntTo"        , index: "ageYcntTo"         , label: "나이(TO)"                    , width: 80         , align: "center"},
                    {name: "calcFrml"            , index: "calcFrml"            , label: "계산식        "                , width: 80         , align: "center"},
                    {name: "regDt"                 , index: "regDt"                , label: "등록일자"                    , width: 80         , align: "center"
                    , formatter: function(cellValue, options, rowObject) { return formatDate(cellValue);                                             }},
                    {name: "regTm"               , index: "regTm"               , label: "등록시각"                   , width: 80         , align: "center"
                    , formatter: function(cellValue, options, rowObject) { return formatTime(cellValue);                                             }},
                    {name: "regUserId"          , index: "regUserId"         , label: "등록사용자ID"            , width: 80        , align: "center"},
                    {name: "uptDt"                , index: "uptDt"                , label: "수정일자"                   , width: 80         , align: "center"
                    , formatter: function(cellValue, options, rowObject) { return formatDate(cellValue);                                             }},
                    {name: "uptTm"               , index: "uptTm"               , label: "수정시각"                   , width: 80         , align: "center"
                    , formatter: function(cellValue, options, rowObject) { return formatTime(cellValue);                                             }},
                    {name: "uptUserId"          , index: "uptUserId"         , label: "수정사용자ID"            , width: 80         , align: "center"}
                ];

                $("#bpalCalcStnd_list").jqGrid("GridUnload");
                $("#bpalCalcStnd_list").jqGrid($.extend(true, {}, commonGridOptions(),
                {
                    datatype  : "local",
                    mtype      : 'post'   ,
                    url            : '/svcStnd/fat/bpalCalcStndMng/searchBpalCalcStndList.ab',
                    pager       : '#bpalCalcStnd_pager_list',
                    height      : 405,
                    colModel : colModels,
                    onPaging : function(data) {
                        onPagingCommon(data, this, function(resultMap)
                        {
                            $this.params.currentPage  = resultMap.currentPage;
                            $this.params.rowCount     = resultMap.rowCount;
                            $this.params.currentIndex = resultMap.currentIndex;
                            $this.searchBpalCalcStndList(false);
                        })
                    }
                }));
                resizeJqGridWidth("bpalCalcStnd_list", "bpalCalcStnd_list_wrapper");
            },
            searchBpalCalcStndList: function(isSearch)
            {
                let $this = this;
                let params = $.extend(true, {}, $this.params);

                if ( isSearch )
                {
                    params.currentPage = 1;
                    params.currentIndex = 0;
                }

                $("#bpalCalcStnd_list").setGridParam(
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
                        url: "/svcStnd/fat/bpalCalcStndMng/searchBpalCalcStndList/excel.ab",
                        param: params,
                        success: function(response)
                        {
                            saveFileLocal(response, 'bpalCalcStndMng.xls');
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
                    ageYcntFr      : ''  ,     // 나이_년수_FROM
                    sexCd            : ''   ,    // 성별_코드
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