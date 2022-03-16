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
                    mmDd           : '' ,  //기준_일자 _이번달
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
                     mmDdList           : [] , //기준_일자_이번달_리스트
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
                $this.code.mmDdList = CodeUtil.getPeriodDateList();
                const terms = getPeriodDate($this.params.mmDd);
                this.params.uptDtFr = terms.strDt;
                this.params.uptDtTo = terms.endDt;
            }, //기간_선택
            mmDdSelect: function()
            {
                let $this = this;
                const terms = getPeriodDate($this.params.mmDd);
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
                        {name: "bandIdTemp"       , index: "bandIdTemp"       , label: "밴드ID"			     , hidden: true },
                        {name: "bandOpenStatCd"   , index: "bandOpenStatCd"   , label: "밴드개통상태코드"     , hidden: true },
                        {name: "uptDt"            , index: "uptDt"            , label: "기준일자"		     , width: 80  , align: "center" , fixed: true  , formatter: function(cellValue, options, rowObject) { return formatDate(cellValue);}},
                        {name: "regDt"            , index: "regDt"            , label: "밴드등록일자"	     , width: 80  , align: "center" , fixed: true  , formatter: function(cellValue, options, rowObject) { return formatDate(cellValue);}},
                        {name: "bandYtyp"         , index: "bandYtyp"         , label: "출고년월"		     , width: 60  , align: "center" , fixed: true },
                        {name: "bandMdlCd"        , index: "bandMdlCd"        , label: "모델TYPE"		     , width: 50  , align: "center" , fixed: true },



                        {name: "bandId"           , index: "bandId"           , label: "밴드ID"		         , width: 80  , align: "center" , fixed: true  , formatter: function(cellValue, options, rowObject) {
                          return `<a data-toggle="modal" class="links" data-target="#bandOpenInfoDetlPopup" data-band data-placement="bottom" title="${cellValue}" data-band-id="${rowObject.bandId}">${cellValue}</a>`;}},



                        {name: "telNo"            , index: "telNo"            , label: "전화번호"		     , width: 100 , align: "center" , fixed: true  , formatter: function(cellValue, options, rowObject) {
                          let telNoTemp = phoneFormatter(cellValue);
                          return `<a data-toggle="modal" class="links" data-target="#bandOpenInfoDetlPopup" data-band data-placement="bottom" title="${telNoTemp}" data-band-id="${rowObject.bandId}">${telNoTemp}</a>`;}},
                        {name: "stdtNo"           , index: "stdtNo"           , label: "학생번호"		     , width: 80  , align: "center" , fixed: true },
                        {name: "stdtNm"           , index: "stdtNm"           , label: "학생명"		         , width: 80  , align: "center" , fixed: true },
                        {name: "guarNo"           , index: "guarNo"           , label: "보호자번호"	  	     , width: 80  , align: "center" , fixed: true , formatter: function(cellValue, options, rowObject) {
                          if(WebUtil.isNull(cellValue)) return '<input type="button" class="btn btn-xs btn-outline btn-success" onclick="bandOpenInfoMng.regGuarInfoDetlPopup(\'' + rowObject.guarNo + '\')" value="신규" data-toggle="modal" data-target="#guarInfoDetlPopup" />';
                          else return `<a data-toggle="modal" class="links" data-target="#guarInfoDetlPopup" data-spos data-placement="bottom" title="${cellValue}" data-guar-no="${rowObject.guarNo}">${cellValue}</a>`;}},
                        {name: "guarNm"           , index: "guarNm"           , label: "보호자명"	 	     , width: 80  , align: "center" , fixed: true , formatter: function(cellValue, options, rowObject) {
                                if(WebUtil.isNull(cellValue)) return '<input type="button" class="btn btn-xs btn-outline btn-success" onclick="bandOpenInfoMng.regGuarInfoDetlPopup(\'' + rowObject.bandId + '\')" value="신규" data-toggle="modal" data-target="#guarInfoDetlPopup" />';
                                else return `<a data-toggle="modal" class="links" data-target="#guarInfoDetlPopup" data-spos data-placement="bottom" title="${cellValue}" data-band-id="${rowObject.bandId}">${cellValue}</a>`;}},



                        {name: "guarTelNo"        , index: "guarTelNo"       , label: "보호자전화번호"	     , width: 100 , align: "center"  , fixed: true ,formatter:function(cellValue, options, rowObject)   {
                          let guarTelNoTemp = phoneFormatter(cellValue);
                           return `<a data-toggle="modal" class="links" data-target="#bandSpecDetlPopup" data-band-spec data-placement="bottom" title="${guarTelNoTemp}" data-band-id="${rowObject.bandId}" data-guar-tel-no="${rowObject.guarTelNo}">${guarTelNoTemp}</a>`;
                        }},
                        {name: "blthId"           , index: "blthId"           , label: "블루투스ID"           , width: 100 , align: "center" , fixed: true  , formatter: function(cellValue, options, rowObject) {
                                return `<a data-toggle="modal" class="links" data-target="#bandOpenInfoDetlPopup" data-band data-placement="bottom" title="${cellValue}" data-band-id="${rowObject.bandId}">${cellValue}</a>`;}},
                        {name: "bandOpenStatCdNm" , index: "bandOpenStatCdNm" , label: "밴드<br/>개통상태"    , width: 60  , align: "center" , fixed: true  , formatter: function(cellValue, options, rowObject) {
                                return `<a data-toggle="modal" class="links" data-target="#bandOpenInfoDetlPopup" data-band data-placement="bottom" title="${cellValue}" data-band-id="${rowObject.bandId}">${cellValue}</a>`;}},
                        {name: "apiUrlGramNo"     , index: "apiUrlGramNo"     , label: "개통URL<br/>전문번호" , width: 80  , align: "center" , fixed: true },
                        {name: "openGramNo"       , index: "openGramNo"       , label: "개통전문번호"         , width: 80  , align: "center" , fixed: true },
                        {name: "apiUrlYn"         , index: "apiUrlYn"         , label: "URL<br/>제공여부"     , width: 60  , align: "center" , fixed: true },
                        {name: "apiUrlDttm"       , index: "apiUrlDttm"       , label: "URL<br/>제공일시"     , width: 100 , align: "center" , fixed: true }
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

                            $(grid).tableRowSpan(["stdtNo", "stdtNm"], "stdtNo");


                            $("#bandOpenInfo_list").find('A.links[data-band]').on('click', function(e) {
                                bandOpenInfoMng.regBandOpenInfoDetlPopup($(e.target).data('band-id'))
                            });


                            $("#bandOpenInfo_list").find('A.links[data-band-spec]').on('click', function(e) {
                                bandOpenInfoMng.regBandSpecDetlPopup($(e.target).data('band-id'),$(e.target).data('guar-tel-no'))
                            });


                            $("#bandOpenInfo_list").find('A.links[data-guar-tel]').on('click', function(e) {
                                bandOpenInfoMng.regGuarInfoDetlPopup($(e.target).data('band-id'),$(e.target).data('guar-tel-no'))
                            });
                        }
                    }));
                resizeJqGridWidth("bandOpenInfo_list", "bandOpenInfo_list_wrapper");
            },
            searchBandOpenInfoList: function(isSearch)
            {
                let $this = this;
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
            regGuarInfoDetlPopup: function(guarNo) {
                guarInfoDetl.initPage(guarNo, function(){bandOpenInfoMng.searchBandOpenInfoList});
            },
            regBandOpenInfoDetlPopup: function(bandId) {
                bandOpenInfoDetl.initPage(bandId, function(){  bandOpenInfoMng.searchBandOpenInfoList(true) });
            },
            regBandSpecDetlPopup: function(bandId,guarTelNo) {
                console.log(bandId+"번호"+guarTelNo);
                bandSpecDetl.initPage(bandId, guarTelNo, function(){  bandOpenInfoMng.searchBandOpenInfoList(true) });
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
                $this.code.mmDdList = CodeUtil.getPeriodDateList();
                const terms = getPeriodDate($this.params.mmDd);
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