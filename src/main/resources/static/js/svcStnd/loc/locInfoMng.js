// import GORG_MARKER from '@/img/map/gorg_markers_sprite.png'
// import GUAR_MARKER from '@/img/map/guar_markers_sprite.png'
// import SZONE_MARKER from '/static/img/map/szone_markers_sprite.png';
// import DZONE_MARKER from '/static/img/map/dzone_markers_sprite.png';

let locInfoMng = new Vue({
    el: "#locInfoMng",
    data: {
        params : {
            plcClssCd       : '',
            plcCd           : '',
            wordHead1       : '',
            wordHead2       : '',
            guarNo          : '',
            stdtNo          : '',
            guarNm          : '',
            stdtNm          : '',
            addrSpec        : '',
            rdGorgGuarDiv   : 'ALL',
            paging          : 'Y',
            totalCount      : 0,
            rowCount        : 30,
            currentPage     : 1,
            currentIndex    : 0
        },
        locInfo : {
            locNo           : ''
        },
        locInfoSpec: {
            crud            : 'C',
            rdGorgGuarDivSpec: '',
            guarNo          : '',
            stdtNo          : '',
            locNo           : '',
            locNm           : '',
            plcClssCd       : '',
            plcCd           : '',
            locApntCd       : '',
            latVal          : '',
            lonVal          : '',
            valdRngeDist    : '',
            swstLatVal      : '',
            swstLonVal      : '',
            nestLatVal      : '',
            nestLonVal      : '',
            pstno           : '',
            addrBase        : '',
            addrSpec        : '',
            delYn           : ''
        },
        map                 : null,
        currLevel           : 3,
        currLat             : 37.48170530421067,
        currLng             : 126.88481997057949,
        currSwLat           : 0.0,
        currSwLng           : 0.0,
        currNeLat           : 0.0,
        currNeLng           : 0.0,
        oldSwLat            : 0.0,
        oldSwLng            : 0.0,
        oldNeLat            : 0.0,
        oldNeLng            : 0.0,
        locNoList           : null,
        positionList        : null,
        rectangleList       : null,
        markerList          : [],
        drawManager         : null,
        drawRectangle       : [],
        toolbox             : null,
        ps                  : null,
        psInfowindow        : null,
        psMarkers           : [],
        placePositionList   : [],
        drawList: {
            flag            : false,
            locNo           : -1,
            locNm           : '',
            plcClssCd       : '',
            plcClssNm       : '',
            latVal          : 0,
            lonVal          : 0,
            swstLatVal      : 0,
            nestLatVal      : 0,
            swstLonVal      : 0,
            nestLonVal      : 0,
            valdRngeDist    : 10,
            pstno           : '',
            addrBase        : '',
            addrSpec        : '',
            cntrPos         : null,
            rectangle       : null,
            marker          : null,
            cstmOvrlay      : null
        },
        infowindow          : null,
        mapCont: {
            draggable       : 'false',
            marker          : null,
            geocoder        : null,
            mouseEvent      : null,
            detailAddr      : null,
            result          : [],
            searchSpecFg    : ''
        },
        draw: {
            flag            : false,
            id              : -1,
            cntrPos         : null,
            line            : null,
            circle          : null,
            rectangle       : null,
            lat             : 0,
            lng             : 0,
            southLat        : 0,
            northLat        : 0,
            westLng         : 0,
            eastLng         : 0,
            dist            : 10,
            title           : '',
            infoWndw        : null,
        },
        code : {
            plcClssCdList       : [],
            plcCdList           : [],
            plcCdListFilter     : [],
            plcCdListFilterSpec : [],
            wordHead1List       : [],
            wordHead2List       : [],
            wordHead2ListFilter : [],
            // guarNoList          : [], // jcw : 팝업 조회로 변경하여 불필요.
            // stdtNoList          : [], // jcw : 팝업 조회로 변경하여 불필요.
            // stdtNoListFilter    : [], // jcw : 팝업 조회로 변경하여 불필요.
            // guarNoListSpec      : [], // jcw : 팝업 조회로 변경하여 불필요.
            // stdtNoListSpec      : [], // jcw : 팝업 조회로 변경하여 불필요.
            // stdtNoListFilterSpec : [], // jcw : 팝업 조회로 변경하여 불필요.
            locApntCdList       : []
        }
    },

    methods: {

        initialize: function() {
            let $this = this;

            $this.initMapPosition();
            $this.initCodeList();
            $this.createMap();
            $this.initGrid();
            $this.searchLocInfoList(true);
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

            if(!!$this.locInfoSpec.latVal) {
                $this.currLat = $this.locInfoSpec.latVal;
                $this.currLng = $this.locInfoSpec.lonVal;
            }
            if ( !$this.map ) {
                $this.map = new kakao.maps.Map(this.getContainer(), {
                    center: $this.getLatLng($this.currLat, $this.currLng), // 지도의 중심좌표 37.48170530421067, 126.88481997057949
                    draggable: false, // 지도를 생성할때 지도 이동 및 확대/축소 제어
                    currLevel: 3 // 지도의 확대 레벨
                });
                // jcw :: 2022.04.25 개발중..
                // $this.searchPlace();
            } else {
                $this.map.setCenter($this.getLatLng($this.locInfoSpec.latVal, $this.locInfoSpec.lonVal));
            }

            $this.createPs();

            $this.map.setDraggable(true);
            $this.map.setZoomable(true);

            if ( !$this.mapCont.geocoder ) {
                // 주소-좌표 변환 객체를 생성합니다
                var geocoder = new kakao.maps.services.Geocoder();
                $this.mapCont.geocoder = geocoder;
            }

            if ($this.mapCont.marker) {
            } else {
                $this.mapCont.marker = new kakao.maps.Marker(); // 클릭한 위치를 표시할 마커입니다
                // $this.infowindow = new kakao.maps.InfoWindow({zindex: 1}); // 클릭한 위치에 대한 주소를 표시할 인포윈도우입니다
            }

            if ($this.infowindow) {
            } else {
                $this.infowindow = new kakao.maps.InfoWindow({zindex: 1}); // 클릭한 위치에 대한 주소를 표시할 인포윈도우입니다
            }

            $this.draw.cntrPos = $this.map.getCenter();

            // // 현재 지도 중심좌표로 주소를 검색해서 지도 좌측 상단에 표시합니다
            // searchAddrFromCoords($this.map.getCenter(), displayCenterInfo);

            if (!$this.drawManager) {

                let options = { // Drawing Manager를 생성할 때 사용할 옵션입니다
                    map: $this.map, // Drawing Manager로 그리기 요소를 그릴 map 객체입니다
                    drawingMode: [
                        kakao.maps.Drawing.OverlayType.RECTANGLE,
                    ],
                    // 사용자에게 제공할 그리기 가이드 툴팁입니다
                    // 사용자에게 도형을 그릴때, 드래그할때, 수정할때 가이드 툴팁을 표시하도록 설정합니다
                    guideTooltip: ['draw', 'drag', 'edit'],
                    markerOptions: {
                        draggable       : false,
                        editable        : false, // 그린 후 수정할 수 있도록 설정합니다
                        removable       : true
                    },
                    rectangleOptions: {
                        draggable       : true,
                        removable       : true,
                        strokeWeight    : 1, // 선의 두께입니다
                        strokeColor     : '#39f', // 선의 색깔입니다
                        strokeOpacity   : 0.5, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
                        strokeStyle     : 'shortdashdot', // 선의 스타일입니다
                        fillColor       : '#39f', // 채우기 색깔입니다
                        fillOpacity     : 0.4 // 채우기 불투명도 입니다
                    },
                };

                // 위에 작성한 옵션으로 Drawing Manager를 생성합니다
                $this.drawManager = new kakao.maps.Drawing.DrawingManager(options);

                // Toolbox를 생성합니다.
                // Toolbox 생성 시 위에서 생성한 DrawingManager 객체를 설정합니다.
                // DrawingManager 객체를 꼭 설정해야만 그리기 모드와 매니저의 상태를 툴박스에 설정할 수 있습니다.
                $this.toolbox = new kakao.maps.Drawing.Toolbox({drawingManager: $this.drawManager});
                // console.log("jcw toolbox :: ", $this.toolbox);

                // 지도 위에 Toolbox를 표시합니다
                // kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOP은 위 가운데를 의미합니다.
                $this.map.addControl($this.toolbox.getElement(), kakao.maps.ControlPosition.TOP);

                // jcw 테스트 중...
                // 직사각형과 정사각형 그리는 방식 중 한가지만 되도록..
                // 1. 정사각형 그리기 시도 시 $this.drawRectangle.length 가 0보다 클 때 못하도록 (체크 완료!)
                // 2. 직사각형 그리기 시도 시 $this.draw.rectangle.length 가 0보다 클 때 못하다록?? (이건 체크 필요!!)
                {
                    $this.drawManager.addListener('drawstart', function(drawstartMouseEvent) {
                        // console.log("jcw toolbox 1 :: ", $this.toolbox);
                        $this.mapCont.draggable  = 'true';
                        $this.setMarking();
                    });

                    $this.drawManager.addListener('drawend', function(drawendMouseEvent) {

                        let drawRect = $this.drawManager.getData().rectangle[$this.drawManager.getData().rectangle.length-1];

                        let sPointlat = drawRect.sPoint.y;
                        let sPointLng = drawRect.sPoint.x;
                        let ePointlat = drawRect.ePoint.y;
                        let ePointLng = drawRect.ePoint.x;
                        let centLat;
                        let centLng;

                        // jcw :: 2022.04.24 남은 것!
                        // 1. 저장 시 기존 중심 좌표와 거리 값으로 4개 꼭지점 좌표 구하던 로직 대신 각 꼭지점 구하기(아래 로직 거의 완성)
                        // 1-1. 중요! 저장 시 정사각형과 직사각형을 여러번 그려본 후 저장하면 locInfoSpec.swstLatVal 값이 과거 쓰레기 값이 남으므로 조치할 것!
                        // 2. 조회 시 정사각형 박스 그리던 로직을 직사각형 박스 그리는 로직으로 변경하기. (즉, 거리 값으로 구하던 로직 제거하고 4개 꼭지점으로 그리기)
                        // 3. 검색 목록 구현하기
                        if(sPointlat < ePointlat) {
                            centLat = (ePointlat-sPointlat)/2+sPointlat;
                            $this.locInfoSpec.swstLatVal = sPointlat;
                            $this.locInfoSpec.nestLatVal = ePointlat;
                        } else {
                            centLat = (sPointlat-ePointlat)/2+ePointlat;
                            $this.locInfoSpec.swstLatVal = ePointlat;
                            $this.locInfoSpec.nestLatVal = sPointlat;
                        }
                        if(sPointLng < ePointLng) {
                            centLng = (ePointLng-sPointLng)/2+sPointLng;
                            $this.locInfoSpec.swstLonVal = sPointLng;
                            $this.locInfoSpec.nestLonVal = ePointLng;
                        } else {
                            centLng = (sPointLng-ePointLng)/2+ePointLng;
                            $this.locInfoSpec.swstLonVal = ePointLng;
                            $this.locInfoSpec.nestLonVal = sPointLng;
                        }

                        $this.drawMngRect($this.getLatLng(centLat, centLng));

                        $this.drawRectangle.push(drawendMouseEvent);

                        if($this.drawRectangle.length > 1) {
                            $this.drawRectangle[0].target.setMap(null);
                            $this.drawRectangle[0].target._closeButton.setMap(null);
                            $this.drawRectangle = [];
                            $this.drawRectangle[0] = drawendMouseEvent;
                        }
                        if($this.draw.rectangle) {
                            $this.draw.rectangle.setMap(null);
                            $this.mapCont.marker.setMap(null);
                        }
                    });
                }
            }

            // 지도에 클릭 이벤트를 등록합니다
            // 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
            // 지도를 클릭했을 때 클릭 위치 좌표에 대한 주소정보를 표시하도록 이벤트를 등록합니다
            kakao.maps.event.addListener($this.map, 'click', function(mouseEvent) {
                if(!!$this.toolbox._selected && $this.mapCont.draggable === 'true') {
                    // alert("사각형 그리기 toolbox가 활성화 중입니다.\n맵 상단 toolbox를 클릭하여 비활성화 후 진행해주세요.");
                    // console.log("사각형 그리기 toolbox가 활성화 중이고 draggable === true", $this.mapCont.draggable);
                    $this.mapCont.draggable  = 'true';
                    $this.setMarking();
                } else {
                    // console.log("사각형 그리기 toolbox가 활성화 중이고 draggable === false", $this.mapCont.draggable);
                    $this.mapCont.mouseEvent = mouseEvent;
                    $this.locInfoSpec.valdRngeDist = $this.draw.dist;

                    if ($this.mapCont.draggable === 'true') {
                        searchDetailAddrFromCoords($this.mapCont.mouseEvent.latLng, function (result, status) {
                            $this.mapCont.result = [];
                            $this.mapCont.result = result;
                            if (status === kakao.maps.services.Status.OK) {
                                var detailAddr = !!$this.mapCont.result[0].road_address ? '<div>도로명 : ' + $this.mapCont.result[0].road_address.address_name + '</div>' : '';

                                $this.mapCont.detailAddr = null;
                                $this.mapCont.detailAddr = detailAddr;
                                $this.mapCont.detailAddr += '<div>지번 : ' + $this.mapCont.result[0].address.address_name + '</div>';

                                var content = '<div class="bAddr">' +
                                    '<span class="title">법정동 주소정보</span>' +
                                    $this.mapCont.detailAddr +
                                    '</div>';

                                // 클릭한 위도, 경도 정보를 가져옵니다
                                var latlng = $this.mapCont.mouseEvent.latLng;
                                $this.locInfoSpec.latVal = latlng.getLat();
                                $this.locInfoSpec.lonVal = latlng.getLng();

                                $this.draw.cntrPos = latlng;
                                // 마커를 클릭한 위치에 표시합니다
                                $this.mapCont.marker.setPosition(latlng);
                                $this.mapCont.marker.setMap(null);
                                $this.mapCont.marker.setMap($this.map);

                                // 인포윈도우에 클릭한 위치에 대한 법정동 상세 주소정보를 표시합니다
                                $this.infowindow.setContent(content);

                                $this.locInfoSpec.pstno = !!$this.mapCont.result[0].road_address ? $this.mapCont.result[0].road_address.zone_no : $this.mapCont.result[0].address.zip_code;
                                $this.locInfoSpec.addrBase = !!$this.mapCont.result[0].road_address ? $this.mapCont.result[0].road_address.address_name : $this.mapCont.result[0].address.address_name;
                                $this.locInfoSpec.addrSpec = !!$this.mapCont.result[0].road_address ? $this.mapCont.result[0].road_address.building_name : $this.mapCont.result[0].address.building_name;

                                $this.setRectangle(true);
                            }
                        });
                    }
                }
            });

            // 마커에 마우스오버 이벤트를 등록합니다
            kakao.maps.event.addListener($this.mapCont.marker, 'mouseover', function () {
                // console.log("jcw mouseover :");
                // 마커에 마우스오버 이벤트가 발생하면 인포윈도우를 마커위에 표시합니다
                $this.infowindow.open($this.map, $this.mapCont.marker);
            });

            // 마커에 마우스아웃 이벤트를 등록합니다
            kakao.maps.event.addListener($this.mapCont.marker, 'mouseout', function () {
                // console.log("jcw mouseout :");
                // 마커에 마우스아웃 이벤트가 발생하면 인포윈도우를 제거합니다
                $this.infowindow.close();
            });

            kakao.maps.event.addListener($this.map, 'bounds_changed', function() {
                $this.currLevel = $this.map.getLevel();
                // console.log("jcw currLevel :: ", $this.map.getLevel());
            });

            // 마우스 드래그로 지도 이동이 완료되었을 때 마지막 파라미터로 넘어온 함수를 호출하도록 이벤트를 등록합니다
            kakao.maps.event.addListener($this.map, 'dragend', function() {
                // alert("jcw 지도이동 ");
                if($this.map.getLevel() < 6) {
                    $this.changedBound();
                }
            });

            // // 중심 좌표나 확대 수준이 변경됐을 때 지도 중심 좌표에 대한 주소 정보를 표시하도록 이벤트를 등록합니다
            // kakao.maps.event.addListener($this.map, 'idle', function() {
            //     searchAddrFromCoords($this.map.getCenter(), displayCenterInfo);
            // });
            //
            // function searchAddrFromCoords(coords, callback) {
            //     // 좌표로 행정동 주소 정보를 요청합니다
            //     $this.mapCont.geocoder.coord2RegionCode(coords.getLng(), coords.getLat(), callback);
            // }

            function searchDetailAddrFromCoords(coords, callback) {
                // 좌표로 법정동 상세 주소 정보를 요청합니다
                $this.mapCont.geocoder.coord2Address(coords.getLng(), coords.getLat(), callback);
            }

            // // 지도 좌측상단에 지도 중심좌표에 대한 주소정보를 표출하는 함수입니다
            // function displayCenterInfo(result, status) {
            //
            // }
        },
        drawMngRect : function(latLng) {
            let $this = this;
            $this.mapCont.mouseEvent.latLng = latLng;
            searchDetailAddrFromCoords($this.mapCont.mouseEvent.latLng, function (result, status) {
                $this.mapCont.result = [];
                $this.mapCont.result = result;
                if (status === kakao.maps.services.Status.OK) {
                    var detailAddr = !!$this.mapCont.result[0].road_address ? '<div>도로명 : ' + $this.mapCont.result[0].road_address.address_name + '</div>' : '';

                    $this.mapCont.detailAddr = null;
                    $this.mapCont.detailAddr = detailAddr;
                    $this.mapCont.detailAddr += '<div>지번 : ' + $this.mapCont.result[0].address.address_name + '</div>';

                    var content = '<div class="bAddr">' +
                        '<span class="title">법정동 주소정보</span>' +
                        $this.mapCont.detailAddr +
                        '</div>';

                    // 클릭한 위도, 경도 정보를 가져옵니다
                    $this.locInfoSpec.latVal = latLng.getLat();
                    $this.locInfoSpec.lonVal = latLng.getLng();

                    $this.draw.cntrPos = latLng;
                    // 마커를 클릭한 위치에 표시합니다
                    $this.mapCont.marker.setPosition(latLng);
                    $this.mapCont.marker.setMap(null);
                    $this.mapCont.marker.setMap($this.map);

                    // 인포윈도우에 클릭한 위치에 대한 법정동 상세 주소정보를 표시합니다
                    $this.infowindow.setContent(content);

                    $this.locInfoSpec.pstno = !!$this.mapCont.result[0].road_address ? $this.mapCont.result[0].road_address.zone_no : $this.mapCont.result[0].address.zip_code;
                    $this.locInfoSpec.addrBase = !!$this.mapCont.result[0].road_address ? $this.mapCont.result[0].road_address.address_name : $this.mapCont.result[0].address.address_name;
                    $this.locInfoSpec.addrSpec = !!$this.mapCont.result[0].road_address ? $this.mapCont.result[0].road_address.building_name : $this.mapCont.result[0].address.building_name;

                    // $this.setRectangle();
                }
            });

            function searchDetailAddrFromCoords(coords, callback) {
                // 좌표로 법정동 상세 주소 정보를 요청합니다
                $this.mapCont.geocoder.coord2Address(coords.getLng(), coords.getLat(), callback);
            }

        },
        searchSpecMap : function() {
            let $this = this;
            if(!!$this.locInfoSpec.latVal) {
                $this.currLat = $this.locInfoSpec.latVal;
                $this.currLng = $this.locInfoSpec.lonVal;
            }
            if ( !$this.map ) {
                $this.map = new kakao.maps.Map(this.getContainer(), {
                    center: $this.getLatLng($this.currLat, $this.currLng), // 지도의 중심좌표 37.48170530421067, 126.88481997057949
                    draggable: false, // 지도를 생성할때 지도 이동 및 확대/축소 제어
                    currLevel: 3 // 지도의 확대 레벨
                });
            } else {
                $this.map.setCenter($this.getLatLng($this.locInfoSpec.latVal, $this.locInfoSpec.lonVal));
            }

            if($this.mapCont.searchSpecFg === 'Y') {

                if ($this.locInfoSpec.valdRngeDist < 50) {
                    $this.map.setLevel(2);
                } else if ($this.locInfoSpec.valdRngeDist < 200) {
                    $this.map.setLevel(3);
                } else if ($this.locInfoSpec.valdRngeDist < 500) {
                    $this.map.setLevel(4);
                } else if ($this.locInfoSpec.valdRngeDist < 1000) {
                    $this.map.setLevel(5);
                } else if ($this.locInfoSpec.valdRngeDist < 1600) {
                    $this.map.setLevel(6);
                } else {
                    $this.map.setLevel(7);
                }
                $this.draw.cntrPos = $this.getLatLng($this.locInfoSpec.latVal, $this.locInfoSpec.lonVal);
                $this.draw.dist = $this.locInfoSpec.valdRngeDist;
                $this.mapCont.detailAddr = null;
                $this.mapCont.detailAddr = !!$this.locInfoSpec.addrBase ? '<div>도로명 : ' + $this.locInfoSpec.addrBase + '</div>' : '';
                $this.mapCont.detailAddr += !!$this.locInfoSpec.addrSpec ? '<div>상세 : ' + $this.locInfoSpec.addrSpec + '</div>' : '';

                var content = '<div class="bAddr">' +
                    '<span class="title">법정동 주소정보</span>' +
                    $this.mapCont.detailAddr +
                    '</div>';

                var markerPosition  = $this.getLatLng($this.locInfoSpec.latVal, $this.locInfoSpec.lonVal);

                $this.mapCont.marker.setPosition(markerPosition);
                $this.mapCont.marker.setMap(null);
                $this.mapCont.marker.setMap($this.map);

                // 인포윈도우에 클릭한 위치에 대한 법정동 상세 주소정보를 표시합니다
                $this.infowindow.setContent(content);

                // if(!!$this.toolbox._selected) {
                //     alert("사각형 그리기 toolbox가 활성화 중입니다.\n맵 상단 toolbox를 클릭하여 비활성화 후 진행해주세요.");
                // } else {
                $this.setRectangle(false);
                // }

                $this.mapCont.searchSpecFg = 'N';
            }
        },
        createPs : function() {
            // 장소 검색 객체를 생성합니다
            let $this = this;

            if(!$this.ps) {
                $this.ps = new kakao.maps.services.Places();
            }
            $this.ps.setMap($this.map);

            // 검색 결과 목록이나 마커를 클릭했을 때 장소명을 표출할 인포윈도우를 생성합니다
            if(!$this.psInfowindow) {
                $this.psInfowindow = new kakao.maps.InfoWindow({zIndex: 1});
            }
        },
        searchPlaces : function() {
            let $this = this;

            let keyword = document.getElementById('keyword').value;

            if (!keyword.replace(/^\s+|\s+$/g, '')) {
                alert('키워드를 입력해주세요!');
                return false;
            }
            // 장소검색 객체를 통해 키워드로 장소검색을 요청합니다
            $this.ps.keywordSearch(keyword, $this.placesSearchCB);
        },
        placesSearchCB : function(data, status, pagination) {
            let $this = this;

            if (status === kakao.maps.services.Status.OK) {

                // 정상적으로 검색이 완료됐으면
                // 검색 목록과 마커를 표출합니다
                $this.psDisplayPlaces(data);

                // 페이지 번호를 표출합니다
                $this.psDisplayPagination(pagination);

            } else if (status === kakao.maps.services.Status.ZERO_RESULT) {
                alert('검색 결과가 존재하지 않습니다.');
                return;
            } else if (status === kakao.maps.services.Status.ERROR) {
                alert('검색 결과 중 오류가 발생했습니다.');
                return;
            }
        },
        psDisplayPlaces : function(places) {
            // 검색 결과 목록과 마커를 표출하는 함수입니다
            let $this = this;

            var listEl = document.getElementById('placesList'),
                menuEl = document.getElementById('menu_wrap'),
                fragment = document.createDocumentFragment(),
                bounds = new kakao.maps.LatLngBounds(),
                listStr = '';

            // 검색 결과 목록에 추가된 항목들을 제거합니다
            $this.psRemoveAllChildNods(listEl);

            // 지도에 표시되고 있는 마커를 제거합니다
            $this.psRemoveMarker();

            for ( var i=0; i<places.length; i++ ) {

                // 마커를 생성하고 지도에 표시합니다
                var placePosition = new kakao.maps.LatLng(places[i].y, places[i].x),
                    marker = $this.psAddMarker(placePosition, i),
                    itemEl = $this.psGetListItem(i, places[i]); // 검색 결과 항목 Element를 생성합니다

                // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
                // LatLngBounds 객체에 좌표를 추가합니다
                bounds.extend(placePosition);
                $this.placePositionList.push(placePosition);
                // 마커와 검색결과 항목에 mouseover 했을때
                // 해당 장소에 인포윈도우에 장소명을 표시합니다
                // mouseout 했을 때는 인포윈도우를 닫습니다
                (function(marker, title) {
                    kakao.maps.event.addListener(marker, 'mouseover', function() {
                        $this.psDisplayInfowindow(marker, title);
                    });

                    kakao.maps.event.addListener(marker, 'mouseout', function() {
                        $this.psInfowindow.close();
                    });

                    // itemEl.onmouseover =  function () {
                    //     console.log("jcw 검색 목록 mouseover placePosition :: ", placePosition);
                    //     $this.psDisplayInfowindow(marker, title);
                    //
                    //     // $this.map.setCenter(placePosition);
                    // };

                    itemEl.onclick =  function () {
                        $this.psDisplayInfowindow(marker, title);
                        $this.map.setLevel(3);
                        $this.map.setCenter(marker.getPosition());
                    };

                    itemEl.onmouseout =  function () {
                        $this.psInfowindow.close();
                    };
                })(marker, places[i].place_name);

                fragment.appendChild(itemEl);
            }
            // 검색결과 항목들을 검색결과 목록 Element에 추가합니다
            listEl.appendChild(fragment);
            menuEl.scrollTop = 0;

            // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
            $this.map.setBounds(bounds);

        },
        psDisplayPagination : function(pagination) {
            // 검색결과 목록 하단에 페이지번호를 표시는 함수입니다
            let $this = this;

            var paginationEl = document.getElementById('pagination'),
                fragment = document.createDocumentFragment(),
                i;

            // 기존에 추가된 페이지번호를 삭제합니다
            while (paginationEl.hasChildNodes()) {
                paginationEl.removeChild (paginationEl.lastChild);
            }

            for (i=1; i<=pagination.last; i++) {
                var el = document.createElement('a');
                el.href = "#";
                el.innerHTML = i;

                if (i===pagination.current) {
                    el.className = 'on';
                } else {
                    el.onclick = (function(i) {
                        return function() {
                            pagination.gotoPage(i);
                        }
                    })(i);
                }

                fragment.appendChild(el);
            }
            paginationEl.appendChild(fragment);
        },
        psRemoveAllChildNods : function (el) {
            let $this = this;
            // 검색결과 목록의 자식 Element를 제거하는 함수입니다
            while (el.hasChildNodes()) {
                el.removeChild(el.lastChild);
            }
            $this.placePositionList = [];
        },
        psRemoveMarker : function () {
            let $this = this;
            // 지도 위에 표시되고 있는 마커를 모두 제거합니다
            for ( var i = 0; i < $this.psMarkers.length; i++ ) {
                $this.psMarkers[i].setMap(null);
            }
            $this.psMarkers = [];
        },
        psAddMarker : function (position, idx, title) {
            // 마커를 생성하고 지도 위에 마커를 표시하는 함수입니다
            let $this = this;

            var imageSrc = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png', // 마커 이미지 url, 스프라이트 이미지를 씁니다
                imageSize = new kakao.maps.Size(36, 37),  // 마커 이미지의 크기
                imgOptions =  {
                    spriteSize : new kakao.maps.Size(36, 691), // 스프라이트 이미지의 크기
                    spriteOrigin : new kakao.maps.Point(0, (idx*46)+10), // 스프라이트 이미지 중 사용할 영역의 좌상단 좌표
                    offset: new kakao.maps.Point(13, 37) // 마커 좌표에 일치시킬 이미지 내에서의 좌표
                },
                markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imgOptions),
                marker = new kakao.maps.Marker({
                    position: position, // 마커의 위치
                    image: markerImage
                });

            marker.setMap($this.map); // 지도 위에 마커를 표출합니다
            $this.psMarkers.push(marker);  // 배열에 생성된 마커를 추가합니다

            return marker;
        },
        // 검색결과 항목을 Element로 반환하는 함수입니다
        psGetListItem : function (index, places) {

            var el = document.createElement('li'),
                itemStr = '<span class="markerbg marker_' + (index+1) + '"></span>' +
                    '<div class="info">' +
                    '   <h5>' + places.place_name + '</h5>';

            if (places.road_address_name) {
                itemStr += '    <span>' + places.road_address_name + '</span>' +
                    '   <span class="jibun gray">' +  places.address_name  + '</span>';
            } else {
                itemStr += '    <span>' +  places.address_name  + '</span>';
            }

            itemStr += '  <span class="tel">' + places.phone  + '</span>' +
                '</div>';

            el.innerHTML = itemStr;
            el.className = 'item';

            return el;
        },
        // 검색결과 목록 또는 마커를 클릭했을 때 호출되는 함수입니다
        // 인포윈도우에 장소명을 표시합니다
        psDisplayInfowindow : function (marker, title) {
            let $this = this;

            var content = '<div style="padding:5px;z-index:1;">' + title + '</div>';

            $this.psInfowindow.setContent(content);
            $this.psInfowindow.open($this.map, marker);
        },
        changedBound : function() {
            let $this = this;

            const bounds = $this.map.getBounds();
            const sw = bounds.getSouthWest();
            const ne = bounds.getNorthEast();
            const swLat = sw.getLat();
            const swLng = sw.getLng();
            const neLat = ne.getLat();
            const neLng = ne.getLng();

            const center  = $this.map.getCenter();
            const cntrLat = center.getLat();
            const cntrLng = center.getLng();

            $this.oldSwLat = $this.currSwLat;
            $this.oldSwLng = $this.currSwLng;
            $this.oldNeLat = $this.currNeLat;
            $this.oldNeLng = $this.currNeLng;

            $this.currLat   = cntrLat;
            $this.currLng   = cntrLng;
            $this.currSwLat = swLat;
            $this.currSwLng = swLng;
            $this.currNeLat = neLat;
            $this.currNeLng = neLng;

            // console.log($this.currLat, $this.currLng, $this.currSwLat, $this.currSwLng, $this.currNeLat, $this.currNeLng);
            // console.log(cntrLat, cntrLng, swLat, swLng, neLat, neLng);
            $this.searchZoneList();
        },
        searchZoneList: function() {
            let $this = this;
            if ( $this.currSwLat > 0.0 && $this.currSwLng > 0.0 && $this.currNeLat > 0.0 && $this.currNeLng > 0.0 )
            {
                const params = {
                    latVal          : $this.currLat,
                    lonVal          : $this.currLng,
                    swstLatVal      : $this.currSwLat,
                    swstLonVal      : $this.currSwLng,
                    nestLatVal      : $this.currNeLat,
                    nestLonVal      : $this.currNeLng,
                    oldSwstLatVal   : $this.oldSwLat,
                    oldSwstLonVal   : $this.oldSwLng,
                    oldNestLatVal   : $this.oldNeLat,
                    oldNestLonVal   : $this.oldNeLng,
                    currLevel       : $this.currLevel
                }
                AjaxUtil.post({
                    url: '/svcStnd/loc/locInfoMng/searchLocZoneList.ab',
                    param: params,
                    success: function(response) {
                        if ( !!response["rtnData"].result && response["rtnData"].result.length > 0 )
                        {
                            const markerObj = _.cloneDeep($this.markerList);
                            // let markerCreateObjList = [];
                            // $this.zoneList = [];
                            // $.each(response["rtnData"].result, function(index, data) {
                            //     console.log("jcw 33 :: ");
                            //     if ( markerObj.length === 0 || markerObj.findIndex( (locNo) => locNo === data.locNo ) === -1 ) {
                            //         markerCreateObjList.push(data);
                            //         // $this.markerList.push(data.locNo);
                            //     }
                            // });
                            // console.log("jcw 44 :: ");
                            // $.each(markerCreateObjList, function(index, marker) {
                            $.each(response["rtnData"].result, function(index, marker) {
                                if ( markerObj.length === 0 || markerObj.findIndex( (locNo) => locNo === marker.locNo ) === -1 ) {
                                    $this.markerList.push(marker.locNo);

                                    let markerImage = {
                                        plcCd     : marker.plcCd,
                                        plcClssCd : marker.plcClssCd,
                                        locApntCd : marker.locApntCd
                                    };
                                    $this.setDraw(marker);
                                    $this.setMarker($this.drawList.cntrPos, markerImage);
                                    $this.setRectangleList(markerImage.plcClssCd);

                                    // jcw
                                    // if ( marker.locApntCd === 'GUAR' ) {
                                    //     $this.zoneList.push($this.drawList);
                                    // }
                                    // $this.zoneList.push($this.drawList);
                                    // console.log("jcw initDrawValue 전 :: ");
                                    $this.initDrawValue();
                                }
                            });
                        }
                    },
                    error: function (response) {
                        Swal.alert([response, 'error']);
                    }
                });
            }
        },
        searchZoneListTemp: function() {
            let $this = this;
            if ( $this.currSwLat > 0.0 && $this.currSwLng > 0.0 && $this.currNeLat > 0.0 && $this.currNeLng > 0.0 )
            {
                const params = {
                    latVal          : $this.currLat,
                    lonVal          : $this.currLng,
                    swstLatVal      : $this.currSwLat,
                    swstLonVal      : $this.currSwLng,
                    nestLatVal      : $this.currNeLat,
                    nestLonVal      : $this.currNeLng,
                    oldSwstLatVal   : $this.oldSwLat,
                    oldSwstLonVal   : $this.oldSwLng,
                    oldNestLatVal   : $this.oldNeLat,
                    oldNestLonVal   : $this.oldNeLng,
                    currLevel       : $this.currLevel
                }
                AjaxUtil.post({
                    url: '/svcStnd/loc/locInfoMng/searchLocZoneList.ab',
                    param: params,
                    success: function(response) {
                        if ( !!response["rtnData"].result && response["rtnData"].result.length > 0 )
                        {
                            const markerObj = _.cloneDeep($this.markerList);
                            // let markerCreateObjList = [];
                            // $this.zoneList = [];
                            // $.each(response["rtnData"].result, function(index, data) {
                            //     console.log("jcw 33 :: ");
                            //     if ( markerObj.length === 0 || markerObj.findIndex( (locNo) => locNo === data.locNo ) === -1 ) {
                            //         markerCreateObjList.push(data);
                            //         // $this.markerList.push(data.locNo);
                            //     }
                            // });
                            // console.log("jcw 44 :: ");
                            // $.each(markerCreateObjList, function(index, marker) {
                            $.each(response["rtnData"].result, function(index, marker) {
                                if ( markerObj.length === 0 || markerObj.findIndex( (locNo) => locNo === marker.locNo ) === -1 ) {
                                    $this.markerList.push(marker.locNo);

                                    let markerImage = {
                                        plcCd     : marker.plcCd,
                                        plcClssCd : marker.plcClssCd,
                                        locApntCd : marker.locApntCd
                                    };
                                    $this.setDraw(marker);
                                    $this.setMarker($this.drawList.cntrPos, markerImage);
                                    $this.setRectangleList(markerImage.plcClssCd);

                                    // jcw
                                    // if ( marker.locApntCd === 'GUAR' ) {
                                    //     $this.zoneList.push($this.drawList);
                                    // }
                                    // $this.zoneList.push($this.drawList);
                                    // console.log("jcw initDrawValue 전 :: ");
                                    $this.initDrawValue();
                                }
                            });
                        }
                    },
                    error: function (response) {
                        Swal.alert([response, 'error']);
                    }
                });
            }
        },
        initDrawValue: function() {
            let $this = this;

            $this.drawList = {
                flag         : false,
                locNo        : -1,
                locNm        : '',
                latVal       : 0,
                lonVal       : 0,
                swstLatVal   : 0,
                nestLatVal   : 0,
                swstLonVal   : 0,
                nestLonVal   : 0,
                valdRngeDist : 10,
                pstno        : '',
                addrBase     : '',
                addrSpec     : '',
                cntrPos      : null,
                rectangle    : null,
                marker       : null,
                cstmOvrlay   : null,
            };
        },
        setDraw: function(params) {
            let $this = this;
            $this.drawList = {
                flag         : false,
                locNo        : params.locNo,
                locNm        : params.locNm,
                plcNm        : params.plcNm,
                latVal       : params.latVal,
                lonVal       : params.lonVal,
                swstLatVal   : params.swstLatVal,
                swstLonVal   : params.swstLonVal,
                nestLatVal   : params.nestLatVal,
                nestLonVal   : params.nestLonVal,
                valdRngeDist : params.valdRngeDist,
                pstno        : params.pstno,
                addrBase     : params.addrBase,
                addrSpec     : params.addrSpec,
                cntrPos      : $this.getLatLng(params.latVal, params.lonVal),
                rectangle    : null,
                marker       : null,
                cstmOvrlay   : null,
            }
        },
        /**
         * @Param pos Object(lat, lng)
         * @Param markerImage Object ( marker )
         * @Param params Object( overlay )
         */
        setMarker: function(pos, markerImage, params) {
            let $this = this;
            if ( WebUtil.isNotNull(pos.getLat()) && WebUtil.isNotNull(pos.getLng()) ) {

                let marker = $this.addMarker(pos, markerImage);

                // jcw :: 맵 확장이 매우 커질 경우 marker 이벤트 리스너가 너무 많이 호출 되어서 일단 주석..
                // 인포윈도우를 생성합니다
                const infowindow = new kakao.maps.InfoWindow({
                    position: pos,
                    content: "위치번호 : " + $this.drawList.locNo
                        + "<br>위치명 : " + $this.drawList.locNm
                        + "<br>장소구분 : " + $this.drawList.plcNm
                });

                // jcw :: 맵 확장이 매우 커질 경우 marker 이벤트 리스너가 너무 많이 호출 되어서 일단 주석..
                kakao.maps.event.addListener(marker, 'mouseover', function() {
                    infowindow.open($this.map, marker);
                });
                kakao.maps.event.addListener(marker, 'mouseout', function() {
                    infowindow.close();
                });

                if ( !!marker.locNo ) {
                    $this.locNoList = marker.locNo;
                }
                // jcw
                // if ( WebUtil.isNotNull(params) ) {
                //     $this.makeCustomOverlay(pos, params);
                // }

            } else {
                console.log('set marker position not exists.')
            }
        },
        /**
         * point : 중심 위도/경도를 가지는 Position 객체
         * title : 마커의 타이틀
         * index : 스프라이트 이미지의 이미지 인덱스(normal, mouseOver, click 이런 이미지를 한 이미지파일에 합쳐져 있는 것)
         */
        addMarker: function(pos, markerImage) {
            let $this = this;

            let marker = null;

            if ( WebUtil.isNotNull(pos.getLat()) && WebUtil.isNotNull(pos.getLng()) ) {

                // 마커 이미지로 변경하려면 아래 함수에서 이미지 경로 및 사이즈를 변경해야 함
                let customImage;
                // jcw
                // if ( !!markerImage.moveIndex && markerImage.moveIndex > -1 )
                // {
                //     customImage = $this.getMovePathMarkerImage(markerImage);
                //     marker = new kakao.maps.Marker({
                //         map     : $this.map,
                //         position: pos,
                //         image   : customImage
                //     });
                // }
                // else
                {
                    customImage = $this.getZoneMarkerImage(markerImage);

                    // 마커를 생성하고 이미지는 기본 마커 이미지를 사용합니다
                    if ( !!customImage.normal )
                    {
                        marker = new kakao.maps.Marker({
                            map     : $this.map,
                            position: pos,
                            image   : customImage.normal
                        });

                        // 마커 객체에 마커아이디와 마커의 기본 이미지를 추가합니다
                        if ( $this.drawList > -1 ) {
                            marker.locNo = $this.drawList;
                        }
                        marker.normalImage = customImage.normal;
                        marker.clickImage  = customImage.click;
                    }

                    // jcw
                    // 마커에 click 이벤트를 등록합니다

                    // if ( markerImage.locApntCd === 'GUAR' && !!customImage.click )
                    // {
                    //     kakao.maps.event.addListener(marker, 'click', function() {
                    //
                    //         // 클릭된 마커가 없고, click 마커가 클릭된 마커가 아니면
                    //         // 마커의 이미지를 클릭 이미지로 변경합니다
                    //         if ( $this.selectedMarker !== marker ) {
                    //
                    //             // 클릭된 마커 객체가 null이 아니면
                    //             // 클릭된 마커의 이미지를 기본 이미지로 변경하고
                    //             if ( !!$this.selectedMarker ) {
                    //                 $this.selectedMarker.setImage($this.selectedMarker.normalImage);
                    //             }
                    //
                    //             $this.setExistedMarker(marker);
                    //
                    //             // 현재 클릭된 마커의 이미지는 클릭 이미지로 변경합니다
                    //             marker.setImage(marker.clickImage);
                    //
                    //             // 클릭된 마커를 현재 클릭된 마커 객체로 설정합니다
                    //             $this.selectedMarker = marker;
                    //
                    //             $this.emitter.emit('onSelectedMarker', marker.locNo);
                    //         }
                    //     });
                    //
                    //     // 클릭된 마커를 현재 클릭된 마커 객체로 설정합니다
                    //     $this.selectedMarker = marker;
                    // }
                }

                $this.drawList.marker = marker;
            } else {
                console.log('add marker position not exists.')
            }

            return marker;
        },
        getZoneMarkerImage(markerImage) {

            let $this = this;

            let imageFile = '';
            let markerIndex = 0;
            // console.log(markerImage);
            if ( markerImage.locApntCd === 'GORG' ) {
                // imageFile = GORG_MARKER;
                imageFile = '/img/map/gorg_markers_sprite.png';
            } else if ( markerImage.locApntCd === 'GUAR' ) {
                // imageFile = GUAR_MARKER;
                imageFile = '/img/map/guar_markers_sprite.png';
            } else {
                imageFile = '';
            }

            if ( markerImage.plcClssCd === 'SZONE' ) {
                markerIndex = 0;
            } else if ( markerImage.plcClssCd === 'DZONE' ) {

                if ( markerImage.locApntCd === 'GORG' ) {

                    // 유흥/유해
                    if ( markerImage.plcCd === 'DEHM' ) {
                        markerIndex = 1;
                    }
                    // 공사/위험물
                    else if ( markerImage.plcCd === 'DECG' ) {
                        markerIndex = 2;
                    }
                    // 교통사고다발
                    else if ( markerImage.plcCd === 'ACDZ' ) {
                        markerIndex = 3;
                    }
                    // 우범지역
                    else if ( markerImage.plcCd === 'CRMN' ) {
                        markerIndex = 4;
                    } else {
                        markerIndex = -1;
                    }

                } else {
                    markerIndex = 1;
                }
            }

            // console.log(imageFile);
            // console.log(markerIndex);

            let MARKER_WIDTH        = 33; // 기본, 클릭 마커의 너비      // 마커 한개의 너비
            let MARKER_HEIGHT       = 38; // 기본, 클릭 마커의 높이      // 마커 한개의 높이
            let OFFSET_X            = 12; // 기본, 클릭 마커의 기준 X좌표
            let OFFSET_Y            = MARKER_HEIGHT; // 기본, 클릭 마커의 기준 Y좌표

            let OVER_MARKER_WIDTH   = 40; // 오버 마커의 너비
            let OVER_MARKER_HEIGHT  = 42; // 오버 마커의 높이
            let OVER_OFFSET_X       = 13; // 오버 마커의 기준 X좌표
            let OVER_OFFSET_Y       = OVER_MARKER_HEIGHT; // 오버 마커의 기준 Y좌표

            let SPRITE_WIDTH        = 126; // 스프라이트 이미지 너비     // 이미지 크기
            let SPRITE_HEIGHT       = 206; // 스프라이트 이미지 높이     // 이미지 크기
            if ( markerImage.locApntCd === 'GUAR' ) {
                SPRITE_HEIGHT       = 84;
            }

            let WIDTH_GAP           = 10; // 스프라이트 이미지에서 마커간 간격
            let HEIGHT_GAP          = 10; // 스프라이트 이미지에서 마커간 간격

            if ( markerImage.locApntCd === 'GUAR' ) {
                WIDTH_GAP           = 6;
                HEIGHT_GAP          = 6;
            } else {
                if ( markerImage.plcClssCd === 'DZONE' ) {
                    WIDTH_GAP       = 4;
                    HEIGHT_GAP      = 5;
                }
            }

            let markerSize       = new kakao.maps.Size(MARKER_WIDTH, MARKER_HEIGHT);           // 기본, 클릭 마커의 크기
            let markerOffset     = new kakao.maps.Point(OFFSET_X, OFFSET_Y);                   // 기본, 클릭 마커의 기준좌표
            let overMarkerSize   = new kakao.maps.Size(OVER_MARKER_WIDTH, OVER_MARKER_HEIGHT); // 오버 마커의 크기
            let overMarkerOffset = new kakao.maps.Point(OVER_OFFSET_X, OVER_OFFSET_Y);         // 오버 마커의 기준 좌표
            let spriteImageSize  = new kakao.maps.Size(SPRITE_WIDTH, SPRITE_HEIGHT);           // 스프라이트 이미지의 크기

            let gapX         = (MARKER_WIDTH + WIDTH_GAP);                 // 스프라이트 이미지에서 마커로 사용할 이미지 X좌표 간격 값
            let originY      = (MARKER_HEIGHT + HEIGHT_GAP) * markerIndex;        // 스프라이트 이미지에서 기본, 클릭 마커로 사용할 Y좌표 값
            let overOriginY  = (OVER_MARKER_HEIGHT + HEIGHT_GAP) * markerIndex;   // 스프라이트 이미지에서 오버 마커로 사용할 Y좌표 값
            let normalOrigin = new kakao.maps.Point(0, originY);            // 스프라이트 이미지에서 기본 마커로 사용할 영역의 좌상단 좌표
            let clickOrigin  = new kakao.maps.Point(gapX, originY);         // 스프라이트 이미지에서 마우스오버 마커로 사용할 영역의 좌상단 좌표
            let overOrigin   = new kakao.maps.Point(gapX * 2, overOriginY); // 스프라이트 이미지에서 클릭 마커로 사용할 영역의 좌상단 좌표

            // 기본 마커이미지, 오버 마커이미지, 클릭 마커이미지를 생성합니다
            let normal = $this.splitImage(imageFile, markerSize    , markerOffset    , normalOrigin, spriteImageSize);
            let click  = $this.splitImage(imageFile, markerSize    , markerOffset    , clickOrigin , spriteImageSize);
            let over   = $this.splitImage(imageFile, overMarkerSize, overMarkerOffset, overOrigin  , spriteImageSize);

            return {
                'normal' : normal,
                'click'  : click,
                'over'   : over
            }
        },
        splitImage: function(imageFile, markerSize, offset, spriteOrigin, spriteImageSize) {

            let markerImage = new kakao.maps.MarkerImage (
                imageFile, // 스프라이트 마커 이미지 URL
                markerSize, // 마커의 크기
                {
                    offset       : offset,          // 마커 이미지에서의 기준 좌표
                    spriteOrigin : spriteOrigin,    // 스트라이프 이미지 중 사용할 영역의 좌상단 좌표
                    spriteSize   : spriteImageSize  // 스프라이트 이미지의 크기
                }
            );

            return markerImage;
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
                if ( WebUtil.isNotNull(lat.lat) && WebUtil.isNotNull(lat.lng) ) {
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
        getRectBound : function(square) {
            let $this = this;

            let southLat;
            let northLat;
            let westLng;
            let eastLng;
            // jcw :: 정사각형일 때
            if(square) {
                let center = $this.draw.cntrPos;
                let radius = $this.draw.dist;

                // 위도거리 : 1도=111Km
                // 경도거리 위도37도기준 1도=88.8km
                let unitLat = $this.getLatPerMeter() * radius;
                let unitLng = $this.getLngPerMeter() * radius;

                southLat = center.getLat() - unitLat;
                northLat = center.getLat() + unitLat;
                westLng = center.getLng() - unitLng;
                eastLng = center.getLng() + unitLng;

                $this.locInfoSpec.swstLatVal = southLat;
                $this.locInfoSpec.swstLonVal = westLng;
                $this.locInfoSpec.nestLatVal = northLat;
                $this.locInfoSpec.nestLonVal = eastLng;
            } else if($this.mapCont.draggable === 'false') {
                southLat = $this.locInfoSpec.swstLatVal;
                westLng = $this.locInfoSpec.swstLonVal;
                northLat = $this.locInfoSpec.nestLatVal;
                eastLng = $this.locInfoSpec.nestLonVal;
            } else { // jcw :: 직사각형일 때
                southLat = $this.locInfoSpec.swstLatVal;
                westLng = $this.locInfoSpec.swstLonVal;
                northLat = $this.locInfoSpec.nestLatVal;
                eastLng = $this.locInfoSpec.nestLonVal;
            }

            let sw = $this.getLatLng(southLat, westLng);
            let ne = $this.getLatLng(northLat, eastLng);

            // 사각형을 구성하는 영역정보를 생성합니다
            // 사각형을 생성할 때 영역정보는 LatLngBounds 객체로 넘겨줘야 합니다
            return new kakao.maps.LatLngBounds(sw, ne);
        },
        setRectangle : function(square) {
            let $this = this;

            // 사각형을 구성하는 영역정보를 생성합니다
            // 사각형을 생성할 때 영역정보는 LatLngBounds 객체로 넘겨줘야 합니다
            var rectangleBounds = $this.getRectBound(square);

            // 지도에 표시할 사각형을 생성합니다
            if ( !$this.draw.rectangle ) {
                $this.draw.rectangle = new kakao.maps.Rectangle({
                    bounds: rectangleBounds, // 그려질 사각형의 영역정보입니다
                    strokeWeight    : 1, // 선의 두께입니다
                    strokeColor     : '#39f', // 선의 색깔입니다
                    strokeOpacity   : 0.5, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
                    strokeStyle     : 'shortdashdot', // 선의 스타일입니다
                    fillColor       : '#39f', // 채우기 색깔입니다
                    fillOpacity     : 0.4 // 채우기 불투명도 입니다
                });
            } else {
                $this.draw.rectangle.setMap(null);
                $this.draw.rectangle = null;
                $this.draw.rectangle = new kakao.maps.Rectangle({
                    bounds: rectangleBounds, // 그려질 사각형의 영역정보입니다
                    strokeWeight    : 1, // 선의 두께입니다
                    strokeColor     : '#39f', // 선의 색깔입니다
                    strokeOpacity   : 0.5, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
                    strokeStyle     : 'shortdashdot', // 선의 스타일입니다
                    fillColor       : '#39f', // 채우기 색깔입니다
                    fillOpacity     : 0.4 // 채우기 불투명도 입니다
                });
            }
            if($this.drawRectangle.length > 0) {
                $this.drawRectangle[0].target.setMap(null);
                $this.drawRectangle[0].target._closeButton.setMap(null);
            }
            // 지도에 사각형을 표시합니다
            // $this.draw.rectangle.setMap(null);
            // $this.draw.rectangle.setBounds(rectangleBounds);
            $this.draw.rectangle.setMap($this.map);
        },
        getRectBoundList : function() {
            let $this = this;

            let southLat;
            let northLat;
            let westLng;
            let eastLng;

            southLat = $this.drawList.swstLatVal;
            westLng = $this.drawList.swstLonVal;
            northLat = $this.drawList.nestLatVal;
            eastLng = $this.drawList.nestLonVal;

            let sw = $this.getLatLng(southLat, westLng);
            let ne = $this.getLatLng(northLat, eastLng);

            // 사각형을 구성하는 영역정보를 생성합니다
            // 사각형을 생성할 때 영역정보는 LatLngBounds 객체로 넘겨줘야 합니다
            return new kakao.maps.LatLngBounds(sw, ne);
        },
        setRectangleList : function(div) {
            let $this = this;

            // 사각형을 구성하는 영역정보를 생성합니다
            // 사각형을 생성할 때 영역정보는 LatLngBounds 객체로 넘겨줘야 합니다
            var rectangleBounds = $this.getRectBoundList();

            if(div === 'SZONE') {
                // 지도에 표시할 사각형을 생성합니다
                if ( !$this.drawList.rectangle ) {
                    $this.drawList.rectangle = new kakao.maps.Rectangle({
                        bounds: rectangleBounds, // 그려질 사각형의 영역정보입니다
                        strokeWeight    : 1, // 선의 두께입니다
                        strokeColor     : '#3dccb2', // 선의 색깔입니다
                        strokeOpacity   : 0.3, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
                        strokeStyle     : 'shortdashdot', // 선의 스타일입니다
                        fillColor       : '#3dccb2', // 채우기 색깔입니다
                        fillOpacity     : 0.2 // 채우기 불투명도 입니다
                    });
                }
            } else if(div === 'DZONE') {
                // 지도에 표시할 사각형을 생성합니다
                if ( !$this.drawList.rectangle ) {
                    $this.drawList.rectangle = new kakao.maps.Rectangle({
                        bounds: rectangleBounds, // 그려질 사각형의 영역정보입니다
                        strokeWeight    : 1, // 선의 두께입니다
                        strokeColor     : '#ec4f42', // 선의 색깔입니다
                        strokeOpacity   : 0.3, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
                        strokeStyle     : 'shortdashdot', // 선의 스타일입니다
                        fillColor       : '#ec4f42', // 채우기 색깔입니다
                        fillOpacity     : 0.2 // 채우기 불투명도 입니다
                    });
                }
            } else {
                // 지도에 표시할 사각형을 생성합니다
                if ( !$this.drawList.rectangle ) {
                    $this.drawList.rectangle = new kakao.maps.Rectangle({
                        bounds: rectangleBounds, // 그려질 사각형의 영역정보입니다
                        strokeWeight    : 1, // 선의 두께입니다
                        strokeColor     : '#ffee33', // 선의 색깔입니다
                        strokeOpacity   : 0.4, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
                        strokeStyle     : 'shortdashdot', // 선의 스타일입니다
                        fillColor       : '#ffee33', // 채우기 색깔입니다
                        fillOpacity     : 0.3 // 채우기 불투명도 입니다
                    });
                }
            }

            $this.drawList.rectangle.setBounds(rectangleBounds);
            // 지도에 사각형을 표시합니다
            $this.drawList.rectangle.setMap($this.map);
        },
        setMarking : function() {
            let $this = this;
            // jcw 변경..
            // let draggable;
            if($this.mapCont.draggable === 'false'){
                $this.mapCont.draggable = 'true';
                // draggable = true;
                $("#btnLocMark").text(' 마킹종료');
            } else {
                $this.mapCont.draggable = 'false';
                // draggable = false;
                $("#btnLocMark").text(' 마킹시작');
            }
            // 마우스 드래그로 지도 이동 가능여부를 설정합니다
            $this.map.setDraggable(true);
            $this.map.setZoomable(true);
        },
        getContainer: function(mapId) {
            let id = '';
            if ( WebUtil.isNull(mapId) ) {
                id = 'map';
            }
            return document.getElementById(id);
        },
        initCodeList : function() {
            let $this = this;

            getCommonCodeList('PLC_CLSS_CD',$this.code.plcClssCdList, '');
            getCommonCodeList('PLC_CD',     $this.code.plcCdList, '');
            getCommonCodeList('LOC_APNT_CD',$this.code.locApntCdList, '');
            $this.code.plcCdListFilter      = $this.code.plcCdList;
            $this.code.plcCdListFilterSpec  = $this.code.plcCdList;
            $this.searchAddrHeadList();
            // jcw 팝업 조회로 변경하여 불필요.
            // $this.searchGuarStdtList();
        },
        initGrid: function() {
            let $this = this;

            let locListColModels = [
                {name: "locNo"          , index: "locNo"        , label: "위치번호"     , width: 45         , align: "center"},
                {name: "locNm"          , index: "locNm"        , label: "위치명"       , width: 100        , align: "left"  },
                {name: "plcClssNm"      , index: "plcClssNm"    , label: "장소구분"     , width: 46         , align: "center"},
                {name: "plcNm"          , index: "plcNm"        , label: "장소구분상세"  , width: 63         , align: "center"},
                {name: "guarNm"         , index: "guarNo"       , label: "보호자"       , width: 50         , align: "center"},
                {name: "stdtNm"         , index: "stdtNo"       , label: "학생"        , width: 50          , align: "center"},
                // {name: "regUserId"      , index: "regUserId"    , label: "등록자"       , width: 35         , align: "center"},
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
                        $this.params.currentPage    = resultMap.currentPage;
                        $this.params.rowCount       = resultMap.rowCount;
                        $this.params.currentIndex   = resultMap.currentIndex;
                        $this.searchLocInfoList(false);
                    })
                },
                onSelectRow: function(rowId, status, e) {
                    let item = $('#locInfo_list').jqGrid('getRowData', rowId);
                    if ( !!item.locNo )
                    {
                        $this.locInfo.locNo      = item.locNo;
                        $this.mapCont.draggable  = 'true';
                        $this.setMarking();
                        $this.searchLocInfoSpec(true);
                        // $this.searchZoneList();
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
            $this.setMarking();

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
        // jcw : 팝업 조회로 변경하여 불필요.
        searchGuarStdtList : function() {
            let $this = this;

            AjaxUtil.post({
                url: "/svcStnd/loc/locInfoMng/searchGuarStdtList.ab",
                param: {},
                success: function(response) {
                    $this.code.guarNoList       = [];
                    $this.code.stdtNoList       = [];
                    $this.code.guarNoListSpec   = [];
                    $this.code.stdtNoListSepc   = [];
                    if ( !!response["rtnData"].result && response["rtnData"].result.length > 0 ) {
                        $.each(response["rtnData"].result, function(index, item) {
                            $this.code.guarNoList.push({'cdVal':item.guarNo, 'cdNm':item.guarNm});
                        });
                        $this.code.guarNoListSpec = $this.code.guarNoList;
                    }
                    if ( !!response["rtnData"]["result2"] && response["rtnData"]["result2"].length > 0 ) {
                        $.each(response["rtnData"]["result2"], function(index, item) {
                            $this.code.stdtNoList.push({'cdVal':item.stdtNo, 'cdNm':item.stdtNm, 'guarNo':item.guarNo});
                        });
                        $this.code.stdtNoListFilter     = $this.code.stdtNoList;
                        $this.code.stdtNoListSpec       = $this.code.stdtNoList;
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
            //$this.map = null;
            //$this.mapCont.detailAddr = null;
            if(!!$this.mapCont.marker) {
                $this.mapCont.marker.setMap(null);
            }
            // if(!!$this.draw.rectangle) {
            //     $this.draw.rectangle.setMap(null);
            // }
            if (isSearch) {
                params = $.extend(true, {}, $this.locInfo);
            } else {
                params = $.extend(true, {}, $this.locInfo);
            }
            AjaxUtil.post({
                url: "/svcStnd/loc/locInfoMng/searchLocInfoSpec.ab",
                param: params,
                success: function(response) {
                    if ( !!response["rtnData"].result && response["rtnData"].result.length > 0 ) {
                        $.each(response["rtnData"].result, function(index, item) {
                            $this.locInfoSpec.crud = 'U',
                                $this.locInfoSpec.rdGorgGuarDivSpec = item.rdGorgGuarDiv,
                                // $this.locInfoSpec.guarNo = item.guarNo,
                                $this.locInfoSpec.guarNo        = '',
                                $this.locInfoSpec.stdtNo        = item.stdtNo,
                                $this.locInfoSpec.locNo         = item.locNo,
                                $this.locInfoSpec.locNm         = item.locNm,
                                $this.locInfoSpec.plcClssCd     = item.plcClssCd,
                                $this.locInfoSpec.locApntCd     = item.locApntCd,
                                $this.locInfoSpec.plcCd         = item.plcCd,
                                $this.locInfoSpec.latVal        = item.latVal,
                                $this.locInfoSpec.lonVal        = item.lonVal,
                                $this.locInfoSpec.valdRngeDist  = item.valdRngeDist,
                                $this.locInfoSpec.swstLatVal    = item.swstLatVal,
                                $this.locInfoSpec.swstLonVal    = item.swstLonVal,
                                $this.locInfoSpec.nestLatVal    = item.nestLatVal,
                                $this.locInfoSpec.nestLonVal    = item.nestLonVal,
                                $this.locInfoSpec.pstno         = item.pstno,
                                $this.locInfoSpec.addrBase      = item.addrBase,
                                $this.locInfoSpec.addrSpec      = item.addrSpec,
                                $this.locInfoSpec.delYn         = item.delYn
                        });

                        $this.changeGuarNoSpec();
                        $this.mapCont.searchSpecFg = 'Y';
                        $this.searchSpecMap();
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
                plcClssCd       : '',
                plcCd           : '',
                wordHead1       : '',
                wordHead2       : '',
                guarNo          : '',
                stdtNo          : '',
                guarNm          : '',
                stdtNm          : '',
                addrSpec        : '',
                rdGorgGuarDiv   : 'ALL',
                paging          : 'Y',
                totalCount      : 0,
                rowCount        : 30,
                currentPage     : 1,
                currentIndex    : 0
            }
        },
        resetSearchParamSpec: function() {
            let $this = this;
            $this.locInfoSpec = {
                crud            : 'C',
                rdGorgGuarDivSpec: 'GORG',
                guarNo          : '',
                stdtNo          : '',
                locNo           : '',
                locNm           : '',
                plcClssCd       : '',
                plcCd           : '',
                locApntCd       : '',
                latVal          : '',
                lonVal          : '',
                valdRngeDist    : '',
                swstLatVal      : '',
                swstLonVal      : '',
                nestLatVal      : '',
                nestLonVal      : '',
                pstno           : '',
                addrBase        : '',
                addrSpec        : '',
                delYn           : ''
            }
        },
        resetSearchParamSpecRe: function() {
            let $this = this;
            $this.locInfoSpec.crud  = 'C';
            $this.locInfoSpec.locNo = '';
        },
        regLocInfoSpec : function () {
            let $this = this;

            if ( !this.beforeSave() ) {
                return false;
            }

            // 20220414 컬럼 추가에 따른 로직
            if($this.locInfoSpec.rdGorgGuarDivSpec === 'GORG') {
                $this.locInfoSpec.locApntCd = 'GORG'
            } else {
                $this.locInfoSpec.locApntCd = 'GUAR'
            }

            AjaxUtil.post({
                url: "/svcStnd/loc/locInfoMng/saveLocInfoSpec.ab",
                param: $this.locInfoSpec,
                success: function(response) {
                    Swal.alert(['저장이 완료되었습니다.', 'success']).then(function() {
                        if (!!response["rtnData"].result.locNo) {
                            $this.locInfo.locNo = response["rtnData"].result.locNo;
                        }
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

            if ( WebUtil.isNull($this.locInfoSpec.rdGorgGuarDivSpec) ) {
                Swal.alert(['자료구분을 입력해주세요.', 'info']);
                return false;
            }

            if ( $this.locInfoSpec.rdGorgGuarDivSpec === 'GUAR' &&
                WebUtil.isNull($this.locInfoSpec.stdtNo)) {
                Swal.alert(['보호자 지정일땐 학생을 입력해주세요.', 'info']);
                return false;
            } else if($this.locInfoSpec.rdGorgGuarDivSpec === 'GORG') {
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

            // if ( WebUtil.isNull($this.locInfoSpec.addrSpec) ) {
            //     Swal.alert(['상세주소를 입력해주세요.', 'info']);
            //     return false;
            // }

            if (WebUtil.isNull($this.locInfoSpec.swstLatVal) || WebUtil.isNull($this.locInfoSpec.swstLonVal) ||
                WebUtil.isNull($this.locInfoSpec.nestLatVal) || WebUtil.isNull($this.locInfoSpec.nestLonVal)) {
                Swal.alert(['장소를 마킹하여 범위를 지정해주세요.', 'info']);
                return false;
            }
            return true;
        },
        //학생 및 보호자 search 팝업
        locStdtGuarPopup: function(div) {
            if(div === "search") {
                locStdtGuarPopup.initialize(this.setPopupData);
            } else if( div === "reg") {
                locStdtGuarPopup.initialize(this.setRegPopupData);
            }
        },
        //(학생 및 보호자 번호 , 학교명) 팝업 Grid 값 부모창 input 값에 삽입
        setPopupData: function(data) {
            let $this = this;

            if(data.stdtNo !== undefined && data.stdtNm !== undefined && data.guarNo !== undefined && data.guarNm !== undefined) {
                $this.params.stdtNo = data.stdtNo;
                $this.params.stdtNm = data.stdtNm;
                $this.params.guarNo = data.guarNo;
                $this.params.guarNm = data.guarNm;
            }
        },
        //(학생 및 보호자 번호 , 학교명) 팝업 Grid 값 부모창 input 값에 삽입
        setRegPopupData: function(data) {
            let $this = this;

            if(data.stdtNo !== undefined && data.stdtNm !== undefined && data.guarNo !== undefined && data.guarNm !== undefined) {
                $this.locInfoSpec.stdtNo = data.stdtNo;
                $this.locInfoSpec.guarNo = data.guarNo;
            }
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
        changeGuarNo : function () {
            let $this = this;

            if($this.params.guarNo === ''){
                $this.code.stdtNoListFilter = $this.code.stdtNoList;
            }
            else{
                $this.code.stdtNoListFilter = _.filter($this.code.stdtNoList, function(item) {
                    return item.guarNo === $this.params.guarNo;
                })
            }
        },
        changeStdtNo : function () {
            let $this = this;

            _.filter($this.code.stdtNoList, function(item) {
                if(item.cdVal === $this.params.stdtNo){
                    $this.params.guarNo = item.guarNo;
                }
            })
        },
        changeGorgNoSpec : function () {
            let $this = this;

            $this.locInfoSpec.guarNo = '';
            $this.locInfoSpec.stdtNo = '';

        },
        changeGuarNoSpec : function () {
            let $this = this;
            if($this.locInfoSpec.guarNo === ''){
                $this.code.stdtNoListFilterSpec = $this.code.stdtNoListSpec;
            }
            else{
                $this.code.stdtNoListFilterSpec = _.filter($this.code.stdtNoListSpec, function(item) {
                    return item.guarNo === $this.locInfoSpec.guarNo;
                })
            }
        },
        changeStdtNoSpec : function () {
            let $this = this;
            _.filter($this.code.stdtNoListSpec, function(item) {
                if(item.cdVal === $this.locInfoSpec.stdtNo){
                    $this.locInfoSpec.guarNo = item.guarNo;
                }
            })
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
        // drawRectangle: {
        //     handler: function (newVal, oldVal) {
        //         let $this = this;
        //
        //         let drawRect = $this.drawManager.getData().rectangle[$this.drawManager.getData().rectangle.length-1];
        //
        //         console.log("jcw drawRect newVal:: ", newVal);
        //         console.log("jcw drawRect oldVal:: ", oldVal);
        //         console.log("jcw drawRect x, y:: ", drawRect.ePoint.x, " / ", drawRect.ePoint.y);

        //         // var latlng = $this.mapCont.mouseEvent.latLng;
        //         // $this.locInfoSpec.latVal = latlng.getLat();
        //         // $this.locInfoSpec.lonVal = latlng.getLng();
        //         //
        //         // $this.draw.cntrPos = latlng;
        //         // // 마커를 클릭한 위치에 표시합니다
        //         // $this.mapCont.marker.setPosition(latlng);
        //         // $this.mapCont.marker.setMap(null);
        //         // $this.mapCont.marker.setMap($this.map);
        //
        //         $this.locInfoSpec.valdRngeDist = $this.draw.dist;

        //         console.log("jcw watch deep !!! ::", drawRect);
        //     },
        //     deep: true
        // },
        'locInfoSpec.rdGorgGuarDivSpec': function(value) {
            let $this = this;
            if(value === 'GORG'){
                $this.changeGorgNoSpec();
            }
        },
        currLevel: function(newVal, oldVal) {
            let $this = this;
            if ( newVal > oldVal && newVal < 6) {
                $this.changedBound();
            }
        },
        'draw.dist': function(newVal, oldVal) {
            let $this = this;
            if ( newVal !== oldVal ) {
                if ( $this.draw.rectangle && $this.mapCont.draggable === 'true') {
                    let rectangleBounds = this.getRectBound(true);
                    $this.draw.rectangle.setBounds(rectangleBounds);

                    // 지도에 사각형을 표시합니다
                    // $this.draw.rectangle.setMap(null);
                    $this.draw.rectangle.setMap($this.map);

                    $this.locInfoSpec.valdRngeDist = $this.draw.dist;
                }

                // 넓은 범위로 확대된 맵으로 디테일하게 이용하고 싶을 수 있으니 주석..
                // if ($this.locInfoSpec.valdRngeDist < 150) {
                //     $this.map.setLevel(2);
                // } else if ($this.locInfoSpec.valdRngeDist < 250) {
                //     $this.map.setLevel(3);
                // } else if ($this.locInfoSpec.valdRngeDist < 500) {
                //     $this.map.setLevel(4);
                // } else if ($this.locInfoSpec.valdRngeDist < 1000) {
                //     $this.map.setLevel(5);
                // } else if ($this.locInfoSpec.valdRngeDist < 1700) {
                //     $this.map.setLevel(6);
                // } else {
                //     $this.map.setLevel(7);
                // }
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
