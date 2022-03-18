let hbitStatStndMng = new Vue({
    el: "#hbitStatStndMng",
    data: {
    	params: {
    	     sexCdTemp    :''
    	    ,ageYcntTemp  :''
    	    ,hbitCntFrTemp:''
    	    ,sex_cd		  :''
            ,age_ycnt     :''
            ,hbit_cnt_fr  :''
            ,hbit_cnt_to  :''
            ,hbit_stat_cd :''
            ,reg_dt		  :''
            ,reg_tm		  :''
            ,reg_user_id  :''
            ,upt_dt		  :''
            ,upt_tm		  :''
            ,upt_user_id  :''
    		,paging       :'Y'
    		,totalCount   :0
            ,rowCount     :30
            ,currentPage  :1
            ,currentIndex :0
    	},
        code:{
            sexCdList       : [],
            hbitStatCdList  : []
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
            //성별
            getCommonCodeList('SEX_CD',$this.code.sexCdList, function()
            {
                $this.initGrid();
                $this.searchHbitStatStndList(true);
            }
            );
            //심박상태코드
            getCommonCodeList('HBIT_STAT_CD',$this.code.hbitStatCdList, function()
            {
                $this.initGrid();
                $this.searchHbitStatStndList(true);
            }
            );
        },
        initGrid: function() {
            let $this = this;
            let sexCdList       = commonGridCmonCd($this.code.sexCdList);
            let hbitStatCdList  = commonGridCmonCd($this.code.hbitStatCdList);
        	let colModels =
            [
                {name:"crud"               , index: "crud"             , label:"crud"               , hidden:true},
                {name:"sexCdTemp"          , index: "sexCdTemp"        , label: "성별코드"            , width: 50         , align: "center", hidden:true},
                {name:"ageYcntTemp"        , index: "ageYcntTemp"      , label: "나이년수"            , width: 50         , align: "center", hidden:true},
                {name:"hbitCntFrTemp"      , index: "hbitCntFrTemp"    , label: "심박수 FORM"         , width: 50        , align: "center", hidden:true},
                {name: "sexCd"             , index: "sexCd"            , label: "성별"               , width: 80         , align: "center" , editable: true
                    , editable: true  ,edittype:"select"	, formatter:"select", editoptions : {value:sexCdList}},
                {name: "ageYcnt"           , index: "ageYcnt"          , label: "나이년수"            , width: 80        , align: "center"
                    , editable: true , editrules:{number:true}},
                {name: "hbitCntFr"          , index: "hbitCntFr"       , label: "심박수 FORM"         , width: 80        , align: "center"
                    , editable: true , editrules:{number:true}},
                {name: "hbitCntTo"          , index: "hbitCntTo"       , label: "심박수 TO"           , width: 80        , align: "center"
                    , editable: true , editrules:{number:true}},
                {name: "hbitStatCd"         , index: "hbitStatCd"      , label: "심박상태 코드"         , width: 80       , align: "center"
                    , editable: true  ,edittype:"select"	, formatter:"select", editoptions : {value:hbitStatCdList}},
                {name: "regDt"              , index: "regDt"           , label: "등록일자"            , width: 80         , align: "center"
                    , formatter: function(cellValue, options, rowObject) { return formatDate(cellValue);                                              }},
                {name: "regTm"              , index: "regTm"           , label: "등록시각"            , width: 80         , align: "center"
                    , formatter: function(cellValue, options, rowObject) { return formatTime(cellValue);                                              }},
                {name: "regUserId"          , index: "regUserId"       , label: "등록사용자ID"         , width: 80        , align: "center"},
                {name: "uptDt"              , index: "uptDt"           , label: "수정일자"             , width: 80        , align: "center"
                    , formatter: function(cellValue, options, rowObject) { return formatDate(cellValue);                                              }},
                {name: "uptTm"              , index: "uptTm"           , label: "수정시각"             , width: 80        , align: "center"
                    , formatter: function(cellValue, options, rowObject) { return formatTime(cellValue);                                              }},
                {name: "uptUserId"          , index: "uptUserId"       , label: "수정사용자ID"         , width: 80        , align: "center"}
            ];
  
            $("#user_list").jqGrid("GridUnload");
           	$("#user_list").jqGrid($.extend(true, {}, commonEditGridOptions(), {
            	datatype: "local",
            	mtype: 'post',
                url: '/svcStnd/dgem/hbitStatStndMng/searchHbitStatStndList.ab',
                pager: '#user_pager_list',
				height: 405,
                colModel: colModels,
                onPaging : function(data) {
                    onPagingCommon(data, this, function(resultMap) {
                        $this.params.currentPage  = resultMap.currentPage;
                        $this.params.rowCount     = resultMap.rowCount;
                        $this.params.currentIndex = resultMap.currentIndex;
                        $this.searchHbitStatStndList(false);
                    })
                },
                afterSaveCell : function (rowid, colId, val, e)
                {
                    if($("#user_list").getRowData(rowid).crud != "C" && $("#user_list").getRowData(rowid).crud != "D" ) {
                        $("#user_list").setRowData(rowid, {crud: "U"}
                        );
                    }
                }
            }));
            resizeJqGridWidth("user_list", "user_list_wrapper");                        
        },
        searchHbitStatStndList: function(isSearch) {
			let $this = this;
            let params = $.extend(true, {}, $this.params);

            if ( isSearch ) {
                params.currentPage = 1;
                params.currentIndex = 0;
            }
            
			$("#user_list").setGridParam({
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
            var cnt = $("#user_list").jqGrid("getGridParam", "records")+1;

            var addRow = {
                 crud:"C"
                ,sexCdTemp    :""
                ,ageYcntTemp  :""
                ,hbitCntFrTemp:""
                ,sex_cd		  :""
                ,age_ycnt     :""
                ,hbit_cnt_fr  :""
                ,hbit_cnt_to  :""
                ,hbit_stat_cd :""
                ,regDt:date
                ,regTm:date
                ,regUserId:$this.userId
                ,uptDt:date
                ,uptTm:date
                ,uptUserId:$this.userId
            };
            $("#user_list").addRowData(cnt, addRow);

        },
        btnDelRow : function() {
            //var checkIds = $("#dgem_list").jqGrid("getGridParam","selarrrow") + ""; // 멀티
            let checkIds = $("#user_list").jqGrid("getGridParam","selrow") + "";  // 단건
            if ( checkIds == "" )
            {
                alert("삭제할 행을 선택해주십시요.");
                return false;
            }

            let checkId = checkIds.split(",");
            for ( var i in checkId )
            {
                if ( $("#user_list").getRowData(checkId[i]).crud == "C" )
                {
                    $("#user_list").setRowData(checkId[i], {crud:"N"});
                    $("#"+checkId[i],"#user_list").css({display:"none"});
                }
                else
                {
                    $("#user_list").setRowData(checkId[i], {crud:"D"});
                    $("#"+checkId[i],"#user_list").css({display:"none"});
                }
            }
        },
        btnSave  :  function() {
            let $this = this;
            let gridData = commonGridGetDataNew($("#user_list"));

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
                url: "/svcStnd/dgem/hbitStatStndMng/saveHbitStatStnd.ab",
                param: param,
                success: function(response) {
                    Swal.alert(['저장이 완료되었습니다.', 'success']).then(function() {
                        $this.searchHbitStatStndList(true);
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
                url: "/svcStnd/dgem/hbitStatStndMng/searchHbitStatStndList/excel.ab",
                param: params,
                success: function(response)
                {
                    saveFileLocal(response, 'ddPalMng.xls');
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
                 sexCd		 :''
                ,ageYcnt     :''
                ,hbitStatCd  :''
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