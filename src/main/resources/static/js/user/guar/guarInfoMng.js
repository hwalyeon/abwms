let guarInfoMng = new Vue({
    el: "#guarInfoMng",
    data:
        {
            codeCount : 0,
            params:
                {
            		userId         : '' , 
                    entrDtFr       : '' ,  //가입_일자_From
                    entrDtTo       : '' ,  //가입_일자_To
                    entrDt         : '' ,  //가입_일자
                    mmDd           : '' ,  //기준_일자 _이번달  THIS_MONTH
                    stdtNm         : '' ,  //학생_명
                    telNo          : '' ,  //전화_번호(밴드)
                    stdtNo         : '' ,  //학생_번호
                    bandId         : '' ,  //밴드_ID
                    guarNo         : '' ,  //보호자_번호
                    guarNm         : '' ,  //보호자_명
                    guarTelNo      : '' ,  //보호자_전화_번호
                    locNm          : '' ,  //위치_명
                    paging         : 'Y',
                    totalCoun      : 0  ,
                    rowCount       : 30 ,
                    currentPage    : 1  ,
                    currentIndex   : 0  ,

                },
            code:
                {
            	    mmDdList        : [] , //기준_일자_이번달_리스트
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
                $this.searchGuarInfoList(true);
            },
            initValue: function()
            {
                let $this    = this;
                $this.userId = SessionUtil.getUserId();
                //이번 달 기본 값 세팅
                $this.code.mmDdList = CodeUtil.getPeriodDateList();
                const terms = getPeriodDate($this.params.mmDd);
                this.params.entrDtFr = terms.strDt;
                this.params.entrDtTo = terms.endDt;
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
                        {name: "crud"         , index: "crud"         , label: "crud"		   , hidden: true },
                        {name: "guarNoTemp"   , index: "guarNoTemp"   , label: "보호자번호"     , hidden: true },
                        {name: "prntNoTemp"   , index: "prntNoTemp"   , label: "학부모번호"     , hidden: true },
                        {name: "guarNo"       , index: "guarNo"       , label: "보호자번호"     , width: 40     , align: "center"  , formatter: function(cellValue, options, rowObject){
                                return `<a data-toggle="modal" class="links" data-target="#guarInfoDetlPopup" data-guar data-placement="bottom" title="${cellValue}" data-guar-no="${rowObject.guarNo}" data-stdt-no="${rowObject.stdtNo}">${cellValue}</a>`;}},
                        {name: "guarNm"       , index: "guarNm"       , label: "보호자명"	   , width: 80     , align: "center"  , formatter: function(cellValue, options, rowObject){
                                return `<a data-toggle="modal" class="links" data-target="#guarInfoDetlPopup" data-guar data-placement="bottom" title="${cellValue}" data-guar-no="${rowObject.guarNo}"data-stdt-no="${rowObject.stdtNo}">${cellValue}</a>`;}},
                        {name: "guarTelNo"    , index: "guarTelNo"    , label: "보호자전화번호" , width: 80     , align: "center"  , formatter: function(cellValue, options, rowObject){
                                let guarTelNoTemp = phoneFormatter(cellValue);
                                return `<a data-toggle="modal" class="links" data-target="#guarInfoDetlPopup"  data-guar  data-placement="bottom" title="${guarTelNoTemp}" data-guar-no="${rowObject.guarNo}"data-stdt-no="${rowObject.stdtNo}">${guarTelNoTemp}</a>`;}},
                        {name: "stdtNo"       , index: "stdtNo"       , label: "학생번호"	 , width: 40     , align: "center" },
                        {name: "stdtNm"       , index: "stdtNm"       , label: "학생명"	     , width: 80     , align: "center" },
                        {name: "entrDt"       , index: "entrDt"       , label: "가입일자"	 , width: 80     , align: "center"  , formatter: function(cellValue, options, rowObject){return formatDate(cellValue);}},
                        {name: "entrStatCdNm" , index: "entrStatCdNm" , label: "가입상태"	 , width: 80     , align: "center" },
                        {name: "locNm"        , index: "locNm"        , label: "학교(학원)명", width: 80     , align: "center" },
                        {name: "bandId"       , index: "bandId"       , label: "밴드ID"		 , width: 80     , align: "center"  , formatter: function(cellValue, options, rowObject){
                                return `<a data-toggle="modal" class="links" data-target="#bandOpenInfoDetlPopup" data-band data-placement="bottom" title="${cellValue}" data-band-id="${rowObject.bandId}">${cellValue}</a>`;}},
                        {name: "telNo"        , index: "telNo"        , label: "밴드전화번호" , width: 80     , align: "center"  , formatter: function(cellValue, options, rowObject){
                                let phonNoTemp =  phoneFormatter(cellValue);
                                return `<a data-toggle="modal" class="links" data-target="#bandOpenInfoDetlPopup" data-band data-placement="bottom" title="${phonNoTemp}" data-band-id="${rowObject.bandId}">${phonNoTemp}</a>`;}},
                        {name: "prntNo"       , index: "prntNo"       , label: "학부모번호"	 , width: 40     , align: "center" },
                        {name: "prntNmMale"   , index: "prntNmMale"   , label: "남자학부모"	 , width: 80     , align: "center" , formatter: function(cellValue, options, rowObject){
                                if(WebUtil.isNull(cellValue)) return '<input type="button" class="btn btn-xs btn-outline btn-success" onclick="guarInfoMng.regPrntInfoDetlPopup(\'' + rowObject.prntNo + '\',\'' + 'MALE' + '\')" value="신규" data-toggle="modal" data-target="#prntInfoDetlPopup" />';
                                else return`<a data-toggle="modal" class="links" data-target="#prntInfoDetlPopup" data-prnt data-placement="bottom" title="${cellValue}" data-prnt-no="${rowObject.prntNo}" data-sex-cd="MALE">${cellValue}</a>`;}},
                        {name: "prntNmFemale" , index: "prntNmFemale" , label: "여자학부모" 	 , width: 80     , align: "center" },
                        {name: "termAgreYnInfoDetlPopup"  , index: "termAgreYnInfoDetlPopup" , label: "약관동의여부" , width: 80, align: "center", formatter: function(cellValue, options, rowObject) {
                          return '<input type="button" class="btn btn-xs btn-outline btn-success" onclick="guarInfoMng.regTermAgreYnInfoDetlPopup(\'' + rowObject.guarNo + '\')" value="상세보기" data-toggle="modal" data-target="#termAgreYnInfoDetlPopup" />'; }}
                    ];

                $("#guarInfo_list").jqGrid("GridUnload");
                $("#guarInfo_list").jqGrid($.extend(true, {}, commonGridOptions(),
                    {
                        datatype : "local",
                        mtype    : 'post',
                        url      : '/user/guar/guarInfoMng/searchGuarInfoList.ab',
                        pager    : '#guarInfo_pager_list',
                        height   : 405,
                        colModel : colModels,
                        onPaging : function(data) {
                            onPagingCommon(data, this, function(resultMap)
                            {
                                $this.params.currentPage  = resultMap.currentPage;
                                $this.params.rowCount     = resultMap.rowCount;
                                $this.params.currentIndex = resultMap.currentIndex;
                                $this.searchGuarInfoList(false);
                            })
                        },
                        afterSaveCell : function (rowid , colId , val, e ){
                            if($("#guarInfo_list").getRowData(rowid).crud != "C" && $("#guarInfo_list").getRowData(rowid).crud != "D" ) {
                                $("#guarInfo_list").setRowData(rowid, {crud:"U"});
                            }
                        },
                        gridComplete: function () {
                            //보호자(사용자)정보 상세 팝업
                            $("#guarInfo_list").find('A.links[data-guar]').on('click', function(e) {
                                guarInfoMng.regGuarInfoDetlPopup($(e.target).data('guar-no'),$(e.target).data('stdt-no'))
                            });
                            //밴드/개통정보 상세 팝업
                            $("#guarInfo_list").find('A.links[data-band]').on('click', function(e) {
                                guarInfoMng.regBandOpenInfoDetlPopup($(e.target).data('band-id'))
                            });
                            //학부모정보 상세 팝업
                            $("#guarInfo_list").find('A.links[data-prnt]').on('click', function(e) {
                                guarInfoMng.regPrntInfoDetlPopup($(e.target).data('prnt-no'),$(e.target).data('sex-cd'))
                            });
                        }
                    }));
                resizeJqGridWidth("guarInfo_list", "guarInfo_list_wrapper");
            },
            searchGuarInfoList: function(isSearch)
            {
                let $this = this;
                let params = $.extend(true, {}, $this.params);

                if ( isSearch )
                {
                    params.currentPage = 1;
                    params.currentIndex = 0;
                }
                $("#guarInfo_list").setGridParam(
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
           //기간_선택
            mmDdSelect: function()
            {
                let $this = this;
                const terms = getPeriodDate($this.params.mmDd);
                this.params.entrDtFr = terms.strDt;
                this.params.entrDtTo = terms.endDt;
            },
            downloadExcel : function()
            {
                let $this = this;
                let params = $.extend(true, {}, $this.params);

                AjaxUtil.post(
                    {
                        dataType: 'binary',
                        url: "/user/guar/guarInfoMng/searchGuarInfoList/excel.ab",
                        param: params,
                        success: function(response)
                        {
                            saveFileLocal(response, 'guarInfoMng.xls');
                        },
                        error: function (response)
                        {
                            Swal.alert([response, 'error']);
                        }
                    });
            },
            regGuarInfoDetlPopup: function(guarNo,stdtNo) {
                guarInfoDetl.initPage(guarNo,stdtNo);
            },
            regBandOpenInfoDetlPopup: function(bandId) {
                bandOpenInfoDetl.initPage(bandId, function(){  guarInfoMng.searchGuarInfoList(true) });
            },
            regPrntInfoDetlPopup: function(prntNo, sexCd) {
                alert("sexCd " + sexCd);
                prntInfoDetl.initPage(prntNo,sexCd);
            },
            regTermAgreYnInfoDetlPopup: function(guarNo){
                termAgreYnInfoDetl.initPage(guarNo);
            },
            resetSearchParam: function()
            {
                let $this = this;
                $this.params =
                {
                    userId         : '' ,
                    uptDtFr        : '' ,  //기준_일자From
                    uptDtTo        : '' ,  //기준_일자To
                    mmDd           : '' ,  //기준_일자 _이번달
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
                    $this.searchGuarInfoList(true);
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

