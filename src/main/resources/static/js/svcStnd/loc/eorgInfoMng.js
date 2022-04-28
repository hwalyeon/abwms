let eorgInfoMng = new Vue({
    el: "#eorgInfoMng",
    data:
        {
            params:
                {
                    plcClssCd     : ''  , // 장소_분류_코드
                    plcCd         : ''  , // 장소_코드
                    locNm         : ''  , // 장소_명
                    wordHead1     : ''  , // 단어_헤드_1
                    wordHead2     : ''  , // 단어_헤드_2
                    addrSpec      : ''  , // 상세_주소
                    paging        : 'Y' ,
                    totalCount    : 0   ,
                    rowCount      : 30  ,
                    currentPage   : 1   ,
                    currentIndex  : 0
                },
            code:
                {
                    plcClssCdList : []  , // 장소_구분_코드_리스트
                    plcCdList     : []  , // 장소_코드_리스트
                    wordHead1List : []  , // 단어_헤드_1_리스트
                    wordHead2List : []    // 단어_헤드_2_리스트
                }
        },
    methods:
        {
            initialize: function()
            {
                let $this = this;

                $this.initCodeList();

                $this.initGrid();

                $this.searchEorgInfoList(true);
            },
            initCodeList : function()
            {
                let $this = this;

                // 단어_헤드_리스트
                $this.searchWordHead1List();

                // 장소_구분_코드_리스트
                getCommonCodeList('PLC_CLSS_CD', $this.code.plcClssCdList);

                // 장소_코드_리스트
                AjaxUtil.post({
                    url    : "/svcStnd/loc/eorgInfoMng/searchPlcCdList.ab",
                    param  : {},
                    success: function (response) {

                        $this.code.plcCdList = [];
                        if (!!response.rtnData.result && response.rtnData.result.length > 0) {
                            $.each(response.rtnData.result, function (index, item) {
                                $this.code.plcCdList.push({cdVal: item.plcCd, cdNm: item.plcCdNm})
                            });
                        }
                    },
                    error: function (response) {
                        Swal.alert([response, 'error']);
                    }
                });

            },
            // 단어_헤드_1_리스트_조회
            searchWordHead1List: function()
            {
                let $this = this;
                let params = $.extend(true, {}, $this.params);

                AjaxUtil.post({
                    url    : "/svcStnd/loc/eorgInfoMng/searchWordHeadList.ab",
                    param  : params,
                    success: function (response) {

                        $this.code.wordHead1List = [];
                        if (!!response.rtnData.resultHead1 && response.rtnData.resultHead1.length > 0) {
                            $.each(response.rtnData.resultHead1, function (index, item) {
                                $this.code.wordHead1List.push({cdVal: item.wordHead1})
                            });
                        }
                    },
                    error: function (response) {
                        Swal.alert([response, 'error']);
                    }
                });
            },
            // 단어_헤드_2_리스트_조회
            searchWordHead2List: function()
            {
                let $this = this;
                let params = $.extend(true, {}, $this.params);

                AjaxUtil.post({
                    url    : "/svcStnd/loc/eorgInfoMng/searchWordHeadList.ab",
                    param  : params,
                    success: function (response) {

                        $this.code.wordHead2List = [];
                        if (!!response.rtnData.resultHead2 && response.rtnData.resultHead2.length > 0) {
                            $.each(response.rtnData.resultHead2, function (index, item) {
                                $this.code.wordHead2List.push({cdVal: item.wordHead2})
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
                    { name: "locNo"        , index: "locNo"        , label: "위치 번호"        , width: 50    , align: "center" ,  fixed: true },
                    { name: "locNm"        , index: "locNm"        , label: "위치 명"          , width: 140   , align: "left"   ,  fixed: true },
                    { name: "plcClssCdNm"  , index: "plcClssCdNm"  , label: "장소 분류 코드명" , width: 80    , align: "center" ,  fixed: true },
                    { name: "plcCdNm"      , index: "plcCdNm"      , label: "장소 코드명 "     , width: 80    , align: "center" ,  fixed: true },
                    { name: "roadAddr"     , index: "roadAddr"     , label: "도로명 주소"      , width: 260   , align: "left"   ,  fixed: true },
                    { name: "jibnAddr"     , index: "jibnAddr"     , label: "지번 주소"        , width: 260   , align: "left"   ,  fixed: true },
                    { name: "latVal"       , index: "latVal"       , label: "위도 값"          , width: 100   , align: "left"   ,  fixed: true },
                    { name: "lonVal"       , index: "lonVal"       , label: "경도 값"          , width: 100   , align: "left"   ,  fixed: true },
                    { name: "mngOrgnNm"    , index: "mngOrgnNm"    , label: "관리 기관 명"     , width: 150   , align: "left"   ,  fixed: true },
                    { name: "mngPolcNm"    , index: "mngPolcNm"    , label: "관할 경찰서 명"   , width: 80    , align: "center" ,  fixed: true },
                    { name: "cctvYn"       , index: "cctvYn"       , label: "CCTV 여부"        , width: 80    , align: "center" ,  fixed: true },
                    { name: "cctvCnt"      , index: "cctvCnt"      , label: "CCTV 대수"        , width: 80    , align: "center" ,  fixed: true },
                    { name: "roadWdthDesc" , index: "roadWdthDesc" , label: "도로 넓이 설명"   , width: 80    , align: "center" ,  fixed: true },
                    { name: "dataStndDt"   , index: "dataStndDt"   , label: "자료 기준 일자"   , width: 80    , align: "center" ,  fixed: true
                      , formatter: function(cellValue, options, rowObject) { return formatDate(cellValue);  }},
                    { name: "provOrgnCd"   , index: "provOrgnCd"   , label: "제공 기관 코드"   , width: 80    , align: "center"  ,  fixed: true },
                    { name: "provOrgnNm"   , index: "provOrgnNm"   , label: "제공 기관 명"     , width: 120   , align: "center"  ,  fixed: true },
                ];

                $("#eorgInfo_list").jqGrid("GridUnload");
                $("#eorgInfo_list").jqGrid($.extend(true, {}, commonGridOptions(),
                {
                    datatype : "local",
                    mtype    : 'post',
                    url      : '/svcStnd/loc/eorgInfoMng/searchEorgInfoList.ab',
                    pager    : '#eorgInfo_pager_list',
                    height   : 405,
                    autowidth: false,
                    colModel : colModels,
                    onPaging : function(data) {
                        onPagingCommon(data, this, function(resultMap)
                        {
                            $this.params.currentPage  = resultMap.currentPage;
                            $this.params.rowCount     = resultMap.rowCount;
                            $this.params.currentIndex = resultMap.currentIndex;
                            $this.searchEorgInfoList(false);
                        })
                    }
                }));
                resizeJqGridWidth("eorgInfo_list", "eorgInfo_list_wrapper");
            },
            /* 교육시설_정보_조회 */
            searchEorgInfoList: function(isSearch)
            {
                let $this = this;
                let params = $.extend(true, {}, $this.params);

                if ( isSearch )
                {
                    params.currentPage = 1;
                    params.currentIndex = 0;
                }
                $("#eorgInfo_list").setGridParam(
                    {
                        datatype    : "json",
                        postData    : JSON.stringify(params),
                        page        : 1,
                        loadComplete: function (response)

                        {
                            if ( response.rtnData.result == 0 )
                            {
                                Swal.alert(['조회할 내용이 없습니다.', "info"]);
                            }
                        }
                    }).trigger("reloadGrid");
            },
            selectWordHead1: function()
            {
                let $this = this;

                $this.searchWordHead2List();
            },
            /* 교육시설_정보_엑셀_다운로드*/
            downloadExcel : function()
            {
                let $this = this;
                let params = $.extend(true, {}, $this.params);

                AjaxUtil.post(
                    {
                        dataType: 'binary',
                        url     : "/svcStnd/loc/eorgInfoMng/searchEorgInfoList/excel.ab",
                        param   : params,
                        success : function(response)
                        {
                            saveFileLocal(response, 'eorgInfo.xls');
                        },
                        error: function (response)
                        {
                            Swal.alert([response, 'error']);
                        }
                    });
            },
            resetSearchParam: function() {
                let $this = this;
                $this.params =
                {
                    plcClssCd     : ''  , // 장소_분류_코드
                    plcCd         : ''  , // 장소_코드
                    locNm         : ''  , // 장소_명
                    wordHead1     : ''  , // 단어_헤드_1
                    wordHead2     : ''  , // 단어_헤드_2
                    addrSpec      : ''  , // 상세_주소
                    paging        : 'Y' ,
                    totalCount    : 0   ,
                    rowCount      : 30  ,
                    currentPage   : 1   ,
                    currentIndex  : 0

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