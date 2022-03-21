let bandPop = new Vue({
	el: "#bandPopup",
	data: {
		params: {
			bandId: '',
			telNo:'',
			bandOpenStatCd: '',
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
				{name: "bandId"         , index: "bandId"          , label: "밴드ID"	   , width: 80  , align: "center"},
				{name: "telNo"          , index: "telNo"           , label: "전화번호"  , width: 80  , align: "center"},
				{name: "bandOpenStatCd" , index: "bandOpenStatCd"  , label: "밴드상태"  , width: 100 , align: "left", hidden : true},
				{name: "bandOpenStatNm" , index: "bandOpenStatNm"  , label: "밴드상태"  , width: 100 , align: "left"}
			];

			$("#bandPopup_list").jqGrid("GridUnload");
			$("#bandPopup_list").jqGrid($.extend(true, {}, commonGridOptions(), {
				datatype: "local",
				mtype: 'post',
				url: '/user/stdt/stdtInfoMng/searchBandList.ab',
				pager: "#bandPopup_pager_list",
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

			resizeJqGridWidth("bandPopup_list", "bandPopup_jqGrid_wrapper");

		},

		initPage: function(vo) {

			let $this = this;
			$this.initParam();

			$this.callback = vo.callback;

		},
		initParam: function() {
			this.params.bandId = '';
			this.params.telNo = '';
			this.params.bandOpenStatCd = '';
			this.params.currentPage = 0;
			this.params.currentIndex = 0;
		},
		initModal: function() {
			let $this = this;
			$("#bandPopup").off("shown.bs.modal").on("shown.bs.modal", function(e) {
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

			$("#bandPopup_list").setGridParam({
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
				var rowData = $("#bandPopup_list").getRowData($("#bandPopup_list").jqGrid("getGridParam","selrow") + "");

				if(rowData.bandOpenStatCd != 'PRNT'){
					Swal.alert(["보호자가 등록되지 않은 밴드입니다. 보호자 등록 후 진행하여 주시기 바랍니다.", 'warning']);
					return false;
				}

				this.callback(rowData);

				$("#bandPopup").modal("hide");
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
