let locSearchPopup = new Vue({
    el: "#locSearchPopup",
    data: {
        params : {
            wordHead1:'',
            wordHead2:'',
            locNm:'',
            addrBase:'',
            paging  :'Y',
            totalCount: 0,
            rowCount: 30,
            currentPage: 1,
            currentIndex: 0
        },
        code : {
            wordHead1List: [],
            wordHead2List: [],
            wordHead2ListFilter:[]
        },
        callback: null
    },

    methods: {

        initialize: function() {
            let $this = this;
            $this.initCodeList();
            $this.initModal();
        },

        initModal: function() {
            let $this = this;
            $("#locSearchPopup").off("shown.bs.modal").on("shown.bs.modal", function(e) {
                $this.initGrid();
                $this.searchLocInfoList(true);
            });
        },

        initpage : function(vo){
            let $this = this;
            if(vo != null){
                $this.callback = vo.callback;
            }
        },

        initCodeList : function() {
            let $this = this;
            $this.searchAddrHeadList();
        },
        initGrid: function() {
            let $this = this;

            let colModels = [
                {name: "locNo"          , index: "locNo"        , label: "교육시설번호"  , width: 45         , align: "center" , hideen:true},
                {name: "locNm"          , index: "locNm"        , label: "교육시설명"    , width: 100        , align: "left"  },
                {name: "plcClssNm"      , index: "plcClssNm"    , label: "장소구분"     , width: 46         , align: "center"},
                {name: "plcNm"          , index: "plcNm"        , label: "장소구분상세"  , width: 63         , align: "center"},
                {name: "addrBase"       , index: "addrBase"     , label: "주소"         , width: 63         , align: "center"},
            ];

            $("#locSearch_list").jqGrid("GridUnload");
            $("#locSearch_list").jqGrid($.extend(true, {}, commonGridOptions(), {
                datatype: "local",
                mtype: 'post',
                height: 270,
                url: '/popup/popupMng/searchLocList.ab',
                pager: "#locSearch_pager_list",
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
                    $this.chooseRow();
                }
            }));

            resizeJqGridWidth("locSearch_list", "locSearch_list_wrapper");
        },

        chooseRow: function() {
            let $this = this;

            // 콜백함수 실행
            if ( typeof $this.callback === "function")
            {
                var rowData = $("#locSearch_list").getRowData($("#locSearch_list").jqGrid("getGridParam","selrow") + "");

                $this.callback(rowData);

                closeModal($('#locSearchPopup'));
            }
        },

        searchLocInfoList: function(isSearch) {
            let $this = this;
            let params = $.extend(true, {}, $this.params);

            if ( isSearch ) {
                params.currentPage  = 1;
                params.currentIndex = 0;
            }

            $("#locSearch_list").setGridParam({
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
                wordHead1   : '',
                wordHead2   : '',
                locNm       : '',
                addrBase    : '',
                paging      :'Y',
                rowCount    : 30,
                currentPage : 1 ,
                currentIndex: 0,
                totalCount  : 0
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
