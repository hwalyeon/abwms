let totMonStat = new Vue({
    el: "#totMonStat",
    data: {
        menuList : [],
        searchAuthParam : {
            searchClass : '01',
            empNo : 0
        },
        //위험안전발생
        dgsfOccr : {
            mnthDngrAvg : 0,
            tdayNorm    : 0,
            tdayChk     : 0,
            tdayWarn    : 0,
            tdayPdngr   : 0,
            tdayDngr    : 0,
            tdayDngrSum : 0,
            difCnt      : 0,
            persAvg     : 0
        },
        //위험지역_추이
        dzonTrnd : {
            bday1       : 0,
            week1Ago    : 0,
            week2Ago    : 0,
            week3Ago    : 0,
            week4Ago    : 0,
            lowHighDif  : 0,
            trnd        : ''
        },
        //안전위험지역_탐지율
        dgsfDtct : {
            gorgDzon    : 0,
            gorgSzon    : 0,
            guarDzon    : 0,
            guarSzon    : 0
        },
        //위험감정_카운트
        dgemCnt : {
            dgemTotl : 0,
            dgemDzon : 0,
            dgemFall : 0,
            dgemHbit : 0,
            dgemTemp : 0
        },
        //위험지역_TOP3_공공
        gorgDtop3 : {
            gorgDtop3PlcNm1  : '',
            gorgDtop3Addr1   : '',
            gorgDtop3Cnt1    : 0,
            gorgDtop3PlcNm2  : '',
            gorgDtop3Addr2   : '',
            gorgDtop3Cnt2    : 0,
            gorgDtop3PlcNm3  : '',
            gorgDtop3Addr3   : '',
            gorgDtop3Cnt3    : 0
        },
        //보호자_지정_위험지역_TOP3
        guarDtop3 : {
            guarDtop3Addr1   : '',
            guarDtop3Cnt1    : 0,
            guarDtop3Addr2   : '',
            guarDtop3Cnt2    : 0,
            guarDtop3Addr3   : '',
            guarDtop3Cnt3    : 0
        },
        //위험감정_이력
        dgemHist : [{
            dgemDt : '',
            dgemTm : '',
            dgemHistStatCd : '',
            dgemHistStatNm : ''
        }],


        ////////////////////// 임시 //////////////////////
        totMonStat: {
            openCnt             : 0,
            operCnt             : 0,
            noRsps              : 0,

            temp                : null,
            // tmpDngrSafeOcrrTd   : 0,
            // tmpDngrSafeOcrrDif  : 0,
            // tmpDngrSafeOcrrYav  : 5.8,

            tmpTotal            : 200000,
            tmpUsage            : 140000,
            tmpNumber1          : 200000,
            tmpNumber2          : 180000,
            tmpNumber3          : 20000,
            tmpNumber4          : 500000,
            tmpNumber5          : 300000,
            tmpNumber6          : 200000,
            tmpNumber7          : 200000,
            tmpNumber8          : 14000,
            tmpNumber9          : 10000,
            tmpNumber10         : 13000,
            tmpNumber11         : 30,

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

            careMmelNeatFmenuCnt    : 11853,
            careMmelNeatFmenuObj    : 20000,

            careMmelNeatQustCnt     : 11853,
            careMmelNeatQustObj     : 20000,

        },
        totCnt: {
            tmpDngrZoneCnt      : 4400,
            tmpFallDownCnt      : 2400,
            tmpHbitAbnmCnt      : 1200,
            tmpTmepAbnmCnt      : 3300,
            tmpTotalCnt         : 20000
        },
        clockParam: {
            hhmmss                  : '',
            yyyymmdd                : '',
            ddd                     : '',
            amPm                    : ''
        },
        cycl: {
            initCycl                : null,
            timeCycl                : 5000
        },
        cyclButton: {
            button1                : true,
            button2                : false,
            button3                : false
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
        chartDgsfOccr   : null,
        chartDzonTrnd   : null,
        chartGorgSafeDtct   : null,
        chartGorgDngrDtct   : null,
        chartGuarSafeDtct   : null,
        chartGuarDngrDtct   : null,

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

            $this.searchAuthParam.userId = SessionUtil.getUserId();
            $this.searchAuthParam.userNm = SessionUtil.getUserNm();
            $this.getMenuList();
            $this.initCodeList();
            $this.initPage();

            $this.clock();
            setInterval($this.clock, 1000);
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
            if ($this.chartDgsfOccr     != null )   $this.chartDgsfOccr.destroy();
            if ($this.chartDzonTrnd     != null )   $this.chartDzonTrnd.destroy();
            if ($this.chartGorgSafeDtct != null )   $this.chartGorgSafeDtct.destroy();
            if ($this.chartGorgDngrDtct != null )   $this.chartGorgDngrDtct.destroy();
            if ($this.chartGuarSafeDtct != null )   $this.chartGuarSafeDtct.destroy();
            if ($this.chartGuarDngrDtct != null )   $this.chartGuarDngrDtct.destroy();

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

                AjaxUtil.post({
                    url: "/oper/cmon/totMonStat/searchDgsfOccr.ab",
                    param: params,
                    success: function(response) {

                        // 위험안전발생
                        if ( !!response["rtnData"]["result1"] ) {
                            $.each(response["rtnData"]["result1"], function(key, val) {
                                $this.dgsfOccr[key] = val;
                            });
                        }
                        // 위험지역_추이
                        if ( !!response["rtnData"]["result2"] ) {
                            $.each(response["rtnData"]["result2"], function(key, val) {
                                $this.dzonTrnd[key] = val;
                            });
                        }
                        // 안전위험지역_탐지율
                        if ( !!response["rtnData"]["result3"] ) {
                            $.each(response["rtnData"]["result3"], function(key, val) {
                                $this.dgsfDtct[key] = val;
                            });
                        }
                        // 위험감정_카운트
                        if ( !!response["rtnData"]["result4"] ) {
                            $.each(response["rtnData"]["result4"], function(key, val) {
                                $this.dgemCnt[key] = val;
                            });
                        }
                        // 위험지역_TOP3_공공
                        if ( !!response["rtnData"]["result5"] ) {
                            $.each(response["rtnData"]["result5"], function(key, val) {
                                $this.gorgDtop3[key] = val;
                            });
                        }
                        // 보호자_지정_위험지역_TOP3
                        if ( !!response["rtnData"]["result6"] ) {
                            $.each(response["rtnData"]["result6"], function(key, val) {
                                $this.guarDtop3[key] = val;
                            });
                        }
                        // 위험감정_이력
                        if ( !!response["rtnData"]["result7"] ) {
                            $.each(response["rtnData"]["result7"], function(index, item) {
                                $this.dgemHist.push({
                                    dgemDt              :item.dgemDt,
                                    dgemTm              :item.dgemTm,
                                    dgemHistStatCd      :item.dgemHistStatCd,
                                    dgemHistStatNm      :item.dgemHistStatNm
                                });
                            });
                        }

                        console.log("jcw rtnData :: ", response["rtnData"].result6);
                        console.log("jcw $this.guarDtop3 :: ", $this.guarDtop3);
                        $this.updateChart();
                        $this.initCycl($this.cycl.timeCycl);
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

            let colorRed = '#ff0b21';
            let colorGre = '#09ea09';
            let colorBlu = '#2a99ec';
            let colorYel = '#f3e24a';
            let colorOra = '#fc8f46';
            let colorGra = '#4d4d4d';
            let colorLggre = '#c0dc5c';
            let colorBla = '#000000';
            let colorWhi = '#ffffff';

            // 헬스케어 활용율 Data
            let tmpGrowFatIdx       = 80;
            let tmpFatPrdtIdx       = 70;
            let tmpStrsIdx          = 65;

            // 위험안전 발생 Data
            // let tmpDngrSafeOcrrTd   = 2170;
            // let tmpDngrSafeOcrrAv   = 2600;

            // 위험지역 추이 Data
            // let $this.dzonTrnd.week4Ago  = 1400;
            // let $this.dzonTrnd.week3Ago  = 1000;
            // let $this.dzonTrnd.week2Ago  = 1100;
            // let $this.dzonTrnd.week1Ago  = 1200;
            // let $this.dzonTrnd.bday1= 1300;

            // 공공 안전/위험지역 활용(탐지) Data
            // let $this.dgsfDtct.gorgSzon   = 83.1;
            // let $this.dgsfDtct.gorgDzon   = 33.1;

            // 학부모 안전/위험지역 활용(탐지) Data
            // let $this.dgsfDtct.guarSzon   = 89.5;
            // let $this.dgsfDtct.guarDzon   = 35.6;

            // $this.totMonStat.tmpDngrSafeOcrrTd = tmpDngrSafeOcrrTd;
            // $this.totMonStat.tmpDngrSafeOcrrDif = tmpDngrSafeOcrrTd - tmpDngrSafeOcrrAv;

            // 백분율 몫 구하기
            let operCntQuotiIdx     = $this.chartPerQuoti($this.totMonStat.operCnt, $this.totMonStat.openCnt);
            let NeatFmenuQuotiIdx   = $this.chartPerQuoti($this.totMonStat.careMmelNeatFmenuCnt, $this.totMonStat.careMmelNeatFmenuObj);
            let NeatQustQuotiIdx    = $this.chartPerQuoti($this.totMonStat.careMmelNeatQustCnt, $this.totMonStat.careMmelNeatQustObj);

            // 나머지 구하기
            let operCntModIdx       = $this.chartPerModIdx(operCntQuotiIdx);
            let growFatModIdx       = $this.chartPerModIdx(tmpGrowFatIdx);
            let fatPrdtModIdx       = $this.chartPerModIdx(tmpFatPrdtIdx);
            let strsModIdx          = $this.chartPerModIdx(tmpStrsIdx);
            let dgsfDtctGorgSzonMod = $this.chartPerModIdx($this.dgsfDtct.gorgSzon);
            let dgsfDtctGorgDzonMod = $this.chartPerModIdx($this.dgsfDtct.gorgDzon);
            let dgsfDtctGuarSzonMod = $this.chartPerModIdx($this.dgsfDtct.guarSzon);
            let dgsfDtctGuarDzonMod = $this.chartPerModIdx($this.dgsfDtct.guarDzon);
            let NeatFmenuModIdx     = $this.chartPerModIdx(NeatFmenuQuotiIdx);
            let NeatQustModIdx      = $this.chartPerModIdx(NeatQustQuotiIdx);

            let dataOperStat = {
                labels              : ['가동','무응답'],
                datasets: [{
                    data            : [operCntQuotiIdx          , operCntModIdx],
                    backgroundColor : [colorBlu                 , colorBla],
                    borderColor     : [colorBlu                 , colorBla],
                    borderWidth     : 10
                }]
            };
            let dataOpenStat = {
                labels              : ['개통','제출','가입'],
                datasets: [{
                    data            : [50       , 30        , 20        ],
                    backgroundColor : [colorBlu , colorOra  , colorLggre  ],
                    borderColor     : [colorBlu , colorOra  , colorLggre  ],
                    borderWidth     : 22
                }]
            };
            let dataGrowFat = {
                labels              : ['USAGE','NUSAGE'],
                datasets: [{
                    data            : [tmpGrowFatIdx            , growFatModIdx],
                    backgroundColor : [colorBlu                 , colorBla],
                    borderColor     : [colorBlu                 , colorBla],
                    borderWidth     : 10
                }]
            };
            let dataFatPrdt = {
                labels              : ['USAGE','NUSAGE'],
                datasets: [{
                    data            : [tmpFatPrdtIdx            , fatPrdtModIdx],
                    backgroundColor : [colorBlu                 , colorBla],
                    borderColor     : [colorBlu                 , colorBla],
                    borderWidth     : 10
                }]
            };
            let dataStrs = {
                labels              : ['USAGE','NUSAGE'],
                datasets: [{
                    data            : [tmpStrsIdx               , strsModIdx],
                    backgroundColor : [colorBlu                 , colorBla],
                    borderColor     : [colorBlu                 , colorBla],
                    borderWidth     : 10
                }]
            };
            let dataDgsfOccr = {
                labels              : ['평균','오늘'],
                datasets: [{
                    data            : [$this.dgsfOccr.mnthDngrAvg   , $this.dgsfOccr.tdayDngrSum],
                    backgroundColor : [colorYel                     , colorOra],
                    borderColor     : [colorYel                     , colorOra],
                    borderWidth     : 0
                }]
            };
            let dataDzonTrnd = {
                labels              : ['-4주','-3주','-2주','-1주','전일'],
                datasets: [{
                    data            : [$this.dzonTrnd.week4Ago       , $this.dzonTrnd.week3Ago        , $this.dzonTrnd.week2Ago        , $this.dzonTrnd.week1Ago        , $this.dzonTrnd.bday1],
                    backgroundColor : [colorBlu                 , colorBlu                  , colorBlu                  , colorBlu                  , colorBlu],
                    borderColor     : [colorBlu                 , colorBlu                  , colorBlu                  , colorBlu                  , colorBlu],
                    borderWidth     : 0,
                    categoryPercentage: 1.0,
                    barPercentage   : 0.4
                }]
            };
            let dataGorgSafeDtct = {
                labels              : ['USAGE','NUSAGE'],
                datasets: [{
                    data            : [$this.dgsfDtct.gorgSzon  , dgsfDtctGorgSzonMod],
                    backgroundColor : [colorGre                 , colorGra],
                    borderColor     : [colorGre                 , colorGra],
                    borderWidth     : 5
                }]
            };
            let dataGorgDngrDtct = {
                labels              : ['USAGE','NUSAGE'],
                datasets: [{
                    data            : [$this.dgsfDtct.gorgDzon  , dgsfDtctGorgDzonMod],
                    backgroundColor : [colorOra                 , colorGra],
                    borderColor     : [colorOra                 , colorGra],
                    borderWidth     : 5
                }]
            };
            let dataGuarSafeDtct = {
                labels              : ['USAGE','NUSAGE'],
                datasets: [{
                    data            : [$this.dgsfDtct.guarSzon  , dgsfDtctGuarSzonMod],
                    backgroundColor : [colorGre                 , colorGra],
                    borderColor     : [colorGre                 , colorGra],
                    borderWidth     : 5
                }]
            };
            let dataGuarDngrDtct = {
                labels              : ['USAGE','NUSAGE'],
                datasets: [{
                    data            : [$this.dgsfDtct.guarDzon  , dgsfDtctGuarDzonMod],
                    backgroundColor : [colorOra                 , colorGra],
                    borderColor     : [colorOra                 , colorGra],
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
                    data            : [tmpGrowFatIdx      , growFatModIdx],
                    backgroundColor : [colorGre                             , colorGra],
                    borderColor     : [colorGre                             , colorGra],
                    borderWidth     : 10
                }]
            };
            let dataCareFatIdx = {
                labels              : ['고도비만','비만','저체중'],
                datasets: [{
                    data            : [$this.totMonStat.careFatIdxHighRt    , $this.totMonStat.careFatIdxGnrlRt     , $this.totMonStat.careFatIdxUndrRt],
                    backgroundColor : [colorBlu                             , colorOra                              , colorLggre],
                    borderColor     : [colorBlu                             , colorOra                              , colorLggre],
                    borderWidth     : 22
                }]
            };
            let dataCareFatPrdt = {
                labels              : ['고도비만','비만','저체중'],
                datasets: [{
                    data            : [$this.totMonStat.careFatPrdtHighRt   , $this.totMonStat.careFatPrdtGnrlRt    , $this.totMonStat.careFatPrdtUndrRt],
                    backgroundColor : [colorBlu                             , colorOra                              , colorLggre],
                    borderColor     : [colorBlu                             , colorOra                              , colorLggre],
                    borderWidth     : 22
                }]
            };
            let dataCareStrs = {
                labels              : ['높음','매우높음'],
                datasets: [{
                    data            : [tmpStrsIdx        , strsModIdx],
                    backgroundColor : [colorGre                             , colorGra],
                    borderColor     : [colorGre                             , colorGra],
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
                    backgroundColor : [colorBlu                             , colorOra                              , colorLggre],
                    borderColor     : [colorBlu                             , colorOra                              , colorLggre],
                    borderWidth     : 22
                }]
            };
            let dataCareMmelNeatFmenut = {
                labels              : ['결식','대상'],
                datasets: [{
                    data            : [NeatFmenuQuotiIdx                    , NeatFmenuModIdx],
                    backgroundColor : [colorGre                             , colorGra],
                    borderColor     : [colorGre                             , colorGra],
                    borderWidth     : 10
                }]
            };
            let dataCareMmelNeatQust = {
                labels              : ['결식','대상'],
                datasets: [{
                    data            : [NeatQustQuotiIdx                     , NeatQustModIdx],
                    backgroundColor : [colorGre                             , colorGra],
                    borderColor     : [colorGre                             , colorGra],
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
            let pluginsGorgSafeDtct = [{
                beforeDraw: function () {
                    let srcIdx = '-';
                    if($this.dgsfDtct.gorgSzon != null ) srcIdx = $this.dgsfDtct.gorgSzon;
                    $this.textCenter('gorgSafeDtctChart', srcIdx, $this.chartGorgSafeDtct, colorGre, '' , '');
                }
            }];
            let pluginsGorgDngrDtct = [{
                beforeDraw: function () {
                    let srcIdx = '-';
                    if($this.dgsfDtct.gorgDzon != null ) srcIdx = $this.dgsfDtct.gorgDzon;
                    $this.textCenter('gorgDngrDtctChart', srcIdx, $this.chartGorgDngrDtct, colorOra, '' , '');
                }
            }];
            let pluginsGuarSafeDtct = [{
                beforeDraw: function () {
                    let srcIdx = '-';
                    if($this.dgsfDtct.guarSzon != null ) srcIdx = $this.dgsfDtct.guarSzon;
                    $this.textCenter('guarSafeDtctChart', srcIdx, $this.chartGuarSafeDtct, colorGre, '' , '');
                }
            }];
            let pluginsGuarDngrDtct = [{
                beforeDraw: function () {
                    let srcIdx = '-';
                    if($this.dgsfDtct.guarDzon != null ) srcIdx = $this.dgsfDtct.guarDzon;
                    $this.textCenter('guarDngrDtctChart', srcIdx, $this.chartGuarDngrDtct, colorOra, '' , '');
                }
            }];
            // 의미 확인 후 centerText 수정 필요
            let pluginsCareGrowIdx = [{
                beforeDraw: function () {
                    let srcIdx = '-';
                    if(tmpGrowFatIdx != null ) srcIdx = tmpGrowFatIdx;
                    $this.textCenter('careGrowIdxChart', srcIdx, $this.chartCareGrowIdx, colorGre, '' , '');
                }
            }];
            // 의미 확인 후 centerText 수정 필요
            // let pluginsCareFatIdx = [{
            //     beforeDraw: function () {
            //         let srcIdx = '-';
            //         if(tmpStrsIdx != null ) srcIdx = tmpStrsIdx;
            //         $this.textCenter('careFatIdxChart', srcIdx, $this.chartCareFatIdx, colorBlu, '' , '');
            //     }
            // }];
            // // 의미 확인 후 centerText 수정 필요
            // let pluginsCareFatPrdt = [{
            //     beforeDraw: function () {
            //         let srcIdx = '-';
            //         if(tmpStrsIdx != null ) srcIdx = tmpStrsIdx;
            //         $this.textCenter('careFatPrdtChart', srcIdx, $this.chartCareFatPrdt, colorBlu, '' , '');
            //     }
            // }];
            // 의미 확인 후 centerText 수정 필요
            let pluginsCareStrs = [{
                beforeDraw: function () {
                    let srcIdx = '-';
                    if(tmpStrsIdx != null ) srcIdx = tmpStrsIdx;
                    $this.textCenter('careStrsChart', srcIdx, $this.chartCareStrs, colorGre, '' , '');
                }
            }];
            let pluginsCareMmelNeatFmenu = [{
                beforeDraw: function () {
                    let srcIdx = '-';
                    if(NeatFmenuQuotiIdx != null ) srcIdx = NeatFmenuQuotiIdx;
                    $this.textCenter('careMmelNeatFmenuChart', srcIdx, $this.chartCareMmelNeatFmenu, colorGre, '' , '');
                }
            }];
            let pluginsCareMmelNeatQust = [{
                beforeDraw: function () {
                    let srcIdx = '-';
                    if(NeatQustQuotiIdx != null ) srcIdx = NeatQustQuotiIdx;
                    $this.textCenter('careMmelNeatQustChart', srcIdx, $this.chartCareMmelNeatQust, colorGre, '' , '');
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
            // 위험안전_발생
            let configDgsfOccr = {
                type    : 'bar',
                data    : dataDgsfOccr,
                options : $this.optionsBarVert,
                plugins : [{}]
            };
            let configDzonTrnd = {
                type    : 'bar',
                data    : dataDzonTrnd,
                options : $this.optionsBarVert,
                plugins : [{}]
            };
            let configGorgSafeDtct = {
                type    : 'doughnut',
                data    : dataGorgSafeDtct,
                options : $this.options,
                plugins : pluginsGorgSafeDtct
            };
            let configGorgDngrDtct = {
                type    : 'doughnut',
                data    : dataGorgDngrDtct,
                options : $this.options,
                plugins : pluginsGorgDngrDtct
            };
            let configGuarSafeDtct = {
                type    : 'doughnut',
                data    : dataGuarSafeDtct,
                options : $this.options,
                plugins : pluginsGuarSafeDtct
            };
            let configGuarDngrDtct = {
                type    : 'doughnut',
                data    : dataGuarDngrDtct,
                options : $this.options,
                plugins : pluginsGuarDngrDtct
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
                plugins : [{}]
            };
            let configCareFatPrdt = {
                type    : 'doughnut',
                data    : dataCareFatPrdt,
                options : $this.options,
                plugins : [{}]
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
            let ctxDgsfOccr             = document.getElementById('dgsfOccrChart').getContext('2d');
            let ctxDzonTrnd             = document.getElementById('dzonTrndChart').getContext('2d');
            let ctxGorgSafeDtct         = document.getElementById('gorgSafeDtctChart').getContext('2d');
            let ctxGorgDngrDtct         = document.getElementById('gorgDngrDtctChart').getContext('2d');
            let ctxGuarSafeDtct         = document.getElementById('guarSafeDtctChart').getContext('2d');
            let ctxGuarDngrDtct         = document.getElementById('guarDngrDtctChart').getContext('2d');

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
            $this.chartDgsfOccr         = new Chart(ctxDgsfOccr     , configDgsfOccr);
            $this.chartDzonTrnd         = new Chart(ctxDzonTrnd     , configDzonTrnd);
            $this.chartGorgSafeDtct     = new Chart(ctxGorgSafeDtct , configGorgSafeDtct);
            $this.chartGorgDngrDtct     = new Chart(ctxGorgDngrDtct , configGorgDngrDtct);
            $this.chartGuarSafeDtct     = new Chart(ctxGuarSafeDtct , configGuarSafeDtct);
            $this.chartGuarDngrDtct     = new Chart(ctxGuarDngrDtct , configGuarDngrDtct);

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

            $this.totMonStat.careCalEatAvg          = $this.toNumber($this.totMonStat.careCalEatAvg);
            $this.totMonStat.careCalEatbfDay        = $this.toNumber($this.totMonStat.careCalEatbfDay);
            $this.totMonStat.careMmelNeatFmenuCnt   = $this.toNumber($this.totMonStat.careMmelNeatFmenuCnt);
            $this.totMonStat.careMmelNeatFmenuObj   = $this.toNumber($this.totMonStat.careMmelNeatFmenuObj);
            $this.totMonStat.careMmelNeatQustCnt    = $this.toNumber($this.totMonStat.careMmelNeatQustCnt);
            $this.totMonStat.careMmelNeatQustObj    = $this.toNumber($this.totMonStat.careMmelNeatQustObj);

            $this.numCountAnimate();
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
        initData: function () {
            let $this = this;

            $this.dgsfOccr = {
                mnthDngrAvg : '',
                tdayNorm    : '',
                tdayChk     : '',
                tdayWarn    : '',
                tdayPdngr   : '',
                tdayDngr    : '',
                tdayDngrSum : '',
                difCnt      : '',
                persAvg     : ''
            },
            $this.dgemCnt = {
                dgemTotl : '',
                dgemDzon : '',
                dgemFall : '',
                dgemHbit : '',
                dgemTemp : ''
            },
            $this.dgemHist = [{
                dgemDt          : '',
                dgemTm          : '',
                dgemHistStatCd  : '',
                dgemHistStatNm  : ''
            }];


            ////////////////////// 임시 //////////////////////
            $this.totMonStat = {
                openCnt             : '',
                operCnt             : '',
                noRsps              : '',

                temp                : null,
                // tmpDngrSafeOcrrTd   : 0,
                // tmpDngrSafeOcrrDif  : 0,
                // tmpDngrSafeOcrrYav  : 5.8,

                tmpTotal            : 200000,
                tmpUsage            : 140000,
                tmpNumber1          : 200000,
                tmpNumber2          : 180000,
                tmpNumber3          : 20000,
                tmpNumber4          : 500000,
                tmpNumber5          : 300000,
                tmpNumber6          : 200000,
                tmpNumber7          : 200000,
                tmpNumber8          : 14000,
                tmpNumber9          : 10000,
                tmpNumber10         : 13000,
                tmpNumber11         : 30,

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

                careMmelNeatFmenuCnt    : 11853,
                careMmelNeatFmenuObj    : 20000,

                careMmelNeatQustCnt     : 11853,
                careMmelNeatQustObj     : 20000,
            },
            $this.totCnt = {
                tmpDngrZoneCnt          : 4400,
                tmpFallDownCnt          : 2400,
                tmpHbitAbnmCnt          : 1200,
                tmpTmepAbnmCnt          : 3300,
                tmpTotalCnt             : 20000
            }
        },
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
            return value.toLocaleString('ko-KR', { hour12: true });
        },
        clock: function() {
            let $this = this;
            let date = moment().lang("ko");

            $this.clockParam.hhmmss = date.format(time12FormatPattern);
            $this.clockParam.yyyymmdd = date.format(dateFormatPattern);
            $this.clockParam.ddd = date.format("(ddd)");
            $this.clockParam.amPm = date.format("a");
        },
        initCycl: function(timeCycl) {
            let $this = this;

            if (timeCycl === null) timeCycl = 5000;
            $this.cycl.timeCycl = timeCycl;

            switch (timeCycl) {
                case 5000   :
                    $this.cyclButton.button1 = true;
                    $this.cyclButton.button2 = false;
                    $this.cyclButton.button3 = false;
                    break;
                case 30000  :
                    $this.cyclButton.button1 = false;
                    $this.cyclButton.button2 = true;
                    $this.cyclButton.button3 = false;
                    break;
                case 60000  :
                    $this.cyclButton.button1 = false;
                    $this.cyclButton.button2 = false;
                    $this.cyclButton.button3 = true;
                    break;
                default     :
                    break;
            }

            clearInterval($this.cycl.initCycl);
            $this.cycl.initCycl = setInterval($this.searchStdtDetlInfo, timeCycl);
        },
        numCountAnimate: function () {
            let $this = this;


            // 위험안전발생 : 위험가능성+위험
            $({ val : 0 }).animate({ val : $this.dgsfOccr.tdayDngrSum }, {
                duration: 1000,
                step: function() {
                    $this.dgsfOccr.tdayDngrSum = $this.toNumber(Math.floor(this.val));
                },
                complete: function() {
                    $this.dgsfOccr.tdayDngrSum = $this.toNumber(Math.floor(this.val));
                }
            });
            // 위험안전발생 : 평균대비
            $({ val : 0 }).animate({ val : $this.dgsfOccr.difCnt }, {
                duration: 1000,
                step: function() {
                    console.log("jcw animate difCnt :: ", this.val);
                    console.log("jcw animate difCnt :: ", Math.floor(this.val));
                    console.log("jcw animate difCnt :: ", $this.toNumber(Math.floor(this.val)));
                    $this.dgsfOccr.difCnt = $this.toNumber(Math.floor(this.val));
                },
                complete: function() {
                    $this.dgsfOccr.difCnt = $this.toNumber(Math.floor(this.val));
                }
            });
            // 위험안전발생 : 인평균
            $({ val : 0 }).animate({ val : $this.dgsfOccr.persAvg }, {
                duration: 1000,
                step: function() {
                    $this.dgsfOccr.persAvg = $this.toNumber(Math.floor(this.val));
                },
                complete: function() {
                    $this.dgsfOccr.persAvg = $this.toNumber(Math.floor(this.val));
                }
            });
            // 위험안전발생 : 정상
            $({ val : 0 }).animate({ val : $this.dgsfOccr.tdayNorm }, {
                duration: 1000,
                step: function() {
                    $this.dgsfOccr.tdayNorm = $this.toNumber(Math.floor(this.val));
                },
                complete: function() {
                    $this.dgsfOccr.tdayNorm = $this.toNumber(Math.floor(this.val));
                }
            });
            // 위험안전발생 : 정상(유의)
            $({ val : 0 }).animate({ val : $this.dgsfOccr.tdayChk }, {
                duration: 1000,
                step: function() {
                    $this.dgsfOccr.tdayChk = $this.toNumber(Math.floor(this.val));
                },
                complete: function() {
                    $this.dgsfOccr.tdayChk = $this.toNumber(Math.floor(this.val));
                }
            });
            // 위험안전발생 : 주의
            $({ val : 0 }).animate({ val : $this.dgsfOccr.tdayWarn }, {
                duration: 1000,
                step: function() {
                    $this.dgsfOccr.tdayWarn = $this.toNumber(Math.floor(this.val));
                },
                complete: function() {
                    $this.dgsfOccr.tdayWarn = $this.toNumber(Math.floor(this.val));
                }
            });
            // 위험안전발생 : 위험가능성
            $({ val : 0 }).animate({ val : $this.dgsfOccr.tdayPdngr }, {
                duration: 1000,
                step: function() {
                    $this.dgsfOccr.tdayPdngr = $this.toNumber(Math.floor(this.val));
                },
                complete: function() {
                    $this.dgsfOccr.tdayPdngr = $this.toNumber(Math.floor(this.val));
                }
            });
            // 위험안전발생 : 위험
            $({ val : 0 }).animate({ val : $this.dgsfOccr.tdayDngr }, {
                duration: 1000,
                step: function() {
                    $this.dgsfOccr.tdayDngr = $this.toNumber(Math.floor(this.val));
                },
                complete: function() {
                    $this.dgsfOccr.tdayDngr = $this.toNumber(Math.floor(this.val));
                }
            });

            // 위험지역추이 : 최저/최고대비
            $({ val : 0 }).animate({ val : $this.dzonTrnd.lowHighDif }, {
                duration: 1000,
                step: function() {
                    $this.dzonTrnd.lowHighDif = $this.toNumber(Math.floor(this.val));
                },
                complete: function() {
                    $this.dzonTrnd.lowHighDif = $this.toNumber(Math.floor(this.val));
                }
            });

            // 위험감정_카운트 : TOTAL
            $({ val : 0 }).animate({ val : $this.dgemCnt.dgemTotl }, {
                duration: 1000,
                step: function() {
                    $this.dgemCnt.dgemTotl = $this.toNumber(Math.floor(this.val));
                },
                complete: function() {
                    $this.dgemCnt.dgemTotl = $this.toNumber(Math.floor(this.val));
                }
            });
            // 위험감정_카운트 : 위험지역
            $({ val : 0 }).animate({ val : $this.dgemCnt.dgemDzon }, {
                duration: 1000,
                step: function() {
                    $this.dgemCnt.dgemDzon = $this.toNumber(Math.floor(this.val));
                },
                complete: function() {
                    $this.dgemCnt.dgemDzon = $this.toNumber(Math.floor(this.val));
                }
            });
            // 위험감정_카운트 : 낙상
            $({ val : 0 }).animate({ val : $this.dgemCnt.dgemFall }, {
                duration: 1000,
                step: function() {
                    $this.dgemCnt.dgemFall = $this.toNumber(Math.floor(this.val));
                },
                complete: function() {
                    $this.dgemCnt.dgemFall = $this.toNumber(Math.floor(this.val));
                }
            });
            // 위험감정_카운트 : 심박의심
            $({ val : 0 }).animate({ val : $this.dgemCnt.dgemHbit }, {
                duration: 1000,
                step: function() {
                    $this.dgemCnt.dgemHbit = $this.toNumber(Math.floor(this.val));
                },
                complete: function() {
                    $this.dgemCnt.dgemHbit = $this.toNumber(Math.floor(this.val));
                }
            });
            // 위험감정_카운트 : 체온의심
            $({ val : 0 }).animate({ val : $this.dgemCnt.dgemTemp }, {
                duration: 1000,
                step: function() {
                    $this.dgemCnt.dgemTemp = $this.toNumber(Math.floor(this.val));
                },
                complete: function() {
                    $this.dgemCnt.dgemTemp = $this.toNumber(Math.floor(this.val));
                }
            });



            ////////////////////// 임시 //////////////////////
            let tmpNumber1          = $this.totMonStat.tmpNumber1;
            let tmpNumber2          = $this.totMonStat.tmpNumber2;
            let tmpNumber3          = $this.totMonStat.tmpNumber3;
            let tmpNumber4          = $this.totMonStat.tmpNumber4;
            let tmpNumber5          = $this.totMonStat.tmpNumber5;
            let tmpNumber6          = $this.totMonStat.tmpNumber6;
            let tmpNumber7          = $this.totMonStat.tmpNumber7;
            let tmpNumber8          = $this.totMonStat.tmpNumber8;
            let tmpNumber9          = $this.totMonStat.tmpNumber9;
            let tmpNumber10         = $this.totMonStat.tmpNumber10;
            let tmpNumber11         = $this.totMonStat.tmpNumber11;

            let tmpTotal            = $this.totMonStat.tmpTotal;
            let tmpUsage            = $this.totMonStat.tmpUsage;
            let tdayDngrSum         = $this.dgsfOccr.tdayDngrSum;
            let tmpDngrZoneCnt      = $this.totCnt.tmpDngrZoneCnt;
            let tmpFallDownCnt      = $this.totCnt.tmpFallDownCnt;
            let tmpHbitAbnmCnt      = $this.totCnt.tmpHbitAbnmCnt;
            let tmpTmepAbnmCnt      = $this.totCnt.tmpTmepAbnmCnt;
            let tmpTotalCnt         = $this.totCnt.tmpTotalCnt;

            $({ val : 0 }).animate({ val : tmpNumber1 }, {
                duration: 1000,
                step: function() {
                    $this.totMonStat.tmpNumber1 = $this.toNumber(Math.floor(this.val));
                },
                complete: function() {
                    $this.totMonStat.tmpNumber1 = $this.toNumber(Math.floor(this.val));
                }
            });
            $({ val : 0 }).animate({ val : tmpNumber2 }, {
                duration: 1000,
                step: function() {
                    $this.totMonStat.tmpNumber2 = $this.toNumber(Math.floor(this.val));
                },
                complete: function() {
                    $this.totMonStat.tmpNumber2 = $this.toNumber(Math.floor(this.val));
                }
            });
            $({ val : 0 }).animate({ val : tmpNumber3 }, {
                duration: 1000,
                step: function() {
                    $this.totMonStat.tmpNumber3 = $this.toNumber(Math.floor(this.val));
                },
                complete: function() {
                    $this.totMonStat.tmpNumber3 = $this.toNumber(Math.floor(this.val));
                }
            });
            $({ val : 0 }).animate({ val : tmpNumber4 }, {
                duration: 1000,
                step: function() {
                    $this.totMonStat.tmpNumber4 = $this.toNumber(Math.floor(this.val));
                },
                complete: function() {
                    $this.totMonStat.tmpNumber4 = $this.toNumber(Math.floor(this.val));
                }
            });
            $({ val : 0 }).animate({ val : tmpNumber5 }, {
                duration: 1000,
                step: function() {
                    $this.totMonStat.tmpNumber5 = $this.toNumber(Math.floor(this.val));
                },
                complete: function() {
                    $this.totMonStat.tmpNumber5 = $this.toNumber(Math.floor(this.val));
                }
            });
            $({ val : 0 }).animate({ val : tmpNumber6 }, {
                duration: 1000,
                step: function() {
                    $this.totMonStat.tmpNumber6 = $this.toNumber(Math.floor(this.val));
                },
                complete: function() {
                    $this.totMonStat.tmpNumber6 = $this.toNumber(Math.floor(this.val));
                }
            });
            $({ val : 0 }).animate({ val : tmpNumber7 }, {
                duration: 1000,
                step: function() {
                    $this.totMonStat.tmpNumber7 = $this.toNumber(Math.floor(this.val));
                },
                complete: function() {
                    $this.totMonStat.tmpNumber7 = $this.toNumber(Math.floor(this.val));
                }
            });
            $({ val : 0 }).animate({ val : tmpNumber8 }, {
                duration: 1000,
                step: function() {
                    $this.totMonStat.tmpNumber8 = $this.toNumber(Math.floor(this.val));
                },
                complete: function() {
                    $this.totMonStat.tmpNumber8 = $this.toNumber(Math.floor(this.val));
                }
            });
            $({ val : 0 }).animate({ val : tmpNumber9 }, {
                duration: 1000,
                step: function() {
                    $this.totMonStat.tmpNumber9 = $this.toNumber(Math.floor(this.val));
                },
                complete: function() {
                    $this.totMonStat.tmpNumber9 = $this.toNumber(Math.floor(this.val));
                }
            });
            $({ val : 0 }).animate({ val : tmpNumber10 }, {
                duration: 1000,
                step: function() {
                    $this.totMonStat.tmpNumber10 = $this.toNumber(Math.floor(this.val));
                },
                complete: function() {
                    $this.totMonStat.tmpNumber10 = $this.toNumber(Math.floor(this.val));
                }
            });
            $({ val : 0 }).animate({ val : tmpNumber11 }, {
                duration: 1000,
                step: function() {
                    $this.totMonStat.tmpNumber11 = $this.toNumber(Math.floor(this.val));
                },
                complete: function() {
                    $this.totMonStat.tmpNumber11 = $this.toNumber(Math.floor(this.val));
                }
            });
            $({ val : 0 }).animate({ val : tmpTotal }, {
                duration: 1000,
                step: function() {
                    $this.totMonStat.tmpTotal = $this.toNumber(Math.floor(this.val));
                },
                complete: function() {
                    $this.totMonStat.tmpTotal = $this.toNumber(Math.floor(this.val));
                }
            });
            $({ val : 0 }).animate({ val : tdayDngrSum }, {
                duration: 1000,
                step: function() {
                    $this.dgsfOccr.tdayDngrSum = $this.toNumber(Math.floor(this.val));
                },
                complete: function() {
                    $this.dgsfOccr.tdayDngrSum = $this.toNumber(Math.floor(this.val));
                }
            });
            $({ val : 0 }).animate({ val : tmpUsage }, {
                duration: 1000,
                step: function() {
                    $this.totMonStat.tmpUsage = $this.toNumber(Math.floor(this.val));
                },
                complete: function() {
                    $this.totMonStat.tmpUsage = $this.toNumber(Math.floor(this.val));
                }
            });
            $({ val : 0 }).animate({ val : tmpDngrZoneCnt }, {
                duration: 1000,
                step: function() {
                    $this.totCnt.tmpDngrZoneCnt = $this.toNumber(Math.floor(this.val));
                },
                complete: function() {
                    $this.totCnt.tmpDngrZoneCnt = $this.toNumber(Math.floor(this.val));
                }
            });
            $({ val : 0 }).animate({ val : tmpFallDownCnt }, {
                duration: 1000,
                step: function() {
                    $this.totCnt.tmpFallDownCnt = $this.toNumber(Math.floor(this.val));
                },
                complete: function() {
                    $this.totCnt.tmpFallDownCnt = $this.toNumber(Math.floor(this.val));
                }
            });
            $({ val : 0 }).animate({ val : tmpHbitAbnmCnt }, {
                duration: 1000,
                step: function() {
                    $this.totCnt.tmpHbitAbnmCnt = $this.toNumber(Math.floor(this.val));
                },
                complete: function() {
                    $this.totCnt.tmpHbitAbnmCnt = $this.toNumber(Math.floor(this.val));
                }
            });
            $({ val : 0 }).animate({ val : tmpTmepAbnmCnt }, {
                duration: 1000,
                step: function() {
                    $this.totCnt.tmpTmepAbnmCnt = $this.toNumber(Math.floor(this.val));
                },
                complete: function() {
                    $this.totCnt.tmpTmepAbnmCnt = $this.toNumber(Math.floor(this.val));
                }
            });
            $({ val : 0 }).animate({ val : tmpTotalCnt }, {
                duration: 1000,
                step: function() {
                    $this.totCnt.tmpTotalCnt = $this.toNumber(Math.floor(this.val));
                },
                complete: function() {
                    $this.totCnt.tmpTotalCnt = $this.toNumber(Math.floor(this.val));
                }
            });
        },
        linkCall: function (menuNo) {
            let $this = this;

            let menuInfo = $this.menuList.find(findMenu);
            function findMenu(element)  {
                if(element.menuNo === menuNo)  {
                    return true;
                }
            }
            opener.navigation.handlerMenu(menuInfo);
            self.close();
        },
        getMenuList: function() {
            let $this = this;

			console.log('getMenuList');

            AjaxUtil.post({
                url: "/oper/cmon/totMonStat/searchTotMonStatMenuList.ab",
                param: $this.searchAuthParam,
                success: function(response) {

                    if ( !!response["rtnData"].result && response["rtnData"].result.length > 0 ) {
                        $.each(response["rtnData"].result, function(index, item) {
                            $this.menuList.push({'menuNo':item.menuNo, 'menuNm':item.menuNm, 'menuUrl':item.menuUrl + '.pg'});
                        });
                    }
                },
                error: function (response) {
                    Swal.alert([response, 'error']);
                }
            });
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
