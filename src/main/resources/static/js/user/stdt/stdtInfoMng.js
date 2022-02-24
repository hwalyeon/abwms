let stdtInfoMng = new Vue({
    el: "#stdtInfoMng",
    data: {
        params: {
            entrDtFr       : '' ,  //가입_일자_From
            entrDtTo       : '' ,  //가입_일자_To
            entrDt:'',
            guarNo:'',
            guarNm:'',
            sposNm:'',
            stdtNo:'',
            stdtNm:'',
            plcClssCd:'',
            locNm:'',
            dgemStatCd:'',
            strsIdx:'',
            growIdx:'',
            fatIdx:'',
            bandId:'',
            telNo:'',
            blthId:'',
            sexCd:'',
            bithDt:'',
            locNo:'',
            locNm:'',
            bithDt:'',
            bandStatCd:'',
            mentStrsStatCd:'',
            physStrsStatCd:'',
            useCbeeAmt:'',
            cbeeBal:'',
            paging: 'Y',
            totalCount: 0,
            rowCount: 30,
            currentPage: 1,
            currentIndex: 0
        },
        code:{
            mentGrowJudgCdList : []
        },
    },


    methods: {

        initialize: function() {

            let $this = this;

            $this.initCodeList();

            $this.initGrid();

            $this.searchGrowJudgList(true);


        },
        initCodeList: function() {
            let $this = this;
            getCommonCodeList('GROW_JUDG_CD',$this.code.mentGrowJudgCdList);
        },
        initGrid: function() {

            let colModels = [
                {name: "crud"             , index: "crud"             , label: "crud"		 	, hidden: true                                },
                {name: "guarNoTemp"       , index: "guarNoTemp"       , label: "보호자번호"			, width: 80 , align: "center" , hidden: true  },
                {name: "entrDt"           , index: "entrDt"           , label: "가입일자"		 	, width: 80 , align: "center" },
                {name: "stdtNo"           , index: "stdtNo"           , label: "학생번호"		 	, width: 80 , align: "center" },
                {name: "stdtNm"           , index: "stdtNm"           , label: "학생명"		    , width: 80 , align: "center" },
                {name: "telNo"            , index: "telNo"            , label: "전화번호"			, width: 80 , align: "center" },
                {name: "eorgLocNo"        , index: "eorgLocNo"        , label: "학교(학원)명"		, width: 80 , align: "center" },
                {name: "bandId"           , index: "bandId"           , label: "밴드ID"		    , width: 80 , align: "center" },
                {name: "guarNo"           , index: "guarNo"           , label: "보호자번호"		 	, width: 80 , align: "center" },
                {name: "guarNm"           , index: "guarNm"           , label: "보호자명"	 	 	, width: 80 , align: "center" },
                {name: "guarTelNo"        , index: "guarTelNo"        , label: "보호자전화번호" 	 	, width: 80 , align: "center" },
                {name: "sposNo"           , index: "sposNo"           , label: "배우자번호"		 	, width: 80 , align: "center" },
                {name: "sposNm"           , index: "sposNm"           , label: "배우자명"	 	 	, width: 80 , align: "center" },
                {name: "sposTelNo"        , index: "sposTelNo"        , label: "배우자전화번호" 	 	, width: 80 , align: "center" },
                {name: "termDivCd"        , index: "termDivCd"        , label: "약관구분명" 	 	, width: 80 , align: "center" },
                {name: "termAgreYn"       , index: "termAgreYn"       , label: "약관동의여부" 	 	, width: 80 , align: "center" },
                {name: "prntInfoDetlPopup" , index: "prntInfoDetlPopup" , label: "상세정보보기", width: 80, align: "center",
                    formatter: function(cellValue, options, rowObject) {
                        return '<input type="button" class="btn btn-xs btn-outline btn-success" onclick="prntInfoMng.regPrntInfoDetlPopup(\'' + rowObject.guarNo + '\')" value="상세보기" data-toggle="modal" data-target="#prntInfoDetlPopup" />';
                    }
                },
                {name: "regDt"          , index: "regDt"          , label: "등록일자"         , width: 80 , align: "center" , formatter: function(cellValue, options, rowObject) { return formatDate(cellValue);} , hidden: true },
                {name: "regTm"          , index: "regTm"          , label: "등록시각"         , width: 80 , align: "center" , formatter: function(cellValue, options, rowObject) { return formatTime(cellValue);} , hidden: true },
                {name: "regUserId"      , index: "regUserId"      , label: "등록사용자ID"     , width: 80 , align: "center"  , hidden: true},
                {name: "uptDt"          , index: "uptDt"          , label: "수정일자"         , width: 80 , align: "center" , formatter: function(cellValue, options, rowObject) { return formatDate(cellValue);} , hidden: true },
                {name: "uptTm"          , index: "uptTm"          , label: "수정시각"         , width: 80 , align: "center" , formatter: function(cellValue, options, rowObject) { return formatTime(cellValue);} , hidden: true },
                {name: "uptUserId"      , index: "uptUserId"      , label: "수정사용자ID"     , width: 80 , align: "center"  , hidden: true}

            ];



            $("#grid_list").jqGrid("GridUnload");
            $("#grid_list").jqGrid($.extend(true, {}, commonGridOptions(), {
                datatype: "local",
                mtype: 'post',
                url: '/user/stdt/stdtInfoMng/searchStdtInfoList.ab',
                pager: '#user_pager_list',
                height: 405,
                colModel: colModels,
                onPaging : function(data) {
                    onPagingCommon(data, this, function(resultMap) {
                        $this.params.currentPage  = resultMap.currentPage;
                        $this.params.rowCount     = resultMap.rowCount;
                        $this.params.currentIndex = resultMap.currentIndex;
                        $this.searchGrowJudgList(false);
                    })
                }
            }));

            resizeJqGridWidth("grid_list", "grid_list_wrapper");
        },
        searchGrowJudgList: function(isSearch) {

            let $this = this;
            let params = $.extend(true, {}, $this.params);
            if ( isSearch ) {
                params.currentPage = 1;
                params.currentIndex = 0;
            }

            $("#grid_list").setGridParam({
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
        growJudgStndNmVal:function(){
            let $this = this;
        },
        physStrsStatNmVal:function(){
            let $this = this;
        },
        regGrowJudgStndPop: function(growJudgCd) {
            growJudgStndDetl.initPage(growJudgCd);
        },
        downloadExcel : function()
        {
            let $this = this;
            let params = $.extend(true, {}, $this.params);

            AjaxUtil.post({
                dataType: 'binary',
                url: "/user/stdt/stdtInfoMng/searchStdtInfoList/excel.ab",
                param: params,
                success: function(response)
                {
                    saveFileLocal(response, 'stdtInfoMng.xls');
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
                growJudgCd:'',
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
