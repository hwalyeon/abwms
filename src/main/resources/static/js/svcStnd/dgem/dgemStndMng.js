let dgemStndMng = new Vue({
    el: "#dgemStndMng", //위험감정_상태_기준
    data:
    {
    	params:
        {
            userId                  : ''   ,
            dgemStatCdNm : ''   ,  //위험감정_상태_코드_명
    		paging                : 'Y' ,
    		totalCount          : 0   ,
            rowCount           : 30 ,
            currentPage       : 1   ,
            currentIndex      : 0
        },
            code:
        {
            dgemStatCdList : []  //위험감정_상태_코드_리스트
        },
	},
    methods:
    {
        initialize: function()
        {
        	let $this = this;

            $this.initValue();
        	$this.initCodeList();
        },
        initValue: function()
        {
            let $this = this;
            $this.userId = SessionUtil.getUserId();
        },
        initCodeList : function()
        {
            let $this = this;
            //위험감정상태 코드 목록 조회 공통코드의 경우 1건인 경우
            getCommonCodeList('DGEM_STAT_CD', $this.code.dgemStatCdList, function()
            {
                $this.initGrid();
                $this.searchDgemList(true);
            });

            //별도 테이블의 경우 - 1건의 경우
            // $this.codeList( $this.code.dgemStatCdList, function() {
            //     $this.initGrid();
            //     $this.searchDgemList(true);
            // });
        },
        initGrid: function()
        {
            let $this = this;
            let dgemStatCdList = commonGridCmonCd($this.code.dgemStatCdList); //위험감정_상태_코드_리스트
        	let colModels = [
                {name: "crud"                         , index: "crud"                         , label: "crud"                             , hidden: true  },
                {name: "dgemStatCdTemp"  , index: "dgemStatCdTemp"  , label: "위험감정상태코드"      , hidden: true  }, //update.delete 조건 값
                {name: "dgemStatCdNm"     , index: "dgemStatCdNm"      , label: "위험감정상태코드명"  , hidden: true  }, //엑셀다운로드에 필요
                {name: "dgemStatCd"           , index: "dgemStatCd"            , label: "위험감정상태코드"      , width: 80  , align: "center"  , editable: true
                 ,edittype:"select"                  , formatter:"select"                  , editoptions: {value: dgemStatCdList}  },
                {name: "dgemStatCntn"        , index: "dgemStatCntn"         , label: "위험감정상태내용"     , width: 80   , align: "center"  , editable: true  },
                {name: "regDt"                      , index: "regDt"                       , label: "등록일자"                     , width: 80   , align: "center"  , formatter: function(cellValue, options, rowObject) { return formatDate(cellValue);}  },
                {name: "regTm"                     , index: "regTm"                      , label: "등록시각"                    , width: 80   , align: "center"  , formatter: function(cellValue, options, rowObject) { return formatTime(cellValue);}  },
                {name: "regUserId"               , index: "regUserId"                 , label: "등록사용자ID"             , width: 80   , align: "center"  },
                {name: "uptDt"                      , index: "uptDt"                       , label: "수정일자"                     , width: 80   , align: "center"  , formatter: function(cellValue, options, rowObject) { return formatDate(cellValue);}  },
                {name: "uptTm"                     , index: "uptTm"                     , label: "수정시각"                     , width: 80   , align: "center"  , formatter: function(cellValue, options, rowObject) { return formatTime(cellValue);}  },
                {name: "uptUserId"                , index: "uptUserId"                , label: "수정사용자ID"             , width: 80   , align: "center"  }
            ];
  
            $("#dgem_list").jqGrid("GridUnload");
           	$("#dgem_list").jqGrid($.extend(true, {}, commonEditGridOptions(),
            {
            	datatype : "local",
            	mtype     : 'post'  ,
                url           : '/svcStnd/dgem/dgemStndMng/searchDgemList.ab',
                pager      : '#dgem_pager_list',
				height     : 405     ,
                colModel: colModels,
                onPaging : function(data)
                {
                    onPagingCommon(data, this, function(resultMap)
                    {
                        $this.params.currentPage  = resultMap.currentPage;
                        $this.params.rowCount      = resultMap.rowCount;
                        $this.params.currentIndex = resultMap.currentIndex;
                        $this.searchDgemList(false);
                    })
                },
                onCellSelect : function (rowid , colId , val, e )
                {
                    // 행의 컬럼을 하나라도 클릭했을 경우 수정으로변경
                    if($("#dgem_list").getRowData(rowid).crud != "C" && $("#dgem_list").getRowData(rowid).crud != "D" )
                    {
                        $("#dgem_list").setRowData(rowid, {crud:"U"});
                    }
                }
            }));
            resizeJqGridWidth("dgem_list", "dgem_list_wrapper");
        },
        searchDgemList: function(isSearch)
        {
			let $this     = this;
            let params = $.extend(true, {}, $this.params);
			
            if ( isSearch )
            {
                params.currentPage = 1;
                params.currentIndex = 0;
            }
            
			$("#dgem_list").setGridParam(
			{
                datatype: "json",
                postData: JSON.stringify(params),
                page: 1,
                loadComplete: function (response)
                {
                    if ( response.rtnData.result == 0 )
                    {
                        Swal.alert(['조회할 내용이 없습니다.', "info"]);
                    }
                }
            }).trigger("reloadGrid");
		},
		downloadExcel : function()
        {
			let $this = this;
			let params = $.extend(true, {}, $this.params);
			
			AjaxUtil.post(
{
				dataType : 'binary',
                url            : "/svcStnd/dgem/dgemStndMng/searchDgemList/excel.ab",
                param     : params,
                success: function(response)
                {
                	saveFileLocal(response, 'dgemStndMng.xls');
                },
                error: function (response)
                {
                    Swal.alert([response, 'error']);
                }
            });
		},
        btnAddRow  :  function()
        {
            let $this = this;
            let date = new Date(); //현재 날짜
            let cnt    = $("#dgem_list").jqGrid("getGridParam", "records")+1;

            if(WebUtil.isNotNull(this.dgemStatCd)) tempDgemStatCd = this.dgemStatCd;

            var addRow =
            {
                crud                        : "C",
                dgemStatCdTemp : ""  ,
                dgemStatCdNm    : ""  ,
                dgemStatCd          : ""  ,
                dgemStatCntn       : ""  ,
                regDt                     : date  ,
                regTm                    : date  ,
                regUserId               : $this.userId  ,
                uptDt                     : date ,
                uptTm                    : date ,
                uptUserId               : $this.userId  ,
            };
            $("#dgem_list").addRowData(cnt, addRow);
            //$("#dgem_list").jqGrid('setColProp', 'dgemStatCd', {editable:true});
            //$("#dgem_list").getCell(cnt, 2).setEditOptions({editable:true});

        },
        btnDelRow : function()
        {
            //var checkIds = $("#dgem_list").jqGrid("getGridParam","selarrrow") + ""; // 멀티
            var checkIds = $("#dgem_list").jqGrid("getGridParam","selrow") + "";  // 단건
            if ( checkIds == "" )
            {
                alert("삭제할 행을 선택해주십시요.");
                return false;
            }

            var checkId = checkIds.split(",");
            for ( var i in checkId )
            {
                if ( $("#dgem_list").getRowData(checkId[i]).crud == "C" )
                {
                    $("#dgem_list").setRowData(checkId[i], {crud:"N"});
                    $("#"+checkId[i],"#dgem_list").css({display:"none"});
                }
                else
                {
                    $("#dgem_list").setRowData(checkId[i], {crud:"D"});
                    $("#"+checkId[i],"#dgem_list").css({display:"none"});
                }
            }

        },
        btnSave  :  function()
        {
            let $this = this;
            let gridData = commonGridGetDataNew($("#dgem_list"));

            if(gridData.length > 0)
            {
                for (let data in gridData)
                {
                    if(gridData[data].crud === 'C' || gridData[data].crud === 'U')
                    {
                        if(WebUtil.isNull(gridData[data].dgemStatCd))
                        {
                            Swal.alert(["위험감정상태코드는 필수 입력입니다.", 'warning']);
                            return false;
                        }
                    }
                }
            }else
            {
                Swal.alert(["저장 대상 데이터가 없습니다.", 'warning']);
                return false;
            }

            let param = { gridList : []}
            param.gridList = gridData;

            AjaxUtil.post(
            {
                url: "/svcStnd/dgem/dgemStndMng/saveDgemStnd.ab",
                param: param,
                success: function(response)
                {
                    Swal.alert(['저장이 완료되었습니다.', 'success']).then(function()
                    {
                        $this.searchDgemList(true);
                    });
                },
                error: function (response)
                {
                    Swal.alert([response, 'error']);
                }
            });
        },
        /*codeList : function (arrayObject , callback)
        {
            AjaxUtil.post({
                url: "/svcStnd/dgem/dgemStndMng/searchDgemList.ab",
                param: {},
                success: function(response) {
                    var dataList = response.rtnData.result;

                    if (Array.isArray(arrayObject)) {
                        var dataCnt = dataList.length;
                        var m = 0;

                        for (m = 0; m < dataCnt; m++) {
                            arrayObject.push({
                                cdVal   : dataList[m].dgemStatCd,
                                cdNm    : dataList[m].dgemStatCntn,
                                sortOrd : 0
                            });
                        }
                    }

                    if (typeof callback === "function") {
                        callback(dataList);
                    }
                },
                error: function (response) {
                    alert(response);
                }
            });
        },*/
		resetSearchParam: function()
        {
			let $this = this;
			$this.params =
            {
                dgemStatCdNm:  ''  ,  //위험감정_상태_코드_명
                paging               : 'Y' ,
                totalCount         : 0   ,
                rowCount           : 30 ,
                currentPage       : 1   ,
                currentIndex      : 0
	    	}
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