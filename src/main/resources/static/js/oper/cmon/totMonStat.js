let totMonStat = new Vue({
    el: "#totMonStat",
    data: {
        totMonStat: {
            openCnt             : 0,
            operCnt             : 0,
            noRsps              : 0,

            temp                : null,
            tmpDngrSafeOcrrTd   : '',
            tmpDngrSafeOcrrDif  : '',
            tmpDngrSafeOcrrYav  : 3.8,

            tmpDngrZoneCnt      : 4400,
            tmpFallDownCnt      : 2400,
            tmpHbitAbnmCnt      : 1200,
            tmpTmepAbnmCnt      : 3300,
            tmpTotal            : 200000,
            tmpUsage            : 140000,
            tmpNumber1          : 200000,
            tmpNumber2          : 180000,
            tmpNumber3          : 20000,
            tmpNumber4          : 500000,
            tmpNumber5          : 300000,
            tmpNumber6          : 200000,

            plcCdPublTop1       : '유흥/유해',
            plcCdPublTop2       : '공사/위험물',
            plcCdPublTop3       : '우범지역',
            addrPublTop1        : '서울특별시 마포구 마포대로12 한신빌딩 911',
            addrPublTop2        : '서울특별시 금천구 디지털로9길 99 스타밸리빌',
            addrPublTop3        : '서울시 금천구 가산동 1234-17 우리벤처타워',
            cntPublTop1         : 123,
            cntPublTop2         : 78,
            cntPublTop3         : 50,
            plcCdPrntTop1       : '우범지역',
            plcCdPrntTop2       : '유흥/유해',
            plcCdPrntTop3       : '공사/위험물',
            addrPrntTop1        : '서울특별시 송파구 송파대로8길 17',
            addrPrntTop2        : '제주특별자치도 제주시 첨단로 242',
            addrPrntTop3        : '서울특별시 용산구 국방부',
            cntPrntTop1         : 123,
            cntPrntTop2         : 78,
            cntPrntTop3         : 999,

            careBmiBodyIdxAvg       : 27.56,
            careBmiBodyIdxMin       : 17.12,
            careBmiBodyIdxMax       : 42.78,

            careGrowLowRt           : 20,
            careGrowOverRt          : 27,

            careFatIdxHighRt        : 10,
            careFatIdxGnrlRt        : 20,
            careFatIdxUndrRt        : 10,

            careFatPrdtHighRt       : 10,
            careFatPrdtGnrlRt       : 20,
            careFatPrdtUndrRt       : 10,

            careStrsHigh            : 20,
            careStrsVeryHigh        : 10,

            careExcsTimeAvg         : 1.2,
            careExcsTimeBfDay       : 1.5,
            careExcsTimeDif         : 0.3,

            careCalEatAvg           : 2113,
            careCalEatbfDay         : 2238,
            careCalEatDif           : 125,

            careFmenuCdTop1         : '밥',
            careFmenuRtTop1         : 33.1,
            careFmenuCdTop2         : '빵',
            careFmenuRtTop2         : 27.5,
            careFmenuCdTop3         : '튀김',
            careFmenuRtTop3         : 12.9,

            careMmelNeatFmenuCnt    : 1853,
            careMmelNeatFmenuObj    : 20000,
            careMmelNeatFmenuRt     : 9.2,

            careMmelNeatQustCnt     : 1853,
            careMmelNeatQustObj     : 20000,
            careMmelNeatQustRt      : 9.2,

        },
        clockParam: {
            hhmmss                  : '',
            yyyymmdd                : '',
            ddd                     : '',
            amPm                    : ''
        },
        cycl: {
            initCycl                : '',
            timeCycl                : 5000
        },
        code: {
            // sexCdList: []
        },
        selectItem: {
            text        : '',
            value       : ''
        },
        params :{
            crud        : ''
        },
        options: {
            responsive: false,
            plugins: {
                legend: {
                    display: false
                },
                tooltip : {
                    enabled: false
                }
            },
            cutout: 40
        },
        optionsBar: {
            indexAxis : 'y',
            responsive : false,
            plugins: {
                legend: {
                    display : false
                },
                tooltip : {
                    enabled : false
                }
            }
        },
        optionsBarVert: {
            responsive: false,
            plugins: {
                legend: {
                    display : false,
                    position: 'top'
                },
                title: {
                    display: false,
                }
            }
        },
        chartOperStat       : null,
        chartOpenStat       : null,
        chartGrowFat        : null,
        chartFatPrdt        : null,
        chartStrs           : null,
        chartDngrSafeOccr   : null,
        chartDngrZoneProg   : null,
        chartPublSafeDtct   : null,
        chartPublDngrDtct   : null,
        chartPrntSafeDtct   : null,
        chartPrntDngrDtct   : null,

        chartCareBmiBodyIdx : null,
        chartCareGrowIdx    : null,
        chartCareFatIdx     : null,
        chartCareFatPrdt    : null,
        chartCareStrs       : null,
        chartCareExcsTime   : null,
        chartCareCalEat     : null,
        chartCareFmenuTop   : null,
        chartCareMmelNeatFmenu  : null,
        chartCareMmelNeatQust   : null
    },
    methods: {

        initialize: function() {
            let $this = this;

            $this.initCodeList();
            $this.initPage();

            $this.clock();
            setInterval($this.clock, 1000);
            $this.numCountAnimate();
        },
        initCodeList: function() {
            // let $this = this;

            // getCommonCodeList('SEX_CD',$this.code.sexCdList);
        },
        initPage: function(stdtNo, guarNo) {
            let $this = this;

            $this.initChart();
            $this.searchStdtDetlInfo(stdtNo, guarNo);
        },
        initChart: function() {
            let $this = this;

            if ($this.chartOperStat     != null )   $this.chartOperStat.destroy();
            if ($this.chartOpenStat     != null )   $this.chartOpenStat.destroy();
            if ($this.chartGrowFat      != null )   $this.chartGrowFat.destroy();
            if ($this.chartFatPrdt      != null )   $this.chartFatPrdt.destroy();
            if ($this.chartStrs         != null )   $this.chartStrs.destroy();
            if ($this.chartDngrSafeOccr != null )   $this.chartDngrSafeOccr.destroy();
            if ($this.chartDngrZoneProg != null )   $this.chartDngrZoneProg.destroy();
            if ($this.chartPublSafeDtct != null )   $this.chartPublSafeDtct.destroy();
            if ($this.chartPublDngrDtct != null )   $this.chartPublDngrDtct.destroy();
            if ($this.chartPrntSafeDtct != null )   $this.chartPrntSafeDtct.destroy();
            if ($this.chartPrntDngrDtct != null )   $this.chartPrntDngrDtct.destroy();

            if ($this.chartCareBmiBodyIdx   != null )   $this.chartCareBmiBodyIdx.destroy();
            if ($this.chartCareGrowIdx      != null )   $this.chartCareGrowIdx.destroy();
            if ($this.chartCareFatIdx       != null )   $this.chartCareFatIdx.destroy();
            if ($this.chartCareFatPrdt      != null )   $this.chartCareFatPrdt.destroy();
            if ($this.chartCareStrs         != null )   $this.chartCareStrs.destroy();
            if ($this.chartCareExcsTime     != null )   $this.chartCareExcsTime.destroy();
            if ($this.chartCareCalEat       != null )   $this.chartCareCalEat.destroy();
            if ($this.chartCareFmenuTop     != null )   $this.chartCareFmenuTop.destroy();
            if ($this.chartCareMmelNeatFmenu!= null )   $this.chartCareMmelNeatFmenu.destroy();
            if ($this.chartCareMmelNeatQust != null )   $this.chartCareMmelNeatQust.destroy();
        },
        textCenter: function(chartDivId , txt , chartId, color, fontSize, fontStyle) {
            const ctx = document.getElementById(chartDivId).getContext('2d');

            let fontSizeTemp    = fontSize || '20';
            let fontStyleTemp   = fontStyle || 'Arial';

            if (txt.length <= 3) {
            } else {
                fontSizeTemp = 15;
            }

            ctx.textAlign       = 'center';
            ctx.textBaseline    = 'middle';
            let centerX         = ((chartId.chartArea.left + chartId.chartArea.right) / 2);
            let centerY         = ((chartId.chartArea.top + chartId.chartArea.bottom) / 2);

            //반도넛일 경우
            // if (chart.config.options.rotation === Math.PI && chart.config.options.circumference === Math.PI) {
            // 	centerY = ((chart.chart.legend.chartArea.top + chart.chart.legend.chartArea.bottom) / 1.3);
            // }
            ctx.font            = fontSizeTemp + "px " + fontStyleTemp;
            ctx.fillStyle       = color;
            ctx.fillText(txt, centerX, centerY);
        },
        searchStdtDetlInfo: function (stdtNo, guarNo){
            let $this = this;

            // jcw 임시 로직
            stdtNo = 1;
            guarNo = 1;
            if ( !WebUtil.isNull(stdtNo) )
            {
                let params = {
                    'stdtNo'    : stdtNo
                    ,'guarNo'   : guarNo
                }

                $this.initData();

                // /user/stdt/stdtInfoMng/searchStdtDetlInfo.ab
                AjaxUtil.post({
                    url: "/oper/cmon/totMonStat/searchTotMonStat.ab",
                    param: params,
                    success: function(response) {
                        if ( !!response["rtnData"].result ) {
                            $.each(response["rtnData"].result, function(key, val) {
                                $this.totMonStat[key] = val;
                            });

                            $this.updateChart();
                            $this.initCycl($this.cycl.timeCycl);
                        }
                    },
                    error: function (response) {
                        Swal.alert([response, 'error']);
                    }
                });
            }
        },
        updateChart : function() {
            let $this = this;
            // let TempChartColor      = '#989998';
            // let operStatChartColor  = '#65D965';

            // if ($this.totMonStat.growJudgCd !== 'VLOW') {
            //     if      ($this.totMonStat.growJudgCd === 'LOW')   operStatChartColor = '#65D965';
            //     else if ($this.totMonStat.growJudgCd === 'AVG')   operStatChartColor = '#f3e24a';
            //     else if ($this.totMonStat.growJudgCd === 'HIGH')  operStatChartColor = '#fc8f46';
            //     else if ($this.totMonStat.growJudgCd === 'OHIGH') operStatChartColor = '#f1071b';
            // } else {
            //     operStatChartColor = '#2a99ec';
            // }

            let colorRed = '#f1071b';
            let colorGre = '#09ea09';
            let colorBlu = '#2a99ec';
            let colorYel = '#f3e24a';
            let colorOra = '#fc8f46';
            let colorGra = '#989998';
            let colorBla = '#000000';
            let colorWhi = '#ffffff';

            // 헬스케어 활용율 Data
            let tmpGrowFatIdx       = 80;
            let tmpFatPrdtIdx       = 70;
            let tmpStrsIdx          = 90;

            // 위험안전 발생 Data
            let tmpDngrSafeOcrrTd   = 1100;
            let tmpDngrSafeOcrrAv   = 1400;

            // 위험지역 추이 Data
            let tmpDngrZoneProg4wb  = 1400;
            let tmpDngrZoneProg3wb  = 1000;
            let tmpDngrZoneProg2wb  = 1100;
            let tmpDngrZoneProg1wb  = 1200;
            let tmpDngrZoneProgBfDay= 1300;

            // 공공 안전/위험지역 활용(탐지) Data
            let tmpPublSafeDtct   = 83.1;
            let tmpPublDngrDtct   = 33.1;

            // 학부모 안전/위험지역 활용(탐지) Data
            let tmpPrntSafeDtct   = 89.5;
            let tmpPrntDngrDtct   = 35.6;

            $this.totMonStat.tmpDngrSafeOcrrTd = $this.toNumber(tmpDngrSafeOcrrTd);
            $this.totMonStat.tmpDngrSafeOcrrDif = tmpDngrSafeOcrrAv - tmpDngrSafeOcrrTd;

            // 백분율 몫 구하기
            let operCntQuotiIdx     = $this.chartPerQuoti($this.totMonStat.operCnt, $this.totMonStat.openCnt);

            // 나머지 구하기
            let operCntModIdx       = $this.chartPerModIdx(operCntQuotiIdx);
            let growFatModIdx       = $this.chartPerModIdx(tmpGrowFatIdx);
            let fatPrdtModIdx       = $this.chartPerModIdx(tmpFatPrdtIdx);
            let strsModIdx          = $this.chartPerModIdx(tmpStrsIdx);
            let publSafeDtctModIdx  = $this.chartPerModIdx(tmpPublSafeDtct);
            let publDngrDtctModIdx  = $this.chartPerModIdx(tmpPublDngrDtct);
            let prntSafeDtctModIdx  = $this.chartPerModIdx(tmpPrntSafeDtct);
            let prntDngrDtctModIdx  = $this.chartPerModIdx(tmpPrntDngrDtct);

            let dataOperStat = {
                labels              : ['가동','무응답'],
                datasets: [{
                    data            : [operCntQuotiIdx          , operCntModIdx],
                    backgroundColor : [colorBlu                 , colorGra],
                    borderColor     : [colorBlu                 , colorGra],
                    borderWidth     : 10
                }]
            };
            let dataOpenStat = {
                labels              : ['개통','제출','가입'],
                datasets: [{
                    data            : [50       , 30        , 20        ],
                    backgroundColor : [colorBlu , colorOra  , colorGra  ],
                    borderColor     : [colorBlu , colorOra  , colorGra  ],
                    borderWidth     : 22
                }]
            };
            let dataGrowFat = {
                labels              : ['USAGE','NUSAGE'],
                datasets: [{
                    data            : [tmpGrowFatIdx            , growFatModIdx],
                    backgroundColor : [colorBlu                 , colorWhi],
                    borderColor     : [colorBlu                 , colorWhi],
                    borderWidth     : 10
                }]
            };
            let dataFatPrdt = {
                labels              : ['USAGE','NUSAGE'],
                datasets: [{
                    data            : [tmpFatPrdtIdx            , fatPrdtModIdx],
                    backgroundColor : [colorBlu                 , colorWhi],
                    borderColor     : [colorBlu                 , colorWhi],
                    borderWidth     : 10
                }]
            };
            let dataStrs = {
                labels              : ['USAGE','NUSAGE'],
                datasets: [{
                    data            : [tmpStrsIdx               , strsModIdx],
                    backgroundColor : [colorBlu                 , colorWhi],
                    borderColor     : [colorBlu                 , colorWhi],
                    borderWidth     : 10
                }]
            };
            let dataDngrSafeOccr = {
                labels              : ['평균','오늘'],
                datasets: [{
                    data            : [tmpDngrSafeOcrrAv        , tmpDngrSafeOcrrTd],
                    backgroundColor : [colorYel                 , colorOra],
                    borderColor     : [colorYel                 , colorOra],
                    borderWidth     : 0
                }]
            };
            let dataDngrZoneProg = {
                labels              : ['-4주','-3주','-2주','-1주','전일'],
                datasets: [{
                    data            : [tmpDngrZoneProg4wb       , tmpDngrZoneProg3wb        , tmpDngrZoneProg2wb        , tmpDngrZoneProg1wb        , tmpDngrZoneProgBfDay],
                    backgroundColor : [colorBlu                 , colorBlu                  , colorBlu                  , colorBlu                  , colorBlu],
                    borderColor     : [colorBlu                 , colorBlu                  , colorBlu                  , colorBlu                  , colorBlu],
                    borderWidth     : 0,
                    categoryPercentage: 1.0,
                    barPercentage   : 0.4
                }]
            };
            let dataPublSafeDtct = {
                labels              : ['USAGE','NUSAGE'],
                datasets: [{
                    data            : [tmpPublSafeDtct          , publSafeDtctModIdx],
                    backgroundColor : [colorGre                 , colorWhi],
                    borderColor     : [colorGre                 , colorWhi],
                    borderWidth     : 5
                }]
            };
            let dataPublDngrDtct = {
                labels              : ['USAGE','NUSAGE'],
                datasets: [{
                    data            : [tmpPublDngrDtct          , publDngrDtctModIdx],
                    backgroundColor : [colorOra                 , colorWhi],
                    borderColor     : [colorOra                 , colorWhi],
                    borderWidth     : 5
                }]
            };
            let dataPrntSafeDtct = {
                labels              : ['USAGE','NUSAGE'],
                datasets: [{
                    data            : [tmpPrntSafeDtct          , prntSafeDtctModIdx],
                    backgroundColor : [colorGre                 , colorWhi],
                    borderColor     : [colorGre                 , colorWhi],
                    borderWidth     : 5
                }]
            };
            let dataPrntDngrDtct = {
                labels              : ['USAGE','NUSAGE'],
                datasets: [{
                    data            : [tmpPrntDngrDtct          , prntDngrDtctModIdx],
                    backgroundColor : [colorOra                 , colorWhi],
                    borderColor     : [colorOra                 , colorWhi],
                    borderWidth     : 5
                }]
            };
            // 막대차트 미구현, 누적막대 의미 확인 필요
            let dataCareBmiBodyIdx = {
                labels              : ['최저','최대'],
                datasets: [{
                    data            : [$this.totMonStat.careBmiBodyIdxMin   , $this.totMonStat.careBmiBodyIdxMax],
                    backgroundColor : [colorOra                             , colorWhi],
                    borderColor     : [colorOra                             , colorWhi],
                    borderWidth     : 0
                }]
            };
            let dataCareGrowIdx = {
                labels              : ['과성장','저성장'],
                datasets: [{
                    data            : [$this.totMonStat.careGrowOverRt      , $this.totMonStat.careGrowLowRt],
                    backgroundColor : [colorGre                             , colorWhi],
                    borderColor     : [colorGre                             , colorWhi],
                    borderWidth     : 10
                }]
            };
            let dataCareFatIdx = {
                labels              : ['고도비만','비만','저체중'],
                datasets: [{
                    data            : [$this.totMonStat.careFatIdxHighRt    , $this.totMonStat.careFatIdxGnrlRt     , $this.totMonStat.careFatIdxUndrRt],
                    backgroundColor : [colorBlu                             , colorOra                              , colorGra],
                    borderColor     : [colorBlu                             , colorOra                              , colorGra],
                    borderWidth     : 22
                }]
            };
            let dataCareFatPrdt = {
                labels              : ['고도비만','비만','저체중'],
                datasets: [{
                    data            : [$this.totMonStat.careFatPrdtHighRt   , $this.totMonStat.careFatPrdtGnrlRt    , $this.totMonStat.careFatPrdtUndrRt],
                    backgroundColor : [colorBlu                             , colorOra                              , colorGra],
                    borderColor     : [colorBlu                             , colorOra                              , colorGra],
                    borderWidth     : 22
                }]
            };
            let dataCareStrs = {
                labels              : ['높음','매우높음'],
                datasets: [{
                    data            : [$this.totMonStat.careStrsHigh        , $this.totMonStat.careStrsVeryHigh],
                    backgroundColor : [colorGre                             , colorWhi],
                    borderColor     : [colorGre                             , colorWhi],
                    borderWidth     : 10
                }]
            };
            let dataCareExcsTime = {
                labels              : ['평균','전일'],
                datasets: [{
                    data            : [$this.totMonStat.careExcsTimeAvg     , $this.totMonStat.careExcsTimeBfDay],
                    backgroundColor : [colorYel                             , colorBlu],
                    borderColor     : [colorYel                             , colorBlu],
                    borderWidth     : 0
                }]
            };
            let dataCareCalEat = {
                labels              : ['평균','전일'],
                datasets: [{
                    data            : [$this.totMonStat.careCalEatAvg       , $this.totMonStat.careCalEatbfDay],
                    backgroundColor : [colorYel                             , colorOra],
                    borderColor     : [colorYel                             , colorOra],
                    borderWidth     : 0
                }]
            };
            let dataCareFmenuTop = {
                labels              : ['밥','빵','튀김'],
                datasets: [{
                    data            : [$this.totMonStat.careFmenuRtTop1     , $this.totMonStat.careFmenuRtTop2      , $this.totMonStat.careFmenuRtTop3],
                    backgroundColor : [colorBlu                             , colorOra                              , colorGra],
                    borderColor     : [colorBlu                             , colorOra                              , colorGra],
                    borderWidth     : 22
                }]
            };
            let dataCareMmelNeatFmenut = {
                labels              : ['결식','대상'],
                datasets: [{
                    data            : [$this.totMonStat.careMmelNeatFmenuCnt, $this.totMonStat.careMmelNeatFmenuObj],
                    backgroundColor : [colorGre                             , colorWhi],
                    borderColor     : [colorGre                             , colorWhi],
                    borderWidth     : 10
                }]
            };
            let dataCareMmelNeatQust = {
                labels              : ['결식','대상'],
                datasets: [{
                    data            : [$this.totMonStat.careMmelNeatQustCnt , $this.totMonStat.careMmelNeatQustObj],
                    backgroundColor : [colorGre                             , colorWhi],
                    borderColor     : [colorGre                             , colorWhi],
                    borderWidth     : 10
                }]
            };

            let pluginsOperStat = [{
                beforeDraw: function () {
                    let srcIdx = '-';
                    if(operCntQuotiIdx != null ) srcIdx = operCntQuotiIdx;
                    $this.textCenter('operStatChart', srcIdx, $this.chartOperStat, colorBlu, '' , '');
                }
            }];
            let pluginsGrowFat = [{
                beforeDraw: function () {
                    let srcIdx = '-';
                    if(tmpGrowFatIdx != null ) srcIdx = tmpGrowFatIdx;
                    $this.textCenter('growFatChart', srcIdx, $this.chartGrowFat, colorBlu, '' , '');
                }
            }];
            let pluginsFatPrdt = [{
                beforeDraw: function () {
                    let srcIdx = '-';
                    if(tmpFatPrdtIdx != null ) srcIdx = tmpFatPrdtIdx;
                    $this.textCenter('fatPrdtChart', srcIdx, $this.chartFatPrdt, colorBlu, '' , '');
                }
            }];
            let pluginsStrs = [{
                beforeDraw: function () {
                    let srcIdx = '-';
                    if(tmpStrsIdx != null ) srcIdx = tmpStrsIdx;
                    $this.textCenter('strsChart', srcIdx, $this.chartStrs, colorBlu, '' , '');
                }
            }];
            let pluginsPublSafeDtct = [{
                beforeDraw: function () {
                    let srcIdx = '-';
                    if(tmpPublSafeDtct != null ) srcIdx = tmpPublSafeDtct;
                    $this.textCenter('publSafeDtctChart', srcIdx, $this.chartPublSafeDtct, colorBlu, '' , '');
                }
            }];
            let pluginsPublDngrDtct = [{
                beforeDraw: function () {
                    let srcIdx = '-';
                    if(tmpPublDngrDtct != null ) srcIdx = tmpPublDngrDtct;
                    $this.textCenter('publDngrDtctChart', srcIdx, $this.chartPublDngrDtct, colorOra, '' , '');
                }
            }];
            let pluginsPrntSafeDtct = [{
                beforeDraw: function () {
                    let srcIdx = '-';
                    if(tmpPrntSafeDtct != null ) srcIdx = tmpPrntSafeDtct;
                    $this.textCenter('prntSafeDtctChart', srcIdx, $this.chartPrntSafeDtct, colorBlu, '' , '');
                }
            }];
            let pluginsPrntDngrDtct = [{
                beforeDraw: function () {
                    let srcIdx = '-';
                    if(tmpPrntDngrDtct != null ) srcIdx = tmpPrntDngrDtct;
                    $this.textCenter('prntDngrDtctChart', srcIdx, $this.chartPrntDngrDtct, colorOra, '' , '');
                }
            }];
            // 의미 확인 후 centerText 수정 필요
            let pluginsCareGrowIdx = [{
                beforeDraw: function () {
                    let srcIdx = '-';
                    if(tmpStrsIdx != null ) srcIdx = tmpStrsIdx;
                    $this.textCenter('careGrowIdxChart', srcIdx, $this.chartCareGrowIdx, colorBlu, '' , '');
                }
            }];
            // 의미 확인 후 centerText 수정 필요
            let pluginsCareFatIdx = [{
                beforeDraw: function () {
                    let srcIdx = '-';
                    if(tmpStrsIdx != null ) srcIdx = tmpStrsIdx;
                    $this.textCenter('careFatIdxChart', srcIdx, $this.chartCareFatIdx, colorBlu, '' , '');
                }
            }];
            // 의미 확인 후 centerText 수정 필요
            let pluginsCareFatPrdt = [{
                beforeDraw: function () {
                    let srcIdx = '-';
                    if(tmpStrsIdx != null ) srcIdx = tmpStrsIdx;
                    $this.textCenter('careFatPrdtChart', srcIdx, $this.chartCareFatPrdt, colorBlu, '' , '');
                }
            }];
            // 의미 확인 후 centerText 수정 필요
            let pluginsCareStrs = [{
                beforeDraw: function () {
                    let srcIdx = '-';
                    if(tmpStrsIdx != null ) srcIdx = tmpStrsIdx;
                    $this.textCenter('careStrsChart', srcIdx, $this.chartCareStrs, colorBlu, '' , '');
                }
            }];
            let pluginsCareMmelNeatFmenu = [{
                beforeDraw: function () {
                    let srcIdx = '-';
                    if($this.careMmelNeatFmenuRt != null ) srcIdx = $this.careMmelNeatFmenuRt;
                    $this.textCenter('careMmelNeatFmenuChart', srcIdx, $this.chartCareMmelNeatFmenu, colorBlu, '' , '');
                }
            }];
            let pluginsCareMmelNeatQust = [{
                beforeDraw: function () {
                    let srcIdx = '-';
                    if($this.careMmelNeatQustRt != null ) srcIdx = $this.careMmelNeatQustRt;
                    $this.textCenter('careMmelNeatQustChart', srcIdx, $this.chartCareMmelNeatQust, colorBlu, '' , '');
                }
            }];
            // jcw : 신기하네.. 왜 updateChart에서 호출할땐 오브젝트고.. 여기서 넘겨서 할땐 널일까..
            // let pluginsOperStat = $this.chartPluginsCenter('operStatChart'  , $this.totMonStat.growIdx  , $this.chartOperStat   , operStatChartColor, '' , '');
            // let pluginsGrowFat  = $this.chartPluginsCenter('growFatChart'   , tmpGrowFatIdx             , $this.chartGrowFat    , colorBlu          , '' , '');

            let configOperStat = {
                type    : 'doughnut',
                data    : dataOperStat,
                options : $this.options,
                plugins : pluginsOperStat
            };
            let configOpenStat = {
                type    : 'doughnut',
                data    : dataOpenStat,
                options : $this.options
            };
            let configGrowFat = {
                type    : 'doughnut',
                data    : dataGrowFat,
                options : $this.options,
                plugins : pluginsGrowFat
            };
            let configFatPrdt = {
                type    : 'doughnut',
                data    : dataFatPrdt,
                options : $this.options,
                plugins : pluginsFatPrdt
            };
            let configStrs = {
                type    : 'doughnut',
                data    : dataStrs,
                options : $this.options,
                plugins : pluginsStrs
            };
            let configDngrSafeOccr = {
                type    : 'bar',
                data    : dataDngrSafeOccr,
                options : $this.optionsBarVert,
                plugins : [{}]
            };
            let configDngrZoneProg = {
                type    : 'bar',
                data    : dataDngrZoneProg,
                options : $this.optionsBarVert,
                plugins : [{}]
            };
            let configPublSafeDtct = {
                type    : 'doughnut',
                data    : dataPublSafeDtct,
                options : $this.options,
                plugins : pluginsPublSafeDtct
            };
            let configPublDngrDtct = {
                type    : 'doughnut',
                data    : dataPublDngrDtct,
                options : $this.options,
                plugins : pluginsPublDngrDtct
            };
            let configPrntSafeDtct = {
                type    : 'doughnut',
                data    : dataPrntSafeDtct,
                options : $this.options,
                plugins : pluginsPrntSafeDtct
            };
            let configPrntDngrDtct = {
                type    : 'doughnut',
                data    : dataPrntDngrDtct,
                options : $this.options,
                plugins : pluginsPrntDngrDtct
            };
            let configCareBmiBodyIdx = {
                type    : 'bar',
                data    : dataCareBmiBodyIdx,
                options : $this.optionsBarVert,
                plugins : [{}]
            };
            let configCareGrowIdx = {
                type    : 'doughnut',
                data    : dataCareGrowIdx,
                options : $this.options,
                plugins : pluginsCareGrowIdx
            };
            let configCareFatIdx = {
                type    : 'doughnut',
                data    : dataCareFatIdx,
                options : $this.options,
                plugins : pluginsCareFatIdx
            };
            let configCareFatPrdt = {
                type    : 'doughnut',
                data    : dataCareFatPrdt,
                options : $this.options,
                plugins : pluginsCareFatPrdt
            };
            let configCareStrs = {
                type    : 'doughnut',
                data    : dataCareStrs,
                options : $this.options,
                plugins : pluginsCareStrs
            };
            let configCareExcsTime = {
                type    : 'bar',
                data    : dataCareExcsTime,
                options : $this.optionsBarVert,
                plugins : [{}]
            };
            let configCareCalEat = {
                type    : 'bar',
                data    : dataCareCalEat,
                options : $this.optionsBarVert,
                plugins : [{}]
            };
            let configCareFmenuTop = {
                type    : 'doughnut',
                data    : dataCareFmenuTop,
                options : $this.options,
                plugins : [{}]
            };
            let configCareMmelNeatFmenu = {
                type    : 'doughnut',
                data    : dataCareMmelNeatFmenut,
                options : $this.options,
                plugins : pluginsCareMmelNeatFmenu
            };
            let configCareMmelNeatQust = {
                type    : 'doughnut',
                data    : dataCareMmelNeatQust,
                options : $this.options,
                plugins : pluginsCareMmelNeatQust
            };

            let ctxOperStat             = document.getElementById('operStatChart').getContext('2d');
            let ctxOpenStat             = document.getElementById('openStatChart').getContext('2d');
            let ctxGrowFat              = document.getElementById('growFatChart').getContext('2d');
            let ctxFatPrdt              = document.getElementById('fatPrdtChart').getContext('2d');
            let ctxStrs                 = document.getElementById('strsChart').getContext('2d');
            let ctxDngrSafeOccr         = document.getElementById('dngrSafeOccrChart').getContext('2d');
            let ctxDngrZoneProg         = document.getElementById('dngrZoneProgChart').getContext('2d');
            let ctxPublSafeDtct         = document.getElementById('publSafeDtctChart').getContext('2d');
            let ctxPublDngrDtct         = document.getElementById('publDngrDtctChart').getContext('2d');
            let ctxPrntSafeDtct         = document.getElementById('prntSafeDtctChart').getContext('2d');
            let ctxPrntDngrDtct         = document.getElementById('prntDngrDtctChart').getContext('2d');

            let ctxCareBmiBodyIdx       = document.getElementById('careBmiBodyIdxChart').getContext('2d');
            let ctxCareGrowIdx          = document.getElementById('careGrowIdxChart').getContext('2d');
            let ctxCareFatIdx           = document.getElementById('careFatIdxChart').getContext('2d');
            let ctxCareFatPrdt          = document.getElementById('careFatPrdtChart').getContext('2d');
            let ctxCareStrs             = document.getElementById('careStrsChart').getContext('2d');
            let ctxCareExcsTime         = document.getElementById('careExcsTimeChart').getContext('2d');
            let ctxCareCalEat           = document.getElementById('careCalEatChart').getContext('2d');
            let ctxCareFmenuTop         = document.getElementById('careFmenuTopChart').getContext('2d');
            let ctxCareMmelNeatFmenu    = document.getElementById('careMmelNeatFmenuChart').getContext('2d');
            let ctxCareMmelNeatQust     = document.getElementById('careMmelNeatQustChart').getContext('2d');

            $this.initChart();

            $this.chartOperStat         = new Chart(ctxOperStat     , configOperStat);
            $this.chartOpenStat         = new Chart(ctxOpenStat     , configOpenStat);
            $this.chartGrowFat          = new Chart(ctxGrowFat      , configGrowFat);
            $this.chartFatPrdt          = new Chart(ctxFatPrdt      , configFatPrdt);
            $this.chartStrs             = new Chart(ctxStrs         , configStrs);
            $this.chartDngrSafeOccr     = new Chart(ctxDngrSafeOccr , configDngrSafeOccr);
            $this.chartDngrZoneProg     = new Chart(ctxDngrZoneProg , configDngrZoneProg);
            $this.chartPublSafeDtct     = new Chart(ctxPublSafeDtct , configPublSafeDtct);
            $this.chartPublDngrDtct     = new Chart(ctxPublDngrDtct , configPublDngrDtct);
            $this.chartPrntSafeDtct     = new Chart(ctxPrntSafeDtct , configPrntSafeDtct);
            $this.chartPrntDngrDtct     = new Chart(ctxPrntDngrDtct , configPrntDngrDtct);

            $this.chartCareBmiBodyIdx   = new Chart(ctxCareBmiBodyIdx   , configCareBmiBodyIdx);
            $this.chartCareGrowIdx      = new Chart(ctxCareGrowIdx      , configCareGrowIdx);
            $this.chartCareFatIdx       = new Chart(ctxCareFatIdx       , configCareFatIdx);
            $this.chartCareFatPrdt      = new Chart(ctxCareFatPrdt      , configCareFatPrdt);
            $this.chartCareStrs         = new Chart(ctxCareStrs         , configCareStrs);
            $this.chartCareExcsTime     = new Chart(ctxCareExcsTime     , configCareExcsTime);
            $this.chartCareCalEat       = new Chart(ctxCareCalEat       , configCareCalEat);
            $this.chartCareFmenuTop     = new Chart(ctxCareFmenuTop     , configCareFmenuTop);
            $this.chartCareMmelNeatFmenu= new Chart(ctxCareMmelNeatFmenu, configCareMmelNeatFmenu);
            $this.chartCareMmelNeatQust = new Chart(ctxCareMmelNeatQust , configCareMmelNeatQust);

            $this.totMonStat.tmpDngrZoneCnt         = $this.toNumber($this.totMonStat.tmpDngrZoneCnt);
            $this.totMonStat.tmpFallDownCnt         = $this.toNumber($this.totMonStat.tmpFallDownCnt);
            $this.totMonStat.tmpHbitAbnmCnt         = $this.toNumber($this.totMonStat.tmpHbitAbnmCnt);
            $this.totMonStat.tmpTmepAbnmCnt         = $this.toNumber($this.totMonStat.tmpTmepAbnmCnt);
            $this.totMonStat.careCalEatAvg          = $this.toNumber($this.totMonStat.careCalEatAvg);
            $this.totMonStat.careCalEatbfDay        = $this.toNumber($this.totMonStat.careCalEatbfDay);
            $this.totMonStat.careMmelNeatFmenuCnt   = $this.toNumber($this.totMonStat.careMmelNeatFmenuCnt);
            $this.totMonStat.careMmelNeatFmenuObj   = $this.toNumber($this.totMonStat.careMmelNeatFmenuObj);
            $this.totMonStat.careMmelNeatQustCnt    = $this.toNumber($this.totMonStat.careMmelNeatQustCnt);
            $this.totMonStat.careMmelNeatQustObj    = $this.toNumber($this.totMonStat.careMmelNeatQustObj);
            $this.totMonStat.tmpTotal               = $this.toNumber($this.totMonStat.tmpTotal);
            $this.totMonStat.tmpUsage               = $this.toNumber($this.totMonStat.tmpUsage);
            $this.totMonStat.tmpNumber1             = $this.toNumber($this.totMonStat.tmpNumber1);
            $this.totMonStat.tmpNumber2             = $this.toNumber($this.totMonStat.tmpNumber2);
            $this.totMonStat.tmpNumber3             = $this.toNumber($this.totMonStat.tmpNumber3);
            $this.totMonStat.tmpNumber4             = $this.toNumber($this.totMonStat.tmpNumber4);
            $this.totMonStat.tmpNumber5             = $this.toNumber($this.totMonStat.tmpNumber5);
            $this.totMonStat.tmpNumber6             = $this.toNumber($this.totMonStat.tmpNumber6);

            // $this.chartStrs = new Chart(ctxStrs, configStrs);

            // const operStatCntn = document.getElementById('operStatCntn');
            // operStatCntn.innerHTML = $this.stdtInfo.smryCntn;

        },
        // jcw : 신기하네.. 왜 updateChart에서 호출할땐 오브젝트고.. 여기서 넘겨서 할땐 널일까..
        // chartPluginsCenter: function(chartDivId, srcIdx, chartId, centerColor, fontSize, fontStyle) {
        //     let $this = this;
        //
        //     alert("jcw chartCenter asasa :: " + chartId);
        //
        //     return [{
        //         beforeDraw: function () {
        //             let centerTxt = '-';
        //             if(srcIdx != null ) centerTxt = srcIdx;
        //             $this.textCenter(chartDivId, centerTxt, chartId, centerColor, fontSize , fontStyle);
        //         }
        //     }];
        // },
        chartPerModIdx: function(srcIdx, perIdx) {
            if (WebUtil.isNull(perIdx)) {
                perIdx = 100;
            }
            let modIdx;

            if      (srcIdx > 100 ) modIdx = 0;
            else if (srcIdx < 0   ) modIdx = 100;
            else    modIdx  = perIdx - srcIdx;

            return modIdx;
        },
        chartPerQuoti: function(numerator, denominator) {
            // 분모 혹은 제수 : null 또는 0 일 경우 임의로 1로 강제 세팅
            if (WebUtil.isNull(denominator) || denominator === 0) {
                denominator = 1;
            }
            let quoti;
            quoti  = Math.round((numerator / denominator * 100) * 10) / 10;
            return quoti;
        },
        toNumber: function (value) {
            return value.toLocaleString('ko-KR');
        },
        initData: function () {
            let $this = this;

            $this.totMonStat = {
                openCnt             : '',
                operCnt             : '',
                noRsps              : '',

                temp                : null,
                tmpDngrSafeOcrrTd   : $this.tmpDngrSafeOcrrTd,
                tmpDngrSafeOcrrDif  : $this.tmpDngrSafeOcrrDif,
                tmpDngrSafeOcrrYav  : 3.8,

                tmpDngrZoneCnt      : 4400,
                tmpFallDownCnt      : 2400,
                tmpHbitAbnmCnt      : 1200,
                tmpTmepAbnmCnt      : 3300,
                tmpTotal            : 200000,
                tmpUsage            : 140000,
                tmpNumber1          : 200000,
                tmpNumber2          : 180000,
                tmpNumber3          : 20000,
                tmpNumber4          : 500000,
                tmpNumber5          : 300000,
                tmpNumber6          : 200000,

                plcCdPublTop1       : '유흥/유해',
                plcCdPublTop2       : '공사/위험물',
                plcCdPublTop3       : '우범지역',
                addrPublTop1        : '서울특별시 마포구 마포대로12 한신빌딩 911',
                addrPublTop2        : '서울특별시 금천구 디지털로9길 99 스타밸리빌',
                addrPublTop3        : '서울시 금천구 가산동 1234-17 우리벤처타워',
                cntPublTop1         : 123,
                cntPublTop2         : 78,
                cntPublTop3         : 50,
                plcCdPrntTop1       : '우범지역',
                plcCdPrntTop2       : '유흥/유해',
                plcCdPrntTop3       : '공사/위험물',
                addrPrntTop1        : '서울특별시 송파구 송파대로8길 17',
                addrPrntTop2        : '제주특별자치도 제주시 첨단로 242',
                addrPrntTop3        : '서울특별시 용산구 국방부',
                cntPrntTop1         : 123,
                cntPrntTop2         : 78,
                cntPrntTop3         : 999,

                careBmiBodyIdxAvg       : 27.56,
                careBmiBodyIdxMin       : 17.12,
                careBmiBodyIdxMax       : 42.78,

                careGrowLowRt           : 20,
                careGrowOverRt          : 27,

                careFatIdxHighRt        : 10,
                careFatIdxGnrlRt        : 20,
                careFatIdxUndrRt        : 10,

                careFatPrdtHighRt       : 10,
                careFatPrdtGnrlRt       : 20,
                careFatPrdtUndrRt       : 10,

                careStrsHigh            : 20,
                careStrsVeryHigh        : 10,

                careExcsTimeAvg         : 1.2,
                careExcsTimeBfDay       : 1.5,
                careExcsTimeDif         : 0.3,

                careCalEatAvg           : 2113,
                careCalEatbfDay         : 2238,
                careCalEatDif           : 125,

                careFmenuCdTop1         : '밥',
                careFmenuRtTop1         : 33.1,
                careFmenuCdTop2         : '빵',
                careFmenuRtTop2         : 27.5,
                careFmenuCdTop3         : '튀김',
                careFmenuRtTop3         : 12.9,

                careMmelNeatFmenuCnt    : 1853,
                careMmelNeatFmenuObj    : 20000,
                careMmelNeatFmenuRt     : 9.2,

                careMmelNeatQustCnt     : 1853,
                careMmelNeatQustObj     : 20000,
                careMmelNeatQustRt      : 9.2
            }
        },
        clock: function() {
            let $this = this;
            let date = moment().lang("ko");

            $this.clockParam.hhmmss = date.format(timeFormatPattern);
            $this.clockParam.yyyymmdd = date.format(dateFormatPattern);
            $this.clockParam.ddd = date.format("(ddd)");
            $this.clockParam.amPm = date.format("a");
        },
        initCycl: function(timeCycl) {
            let $this = this;
            if (timeCycl === null) timeCycl = 5000;
            $this.cycl.timeCycl = timeCycl;

            clearInterval($this.cycl.initCycl);
            $this.cycl.initCycl = setInterval($this.searchStdtDetlInfo, timeCycl);
        },
        numCountAnimate: function () {
            let $this = this;
            var memberCountConTxt= $this.totMonStat.tmpTmepAbnmCnt;

            $({ val : 0 }).animate({ val : memberCountConTxt }, {
                duration: 1000,
                step: function() {
                    var num = numberWithCommas(Math.floor(this.val));
                    //$(".memberCountCon").text(num);
                    $this.totMonStat.tmpTmepAbnmCnt = num;
                },
                complete: function() {
                    var num = numberWithCommas(Math.floor(this.val));
                    //$(".memberCountCon").text(num);
                    $this.totMonStat.tmpTmepAbnmCnt = num;
                }
            });

            function numberWithCommas(x) {
                return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
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
