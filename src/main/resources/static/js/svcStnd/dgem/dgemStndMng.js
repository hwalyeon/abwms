let dgemStndMng = new Vue({
    el: "#dgemStndMng", //위험감정_상태_기준
    data:
    {
    	params:
        {
            userId       : ''  ,
            actDivCd     : ''  , //활동_구분_코드
            hbitStatCd   : ''  , //심박_상태_코드
            plcClssCd    : ''  , //장소_구분_코드
            tempStatCd   : ''  , //체온_상태_코드
            dgemStatCd   : ''  , //위험감정_상태_코드
    		paging       : 'Y' ,
    		totalCount   : 0   ,
            rowCount     : 30  ,
            currentPage  : 1   ,
            currentIndex : 0
        },
        code:
        {
            actDivCdList   : [] , //활동_구분_코드_리스트
        	hbitStatCdList : [] , //심박_상태_코드_리스트
            plcClssCdList  : [] , //장소_구분_코드_리스트
        	tempStatCdList : [] , //체온_상태_코드_리스트
            dgemStatCdList : [] , //위험감정_상태_코드_리스트
        },
	},
    methods:
    {
        initialize: function()
        {
        	let $this = this;

            $this.initValue();
        	$this.initCodeList();
        	$this.initGrid();
            $this.searchDgemList(true);
        },
        initValue: function()
        {
            let $this = this;
            $this.userId = SessionUtil.getUserId();
        },
        initCodeList : function()
        {
            let $this = this;
           
            getCommonCodeList('ACT_DIV_CD'  , $this.code.actDivCdList);   //활동_구분_코드_리스트          
            getCommonCodeList('HBIT_STAT_CD', $this.code.hbitStatCdList); //심박_상태_코드_리스트          
            getCommonCodeList('PLC_CLSS_CD' , $this.code.plcClssCdList);  //장소_구분_코드_리스트          
            getCommonCodeList('TEMP_STAT_CD', $this.code.tempStatCdList); //체온_상태_코드_리스트          
            getCommonCodeList('DGEM_STAT_CD', $this.code.dgemStatCdList); //위험감정_상태_코드_리스트        
          
            //위험감정상태 코드 목록 조회 공통코드의 경우 1건인 경우

            //별도 테이블의 경우 - 1건의 경우
            // $this.codeList( $this.code.dgemStatCdList, function() {
            //     $this.initGrid();
            //     $this.searchDgemList(true);
            // });
        },
        initGrid: function()
        {
        	 let $this = this;				                                                             
             
        	let colModels = [
                {name: "crud"         , index: "crud"         , label: "crud"         , hidden: true },
                {name: "actDivCd"     , index: "actDivCd"     , label: "활동 구분 코드" 	  , hidden: true },
                {name: "hbitStatCd"   , index: "hbitStatCd"   , label: "심박 상태 코드" 	  , hidden: true }, 
                {name: "plcClssCd"    , index: "plcClssCd"    , label: "장소 분류 코드" 	  , hidden: true },
                {name: "tempStatCd"   , index: "tempStatCd"   , label: "체온 상태 코드" 	  , hidden: true },
                {name: "dgemStatCd"   , index: "dgemStatCd"   , label: "위험감정 상태 코드" , hidden: true },
                {name: "actDivCdNm"   , index: "actDivCdNm"   , label: "활동 구분" 	  , width: 50 , align: "center" },
                {name: "hbitStatCdNm" , index: "hbitStatCdNm" , label: "심박 상태" 	  , width: 50 , align: "center" },
                {name: "plcClssCdNm"  , index: "plcClssCdNm"  , label: "장소 분류" 	  , width: 50 , align: "center" },
                {name: "tempStatCdNm" , index: "tempStatCdNm" , label: "체온 상태" 	  , width: 50 , align: "center" },
                {name: "dgemIdx" 	  , index: "dgemIdx" 	  , label: "위험 감정 지수" 	  , width: 50 , align: "center" },
                {name: "dgemStatCdNm" , index: "dgemStatCdNm" , label: "위험감정 상태"    , width: 50 , align: "center" }, 
                {name: "dgemSmryCntn" , index: "dgemSmryCntn" , label: "위험감정 요약내용" , width: 80 , align: "center" 	}, 
                {name: "regDt"        , index: "regDt"        , label: "등록일자"   	  , width: 50 , align: "center"  , formatter: function(cellValue, options, rowObject) { return formatDate(cellValue);}  },
                {name: "regTm"        , index: "regTm"        , label: "등록시각"   	  , width: 50 , align: "center"  , formatter: function(cellValue, options, rowObject) { return formatTime(cellValue);}  },
                {name: "regUserId"    , index: "regUserId"    , label: "등록사용자ID"	  , width: 50 , align: "center"  },
                {name: "uptDt"        , index: "uptDt"        , label: "수정일자"    	  , width: 50 , align: "center"  , formatter: function(cellValue, options, rowObject) { return formatDate(cellValue);}  },
                {name: "uptTm"        , index: "uptTm"        , label: "수정시각"    	  , width: 50 , align: "center"  , formatter: function(cellValue, options, rowObject) { return formatTime(cellValue);}  },
                {name: "uptUserId"    , index: "uptUserId"    , label: "수정사용자ID"	  , width: 50 , align: "center"  },
                {name: "dgemStndDetlPop" , index: "dgemStndDetlPop" , label: "상세정보보기", width: 50, align: "center",
                    formatter: function(cellValue, options, rowObject) {
                        return '<input type="button" class="btn btn-xs btn-outline btn-success" onclick="dgemStndMng.regDgemStndDetlPop(\'' + rowObject.actDivCd + '\')" value="상세보기" data-toggle="modal" data-target="#dgemStndDetlPopup" />';
                    }
                }
                
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
                afterSaveCell : function (rowid , colId , val, e )
                {

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
		regDgemStndDetlPop: function(actDivCd) {
            dgemStndDetl.initPage(actDivCd);
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