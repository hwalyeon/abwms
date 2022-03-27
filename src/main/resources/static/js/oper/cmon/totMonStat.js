let totMonStat = new Vue({
    el: "#totMonStat",
    data: {
        totMonStat: {
            temp        : null,
            tmpDngrSafeOcrrTd : '',
            tmpDngrSafeOcrrDif : '',
            tmpDngrSafeOcrrYav : '3.8'
        },
        code: {
            // sexCdList: []
        },
        selectItem: {
            text        : '',
            value       : '',
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
        chartOperStat       : null,
        chartOpenStat       : null,
        chartGrowFat        : null,
        chartFatPrdt        : null,
        chartStrs           : null,
        chartDngrSafeOccr   : null
    },
    methods: {

        initialize: function() {
            let $this = this;

            $this.initCodeList();
            $this.initPage();
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
            stdtNo = 1;
            guarNo = 1;
            if ( !WebUtil.isNull(stdtNo) )
            {
                let params = {
                    'stdtNo'    : stdtNo
                    ,'guarNo'   : guarNo
                }

                AjaxUtil.post({
                    url: "/user/stdt/stdtInfoMng/searchStdtDetlInfo.ab",
                    param: params,
                    success: function(response) {
                        if ( !!response["rtnData"].result ) {
                            $.each(response["rtnData"].result, function(key, val) {
                                $this.totMonStat[key] = val;
                            });
                            $this.updateChart();
                        }
                    },
                    error: function (response) {
                        Swal.alert([response, 'error']);
                        closeModal($('#stdtInfoDetlPopup'));
                    }
                });
            }
        },
        updateChart : function() {
            let $this = this;

            let TempChartColor      = '#989998';
            let operStatChartColor  = '#65D965';

            if ($this.totMonStat.growJudgCd !== 'VLOW') {
                if      ($this.totMonStat.growJudgCd === 'LOW')   operStatChartColor = '#65D965';
                else if ($this.totMonStat.growJudgCd === 'AVG')   operStatChartColor = '#f3e24a';
                else if ($this.totMonStat.growJudgCd === 'HIGH')  operStatChartColor = '#fc8f46';
                else if ($this.totMonStat.growJudgCd === 'OHIGH') operStatChartColor = '#f1071b';
            } else {
                operStatChartColor = '#2a99ec';
            }

            let colorRed = '#f1071b';
            let colorGre = '#65D965';
            let colorBlu = '#2a99ec';
            let colorYel = '#f3e24a';
            let colorOra = '#fc8f46';
            let colorGra = '#989998';
            let colorBla = '#000000';
            let colorWhi = '#ffffff';

            let tmpGrowFatIdx       = 80;
            let tmpFatPrdtIdx       = 70;
            let tmpStrsIdx          = 90;
            let tmpDngrSafeOcrrTd   = 1100;
            let tmpDngrSafeOcrrAv   = 1400;
            $this.totMonStat.tmpDngrSafeOcrrTd = $this.toNumber(tmpDngrSafeOcrrTd);
            $this.totMonStat.tmpDngrSafeOcrrDif = tmpDngrSafeOcrrAv - tmpDngrSafeOcrrTd;

            let operStatModIdx  = $this.chartPerModIdx($this.totMonStat.growIdx, 100);
            let growFatModIdx   = $this.chartPerModIdx(tmpGrowFatIdx);
            let fatPrdtModIdx   = $this.chartPerModIdx(tmpFatPrdtIdx);
            let strsModIdx      = $this.chartPerModIdx(tmpStrsIdx);

            let dataOperStat = {
                labels              : ['가동','무응답'],
                datasets: [{
                    data            : [$this.totMonStat.growIdx , operStatModIdx],
                    backgroundColor : [operStatChartColor       , TempChartColor],
                    borderColor     : [operStatChartColor       , TempChartColor],
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
                    borderWidth     : 10
                }]
            };

            let pluginsOperStat = [{
                beforeDraw: function () {
                    let srcIdx = '-';
                    if($this.totMonStat.growIdx != null ) srcIdx = $this.totMonStat.growIdx;
                    $this.textCenter('operStatChart', srcIdx, $this.chartOperStat, operStatChartColor, '' , '');
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
                options : $this.options,
                plugins : pluginsStrs
            };

            // let configStrs = {
            //     type     : 'bar',
            //     data     : dataStrs,
            //     options  : optionsBar,
            //     plugins  : [{}]
            // };

            let ctxOperStat     = document.getElementById('operStatChart').getContext('2d');
            let ctxOpenStat     = document.getElementById('openStatChart').getContext('2d');
            let ctxGrowFat      = document.getElementById('growFatChart').getContext('2d');
            let ctxFatPrdt      = document.getElementById('fatPrdtChart').getContext('2d');
            let ctxStrs         = document.getElementById('strsChart').getContext('2d');
            let ctxDngrSafeOccr = document.getElementById('dngrSafeOccrChart').getContext('2d');

            if ($this.chartOperStat     != null )   $this.chartOperStat.destroy();
            if ($this.chartOpenStat     != null )   $this.chartOpenStat.destroy();
            if ($this.chartGrowFat      != null )   $this.chartGrowFat.destroy();
            if ($this.chartFatPrdt      != null )   $this.chartFatPrdt.destroy();
            if ($this.chartStrs         != null )   $this.chartStrs.destroy();
            if ($this.chartDngrSafeOccr != null )   $this.chartDngrSafeOccr.destroy();

            $this.chartOperStat         = new Chart(ctxOperStat     , configOperStat);
            $this.chartOpenStat         = new Chart(ctxOpenStat     , configOpenStat);
            $this.chartGrowFat          = new Chart(ctxGrowFat      , configGrowFat);
            $this.chartFatPrdt          = new Chart(ctxFatPrdt      , configFatPrdt);
            $this.chartStrs             = new Chart(ctxStrs         , configStrs);
            $this.chartDngrSafeOccr     = new Chart(ctxDngrSafeOccr , configDngrSafeOccr);
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
        toNumber: function (value) {
            return value.toLocaleString('ko-KR');
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
