let eatHistDetl = new Vue({
	el  : "#eatHistDetlPopup",
	data:
		{
			params:
			{
				fmenuSpec :
				{
					guarNo        : '' , //보호자_번호
					fmenuSeq      : '' , //식단_순번
					fmenuNm       : '' , //식단_명
					fmenuCtgry    : '' , //식단_유형
					fmenuQty      : '' , //식단_용량
					paging        : 'Y',
					totalCoun     : 0  ,
					rowCount      : 30 ,
					currentPage   : 1  ,
					currentIndex  : 0
				},
				eatNutrSpec :
				{
					foodNo        : '' , //음식_번호
					foodNm        : '' , //음식_번호
					eatQty        : '' , //섭취_량
					paging        : 'Y',
					totalCoun     : 0  ,
					rowCount      : 30 ,
					currentPage   : 1  ,
					currentIndex  : 0
				}
			},
		},
	methods:
		{
			initialize: function()
			{
				let $this = this;
			},
			initPage: function(fmenuSeq, guarNo)
			{
				let $this = this;

				$this.resetEatHistDetl();
				//식단_구성_목록 초기화
				$("#fmenuSpec_list").clearGridData();
				//섭취_영양_정보_목록 초기화
				$("#eatNutrSpec_list").clearGridData();

				if (!WebUtil.isNull(fmenuSeq))
				{
					$this.params.fmenuSpec.fmenuSeq = fmenuSeq;  /*식단_순번   */
					$this.params.fmenuSpec.guarNo   = guarNo;    /*보호자_번호 */

					let params = {
						'fmenuSeq' : fmenuSeq ,
						'guarNo'   : guarNo
					}
					AjaxUtil.post({
						url    : "/oper/hc/eatHist/searchFmenuSpecList.ab",
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
					$this.searchFmenuSpecList(true);
				},300);

			},
			initGrid: function()
			{
				let $this = this;

				/*식단_정보_그리드*/
				let fmenuSpecColModels =
				[
					{name: "foodNo"  , index: "foodNo"  , label: "식품 번호" , width: 30  , align: "center" },
					{name: "foodNm"  , index: "foodNm"  , label: "식품 명"   , width: 100  , align: "center"},
					{name: "qty"     , index: "qty"     , label: "수량"      , width: 30  , align: "center" },
					{name: "eatQty"  , index: "eatQty"  , label: "섭취 용량" , width: 50  , align: "center" },
				];
				$("#fmenuSpec_list").jqGrid("GridUnload");
				$("#fmenuSpec_list").jqGrid($.extend(true, {}, commonGridOptions(),
				{
					datatype : "local",
					mtype    : 'post',
					height   :  220,
					url      : '/oper/hc/eatHist/searchFmenuSpecList.ab',
					pager    : "#fmenuSpec_pager_list",
					colModel : fmenuSpecColModels,
					onPaging : function(data)
					{
						onPagingCommon(data, this, function(resultMap) {
							$this.params.fmenuSpec.currentPage  = resultMap.currentPage;
							$this.params.fmenuSpec.rowCount     = resultMap.rowCount;
							$this.params.fmenuSpec.currentIndex = resultMap.currentIndex;
							$this.searchFmenuSpecList(false);
						})
					},
					onSelectRow: function(rowId, status, e)
					{
						let item = $('#fmenuSpec_list').jqGrid('getRowData', rowId);
						if (!!item.foodNo)
						{
							$this.params.eatNutrSpec.foodNo = item.foodNo;
							$this.params.eatNutrSpec.eatQty = item.eatQty;
							$this.params.eatNutrSpec.foodNm = item.foodNm;
							$this.searcheEtNutrSpecList(true);
						}
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

				/*섭취_영양_정보_그리드*/
				let eatNutrSpecColModels =
				[
					{name: "nutrNm"     , index: "nutrNm"     , label: "영양소" , width: 120 , align: "center" },
					{name: "nutrQty"    , index: "nutrQty"    , label: "섭취량" , width: 90  , align: "left"   },
					{name: "nutrUnitCd" , index: "nutrUnitCd" , label: "단위"   , width: 60  , align: "center" }
				];
				$("#eatNutrSpec_list").jqGrid("GridUnload");
				$("#eatNutrSpec_list").jqGrid($.extend(true, {}, commonGridOptions(), {
					mtype    : 'post',
					height   : 440,
					datatype : "local",
					url      : '/oper/hc/eatHist/searchEatNutrSpecList.ab',
					pager    : "#eatNutrSpec_pager_list",
					colModel : eatNutrSpecColModels,
					onPaging : function(data) {
						onPagingCommon(data, this, function(resultMap) {
							$this.params.eatNutrSpec.currentPage  = resultMap.currentPage;
							$this.params.eatNutrSpec.rowCount     = resultMap.rowCount;
							$this.params.eatNutrSpec.currentIndex = resultMap.currentIndex;
							$this.searcheEtNutrSpecList(false);
						})
					},
					loadComplete: function(datas) {
						var grid = this;
						$('td[rowspan="1"]', grid).each(function () {
							var spans = $('td[rowspanid="' + this.id + '"]', grid).length + 1;
							if (spans > 1) {
								$(this).attr('rowspan', spans);
							}
						});
					}
				}));
				resizeJqGridWidth("eatNutrSpec_list", "eatNutrSpec_list_wrapper");
			},
			//식단_정보_목록 조회
			searchFmenuSpecList : function(isSearch) {

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

							//섭취_영양_정보 자동 세팅(첫 번째 음식)
							let item = $('#fmenuSpec_list').jqGrid('getRowData', 1);
							if (!!item.foodNo)
							{
								$this.params.eatNutrSpec.foodNo = item.foodNo;
								$this.params.eatNutrSpec.eatQty = item.eatQty;
								$this.params.eatNutrSpec.foodNm = item.foodNm;
								$this.searcheEtNutrSpecList(true);
							}
						}
					}
				}).trigger("reloadGrid");
			},
			//섭취_영양소_정보_목록 조회
			searcheEtNutrSpecList : function(isSearch) {
				let $this = this;

				let params = $.extend(true, {}, this.params.eatNutrSpec);

				if ( isSearch ) {
					params.currentPage  = 1;
					params.currentIndex = 0;
				}

				$("#eatNutrSpec_list").setGridParam({
					datatype    : "json",
					postData    : JSON.stringify(params),
					page        : 1,
					loadComplete: function(response) {
						if ( response.rtnData.result == 0 ) {
							Swal.alert(["데이터가 없습니다.", "info"]);
						}
					}
				}).trigger("reloadGrid");
			},
			/*초기화_식단_정보_*/
			resetEatHistDetl: function() {
				this.params =
				{
					fmenuSpec:
						{
							guarNo: '', //보호자_번호
							fmenuSeq: '', //식단_순번
							fmenuNm: '', //식단_명
							fmenuCtgry: '', //식단_유형
							fmenuQty: '', //식단_용량
							paging: 'Y',
							totalCoun: 0,
							rowCount: 30,
							currentPage: 1,
							currentIndex: 0
						},
					eatNutrSpec:
						{
							foodNo: '', //음식_번호
							foodNm: '', //음식_번호
							eatQty: '', //섭취_량
							paging: 'Y',
							totalCoun: 0,
							rowCount: 30,
							currentPage: 1,
							currentIndex: 0
						}
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
