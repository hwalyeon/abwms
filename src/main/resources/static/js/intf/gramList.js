const gramList = new Vue({
    el : "#gramList",
    data : {
        params : {
            reqDtFr: '',
            reqDtTo: '',
            apiDivCd: '',
            rspsCd: '',
            paging : 'Y',
            totalCount : 0,
            rowCount : 30,
            currentPage : 1,
            currentIndex : 0
        },
        code : {
            apiDivList : [],
            rspsList: [
                {cdVal: '00', cdNm: '정상'},
                {cdVal: '99', cdNm: '오류'}
            ]
        }
    },
    methods : {

        initialize : function() {
            let $this = this;
            $this.initData();
            $this.initCodeList();
            $this.initGrid();
            $this.setDatepicker();
            $this.searchGramList(true);
        },
        initData: function() {
            this.resetSearchParam();
            this.params.reqDtFr = moment().format(dataPickerFormat);
            this.params.reqDtTo = moment().format(dataPickerFormat);
        },
        initCodeList : function() {
            getCommonCodeList('API_DIV_CD', this.code.apiDivList);
        },
        initGrid : function() {
            const $this = this;
            const colModels = [
                {name: "gramNo"  , index: "gramNo"  , label: "전문번호"   , width: 50 , align: "center"},
                {name: "apiDivCd", index: "apiDivCd", label: "API구분코드", width: 50 , align: "center"},
                {name: "apiDivNm", index: "apiDivNm", label: "API구분"   , width: 50 , align: "center"},
                {name: "reqDttm" , index: "reqDttm" , label: "요청일시"   , width: 100, align: "center" ,formatter: formatTimestamp},
                {name: "reqGram" , index: "reqGram" , label: "요청전문"   , editable :true, width: 500, align: "left"  },
                {name: "rspsGram", index: "rspsGram", label: "응답전문"   , editable :true, width: 300, align: "left"  },
                {name: "rspsCd"  , index: "rspsCd"  , label: "응답코드"   , width: 50 , align: "center"},
                {name: "procTcnt", index: "procTcnt", label: "처리수"     , hidden: true }//width: 80 , align: "right"  ,formatter: 'integer'}
            ];

            $("#gram_list").jqGrid("GridUnload");
            $("#gram_list").jqGrid($.extend(true, {}, commonEditGridOptions(), {
                datatype: "local",
                mtype: 'post',
                url: '/intf/gramList/searchGramList.ab',
                pager: '#gram_pager_list',
                colModel: colModels,
                onPaging : function(data) {
                    onPagingCommon(data, this, function(resultMap) {
                        $this.params.currentPage  = resultMap.currentPage;
                        $this.params.rowCount     = resultMap.rowCount;
                        $this.params.currentIndex = resultMap.currentIndex;
                        $this.searchGramList(false);
                    })
                }
            }));

            resizeJqGridWidth("gram_list", "gram_list_wrapper");
        },
        searchGramList : function(isSearch) {

            let $this = this;
            let params = $.extend(true, {}, $this.params);

            if (isSearch) {
                params.currentPage = 1;
                params.currentIndex = 0;
            }

            params.reqDtFr = params.reqDtFr.replaceAll("-", "");
            params.reqDtTo = params.reqDtTo.replaceAll("-", "");

            $("#gram_list").setGridParam({
                datatype : "json",
                postData : JSON.stringify(params),
                page : 1,
                loadComplete : function(response) {
                    if (response.rtnData.result == 0) {
                        Swal.alert([ '조회할 내용이 없습니다.', "info" ]);
                    }
                }
            }).trigger("reloadGrid");
        },
        downloadExcel : function() {

            let $this = this;

            let params = $.extend(true, {}, $this.params);

            AjaxUtil.post({
                dataType : 'binary',
                url : "/intf/gramList/searchGramList/excel.ab",
                param : params,
                success : function(response) {
                    saveFileLocal(response, '전문이력.xls');
                },
                error : function(response) {
                    Swal.alert([ response, 'error' ]);
                }
            });
        },
        setDatepicker() {
            const $this = this;
            $('#reqDtFrPicker').datepicker({
                todayBtn: "linked",
                keyboardNavigation: false,
                forceParse: false,
                calendarWeeks: true,
                autoclose: true,
                todayHighlight: true,
            }).on("changeDate", function() {
                $this.params.reqDtFr = $('#reqDtFr').val();
            });

            $('#reqDtToPicker').datepicker({
                todayBtn: "linked",
                keyboardNavigation: false,
                forceParse: false,
                calendarWeeks: true,
                autoclose: true,
                todayHighlight: true,
            }).on("changeDate", function() {
                $this.params.reqDtTo = $('#reqDtTo').val();
            });
        },
        resetSearchParam : function() {
            this.params = {
                reqDtFr: '',
                reqDtTo: '',
                apiDivCd: '',
                rspsCd: '',
                paging : 'Y',
                totalCount : 0,
                rowCount : 30,
                currentPage : 1,
                currentIndex : 0
            }
        }
    },
    mounted : function() {
        this.initialize();
    }
});
