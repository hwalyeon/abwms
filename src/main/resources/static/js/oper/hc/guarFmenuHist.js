let guarFmenuHist = new Vue({
    el: "#guarFmenuHist", //보호자_식단표_현황
    data:
    {
    	params:
        {
            userId        : '' ,
            fmenuNm       : '' , //식단표_명
            mmelYn        : '' , //아침_여부
            amelYn        : '' , //점심_여부
            emelYn        : '' , //저녁_여부
            smelYn        : '' , //간식_여부
            guarNo        : '' , //보호자_번호
            guarNm        : '' , //보호자_명
    		paging        : 'Y',
    		totalCount    : 0  ,
            rowCount      : 30 ,
            currentPage   : 1  ,
            currentIndex  : 0
        },
        code:
        {
        },
	},
    methods:
    {
        initialize: function()
        {
        	let $this = this;

            $this.initValue();
        	$this.initGrid();
            $this.searchGuarFmenuHistList(true);
        },
        initValue: function()
        {
            let $this = this;
            $this.userId = SessionUtil.getUserId();
        },
        initGrid: function()
        {
            let $this = this;
        	let colModels =
            [   {name: "guarNo"    , index: "guarNo"   , label: "보호자 번호"  , width: 50 , align: "center" },
                {name: "guarNm"    , index: "guarNm"   , label: "보호자 명"    , width: 50 , align: "center" },
                {name: "fmenuSeq"  , index: "fmenuSeq" , label: "식단표 번호"  , width: 50 , align: "center" },
                {name: "fmenuNm"   , index: "fmenuNm"  , label: "식단표 명"    , width: 50 , align: "center" },
                {name: "mmelYn"    , index: "mmelYn"   , label: "아침 여부"    , width: 50 , align: "center" },
                {name: "amelYn"    , index: "amelYn"   , label: "점심 여부"    , width: 50 , align: "center" },
                {name: "emelYn"    , index: "emelYn"   , label: "저녁 여부"    , width: 50 , align: "center" },
                {name: "smelYn"    , index: "smelYn"   , label: "간식 여부"    , width: 50 , align: "center" },
                {name: "feqUse"    , index: "feqUse"   , label: "이용빈도(수)" , width: 50 , align: "center" },
                ];
            $("#guarFmenuHist_list").jqGrid("GridUnload");
           	$("#guarFmenuHist_list").jqGrid($.extend(true, {}, commonGridOptions(),
            {
            	datatype : "local",
            	mtype    : 'post'  ,
                url      : '/oper/hc/guarFmenuHist/guarFmenuHistList.ab',
                pager    : '#guarFmenuHist_pager_list',
				height   : 429     ,
                colModel : colModels,
                onPaging : function(data)
                {
                    onPagingCommon(data, this, function(resultMap)
                    {
                        $this.params.currentPage  = resultMap.currentPage;
                        $this.params.rowCount      = resultMap.rowCount;
                        $this.params.currentIndex = resultMap.currentIndex;
                        $this.searchGuarFmenuHistList(false);
                    })
                },
                gridComplete: function () {
                    let grid = this;

                    $(grid).tableRowSpan(["guarNo","guarNm"], "guarNo");

                }
            }));
            resizeJqGridWidth("guarFmenuHist_list", "guarFmenuHist_list_wrapper");
        },
        //보호자_식단표_현황 리스트 조회
        searchGuarFmenuHistList: function(isSearch)
        {
			let $this     = this;
            let params = $.extend(true, {}, $this.params);
            if ( isSearch )
            {
                params.currentPage = 1;
                params.currentIndex = 0;
            }
			$("#guarFmenuHist_list").setGridParam(
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
        //보호자_식단표_현황 리스트 엑셀 다운로드
		downloadExcel : function()
        {
			let $this = this;
			let params = $.extend(true, {}, $this.params);

			AjaxUtil.post(
       {
				dataType : 'binary',
                url      : "/oper/hc/guarFmenuHist/guarFmenuHistList/excel.ab",
                param    : params,
                success  : function(response)
                {
                	saveFileLocal(response, 'guarFmenuHist.xls');
                },
                error    : function (response)
                {
                    Swal.alert([response, 'error']);
                }
            });
		},
		resetSearchParam: function()
        {
			let $this = this;
			$this.params =
            {
                userId        : '' ,
                fmenuNm       : '' , //식단표_명
                mmelYn        : '' , //아침_여부
                amelYn        : '' , //점심_여부
                emelYn        : '' , //저녁_여부
                smelYn        : '' , //간식_여부
                guarNo        : '' , //보호자_번호
                guarNm        : '' , //보호자_명
                paging        : 'Y',
                totalCount    : 0  ,
                rowCount      : 30 ,
                currentPage   : 1  ,
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