let foodInfoDetl = new Vue({
    el: "#foodInfoDetlPopup",
    data:
    {
        codeCnt : 0,
        foodElemList : [],
        params:
        {
            crud         : 'C',
            foodNo       : '' ,
            foodLclsNm   : '' ,
            foodMclsNm   : '' ,
            foodNm       : '' ,
            otimEatQty   : '' ,
            eatUnitCd    : '' ,
            totalCount   : 0  ,
            rowCount     : 3000 ,
            currentPage  : 1 ,
            currentIndex : 0
        },
        code:
        {
            eatUnitCdList : []
        },
    },
    methods:
    {
        initialize: function()
        {
            let $this = this;
            $this.initCodeList();
        //    $this.initModal();
        },
        initCodeList : function() {
            let $this = this;
            getCommonCodeList('EAT_UNIT_CD',$this.code.eatUnitCdList);
        },

        initGrid: function()
        {
            let colModels =
            [
                {name: "crud"             , index: "crud"          , label: "crud"       , hidden:true},
                {name: "foodNo"           , index: "foodNo"        , label: "식품번호"     , width: 50        , align: "center", hidden:true},
                {name: "nutrCd"           , index: "nutrCd"        , label: "영양소코드"   , width: 50        , align: "center"},
                {name: "nutrNm"           , index: "nutrNm"        , label: "영양소명"     , width: 50        , align: "center"},
                {name: "nutrQty"          , index: "nutrQty"       , label: "영양소용량"   , width: 50        , align: "left" , editable :true, editrules:{number:true}}
            ];

            $("#foodNutrInfo_list").jqGrid("GridUnload");
            $("#foodNutrInfo_list").jqGrid($.extend(true, {}, commonEditGridOptions(),
            {
                datatype  : "local",
                mtype     : 'post',
                url       : '/svcStnd/food/foodInfoMng/searchFoodElemList.ab',
                shrinkToFit: true,
                pager       : '#foodNutrInfo_pager_list',
                height      : 200,
                colModel : colModels,
                rowNum : 3000
            }));
            resizeJqGridWidth("foodNutrInfo_list", "foodNutrInfo_list_wrapper");
        },

        initModal: function()
        {
            let $this = this;
            $("#foodInfoDetlPopup").off("shown.bs.modal").on("shown.bs.modal", function(e) {
                $this.initGrid();
            });
        },

        initPage: function(foodNo) {
            let $this = this;
            $this.resetSearchParam();
            $this.params.foodNo = foodNo;

            setTimeout(function()
            {
                $this.initGrid();
                $this.searchFoodElemList();
            },300);
        },

        searchFoodElemList: function()
        {
            const $this = this;

            $("#foodNutrInfo_list").setGridParam({
                datatype: "json",
                postData: JSON.stringify( $this.params),
                page: 1,
                loadComplete: function (response)
                {
                    if(!!response.rtnData.foodInfo){
                        $this.params.crud = 'U';
                        $.each(response.rtnData.foodInfo, function(key, val){
                            $this.params[key] = val;
                        });
                    }
                }
            }).trigger("reloadGrid");
        },

        saveInfo  :  function() {
            let $this = this;

            //let gridData = commonGridGetDataNew($("#foodNutrInfo_list"));
            commonGridCancelEdit($("#foodNutrInfo_list"));

            var gridData = $("#foodNutrInfo_list").jqGrid('getRowData');

            if(gridData.length > 0) {
                for (let data in gridData) {
                    if (WebUtil.isNull(gridData[data].nutrQty)) {
                        Swal.alert(["영양소용량은 필수 입력입니다.", 'warning']);
                        return false;
                    }
                }
            }

            let param = { foodInfo : {} , gridData : []}
            param.gridData = gridData;
            param.foodInfo = $this.params;

            AjaxUtil.post({
                url: "/svcStnd/food/foodInfoMng/saveFoodInfo.ab",
                param: param,
                success: function(response) {
                    Swal.alert(['저장이 완료되었습니다.', 'success']).then(function() {
                        $("#foodNutrInfo_list").jqGrid('clearGridData', true);
                        $this.searchFoodElemList(true);
                    });
                },
                error: function (response) {
                    Swal.alert([response, 'error']);
                }
            });
        },

        deleteInfo: function() {

            let $this = this;

            $this.params.crud = 'D';

            AjaxUtil.post({
                url: "/svcStnd/food/foodInfoMng/saveFoodInfo.ab",
                param: $this.params,
                success: function(response) {
                    Swal.alert(['삭제가 완료되었습니다.', 'success']).then(function() {
                        closeModal($('#foodInfoDetlPopup'));
                        foodInfoMng.searchFoodInfoList(true);
                    });
                },
                error: function (response) {
                    Swal.alert([response, 'error']);
                }
            });
        },

        resetSearchParam: function()
        {
            let $this = this;
            $this.params =
                {
                    crud         : 'C',
                    foodNo       : '' ,
                    foodLclsNm   : '' ,
                    foodMclsNm   : '' ,
                    foodNm       : '' ,
                    qtimEatQty   : '' ,
                    eatUnitCd    : '' ,
                    paging       : 'N',
                    totalCount   : 0  ,
                    rowCount     : 3000,
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