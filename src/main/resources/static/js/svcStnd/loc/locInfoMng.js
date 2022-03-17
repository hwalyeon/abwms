let locInfoMng = new Vue({
    el: "#locInfoMng",
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
            rdPublGuarDiv:'all',
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
        mapCont: {
            draggable: 'false',
            mapContainer:[],
            map:[],
            marker:[],
            geocoder:[],
            mouseEvent:[],
            detailAddr:[],
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
            plcCdListFilter:[],
            plcCdListFilterSpec:[],
            wordHead1List: [],
            wordHead2List: [],
            wordHead2ListFilter:[],
            prntNoList: [],
            stdtNoList: [],
            stdtNoListFilter:[],
            prntNoListSepc: [],
            stdtNoListSpec: [],
            stdtNoListFilterSpec:[]
        }
    },

    methods: {

        initialize: function() {
            let $this = this;

            $this.createMap();
            $this.initCodeList();
            $this.initGrid();
            $this.searchLocInfoList(true);
        },
        createMap : function() {
            let $this = this;

            var latVal;
            var lonVal;

            // jcw :: 크롬브라우저는 https 통신일때만 허용하기 때문에 http 통신일땐 먹통 되므로 프토토콜 체크
            // HTML5의 geolocation으로 사용할 수 있는지 확인합니다
            if (navigator.geolocation && window.location.protocol=== 'https:') {
                // GeoLocation을 이용해서 접속 위치를 얻어옵니다
                navigator.geolocation.getCurrentPosition(function(position) {
                    latVal = position.coords.latitude; // 위도
                    lonVal = position.coords.longitude; // 경도
                });
            } else {
                if( WebUtil.isNull($this.locInfoSpec.latVal) ) {
                    latVal = 33.450701;
                    lonVal = 126.570667;
                } else {
                    latVal = $this.locInfoSpec.latVal;
                    lonVal = $this.locInfoSpec.lonVal;
                }
            }

            $this.mapCont.mapContainer = document.getElementById('locInfoMngMap'), // 지도를 표시할 div
                mapOption = {
                    center: new kakao.maps.LatLng(latVal, lonVal), // 지도의 중심좌표 37.48170530421067, 126.88481997057949
                    draggable: false, // 지도를 생성할때 지도 이동 및 확대/축소 제어
                    level: 3 // 지도의 확대 레벨
                };

            $this.mapCont.map = new kakao.maps.Map($this.mapCont.mapContainer, mapOption); // 지도를 생성합니다

            $this.mapCont.map.setDraggable(true);
            $this.mapCont.map.setZoomable(true);

            // 주소-좌표 변환 객체를 생성합니다
            var geocoder = new kakao.maps.services.Geocoder();
            $this.mapCont.geocoder = geocoder;

            $this.mapCont.marker = new kakao.maps.Marker(), // 클릭한 위치를 표시할 마커입니다
                infowindow = new kakao.maps.InfoWindow({zindex:1}); // 클릭한 위치에 대한 주소를 표시할 인포윈도우입니다

            // 지도에 표시할 사각형을 생성합니다
            $this.draw.rectangle = new kakao.maps.Rectangle({
                //bounds: rectangleBounds, // 그려질 사각형의 영역정보입니다
                strokeWeight: 1, // 선의 두께입니다
                strokeColor: '#39f', // 선의 색깔입니다
                strokeOpacity: 0.5, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
                strokeStyle: 'shortdashdot', // 선의 스타일입니다
                fillColor: '#39f', // 채우기 색깔입니다
                fillOpacity: 0.4 // 채우기 불투명도 입니다
            });

            // 현재 지도 중심좌표로 주소를 검색해서 지도 좌측 상단에 표시합니다
            searchAddrFromCoords($this.mapCont.map.getCenter(), displayCenterInfo);

            // 지도에 클릭 이벤트를 등록합니다
            // 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
            // 지도를 클릭했을 때 클릭 위치 좌표에 대한 주소정보를 표시하도록 이벤트를 등록합니다
            kakao.maps.event.addListener($this.mapCont.map, 'click', function(mouseEvent) {

                $this.mapCont.mouseEvent = [];
                $this.mapCont.mouseEvent = mouseEvent;

                if($this.mapCont.draggable === 'true') {
                    searchDetailAddrFromCoords($this.mapCont.mouseEvent.latLng, function(result, status) {
                        $this.mapCont.result = result;
                        if (status === kakao.maps.services.Status.OK) {
                            var detailAddr = !!$this.mapCont.result[0].road_address ? '<div>도로명주소 : ' + $this.mapCont.result[0].road_address.address_name + '</div>' : '';

                            // $this.mapCont.detailAddr = [];
                            $this.mapCont.detailAddr = detailAddr;
                            $this.mapCont.detailAddr += '<div>지번 주소 : ' + $this.mapCont.result[0].address.address_name + '</div>';

                            var content = '<div class="bAddr">' +
                                '<span class="title">법정동 주소정보</span>' +
                                $this.mapCont.detailAddr +
                                '</div>';

                            $this.draw.cntrPos = $this.mapCont.mouseEvent.latLng;
                            // 마커를 클릭한 위치에 표시합니다
                            $this.mapCont.marker.setPosition($this.mapCont.mouseEvent.latLng);
                            $this.mapCont.marker.setMap($this.mapCont.map);

                            // 인포윈도우에 클릭한 위치에 대한 법정동 상세 주소정보를 표시합니다
                            infowindow.setContent(content);
                            infowindow.open($this.mapCont.map, $this.mapCont.marker);
                            $this.locInfoSpec.addrBase = !!$this.mapCont.result[0].road_address ? $this.mapCont.result[0].road_address.address_name : $this.mapCont.result[0].address.address_name;
                            $this.locInfoSpec.pstno = !!$this.mapCont.result[0].road_address ? $this.mapCont.result[0].road_address.zone_no : $this.mapCont.result[0].address.zip_code;

                            // 클릭한 위도, 경도 정보를 가져옵니다
                            var latlng = $this.mapCont.mouseEvent.latLng;
                            $this.locInfoSpec.latVal = latlng.getLat();
                            $this.locInfoSpec.lonVal = latlng.getLng();

                            $this.locInfoSpec.valdRngeDist = $this.draw.dist;
                            $this.getRectBound();

                            var sw, ne;
                            sw = new kakao.maps.LatLng($this.locInfoSpec.swstLatVal, $this.locInfoSpec.swstLonVal);
                            ne = new kakao.maps.LatLng($this.locInfoSpec.nestLatVal, $this.locInfoSpec.nestLonVal); // 사각형 영역의 북동쪽 좌표

                            // 사각형을 구성하는 영역정보를 생성합니다
                            // 사각형을 생성할 때 영역정보는 LatLngBounds 객체로 넘겨줘야 합니다
                            var rectangleBounds = new kakao.maps.LatLngBounds(sw, ne);

                            $this.draw.rectangle.setBounds(rectangleBounds);
                            // 지도에 사각형을 표시합니다
                            $this.draw.rectangle.setMap($this.mapCont.map);
                        }
                    });
                }
            });

            if($this.mapCont.searchSpecFg === 'Y') {

                $this.mapCont.detailAddr = !!$this.locInfoSpec.addrBase ? '<div>도로명주소 : ' + $this.locInfoSpec.addrBase + '</div>' : '';

                var contentA = '<div class="bAddr">' +
                    '<span class="title">법정동 주소정보</span>' +
                    $this.mapCont.detailAddr +
                    '</div>';

                var markerPosition  = new kakao.maps.LatLng($this.locInfoSpec.latVal, $this.locInfoSpec.lonVal);

                $this.mapCont.marker.setPosition(markerPosition);
                $this.mapCont.marker.setMap($this.mapCont.map);

                // 인포윈도우에 클릭한 위치에 대한 법정동 상세 주소정보를 표시합니다
                infowindow.setContent(contentA);
                infowindow.open($this.mapCont.map, $this.mapCont.marker);

                $this.setRectangle();

                $this.mapCont.searchSpecFg = 'N';
            }

            // 중심 좌표나 확대 수준이 변경됐을 때 지도 중심 좌표에 대한 주소 정보를 표시하도록 이벤트를 등록합니다
            kakao.maps.event.addListener($this.mapCont.map, 'idle', function() {
                searchAddrFromCoords($this.mapCont.map.getCenter(), displayCenterInfo);
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
                // if (status === kakao.maps.services.Status.OK) {
                //     //var infoDiv = document.getElementById('centerAddr');
                //
                //     for(var i = 0; i < result.length; i++) {
                //         // 행정동의 region_type 값은 'H' 이므로
                //         if (result[i].region_type === 'H') {
                //             //infoDiv.innerHTML = result[i].address_name;
                //             //$this.locInfoSpec.addrBase = result[i].address_name;
                //             break;
                //         }
                //     }
                // }
            }
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
            var sw = new kakao.maps.LatLng($this.locInfoSpec.swstLatVal, $this.locInfoSpec.swstLonVal), // 사각형 영역의 남서쪽 좌표
                ne = new kakao.maps.LatLng($this.locInfoSpec.nestLatVal,  $this.locInfoSpec.nestLonVal); // 사각형 영역의 북동쪽 좌표

            // 사각형을 구성하는 영역정보를 생성합니다
            // 사각형을 생성할 때 영역정보는 LatLngBounds 객체로 넘겨줘야 합니다
            var rectangleBounds = new kakao.maps.LatLngBounds(sw, ne);

            // 지도에 표시할 사각형을 생성합니다
            $this.draw.rectangle = new kakao.maps.Rectangle({
                bounds: rectangleBounds, // 그려질 사각형의 영역정보입니다
                strokeWeight: 1, // 선의 두께입니다
                strokeColor: '#39f', // 선의 색깔입니다
                strokeOpacity: 0.5, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
                strokeStyle: 'shortdashdot', // 선의 스타일입니다
                fillColor: '#39f', // 채우기 색깔입니다
                fillOpacity: 0.4 // 채우기 불투명도 입니다
            });

            // 지도에 사각형을 표시합니다
            $this.draw.rectangle.setMap($this.mapCont.map);
        },
        initCodeList : function() {
            let $this = this;

            getCommonCodeList('PLC_CLSS_CD',$this.code.plcClssCdList, '');
            getCommonCodeList('PLC_CD',$this.code.plcCdList, '');
            $this.code.plcCdListFilter = $this.code.plcCdList;
            $this.code.plcCdListFilterSpec = $this.code.plcCdList;
            $this.searchAddrHeadList();
            $this.searchPrntStdtList();
        },
        initGrid: function() {
            let $this = this;

            let locListColModels = [
                {name: "locNo"          , index: "locNo"        , label: "위치번호"     , width: 45         , align: "center"},
                {name: "locNm"          , index: "locNm"        , label: "위치명"       , width: 100        , align: "left"  },
                {name: "plcClssNm"      , index: "plcClssNm"    , label: "장소구분"     , width: 46         , align: "center"},
                {name: "plcNm"          , index: "plcNm"        , label: "장소구분상세"  , width: 63         , align: "center"},
                {name: "prntNoNm"       , index: "prntNo"       , label: "학부모"       , width: 50         , align: "center"},
                {name: "stdtNoNm"       , index: "stdtNo"       , label: "학생"        , width: 50          , align: "center"},
                {name: "regUserId"      , index: "regUserId"    , label: "등록자"       , width: 35         , align: "center"},
                {name: "stdtNo"         , index: "stdtNo"       , label: "학생"         , width: 35         , align: "center"     , hidden:true}
            ];

            $("#locInfo_list").jqGrid("GridUnload");
            $("#locInfo_list").jqGrid($.extend(true, {}, commonGridOptions(), {
                datatype: "local",
                mtype: 'post',
                height: 450,
                url: '/svcStnd/loc/locInfoMng/searchLocInfoList.ab',
                pager: "#locInfo_pager_list",
                colModel: locListColModels,
                onPaging : function(data) {
                    onPagingCommon(data, this, function(resultMap) {
                        $this.locInfo.currentPage    = resultMap.currentPage;
                        $this.locInfo.rowCount       = resultMap.rowCount;
                        $this.locInfo.currentIndex   = resultMap.currentIndex;
                        $this.searchLocInfoList(false);
                    })
                },
                onSelectRow: function(rowId, status, e) {
                    let item = $('#locInfo_list').jqGrid('getRowData', rowId);
                    if ( !!item.locNo )
                    {
                        $this.locInfo.locNo      = item.locNo;
                        $this.locInfo.locNm      = item.locNm;
                        $this.locInfo.stdtNo     = item.stdtNo;
                        $this.mapCont.draggable  = 'true';
                        $this.setDraggable();
                        $this.searchLocInfoSpec(true);
                    }
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
        searchLocInfoList: function(isSearch) {
            let $this = this;
            let params = $.extend(true, {}, this.params);

            if ( isSearch ) {
                params.currentPage  = 1;
                params.currentIndex = 0;
            }
            // jcw :: 조회 버튼 클릭 시 맵 컨트롤 잠금
            $this.mapCont.draggable  = 'true';
            $this.setDraggable();

            // jcw temp
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
                url: "/svcStnd/loc/locInfoMng/searchLocInfoSelect.ab",
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
        searchPrntStdtList : function() {
            let $this = this;

            AjaxUtil.post({
                url: "/svcStnd/loc/locInfoMng/searchPrntStdtList.ab",
                param: {},
                success: function(response) {
                    $this.code.prntNoList = [];
                    $this.code.stdtNoList = [];
                    $this.code.prntNoListSpec = [];
                    $this.code.stdtNoListSepc = [];
                    if ( !!response["rtnData"].result && response["rtnData"].result.length > 0 ) {
                        $.each(response["rtnData"].result, function(index, item) {
                            $this.code.prntNoList.push({'cdVal':item.prntNo, 'cdNm':item.prntNoNm});
                        });
                        $this.code.prntNoListSpec = $this.code.prntNoList;
                    }
                    if ( !!response["rtnData"]["result2"] && response["rtnData"]["result2"].length > 0 ) {
                        $.each(response["rtnData"]["result2"], function(index, item) {
                            $this.code.stdtNoList.push({'cdVal':item.stdtNo, 'cdNm':item.stdtNoNm, 'prntNo':item.prntNo});
                        });
                        $this.code.stdtNoListFilter = $this.code.stdtNoList;
                        $this.code.stdtNoListSpec = $this.code.stdtNoList;
                        $this.code.stdtNoListFilterSpec = $this.code.stdtNoList;
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
                url: "/svcStnd/loc/locInfoMng/searchLocInfoSpec.ab",
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
                url: "/svcStnd/loc/locInfoMng/searchLocInfoList/excel.ab",
                param: params,
                success: function(response) {
                    saveFileLocal(response, '위치정보목록.xls');
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
                rdPublGuarDiv:'all',
                paging: 'Y',
                totalCount: 0,
                rowCount: 30,
                currentPage: 1,
                currentIndex: 0
            }
        },
        resetSearchParamSpec: function() {
            let $this = this;
            $this.locInfoSpec = {
                crud:'C',
                rdPublGuarDivSpec: 'publ',
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
        },
        regLocInfoSpec : function () {
            let $this = this;

            if ( !this.beforeSave() ) {
                return false;
            }

            AjaxUtil.post({
                url: "/svcStnd/loc/locInfoMng/saveLocInfoSpec.ab",
                param: $this.locInfoSpec,
                success: function(response) {
                    Swal.alert(['저장이 완료되었습니다.', 'success']).then(function() {
                        locInfoMng.searchLocInfoSpec(false);
                    });
                },
                error: function (response) {
                    Swal.alert([response, 'error']);
                }
            });
        },
        delLocInfoSpec : function() {
            let $this = this;

            if(!confirm(["위치정보 상세 내역을 삭제하시겠습니까?"])) {
                return false;
            }

            if ( WebUtil.isNull($this.locInfoSpec.locNo) && $this.locInfoSpec.crud !== 'U' ) {
                Swal.alert(['위치목록에서 대상 조회 후 삭제해주세요.', 'info']);
                return false;
            }

            $this.locInfoSpec.crud = 'D';

            AjaxUtil.post({
                url: "/svcStnd/loc/locInfoMng/saveLocInfoSpec.ab",
                param: $this.locInfoSpec,
                success: function(response) {
                    Swal.alert(['삭제가 완료되었습니다.', 'success']).then(function() {
                        locInfoMng.searchLocInfoList(true);
                    });
                },
                error: function (response) {
                    Swal.alert([response, 'error']);
                }
            });
        },
        beforeSave : function() {
            let $this = this;

            if ( WebUtil.isNull($this.locInfoSpec.rdPublGuarDivSpec) ) {
                Swal.alert(['자료구분을 입력해주세요.', 'info']);
                return false;
            }

            if ( $this.locInfoSpec.rdPublGuarDivSpec === 'prnt' &&
                WebUtil.isNull($this.locInfoSpec.stdtNo)) {
                Swal.alert(['학부모 지정일땐 학생을 입력해주세요.', 'info']);
                return false;
            } else if($this.locInfoSpec.rdPublGuarDivSpec === 'publ') {
                $this.locInfoSpec.stdtNo = '';
            }

            if ( WebUtil.isNull($this.locInfoSpec.locNm) ) {
                Swal.alert(['위치명을 입력해주세요.', 'info']);
                return false;
            }

            if ( WebUtil.isNull($this.locInfoSpec.plcClssCd) ) {
                Swal.alert(['장소구분을 선택해주세요.', 'info']);
                return false;
            }

            if ( WebUtil.isNull($this.locInfoSpec.plcCd) ) {
                Swal.alert(['장소구분상세를 선택해주세요.', 'info']);
                return false;
            }

            if ( WebUtil.isNull($this.locInfoSpec.latVal) ) {
                Swal.alert(['위도 값이 입력되지 않았습니다.', 'info']);
                return false;
            }

            if ( WebUtil.isNull($this.locInfoSpec.lonVal) ) {
                Swal.alert(['경도 값이 입력되지 않았습니다.', 'info']);
                return false;
            }

            if ( WebUtil.isNull($this.locInfoSpec.valdRngeDist) ) {
                Swal.alert(['유효반경이 입력되지 않았습니다.', 'info']);
                return false;
            }

            if ( WebUtil.isNull($this.locInfoSpec.addrBase) ) {
                Swal.alert(['기본주소를 입력해주세요.', 'info']);
                return false;
            }

            if ( WebUtil.isNull($this.locInfoSpec.addrSpec) ) {
                Swal.alert(['상세주소를 입력해주세요.', 'info']);
                return false;
            }

            if ( WebUtil.isNull($this.locInfoSpec.swstLatVal) || WebUtil.isNull($this.locInfoSpec.swstLonVal) ||
                 WebUtil.isNull($this.locInfoSpec.nestLatVal) || WebUtil.isNull($this.locInfoSpec.nestLonVal)) {
                Swal.alert(['장소를 마킹하여 범위를 지정해주세요.', 'info']);
                return false;
            }

            return true;
        },
        changePlcClssCd : function () {
            let $this = this;

            if($this.params.plcClssCd === ''){
                $this.code.plcCdListFilter = $this.code.plcCdList;
            }
            else{
                $this.code.plcCdListFilter = _.filter($this.code.plcCdList, function(item) {
                    return item.fltrVal1 === $this.params.plcClssCd;
                })
            }
        },
        changePlcCd : function () {
            let $this = this;

            _.filter($this.code.plcCdList, function (item){
                if(item.cdVal === $this.params.plcCd){
                    $this.params.plcClssCd = item.fltrVal1;
                }
            })
        },
        changePlcClssCdSpec : function () {
            let $this = this;

            if($this.locInfoSpec.plcClssCd === ''){
                $this.code.plcCdListFilterSpec = $this.code.plcCdList;
            }
            else{
                $this.code.plcCdListFilterSpec = _.filter($this.code.plcCdList, function(item) {
                    return item.fltrVal1 === $this.locInfoSpec.plcClssCd;
                })
            }
        },
        changePlcCdSpec : function () {
            let $this = this;

            _.filter($this.code.plcCdList, function (item){
                if(item.cdVal === $this.locInfoSpec.plcCd){
                    $this.locInfoSpec.plcClssCd = item.fltrVal1;
                }
            })
        },
        changeWordHead1 : function () {
            let $this = this;

            if($this.params.wordHead1 === ''){
                $this.code.wordHead2ListFilter = $this.code.wordHead2List;
            }
            else{
                $this.code.wordHead2ListFilter = _.filter($this.code.wordHead2List, function(item) {
                    return item.wordHead1 === $this.params.wordHead1;
                })
            }
        },
        changeWordHead2 : function () {
            let $this = this;

            _.filter($this.code.wordHead2List, function(item) {
                if(item.cdVal === $this.params.wordHead2){
                    $this.params.wordHead1 = item.wordHead1;
                }
            })
        },
        changePrntNo : function () {
            let $this = this;

            if($this.params.prntNo === ''){
                $this.code.stdtNoListFilter = $this.code.stdtNoList;
            }
            else{
                $this.code.stdtNoListFilter = _.filter($this.code.stdtNoList, function(item) {
                    return item.prntNo === $this.params.prntNo;
                })
            }
        },
        changeStdtNo : function () {
            let $this = this;

            _.filter($this.code.stdtNoList, function(item) {
                if(item.cdVal === $this.params.stdtNo){
                    $this.params.prntNo = item.prntNo;
                }
            })
        },
        changePrntNoSpec : function () {
            let $this = this;
            if($this.locInfoSpec.prntNo === ''){
                $this.code.stdtNoListFilterSpec = $this.code.stdtNoListSpec;
            }
            else{
                $this.code.stdtNoListFilterSpec = _.filter($this.code.stdtNoListSpec, function(item) {
                    return item.prntNo === $this.locInfoSpec.prntNo;
                })
            }
        },
        changeStdtNoSpec : function () {
            let $this = this;
            _.filter($this.code.stdtNoListSpec, function(item) {
                if(item.cdVal === $this.locInfoSpec.stdtNo){
                    $this.locInfoSpec.prntNo = item.prntNo;
                }
            })
        },
        setDraggable : function() {
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
            $this.mapCont.map.setDraggable(true);
            $this.mapCont.map.setZoomable(true);
        },
        // jcw :: input 데이터 자리수 제한
        input_lenth : function(e){
            this.max_length(e, 200, '#addrSpec');
            this.max_length(e, 100, '#locInfoSpecLocNm');
            this.max_length(e, 200, '#locInfoSpecAddrSpec');
        },
        max_length : function(e, len,id)
        {
            var val =  e.target.value;
            if (val.length > len){
                Swal.alert(['최대 글자수를 초과하였습니다.' ]);
                $(id).val(val.substring(0, len));
            }
        }
    },
    computed: {


    },
    watch: {
        'draw.dist': function(newVal, oldVal) {
            let $this = this;
            if ( newVal !== oldVal ) {

                if ( $this.draw.rectangle ) {
                    let rectangleBounds = this.getRectBound();
                    $this.draw.rectangle.setBounds(rectangleBounds);

                    // 지도에 사각형을 표시합니다
                    $this.draw.rectangle.setMap($this.mapCont.map);
                }
                $this.locInfoSpec.valdRngeDist = $this.draw.dist;
            }
        }
    },
    mounted: function() {
        let self = this;
        $(document).ready(function() {
            self.initialize();
        });
    }
});
