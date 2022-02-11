let fatStndMng = new Vue({
    el: "#fatStndMng",
    data:
        {
            params:
                {
                    fatStndVer     : ''  ,    // 비만_기준_번호
                    ageYcnt         : ''  ,     // 나이_년수
                    sexCd            : ''   ,    // 성별_코드
                    paging          : 'Y',
                    totalCount    : 0  ,
                    rowCount     : 30,
                    currentPage : 1  ,
                    currentIndex: 0
                },
            code:
                {
                    fatStndVerList     : [],  // 비만_기준_버전_리스트
                    ageYcntList         : [],  // 나이_년수_리스트
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

                $this.searchFatStndList(true);
            },
            initCodeList : function()
            {

                let $this = this;
                // 나이_년수_리스트_조회
                AjaxUtil.post({
                    url: "/svcStnd/fat/fatStndMng/ageYcntList.ab",
                    param: {},
                    success: function(response) {

                        $this.code.ageYcntList = [];
                        if ( !!response.rtnData.result && response.rtnData.result.length > 0 ) {
                            $.each(response.rtnData.result, function(index, item) {
                                $this.code.ageYcntList.push({'cdVal':item.ageYcnt});
                            });
                        }
                    },
                    error: function (response) {
                        Swal.alert([response, 'error']);
                    }
                });

                // 비만_기준_버전_리스트_조회
                AjaxUtil.post({
                    url: "/svcStnd/fat/fatStndMng/fatStndVerList.ab",
                    param: {},
                    success: function(response) {
                        $this.code.fatStndVerList = [];
                        if ( !!response.rtnData.result && response.rtnData.result.length > 0 ) {
                            $.each(response.rtnData.result, function(index, item) {
                                $this.code.fatStndVerList.push({'cdVal':item.fatStndVer});
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
                    {name: "fatStndVer"        , index: "fatStndVer"         , label: "비만기준버전"          , width: 80         , align: "center"},
                    {name: "fatStndNo"        , index: "fatStndNo"          , label: "비만기준번호"          , width: 80         , align: "center"},
                    {name: "sexCd"                , index: "sexCd"                , label: "성별코드"                  , width: 80          , align: "center",  hidden:true},
                    {name: "fnGetcdnm"       , index: "fnGetcdnm"        , label: "성별"                          , width: 80         , align: "center"},
                    {name: "ageYcnt"            , index: "ageYcnt"             , label: "나이(년)"                    , width: 80         , align: "center"},
                    {name: "ageMcnt"           , index: "ageMcnt"           , label: "나이(개월)"                , width: 80          , align: "center"},
                    {name: "p5Fidx"               , index: "p5Fidx"              , label: "백분위5 비만지수"     , width: 80         , align: "center"},
                    {name: "p50Fidx"             , index: "p50Fidx"            , label: "백분위50 비만지수"   , width: 80         , align: "center"},
                    {name: "p95Fidx"             , index: "p95Fidx"            , label: "백분위95 비만지수"   , width: 80         , align: "center"},
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

                $("#fatStnd_list").jqGrid("GridUnload");
                $("#fatStnd_list").jqGrid($.extend(true, {}, commonGridOptions(),
                {
                    datatype  : "local",
                    mtype      : 'post',
                    url            : '/svcStnd/fat/fatStndMng/searchFatStndList.ab',
                    pager       : '#fatStnd_pager_list',
                    height      : 405,
                    colModel : colModels,
                    onPaging : function(data) {
                        onPagingCommon(data, this, function(resultMap)
                        {
                            $this.params.currentPage  = resultMap.currentPage;
                            $this.params.rowCount     = resultMap.rowCount;
                            $this.params.currentIndex = resultMap.currentIndex;
                            $this.searchFatStndList(false);
                        })
                    }
                }));
                resizeJqGridWidth("fatStnd_list", "fatStnd_list_wrapper");
            },
            searchFatStndList: function(isSearch)
            {
                let $this = this;
                let params = $.extend(true, {}, $this.params);

                if ( isSearch )
                {
                    params.currentPage = 1;
                    params.currentIndex = 0;
                }

                $("#fatStnd_list").setGridParam(
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
            },  /**/
            btnAddRow  :  function() {
                var cnt = $("#growStnd_list").jqGrid("getGridParam", "records")+1;

                var addRow = {crud:"C",
                    growStndNo        :"",
                    growStndVer       :"",
                };
                $("#growStnd_list").addRowData(cnt, addRow);

            },
            btnDelRow : function() {
                //var checkIds = $("#dgem_list").jqGrid("getGridParam","selarrrow") + ""; // 멀티
                let checkIds = $("#growStnd_list").jqGrid("getGridParam","selrow") + "";  // 단건
                if ( checkIds == "" )
                {
                    alert("삭제할 행을 선택해주십시요.");
                    return false;
                }

                let checkId = checkIds.split(",");
                for ( var i in checkId )
                {
                    if ( $("#growStnd_list").getRowData(checkId[i]).crud == "C" )
                    {
                        $("#growStnd_list").setRowData(checkId[i], {crud:"N"});
                        $("#"+checkId[i],"#growStnd_list").css({display:"none"});
                    }
                    else
                    {
                        $("#growStnd_list").setRowData(checkId[i], {crud:"D"});
                        $("#"+checkId[i],"#growStnd_list").css({display:"none"});
                    }
                }
            },
            btnSave  :  function() {
                let $this = this;
                let gridData = commonGridGetDataNew($("#growStnd_list"));

                if(gridData.length > 0)
                {
                    for (let data in gridData)
                    {
                        if(gridData[data].crud === 'C' || gridData[data].crud === 'U')
                        {
                            if(WebUtil.isNull(gridData[data].growStndVer)){
                                Swal.alert(["성장기준버전 필수 입력입니다.", 'warning']);
                                return false;
                            }if(WebUtil.isNull(gridData[data].growStndNo)){
                            Swal.alert(["성장기준번호 필수 입력입니다.", 'warning']);
                            return false;
                        }if(WebUtil.isNull(gridData[data].ageYcnt)){
                            Swal.alert(["나이(년수) 필수 입력입니다.", 'warning']);
                            return false;
                        }if(WebUtil.isNull(gridData[data].ageMcnt)){
                            Swal.alert(["나이(개월수) 필수 입력입니다.", 'warning']);
                            return false;
                        }if(WebUtil.isNull(gridData[data].p3Gidx)){
                            Swal.alert(["백분위3 성장지수 필수 입력입니다.", 'warning']);
                            return false;
                        }if(WebUtil.isNull(gridData[data].p50Gidx)){
                            Swal.alert(["백분위50 성장지수 필수 입력입니다.", 'warning']);
                            return false;
                        }if(WebUtil.isNull(gridData[data].p97Gidx)){
                            Swal.alert(["백분위97 성장지수 필수 입력입니다.", 'warning']);
                            return false;
                        }
                        }
                    }
                }
                else
                {
                    Swal.alert(["저장 대상 데이터가 없습니다.", 'warning']);
                    return false;
                }
                let param = { gridList : []}
                param.gridList = gridData;

                AjaxUtil.post({
                    url: "/svcStnd/grow/growStndMng/saveGrowStnd.ab",
                    param: param,
                    success: function(response) {
                        Swal.alert(['저장이 완료되었습니다.', 'success']).then(function() {
                            $this.searchGrowStndList(true);
                        });
                    },
                    error: function (response) {
                        Swal.alert([response, 'error']);
                    }
                });
            },
            /**/
            downloadExcel : function()
            {
                let $this = this;
                let params = $.extend(true, {}, $this.params);

                AjaxUtil.post(
                    {
                        dataType: 'binary',
                        url: "/svcStnd/fat/fatStndMng/searchFatStndList/excel.ab",
                        param: params,
                        success: function(response)
                        {
                            saveFileLocal(response, 'fatStndMng.xls');
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
                    fatStndVer : ''  ,    // 성장_기준_번호
                    ageYcnt         : ''  ,     // 나이_년수
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