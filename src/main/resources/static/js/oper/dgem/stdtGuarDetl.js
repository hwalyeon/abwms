let stdtGuarDetl = new Vue({
	el: "#stdtGuarDetlPopup",
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
	},

	methods: {

		initialize: function() {

			let $this = this;

			$this.initValue();

			$this.initCodeList();

			setTimeout(function()
			{
				$this.initGrid();
				$this.searchStdtGuarList(true);
			},300);
		},
		initValue: function() {
			let $this = this;
		},
		initCodeList: function() {
			let $this = this;
		},
		initPage: function() {
			let $this = this;

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

			$("#stdtguar_list").jqGrid("GridUnload");
			$("#stdtguar_list").jqGrid($.extend(true, {}, commonGridOptions(), {
				datatype: "local",
				mtype: 'post',
				url: '/oper/dgem/dgemHist/searchStdtGuarList.ab',
				pager: '#stdtguar_pager_list',
				height: 270,
				colModel: colModels,
				onPaging : function(data) {
					onPagingCommon(data, this, function(resultMap) {
						$this.params.currentPage  = resultMap.currentPage;
						$this.params.rowCount     = resultMap.rowCount;
						$this.params.currentIndex = resultMap.currentIndex;
						$this.searchStdtGuarList(false);
					})
				},
				ondblClickRow: function(rowId, status, e) {
					let item = $('#stdtguar_list').jqGrid('getRowData', rowId);
					dgemHist.setData(item);
					locHist.setData(item);
					console.log(item);
					closeModal($('#stdtGuarDetlPopup'));
				},
				gridComplete: function(rowId, rowObject) {
					let grid = this;

				},
			}));

			resizeJqGridWidth("stdtguar_list", "stdtguar_list_wrapper");
		},
		searchStdtGuarList: function(isSearch) {

			let $this = this;
			let params = $.extend(true, {}, $this.params);
			if ( isSearch ) {
				params.currentPage = 1;
				params.currentIndex = 0;
			}

			$("#stdtguar_list").setGridParam({
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
