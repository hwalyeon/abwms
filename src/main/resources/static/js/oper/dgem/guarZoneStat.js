let guarZoneStat = new Vue({
    el: "#guarZoneStat",
    data: {
        params : {
            plcClssCd:'',
            plcCd:'',
            wordHead1:'',
            wordHead2:'',
            prntNo:'',
            stdtNo:'',
            prntNoNm:'',
            stdtNoNm:'',
            addrSpec:'',
            locNm:'',
            rdPublGuarDiv:'all',
            locApntCd:'',
            mmDd     :'RECENT_MONTH',
            plcClssCd:'',
            paging: 'Y',
            totalCount: 0,
            rowCount: 30,
            currentPage: 1,
            currentIndex: 0
        },
        locInfo : {
            locNo: '',
            locNm: '',
            stdtNo:'',
            paging: 'Y',
            totalCount: 0,
            rowCount: 30,
            currentPage: 1,
            currentIndex: 0
        },
        locInfoSpec: {
            crud:'C',
            rdPublGuarDivSpec: '',
            prntNo:'',
            stdtNo:'',
            nearAddr:'',
            locNo: '',
            locNm: '',
            plcClssCd: '',
            plcCd: '',
            latVal: '',
            lonVal: '',
            valdRngeDist: '',
            swstLatVal:'',
            swstLonVal:'',
            nestLatVal:'',
            nestLonVal:'',
            pstno: '',
            addrBase: '',
            addrSpec: '',
            delYn:'',
            paging: 'Y',
            totalCount: 0,
            rowCount: 30,
            currentPage: 1,
            currentIndex: 0
        },
        map: null,
        currLat: 37.48170530421067,
        currLng: 126.88481997057949,
        mapCont: {
            draggable: 'false',
            marker:null,
            geocoder:null,
            mouseEvent:null,
            detailAddr:null,
            result:[],
            searchSpecFg:''
        },
        draw: {
            flag      : false,
            id        : -1,
            cntrPos   : null,
            line      : null,
            circle    : null,
            rectangle : null,
            lat       : 0,
            lng       : 0,
            southLat  : 0,
            northLat  : 0,
            westLng   : 0,
            eastLng   : 0,
            dist      : 50,
            title     : '',
            infoWndw  : null,
        },
        code : {
            plcClssCdList:[],
            plcCdList:[],
            wordHead1List: [],
            wordHead2List: [],
            wordHead2ListFilter:[],
            mmDdList           : []
        }
    },

    methods: {

        initialize: function() {
            let $this = this;

            $this.initValue();
            $this.initMapPosition();
            $this.initCodeList();
            $this.createMap();
            $this.initGrid();
            $this.searchLocInfoList(true);
            $this.setDatepicker();
        },
        initValue: function() {
            let $this = this;
            $this.code.mmDdList = CodeUtil.getPeriodDateList();
            const terms = getPeriodDate($this.params.mmDd);
            this.params.entrDtFr = terms.strDt;
            this.params.entrDtTo = terms.endDt;
        },
        mmDdSelect: function()
        {
            let $this = this;
            const terms = getPeriodDate($this.params.mmDd);
            this.params.entrDtFr = terms.strDt;
            this.params.entrDtTo = terms.endDt;
        },
        initMapPosition : function() {
            let $this = this;

            // jcw :: ????????????????????? https ??????????????? ???????????? ????????? http ???????????? ?????? ????????? ???????????? ??????
            // HTML5??? geolocation?????? ????????? ??? ????????? ???????????????
            if (navigator.geolocation && window.location.protocol=== 'https:') {
                // GeoLocation??? ???????????? ?????? ????????? ???????????????
                navigator.geolocation.getCurrentPosition(function(position) {
                    $this.currLat = position.coords.latitude; // ??????
                    $this.currLng = position.coords.longitude; // ??????
                });
            } else {
                if( !WebUtil.isNull($this.locInfoSpec.latVal) ) {
                    $this.currLat = $this.locInfoSpec.latVal;
                    $this.currLng = $this.locInfoSpec.lonVal;
                }
            }
        },
        createMap : function() {
            let $this = this;

            if ( !$this.map ) {
                $this.map = new kakao.maps.Map(this.getContainer(), {
                    center: $this.getLatLng($this.currLat, $this.currLng), // ????????? ???????????? 37.48170530421067, 126.88481997057949
                    draggable: false, // ????????? ???????????? ?????? ?????? ??? ??????/?????? ??????
                    level: 3 // ????????? ?????? ??????
                });
            } else {
                $this.map.setCenter($this.getLatLng($this.locInfoSpec.latVal, $this.locInfoSpec.lonVal));
            }

            $this.map.setDraggable(true);
            $this.map.setZoomable(true);

            if ( !$this.mapCont.geocoder ) {
                // ??????-?????? ?????? ????????? ???????????????
                var geocoder = new kakao.maps.services.Geocoder();
                $this.mapCont.geocoder = geocoder;
            }
            if ( !$this.mapCont.marker ) {
                $this.mapCont.marker = new kakao.maps.Marker(), // ????????? ????????? ????????? ???????????????
                    infowindow = new kakao.maps.InfoWindow({zindex:1}); // ????????? ????????? ?????? ????????? ????????? ????????????????????????
            }

            $this.draw.cntrPos = $this.map.getCenter();

            // ?????? ?????? ??????????????? ????????? ???????????? ?????? ?????? ????????? ???????????????
            searchAddrFromCoords($this.map.getCenter(), displayCenterInfo);

            if($this.mapCont.searchSpecFg === 'Y') {

                $this.draw.dist = $this.locInfoSpec.valdRngeDist;
                console.log($this.locInfoSpec.nearAddr + "????????? :: ");
                $this.mapCont.detailAddr = !!$this.locInfoSpec.nearAddr ? '<div>?????? : ' + $this.locInfoSpec.nearAddr + '</div>' : '';

                var content = '<div class="bAddr" style="width:260px;">' +
                    '<span class="title">????????? ????????????</span>' +
                    $this.mapCont.detailAddr +
                    '<br>' +
                    '</div>';

                var markerPosition  = $this.getLatLng($this.locInfoSpec.latVal, $this.locInfoSpec.lonVal);

                $this.mapCont.marker.setPosition(markerPosition);
                $this.mapCont.marker.setMap($this.map);

                // ?????????????????? ????????? ????????? ?????? ????????? ?????? ??????????????? ???????????????
                infowindow.setContent(content);
                infowindow.open($this.map, $this.mapCont.marker);

                $this.setRectangle();

                $this.mapCont.searchSpecFg = 'N';
            }

            // ?????? ????????? ?????? ????????? ???????????? ??? ?????? ?????? ????????? ?????? ?????? ????????? ??????????????? ???????????? ???????????????
            kakao.maps.event.addListener($this.map, 'idle', function() {
                searchAddrFromCoords($this.map.getCenter(), displayCenterInfo);
            });

            function searchAddrFromCoords(coords, callback) {
                // ????????? ????????? ?????? ????????? ???????????????
                $this.mapCont.geocoder.coord2RegionCode(coords.getLng(), coords.getLat(), callback);
            }

            function searchDetailAddrFromCoords(coords, callback) {
                // ????????? ????????? ?????? ?????? ????????? ???????????????
                $this.mapCont.geocoder.coord2Address(coords.getLng(), coords.getLat(), callback);
            }

            // ?????? ??????????????? ?????? ??????????????? ?????? ??????????????? ???????????? ???????????????
            function displayCenterInfo(result, status) {

            }
        },
        setData: function(data) {
            console.log(data);
            let $this = this;
            if(data.stdtNo !== undefined && data.stdtNm !== undefined && data.guarNo !== undefined && data.guarNm !== undefined)
            {
                $this.params.stdtNo = data.stdtNo;
                $this.params.stdtNm = data.stdtNm;
                $this.params.guarNo = data.guarNo;
                $this.params.guarNm = data.guarNm;
            }
            if(data.locNm !== undefined)
            {
                $this.params.locNm  = data.locNm;
            }
        },

        //datepicker
        setDatepicker : function() {
            let $this = this;
            $('#entrDtFrPicker').datepicker({
                todayBtn: "linked",
                keyboardNavigation: false,
                forceParse: false,
                calendarWeeks: true,
                format: 'yyyy-mm-dd',
                autoclose: true,
                todayHighlight: true,
            }).on("changeDate", function() {
                $this.params.entrDtFr = $('#entrDtFr').val();
            });
            $('#entrDtToPicker').datepicker({
                todayBtn: "linked",
                keyboardNavigation: false,
                forceParse: false,
                calendarWeeks: true,
                format: 'yyyy-mm-dd',
                autoclose: true,
                todayHighlight: true,
            }).on("changeDate", function() {
                $this.params.entrDtTo = $('#entrDtTo').val();
            });
        },
        getLatPerMeter: function() {
            // ???????????? : 1???=111Km
            return 1 / (111 * 1000);
        },
        getLngPerMeter: function(lat) {
            // ???????????? ??????37????????? 1???=88.8km
            return 1 / (88.8 * 1000);
        },
        getLatLng: function(lat, lng) {
            if ( typeof lat === 'object' ) {
                if ( WebUtil.isNotNull(lat.lat) && WebUtil.isNotNull(latlng) ) {
                    return new kakao.maps.LatLng(lat.lat, lat.lng);
                } else {
                    console.log('params is not exists.');
                }
            } else {
                if ( WebUtil.isNotNull(lat) && WebUtil.isNotNull(lng) ) {
                    return new kakao.maps.LatLng(lat, lng);
                } else {
                    console.log('params is not exists.');
                }
            }
        },
        getRectBound : function() {
            let $this = this;

            let center = $this.draw.cntrPos;
            let radius = $this.draw.dist;

            // ???????????? : 1???=111Km
            // ???????????? ??????37????????? 1???=88.8km
            const unitLat = $this.getLatPerMeter() * radius;
            const unitLng = $this.getLngPerMeter() * radius;

            let southLat = center.getLat() - unitLat;
            let northLat = center.getLat() + unitLat;
            let westLng = center.getLng() - unitLng;
            let eastLng = center.getLng() + unitLng;

            let sw = $this.getLatLng(southLat, westLng);
            let ne = $this.getLatLng(northLat, eastLng);

            $this.locInfoSpec.swstLatVal = southLat;
            $this.locInfoSpec.swstLonVal = westLng;
            $this.locInfoSpec.nestLatVal = northLat;
            $this.locInfoSpec.nestLonVal = eastLng;

            // ???????????? ???????????? ??????????????? ???????????????
            // ???????????? ????????? ??? ??????????????? LatLngBounds ????????? ???????????? ?????????
            let rectangleBounds = new kakao.maps.LatLngBounds(sw, ne);

            return rectangleBounds;
        },
        setRectangle : function() {
            let $this = this;

            // ???????????? ???????????? ??????????????? ???????????????
            // ???????????? ????????? ??? ??????????????? LatLngBounds ????????? ???????????? ?????????
            var rectangleBounds = $this.getRectBound();

            // ????????? ????????? ???????????? ???????????????
            if ( !$this.draw.rectangle ) {
                $this.draw.rectangle = new kakao.maps.Rectangle({
                    bounds: rectangleBounds, // ????????? ???????????? ?????????????????????
                    strokeWeight: 1, // ?????? ???????????????
                    strokeColor: '#39f', // ?????? ???????????????
                    strokeOpacity: 0.5, // ?????? ???????????? ????????? 1?????? 0 ????????? ????????? 0??? ??????????????? ???????????????
                    strokeStyle: 'shortdashdot', // ?????? ??????????????????
                    fillColor: '#39f', // ????????? ???????????????
                    fillOpacity: 0.4 // ????????? ???????????? ?????????
                });
            }

            $this.draw.rectangle.setBounds(rectangleBounds);
            // ????????? ???????????? ???????????????
            $this.draw.rectangle.setMap($this.map);
        },
        setMarking : function() {
            let $this = this;
            let draggable;

            if($this.mapCont.draggable === 'false'){
                $this.mapCont.draggable = 'true';
                draggable = true;
                $("#btnLocMark").text(' ????????????');
            } else {
                $this.mapCont.draggable = 'false';
                draggable = false;
                $("#btnLocMark").text(' ????????????');
            }
            // ????????? ???????????? ?????? ?????? ??????????????? ???????????????
            $this.map.setDraggable(true);
            $this.map.setZoomable(true);
        },
        getContainer: function(mapId) {
            let id = '';
            if ( WebUtil.isNull(mapId) ) {
                id = 'locInfoMngMap';
            }
            return document.getElementById(id);
        },
        initCodeList : function() {
            let $this = this;

            getCommonCodeList('PLC_CLSS_CD',$this.code.plcClssCdList, '');
            getCommonCodeList('PLC_CD',$this.code.plcCdList, '');
            $this.code.plcCdListFilter = $this.code.plcCdList;
            $this.code.plcCdListFilterSpec = $this.code.plcCdList;
            $this.searchAddrHeadList();
        },
        initGrid: function() {
            let $this = this;

            let locListColModels = [
                {name: "seq"            , index: "seq"          , label: "??????"           , width:  40 , align: "center"  },
                {name: "latVal"         , index: "latVal"       , label: "??????"           , width:  90 , align: "center"  },
                {name: "lonVal"         , index: "lonVal"       , label: "??????"           , width:  90 , align: "center"  },
                {name: "nearAddr"       , index: "nearAddr"     , label: "??????"           , width: 144 , align: "left"    },
                {name: "plcClssNm"      , index: "plcClssNm"    , label: "????????????"       , width:  60 , align: "center"  },
                {name: "dupApntCnt"     , index: "dupApntCnt"   , label: "????????? ????????????", width:  55 , align: "center"  },
                {name: "locNo"          , index: "locNo"        , label: "????????????"       , width:  55 , align: "center", hidden:true}
            ];

            $("#locInfo_list").jqGrid("GridUnload");
            $("#locInfo_list").jqGrid($.extend(true, {}, commonGridOptions(), {
                datatype: "local",
                mtype: 'post',
                height: 420,
                url: '/oper/dgem/guarZoneStat/searchLocInfoList.ab',
                pager: "#locInfo_pager_list",
                colModel: locListColModels,
                onPaging : function(data) {
                    onPagingCommon(data, this, function(resultMap) {
                        $this.params.currentPage    = resultMap.currentPage;
                        $this.params.rowCount       = resultMap.rowCount;
                        $this.params.currentIndex   = resultMap.currentIndex;
                        $this.searchLocInfoList(false);
                    })
                },
                onSelectRow: function(rowId, status, e) {
                    let item = $('#locInfo_list').jqGrid('getRowData', rowId);
                        $this.locInfo.locNo      = item.locNo;
                        $this.locInfo.locNm      = item.locNm;
                        $this.locInfo.stdtNo     = item.stdtNo;
                        $this.mapCont.draggable  = 'true';
                        $this.setMarking();
                        $this.mapCont.searchSpecFg = 'Y';
                        $this.locInfoSpec.latVal   = item.latVal;
                        $this.locInfoSpec.lonVal   = item.lonVal;
                        $this.locInfoSpec.nearAddr = item.nearAddr;
                        $this.createMap();
                        console.log($this.locInfoSpec.nearAddr);
                },
                gridComplete: function () {
                    var grid = this;

                    $('td[rowspan="1"]', grid).each(function () {
                        var spans = $('td[rowspanid="' + this.id + '"]', grid).length + 1;

                        if (spans > 1) {
                            $(this).attr('rowspan', spans);
                        }
                    });
                }
            }));

            resizeJqGridWidth("locInfo_list", "locInfo_list_wrapper");
        },
        changePlcClssCd() {
        	let $this = this;
        	var plcClssCd = $this.params.plcClssCd;
        	
        	if (plcClssCd == "NZONE")
    		{
        		Swal.alert(["??????????????? ?????????????????? ???????????? ???????????????.", "info"]);
        		$this.params.plcClssCd = "";
    		}
        	else
    		{
        		$this.searchLocInfoList(true);
    		}
        },
        searchLocInfoList: function(isSearch) {
            let $this = this;
            let params = $.extend(true, {}, this.params);

            if ( isSearch ) {
                params.currentPage  = 1;
                params.currentIndex = 0;
            }
            // jcw :: ?????? ?????? ?????? ??? ??? ????????? ??????
            $this.mapCont.draggable  = 'true';
            $this.setMarking();

            $this.locInfoSpec = {
                crud:'C',
                rdPublGuarDivSpec: '',
                prntNo:'',
                stdtNo:'',
                locNo: '',
                locNm: '',
                plcClssCd: '',
                plcCd: '',
                latVal: '',
                lonVal: '',
                valdRngeDist: '',
                swstLatVal:'',
                swstLonVal:'',
                nestLatVal:'',
                nestLonVal:'',
                pstno: '',
                addrBase: '',
                addrSpec: '',
                delYn:'',
                paging: 'Y',
                totalCount: 0,
                rowCount: 30,
                currentPage: 1,
                currentIndex: 0
            }
            $("#locInfo_list").setGridParam({
                datatype: "json",
                postData: JSON.stringify(params),
                page: 1,
                loadComplete: function(response) {
                    if ( response["rtnData"].result === 0 ) {
                        Swal.alert(["???????????? ????????????.", "info"]);
                    }
                }
            }).trigger("reloadGrid");
        },
        searchAddrHeadList : function() {
            let $this = this;

            AjaxUtil.post({
                url: "/oper/dgem/guarZoneStat/searchLocInfoSelect.ab",
                param: {},
                success: function(response) {
                    $this.code.wordHead1List = [];
                    $this.code.wordHead2List = [];
                    if ( !!response["rtnData"].result && response["rtnData"].result.length > 0 ) {
                        $.each(response["rtnData"].result, function(index, item) {
                            $this.code.wordHead1List.push({'cdVal':item.wordHead1, 'cdNm':item.wordHead1});
                        });
                    }
                    if ( !!response["rtnData"]["result2"] && response["rtnData"]["result2"].length > 0 ) {
                        $.each(response["rtnData"]["result2"], function(index, item) {
                            $this.code.wordHead2List.push({'cdVal':item.wordHead2, 'cdNm':item.wordHead2, 'wordHead1':item.wordHead1});
                        });
                        $this.code.wordHead2ListFilter = $this.code.wordHead2List;
                    }
                },
                error: function (response) {
                    Swal.alert([response, 'error']);
                }
            });
        },
        searchLocInfoSpec : function(isSearch) {
            let $this = this;
            let params;
            if (isSearch) {
                params = $.extend(true, {}, this.locInfo);
            } else {
                params = $.extend(true, {}, this.locInfo);
            }

            AjaxUtil.post({
                url: "/oper/dgem/guarZoneStat/searchLocInfoSpec.ab",
                param: params,
                success: function(response) {
                    if ( !!response["rtnData"].result && response["rtnData"].result.length > 0 ) {
                        $.each(response["rtnData"].result, function(index, item) {
                            $this.locInfoSpec.crud = 'U',
                                $this.locInfoSpec.rdPublGuarDivSpec = item.rdPublGuarDiv,
                                $this.locInfoSpec.prntNo = item.prntNo,
                                $this.locInfoSpec.stdtNo = item.stdtNo,
                                $this.locInfoSpec.locNo = item.locNo,
                                $this.locInfoSpec.locNm = item.locNm,
                                $this.locInfoSpec.plcClssCd = item.plcClssCd,
                                $this.locInfoSpec.plcCd = item.plcCd,
                                $this.locInfoSpec.latVal = item.latVal,
                                $this.locInfoSpec.lonVal = item.lonVal,
                                $this.locInfoSpec.valdRngeDist = item.valdRngeDist,
                                $this.locInfoSpec.swstLatVal = item.swstLatVal,
                                $this.locInfoSpec.swstLonVal = item.swstLonVal,
                                $this.locInfoSpec.nestLatVal = item.nestLatVal,
                                $this.locInfoSpec.nestLonVal = item.nestLonVal,
                                $this.locInfoSpec.pstno = item.pstno,
                                $this.locInfoSpec.addrBase = item.addrBase,
                                $this.locInfoSpec.addrSpec = item.addrSpec,
                                $this.locInfoSpec.delYn = item.delYn
                        });

                        $this.changePrntNoSpec();
                        $this.mapCont.searchSpecFg = 'Y';
                        $this.createMap();
                    }
                },
                error: function (response) {
                    Swal.alert([response, 'error']);
                }
            });
        },
        downloadExcelLocInfoList : function() {

            let $this = this;

            let params = $.extend(true, {}, $this.params);

            AjaxUtil.post({
                dataType: 'binary',
                url: "/oper/dgem/guarZoneStat/searchLocInfoList/excel.ab",
                param: params,
                success: function(response) {
                    saveFileLocal(response, '????????????????????? ??????.xls');
                },
                error: function (response) {
                    Swal.alert([response, 'error']);
                }
            });
        },
        resetSearchParam: function() {
            let $this = this;
            $this.params = {
                plcClssCd:'',
                plcCd:'',
                wordHead1:'',
                wordHead2:'',
                prntNo:'',
                stdtNo:'',
                prntNoNm:'',
                stdtNoNm:'',
                addrSpec:'',
                locNm:'',
                rdPublGuarDiv:'all',
                locApntCd:'',
                mmDd     :'RECENT_MONTH',
                plcClssCd:'',
                paging: 'Y',
                totalCount: 0,
                rowCount: 30,
                currentPage: 1,
                currentIndex: 0
            }
            $this.initValue();
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
