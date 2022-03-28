let locSearchDetl = new Vue({
    el: "#locSearchDetlPopup",
    data: {
        params : {
            plcClssCd:'',
            plcCd:'',
            wordHead1:'',
            wordHead2:'',
            prntNo:'',
            stdtNo:'',
            prntNoNm:'',
            stdtNoNm:'',
            locNm:'',
            addrSpec:'',
            rdPublGuarDiv:'all',
            paging: 'Y',
            totalCount: 0,
            rowCount: 30,
            currentPage: 1,
            currentIndex: 0
        },
        code : {
            plcClssCdList:[],
            plcCdList:[],
            plcCdListFilter:[],
            plcCdListFilterSpec:[],
            wordHead1List: [],
            wordHead2List: [],
            wordHead2ListFilter:[],
            prntNoList: [],
            stdtNoList: [],
            stdtNoListFilter:[],
            prntNoListSepc: [],
            stdtNoListSpec: [],
            stdtNoListFilterSpec:[]
        }
    },

    methods: {

        initialize: function() {
            let $this = this;

            $this.initCodeList();
            setTimeout(function()
            {
                $this.initGrid();
                $this.searchLocInfoList(true);
            },300);
        },
        initCodeList : function() {
            let $this = this;

            getCommonCodeList('PLC_CLSS_CD',$this.code.plcClssCdList, '');
            getCommonCodeList('PLC_CD',$this.code.plcCdList, '');
            $this.code.plcCdListFilter = $this.code.plcCdList;
            $this.code.plcCdListFilterSpec = $this.code.plcCdList;
            $this.searchAddrHeadList();
        },
        initGrid: function() {
            let $this = this;

            let colModels = [
                {name: "locNo"          , index: "locNo"        , label: "학교번호"     , width: 45         , align: "center"},
                {name: "locNm"          , index: "locNm"        , label: "학교명"       , width: 100        , align: "left"  },
                {name: "plcClssNm"      , index: "plcClssNm"    , label: "장소구분"     , width: 46         , align: "center"},
                {name: "plcNm"          , index: "plcNm"        , label: "장소구분상세"  , width: 63         , align: "center"},
            ];

            $("#locsearch_list").jqGrid("GridUnload");
            $("#locsearch_list").jqGrid($.extend(true, {}, commonGridOptions(), {
                datatype: "local",
                mtype: 'post',
                height: 270,
                url: '/oper/dgem/dgemHist/searchLocList.ab',
                pager: "#locsearch_pager_list",
                colModel: colModels,
                onPaging : function(data) {
                    onPagingCommon(data, this, function(resultMap) {
                        $this.params.currentPage    = resultMap.currentPage;
                        $this.params.rowCount       = resultMap.rowCount;
                        $this.params.currentIndex   = resultMap.currentIndex;
                        $this.searchLocInfoList(false);
                    })
                },
                ondblClickRow: function(rowId, status, e) {
                    let item = $('#locsearch_list').jqGrid('getRowData', rowId);
                    dgemHist.setData(item);
                    locHist.setData(item);
                    console.log(item);
                    closeModal($('#locSearchDetlPopup'));
                },
                gridComplete: function (rowId, rowObject) {
                    let grid = this;
                }
            }));

            resizeJqGridWidth("locsearch_list", "locsearch_list_wrapper");
        },

        searchLocInfoList: function(isSearch) {
            let $this = this;
            let params = $.extend(true, {}, this.params);

            if ( isSearch ) {
                params.currentPage  = 1;
                params.currentIndex = 0;
            }

            $this.locInfoSpec = {
                crud:'C',
                rdPublGuarDivSpec: '',
                prntNo:'',
                stdtNo:'',
                locNo: '',
                locNm: '',
                plcClssCd: '',
                plcCd: '',
                latVal: '',
                lonVal: '',
                valdRngeDist: '',
                swstLatVal:'',
                swstLonVal:'',
                nestLatVal:'',
                nestLonVal:'',
                pstno: '',
                addrBase: '',
                addrSpec: '',
                delYn:'',
                paging: 'Y',
                totalCount: 0,
                rowCount: 30,
                currentPage: 1,
                currentIndex: 0
            }
            $("#locsearch_list").setGridParam({
                datatype: "json",
                postData: JSON.stringify(params),
                page: 1,
                loadComplete: function(response) {
                    if ( response["rtnData"].result === 0 ) {
                        Swal.alert(["데이터가 없습니다.", "info"]);
                    }
                }
            }).trigger("reloadGrid");
        },
        searchAddrHeadList : function() {
            let $this = this;

            AjaxUtil.post({
                url: "/svcStnd/loc/locInfoMng/searchLocInfoSelect.ab",
                param: {},
                success: function(response) {
                    $this.code.wordHead1List = [];
                    $this.code.wordHead2List = [];
                    if ( !!response["rtnData"].result && response["rtnData"].result.length > 0 ) {
                        $.each(response["rtnData"].result, function(index, item) {
                            $this.code.wordHead1List.push({'cdVal':item.wordHead1, 'cdNm':item.wordHead1});
                        });
                    }
                    if ( !!response["rtnData"]["result2"] && response["rtnData"]["result2"].length > 0 ) {
                        $.each(response["rtnData"]["result2"], function(index, item) {
                            $this.code.wordHead2List.push({'cdVal':item.wordHead2, 'cdNm':item.wordHead2, 'wordHead1':item.wordHead1});
                        });
                        $this.code.wordHead2ListFilter = $this.code.wordHead2List;
                    }
                },
                error: function (response) {
                    Swal.alert([response, 'error']);
                }
            });
        },

        changeWordHead1 : function () {
            let $this = this;

            if($this.params.wordHead1 === ''){
                $this.code.wordHead2ListFilter = $this.code.wordHead2List;
            }
            else{
                $this.code.wordHead2ListFilter = _.filter($this.code.wordHead2List, function(item) {
                    return item.wordHead1 === $this.params.wordHead1;
                })
            }
        },
        changeWordHead2 : function () {
            let $this = this;

            _.filter($this.code.wordHead2List, function(item) {
                if(item.cdVal === $this.params.wordHead2){
                    $this.params.wordHead1 = item.wordHead1;
                }
            })
        },
        resetSearchParam: function() {
            let $this = this;
            $this.params = {
                locNm: '',
                rowCount     : 30,
                currentPage : 1  ,
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
