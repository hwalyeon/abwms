let guarFmenuDetl = new Vue({
	el  : "#guarFmenuDetlPopup",
	data:
		{
			params:
			{
				fmenuSpec :
				{
					guarNo        : '' , //보호자_번호
					fmenuSeq      : '' , //식단_순번
					fmenuNm       : '' , //식단_명
					fmenuQty      : '' , //식단_용량
					foodNo        : '' , //식품_번호
					foodNm        : '' , //식품_명
					otimEatQty    : '' , //일회_섭취_용량
					qty           : '' , //수량
					eatQty        : '' , //섭취량

					paging        : 'Y',
					totalCoun     : 0  ,
					rowCount      : 30 ,
					currentPage   : 1  ,
					currentIndex  : 0
				},
			},
		},
	methods:
		{
			initialize: function()
			{
				let $this = this;
			},
			initPage: function(guarNo, fmenuSeq)
			{
				let $this = this;

				$this.resetGuarFmenuDetl();
				//식단_구성_목록 초기화
				$("#fmenuSpec_list").clearGridData();

				if (!WebUtil.isNull(fmenuSeq))
				{
					$this.params.fmenuSpec.fmenuSeq = fmenuSeq;  /*식단_순번   */
					$this.params.fmenuSpec.guarNo   = guarNo;    /*보호자_번호 */

					let params = {
						'fmenuSeq' : fmenuSeq ,
						'guarNo'   : guarNo
					}
					AjaxUtil.post({
						url    : "/oper/hc/guarFmenuHist/searchGuarFmenuSpecList.ab",
						param  : params,
						success: function(response)
						{
							if (!!response.rtnData.result)
							{
								$.each(response.rtnData.result[0], function(key, val)
								{
									$this.params.fmenuSpec[key] = val;
								});
							}
							$this.params.fmenuSpec.fmenuQty = numberFormat($this.params.fmenuSpec.fmenuQty)+'㎉';
						},
						error: function (response)
						{
							Swal.alert([response, 'error']);
						},
					});
				}
				setTimeout(function()
				{
					$this.initGrid();
					$this.searchGuarFmenuSpecList(true);
				},300);

			},
			initGrid: function()
			{
				let $this = this;

				/*식단_정보_그리드*/
				let fmenuSpecColModels =
				[
					{name: "foodNo"      , index: "foodNo"      , label: "식품 번호"      , width: 30   , align: "center" },
					{name: "foodNm"      , index: "foodNm"      , label: "식품 명"        , width: 100  , align: "left"   },
					{name: "qty"         , index: "qty"         , label: "수량"           , width: 30   , align: "center" },
					{name: "eatQty"      , index: "eatQty"      , label: "섭취 용량(g)"   , width: 50   , align: "right"   , formatter:function(cellvalue) {return numberFormat(cellvalue) + 'g';}},
					{name: "nutrQty"     , index: "nutrQty"     , label: "섭취 칼로리(㎉)" , width: 50  , align: "right"    , formatter:function(cellvalue) {return cellvalue+'㎉'}},
				];
				$("#fmenuSpec_list").jqGrid("GridUnload");
				$("#fmenuSpec_list").jqGrid($.extend(true, {}, commonGridOptions(),
				{
					datatype : "local",
					mtype    : 'post',
					height   :  220,
					url      : '/oper/hc/guarFmenuHist/searchGuarFmenuSpecList.ab',
					pager    : "#fmenuSpec_pager_list",
					colModel : fmenuSpecColModels,
					onPaging : function(data)
					{
						onPagingCommon(data, this, function(resultMap) {
							$this.params.fmenuSpec.currentPage  = resultMap.currentPage;
							$this.params.fmenuSpec.rowCount     = resultMap.rowCount;
							$this.params.fmenuSpec.currentIndex = resultMap.currentIndex;
							$this.searchGuarFmenuSpecList(false);
						})
					},
					gridComplete: function ()
					{
						var grid = this;
						$('td[rowspan="1"]', grid).each(function () {
							var spans = $('td[rowspanid="' + this.id + '"]', grid).length + 1;

							if (spans > 1) {
								$(this).attr('rowspan', spans);
							}
						});
					}

				}));
				resizeJqGridWidth("fmenuSpec_list", "fmenuSpec_list_wrapper");
			},
			//식단_정보_목록 조회
			searchGuarFmenuSpecList : function(isSearch) {

				let $this = this;

				let params = $.extend(true, {}, this.params.fmenuSpec);

				if ( isSearch ) {
					params.currentPage  = 1;
					params.currentIndex = 0;
				}

				$("#fmenuSpec_list").setGridParam({
					datatype    : "json",
					postData    : JSON.stringify(params),
					page        : 1,
					loadComplete: function(response) {
						if ( response.rtnData.result == 0 ) {
							Swal.alert(["데이터가 없습니다.", "info"]);
						}else{

						}
					}
				}).trigger("reloadGrid");
			},
			/*초기화_식단_정보_*/
			resetGuarFmenuDetl: function() {
				this.params =
				{
					fmenuSpec :
						{
							guarNo        : '' , //보호자_번호
							fmenuSeq      : '' , //식단_순번
							fmenuNm       : '' , //식단_명
							fmenuQty      : '' , //식단_용량
							foodNo        : '' , //식품_번호
							foodNm        : '' , //식품_명
							otimEatQty    : '' , //일회_섭취_용량
							qty           : '' , //수량
							eatQty        : '' , //섭취량

							paging        : 'Y',
							totalCoun     : 0  ,
							rowCount      : 30 ,
							currentPage   : 1  ,
							currentIndex  : 0
						},
				}
			}
		},
	computed:
		{
		},
	watch: {
		'params.bandId': function(newVal, oldVal) {
			this.params.checkDupBandId = 'N';
		},
	},
	mounted: function() {
		let self = this;
		$(document).ready(function()
		{
			self.initialize();
		});
	}
});
