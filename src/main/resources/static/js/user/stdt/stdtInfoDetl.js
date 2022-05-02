let stdtInfoDetl = new Vue({
    el: "#stdtInfoDetlPopup",
    data: {
		stdtInfo: {
    		crud      : 'C',
			stdtNo    : '',
			stdtNm    : '',
			eorgLocNm : '',
			sgrdCd    : '',
			bithDt    : '',
			raceDivCd : '',
			sexCd     : '',
			hghtVal   : '',
			wghtVal   : '',
			wastVal   : '',
			guarNo    : '',
			guarNm    : '',
			guarTelNo : '',
			prntNo    : '',
			prntMale  : '',
			prntFemale : '',
			bandId    : '',
			bandTelNo : '',
			bandStatNm : '-',
			bandCommDttm : '',
			plcClssNm : '',
			locNm     : '',
			latLonVal : '',
			occrDttm  : '',
			dgemStatNm : '',
			locMesuDttm : '',
			growJudgNm : '',
			gfixUptDttm : '',
			fatJudgNm : '',
			fatpJudgNm : '',
			gfixUptDttm : '',
			avgHbitCnt : '',
			mentStrsStatNm : '',
			physStrsStatNm : '',
			strsCopeStatNm : '',
			strsUptDttm : ''
    	},
		code: {
			 sexCdList: []
			,sgrdCdList: []
			,raceDivCdList : []
		},
		selectItem: {
			text: '',
			value: '',
		},
		params :{
    		crud : ''
		},
		chartBand: null,
		chartLoc : null,
		chartDgem : null,
		chartGrow : null,
		chartFat : null,
		chartNutrEat : null,
		chartStrs : null,
		callBack : null
	},

    methods: {

        initialize: function() {

        	let $this = this;

        	$this.initCodeList();
		//	$this.initChart();
        },
        initCodeList: function() {
        	let $this = this;

			getCommonCodeList('SEX_CD',$this.code.sexCdList);
			getCommonCodeList('SGRD_CD',$this.code.sgrdCdList);
			getCommonCodeList('RACE_DIV_CD',$this.code.raceDivCdList);
        },
        initPage: function(stdtNo, guarNo, callback) {
        	let $this = this;

			if(typeof callback === 'function')
			{
				$this.callBack = callback;
			}

			$this.resetParam();
			$this.initChart();
			$this.searchStdtDetlInfo(stdtNo, guarNo);
        },
        isValid: function() {
        	let $this = this;
        },

		textCenter : function (chartDivId , txt , chartId, color, fontSize, fontStyle ){
			var ctx = document.getElementById(chartDivId).getContext('2d');

			var fontSizeTemp = fontSize || '20';
			var fontStyleTemp = fontStyle || 'Arial';

			if(txt != null && txt.length > 3){
				fontSizeTemp = 15;
			}

			ctx.textAlign = 'center';
			ctx.textBaseline = 'middle';
			var centerX = ((chartId.chartArea.left + chartId.chartArea.right) / 2);
			var centerY = ((chartId.chartArea.top + chartId.chartArea.bottom) / 2);

			//반도넛일 경우
			// if (chart.config.options.rotation === Math.PI && chart.config.options.circumference === Math.PI) {
			// 	centerY = ((chart.chart.legend.chartArea.top + chart.chart.legend.chartArea.bottom) / 1.3);
			// }
			ctx.font = fontSizeTemp + "px " + fontStyleTemp;
			ctx.fillStyle = color;
			ctx.fillText(txt, centerX, centerY);
		},

		searchStdtDetlInfo : function (stdtNo, guarNo){
        	let $this = this;

			if ( !WebUtil.isNull(stdtNo) )
			{
				let params = {
					'stdtNo' : stdtNo
					,'guarNo' : guarNo
				}

				AjaxUtil.post({
					url: "/user/stdt/stdtInfoMng/searchStdtDetlInfo.ab",
					param: params,
					success: function(response) {
						if ( !!response.rtnData.result ) {
							$this.stdtInfo.crud = 'U';
							$.each(response.rtnData.result, function(key, val) {
								$this.stdtInfo[key] = val;
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

		initChart: function() {
        	let $this = this;
			if ($this.chartBand != null ) $this.chartBand.destroy();
			if ($this.chartLoc != null )  $this.chartLoc.destroy();
			if ($this.chartDgem != null )  $this.chartDgem.destroy();
			if ($this.chartGrow != null )  $this.chartGrow.destroy();
			if ($this.chartFat != null )  $this.chartFat.destroy();
			if ($this.chartStrs != null )  $this.chartStrs.destroy();

		},

		updateChart : function (){
			let $this = this;
			let bandChartColor = '#65D965';
			let locChartColor = '#f1071b';
			let dgemChartColor = '#65D965';
			let growChartColor = '#65D965';
			let fatChartColor = '#65D965';

			let TempChartColor = '#989998';
			let locTxt = '!';
			let dgemModIdx = 100 - $this.stdtInfo.dgemIdx;

			let bandStatNm = '-';
			if(WebUtil.isNotNull($this.stdtInfo.bandStatNm)) bandStatNm = $this.stdtInfo.bandStatNm;

			let growModIdx = 0;
			if ($this.stdtInfo.gidx > 100 ) growModIdx = 0;
			else if ($this.stdtInfo.gidx < 0 ) growModIdx = 100;
			else growModIdx = 100 - $this.stdtInfo.gidx;

			let fatModIdx = 0;
			if ($this.stdtInfo.fidx > 100 ) fatModIdx = 0;
			else if ($this.stdtInfo.fidx < 0 ) fatModIdx = 100;
			else fatModIdx = 100 - $this.stdtInfo.fidx;

			// 밴드정보
			if($this.stdtInfo.bandStatCd === 'NORM')  bandChartColor = '#2a99ec';
			else if ($this.stdtInfo.bandStatCd === 'LOWB') bandChartColor = '#f3e24a';
			else if ($this.stdtInfo.bandStatCd === 'DISC' ) bandChartColor = '#f1071b';


			// 학생위치
			if($this.stdtInfo.plcClssCd === 'SZONE') { locChartColor = '#2a99ec'; locTxt = 'OK'}
			else if($this.stdtInfo.plcClssCd === 'NZONE') { locChartColor = '#f3e24a'; locTxt = '-'}
			else if($this.stdtInfo.plcClssCd === 'DZONE') { locChartColor = '#f1071b'; locTxt = '!'}

			if($this.stdtInfo.dgemStatCd === 'NORM') dgemChartColor = '#2a99ec';
			else if ($this.stdtInfo.dgemStatCd === 'CHK') dgemChartColor = '#65D965';
			else if ($this.stdtInfo.dgemStatCd === 'WARN') dgemChartColor = '#f3e24a';
			else if ($this.stdtInfo.dgemStatCd === 'PDNGR') dgemChartColor = '#fc8f46';
			else if ($this.stdtInfo.dgemStatCd === 'DNGR') dgemChartColor = '#f1071b';

			if($this.stdtInfo.growJudgCd === 'VLOW') growChartColor = '#2a99ec';
			else if ($this.stdtInfo.growJudgCd === 'LOW') growChartColor = '#65D965';
			else if ($this.stdtInfo.growJudgCd === 'AVG') growChartColor = '#f3e24a';
			else if ($this.stdtInfo.growJudgCd === 'HIGH') growChartColor = '#fc8f46';
			else if ($this.stdtInfo.growJudgCd === 'OHIGH') growChartColor = '#f1071b';


			if($this.stdtInfo.fatJudgCd === 'VLOW') fatChartColor = '#2a99ec';
			else if ($this.stdtInfo.fatJudgCd === 'LOW') fatChartColor = '#65D965';
			else if ($this.stdtInfo.fatJudgCd === 'AVG') fatChartColor = '#f3e24a';
			else if ($this.stdtInfo.fatJudgCd === 'HIGH') fatChartColor = '#fc8f46';
			else if ($this.stdtInfo.fatJudgCd === 'OHIGH') fatChartColor = '#f1071b';



			let dataBand = {
				labels : ['상태'],
				datasets: [{
					data: [10],
					backgroundColor: [bandChartColor],
					borderColor : [bandChartColor]
				}]
			};

			let dataLoc = {
				labels : ['상태'],
				datasets: [{
					data: [10],
					backgroundColor: [locChartColor],
					borderColor : [locChartColor]
				}]
			};

			let dataDgem = {
				labels : ['상태','상태'],
				datasets: [{
					data: [$this.stdtInfo.dgemIdx ,dgemModIdx],
					backgroundColor: [dgemChartColor , TempChartColor],
					borderColor : [dgemChartColor, TempChartColor]
				}]
			};

			let dataGrow = {
				labels : ['상태','상태'],
				datasets: [{
					data: [$this.stdtInfo.gidx ,growModIdx],
					backgroundColor: [growChartColor , TempChartColor],
					borderColor : [growChartColor, TempChartColor]
				}]
			};

			let dataFat = {
				labels : ['상태','상태'],
				datasets: [{
					data: [$this.stdtInfo.fidx ,fatModIdx],
					backgroundColor: [fatChartColor , TempChartColor],
					borderColor : [fatChartColor, TempChartColor]
				}]
			};

			let dataStrs = {
				labels : ['정신','신체','대처능력'],
				datasets: [{
					data: [$this.stdtInfo.mindStrsPnt ,$this.stdtInfo.physStrsPnt , $this.stdtInfo.strsCopePnt],
					backgroundColor: ['#2a99ec' , '#f3e24a','#65D965'],
					borderColor : ['#2a99ec', '#f3e24a', '#65D965']
				}]
			};

			let options = {
				responsive : false,
				plugins: {
					legend: {
						display : false
					},
					tooltip : {
						enabled : false
					}
				},
				cutout: 40
			};

			let optionsBar = {
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
			};

			let ctxBand = document.getElementById('bandStatChart').getContext('2d');
			let ctxLoc = document.getElementById('stdtLocChart').getContext('2d');
			let ctxDgem = document.getElementById('dgemChart').getContext('2d');
			let ctxGrow = document.getElementById('growChart').getContext('2d');
			let ctxFat = document.getElementById('fatChart').getContext('2d');
			let ctxStrs = document.getElementById('strsChart').getContext('2d');

			let pluginsBand = [{
				beforeDraw: function () {
					$this.textCenter('bandStatChart', bandStatNm, $this.chartBand, bandChartColor, '' , '');
				}
			}];

			let pluginsLoc = [{
				beforeDraw: function () {
					$this.textCenter('stdtLocChart', locTxt, $this.chartLoc, locChartColor, '' , '');
				}
			}];

			let pluginsDgem = [{
				beforeDraw: function () {
					let dgemIdx = '-';
					if($this.stdtInfo.dgemIdx != null ) dgemIdx = $this.stdtInfo.dgemIdx;
					$this.textCenter('dgemChart', dgemIdx, $this.chartDgem, dgemChartColor, '' , '');
				}
			}];

			let pluginsGrow = [{
				beforeDraw: function () {
					let gidx = '-';
					if($this.stdtInfo.gidx != null ) gidx = $this.stdtInfo.gidx;
					$this.textCenter('growChart', gidx, $this.chartGrow, growChartColor, '' , '');
				}
			}];

			let pluginsFat = [{
				beforeDraw: function () {
					let fidx = '-';
					if($this.stdtInfo.fidx != null ) fidx = $this.stdtInfo.fidx;
					$this.textCenter('fatChart', fidx, $this.chartFat, fatChartColor, '' , '');
				}
			}];

			let configBand = {
				type : 'doughnut',
				data : dataBand,
				options: options,
				plugins: pluginsBand
			};

			let configLoc = {
				type : 'doughnut',
				data : dataLoc,
				options: options,
				plugins: pluginsLoc
			};

			let configDgem = {
				type : 'doughnut',
				data : dataDgem,
				options: options,
				plugins: pluginsDgem
			};

			let configGrow = {
				type : 'doughnut',
				data : dataGrow,
				options: options,
				plugins: pluginsGrow
			};

			let configFat = {
				type : 'doughnut',
				data : dataFat,
				options: options,
				plugins: pluginsFat
			};

			let configStrs = {
				type : 'bar',
				data : dataStrs,
				options: optionsBar,
				plugins: [{}]
			};

			if ($this.chartBand != null ) $this.chartBand.destroy();
			if ($this.chartLoc != null )  $this.chartLoc.destroy();
			if ($this.chartDgem != null )  $this.chartDgem.destroy();
			if ($this.chartGrow != null )  $this.chartGrow.destroy();
			if ($this.chartFat != null )  $this.chartFat.destroy();
			if ($this.chartStrs != null )  $this.chartStrs.destroy();

			$this.chartBand = new Chart(ctxBand, configBand);
			$this.chartLoc = new Chart(ctxLoc, configLoc);
			$this.chartDgem = new Chart(ctxDgem, configDgem);
			$this.chartGrow = new Chart(ctxGrow, configGrow);
			$this.chartFat = new Chart(ctxFat, configFat);
			$this.chartStrs = new Chart(ctxStrs, configStrs);

			const growCntn = document.getElementById('growCntn');
			growCntn.innerHTML = $this.stdtInfo.smryCntn;

			const fatCntn = document.getElementById('fatCntn');
			fatCntn.innerHTML = $this.stdtInfo.currEvalCntn;

			const dgemCntn = document.getElementById('dgemCntn');
			dgemCntn.innerHTML = $this.stdtInfo.dgemStatCntn;
		},

		saveStdtDetlInfo : function (){
        	let $this = this;

			AjaxUtil.post({
				url: "/user/stdt/stdtInfoMng/saveStdtInfo.ab",
				param: $this.stdtInfo,
				success: function(response) {
					Swal.alert(['저장이 완료되었습니다.', 'success']).then(function() {
						closeModal($('#stdtInfoDetlPopup'));
						if($this.callBack != null ) $this.callBack();
					});
				},
				error: function (response) {
					Swal.alert([response, 'error']);
				}
			});
		},

		stdtInfoEorgLocPop : function (){
			let $this = this;
			locSearchPopup.initPage( { callback : function(rowData) {
				$this.stdtInfo.eorgLocNo = rowData.locNo;
				$this.stdtInfo.eorgLocNm = rowData.locNm;
			}});
		},

		resetParam: function() {
			let $this = this;
			$this.stdtInfo = {
				crud    : 'C',
				stdtNo  : '',
				stdtNm  : '',
				eorgLocNm : '',
				sgrdCd  : '',
				bithDt  : '',
				raceDivCd : '',
				sexCd   : '',
				hghtVal : '',
				wghtVal : '',
				wastVal : '',
				guarNo  : '',
				guarNm  : '',
				guarTelNo : '',
				prntNo  : '',
				prntMale : '',
				prntFemale : '',
				bandId  : '',
				bandTelNo : '',
				bandStatNm  : '-',
				bandCommDttm : '',
				plcClssNm : '',
				locNm   : '',
				latLonVal : '',
				occrDttm : '',
				dgemStatNm : '',
				locMesuDttm : '',
				growJudgNm : '',
				gfixUptDttm : '',
				fatJudgNm : '',
				fatpJudgNm : '',
				gfixUptDttm : '',
				avgHbitCnt : '',
				mentStrsStatNm : '',
				physStrsStatNm : '',
				strsCopeStatNm : '',
				strsUptDttm : ''
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
