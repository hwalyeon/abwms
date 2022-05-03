let stdtGuarPopup = new Vue({
	el: "#stdtGuarPopup",
	data: {
		params: {
			stdtNo      :'',
			stdtNm      :'',
			guarNo      :'',
			guarNm      :'',
			guarTelNo   :'',
			hghtVal     : 0,
			wghtVal     : 0,
			wastVal     : 0,
			paging      :'Y',
			totalCount  : 0,
			rowCount    : 30,
			currentPage : 1,
			currentIndex: 0
		},
		code: {
		},
		callback: null
	},

	methods: {

		initialize: function() {

			let $this = this;

			$this.initModal();
		},

		initModal: function() {
			let $this = this;
			$("#stdtGuarPopup").off("shown.bs.modal").on("shown.bs.modal", function(e) {
				$this.initGrid();
				$this.searchStdtGuarInfoList(true);
			});
		},

		initValue: function() {
			let $this = this;
		},
		initCodeList: function() {
			let $this = this;
		},
		initPage: function(vo) {
			let $this = this;
			if(vo != null){
				$this.callback = vo.callback;
			}
		},
		isValid: function() {
			let $this = this;
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
				url: '/popup/popupMng/searchStdtGuarList.ab',
				pager: '#stdtGuar_pager_list',
				height: 270,
				colModel: colModels,
				onPaging : function(data) {
					onPagingCommon(data, this, function(resultMap) {
						$this.params.currentPage  = resultMap.currentPage;
						$this.params.rowCount     = resultMap.rowCount;
						$this.params.currentIndex = resultMap.currentIndex;
						$this.searchStdtGuarInfoList(false);
					})
				},
				ondblClickRow: function(rowId, status, e) {
					$this.chooseRow();
				},
				gridComplete: function(rowId, rowObject) {
					let grid = this;

				},
			}));

			resizeJqGridWidth("stdtGuar_list", "stdtGuar_list_wrapper");
		},
		searchStdtGuarInfoList: function(isSearch) {

			let $this = this;
			let params = $.extend(true, {}, $this.params);
			if ( isSearch ) {
				params.currentPage = 1;
				params.currentIndex = 0;
			}

			$("#stdtGuar_list").setGridParam({
				datatype: "json",
				postData: JSON.stringify(params),
				page: 1,
				loadComplete: function (response) {
					if ( response.rtnData.result == 0 ) {
						Swal.alert(['조회할 내용이 없습니다.', "info"]);
					}
				}
			}).trigger("reloadGrid");

		},
		chooseRow : function (){
			let $this = this;

			// 콜백함수 실행
			if ( typeof $this.callback === "function")
			{
				var rowData = $("#stdtGuar_list").getRowData($("#stdtGuar_list").jqGrid("getGridParam","selrow") + "");

				$this.callback(rowData);

				closeModal($('#stdtGuarPopup'));
			}
		},
		resetSearchParam: function () {
			let $this = this;
			$this.params = {
				stdtNo: '',
				stdtNm: '',
				guarNo: '',
				guarNm: '',
				guarTelNo: '',
				totalCount: 0,
				rowCount: 30,
				currentPage: 1,
				currentIndex: 0,
				paging      :'Y'
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
