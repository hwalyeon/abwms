let tempStatStndMng = new Vue({
    el: "#tempStatStndMng",
    data: {
    	params: {
             ageYcntTemp  :''
            ,tempValFrTemp:''
    	    ,ageYcnt	  :''
            ,tempValFr	  :''
            ,tempValTo	  :''
            ,tempStatCd	  :''
            ,regDt		  :''
            ,regTm		  :''
            ,regUserId  :''
            ,uptDt		  :''
            ,uptTm		  :''
            ,uptUserId  :''
    		,paging       :'Y'
    		,totalCount   :0
            ,rowCount     :30
            ,currentPage  :1
            ,currentIndex :0
    	},
        code:{
            tempStatCdList  : []
        },
	},

	
    methods: {

        initialize: function() {
        	
        	let $this = this;

        	$this.initValue();
        	$this.initCodeList();

        },
        initValue: function()
        {
            let $this = this;
            $this.userId = SessionUtil.getUserId();
        },
        initCodeList: function() {
            let $this = this;
            //체온상태코드
            getCommonCodeList('TEMP_STAT_CD',$this.code.tempStatCdList, function()
            {
                $this.initGrid();
                $this.searchTempStatStndList(true);
            }
            );
        },
        initGrid: function() {
            let $this = this;
            let tempStatCdList  = commonGridCmonCd($this.code.tempStatCdList);
        	let colModels =
            [
                {name:"crud"               , index: "crud"             , label:"crud"               , hidden:true},
                {name:"ageYcntTemp"        , index: "ageYcntTemp"      , label: "나이년수"            , width: 50        , align: "center", hidden:true},
                {name:"tempValFrTemp"       , index: "tempValFrTemp"   , label: "FORM"               , width: 50        , align: "center", hidden:true},
                {name: "ageYcnt"           , index: "ageYcnt"          , label: "나이년수"            , width: 80        , align: "center"
                    , editable: true , editrules:{number:true}},
                {name: "tempValFr"         , index: "tempValFr"        , label: "체온값 FORM"         , width: 80        , align: "center"
                    , editable: true , editrules:{number:true}},
                {name: "tempValTo"         , index: "tempValTo"        , label: "체온값 TO"           , width: 80        , align: "center"
                    , editable: true , editrules:{number:true}},
                {name: "tempStatCd"        , index: "tempStatCd"       , label: "심박상태 코드"        , width: 80        , align: "center"
                    , editable: true  ,edittype:"select"	, formatter:"select", editoptions : {value:tempStatCdList}},
                {name: "regDt"             , index: "regDt"            , label: "등록일자"            , width: 80         , align: "center"
                    , formatter: function(cellValue, options, rowObject) { return formatDate(cellValue);                                              }},
                {name: "regTm"             , index: "regTm"            , label: "등록시각"            , width: 80         , align: "center"
                    , formatter: function(cellValue, options, rowObject) { return formatTime(cellValue);                                              }},
                {name: "regUserId"         , index: "regUserId"        , label: "등록사용자ID"         , width: 80        , align: "center"},
                {name: "uptDt"             , index: "uptDt"            , label: "수정일자"            , width: 80        , align: "center"
                    , formatter: function(cellValue, options, rowObject) { return formatDate(cellValue);                                              }},
                {name: "uptTm"             , index: "uptTm"            , label: "수정시각"            , width: 80        , align: "center"
                    , formatter: function(cellValue, options, rowObject) { return formatTime(cellValue);                                              }},
                {name: "uptUserId"         , index: "uptUserId"        , label: "수정사용자ID"        , width: 80        , align: "center"}
            ];
  
            $("#temp_list").jqGrid("GridUnload");
           	$("#temp_list").jqGrid($.extend(true, {}, commonEditGridOptions(), {
            	datatype: "local",
            	mtype: 'post',
                url: '/svcStnd/dgem/tempStatStndMng/searchTempStatStndList.ab',
                pager: '#temp_pager_list',
				height: 405,
                colModel: colModels,
                onPaging : function(data) {
                    onPagingCommon(data, this, function(resultMap) {
                        $this.params.currentPage  = resultMap.currentPage;
                        $this.params.rowCount     = resultMap.rowCount;
                        $this.params.currentIndex = resultMap.currentIndex;
                        $this.searchTempStatStndList(false);
                    })
                },
                afterSaveCell : function (rowid, colId, val, e)
                {
                    if($("#temp_list").getRowData(rowid).crud != "C" && $("#temp_list").getRowData(rowid).crud != "D" ) {
                        $("#temp_list").setRowData(rowid, {crud: "U"}
                        );
                    }
                }
            }));
            resizeJqGridWidth("temp_list", "temp_list_wrapper");
        },
        searchTempStatStndList: function(isSearch) {
			let $this = this;
            let params = $.extend(true, {}, $this.params);

            if ( isSearch ) {
                params.currentPage = 1;
                params.currentIndex = 0;
            }

			$("#temp_list").setGridParam({
                datatype: "json",
                postData: JSON.stringify(params),
                page: 1,
                loadComplete: function (response) {
                    console.log(response.rtnData.result);
                    if ( response.rtnData.result == 0 ) {
                        Swal.alert(['조회할 내용이 없습니다.', "info"]);
                    }
                }
            }).trigger("reloadGrid");
		},

        btnAddRow  :  function() {
            let $this = this;
            let date  = new Date();
            var cnt = $("#temp_list").jqGrid("getGridParam", "records")+1;

            var addRow = {
                 crud:"C"
                ,ageYcnt	:""
                ,tempValFr	:""
                ,tempValTo	:""
                ,tempStatCd	:""
                ,regDt:date
                ,regTm:date
                ,regUserId:$this.userId
                ,uptDt:date
                ,uptTm:date
                ,uptUserId:$this.userId
            };
            $("#temp_list").addRowData(cnt, addRow);

        },
        btnDelRow : function() {
            //var checkIds = $("#dgem_list").jqGrid("getGridParam","selarrrow") + ""; // 멀티
            let checkIds = $("#temp_list").jqGrid("getGridParam","selrow") + "";  // 단건
            if ( checkIds == "" )
            {
                alert("삭제할 행을 선택해주십시요.");
                return false;
            }

            let checkId = checkIds.split(",");
            for ( var i in checkId )
            {
                if ( $("#temp_list").getRowData(checkId[i]).crud == "C" )
                {
                    $("#temp_list").setRowData(checkId[i], {crud:"N"});
                    $("#"+checkId[i],"#temp_list").css({display:"none"});
                }
                else
                {
                    $("#temp_list").setRowData(checkId[i], {crud:"D"});
                    $("#"+checkId[i],"#temp_list").css({display:"none"});
                }
            }
        },
        btnSave  :  function() {
            let $this = this;
            let gridData = commonGridGetDataNew($("#temp_list"));

            if(gridData.length > 0)
            {
                /*for (let data in gridData)
                {
                    if(gridData[data].crud === 'C' || gridData[data].crud === 'U')
                    {
                    if(WebUtil.isNull(gridData[data].currFatJudgCd)){
                        Swal.alert(["현재비만판정코드 필수 입력입니다.", 'warning']);
                        return false;
                    }if(WebUtil.isNull(gridData[data].prdtFatJudgCd)){
                        Swal.alert(["예측비만판정코드 필수 입력입니다.", 'warning']);
                        return false;
                    }if(WebUtil.isNull(gridData[data].sexCd)){
                        Swal.alert(["성별 코드 필수 입력입니다.", 'warning']);
                        return false;
                    }if(WebUtil.isNull(gridData[data].ageYcnt)){
                        Swal.alert(["나이년수 필수 입력입니다.", 'warning']);
                        return false;
                    }if(WebUtil.isNull(gridData[data].calQtyFr)){
                        Swal.alert(["칼로리량 FORM 필수 입력입니다.", 'warning']);
                        return false;
                    }if(WebUtil.isNull(gridData[data].calQtyTo)){
                        Swal.alert(["칼로리량 TO 필수 입력입니다.", 'warning']);
                        return false;
                    }if(WebUtil.isNull(gridData[data].ddCalQty)){
                        Swal.alert(["일일 칼로리량 필수 입력입니다.", 'warning']);
                        return false;
                    }if(WebUtil.isNull(gridData[data].palCd)){
                        Swal.alert(["신체활동수준 코드 필수 입력입니다.", 'warning']);
                        return false;
                    }if(WebUtil.isNull(gridData[data].nutrCd)){
                        Swal.alert(["영양소 코드 필수 입력입니다.", 'warning']);
                        return false;
                    }if(WebUtil.isNull(gridData[data].nutrStatCd)){
                        Swal.alert(["영양섭취 상태 코드 필수 입력입니다.", 'warning']);
                        return false;
                    }
                    }
                }*/
            }
            else
            {
                Swal.alert(["저장 대상 데이터가 없습니다.", 'warning']);
                return false;
            }
            let param = { gridList : []}
            param.gridList = gridData;

            AjaxUtil.post({
                url: "/svcStnd/dgem/tempStatStndMng/saveTempStatStnd.ab",
                param: param,
                success: function(response) {
                    Swal.alert(['저장이 완료되었습니다.', 'success']).then(function() {
                        $this.searchTempStatStndList(true);
                    });
                },
                error: function (response) {
                    Swal.alert([response, 'error']);
                }
            });
        },


        downloadExcel : function()
        {
            let $this = this;
            let params = $.extend(true, {}, $this.params);

            AjaxUtil.post({
                dataType: 'binary',
                url: "/svcStnd/dgem/tempStatStndMng/searchTempStatStndList/excel.ab",
                param: params,
                success: function(response)
                {
                    saveFileLocal(response, '체온상태기준.xls');
                },
                error: function (response)
                {
                    Swal.alert([response, 'error']);
                }
            });
        },


		resetSearchParam: function() {
			let $this = this;
			$this.params = {
                 ageYcnt     :''
                ,tempValFr   :''
                ,tempValTo   :''
                ,tempStatCd  :''
	    		,paging      :'Y'
	    		,totalCount  :0
	            ,rowCount    :30
	            ,currentPage :1
	            ,currentIndex:0
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