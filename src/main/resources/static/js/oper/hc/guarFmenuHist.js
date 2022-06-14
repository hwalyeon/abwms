let guarFmenuHist = new Vue({
    el: "#guarFmenuHist", //보호자_식단표_현황
    data:
    {
    	params:
        {
            userId        : '' ,
            fmenuNm       : '' ,  //식단표_명
            fmenuQty      : '0' , //식단_용량
            totCalFr      : '' ,  //총_칼로리_Fr
            totCalTo      : '' ,  //총_칼로리_To
            foodNm1       : '' ,  //포함_음식1
            foodNm2       : '' ,  //포함_음식2
            mmelYn        : 'Y' , //아침_여부
            amelYn        : 'Y' , //점심_여부
            emelYn        : 'Y' , //저녁_여부
            smelYn        : 'Y' , //간식_여부
            guarNo        : '' ,  //보호자_번호
            guarNm        : '' ,  //보호자_명
    		paging        : 'Y',
    		totalCount    : 0  ,
            rowCount      : 30 ,
            currentPage   : 1  ,
            currentIndex  : 0
        },
        code:
        {
            totCalList : [] //총 칼로리 리스트
        },
	},
    methods:
    {
        initialize: function()
        {
        	let $this = this;

            $this.initValue();
            $this.initCodeList()
        	$this.initGrid();
            $this.searchGuarFmenuHistList(true);
        },
        initValue: function()
        {
            let $this = this;
            $this.userId = SessionUtil.getUserId();

            $this.params.mmelYn = 'Y'; //아침_여부
            $this.params.amelYn = 'Y'; //점심_여부
            $this.params.emelYn = 'Y'; //저녁_여부
            $this.params.smelYn = 'Y'; //간식_여부
        },
        initCodeList: function(){

            let $this = this;
            $this.code.totCalList = [
                    { value: '0',  text: "전체" },
                    { value: "1",  text: "    0 ~   500 (㎉)" },
                    { value: "2",  text: "  500 ~ 1,000 (㎉)" },
                    { value: "3",  text: "1,000 ~ 1,500 (㎉)" },
                    { value: "4",  text: "1,500 ~ 2,000 (㎉)" },
                    { value: "4",  text: "2,000 ~ 2,500 (㎉)" },
                    { value: "5",  text: "2,500 ~ 3,000 (㎉)" },
                    { value: "5",  text: "3,000 ~ 3,500 (㎉)" },
                    { value: "6",  text: "3,500 ~  (㎉)" }
            ]
        },
        initGrid: function()
        {
            let $this = this;
        	let colModels =
            [   {name: "guarNo"   , index: "guarNo"   , label: "보호자 번호"  , width: 50  , align: "center" },
                {name: "guarNm"   , index: "guarNm"   , label: "보호자 명"    , width: 50  , align: "center" },
                {name: "fmenuSeq" , index: "fmenuSeq" , label: "식단표 번호"  , width: 50  , align: "center" },
                {name: "fmenuNm"  , index: "fmenuNm"  , label: "식단표 명"    , width: 150 , align: "left"   },
                {name: "mmelYn"   , index: "mmelYn"   , label: "아침 여부"    , width: 50  , align: "center" },
                {name: "amelYn"   , index: "amelYn"   , label: "점심 여부"    , width: 50  , align: "center" },
                {name: "emelYn"   , index: "emelYn"   , label: "저녁 여부"    , width: 50  , align: "center" },
                {name: "smelYn"   , index: "smelYn"   , label: "간식 여부"    , width: 50  , align: "center" },
                {name: "fmenuQty" , index: "fmenuQty" , label: "식단 용량"    , width: 50  , align: "right"   , formatter:function(cellvalue) {return numberFormat(cellvalue) + '㎉';}},
                {name: "feqUse"   , index: "feqUse"   , label: "이용빈도(수)" , width: 50  , align: "center" },
                {name: "guarFmenuDetlPop", index: "guarFmenuDetlPop", label: "상세보기", width: 80, align: "center",
                    formatter: function(cellValue, options, rowObject) {
                        return '<input type="button" class="btn btn-xs btn-outline btn-success" onclick="guarFmenuHist.regGuarFmenuDetlPop(\'' + rowObject.guarNo + '\', \''+rowObject.fmenuSeq +'\')" value="상세보기" data-toggle="modal" data-target="#guarFmenuDetlPopup" />';
                    }
                }
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
                        $this.params.rowCount     = resultMap.rowCount;
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
        regGuarFmenuDetlPop : function (guarNo, fmenuSeq){
            guarFmenuDetl.initPage(guarNo, fmenuSeq);
        },
        //총_칼로리 선택 시
        selectTotCal: function(event){

            let $this = this;

            var value = event.target.value;

            if (value == '0') {
                $this.params.totCalFr = '';
                $this.params.totCalTo = '';
            } else if (value == '1') {
                $this.params.totCalFr = 0;
                $this.params.totCalTo = 500;
            } else if (value == '2') {
                $this.params.totCalFr = 500;
                $this.params.totCalTo = 1000;
            } else if (value == '3') {
                $this.params.totCalFr = 1000;
                $this.params.totCalTo = 1500;
            } else if (value == '4') {
                $this.params.totCalFr = 1500;
                $this.params.totCalTo = 2000;
            } else if (value == '5') {
                $this.params.totCalFr = 2000;
                $this.params.totCalTo = 2500;
            } else if (value == '6') {
                $this.params.totCalFr = 2500;
                $this.params.totCalTo = 3000;
            } else if (value == '7') {
                $this.params.totCalFr = 3000;
                $this.params.totCalTo = 3500;
            } else if (value == '8') {
                $this.params.totCalFr = 3500;
                $this.params.totCalTo = 999999;
        }

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
                    }else{

                        $this.Mm
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
                fmenuNm       : '' ,  //식단표_명
                fmenuQty      : '0' , //식단_용량
                totCalFr      : '' ,  //총_칼로리_Fr
                totCalTo      : '' ,  //총_칼로리_To
                foodNm1       : '' ,  //포함_음식1
                foodNm2       : '' ,  //포함_음식2
                mmelYn        : 'Y' , //아침_여부
                amelYn        : 'Y' , //점심_여부
                emelYn        : 'Y' , //저녁_여부
                smelYn        : 'Y' , //간식_여부
                guarNo        : '' ,  //보호자_번호
                guarNm        : '' ,  //보호자_명
                paging        : 'Y',
                totalCount    : 0  ,
                rowCount      : 30 ,
                currentPage   : 1  ,
                currentIndex  : 0
	    	}
			$this.initValue();
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