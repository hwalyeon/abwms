let strsStndMng = new Vue({
    el: "#strsStndMng",
    data: {
    	params: {
            mentStrsStatCd:'',
            physStrsStatCd:'',
            strsJudgCntn:'',
            regDt:'',
            regTm:'',
            regUserId:'',
            uptDt:'',
            uptTm:'',
            uptUserId:'',
    		useYn:'Y',
    		paging: 'Y',
    		totalCount: 0,
            rowCount: 30,
            currentPage: 1,
            currentIndex: 0
    	},
        code:{
            mentStrsStatNmList : []
        },
	},

	
    methods: {

        initialize: function() {
        	
        	let $this = this;
        	
        	$this.initCodeList();
        	$this.initValue();
        },
        initValue: function()
        {
            let $this = this;
            $this.userId = SessionUtil.getUserId();
        },

        initCodeList: function() {
            let $this = this;
            getCommonCodeList('STRS_STAT_CD',$this.code.mentStrsStatNmList, function(){
                $this.initGrid();
                $this.searchStrsList(true);
            }
            );
        },
        initGrid: function() {
            let $this = this;
            let mentStrsStatNmList = commonGridCmonCd($this.code.mentStrsStatNmList);             
        	let colModels = [
                {name: "crud"               , index: "crud"             , label: "crud"                  , hidden:true},
                //   {name: "mentStrsStatCd"     , index: "mentStrsStatCd"   , label: "정신적스트레스상태코드"    , editable :true , editrules : {number : true}, width: 80, align: "center"},
                {name: "mentStrsStatCd"	     , index: "mentStrsStatCd"	 , label: "정신적스트레스상태명" , width: 80  	 ,align:"center"
                    ,edittype:"select"	, formatter:"select", editable :true, editoptions : {value:mentStrsStatNmList}},
                {name: "mentStrsStatCdTemp"      , index: "mentStrsStatCdTemp"   ,label: "정신적스트레스상태명"  , hidden:true },
                {name: "physStrsStatCd"	     , index: "physStrsStatCd"	 , label: "신체적스트레스상태명" , width: 80  	 ,align:"center"
                    ,edittype:"select"	, formatter:"select", editable :true, editoptions : {value:mentStrsStatNmList}},
                {name: "physStrsStatTemp"      , index: "physStrsStatTemp"   ,label: "신체적스트레스상태명"  , hidden:true },
                {name: "strsJudgCntn"       , index: "strsJudgCntn"     , label: "스트레스판정내용"         , editable :true , editrules : {text : true}, width: 80, align: "center"},
                {name: "regDt"              , index: "regDt"            , label: "등록일자"                , width: 80, align: "center"
                    , formatter: function(cellValue, options, rowObject) { return formatDate(cellValue); }},
                {name: "regTm"               , index: "regTm"               , label: "등록시각"            , width: 80, align: "center"
                    , formatter: function(cellValue, options, rowObject) { return formatTime(cellValue); }},
                {name: "regUserId"          , index: "regUserId"         , label: "등록사용자ID"            , width: 80, align: "center"},
                {name: "uptDt"                , index: "uptDt"                , label: "수정일자"           , width: 80, align: "center"
                    , formatter: function(cellValue, options, rowObject) { return formatDate(cellValue); }},
                {name: "uptTm"               , index: "uptTm"               , label: "수정시각"             , width: 80, align: "center"
                    , formatter: function(cellValue, options, rowObject) { return formatTime(cellValue); }},
                {name: "uptUserId"          , index: "uptUserId"         , label: "수정사용자ID"            , width: 80, align: "center"}
            ];

        	console.log("1");
  
            $("#user_list").jqGrid("GridUnload");
           	$("#user_list").jqGrid($.extend(true, {}, commonEditGridOptions(), {
            	datatype: "local",
            	mtype: 'post',
                url: '/svcStnd/strs/strsStndMng/searchStrsList.ab',
                pager: '#user_pager_list',
				height: 405,
                colModel: colModels,
                onPaging : function(data) {
                    onPagingCommon(data, this, function(resultMap) {
                        $this.params.currentPage  = resultMap.currentPage;
                        $this.params.rowCount     = resultMap.rowCount;
                        $this.params.currentIndex = resultMap.currentIndex;
                        $this.searchStrsList(false);
                    })
                },
                afterSaveCell : function (rowid , colId , val, e ){
                    if($("#user_list").getRowData(rowid).crud != "C" && $("#user_list").getRowData(rowid).crud != "D" ) {
                        $("#user_list").setRowData(rowid, {crud:"U"});
                    }
                }
            }));
            console.log("2");
            resizeJqGridWidth("user_list", "user_list_wrapper");                        
        },
        searchStrsList: function(isSearch) {
            console.log("3");
			let $this = this;
            let params = $.extend(true, {}, $this.params);
            console.log("4");
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
            console.log("5");
		},
        mentStrsStatNmVal:function(){
            let $this = this;
        },
        physStrsStatNmVal:function(){
            let $this = this;
        },

        downloadExcel : function()
        {
            let $this = this;
            let params = $.extend(true, {}, $this.params);

            AjaxUtil.post({
                dataType: 'binary',
                url: "/svcStnd/strs/strsStndMng/searchStrsList/excel.ab",
                param: params,
                success: function(response)
                {
                    saveFileLocal(response, 'strsStndMng.xls');
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
            let date  = new Date();
            var cnt = $("#user_list").jqGrid("getGridParam", "records")+1;
            var tempStrsStndCd = "";

            if(WebUtil.isNotNull(this.strsStndCd)) tempStrsStndCd = this.strsStndCd;

            var addRow =
            {
                crud:"C",
                mentStrsStatCd:"",
                physStrsStatCd:"",
                strsJudgCntn:"",
                regDt:date,
                regTm:date,
                regUserId:$this.userId,
                uptDt:date,
                uptTm:date,
                uptUserId: $this.userId
            };
            $("#user_list").addRowData(cnt, addRow);
            //$("#user_list").jqGrid('setColProp', 'strsStndCd', {editable:true});
            //$("#user_list").getCell(cnt, 2).setEditOptions({editable:true});

        },

        btnDelRow : function() {

            //var checkIds = $("#user_list").jqGrid("getGridParam","selarrrow") + ""; // 멀티
            var checkIds = $("#user_list").jqGrid("getGridParam","selrow") + "";  // 단건
            if ( checkIds == "" )
            {
                alert("삭제할 행을 선택해주십시요.");
                return false;
            }

            var checkId = checkIds.split(",");
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


            if(gridData.length > 0){
                for (let data in gridData){
                    if(gridData[data].crud === 'C' || gridData[data].crud === 'U'){
                        if(WebUtil.isNull(gridData[data].mentStrsStatCd)){
                            Swal.alert(["위험감정상태코드는 필수 입력입니다.", 'warning']);
                            return false;
                        }

                        if(WebUtil.isNull(gridData[data].physStrsStatCd)){
                            Swal.alert(["위험감정상태내용은 필수 입력입니다.", 'warning']);
                            return false;
                        }
                    }
                }

            }else {
                Swal.alert(["저장 대상 데이터가 없습니다.", 'warning']);
                return false;
            }

            let param = { gridList : []}
            param.gridList = gridData;

            AjaxUtil.post({
                url: "/svcStnd/strs/strsStndMng/saveStrsStnd.ab",
                param: param,
                success: function(response) {
                    Swal.alert(['저장이 완료되었습니다.', 'success']).then(function() {
                        $this.searchStrsList(true);
                    });
                },
                error: function (response) {
                    Swal.alert([response, 'error']);
                }
            });

        },

		resetSearchParam: function() {
			let $this = this;
			$this.params = {
                mentStrsStatCd:'',
                physStrsStatCd:'',
	    		blngNm: '',
	    		telNo: '',
	    		mtelNo: '',
	    		mailAddr: '',
	    		paging: 'Y',
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