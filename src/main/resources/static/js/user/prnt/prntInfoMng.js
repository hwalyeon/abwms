let prntInfoInfoMng = new Vue({
    el: "#prntInfoMng",
    data:
        {
            codeCount : 0,
            params:
                {
                    entrDtFr       : '' ,  //가입_일자_From
                    entrDtTo       : '' ,  //가입_일자_To
                    entrDt         : '' ,  //가입_일자
                    stdtNo         : '' ,  //학생_번호
                    stdtNm         : '' ,  //학생_명
                    telNo          : '' ,  //전화_번호
                    bandId         : '' ,  //밴드_ID
                    guarNo         : '' ,  //보호자_번호
                    guarNm         : '' ,  //보호자_명
                    guarTelNo      : '' ,  //보호자_전화_번호
                    paging         : 'Y',
                    totalCoun      : 0  ,
                    rowCount       : 30 ,
                    currentPage    : 1  ,
                    currentIndex   : 0  ,

                },
            code:
                {
                },
        },
    methods:
        {
            initialize: function()
            {
                let $this = this;

                $this.initCodeList();
                $this.initGrid();
                $this.searchPrntInfoList(true);
            },
            initCodeList : function()
            {
                let $this = this;

            },
            initGrid: function()
            {
                let $this              = this;
                let colModels =
                    [
                        {name: "crud"             , index: "crud"             , label: "crud"		 	    , hidden: true                                },
                        {name: "guarNoTemp"       , index: "guarNoTemp"       , label: "보호자번호"			, width: 80 , align: "center" , hidden: true  },
                        {name: "entrDt"           , index: "entrDt"           , label: "가입일자"		 	, width: 80 , align: "center" },
                        {name: "stdtNo"           , index: "stdtNo"           , label: "학생번호"		 	, width: 80 , align: "center" },
                        {name: "stdtNm"           , index: "stdtNm"           , label: "학생명"		    	, width: 80 , align: "center" },
                        {name: "telNo"            , index: "telNo"            , label: "전화번호"			, width: 80 , align: "center" },
                        {name: "eorgLocNo"        , index: "eorgLocNo"        , label: "학교(학원)명"		, width: 80 , align: "center" },
                        {name: "bandId"           , index: "bandId"           , label: "밴드ID"		    	, width: 80 , align: "center" },
                        {name: "guarNo"           , index: "guarNo"           , label: "보호자번호"		 	, width: 80 , align: "center" },
                        {name: "guarNm"           , index: "guarNm"           , label: "보호자명"	 	 	, width: 80 , align: "center" },
                        {name: "guarTelNo"        , index: "guarTelNo"        , label: "보호자전화번호" 	 	, width: 80 , align: "center" },
                        {name: "termDivCd"        , index: "termDivCd"        , label: "약관구분명" 	 	    , width: 80 , align: "center" },
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

                $("#prntInfo_list").jqGrid("GridUnload");
                $("#prntInfo_list").jqGrid($.extend(true, {}, commonGridOptions(),
                    {
                        datatype : "local",
                        mtype    : 'post',
                        url      : '/user/prnt/prntInfoMng/searchPrntInfoList.ab',
                        pager    : '#prntInfo_pager_list',
                        height   : 405,
                        colModel : colModels,
                        onPaging : function(data) {
                            onPagingCommon(data, this, function(resultMap)
                            {
                                $this.params.currentPage  = resultMap.currentPage;
                                $this.params.rowCount     = resultMap.rowCount;
                                $this.params.currentIndex = resultMap.currentIndex;
                                $this.searchPrntInfoList(false);
                            })
                        },
                        afterSaveCell : function (rowid , colId , val, e ){
                            if($("#prntInfo_list").getRowData(rowid).crud != "C" && $("#prntInfo_list").getRowData(rowid).crud != "D" ) {
                                $("#prntInfo_list").setRowData(rowid, {crud:"U"});
                            }
                        }
                    }));
                resizeJqGridWidth("prntInfo_list", "prntInfo_list_wrapper");
            },
            searchPrntInfoList: function(isSearch)
            {
                let $this = this;
                let params = $.extend(true, {}, $this.params);

                if ( isSearch )
                {
                    params.currentPage = 1;
                    params.currentIndex = 0;
                }

                $("#prntInfo_list").setGridParam(
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
                        dataType: 'binary',
                        url: "/user/prnt/prntInfoMng/searchPrntInfoList/excel.ab",
                        param: params,
                        success: function(response)
                        {
                            saveFileLocal(response, 'bandOpenInfoMng.xls');
                        },
                        error: function (response)
                        {
                            Swal.alert([response, 'error']);
                        }
                    });
            },
            regPrntInfoDetlPopup: function(guarNo) {
                prntInfoDetl.initPage(guarNo);
            },
            resetSearchParam: function()
            {
                let $this = this;
                $this.params =
                {
                    userId         : '' ,
                    uptDtFr        : '' ,  //기준_일자From
                    uptDtTo        : '' ,  //기준_일자To
                    mmDd           : 'THIS_MONTH' ,  //기준_일자 _이번달
                    stdtNm         : '' ,  //학생_명
                    bandTelNo      : '' ,  //밴드_전화_번호
                    bandId         : '' ,  //밴드_ID
                    bandYtypCd     : '' ,  //밴드_출고_년월
                    bandOpenStatCd : '' ,  //밴드_개통_상태_코드
                    guarNm         : '' ,  //보호자_명
                    guarTelNo      : '' ,  //보호자_전화_번호
                    paging         : 'Y',
                    totalCoun      : 0  ,
                    rowCount       : 30 ,
                    currentPage    : 1  ,
                    currentIndex   : 0
                }
            }
        },
    computed:
        {
        },
    watch:
        {
            'codeCount' : function (value){
                let $this = this;
                if(value ===  3){
                    $this.initGrid();
                    $this.searchPrntInfoList(true);
                }
            }
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