let stdtEorgLocPop = new Vue({
	el: "#stdtEorgLocPopup",
	data: {
		params: {
			locNo: '',
			locNm: '',
			roadAddr: '',
			currentPage : 0,
			rowCount : 30,
			currentIndex : 0
		},
		code: {

		},
		callback: null,
	},

	methods: {

		initialize: function() {

			let $this = this;

			$this.initCodeList();

			$this.initModal();
		},
		initCodeList: function() {



		},

		initGrid: function() {

			let $this = this;
			let colModels = [
				{name: "locNo"     , index: "locNo"     , label: "위치번호"	, width: 80  , align: "center", hidden: true},
				{name: "locNm"     , index: "locNm"     , label: "위치명"	, width: 80  , align: "center"},
				{name: "roadAddr"  , index: "roadAddr"  , label: "주소"	    , width: 100 , align: "left"}
			];


			$("#stdtEorgLocPopup_list").jqGrid("GridUnload");
			$("#stdtEorgLocPopup_list").jqGrid($.extend(true, {}, commonGridOptions(), {
				datatype: "local",
				mtype: 'post',
				url: '/user/stdt/stdtInfoMng/searchStdtEorgLocList.ab',
				pager: "#stdtEorgLocPopup_pager_list",
				height: 250,
				colModel: colModels,
				onPaging : function(data) {
					onPagingCommon(data, this, function(resultMap) {
						$this.params.currentPage  = resultMap.currentPage;
						$this.params.rowCount     = resultMap.rowCount;
						$this.params.currentIndex = resultMap.currentIndex;
						$this.searchList(false);
					})
				},
				ondblClickRow: function() {
					$this.chooseRow();
				}
			}));

			resizeJqGridWidth("stdtEorgLocPopup_list", "stdtEorgLocPopup_jqGrid_wrapper");

		},

		initPage: function(vo) {

			let $this = this;
			$this.initParam();

			$this.callback = vo.callback;

		},
		initParam: function() {
			this.params.stdtId = '';
			this.params.stdtNm = '';
			this.params.mtelNo = '';
			this.params.mailAddr = '';
			this.params.currentPage = 0;
			this.params.currentIndex = 0;
		},
		initModal: function() {
			let $this = this;
			$("#stdtEorgLocPopup").off("shown.bs.modal").on("shown.bs.modal", function(e) {
				$this.initGrid();
			});
		},
		searchList: function(isSearch) {

			let $this = this;

			let params = $.extend(true, {}, $this.params);

			if ( isSearch ) {
				params.currentPage  = 1;
				params.currentIndex = 0;
			}

			$("#stdtEorgLocPopup_list").setGridParam({
				datatype: "json",
				postData: JSON.stringify(params),
				page: 1
			}).trigger("reloadGrid");
		},
		chooseRow: function() {
			let $this = this;

			// 콜백함수 실행
			if ( typeof $this.callback === "function")
			{
				var rowData = $("#stdtEorgLocPopup_list").getRowData($("#stdtEorgLocPopup_list").jqGrid("getGridParam","selrow") + "");

				this.callback(rowData);

				$("#stdtEorgLocPopup").modal("hide");
			}

		}
	},
	mounted: function() {
		let self = this;
		$(document).ready(function() {
			self.initialize();
		});
	}
});
