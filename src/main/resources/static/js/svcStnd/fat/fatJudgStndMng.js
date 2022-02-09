let fatJudgStndMng = new Vue({
    el: "#fatJudgStndMng",
    data: {
        params: {
            fatJudgCd:'',
            fatJudgNm:'',
            fidxFr:'',
            fidxTo:'',
            currEvalCntn:'',
            prdtEvalCntn:'',
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
            mentFatJudgCdList : []
        },
    },


    methods: {

        initialize: function() {

            let $this = this;

            $this.initCodeList();

            $this.initGrid();

            $this.searchFatJudgList(true);


        },
        initCodeList: function() {
            let $this = this;
            getCommonCodeList('FAT_JUDG_CD',$this.code.mentFatJudgCdList);
        },
        initGrid: function() {

            let colModels = [
                {name: "fatJudgCd"          , index: "fatJudgCd"        , label: "비만판정코드"           , width: 80, align: "center"},
                {name: "fatJudgNm"          , index: "fatJudgNm"        , label: "비만판정코드명"         , width: 80, align: "center"},
                {name: "fidxFr"             , index: "fidxFr"           , label: "비만지수FORM"          , width: 80, align: "center"},
                {name: "fidxTo"             , index: "fidxTo"           , label: "비만지수TO"            , width: 80, align: "center"},
                {name: "currEvalCntn"       , index: "strsJudgCntn"     , label: "현재평가내용"           , width: 80, align: "center"},
                {name: "prdtEvalCntn"       , index: "strsJudgCntn"     , label: "예측평가내용"           , width: 80, align: "center"},
                {name: "regDt"              , index: "regDt"            , label: "등록일자"              , width: 80, align: "center", formatter: function(cellValue, options, rowObject)
                    { return formatDate(cellValue); }},
                {name: "regTm", index: "regTm", label: "등록시각", width: 80, align: "center", formatter: function(cellValue, options, rowObject)
                    { return formatTime(cellValue); }},
                {name: "regUserId"          , index: "regUserId"        , label: "등록사용자ID"          , width: 80, align: "center"},
                {name: "uptDt", index: "uptDt", label: "수정일자", width: 80, align: "center", formatter: function(cellValue, options, rowObject)
                    { return formatDate(cellValue); }},
                {name: "uptTm", index: "uptTm", label: "수정시각", width: 80, align: "center", formatter: function(cellValue, options, rowObject)
                    { return formatTime(cellValue); }},
                {name: "uptUserId"          , index: "uptUserId"        , label: "수정사용자ID"          , width: 80, align: "center"},



            ];

            console.log("1");

            $("#user_list").jqGrid("GridUnload");
            $("#user_list").jqGrid($.extend(true, {}, commonGridOptions(), {
                datatype: "local",
                mtype: 'post',
                url: '/svcStnd/fat/fatJudgStndMng/searchFatJudgList.ab',
                pager: '#user_pager_list',
                height: 405,
                colModel: colModels,
                onPaging : function(data) {
                    onPagingCommon(data, this, function(resultMap) {
                        $this.params.currentPage  = resultMap.currentPage;
                        $this.params.rowCount     = resultMap.rowCount;
                        $this.params.currentIndex = resultMap.currentIndex;
                        $this.searchFatJudgList(false);
                    })
                }
            }));
            console.log("2");
            resizeJqGridWidth("user_list", "user_list_wrapper");
        },
        searchFatJudgList: function(isSearch) {
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
        mentJudgStndNmVal:function(){
            let $this = this;
        },

        downloadExcel : function()
        {
            let $this = this;
            let params = $.extend(true, {}, $this.params);

            AjaxUtil.post({
                dataType: 'binary',
                url: "/svcStnd/fat/fatJudgStndMng/searchFatJudgList/excel.ab",
                param: params,
                success: function(response)
                {
                    saveFileLocal(response, 'fatJudgStndMng.xls');
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