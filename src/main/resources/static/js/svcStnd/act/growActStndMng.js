let growActStndMng = new Vue(
		{
			el : "#growActStndMng",
			data : {
				params : {
					userId : '',
					growJudgCd : '', // 성장_판정_코드
					growJudgNm : '', // 성장_판정_명
					palCd : '', // 신체활동수준_코드
					palNm : '', // 신체활동수준_명
					growActRmrk : '', // 성장_활동_비고
					paging : 'Y',
					totalCount : 0,
					rowCount : 30,
					currentPage : 1,
					currentIndex : 0
				},
				code : {
					growJudgCdList : [],
					palCdList : []
				},
			},
			methods : {
				initialize : function() {
					let $this = this;

					$this.initValue();
					$this.initCodeList();
				},
				initValue : function() {
					let $this = this;
					$this.userId = SessionUtil.getUserId();
				},
				initCodeList : function() {
					let $this = this;
					getCommonCodeList('GROW_JUDG_CD', $this.code.growJudgCdList);
					getCommonCodeList('PAL_CD', $this.code.palCdList,
							function() {
								$this.initGrid();
								$this.searchGrowActStndList(true);
							})
				},
				initGrid : function() {
					let $this = this;
					let palCdList = commonGridCmonCd($this.code.palCdList);
					let colModels = [
							{
								name : "crud",
								index : "crud",
								label : "crud",
								hidden : true
							},
							{
								name : "growJudgCd",
								index : "growJudgCd",
								label : "성장판정 코드",
								width : 80,
								align : "center",
								editable : false
							},
							{
								name : "growJudgNm",
								index : "growJudgNm",
								label : "성장판정 명",
								width : 80,
								align : "center",
								editable : false
							},
							{
								name : "palCd",
								index : "palCd",
								label : "신체활동수준 코드",
								width : 80,
								align : "center",
								editable : false
							},
							{
								name : "palNm",
								index : "palNm",
								label : "신체활동수준 명",
								width : 80,
								align : "center",
								editable : false
							},
							{
								name : "growActRmrk",
								index : "growActRmrk",
								label : "성장활동 비고",
								width : 700,
								align : "center",
								editable : false
							},
							{
								name : "regDt",
								index : "regDt",
								label : "등록일자",
								width : 80,
								align : "center",
								formatter : function(cellValue, options,
										rowObject) {
									return formatDate(cellValue);
								}
							},
							{
								name : "regTm",
								index : "regTm",
								label : "등록시각",
								width : 80,
								align : "center",
								formatter : function(cellValue, options,
										rowObject) {
									return formatTime(cellValue);
								}
							},
							{
								name : "regUserId",
								index : "regUserId",
								label : "등록사용자 ID",
								width : 80,
								align : "center"
							},
							{
								name : "uptDt",
								index : "uptDt",
								label : "수정일자",
								width : 80,
								align : "center",
								formatter : function(cellValue, options,
										rowObject) {
									return formatDate(cellValue);
								}
							},
							{
								name : "uptTm",
								index : "uptTm",
								label : "수정시각",
								width : 80,
								align : "center",
								formatter : function(cellValue, options,
										rowObject) {
									return formatTime(cellValue);
								}
							},
							{
								name : "uptUserId",
								index : "uptUserId",
								label : "수정사용자 ID",
								width : 80,
								align : "center"
							},
							{
								name : "growActStndPop",
								index : "growActStndPop",
								label : "상세정보 보기",
								width : 80,
								align : "center",
								formatter : function(cellValue, options,
										rowObject) {
									return '<input type="button" class="btn btn-xs btn-outline btn-success" onclick="growActStndMng.regGrowActStndPop(\''
											+ rowObject.growJudgCd
											+ '\', \''
											+ rowObject.palCd
											+ '\')" value="상세보기" data-toggle="modal" data-target="#growActStndDetlPopup" />';
								}
							} ];

					$("#growActStnd_list").jqGrid("GridUnload");
					$("#growActStnd_list")
							.jqGrid(
									$
											.extend(
													true,
													{},
													commonEditGridOptions(),
													{
														datatype : "local",
														mtype : 'post',
														url : '/svcStnd/act/growActStndMng/searchGrowActStndList.ab',
														pager : '#growActStnd_pager_list',
														height : 502,
														colModel : colModels,
														onPaging : function(
																data) {
															onPagingCommon(
																	data,
																	this,
																	function(
																			resultMap) {
																		$this.params.currentPage = resultMap.currentPage;
																		$this.params.rowCount = resultMap.rowCount;
																		$this.params.currentIndex = resultMap.currentIndex;
																		$this
																				.searchGrowActStndList(false);
																	})
														},
														afterSaveCell : function(
																rowid, colId,
																val, e) {
															if ($(
																	"#growActStnd_list")
																	.getRowData(
																			rowid).crud != "C"
																	&& $(
																			"#growActStnd_list")
																			.getRowData(
																					rowid).crud != "D") {
																$(
																		"#growActStnd_list")
																		.setRowData(
																				rowid,
																				{
																					crud : "U"
																				});
															}
														}
													}));
					resizeJqGridWidth("growActStnd_list",
							"growActStnd_list_wrapper");
				},
				searchGrowActStndList : function(isSearch) {
					let $this = this;
					let params = $.extend(true, {}, $this.params);

					if (isSearch) {
						params.currentPage = 1;
						params.currentIndex = 0;
					}

					$("#growActStnd_list").setGridParam({
						datatype : "json",
						postData : JSON.stringify(params),
						page : 1,
						loadComplete : function(response)

						{
							if (response.rtnData.result == 0) {
								Swal.alert([ '조회할 내용이 없습니다.', "info" ]);
							}
						}
					}).trigger("reloadGrid");
				},
				downloadExcel : function() {
					let $this = this;
					let params = $.extend(true, {}, $this.params);

					AjaxUtil
							.post({
								dataType : 'binary',
								url : "/svcStnd/act/growActStndMng/searchGrowActStndList/excel.ab",
								param : params,
								success : function(response) {
									saveFileLocal(response,
											'growActStndMng.xls');
								},
								error : function(response) {
									Swal.alert([ response, 'error' ]);
								}
							});
				},
				palStndNmVal : function() {
					let $this = this;
				},
				growJudgStndNmVal : function() {
					let $this = this;
				},
				regGrowActStndPop : function(growJudgCd, palCd) {
					growActStndDetl.initPage(growJudgCd, palCd);
				},
				resetSearchParam : function() {
					let $this = this;
					$this.params = {
						growJudgCd : '', // 성장_판정_코드
						palCd : '', // 신체활동수준_코드
						paging : 'Y',
						totalCount : 0,
						rowCount : 30,
						currentPage : 1,
						currentIndex : 0
					}
				}
			},
			computed : {},
			watch : {},
			mounted : function() {
				let self = this;
				$(document).ready(function() {
					self.initialize();
				});
			}
		});