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

            // jcw :: 크롬브라우저는 https 통신일때만 허용하기 때문에 http 통신일땐 먹통 되므로 프토토콜 체크
            // HTML5의 geolocation으로 사용할 수 있는지 확인합니다
            if (navigator.geolocation && window.location.protocol=== 'https:') {
                // GeoLocation을 이용해서 접속 위치를 얻어옵니다
                navigator.geolocation.getCurrentPosition(function(position) {
                    $this.currLat = position.coords.latitude; // 위도
                    $this.currLng = position.coords.longitude; // 경도
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
                    center: $this.getLatLng($this.currLat, $this.currLng), // 지도의 중심좌표 37.48170530421067, 126.88481997057949
                    draggable: false, // 지도를 생성할때 지도 이동 및 확대/축소 제어
                    level: 3 // 지도의 확대 레벨
                });
            } else {
                $this.map.setCenter($this.getLatLng($this.locInfoSpec.latVal, $this.locInfoSpec.lonVal));
            }

            $this.map.setDraggable(true);
            $this.map.setZoomable(true);

            if ( !$this.mapCont.geocoder ) {
                // 주소-좌표 변환 객체를 생성합니다
                var geocoder = new kakao.maps.services.Geocoder();
                $this.mapCont.geocoder = geocoder;
            }
            if ( !$this.mapCont.marker ) {
                $this.mapCont.marker = new kakao.maps.Marker(), // 클릭한 위치를 표시할 마커입니다
                    infowindow = new kakao.maps.InfoWindow({zindex:1}); // 클릭한 위치에 대한 주소를 표시할 인포윈도우입니다
            }

            $this.draw.cntrPos = $this.map.getCenter();

            // 현재 지도 중심좌표로 주소를 검색해서 지도 좌측 상단에 표시합니다
            searchAddrFromCoords($this.map.getCenter(), displayCenterInfo);

            if($this.mapCont.searchSpecFg === 'Y') {

                $this.draw.dist = $this.locInfoSpec.valdRngeDist;
                console.log($this.locInfoSpec.nearAddr + "이건우 :: ");
                $this.mapCont.detailAddr = !!$this.locInfoSpec.nearAddr ? '<div>주소 : ' + $this.locInfoSpec.nearAddr + '</div>' : '';

                var content = '<div class="bAddr" style="width:260px;">' +
                    '<span class="title">법정동 주소정보</span>' +
                    $this.mapCont.detailAddr +
                    '<br>' +
                    '</div>';

                var markerPosition  = $this.getLatLng($this.locInfoSpec.latVal, $this.locInfoSpec.lonVal);

                $this.mapCont.marker.setPosition(markerPosition);
                $this.mapCont.marker.setMap($this.map);

                // 인포윈도우에 클릭한 위치에 대한 법정동 상세 주소정보를 표시합니다
                infowindow.setContent(content);
                infowindow.open($this.map, $this.mapCont.marker);

                $this.setRectangle();

                $this.mapCont.searchSpecFg = 'N';
            }

            // 중심 좌표나 확대 수준이 변경됐을 때 지도 중심 좌표에 대한 주소 정보를 표시하도록 이벤트를 등록합니다
            kakao.maps.event.addListener($this.map, 'idle', function() {
                searchAddrFromCoords($this.map.getCenter(), displayCenterInfo);
            });

            function searchAddrFromCoords(coords, callback) {
                // 좌표로 행정동 주소 정보를 요청합니다
                $this.mapCont.geocoder.coord2RegionCode(coords.getLng(), coords.getLat(), callback);
            }

            function searchDetailAddrFromCoords(coords, callback) {
                // 좌표로 법정동 상세 주소 정보를 요청합니다
                $this.mapCont.geocoder.coord2Address(coords.getLng(), coords.getLat(), callback);
            }

            // 지도 좌측상단에 지도 중심좌표에 대한 주소정보를 표출하는 함수입니다
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
            // 위도거리 : 1도=111Km
            return 1 / (111 * 1000);
        },
        getLngPerMeter: function(lat) {
            // 경도거리 위도37도기준 1도=88.8km
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

            // 위도거리 : 1도=111Km
            // 경도거리 위도37도기준 1도=88.8km
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

            // 사각형을 구성하는 영역정보를 생성합니다
            // 사각형을 생성할 때 영역정보는 LatLngBounds 객체로 넘겨줘야 합니다
            let rectangleBounds = new kakao.maps.LatLngBounds(sw, ne);

            return rectangleBounds;
        },
        setRectangle : function() {
            let $this = this;

            // 사각형을 구성하는 영역정보를 생성합니다
            // 사각형을 생성할 때 영역정보는 LatLngBounds 객체로 넘겨줘야 합니다
            var rectangleBounds = $this.getRectBound();

            // 지도에 표시할 사각형을 생성합니다
            if ( !$this.draw.rectangle ) {
                $this.draw.rectangle = new kakao.maps.Rectangle({
                    bounds: rectangleBounds, // 그려질 사각형의 영역정보입니다
                    strokeWeight: 1, // 선의 두께입니다
                    strokeColor: '#39f', // 선의 색깔입니다
                    strokeOpacity: 0.5, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
                    strokeStyle: 'shortdashdot', // 선의 스타일입니다
                    fillColor: '#39f', // 채우기 색깔입니다
                    fillOpacity: 0.4 // 채우기 불투명도 입니다
                });
            }

            $this.draw.rectangle.setBounds(rectangleBounds);
            // 지도에 사각형을 표시합니다
            $this.draw.rectangle.setMap($this.map);
        },
        setMarking : function() {
            let $this = this;
            let draggable;

            if($this.mapCont.draggable === 'false'){
                $this.mapCont.draggable = 'true';
                draggable = true;
                $("#btnLocMark").text(' 마킹종료');
            } else {
                $this.mapCont.draggable = 'false';
                draggable = false;
                $("#btnLocMark").text(' 마킹시작');
            }
            // 마우스 드래그로 지도 이동 가능여부를 설정합니다
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
                {name: "seq"            , index: "seq"          , label: "순위"           , width:  40 , align: "center"  },
                {name: "latVal"         , index: "latVal"       , label: "위도"           , width:  90 , align: "center"  },
                {name: "lonVal"         , index: "lonVal"       , label: "경도"           , width:  90 , align: "center"  },
                {name: "nearAddr"       , index: "nearAddr"     , label: "주소"           , width: 144 , align: "left"    },
                {name: "plcClssNm"      , index: "plcClssNm"    , label: "장소분류"       , width:  60 , align: "center"  },
                {name: "dupApntCnt"     , index: "dupApntCnt"   , label: "보호자 지정건수", width:  55 , align: "center"  },
                {name: "locNo"          , index: "locNo"        , label: "장소번호"       , width:  55 , align: "center", hidden:true}
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
        		Swal.alert(["세이프존과 위험지역만을 분석하는 화면입니다.", "info"]);
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
            // jcw :: 조회 버튼 클릭 시 맵 컨트롤 잠금
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
                        Swal.alert(["데이터가 없습니다.", "info"]);
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
                    saveFileLocal(response, '보호자관심지역 현황.xls');
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
