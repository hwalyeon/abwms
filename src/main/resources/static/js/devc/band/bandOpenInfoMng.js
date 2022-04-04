let bandOpenInfoMng = new Vue({
    el: "#bandOpenInfoMng",
    data:
        {
            codeCount : 0,
            params:
                {
                    userId         : '' ,
                    uptDtFr        : '' ,  //기준_일자From
                    uptDtTo        : '' ,  //기준_일자To
                    bDPer           : '' ,  //기준_일자 _이번달
                    stdtNm         : '' ,  //학생_명
                    telNo          : '' ,  //밴드_전화_번호
                    bandId         : '' ,  //밴드_ID
                    bandYtypCd     : '' ,  //밴드_출고_년월
                    bandOpenStatCd : '' ,  //밴드_개통_상태_코드
                    guarNm         : '' ,  //보호자_명
                    guarTelNo      : '' ,  //보호자_전화_번호
                    paging         : 'Y',//
                    totalCoun      : 0  ,
                    rowCount       : 30 ,
                    currentPage    : 1  ,
                    currentIndex   : 0
                },
            code:
                {
                     bDPerList           : [] , //기준_일자_이번달_리스트
                     bandOpenStatCdList : [] , //밴드_개통_상태_코드_리스트
                     bandYtypCdList     : [] , //밴드_출고년월_리스트
                     bandMdlCdList      : [] , //밴드_모델_코드_리스트
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
                let $this    = this;
                $this.userId = SessionUtil.getUserId();
                //출고_년월_값 세팅
                $this.initBandYtypCdValue();
                //이번 달 기본 값 세팅
                $this.code.bDPerList = CodeUtil.getPeriodDateList();
                const terms = getPeriodDate($this.params.bDPer);
                this.params.uptDtFr = terms.strDt;
                this.params.uptDtTo = terms.endDt;
            }, //기간_선택
            bDPerSelect: function()
            {
                let $this = this;
                const terms = getPeriodDate($this.params.bDPer);
                this.params.uptDtFr = terms.strDt;
                this.params.uptDtTo = terms.endDt;
            },
            initCodeList : function()
            {
                let $this = this;

                getCommonCodeList('BAND_MDL_CD', $this.code.bandMdlCdList, function (){ $this.codeCount += 1; });  //밴드_모델_코드_리스트
                getCommonCodeList('BAND_OPEN_STAT_CD', $this.code.bandOpenStatCdList, function (){$this.codeCount += 1;})//밴드_개통_상태_코드_리스트
            },
            //출고_년월_리스트_값 세팅
             initBandYtypCdValue: function()
            {
                let $this = this;
                for(let i=2022; i<2032; i++){
                    let cdVal;
                    let cdNm;
                    for(let j=1; j<13; j++){
                        if(j<10){
                            cdVal = i+'0'+j;
                            cdNm  = i+'-0'+j;
                            $this.code.bandYtypCdList.push({'cdVal':cdVal, 'cdNm':cdNm});
                        }else{
                            cdVal = String(i)+j;
                            cdNm  = i+'-'+j;
                            $this.code.bandYtypCdList.push({'cdVal':cdVal, 'cdNm':cdNm});
                        }
                    }
                }
                $this.codeCount += 1;
            },
            initGrid: function()
            {
                let $this              = this;
                let colModels =
                    [
                        {name: "crud"             , index: "crud"             , label: "crud"		 	     , hidden: true },
                        {name: "stdtKeyNo"        , index: "stdtKeyNo"        , label: "학생key"    	     , hidden: true },
                        {name: "bandIdTemp"       , index: "bandIdTemp"       , label: "밴드ID"			     , hidden: true },
                        {name: "bandOpenStatCd"   , index: "bandOpenStatCd"   , label: "밴드개통상태코드"     , hidden: true },
                        {name: "uptDt"            , index: "uptDt"            , label: "기준일자"		     , width: 80  , align: "center"  , formatter: function(cellValue, options, rowObject) { return formatDate(cellValue);}},
                        {name: "regDt"            , index: "regDt"            , label: "밴드등록일자"	     , width: 80  , align: "center"  , formatter: function(cellValue, options, rowObject) { return formatDate(cellValue);}},
                        {name: "bandYtyp"         , index: "bandYtyp"         , label: "출고년월"		     , width: 60  , align: "center" },
                        {name: "bandMdlCd"        , index: "bandMdlCd"        , label: "모델TYPE"		     , width: 50  , align: "center" },
                        {name: "bandId"           , index: "bandId"           , label: "밴드ID"		         , width: 80  , align: "center"  , formatter: function(cellValue, options, rowObject) {
                          return `<a data-toggle="modal" class="links" data-target="#bandOpenInfoDetlPopup" data-band data-placement="bottom" title="${cellValue}" data-band-id="${rowObject.bandId}">${cellValue}</a>`;}},
                        {name: "telNo"            , index: "telNo"            , label: "밴드전화번호"		     , width: 100 , align: "center"  , formatter: function(cellValue, options, rowObject) {
                          let telNoTemp = phoneFormatter(cellValue);
                          return `<a data-toggle="modal" class="links" data-target="#bandOpenInfoDetlPopup" data-band data-placement="bottom" title="${telNoTemp}" data-band-id="${rowObject.bandId}">${telNoTemp}</a>`;}},
                        {name: "stdtNo"           , index: "stdtNo"           , label: "학생번호"		     , width: 80  , align: "center"  , formatter: function(cellValue, options, rowObject){
                                if(WebUtil.isNull(cellValue)) return '<input type="button" class="btn btn-xs btn-outline btn-success" onclick="bandOpenInfoMng.regStdtInfoDetlPopup(\'' + rowObject.guarNo + '\', \'' + rowObject.stdtNo + '\')" value="신규" data-toggle="modal" data-target="#stdtRegDetlPopup" />';
                                else return`<a data-toggle="modal" class="links" data-target="#stdtInfoDetlPopup" data-stdt data-placement="bottom" title="${cellValue}" data-guar-no="${rowObject.guarNo}" data-stdt-no="${rowObject.stdtNo}">${cellValue}</a>`;}},
                        {name: "stdtNm"           , index: "stdtNm"           , label: "학생명"		         , width: 80  , align: "center"  , formatter: function(cellValue, options, rowObject){
                                if(WebUtil.isNull(cellValue)) return '<input type="button" class="btn btn-xs btn-outline btn-success" onclick="bandOpenInfoMng.regStdtInfoDetlPopup(\'' + rowObject.guarNo + '\', \'' + rowObject.stdtNo + '\')" value="신규" data-toggle="modal" data-target="#stdtRegDetlPopup" />';
                                else return`<a data-toggle="modal" class="links" data-target="#stdtInfoDetlPopup" data-stdt data-placement="bottom" title="${cellValue}" data-guar-no="${rowObject.guarNo}" data-stdt-no="${rowObject.stdtNo}">${cellValue}</a>`;}},
                        {name: "guarNo"           , index: "guarNo"           , label: "보호자번호"	  	     , width: 80  , align: "center" , formatter: function(cellValue, options, rowObject) {
                          if(WebUtil.isNull(cellValue)) return '' ;
                          else return `<a data-toggle="modal" class="links" data-target="#guarInfoDetlPopup" data-guar data-placement="bottom" title="${cellValue}" data-band-id="${rowObject.bandId}" data-guar-no="${rowObject.guarNo}" data-guar-tel-no="${rowObject.guarTelNo}" data-stdt-no="${rowObject.stdtNo}" data-stdt-nm="${rowObject.stdtNm}">${cellValue}</a>`;}},
                        {name: "guarNm"           , index: "guarNm"           , label: "보호자명"	 	     , width: 80  , align: "center" , formatter: function(cellValue, options, rowObject) {
                          if(WebUtil.isNull(cellValue)) return '' ;
                          else return `<a data-toggle="modal" class="links" data-target="#guarInfoDetlPopup" data-guar data-placement="bottom" title="${cellValue}" data-band-id="${rowObject.bandId}"data-guar-no="${rowObject.guarNo}" data-guar-tel-no="${rowObject.guarTelNo}" data-stdt-no="${rowObject.stdtNo}" data-stdt-nm="${rowObject.stdtNm}">${cellValue}</a>`;}},
                        {name: "guarTelNo"        , index: "guarTelNo"       , label: "보호자전화번호(밴드상세)"	     , width: 100 , align: "center"  ,formatter:function(cellValue, options, rowObject)   {
                          let guarTelNoTemp = phoneFormatter(cellValue);
                           return `<a data-toggle="modal" class="links" data-target="#bandSpecDetlPopup" data-band-spec data-placement="bottom" title="${guarTelNoTemp}" data-band-id="${rowObject.bandId}" data-guar-tel-no="${rowObject.guarTelNo}">${guarTelNoTemp}</a>`;}},
                        {name: "blthId"           , index: "blthId"           , label: "블루투스ID"           , width: 100 , align: "center"  , formatter: function(cellValue, options, rowObject) {
                                if(WebUtil.isNull(cellValue)) return '<input type="button" class="btn btn-xs btn-outline btn-success" onclick="bandOpenInfoMng.regBandOpenInfoDetlPopup(\'' + rowObject.bandId + '\')" value="등록" data-toggle="modal" data-target="#bandOpenInfoDetlPopup" />';
                                return `<a data-toggle="modal" class="links" data-target="#bandOpenInfoDetlPopup" data-band data-placement="bottom" title="${cellValue}" data-band-id="${rowObject.bandId}">${cellValue}</a>`;}},
                        {name: "bandOpenStatCdNm" , index: "bandOpenStatCdNm" , label: "밴드<br/>개통상태"    , width: 60  , align: "center"  , formatter: function(cellValue, options, rowObject) {
                                return `<a data-toggle="modal" class="links" data-target="#bandOpenInfoDetlPopup" data-band data-placement="bottom" title="${cellValue}" data-band-id="${rowObject.bandId}">${cellValue}</a>`;}},
                        {name: "apiUrlGramNo"     , index: "apiUrlGramNo"     , label: "개통URL<br/>전문번호" , width: 80  , align: "center" },
                        {name: "openGramNo"       , index: "openGramNo"       , label: "개통전문번호"         , width: 80  , align: "center" },
                        {name: "apiUrlYn"         , index: "apiUrlYn"         , label: "URL<br/>제공여부"     , width: 60  , align: "center" },
                        {name: "apiUrlDttm"       , index: "apiUrlDttm"       , label: "URL<br/>제공일시"     , width: 100 , align: "center" }
                    ];

                $("#bandOpenInfo_list").jqGrid("GridUnload");
                $("#bandOpenInfo_list").jqGrid($.extend(true, {}, commonGridOptions(),
                    {
                        datatype : "local",
                        mtype    : 'post',
                        url      : '/devc/band/bandOpenInfoMng/searchBandOpenInfoList.ab',
                        pager    : '#bandOpenInfo_pager_list',
                        height   : 405,
                        autowidth: false,
                        colModel : colModels,
                        onPaging : function(data) {
                            onPagingCommon(data, this, function(resultMap)
                            {
                                $this.params.currentPage  = resultMap.currentPage;
                                $this.params.rowCount     = resultMap.rowCount;
                                $this.params.currentIndex = resultMap.currentIndex;
                                $this.searchBandOpenInfoList(false);
                            })
                        },
                        afterSaveCell : function (rowid , colId , val, e ){
                            if($("#bandOpenInfo_list").getRowData(rowid).crud != "C" && $("#bandOpenInfo_list").getRowData(rowid).crud != "D" ) {
                               $("#bandOpenInfo_list").setRowData(rowid, {crud:"U"});
                            }
                        },
                        gridComplete: function () {
                            let grid = this;

                            $(grid).tableRowSpan(["uptDt","regDt","bandYtyp","bandMdlCd","bandId", "telNo","blthId", "bandOpenStatCd","bandOpenStatCdNm","apiUrlGramNo","openGramNo","apiUrlYn","apiUrlDttm"], "bandId");

                            $(grid).tableRowSpan(["stdtNo", "stdtNm"], "stdtKeyNo");

                            //밴드/개통정보 상세
                            $("#bandOpenInfo_list").find('A.links[data-band]').on('click', function(e) {
                                bandOpenInfoMng.regBandOpenInfoDetlPopup($(e.target).data('band-id'))
                            });
                            //보호자(사용자)정보 상세
                            $("#bandOpenInfo_list").find('A.links[data-guar]').on('click', function(e) {
                                bandOpenInfoMng.regGuarInfoDetlPopup($(e.target).data('band-id'), $(e.target).data('guar-no'),$(e.target).data('guar-tel-no'),$(e.target).data('stdt-no'),$(e.target).data('stdt-nm'));
                            });
                            //밴드/개통정보-보호자 개별 전화번호 수정,삭제
                            $("#bandOpenInfo_list").find('A.links[data-band-spec]').on('click', function(e) {
                                bandOpenInfoMng.regBandSpecDetlPopup($(e.target).data('band-id'),$(e.target).data('guar-tel-no'))
                            });
                            //학생정보 상세 팝업
                            $("#guarInfo_list").find('A.links[data-stdt]').on('click', function(e) {
                                guarInfoMng.regStdtInfoDetlPopup($(e.target).data('guar-no'),$(e.target).data('stdt-no'))
                            });

                        }
                    }));
                resizeJqGridWidth("bandOpenInfo_list", "bandOpenInfo_list_wrapper");
            },
            //기준_일자 선택
            setDatepicker : function() {
                let $this = this;
                $this.params.bDPer = '' ;
                $('#uptDtFrPicker').datepicker({
                    todayBtn: "linked",
                    keyboardNavigation: false,
                    forceParse: false,
                    calendarWeeks: true,
                    format: 'yyyy-mm-dd',
                    autoclose: true,
                    todayHighlight: true,
                }).on("changeDate", function() {
                    $this.params.uptDtFr = $('#uptDtFr').val();
                    });
                $('#uptDtToPicker').datepicker({
                    todayBtn: "linked",
                    keyboardNavigation: false,
                    forceParse: false,
                    calendarWeeks: true,
                    format: 'yyyy-mm-dd',
                    autoclose: true,
                    todayHighlight: true,
                }).on("changeDate", function() {
                    $this.params.uptDtTo = $('#uptDtTo').val();
                });
            },
            //기준_일자_기간_선택
            bDPerSelect: function()
            {
                let $this = this;
                const terms = getPeriodDate($this.params.bDPer);
                this.params.uptDtFr = terms.strDt;
                this.params.uptDtTo = terms.endDt;
            },
            //밴드/개통 정보 목록 조회
            searchBandOpenInfoList: function(isSearch)
            {
                let $this = this;
                //유효성_검증
                if ( !this.isValid() ) {
                    return false;
                }

                let params = $.extend(true, {}, $this.params);

                if ( isSearch )
                {
                    params.currentPage = 1;
                    params.currentIndex = 0;
                }
                $("#bandOpenInfo_list").setGridParam(
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
            //유효성_검증
            isValid: function() {

                let $this = this;

                if( ((WebUtil.isNotNull($this.params.uptDtFr)) && (WebUtil.isNull($this.params.uptDtTo))) || ((WebUtil.isNotNull($this.params.uptDtTo)) && (WebUtil.isNull($this.params.uptDtFr))) )
                {
                    Swal.alert(['나머지 기준 일자를 선택하세요.', 'info']);
                    return false;
                }
                if( ((WebUtil.isNotNull($this.params.uptDtFr) && WebUtil.isNotNull($this.params.uptDtTo)) && $this.params.uptDtFr > $this.params.uptDtTo) )
                {
                    Swal.alert(['정확한 기준 일자를 선택하세요.', 'info']);
                    return false;
                }
                return true;
            },
            downloadExcel : function()
            {
                let $this = this;
                let params = $.extend(true, {}, $this.params);

                AjaxUtil.post(
                    {
                        dataType: 'binary',
                        url: "/devc/band/bandOpenInfoMng/searchBandOpenInfoList/excel.ab",
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
            //보호자(사용자)정보 상세
            regGuarInfoDetlPopup: function(bandId, guarNo, guarTelNo, stdtNo, stdtNm) {
                guarInfoDetl.initPage(guarNo, function(){bandOpenInfoMng.searchBandOpenInfoList});
            },
            //밴드/개통정보 상세
            regBandOpenInfoDetlPopup: function(bandId) {
                bandOpenInfoDetl.initPage(bandId, function(){  bandOpenInfoMng.searchBandOpenInfoList(true) });
            },
            //밴드/개통정보(개별 보호자전화번호)수정,삭제
            regBandSpecDetlPopup: function(bandId,guarTelNo) {
                bandSpecDetl.initPage(bandId, guarTelNo, function(){  bandOpenInfoMng.searchBandOpenInfoList(true) });
            },
            //학생정보상세 팝업
            regStdtInfoDetlPopup: function(guarNo, stdtNo){
                stdtInfoDetl.initPage(stdtNo, guarNo, function(){  bandOpenInfoMng.searchBandOpenInfoList(true) });
            },
            resetSearchParam: function()
            {
                let $this = this;
                $this.params = 
                {
            		 userId         : '' ,
                     uptDtFr        : '' ,  //기준_일자From
                     uptDtTo        : '' ,  //기준_일자To
                     bDPer           : 'THIS_MONTH' ,  //기준_일자 _이번달
                     stdtNm         : '' ,  //학생_명
                     telNo          : '' ,  //밴드_전화_번호
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
                //이번 달 기본 값 세팅
                $this.code.bDPerList = CodeUtil.getPeriodDateList();
                const terms = getPeriodDate($this.params.bDPer);
                this.params.uptDtFr = terms.strDt;
                this.params.uptDtTo = terms.endDt;
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
                    $this.searchBandOpenInfoList(true);
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