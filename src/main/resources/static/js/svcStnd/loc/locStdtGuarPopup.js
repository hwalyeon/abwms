let locStdtGuarPopup = new Vue({
	el: "#locStdtGuarPopup",
	data: {
		params: {
			stdtNo      :'',
			stdtNoNm    :'',
			guarNo      :'',
			guarNoNm    :'',
			guarTelNo   :'',
			paging      :'Y',
			totalCount  : 0,
			rowCount    : 30,
			currentPage : 1,
			currentIndex: 0
		},
		callback: null
	},

	methods: {
		initialize: function(callback) {
			let $this = this;
			console.log("jcw :: ");
			$this.callback = callback;

			setTimeout(function() {
				$this.initGrid();
				$this.searchLocStdtGuarList(true);
				console.log("jcw ??? :: ");
				console.log($this.params);
			},300);
		},
		initGrid: function()
		{
			let $this = this;
			let colModels = [
				{name: "crud"              , index: "crud"         , label: "crud"		 	    , hidden: true                    },
				{name: "stdtNo"            , index: "stdtNo"       , label: "학생번호"		 	, width: 80     , align: "center" },
				{name: "stdtNm"            , index: "stdtnm"       , label: "학생명"	            , width: 80     , align: "center" },
				{name: "guarNo"            , index: "guarNo"       , label: "보호자번호"		    , width: 80     , align: "center" },
				{name: "guarNm"            , index: "guarNm"       , label: "보호자명"		    , width: 80     , align: "center" },
				{name: "guarTelNo"         , index: "guarTelNo"    , label: "보호자 전화번호"	    , width: 100    , align: "center" ,fixed:true},
			];

			$("#stdtGuar_list").jqGrid("GridUnload");
			$("#stdtGuar_list").jqGrid($.extend(true, {}, commonGridOptions(), {
				datatype: "local",
				mtype: 'post',
				url: '/svcStnd/loc/locInfoMng/searchLocStdtGuarList.ab',
				pager: '#locStdtGuar_pager_list',
				height: 270,
				colModel: colModels,
				onPaging : function(data) {
					onPagingCommon(data, this, function(resultMap) {
						$this.params.currentPage  = resultMap.currentPage;
						$this.params.rowCount     = resultMap.rowCount;
						$this.params.currentIndex = resultMap.currentIndex;
						$this.searchLocStdtGuarList(false);
					})
				},
				ondblClickRow: function(rowId, status, e) {
					let item = $('#locStdtGuar_list').jqGrid('getRowData', rowId);
					$this.callback(item);
					closeModal($('#locStdtGuarPopup'));
					//self.closeModal();
				},
				gridComplete: function () {
					var grid = this;

					$('td[rowspan="1"]', grid).each(function () {
						var spans = $('td[rowspanid="' + this.id + '"]', grid).length + 1;

						if (spans > 1) {
							$(this).attr('rowspan', spans);
						}
					});
				}
			}));
			resizeJqGridWidth("locStdtGuar_list", "locStdtGuar_list_wrapper");
		},
		searchLocStdtGuarList: function(isSearch) {
			let $this = this;

			let params = $.extend(true, {}, $this.params);
			if ( isSearch ) {
				params.currentPage = 1;
				params.currentIndex = 0;
			}

			console.log("jcw 22 :: ");
			$("#locStdtGuar_list").setGridParam({
				datatype: "json",
				postData: JSON.stringify(params),
				page: 1,
				loadComplete: function (response) {
					console.log("jcw 입수 :: ");
					console.log(response);
					if ( response["rtnData"].result === 0 ) {
						Swal.alert(['조회할 내용이 없습니다.', "info"]);
					}
					console.log("jcw 입수 :: ");
				}
			}).trigger("reloadGrid");

			console.log("jcw 33 :: ");
		},
		resetSearchParam: function () {
			let $this = this;
			$this.params = {
				stdtNo      :'',
				stdtNoNm    :'',
				guarNo      :'',
				guarNoNm    :'',
				guarTelNo   :'',
				totalCount	: 0,
				rowCount	: 30,
				currentPage	: 1,
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
		// $(document).ready(function() {
		// 	self.initialize();
		// });
	}
});
