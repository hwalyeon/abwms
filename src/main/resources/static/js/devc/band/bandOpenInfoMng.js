let bandOpenInfoMng = new Vue({
    el: "#bandOpenInfoMng",
    data:
        {
            params:
                {
                    userId         : '' ,
                    uptDtFr        : '' ,  //기준_일자From
                    uptDtTo        : '' ,  //기준_일자To
                    mmDd           : '' ,  //기준_일자 _이번달
                    stdtNm         : '' ,  //학생_명
                    bandTelNo      : '' ,  //밴드_전화_번호
                    bandId         : '' ,  //밴드_ID
                    bandOpenStatCd : '' ,  //밴드_개통_상태_코드
                    guarNm         : '' ,  //보호자_명
                    guarTelNo      : '' ,  //보호자_전화_번호
                    paging         : 'Y',
                    totalCoun      : 0  ,
                    rowCount       : 30 ,
                    currentPage    : 1  ,
                    currentIndex   : 0
                },
            code:
                {
                     mmDdList           : [] , //기준_일자_이번달_리스트
                     bandOpenStatCdList : [] , //밴드_개통_상태_코드_리스트
                     bandYtypCdList     : [] , //밴드_년식_리스트
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
            },
            //이번달_일수_계산
            mmDdListCalc: function()
            {
                let $this    = this;
                let now      = new Date();
                let lastDate = new Date(now.getFullYear(), now.getMonth()+1, 0).getDate()
                if( lastDate != null)
                {
                   for(var i=1; i<lastDate+1; i++)
                   {
                    $this.code.mmDdList.push({'cdVal':i,'cdNm':i+'일'});
                   }
                }
            },
            initCodeList : function()
            {
                let $this = this;

                $this.mmDdListCalc(); //이번달_일수_계산
                getCommonCodeList('BAND_MDL_CD'       ,$this.code.bandMdlCdList); //밴드_모델_코드_리스트
                getCommonCodeList('BAND_TTYP_CD'      ,$this.code.bandYtypCdList); //밴드_년식_리스트
                getCommonCodeList('BAND_OPEN_STAT_CD' ,$this.code.bandOpenStatCdList,function() //밴드_개통_상태_코드_리스트
                {
                    $this.initGrid();
                    $this.searchBandOpenInfoList(true);
                })
            },
            initGrid: function()
            {
                let $this              = this;
                let bandYtypCdList     = commonGridCmonCd($this.code.bandYtypCdList);     //밴드_년식_리스트
                let bandMdlCdList      = commonGridCmonCd($this.code.bandMdlCdList);      //밴드_모델_코드_리스트
                let bandOpenStatCdList = commonGridCmonCd($this.code.bandOpenStatCdList); //밴드_개통_상태_코드_리스트
                let colModels =
                    [
                        {name: "crud"           , index: "crud"           , label: "crud"            , hidden: true                                },
                        {name: "uptDt"          , index: "uptDt"          , label: "기준일자"         , width: 80 , align: "center" , hidden: true  },
                        {name: "rgeDt"          , index: "rgeDt"          , label: "밴드등록일자"     , width: 80 , align: "center" , hidden: true  },
                        {name: "bandId"         , index: "bandId"         , label: "밴드ID"           , width: 80 , align: "center" , hidden: true  },
                        {name: "bandYtypCd"     , index: "bandYtypCd"     , label: "년식"             , width: 80 , align: "center" , editable: true
                         ,edittype:"select"     , formatter:"select"      , editoptions: {value: bandYtypCdList}},
                        {name: "bandMdlCd"      , index: "bandMdlCd"      , label: "모델TYPE"         , width: 80 , align: "center" , editable: true
                         ,edittype:"select"     , formatter:"select"      , editoptions: {value: bandMdlCdList}},
                        {name: "telNo"          , index: "telNo"          , label: "전화번호"         , width: 80 , align: "center" , editable: true },
                        {name: "stdtNo"         , index: "stdtNo"         , label: "학생번호"         , width: 80 , align: "center" , editable: true },
                        {name: "stdtNm"         , index: "stdtNm"         , label: "학생명"           , width: 80 , align: "center" , editable: true },
                        {name: "guarNo"         , index: "guarNo"         , label: "보호자번호"       , width: 80 , align: "center" , editable: true },
                        {name: "guarNm"         , index: "guarNm"         , label: "보호자명"         , width: 80 , align: "center" , editable: true },
                        {name: "guarTelNo"      , index: "guarTelNo"      , label: "보호자전화번호"   , width: 80 , align: "center"  , editable: true },
                        {name: "bandOpenStatCd" , index: "bandOpenStatCd" , label: "밴드개통상태코드" , width: 80 , align: "center"  , editable: true
                         ,edittype:"select"     , formatter:"select"      , editoptions:{value:bandOpenStatCdList}},
                        {name: "openGramNo"     , index: "openGramNo"     , label: "개통전문번호"     , width: 80 , align: "center" },
                        {name: "blthId"         , index: "blthId"         , label: "블루투스ID"       , width: 80 , align: "center" , editable: true},
                        {name: "urlSplyYn"      , index: "urlSplyYn"      , label: "URL제공여부"      , width: 80 , align: "center" },
                        {name: "apiUrlDttm"     , index: "apiUrlDttm"     , label: "URL제공일시"      , width: 80 , align: "center" },
                        {name: "regDt"          , index: "regDt"          , label: "등록일자"         , width: 80 , align: "center" , formatter: function(cellValue, options, rowObject) { return formatDate(cellValue);                                              }},
                        {name: "regTm"          , index: "regTm"          , label: "등록시각"         , width: 80 , align: "center" , formatter: function(cellValue, options, rowObject) { return formatTime(cellValue);                                              }},
                        {name: "regUserId"      , index: "regUserId"      , label: "등록사용자ID"     , width: 80 , align: "center" },
                        {name: "uptDt"          , index: "uptDt"          , label: "수정일자"         , width: 80 , align: "center" , formatter: function(cellValue, options, rowObject) { return formatDate(cellValue);                                              }},
                        {name: "uptTm"          , index: "uptTm"          , label: "수정시각"         , width: 80 , align: "center" , formatter: function(cellValue, options, rowObject) { return formatTime(cellValue);                                              }},
                        {name: "uptUserId"      , index: "uptUserId"      , label: "수정사용자ID"     , width: 80 , align: "center" }
                    ];

                $("#bandOpenInfo_list").jqGrid("GridUnload");
                $("#bandOpenInfo_list").jqGrid($.extend(true, {}, commonEditGridOptions(),
                    {
                        datatype : "local",
                        mtype    : 'post',
                        url      : '/devc/band/bandOpenInfoMng/searchBandOpenInfoList.ab',
                        pager    : '#ddRcmdEatStnd_pager_list',
                        height   : 405,
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
                        onCellSelect : function (rowid , colId , val, e ){
                            // 행의 컬럼을 하나라도 클릭했을 경우 수정으로변경
                            if($("#bandOpenInfo_list").getRowData(rowid).crud != "C" && $("#bandOpenInfo_list").getRowData(rowid).crud != "D" ) {
                                $("#bandOpenInfo_list").setRowData(rowid, {crud:"U"});
                            }
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
            /**/
            btnAddRow  :  function()
            {
                let $this = this;
                let date = new Date();
                var cnt = $("#bandOpenInfo_list").jqGrid("getGridParam", "records")+1;

                var addRow = {
                    crud           : "C" ,
                    uptDt          : "" ,
                    rgeDt          : "" ,
                    bandId         : "" ,
                    bandYtypCd     : "" ,
                    bandMdlCd      : "" ,
                    telNo          : "" ,
                    stdtNo         : "" ,
                    stdtNm         : "" ,
                    guarNo         : "" ,
                    guarNm         : "" ,
                    guarTelNo      : "" ,
                    bandOpenStatCd : "" ,
                    openGramNo     : "" ,
                    blthId         : "" ,
                    urlSplyYn      : "" ,
                    apiUrlDttm     : "" ,
                    regDt          : date  ,
                    regTm          : date  ,
                    regUserId      : $this.userId  ,
                    uptDt          : date  ,
                    uptTm          : date  ,
                    uptUserId      : $this.userId
                };
                $("#bandOpenInfo_list").addRowData(cnt, addRow);

            },
            btnDelRow : function() {
                //var checkIds = $("#dgem_list").jqGrid("getGridParam","selarrrow") + ""; // 멀티
                let checkIds = $("#bandOpenInfo_list").jqGrid("getGridParam","selrow") + "";  // 단건
                if ( checkIds == "" )
                {
                    alert("삭제할 행을 선택해주십시요.");
                    return false;
                }

                let checkId = checkIds.split(",");
                for ( var i in checkId )
                {
                    if ( $("#bandOpenInfo_list").getRowData(checkId[i]).crud == "C" )
                    {
                        $("#bandOpenInfo_list").setRowData(checkId[i], {crud:"N"});
                        $("#"+checkId[i],"#bandOpenInfo_list").css({display:"none"});
                    }
                    else
                    {
                        $("#bandOpenInfo_list").setRowData(checkId[i], {crud:"D"});
                        $("#"+checkId[i],"#bandOpenInfo_list").css({display:"none"});
                    }
                }
            },
            btnSave  :  function() {
                let $this = this;
                let gridData = commonGridGetDataNew($("#bandOpenInfo_list"));
                if(gridData.length > 0)
                {
                    for (let data in gridData)
                    {
                        if(gridData[data].crud === 'C' || gridData[data].crud === 'U')
                        {
                            if(WebUtil.isNull(gridData[data].sexCd))
                            {
                                Swal.alert(["성별은 필수 입력입니다.", 'warning']);
                                return false;
                            }if(WebUtil.isNull(gridData[data].ageYcnt))
                        {
                            Swal.alert(["나이(년수)는 필수 입력입니다.", 'warning']);
                            return false;
                        }if(WebUtil.isNull(gridData[data].nutrCd))
                        {
                            Swal.alert(["영양소명은 필수 입력입니다.", 'warning']);
                            return false;
                        }if(WebUtil.isNull(gridData[data].eatQtyFr))
                        {
                            Swal.alert(["섭취량(From)은 필수 입력입니다.", 'warning']);
                            return false;
                        }if(WebUtil.isNull(gridData[data].useYn)){
                            Swal.alert(["사용여부는 필수 입력입니다.", 'warning']);
                            return false;
                        }
                        }
                    }
                }
                else
                {
                    Swal.alert(["저장 대상 데이터가 없습니다.", 'warning']);
                    return false;
                }
                let param = { gridList : []}
                param.gridList = gridData;

                AjaxUtil.post({
                    url: "/devc/band/bandOpenInfoMng/saveBandOpenInfo.ab",
                    param: param,
                    success: function(response) {
                        Swal.alert(['저장이 완료되었습니다.', 'success']).then(function() {
                            $this.searchBandOpenInfoList(true);
                        });
                    },
                    error: function (response) {
                        Swal.alert([response, 'error']);
                    }
                });
            },
            /**/
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
            resetSearchParam: function()
            {
                let $this = this;
                $this.params =
                {
                    uptDtFr        : '' ,  //기준_일자From
                    uptDtTo        : '' ,  //기준_일자To
                    mmDd           : '' ,  //기준_일자 _이번달
                    stdtNm         : '' ,  //학생_명
                    bandTelNo      : '' ,  //밴드_전화_번호
                    bandId         : '' ,  //밴드_ID
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