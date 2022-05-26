let totMonStat = new Vue({
    el: "#totMonStat",
    data: {
        menuList : [],
        searchAuthParam : {
            searchClass : '01',
            empNo : 0
        },
        //가동_현황
        bandOperStat : {
            bandOperOpen : 0,
            bandOperNorm : 0,
            bandOperNasr : 0,
            bandOperRt   : 0
        },
        //개통_현황
        bandOpenStat : {
            bandOpenOpen    : 0,
            bandOpenPrnt    : 0,
            bandOpenNorm    : 0,
            bandOpenOpenRt  : 0,
            bandOpenPrntRt  : 0,
            bandOpenNormRt  : 0,
        },
        //헬스케어_활용율
        hcUseRt : {
            hcUseStdtCnt : 0,
            hcUseGfixCnt : 0,
            hcUseGfixRt  : 0,
            hcUseFatpCnt : 0,
            hcUseFatpRt  : 0,
            hcUseStrsCnt : 0,
            hcUseStrsRt  : 0
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
            minMaxRt    : 0,
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
        // 헬스케어_BMI체질량지수
        hcBmiIdx : {
            hcAvgBmi    : 0,
            hcMinBmi    : 0,
            hcMaxBmi    : 0
        },
        //헬스케어_성장지수
        hcGidx : {
            hcGidxVlow  : 0,
            hcGidxOhigh : 0,
            hcGidxAvg   : 0
        },
        //헬스케어_비만지수
        hcFidx : {
            hcFidxVlow  : 0,
            hcFidxFat   : 0,
            hcFidxFfat  : 0,
            hcFidxAvg   : 0
        },
        //헬스케어_비만예측
        hcFpidx : {
            hcFpidxVlow : 0,
            hcFpidxFat  : 0,
            hcFpidxFfat : 0,
            hcFpidxAvg  : 0
        },
        //헬스케어_스트레스
        hcStrs : {
            hcStrsHigh  : 0,
            hcStrsOhigh : 0,
            hcStrsAvg   : 0
        },
        //헬스케어_평균_운동시간
        hcAvgAct : {
            hcAvgAct    : 0,
            hcPdayAvgAct: 0,
            hcAvgActDif : 0
        },
        //헬스케어_평균_칼로리_섭취
        hcAvgCalEat : {
            hcCalEat    : 0,
            hcPdayCalEat: 0,
            hcCalEatDif : 0
        },
        //헬스케어_주요식단_TOP3
        hcFmenuTop3 : {
            hcEatFood1  : 0,
            hcEatFoodNm1: '',
            hcEatCnt1   : 0,
            hcEatFood2  : 0,
            hcEatFoodNm2: '',
            hcEatCnt2   : 0,
            hcEatFood3  : 0,
            hcEatFoodNm3: '',
            hcEatCnt3   : 0
        },
        //헬스케어_아침식사_결식율
        hcMmelNeat : {
            hcNeatHistObjCnt    : 0,
            hcNeatHistNeatCnt   : 0,
            hcNeatHistNeatRt    : 0,
            hcNeatQustObjCnt    : 0,
            hcNeatQustNeatCnt   : 0,
            hcNeatQustNeatRt    : 0
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
        chartBandOperStat       : null,
        chartBandOpenStat       : null,
        chartHcUseGfix          : null,
        chartHcUseFatp          : null,
        chartHcUseStrs          : null,

        chartDgsfOccr           : null,
        chartDzonTrnd           : null,
        chartGorgSafeDtct       : null,
        chartGorgDngrDtct       : null,
        chartGuarSafeDtct       : null,
        chartGuarDngrDtct       : null,
        chartHcBmiIdx           : null,
        chartHcGidx             : null,
        chartHcFidx             : null,
        chartHcFpidx            : null,
        chartHcStrs             : null,
        chartHcAvgAct           : null,
        chartHcAvgCalEat        : null,
        chartHcFmenuTop3        : null,
        chartHcMmelNeatHist     : null,
        chartHcMmelNeatQust     : null
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

        },
        initPage: function() {
            let $this = this;

            $this.initChart();
            $this.searchStdtDetlInfo();
        },
        initChart: function() {
            let $this = this;

            if ($this.chartBandOperStat     != null )   $this.chartBandOperStat.destroy();
            if ($this.chartBandOpenStat     != null )   $this.chartBandOpenStat.destroy();
            if ($this.chartHcUseGfix        != null )   $this.chartHcUseGfix.destroy();
            if ($this.chartHcUseFatp        != null )   $this.chartHcUseFatp.destroy();
            if ($this.chartHcUseStrs        != null )   $this.chartHcUseStrs.destroy();
            if ($this.chartDgsfOccr         != null )   $this.chartDgsfOccr.destroy();
            if ($this.chartDzonTrnd         != null )   $this.chartDzonTrnd.destroy();
            if ($this.chartGorgSafeDtct     != null )   $this.chartGorgSafeDtct.destroy();
            if ($this.chartGorgDngrDtct     != null )   $this.chartGorgDngrDtct.destroy();
            if ($this.chartGuarSafeDtct     != null )   $this.chartGuarSafeDtct.destroy();
            if ($this.chartGuarDngrDtct     != null )   $this.chartGuarDngrDtct.destroy();
            if ($this.chartHcBmiIdx         != null )   $this.chartHcBmiIdx.destroy();
            if ($this.chartHcGidx           != null )   $this.chartHcGidx.destroy();
            if ($this.chartHcFidx           != null )   $this.chartHcFidx.destroy();
            if ($this.chartHcFpidx          != null )   $this.chartHcFpidx.destroy();
            if ($this.chartHcStrs           != null )   $this.chartHcStrs.destroy();
            if ($this.chartHcAvgAct         != null )   $this.chartHcAvgAct.destroy();
            if ($this.chartHcAvgCalEat      != null )   $this.chartHcAvgCalEat.destroy();
            if ($this.chartHcFmenuTop3      != null )   $this.chartHcFmenuTop3.destroy();
            if ($this.chartHcMmelNeatHist   != null )   $this.chartHcMmelNeatHist.destroy();
            if ($this.chartHcMmelNeatQust   != null )   $this.chartHcMmelNeatQust.destroy();
        },
        textCenter: function(chartDivId , txt , chartId, color, fontSize, fontStyle, txtUnit) {
            const ctx = document.getElementById(chartDivId).getContext('2d');

            let fontSizeTemp    = fontSize || '20';
            let fontStyleTemp   = fontStyle || 'Arial';

            if (txt.length <= 3) {
            } else {
                fontSizeTemp = 15;
            }

            if (!!txtUnit) {
                txt += txtUnit;
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
        searchStdtDetlInfo: function (){
            let $this = this;

            $this.initData();

            AjaxUtil.post({
                url: "/oper/cmon/totMonStat/searchDgsfOccr.ab",
                success: function(response) {

                    // 가동_현황
                    if ( !!response["rtnData"]["bandOperStat"] ) {
                        $.each(response["rtnData"]["bandOperStat"], function(key, val) {
                            $this.bandOperStat[key] = val;
                        });
                    }
                    // 개통_현황
                    if ( !!response["rtnData"]["bandOpenStat"] ) {
                        $.each(response["rtnData"]["bandOpenStat"], function(key, val) {
                            $this.bandOpenStat[key] = val;
                        });
                    }
                    // 헬스케어_활용율
                    if ( !!response["rtnData"]["hcUseRt"] ) {
                        $.each(response["rtnData"]["hcUseRt"], function(key, val) {
                            $this.hcUseRt[key] = val;
                        });
                    }
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
                        if ($this.dzonTrnd.week1Ago > $this.dzonTrnd.week2Ago ) {
                            $this.dzonTrnd.trnd = '증가 추세';
                        } else {
                            $this.dzonTrnd.trnd = '감소 추세';
                        }
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
                    // 헬스케어_BMI_체질량지수
                    if ( !!response["rtnData"]["hcBmiIdx"] ) {
                        $.each(response["rtnData"]["hcBmiIdx"], function(key, val) {
                            $this.hcBmiIdx[key] = val;
                        });
                    }
                    // 헬스케어_성장지수
                    if ( !!response["rtnData"]["hcGidx"] ) {
                        $.each(response["rtnData"]["hcGidx"], function(key, val) {
                            $this.hcGidx[key] = val;
                        });
                    }
                    // 헬스케어_비만지수
                    if ( !!response["rtnData"]["hcFidx"] ) {
                        $.each(response["rtnData"]["hcFidx"], function(key, val) {
                            $this.hcFidx[key] = val;
                        });
                    }
                    // 헬스케어_비만예측
                    if ( !!response["rtnData"]["hcFpidx"] ) {
                        $.each(response["rtnData"]["hcFpidx"], function(key, val) {
                            $this.hcFpidx[key] = val;
                        });
                    }
                    // 헬스케어_스트레스
                    if ( !!response["rtnData"]["hcStrs"] ) {
                        $.each(response["rtnData"]["hcStrs"], function(key, val) {
                            $this.hcStrs[key] = val;
                        });
                    }
                    // 헬스케어_평균_운동시간
                    if ( !!response["rtnData"]["hcAvgAct"] ) {
                        $.each(response["rtnData"]["hcAvgAct"], function(key, val) {
                            $this.hcAvgAct[key] = val;
                        });
                    }
                    // 헬스케어_평균_칼로리_섭취
                    if ( !!response["rtnData"]["hcAvgCalEat"] ) {
                        $.each(response["rtnData"]["hcAvgCalEat"], function(key, val) {
                            $this.hcAvgCalEat[key] = val;
                        });
                    }
                    // 헬스케어_주요식단_TOP3
                    if ( !!response["rtnData"]["hcFmenuTop3"] ) {
                        $.each(response["rtnData"]["hcFmenuTop3"], function(key, val) {
                            $this.hcFmenuTop3[key] = val;
                        });
                    }
                    // 헬스케어_아침식사_결식율
                    if ( !!response["rtnData"]["hcMmelNeat"] ) {
                        $.each(response["rtnData"]["hcMmelNeat"], function(key, val) {
                            $this.hcMmelNeat[key] = val;
                        });
                    }

                    $this.updateChart();
                    $this.initCycl($this.cycl.timeCycl);
                },
                error: function (response) {
                    Swal.alert([response, 'error']);
                }
            });
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
            let colorSil = '#c6d3d1';

            // 헬스케어 활용율 Data
            // let tmpGrowFatIdx       = 80;
            // let tmpFatPrdtIdx       = 70;
            // let tmpStrsIdx          = 65;

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
            // let operCntQuotiIdx     = $this.chartPerQuoti($this.totMonStat.operCnt, $this.bandOperStat.);
            // let NeatFmenuQuotiIdx   = $this.chartPerQuoti($this.totMonStat.careMmelNeatFmenuCnt, $this.totMonStat.careMmelNeatFmenuObj);
            // let NeatQustQuotiIdx    = $this.chartPerQuoti($this.totMonStat.careMmelNeatQustCnt, $this.totMonStat.careMmelNeatQustObj);

            // 나머지 구하기
            // let operCntModIdx       = $this.chartPerModIdx(operCntQuotiIdx);
            // let growFatModIdx       = $this.chartPerModIdx(tmpGrowFatIdx);
            // let fatPrdtModIdx       = $this.chartPerModIdx(tmpFatPrdtIdx);
            // let strsModIdx          = $this.chartPerModIdx(tmpStrsIdx);
            // let dgsfDtctGorgSzonMod = $this.chartPerModIdx($this.dgsfDtct.gorgSzon);
            // let dgsfDtctGorgDzonMod = $this.chartPerModIdx($this.dgsfDtct.gorgDzon);
            // let dgsfDtctGuarSzonMod = $this.chartPerModIdx($this.dgsfDtct.guarSzon);
            // let dgsfDtctGuarDzonMod = $this.chartPerModIdx($this.dgsfDtct.guarDzon);
            // let NeatFmenuModIdx     = $this.chartPerModIdx(NeatFmenuQuotiIdx);
            // let NeatQustModIdx      = $this.chartPerModIdx(NeatQustQuotiIdx);

            $this.numCountAnimate();

            let dataBandOperStat = {
                labels              : ['가동','무응답'],
                datasets: [{
                    data            : [$this.bandOperStat.bandOperRt    , 100 - $this.bandOperStat.bandOperRt],
                    backgroundColor : [colorBlu                         , colorGra],
                    borderColor     : [colorBlu                         , colorGra],
                    borderWidth     : 10
                }]
            };
            let dataBandOpenStat = {
                labels              : ['개통','제출','가입'],
                datasets: [{
                    data            : [$this.bandOpenStat.bandOpenOpen  , $this.bandOpenStat.bandOpenPrnt   , $this.bandOpenStat.bandOpenNorm],
                    backgroundColor : [colorBlu                         , colorOra                          , colorSil  ],
                    borderColor     : [colorBlu                         , colorOra                          , colorSil  ],
                    borderWidth     : 22
                }]
            };
            let dataHcUseGfix = {
                labels              : ['USAGE','NUSAGE'],
                datasets: [{
                    data            : [$this.hcUseRt.hcUseGfixRt        , 100 - $this.hcUseRt.hcUseGfixRt],
                    backgroundColor : [colorBlu                         , colorBla],
                    borderColor     : [colorBlu                         , colorBla],
                    borderWidth     : 10
                }]
            };
            let dataHcUseFatp = {
                labels              : ['USAGE','NUSAGE'],
                datasets: [{
                    data            : [$this.hcUseRt.hcUseFatpRt        , 100 - $this.hcUseRt.hcUseFatpRt],
                    backgroundColor : [colorBlu                         , colorBla],
                    borderColor     : [colorBlu                         , colorBla],
                    borderWidth     : 10
                }]
            };
            let dataHcUseStrs = {
                labels              : ['USAGE','NUSAGE'],
                datasets: [{
                    data            : [$this.hcUseRt.hcUseStrsRt        , 100 - $this.hcUseRt.hcUseStrsRt],
                    backgroundColor : [colorBlu                         , colorBla],
                    borderColor     : [colorBlu                         , colorBla],
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
                    data            : [$this.dgsfDtct.gorgSzon  , 100 - $this.dgsfDtct.gorgSzon],
                    backgroundColor : [colorGre                 , colorGra],
                    borderColor     : [colorGre                 , colorGra],
                    borderWidth     : 5
                }]
            };
            let dataGorgDngrDtct = {
                labels              : ['USAGE','NUSAGE'],
                datasets: [{
                    data            : [$this.dgsfDtct.gorgDzon  , 100 - $this.dgsfDtct.gorgDzon],
                    backgroundColor : [colorOra                 , colorGra],
                    borderColor     : [colorOra                 , colorGra],
                    borderWidth     : 5
                }]
            };
            let dataGuarSafeDtct = {
                labels              : ['USAGE','NUSAGE'],
                datasets: [{
                    data            : [$this.dgsfDtct.guarSzon  , 100 - $this.dgsfDtct.guarSzon],
                    backgroundColor : [colorGre                 , colorGra],
                    borderColor     : [colorGre                 , colorGra],
                    borderWidth     : 5
                }]
            };
            let dataGuarDngrDtct = {
                labels              : ['USAGE','NUSAGE'],
                datasets: [{
                    data            : [$this.dgsfDtct.guarDzon  , 100 - $this.dgsfDtct.guarDzon],
                    backgroundColor : [colorOra                 , colorGra],
                    borderColor     : [colorOra                 , colorGra],
                    borderWidth     : 5
                }]
            };
            // 막대차트 미구현, 누적막대 의미 확인 필요
            let dataHcBmiIdx = {
                labels              : ['최저','최대'],
                datasets: [{
                    data            : [$this.hcBmiIdx.hcMinBmi              , $this.hcBmiIdx.hcMaxBmi],
                    backgroundColor : [colorOra                             , colorWhi],
                    borderColor     : [colorOra                             , colorWhi],
                    borderWidth     : 0
                }]
            };
            let dataHcGidx = {
                labels              : ['성장지수','성장지수'],
                datasets: [{
                    data            : [$this.hcGidx.hcGidxAvg               , 100 - $this.hcGidx.hcGidxAvg],
                    backgroundColor : [colorGre                             , colorGra],
                    borderColor     : [colorGre                             , colorGra],
                    borderWidth     : 10
                }]
            };
            let dataHcFidx = {
                labels              : ['비만지수','비만지수'],
                datasets: [{
                    data            : [$this.hcFidx.hcFidxAvg               , 100 - $this.hcFidx.hcFidxAvg],
                    backgroundColor : [colorGre                             , colorGra],
                    borderColor     : [colorGre                             , colorGra],
                    borderWidth     : 10
                }]
            };
            let dataHcFpidx = {
                labels              : ['비만예측','비만예측'],
                datasets: [{
                    data            : [$this.hcFpidx.hcFpidxAvg             , 100 - $this.hcFpidx.hcFpidxAvg],
                    backgroundColor : [colorGre                             , colorGra],
                    borderColor     : [colorGre                             , colorGra],
                    borderWidth     : 10
                }]
            };
            let dataHcStrs = {
                labels              : ['높음','매우높음'],
                datasets: [{
                    data            : [$this.hcStrs.hcStrsAvg               , 100 - $this.hcStrs.hcStrsAvg],
                    backgroundColor : [colorGre                             , colorGra],
                    borderColor     : [colorGre                             , colorGra],
                    borderWidth     : 10
                }]
            };
            let dataHcAvgAct = {
                labels              : ['평균','전일'],
                datasets: [{
                    data            : [$this.hcAvgAct.hcAvgAct              , $this.hcAvgAct.hcPdayAvgAct],
                    backgroundColor : [colorYel                             , colorBlu],
                    borderColor     : [colorYel                             , colorBlu],
                    borderWidth     : 0
                }]
            };
            let dataHcAvgCalEat = {
                labels              : ['평균','전일'],
                datasets: [{
                    data            : [$this.hcAvgCalEat.hcCalEat           , $this.hcAvgCalEat.hcPdayCalEat],
                    backgroundColor : [colorYel                             , colorOra],
                    borderColor     : [colorYel                             , colorOra],
                    borderWidth     : 0
                }]
            };
            let dataHcFmenuTop3 = {
                labels              : ['밥','빵','튀김'],
                datasets: [{
                    data            : [$this.hcFmenuTop3.hcEatCnt1          , $this.hcFmenuTop3.hcEatCnt2           , $this.hcFmenuTop3.hcEatCnt3],
                    backgroundColor : [colorBlu                             , colorOra                              , colorSil],
                    borderColor     : [colorBlu                             , colorOra                              , colorSil],
                    borderWidth     : 22
                }]
            };
            let dataHcMmelNeatHist = {
                labels              : ['결식','대상'],
                datasets: [{
                    data            : [$this.hcMmelNeat.hcNeatHistNeatRt    , 100 - $this.hcMmelNeat.hcNeatHistNeatRt],
                    backgroundColor : [colorGre                             , colorGra],
                    borderColor     : [colorGre                             , colorGra],
                    borderWidth     : 10
                }]
            };
            let dataHcMmelNeatQust = {
                labels              : ['결식','대상'],
                datasets: [{
                    data            : [$this.hcMmelNeat.hcNeatQustNeatRt    , 100 - $this.hcMmelNeat.hcNeatQustNeatRt],
                    backgroundColor : [colorGre                             , colorGra],
                    borderColor     : [colorGre                             , colorGra],
                    borderWidth     : 10
                }]
            };

            let pluginsBandOperStat = [{
                beforeDraw: function () {
                    let srcIdx = '-';
                    if($this.bandOperStat.bandOperRt != null ) srcIdx = $this.bandOperStat.bandOperRt;
                    $this.textCenter('bandOperStatChart', srcIdx, $this.chartBandOperStat, colorBlu, '' , '', '%');
                }
            }];
            let pluginsHcUseGfix = [{
                beforeDraw: function () {
                    let srcIdx = '-';
                    if($this.hcUseRt.hcUseGfixRt != null ) srcIdx = $this.hcUseRt.hcUseGfixRt;
                    $this.textCenter('hcUseGfixChart', srcIdx, $this.chartHcUseGfix, colorBlu, '' , '', '%');
                }
            }];
            let pluginsHcUseFatp = [{
                beforeDraw: function () {
                    let srcIdx = '-';
                    if($this.hcUseRt.hcUseFatpRt != null ) srcIdx = $this.hcUseRt.hcUseFatpRt;
                    $this.textCenter('hcUseFatpChart', srcIdx, $this.chartHcUseFatp, colorBlu, '' , '', '%');
                }
            }];
            let pluginsHcUseStrs = [{
                beforeDraw: function () {
                    let srcIdx = '-';
                    if($this.hcUseRt.hcUseStrsRt != null ) srcIdx = $this.hcUseRt.hcUseStrsRt;
                    $this.textCenter('hcUseStrsChart', srcIdx, $this.chartHcUseStrs, colorBlu, '' , '', '%');
                }
            }];
            let pluginsGorgSafeDtct = [{
                beforeDraw: function () {
                    let srcIdx = '-';
                    if($this.dgsfDtct.gorgSzon != null ) srcIdx = $this.dgsfDtct.gorgSzon;
                    $this.textCenter('gorgSafeDtctChart', srcIdx, $this.chartGorgSafeDtct, colorGre, '' , '', '%');
                }
            }];
            let pluginsGorgDngrDtct = [{
                beforeDraw: function () {
                    let srcIdx = '-';
                    if($this.dgsfDtct.gorgDzon != null ) srcIdx = $this.dgsfDtct.gorgDzon;
                    $this.textCenter('gorgDngrDtctChart', srcIdx, $this.chartGorgDngrDtct, colorOra, '' , '', '%');
                }
            }];
            let pluginsGuarSafeDtct = [{
                beforeDraw: function () {
                    let srcIdx = '-';
                    if($this.dgsfDtct.guarSzon != null ) srcIdx = $this.dgsfDtct.guarSzon;
                    $this.textCenter('guarSafeDtctChart', srcIdx, $this.chartGuarSafeDtct, colorGre, '' , '', '%');
                }
            }];
            let pluginsGuarDngrDtct = [{
                beforeDraw: function () {
                    let srcIdx = '-';
                    if($this.dgsfDtct.guarDzon != null ) srcIdx = $this.dgsfDtct.guarDzon;
                    $this.textCenter('guarDngrDtctChart', srcIdx, $this.chartGuarDngrDtct, colorOra, '' , '', '%');
                }
            }];
            // 의미 확인 후 centerText 수정 필요
            let pluginsHcGidx = [{
                beforeDraw: function () {
                    let srcIdx = '-';
                    if($this.hcGidx.hcGidxAvg != null ) srcIdx = $this.hcGidx.hcGidxAvg;
                    $this.textCenter('hcGidxChart', srcIdx, $this.chartHcGidx, colorGre, '' , '');
                }
            }];
            // 의미 확인 후 centerText 수정 필요
            let pluginsHcFidx = [{
                beforeDraw: function () {
                    let srcIdx = '-';
                    if($this.hcFidx.hcFidxAvg != null ) srcIdx = $this.hcFidx.hcFidxAvg;
                    $this.textCenter('hcFidxChart', srcIdx, $this.chartHcFidx, colorGre, '' , '');
                }
            }];
            // // 의미 확인 후 centerText 수정 필요
            let pluginsHcFpidx = [{
                beforeDraw: function () {
                    let srcIdx = '-';
                    if($this.hcFpidx.hcFpidxAvg != null ) srcIdx = $this.hcFpidx.hcFpidxAvg;
                    $this.textCenter('hcFpidxChart', srcIdx, $this.chartHcFpidx, colorGre, '' , '');
                }
            }];
            // 의미 확인 후 centerText 수정 필요
            let pluginsHcStrs = [{
                beforeDraw: function () {
                    let srcIdx = '-';
                    if($this.hcStrs.hcStrsAvg != null ) srcIdx = $this.hcStrs.hcStrsAvg;
                    $this.textCenter('hcStrsChart', srcIdx, $this.chartHcStrs, colorGre, '' , '');
                }
            }];
            let pluginsHcMmelNeatHist = [{
                beforeDraw: function () {
                    let srcIdx = '-';
                    if($this.hcMmelNeat.hcNeatHistNeatRt != null ) srcIdx = $this.hcMmelNeat.hcNeatHistNeatRt;
                    $this.textCenter('hcMmelNeatHistChart', srcIdx, $this.chartHcMmelNeatHist, colorGre, '' , '', '%');
                }
            }];
            let pluginsHcMmelNeatQust = [{
                beforeDraw: function () {
                    let srcIdx = '-';
                    if($this.hcMmelNeat.hcNeatQustNeatRt != null ) srcIdx = $this.hcMmelNeat.hcNeatQustNeatRt;
                    $this.textCenter('hcMmelNeatQustChart', srcIdx, $this.chartHcMmelNeatQust, colorGre, '' , '', '%');
                }
            }];
            // jcw : 신기하네.. 왜 updateChart에서 호출할땐 오브젝트고.. 여기서 넘겨서 할땐 널일까..
            // let pluginsBandOperStat = $this.chartPluginsCenter('operStatChart'  , $this.totMonStat.growIdx  , $this.chartBandOperStat   , operStatChartColor, '' , '');
            // let pluginsHcUseGfix  = $this.chartPluginsCenter('hcUseGfixChart'   , $this.hcGidx.hcGidxAvg             , $this.chartHcUseGfix    , colorBlu          , '' , '');

            let configBandOperStat = {
                type    : 'doughnut',
                data    : dataBandOperStat,
                options : $this.options,
                plugins : pluginsBandOperStat
            };
            let configBandOpenStat = {
                type    : 'doughnut',
                data    : dataBandOpenStat,
                options : $this.options
            };
            let configHcUseGfix = {
                type    : 'doughnut',
                data    : dataHcUseGfix,
                options : $this.options,
                plugins : pluginsHcUseGfix
            };
            let configHcUseFatp = {
                type    : 'doughnut',
                data    : dataHcUseFatp,
                options : $this.options,
                plugins : pluginsHcUseFatp
            };
            let configHcUseStrs = {
                type    : 'doughnut',
                data    : dataHcUseStrs,
                options : $this.options,
                plugins : pluginsHcUseStrs
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
            let configHcBmiIdx = {
                type    : 'bar',
                data    : dataHcBmiIdx,
                options : $this.optionsBarVert,
                plugins : [{}]
            };
            let configHcGidx = {
                type    : 'doughnut',
                data    : dataHcGidx,
                options : $this.options,
                plugins : pluginsHcGidx
            };
            let configHcFidx = {
                type    : 'doughnut',
                data    : dataHcFidx,
                options : $this.options,
                plugins : pluginsHcFidx
            };
            let configHcFpidx = {
                type    : 'doughnut',
                data    : dataHcFpidx,
                options : $this.options,
                plugins : pluginsHcFpidx
            };
            let configHcStrs = {
                type    : 'doughnut',
                data    : dataHcStrs,
                options : $this.options,
                plugins : pluginsHcStrs
            };
            let configHcAvgAct = {
                type    : 'bar',
                data    : dataHcAvgAct,
                options : $this.optionsBarVert,
                plugins : [{}]
            };
            let configHcAvgCalEat = {
                type    : 'bar',
                data    : dataHcAvgCalEat,
                options : $this.optionsBarVert,
                plugins : [{}]
            };
            let configHcFmenuTop3 = {
                type    : 'doughnut',
                data    : dataHcFmenuTop3,
                options : $this.options,
                plugins : [{}]
            };
            let configHcMmelNeatHist = {
                type    : 'doughnut',
                data    : dataHcMmelNeatHist,
                options : $this.options,
                plugins : pluginsHcMmelNeatHist
            };
            let configHcMmelNeatQust = {
                type    : 'doughnut',
                data    : dataHcMmelNeatQust,
                options : $this.options,
                plugins : pluginsHcMmelNeatQust
            };

            let ctxBandOperStat         = document.getElementById('bandOperStatChart').getContext('2d');
            let ctxBandOpenStat         = document.getElementById('bandOpenStatChart').getContext('2d');
            let ctxHcUseGfix            = document.getElementById('hcUseGfixChart').getContext('2d');
            let ctxHcUseFatp            = document.getElementById('hcUseFatpChart').getContext('2d');
            let ctxHcUseStrs            = document.getElementById('hcUseStrsChart').getContext('2d');
            let ctxDgsfOccr             = document.getElementById('dgsfOccrChart').getContext('2d');
            let ctxDzonTrnd             = document.getElementById('dzonTrndChart').getContext('2d');
            let ctxGorgSafeDtct         = document.getElementById('gorgSafeDtctChart').getContext('2d');
            let ctxGorgDngrDtct         = document.getElementById('gorgDngrDtctChart').getContext('2d');
            let ctxGuarSafeDtct         = document.getElementById('guarSafeDtctChart').getContext('2d');
            let ctxGuarDngrDtct         = document.getElementById('guarDngrDtctChart').getContext('2d');
            let ctxHcBmiIdx             = document.getElementById('hcBmiIdxChart').getContext('2d');
            let ctxHcGidx               = document.getElementById('hcGidxChart').getContext('2d');
            let ctxHcFidx               = document.getElementById('hcFidxChart').getContext('2d');
            let ctxHcFpidx              = document.getElementById('hcFpidxChart').getContext('2d');
            let ctxHcStrs               = document.getElementById('hcStrsChart').getContext('2d');
            let ctxHcAvgAct             = document.getElementById('hcAvgActChart').getContext('2d');
            let ctxHcAvgCalEat          = document.getElementById('hcAvgCalEatChart').getContext('2d');
            let ctxHcFmenuTop3          = document.getElementById('hcFmenuTop3Chart').getContext('2d');
            let ctxHcMmelNeatHist       = document.getElementById('hcMmelNeatHistChart').getContext('2d');
            let ctxHcMmelNeatQust       = document.getElementById('hcMmelNeatQustChart').getContext('2d');

            $this.initChart();

            $this.chartBandOperStat     = new Chart(ctxBandOperStat     , configBandOperStat);
            $this.chartBandOpenStat     = new Chart(ctxBandOpenStat     , configBandOpenStat);
            $this.chartHcUseGfix        = new Chart(ctxHcUseGfix        , configHcUseGfix);
            $this.chartHcUseFatp        = new Chart(ctxHcUseFatp        , configHcUseFatp);
            $this.chartHcUseStrs        = new Chart(ctxHcUseStrs        , configHcUseStrs);
            $this.chartDgsfOccr         = new Chart(ctxDgsfOccr         , configDgsfOccr);
            $this.chartDzonTrnd         = new Chart(ctxDzonTrnd         , configDzonTrnd);
            $this.chartGorgSafeDtct     = new Chart(ctxGorgSafeDtct     , configGorgSafeDtct);
            $this.chartGorgDngrDtct     = new Chart(ctxGorgDngrDtct     , configGorgDngrDtct);
            $this.chartGuarSafeDtct     = new Chart(ctxGuarSafeDtct     , configGuarSafeDtct);
            $this.chartGuarDngrDtct     = new Chart(ctxGuarDngrDtct     , configGuarDngrDtct);
            $this.chartHcBmiIdx         = new Chart(ctxHcBmiIdx         , configHcBmiIdx);
            $this.chartHcGidx           = new Chart(ctxHcGidx           , configHcGidx);
            $this.chartHcFidx           = new Chart(ctxHcFidx           , configHcFidx);
            $this.chartHcFpidx          = new Chart(ctxHcFpidx          , configHcFpidx);
            $this.chartHcStrs           = new Chart(ctxHcStrs           , configHcStrs);
            $this.chartHcAvgAct         = new Chart(ctxHcAvgAct         , configHcAvgAct);
            $this.chartHcAvgCalEat      = new Chart(ctxHcAvgCalEat      , configHcAvgCalEat);
            $this.chartHcFmenuTop3      = new Chart(ctxHcFmenuTop3      , configHcFmenuTop3);
            $this.chartHcMmelNeatHist   = new Chart(ctxHcMmelNeatHist   , configHcMmelNeatHist);
            $this.chartHcMmelNeatQust   = new Chart(ctxHcMmelNeatQust   , configHcMmelNeatQust);

        },
        // jcw : 신기하네.. 왜 updateChart에서 호출할땐 오브젝트고.. 여기서 넘겨서 할땐 널일까..
        // chartPluginsCenter: function(chartDivId, srcIdx, chartId, centerColor, fontSize, fontStyle) {
        //     let $this = this;
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

            //가동_현황
            $this.bandOperStat = {
                bandOperOpen : 0,
                bandOperNorm : 0,
                bandOperNasr : 0,
                bandOperRt   : 0
            },
            //개통_현황
            $this.bandOpenStat = {
                bandOpenOpen    : 0,
                bandOpenPrnt    : 0,
                bandOpenNorm    : 0,
                bandOpenOpenRt  : 0,
                bandOpenPrntRt  : 0,
                bandOpenNormRt  : 0,
            },
            //헬스케어_활용율
            $this.hcUseRt = {
                hcUseStdtCnt : 0,
                hcUseGfixCnt : 0,
                hcUseGfixRt  : 0,
                hcUseFatpCnt : 0,
                hcUseFatpRt  : 0,
                hcUseStrsCnt : 0,
                hcUseStrsRt  : 0
            },
            //위험안전발생
            $this.dgsfOccr = {
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
            $this.dzonTrnd = {
                bday1       : 0,
                week1Ago    : 0,
                week2Ago    : 0,
                week3Ago    : 0,
                week4Ago    : 0,
                minMaxRt    : 0,
                trnd        : ''
            },
            //안전위험지역_탐지율
            $this.dgsfDtct = {
                gorgDzon    : 0,
                gorgSzon    : 0,
                guarDzon    : 0,
                guarSzon    : 0
            },
            //위험감정_카운트
            $this.dgemCnt = {
                dgemTotl : 0,
                dgemDzon : 0,
                dgemFall : 0,
                dgemHbit : 0,
                dgemTemp : 0
            },
            //위험지역_TOP3_공공
            $this.gorgDtop3 = {
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
            $this.guarDtop3 = {
                guarDtop3Addr1   : '',
                guarDtop3Cnt1    : 0,
                guarDtop3Addr2   : '',
                guarDtop3Cnt2    : 0,
                guarDtop3Addr3   : '',
                guarDtop3Cnt3    : 0
            },
            //위험감정_이력
            $this.dgemHist = [{
                dgemDt : '',
                dgemTm : '',
                dgemHistStatCd : '',
                dgemHistStatNm : ''
            }],
            //헬스케어_성장지수
            $this.hcGidx = {
                hcGidxVlow  : 0,
                hcGidxOhigh : 0,
                hcGidxAvg   : 0
            },
            //헬스케어_비만지수
            $this.hcFidx = {
                hcFidxVlow  : 0,
                hcFidxFat   : 0,
                hcFidxFfat  : 0,
                hcFidxAvg   : 0
            },
            //헬스케어_비만예측
            $this.hcFpidx = {
                hcFpidxVlow : 0,
                hcFpidxFat  : 0,
                hcFpidxFfat : 0,
                hcFpidxAvg  : 0
            },
            //헬스케어_스트레스
            $this.hcStrs = {
                hcStrsHigh  : 0,
                hcStrsOhigh : 0,
                hcStrsAvg   : 0
            },
            //헬스케어_평균_운동시간
            $this.hcAvgAct = {
                hcAvgAct    : 0,
                hcPdayAvgAct: 0,
                hcAvgActDif : 0
            },
            //헬스케어_평균_칼로리_섭취
            $this.hcAvgCalEat = {
                hcCalEat    : 0,
                hcPdayCalEat: 0,
                hcCalEatDif : 0
            },
            //헬스케어_주요식단_TOP3
            $this.hcFmenuTop3 = {
                hcEatFood1  : 0,
                hcEatFoodNm1: '',
                hcEatCnt1   : 0,
                hcEatFood2  : 0,
                hcEatFoodNm2: '',
                hcEatCnt2   : 0,
                hcEatFood3  : 0,
                hcEatFoodNm3: '',
                hcEatCnt3   : 0
            },
            //헬스케어_아침식사_결식율
            $this.hcMmelNeat = {
                hcNeatHistObjCnt    : 0,
                hcNeatHistNeatCnt   : 0,
                hcNeatHistNeatRt    : 0,
                hcNeatQustObjCnt    : 0,
                hcNeatQustNeatCnt   : 0,
                hcNeatQustNeatRt    : 0
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
            return value.toLocaleString();
        },
        clock: function() {
            let $this = this;
            let date = moment().locale('ko', { hour12: true });


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

            // 가동_현황 : 개통
            $({ val : 0 }).animate({ val : $this.bandOperStat.bandOperOpen }, {
                duration: 1000,
                step: function() {
                    $this.bandOperStat.bandOperOpen = $this.toNumber(Math.floor(this.val));
                },
                complete: function() {
                    $this.bandOperStat.bandOperOpen = $this.toNumber(Math.floor(this.val));
                }
            });
            // 가동_현황 : 가동
            $({ val : 0 }).animate({ val : $this.bandOperStat.bandOperNorm }, {
                duration: 1000,
                step: function() {
                    $this.bandOperStat.bandOperNorm = $this.toNumber(Math.floor(this.val));
                },
                complete: function() {
                    $this.bandOperStat.bandOperNorm = $this.toNumber(Math.floor(this.val));
                }
            });
            // 가동_현황 : 무응답
            $({ val : 0 }).animate({ val : $this.bandOperStat.bandOperNasr }, {
                duration: 1000,
                step: function() {
                    $this.bandOperStat.bandOperNasr = $this.toNumber(Math.floor(this.val));
                },
                complete: function() {
                    $this.bandOperStat.bandOperNasr = $this.toNumber(Math.floor(this.val));
                }
            });
            // 개통_현황 : 밴드개통
            $({ val : 0 }).animate({ val : $this.bandOpenStat.bandOpenOpen }, {
                duration: 1000,
                step: function() {
                    $this.bandOpenStat.bandOpenOpen = $this.toNumber(Math.floor(this.val));
                },
                complete: function() {
                    $this.bandOpenStat.bandOpenOpen = $this.toNumber(Math.floor(this.val));
                }
            });
            // 개통_현황 : 서류제출
            $({ val : 0 }).animate({ val : $this.bandOpenStat.bandOpenPrnt }, {
                duration: 1000,
                step: function() {
                    $this.bandOpenStat.bandOpenPrnt = $this.toNumber(Math.floor(this.val));
                },
                complete: function() {
                    $this.bandOpenStat.bandOpenPrnt = $this.toNumber(Math.floor(this.val));
                }
            });
            // 개통_현황 : 회원가입
            $({ val : 0 }).animate({ val : $this.bandOpenStat.bandOpenNorm }, {
                duration: 1000,
                step: function() {
                    $this.bandOpenStat.bandOpenNorm = $this.toNumber(Math.floor(this.val));
                },
                complete: function() {
                    $this.bandOpenStat.bandOpenNorm = $this.toNumber(Math.floor(this.val));
                }
            });
            // 헬스케어_활용율 : TOTAL
            $({ val : 0 }).animate({ val : $this.hcUseRt.hcUseStdtCnt }, {
                duration: 1000,
                step: function() {
                    $this.hcUseRt.hcUseStdtCnt = $this.toNumber(Math.floor(this.val));
                },
                complete: function() {
                    $this.hcUseRt.hcUseStdtCnt = $this.toNumber(Math.floor(this.val));
                }
            });
            // 헬스케어_활용율 : 성장/비만 USAGE
            $({ val : 0 }).animate({ val : $this.hcUseRt.hcUseGfixCnt }, {
                duration: 1000,
                step: function() {
                    $this.hcUseRt.hcUseGfixCnt = $this.toNumber(Math.floor(this.val));
                },
                complete: function() {
                    $this.hcUseRt.hcUseGfixCnt = $this.toNumber(Math.floor(this.val));
                }
            });
            // 헬스케어_활용율 : 비만예측 USAGE
            $({ val : 0 }).animate({ val : $this.hcUseRt.hcUseFatpCnt }, {
                duration: 1000,
                step: function() {
                    $this.hcUseRt.hcUseFatpCnt = $this.toNumber(Math.floor(this.val));
                },
                complete: function() {
                    $this.hcUseRt.hcUseFatpCnt = $this.toNumber(Math.floor(this.val));
                }
            });
            // 헬스케어_활용율 : 스트레스 USAGE
            $({ val : 0 }).animate({ val : $this.hcUseRt.hcUseStrsCnt }, {
                duration: 1000,
                step: function() {
                    $this.hcUseRt.hcUseStrsCnt = $this.toNumber(Math.floor(this.val));
                },
                complete: function() {
                    $this.hcUseRt.hcUseStrsCnt = $this.toNumber(Math.floor(this.val));
                }
            });

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
                    $this.dgsfOccr.difCnt = $this.toNumber(this.val.toFixed(1));
                },
                complete: function() {
                    $this.dgsfOccr.difCnt = $this.toNumber(this.val.toFixed(1));
                }
            });
            // 위험안전발생 : 인평균
            $({ val : 0 }).animate({ val : $this.dgsfOccr.persAvg }, {
                duration: 1000,
                step: function() {
                    $this.dgsfOccr.persAvg = $this.toNumber(this.val.toFixed(1));
                },
                complete: function() {
                    $this.dgsfOccr.persAvg = $this.toNumber(this.val.toFixed(1));
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
            $({ val : 0 }).animate({ val : $this.dzonTrnd.minMaxRt }, {
                duration: 1000,
                step: function() {
                    $this.dzonTrnd.minMaxRt = $this.toNumber(this.val.toFixed(1));
                },
                complete: function() {
                    $this.dzonTrnd.minMaxRt = $this.toNumber(this.val.toFixed(1));
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
            // 자주 방문하는 위험지역 TOP3 : TOP1
            $({ val : 0 }).animate({ val : $this.gorgDtop3.gorgDtop3Cnt1 }, {
                duration: 1000,
                step: function() {
                    $this.gorgDtop3.gorgDtop3Cnt1 = $this.toNumber(Math.floor(this.val));
                },
                complete: function() {
                    $this.gorgDtop3.gorgDtop3Cnt1 = $this.toNumber(Math.floor(this.val));
                }
            });
            // 자주 방문하는 위험지역 TOP3 : TOP2
            $({ val : 0 }).animate({ val : $this.gorgDtop3.gorgDtop3Cnt2 }, {
                duration: 1000,
                step: function() {
                    $this.gorgDtop3.gorgDtop3Cnt2 = $this.toNumber(Math.floor(this.val));
                },
                complete: function() {
                    $this.gorgDtop3.gorgDtop3Cnt2 = $this.toNumber(Math.floor(this.val));
                }
            });
            // 자주 방문하는 위험지역 TOP3 : TOP3
            $({ val : 0 }).animate({ val : $this.gorgDtop3.gorgDtop3Cnt3 }, {
                duration: 1000,
                step: function() {
                    $this.gorgDtop3.gorgDtop3Cnt3 = $this.toNumber(Math.floor(this.val));
                },
                complete: function() {
                    $this.gorgDtop3.gorgDtop3Cnt3 = $this.toNumber(Math.floor(this.val));
                }
            });
            // 보호자가 많이 지정한 위험지역 TOP3 : TOP1
            $({ val : 0 }).animate({ val : $this.guarDtop3.guarDtop3Cnt1 }, {
                duration: 1000,
                step: function() {
                    $this.guarDtop3.guarDtop3Cnt1 = $this.toNumber(Math.floor(this.val));
                },
                complete: function() {
                    $this.guarDtop3.guarDtop3Cnt1 = $this.toNumber(Math.floor(this.val));
                }
            });
            // 보호자가 많이 지정한 위험지역 TOP3 : TOP2
            $({ val : 0 }).animate({ val : $this.guarDtop3.guarDtop3Cnt2 }, {
                duration: 1000,
                step: function() {
                    $this.guarDtop3.guarDtop3Cnt2 = $this.toNumber(Math.floor(this.val));
                },
                complete: function() {
                    $this.guarDtop3.guarDtop3Cnt2 = $this.toNumber(Math.floor(this.val));
                }
            });
            // 보호자가 많이 지정한 위험지역 TOP3 : TOP3
            $({ val : 0 }).animate({ val : $this.guarDtop3.guarDtop3Cnt3 }, {
                duration: 1000,
                step: function() {
                    $this.guarDtop3.guarDtop3Cnt3 = $this.toNumber(Math.floor(this.val));
                },
                complete: function() {
                    $this.guarDtop3.guarDtop3Cnt3 = $this.toNumber(Math.floor(this.val));
                }
            });

            // 헬스케어 : BMI_체질량지수
            $({ val : 0 }).animate({ val : $this.hcBmiIdx.hcAvgBmi }, {
                duration: 1000,
                step: function() {
                    $this.hcBmiIdx.hcAvgBmi = $this.toNumber(this.val.toFixed(1));
                },
                complete: function() {
                    $this.hcBmiIdx.hcAvgBmi = $this.toNumber(this.val.toFixed(1));
                }
            });
            // 헬스케어 : 성장지수 과성장
            $({ val : 0 }).animate({ val : $this.hcGidx.hcGidxOhigh }, {
                duration: 1000,
                step: function() {
                    $this.hcGidx.hcGidxOhigh = $this.toNumber(this.val.toFixed(1));
                },
                complete: function() {
                    $this.hcGidx.hcGidxOhigh = $this.toNumber(this.val.toFixed(1));
                }
            });
            // 헬스케어 : 성장지수 저성장
            $({ val : 0 }).animate({ val : $this.hcGidx.hcGidxVlow }, {
                duration: 1000,
                step: function() {
                    $this.hcGidx.hcGidxVlow = $this.toNumber(this.val.toFixed(1));
                },
                complete: function() {
                    $this.hcGidx.hcGidxVlow = $this.toNumber(this.val.toFixed(1));
                }
            });
            // 헬스케어 : 비만지수 고도비만
            $({ val : 0 }).animate({ val : $this.hcFidx.hcFidxFfat }, {
                duration: 1000,
                step: function() {
                    $this.hcFidx.hcFidxFfat = $this.toNumber(this.val.toFixed(1));
                },
                complete: function() {
                    $this.hcFidx.hcFidxFfat = $this.toNumber(this.val.toFixed(1));
                }
            });
            // 헬스케어 : 비만지수 비만
            $({ val : 0 }).animate({ val : $this.hcFidx.hcFidxFat }, {
                duration: 1000,
                step: function() {
                    $this.hcFidx.hcFidxFat = $this.toNumber(this.val.toFixed(1));
                },
                complete: function() {
                    $this.hcFidx.hcFidxFat = $this.toNumber(this.val.toFixed(1));
                }
            });
            // 헬스케어 : 비만지수 저체중
            $({ val : 0 }).animate({ val : $this.hcFidx.hcFidxVlow }, {
                duration: 1000,
                step: function() {
                    $this.hcFidx.hcFidxVlow = $this.toNumber(this.val.toFixed(1));
                },
                complete: function() {
                    $this.hcFidx.hcFidxVlow = $this.toNumber(this.val.toFixed(1));
                }
            });
            // 헬스케어 : 비만예측 과체중
            $({ val : 0 }).animate({ val : $this.hcFpidx.hcFpidxFfat }, {
                duration: 1000,
                step: function() {
                    $this.hcFpidx.hcFpidxFfat = $this.toNumber(this.val.toFixed(1));
                },
                complete: function() {
                    $this.hcFpidx.hcFpidxFfat = $this.toNumber(this.val.toFixed(1));
                }
            });
            // 헬스케어 : 비만예측 비만
            $({ val : 0 }).animate({ val : $this.hcFpidx.hcFpidxFat }, {
                duration: 1000,
                step: function() {
                    $this.hcFpidx.hcFpidxFat = $this.toNumber(this.val.toFixed(1));
                },
                complete: function() {
                    $this.hcFpidx.hcFpidxFat = $this.toNumber(this.val.toFixed(1));
                }
            });
            // 헬스케어 : 비만예측 저체중
            $({ val : 0 }).animate({ val : $this.hcFpidx.hcFpidxVlow }, {
                duration: 1000,
                step: function() {
                    $this.hcFpidx.hcFpidxVlow = $this.toNumber(this.val.toFixed(1));
                },
                complete: function() {
                    $this.hcFpidx.hcFpidxVlow = $this.toNumber(this.val.toFixed(1));
                }
            });
            // 헬스케어 : 스트레스 높음
            $({ val : 0 }).animate({ val : $this.hcStrs.hcStrsHigh }, {
                duration: 1000,
                step: function() {
                    $this.hcStrs.hcStrsHigh = $this.toNumber(this.val.toFixed(1));
                },
                complete: function() {
                    $this.hcStrs.hcStrsHigh = $this.toNumber(this.val.toFixed(1));
                }
            });
            // 헬스케어 : 스트레스 매우높음
            $({ val : 0 }).animate({ val : $this.hcStrs.hcStrsOhigh }, {
                duration: 1000,
                step: function() {
                    $this.hcStrs.hcStrsOhigh = $this.toNumber(this.val.toFixed(1));
                },
                complete: function() {
                    $this.hcStrs.hcStrsOhigh = $this.toNumber(this.val.toFixed(1));
                }
            });
            // 헬스케어 : 평균_운동시간 차이
            $({ val : 0 }).animate({ val : $this.hcAvgAct.hcAvgActDif }, {
                duration: 1000,
                step: function() {
                    $this.hcAvgAct.hcAvgActDif = $this.toNumber(this.val.toFixed(1));
                },
                complete: function() {
                    $this.hcAvgAct.hcAvgActDif = $this.toNumber(this.val.toFixed(1));
                }
            });
            // 헬스케어 : 평균_운동시간 평균
            $({ val : 0 }).animate({ val : $this.hcAvgAct.hcAvgAct }, {
                duration: 1000,
                step: function() {
                    $this.hcAvgAct.hcAvgAct = $this.toNumber(this.val.toFixed(1));
                },
                complete: function() {
                    $this.hcAvgAct.hcAvgAct = $this.toNumber(this.val.toFixed(1));
                }
            });
            // 헬스케어 : 평균_운동시간 전일
            $({ val : 0 }).animate({ val : $this.hcAvgAct.hcPdayAvgAct }, {
                duration: 1000,
                step: function() {
                    $this.hcAvgAct.hcPdayAvgAct = $this.toNumber(this.val.toFixed(1));
                },
                complete: function() {
                    $this.hcAvgAct.hcPdayAvgAct = $this.toNumber(this.val.toFixed(1));
                }
            });
            // 헬스케어 : 평균_칼로리_섭취 차이
            $({ val : 0 }).animate({ val : $this.hcAvgCalEat.hcCalEatDif }, {
                duration: 1000,
                step: function() {
                    $this.hcAvgCalEat.hcCalEatDif = $this.toNumber(this.val.toFixed(1));
                },
                complete: function() {
                    $this.hcAvgCalEat.hcCalEatDif = $this.toNumber(this.val.toFixed(1));
                }
            });
            // 헬스케어 : 평균_칼로리_섭취 평균
            $({ val : 0 }).animate({ val : $this.hcAvgCalEat.hcCalEat }, {
                duration: 1000,
                step: function() {
                    $this.hcAvgCalEat.hcCalEat = $this.toNumber(this.val.toFixed(1));
                },
                complete: function() {
                    $this.hcAvgCalEat.hcCalEat = $this.toNumber(this.val.toFixed(1));
                }
            });
            // 헬스케어 : 평균_칼로리_섭취 전일
            $({ val : 0 }).animate({ val : $this.hcAvgCalEat.hcPdayCalEat }, {
                duration: 1000,
                step: function() {
                    $this.hcAvgCalEat.hcPdayCalEat = $this.toNumber(this.val.toFixed(1));
                },
                complete: function() {
                    $this.hcAvgCalEat.hcPdayCalEat = $this.toNumber(this.val.toFixed(1));
                }
            });
            // 헬스케어 : 주요식단_TOP3 TOP1
            $({ val : 0 }).animate({ val : $this.hcFmenuTop3.hcEatCnt1 }, {
                duration: 1000,
                step: function() {
                    $this.hcFmenuTop3.hcEatCnt1 = $this.toNumber(this.val.toFixed(1));
                },
                complete: function() {
                    $this.hcFmenuTop3.hcEatCnt1 = $this.toNumber(this.val.toFixed(1));
                }
            });
            // 헬스케어 : 주요식단_TOP3 TOP2
            $({ val : 0 }).animate({ val : $this.hcFmenuTop3.hcEatCnt2 }, {
                duration: 1000,
                step: function() {
                    $this.hcFmenuTop3.hcEatCnt2 = $this.toNumber(this.val.toFixed(1));
                },
                complete: function() {
                    $this.hcFmenuTop3.hcEatCnt2 = $this.toNumber(this.val.toFixed(1));
                }
            });
            // 헬스케어 : 주요식단_TOP3 TOP3
            $({ val : 0 }).animate({ val : $this.hcFmenuTop3.hcEatCnt3 }, {
                duration: 1000,
                step: function() {
                	if ($this.hcFmenuTop3.hcEatFoodNm1 == null || $this.hcFmenuTop3.hcEatFoodNm1 == '') $this.hcFmenuTop3.hcEatFoodNm1 = "(식단없음)";
                	if ($this.hcFmenuTop3.hcEatFoodNm2 == null || $this.hcFmenuTop3.hcEatFoodNm2 == '') $this.hcFmenuTop3.hcEatFoodNm2 = "(식단없음)";
                	if ($this.hcFmenuTop3.hcEatFoodNm3 == null || $this.hcFmenuTop3.hcEatFoodNm3 == '') $this.hcFmenuTop3.hcEatFoodNm3 = "(식단없음)";
                    $this.hcFmenuTop3.hcEatCnt3 = $this.toNumber(this.val.toFixed(1));
                },
                complete: function() {
                    $this.hcFmenuTop3.hcEatCnt3 = $this.toNumber(this.val.toFixed(1));
                }
            });
            // 헬스케어 : 아침결식율_식단 결식
            $({ val : 0 }).animate({ val : $this.hcMmelNeat.hcNeatHistNeatCnt }, {
                duration: 1000,
                step: function() {
                    $this.hcMmelNeat.hcNeatHistNeatCnt = $this.toNumber(Math.floor(this.val));
                },
                complete: function() {
                    $this.hcMmelNeat.hcNeatHistNeatCnt = $this.toNumber(Math.floor(this.val));
                }
            });
            // 헬스케어 : 아침결식율_식단 대상
            $({ val : 0 }).animate({ val : $this.hcMmelNeat.hcNeatHistObjCnt }, {
                duration: 1000,
                step: function() {
                    $this.hcMmelNeat.hcNeatHistObjCnt = $this.toNumber(Math.floor(this.val));
                },
                complete: function() {
                    $this.hcMmelNeat.hcNeatHistObjCnt = $this.toNumber(Math.floor(this.val));
                }
            });
            // 헬스케어 : 아침결식율_설문 결식
            $({ val : 0 }).animate({ val : $this.hcMmelNeat.hcNeatQustNeatCnt }, {
                duration: 1000,
                step: function() {
                    $this.hcMmelNeat.hcNeatQustNeatCnt = $this.toNumber(Math.floor(this.val));
                },
                complete: function() {
                    $this.hcMmelNeat.hcNeatQustNeatCnt = $this.toNumber(Math.floor(this.val));
                }
            });
            // 헬스케어 : 아침결식율_설문 대상
            $({ val : 0 }).animate({ val : $this.hcMmelNeat.hcNeatQustObjCnt }, {
                duration: 1000,
                step: function() {
                    $this.hcMmelNeat.hcNeatQustObjCnt = $this.toNumber(Math.floor(this.val));
                },
                complete: function() {
                    $this.hcMmelNeat.hcNeatQustObjCnt = $this.toNumber(Math.floor(this.val));
                }
            });

            // 차트 텍스트 : 가동현황 가동율
            $({ val : 0 }).animate({ val : $this.bandOperStat.bandOperRt }, {
                duration: 1000,
                step: function() {
                    $this.bandOperStat.bandOperRt = $this.toNumber(this.val.toFixed(1));
                },
                complete: function() {
                    $this.bandOperStat.bandOperRt = $this.toNumber(this.val.toFixed(1));
                }
            });
            // 차트 텍스트 : 헬스케어_활용율 성장/비만
            $({ val : 0 }).animate({ val : $this.hcUseRt.hcUseGfixRt }, {
                duration: 1000,
                step: function() {
                    $this.hcUseRt.hcUseGfixRt = $this.toNumber(this.val.toFixed(1));
                },
                complete: function() {
                    $this.hcUseRt.hcUseGfixRt = $this.toNumber(this.val.toFixed(1));
                }
            });
            // 차트 텍스트 : 헬스케어_활용율 비만예측
            $({ val : 0 }).animate({ val : $this.hcUseRt.hcUseFatpRt }, {
                duration: 1000,
                step: function() {
                    $this.hcUseRt.hcUseFatpRt = $this.toNumber(this.val.toFixed(1));
                },
                complete: function() {
                    $this.hcUseRt.hcUseFatpRt = $this.toNumber(this.val.toFixed(1));
                }
            });
            // 차트 텍스트 : 헬스케어_활용율 스트레스
            $({ val : 0 }).animate({ val : $this.hcUseRt.hcUseStrsRt }, {
                duration: 1000,
                step: function() {
                    $this.hcUseRt.hcUseStrsRt = $this.toNumber(this.val.toFixed(1));
                },
                complete: function() {
                    $this.hcUseRt.hcUseStrsRt = $this.toNumber(this.val.toFixed(1));
                }
            });
            // 차트 텍스트 : 위험안전탐지율 - 공공안전
            $({ val : 0 }).animate({ val : $this.dgsfDtct.gorgSzon }, {
                duration: 1000,
                step: function() {
                    $this.dgsfDtct.gorgSzon = $this.toNumber(this.val.toFixed(1));
                },
                complete: function() {
                    $this.dgsfDtct.gorgSzon = $this.toNumber(this.val.toFixed(1));
                }
            });
            // 차트 텍스트 : 위험안전탐지율 - 공공위험
            $({ val : 0 }).animate({ val : $this.dgsfDtct.gorgDzon }, {
                duration: 1000,
                step: function() {
                    $this.dgsfDtct.gorgDzon = $this.toNumber(this.val.toFixed(1));
                },
                complete: function() {
                    $this.dgsfDtct.gorgDzon = $this.toNumber(this.val.toFixed(1));
                }
            });
            // 차트 텍스트 : 위험안전탐지율 - 보호자안전
            $({ val : 0 }).animate({ val : $this.dgsfDtct.guarSzon }, {
                duration: 1000,
                step: function() {
                    $this.dgsfDtct.guarSzon = $this.toNumber(this.val.toFixed(1));
                },
                complete: function() {
                    $this.dgsfDtct.guarSzon = $this.toNumber(this.val.toFixed(1));
                }
            });
            // 차트 텍스트 : 위험안전탐지율 - 보호자위험
            $({ val : 0 }).animate({ val : $this.dgsfDtct.guarDzon }, {
                duration: 1000,
                step: function() {
                    $this.dgsfDtct.guarDzon = $this.toNumber(this.val.toFixed(1));
                },
                complete: function() {
                    $this.dgsfDtct.guarDzon = $this.toNumber(this.val.toFixed(1));
                }
            });
            // 차트 텍스트 : 헬스케어 - 성장지수
            $({ val : 0 }).animate({ val : $this.hcGidx.hcGidxAvg }, {
                duration: 1000,
                step: function() {
                    $this.hcGidx.hcGidxAvg = $this.toNumber(this.val.toFixed(1));
                },
                complete: function() {
                    $this.hcGidx.hcGidxAvg = $this.toNumber(this.val.toFixed(1));
                }
            });
            // 차트 텍스트 : 헬스케어 - 비만지수
            $({ val : 0 }).animate({ val : $this.hcFidx.hcFidxAvg }, {
                duration: 1000,
                step: function() {
                    $this.hcFidx.hcFidxAvg = $this.toNumber(this.val.toFixed(1));
                },
                complete: function() {
                    $this.hcFidx.hcFidxAvg = $this.toNumber(this.val.toFixed(1));
                }
            });
            // 차트 텍스트 : 헬스케어 - 비만예측
            $({ val : 0 }).animate({ val : $this.hcFpidx.hcFpidxAvg }, {
                duration: 1000,
                step: function() {
                    $this.hcFpidx.hcFpidxAvg = $this.toNumber(this.val.toFixed(1));
                },
                complete: function() {
                    $this.hcFpidx.hcFpidxAvg = $this.toNumber(this.val.toFixed(1));
                }
            });
            // 차트 텍스트 : 헬스케어 - 스트레스
            $({ val : 0 }).animate({ val : $this.hcStrs.hcStrsAvg }, {
                duration: 1000,
                step: function() {
                    $this.hcStrs.hcStrsAvg = $this.toNumber(this.val.toFixed(1));
                },
                complete: function() {
                    $this.hcStrs.hcStrsAvg = $this.toNumber(this.val.toFixed(1));
                }
            });
            // 차트 텍스트 : 헬스케어 - 아침결식율_식단
            $({ val : 0 }).animate({ val : $this.hcMmelNeat.hcNeatHistNeatRt }, {
                duration: 1000,
                step: function() {
                    $this.hcMmelNeat.hcNeatHistNeatRt = $this.toNumber(this.val.toFixed(1));
                },
                complete: function() {
                    $this.hcMmelNeat.hcNeatHistNeatRt = $this.toNumber(this.val.toFixed(1));
                }
            });
            // 차트 텍스트 : 헬스케어 - 아침결식율_설문
            $({ val : 0 }).animate({ val : $this.hcMmelNeat.hcNeatQustNeatRt }, {
                duration: 1000,
                step: function() {
                    $this.hcMmelNeat.hcNeatQustNeatRt = $this.toNumber(this.val.toFixed(1));
                },
                complete: function() {
                    $this.hcMmelNeat.hcNeatQustNeatRt = $this.toNumber(this.val.toFixed(1));
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
