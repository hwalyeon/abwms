let ddPalMng = new Vue({
    el: "#ddPalMng",
    data: {
    	params: {
            currFatJudgCd:'',
            prdtFatJudgCd:'',
            sexCd:'',
            ageYcnt:'',
            palValFr:'',
            palValTo:'',
            calQtyFr:'',
            calQtyTo:'',
            ddCalQty:'',
            palCd:'',
            nutrCd:'',
            nutrStatCd:'',
            regDt:'',
            regTm:'',
            regUserId:'',
            uptDt:'',
            uptTm:'',
            uptUserId:'',
    		useYn:'Y',
    		paging: 'Y',
    		totalCount: 0,
            rowCount: 30,
            currentPage: 1,
            currentIndex: 0
    	},
        code:{
            mentDdPalCdList : []
        },
	},

	
    methods: {

        initialize: function() {
        	
        	let $this = this;
        	
        	$this.initCodeList();
        	
        	$this.initGrid();

        	$this.searchDdPalList(true);

        	
        },
        initCodeList: function() {
            let $this = this;
            getCommonCodeList('FAT_JUDG_CD',$this.code.mentDdPalCdList);
        },
        initGrid: function() {
            let $this = this;
        	let colModels = [
                {name: "currFatJudgCd"     , index: "currFatJudgCd"   , label: "현재비만판정코드"   , width: 80, align: "center"},
                {name: "prdtFatJudgCd"     , index: "prdtFatJudgCd"   , label: "예측비만판정코드"     , width: 80, align: "center"},
                {name: "sexCd"             , index: "sexCd"           , label: "성별코드"   , width: 80, align: "center"},
                {name: "ageYcnt"           , index: "ageYcnt"         , label: "나이년수"     , width: 80, align: "center"},
                {name: "palValFr"          , index: "palValFr"        , label: "신체활동수준값 FORM"        , width: 80, align: "center"},
                {name: "palValTo"          , index: "palValTo"        , label: "신체활동수준값 TO"        , width: 80, align: "center"},
                {name: "calQtyFr"          , index: "calQtyFr"        , label: "칼로리량 FORM"        , width: 80, align: "center"},
                {name: "calQtyTo"          , index: "calQtyTo"        , label: "칼로리량 TO"        , width: 80, align: "center"},
                {name: "ddCalQty"          , index: "ddCalQty"        , label: "일일칼로리량"        , width: 80, align: "center"},
                {name: "palCd"             , index: "palCd"           , label: "신체활동수준코드"        , width: 80, align: "center"},
                {name: "nutrCd"            , index: "nutrCd"          , label: "영양소코드"        , width: 80, align: "center"},
                {name: "nutrStatCd"        , index: "nutrStatCd"      , label: "영양섭취상태코드"        , width: 80, align: "center"},
                {name: "regDt"             , index: "regDt"                , label: "등록일자"                    , width: 80          , align: "center"
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

        	console.log("1");
  
            $("#user_list").jqGrid("GridUnload");
           	$("#user_list").jqGrid($.extend(true, {}, commonGridOptions(), {
            	datatype: "local",
            	mtype: 'post',
                url: '/svcStnd/fat/ddPalMng/searchDdPalList.ab',
                pager: '#user_pager_list',
				height: 405,
                colModel: colModels,
                onPaging : function(data) {
                    onPagingCommon(data, this, function(resultMap) {
                        $this.params.currentPage  = resultMap.currentPage;
                        $this.params.rowCount     = resultMap.rowCount;
                        $this.params.currentIndex = resultMap.currentIndex;
                        $this.searchDdPalList(false);
                    })
                }
            }));
            console.log("2");
            resizeJqGridWidth("user_list", "user_list_wrapper");                        
        },
        searchDdPalList: function(isSearch) {
            console.log("3");
			let $this = this;
            let params = $.extend(true, {}, $this.params);
            console.log("4");
            if ( isSearch ) {
                params.currentPage = 1;
                params.currentIndex = 0;
            }
            
			$("#user_list").setGridParam({
                datatype: "json",
                postData: JSON.stringify(params),
                page: 1,
                loadComplete: function (response) {
                    console.log(response.rtnData.result);
                    if ( response.rtnData.result == 0 ) {
                        Swal.alert(['조회할 내용이 없습니다.', "info"]);
                    }
                }
            }).trigger("reloadGrid");
            console.log("5");
		},
        mentDdPalNmVal:function(){
            let $this = this;
        },
        physStrsStatNmVal:function(){
            let $this = this;
        },

        downloadExcel : function()
        {
            let $this = this;
            let params = $.extend(true, {}, $this.params);

            AjaxUtil.post({
                dataType: 'binary',
                url: "/svcStnd/fat/ddPalMng/searchDdPalList/excel.ab",
                param: params,
                success: function(response)
                {
                    saveFileLocal(response, 'ddPalMng.xls');
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
                currFatJudgCd:'',
                prdtFatJudgCd:'',
                sexCd:'',
                ageYcnt:'',
                palValFr:'',
                palValTo:'',
                calQtyFr:'',
                calQtyTo:'',
                ddCalQty:'',
                palCd:'',
                nutrCd:'',
                nutrStatCd:'',
	    		paging: 'Y',
	    		totalCount: 0,
	            rowCount: 30,
	            currentPage: 1,
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