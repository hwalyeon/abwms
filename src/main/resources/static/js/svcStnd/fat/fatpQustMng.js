let fatpQustMng = new Vue({
    el  : "#fatpQustMng",
    data: {
		params :
		{   //비만예측_설문_기본
			fatpQustBase :
			{
				qustVer      : '' , //설문_버전
				qustNo       : '' , //설문_번호
				qustCntn     : '' , //설문_내용
	            totalCount   : 0  ,
	            rowCount     : 30 ,
	            currentPage  : 1  ,
	            currentIndex : 0
			},
			//비만예측_설문_상세
			fatpQustSpec :
			{
				qustVer      : '' , //설문_버전
				qustNo       : '' , //설문_번호
				ansSeq       : '' , //답변_순번
				ansVal       : '' , //답변_값
				ansCntn      : '' , //답변_내용
	            totalCount   : 0  ,
	            rowCount     : 30 ,
	            currentPage  : 1  ,
	            currentIndex : 0
			}
		},
		code :
		{
			qustVerList : [] , // 설문_버전_리스트
			qustNoList  : []   // 설문_번호_리스트
		}
	},
    methods: {

        initialize: function() {
        	
        	let $this = this;
        	
        	$this.initCodeList();
        	
        	$this.initGrid();

        	$this.searchFatpQustBaseList(true);

		},
		initCodeList : function() {
			
			let $this = this;
		},
		initGrid: function() {
			
			let $this = this;

			//비만예측_설문_기본_ColModels
			let fatpQustBaseColModels =
			[
                {name: "qustVer"     , index: "qustVer"      , label: "설문 버전"     , align: "center" , width: 60  },
                {name: "qustNo"      , index: "qustNo"       , label: "설문 번호"     , align: "center" , width: 50  },
                {name: "qustCntn"    , index: "qustCntn"     , label: "설문 내용"     , align: "left"   , width: 220 },
                {name: "fatpQustBaseDetlPopup", index: "fatpQustBaseDetlPopup" , label: "비만예측설문"  , align: "center" , width: 60  ,
					formatter: function(cellValue, options, rowObject) {
                        return '<input type="button" class="btn btn-xs btn-outline btn-success" onclick="fatpQustMng.regFatpQustBaseDetlPop(\'' + rowObject.qustVer + '\',\'' + rowObject.qustNo + '\')" value="상세보기" data-toggle="modal" data-target="#fatpQustBaseDetlPopup" />';
                    }
                }
            ];
            $("#fatpQustBase_list").jqGrid("GridUnload");
           	$("#fatpQustBase_list").jqGrid($.extend(true, {}, commonGridOptions(),
			{
            	datatype : "local",
                mtype    : 'post',
                height   : 450,
                url      : '/svcStnd/fat/fatpQustMng/searchFatpQustBaseList.ab',
                pager    : "#fatpQustBase_pager_list",
                colModel : fatpQustBaseColModels,
                onPaging : function(data)
				{
                    onPagingCommon(data, this, function(resultMap)
					{
                    	$this.params.fatpQustBase.currentPage  = resultMap.currentPage;
                    	$this.params.fatpQustBase.rowCount     = resultMap.rowCount;
                    	$this.params.fatpQustBase.currentIndex = resultMap.currentIndex;
                    	$this.searchFatpQustBaseList(false);
                    })
                },
				//비만예측설문 선택 시
                onSelectRow: function(rowId, status, e)
				{
                	let item = $('#fatpQustBase_list').jqGrid('getRowData', rowId);

                    if ( !!item.qustNo )
                    {
                    	$this.params.fatpQustSpec.qustVer = item.qustVer;
                    	$this.params.fatpQustSpec.qustNo  = item.qustNo;
                    	$this.searchFatpQustSpecList(true);
                    }
                },
               /* 머지?
                  gridComplete: function () {
                    var grid = this;

                    $('td[rowspan="1"]', grid).each(function () {
                        var spans = $('td[rowspanid="' + this.id + '"]', grid).length + 1;

                        if (spans > 1) {
                            $(this).attr('rowspan', spans);
                        }
                    });
                }*/
            }));

            resizeJqGridWidth("fatpQustBase_list", "fatpQustBase_list_wrapper");

			//비만예측_설문_상세_ColModels
            let fatpQustSpecColModels = [
				{name: "qustVer"      , index: "qustVer"      , label: "설문 버전" , align: "center" , width: 60},
				{name: "qustNo"       , index: "qustNo"       , label: "설문 번호" , align: "center" , width: 50 },
                {name: "ansSeq"       , index: "ansSeq"       , label: "답변 순번" , align: "center" , width: 50},
                {name: "ansVal"       , index: "ansVal"       , label: "답변 값"   , align: "center" , width: 60},
                {name: "ansCntn"      , index: "ansCntn"      , label: "답변 내용" , align: "left"   , width: 100},
				{name: "fatpQustSpecDetlPop", index: "fatpQustSpecDetlPop" , label: "비만예측설문 상세" , align: "center"  , width: 60  ,
					formatter: function(cellValue, options, rowObject) {
                    	return '<input type="button" class="btn btn-xs btn-outline btn-success" onclick="regFatpQustSpecDetlPop(\'' + rowObject.qustVer + '\',\'' + rowObject.qustNo + '\')" value="상세보기" data-toggle="modal" data-target="#fatpQustSpecDetlPopup" />';
                    }
                }
            ];
                
            $("#fatpQustSpec_list").jqGrid("GridUnload");
           	$("#fatpQustSpec_list").jqGrid($.extend(true, {}, commonGridOptions(), {
                mtype    : 'post',
                height   : 450,
                datatype : "local",
                url      : '/svcStnd/fat/fatpQustMng/searchFatpQustSpecList.ab',
                pager    : "#fatpQustSpec_pager_list",
                colModel : fatpQustSpecColModels,
                onPaging : function(data) {
                    onPagingCommon(data, this, function(resultMap) {
                    	$this.params.fatpQustSpec.currentPage  = resultMap.currentPage;
                    	$this.params.fatpQustSpec.rowCount     = resultMap.rowCount;
                    	$this.params.fatpQustSpec.currentIndex = resultMap.currentIndex;
                    	$this.searchFatpQustSpecList(false);
                    })
                },
				// 머지?
                // loadComplete: function(datas) {
                // 	var grid = this;
                //     $('td[rowspan="1"]', grid).each(function () {
                //     	var spans = $('td[rowspanid="' + this.id + '"]', grid).length + 1;
                //     	if (spans > 1) {
                //     		$(this).attr('rowspan', spans);
                //     	}
                //     });
                // }
            }));
           	
            resizeJqGridWidth("fatpQustSpec_list", "fatpQustSpec_list_wrapper");
            
		},
		searchFatpQustBaseList: function(isSearch) {
			
			let $this = this;
			
			let params = $.extend(true, {}, this.params.fatpQustBase);
			
            if ( isSearch ) {
                params.currentPage  = 1;
                params.currentIndex = 0;
            }

/*            $this.params.fatpQustBase =
			{
				qustVer      : '' , //설문_버전
				qustNo       : '' , //설문_번호
				qustCntn     : '' , //설문_번호
				paging       : 'Y',
	            totalCount   : 0,
	            rowCount     : 30,
	            currentPage  : 1,
	            currentIndex : 0
			}*/

            $("#fatpQustSpec_list").clearGridData();

			$("#fatpQustBase_list").setGridParam({
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

		searchFatpQustSpecList : function(isSearch) {
			
			let $this = this;
			let params = $.extend(true, {}, $this.params.fatpQustSpec);
			
            if ( isSearch ) {
                params.currentPage  = 1;
                params.currentIndex = 0;
            }

            $("#fatpQustSpec_list").setGridParam({
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

		downloadExcelFatpQustBase : function() {
			
			let $this = this;
			
			let params = $.extend(true, {}, $this.params.cdGrp);
			
			AjaxUtil.post({
				dataType: 'binary',
                url: "/svcStnd/fat/fatpQustMng/searchCdGrpList/excel.ab",
                param: params,
                success: function(response) {
                	saveFileLocal(response, 'CodeGroup.xls');
                },
                error: function (response) {
                    Swal.alert([response, 'error']);
                }
            });
		},
		downloadExcelFatpQustSpec : function() {
			
			let $this = this;
			
			let params = $.extend(true, {}, $this.params.cdSpec);
			
			AjaxUtil.post({
				dataType: 'binary',
                url: "/svcStnd/fat/fatpQustMng/searchCdSpecList/excel.ab",
                param: params,
                success: function(response) {
                	saveFileLocal(response, 'CodeSpec.xls');
                },
                error: function (response) {
                    Swal.alert([response, 'error']);
                }
            });
		},

		regFatpQustBaseDetlPop: function(qustVer, qustNo) {

			fatpQustBaseDetl.initPage(qustVer, qustNo);
		},
		regFatpQustSpecDetlPop: function(qustVer, qustNo) {
			
			let $this = this;
			
			if ( WebUtil.isNull($this.params.fatpQustBase.qustVer))
			{
				Swal.alert(['비만예측설문 기본을 먼저 조회하시기 바랍니다.', 'info']);
			}
			else
			{
				let crud = 'U';
				if ( WebUtil.isNull(ansSeq) ) {
					crud    = 'C';
					qustVer = $this.params.fatpQustSpec.qustVer;
					qustNo  = $this.params.fatpQustSpec.qustNo;
				}

				$('#fatpQustSpecDetlPopup').modal('show');
				fatpQustSpecDetl.initPage(qustVer, qustNo);

			}
		},
		resetSearchParam: function() {
			let $this = this;
			$this.params = {
				cdGrp : {
					cdGrp: '',
					cdGrpNm: '',
					paging: 'Y',
		            totalCount: 0,
		            rowCount: 30,
		            currentPage: 1,
		            currentIndex: 0
				},
				cdSpec: {
					cdGrp: '',
					paging: 'Y',
		            totalCount: 0,
		            rowCount: 30,
		            currentPage: 1,
		            currentIndex: 0
				}
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
