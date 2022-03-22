let fatActStndDetl = new Vue({
    el: "#fatActStndDetlPopup",
    data: {
		fatActStndInfo: {
    		crud				: 'C',
			currFatJudgCd   	: '' ,    // 현재_비만_판정_코드
			currFatJudgNm    	: '' ,    // 현재_비만_판정_명
			prdtFatJudgCd    	: '' ,    // 예측_비만_판정_코드
			prdtFatJudgNm    	: '' ,    // 예측_비만_판정_명
			palCd            	: '' ,    // 신체활동수준_코드
			palNm            	: '' ,    // 신체활동수준_명
			fatActRmrk       	: ''      // 비만_활동_비고
    	},
		code: {
			fatJudgCdList   : [],
			palCdList		: []
		}
	},
	components: {'summer-note': summernote },
    methods: {

        initialize: function() {
        	
        	let $this = this;
        	
        	$this.initCodeList();      
        	        	
        },
        initCodeList: function() {
        	let $this = this;
			getCommonCodeList('FAT_JUDG_CD',$this.code.fatJudgCdList,'');
			getCommonCodeList('PAL_CD',$this.code.palCdList,'');
        	
        },
        initPage: function(currFatJudgCd, prdtFatJudgCd, palCd) {
        	
        	let $this = this;
        	$this.resetFatActStndInfo();
        	
        	if ( !WebUtil.isNull(currFatJudgCd) && !WebUtil.isNull(prdtFatJudgCd) && !WebUtil.isNull(palCd))
    		{
        		let params = {
					'currFatJudgCd' 	: currFatJudgCd,
					'prdtFatJudgCd' 	: prdtFatJudgCd,
        			'palCd' 			: palCd
        		}
        		AjaxUtil.post({
                    url: "/svcStnd/act/fatActStndMng/searchFatActStndInfo.ab",
                    param: params,
                    success: function(response) {
                    	if ( !!response["rtnData"].result ) {
                    		$this.fatActStndInfo.crud = 'U';
                    		$.each(response["rtnData"].result, function(key, val) {
            					$this.fatActStndInfo[key] = val;
            				});
                    	}                    		
                    },
                    error: function (response) {
                    	Swal.alert([response, 'error']);
                    }
                });
    		}
        },
        isValid: function() {
        	
        	let $this = this;

			if ( WebUtil.isNull($this.fatActStndInfo.currFatJudgCd) ) {
				Swal.alert(['현재비만판정 코드를 입력하세요.', 'info']);
				return false;
			}

			if ( WebUtil.isNull($this.fatActStndInfo.currFatJudgNm) ) {
				Swal.alert(['현재비만판정 명을 입력하세요.', 'info']);
				return false;
			}

			if ( WebUtil.isNull($this.fatActStndInfo.prdtFatJudgCd) ) {
				Swal.alert(['예측비만판정 코드를 입력하세요.', 'info']);
				return false;
			}

			if ( WebUtil.isNull($this.fatActStndInfo.prdtFatJudgNm) ) {
				Swal.alert(['예측비만판정 명을 입력하세요.', 'info']);
				return false;
			}

        	if ( WebUtil.isNull($this.fatActStndInfo.palCd) ) {
        		Swal.alert(['신체활동수준 코드를 입력하세요.', 'info']);
        		return false;
        	}

        	if ( WebUtil.isNull($this.fatActStndInfo.palNm) ) {
        		Swal.alert(['신체활동수준 명을 입력하세요.', 'info']);
        		return false;
        	}

			if ( WebUtil.isNull($this.fatActStndInfo.fatActRmrk) ) {
				Swal.alert(['비만판정 비고를 입력하세요.', 'info']);
				return false;
			}

        	return true;
        },

		saveInfo: function() {
			
			let $this = this;

            if ( !this.isValid() ) {
                return false;
            }

			AjaxUtil.post({
                url: "/svcStnd/act/fatActStndMng/saveFatActStndInfo.ab",
                param: $this.fatActStndInfo,
                success: function() {
                	Swal.alert(['저장이 완료되었습니다.', 'success']).then(function() {
                		closeModal($('#fatActStndDetlPopup'));
						fatActStndMng.searchFatActStndList(true);
                	});                	
                },
                error: function (response) {
                	Swal.alert([response, 'error']);
                }
            });

		},
		deleteInfo: function() {
			
			let $this = this;
			
			$this.fatActStndInfo.crud = 'D';
			
            AjaxUtil.post({
                url: "/svcStnd/act/fatActStndMng/saveFatActStndInfo.ab",
                param: $this.fatActStndInfo,
                success: function() {
                	Swal.alert(['삭제가 완료되었습니다.', 'success']).then(function() {
                		 closeModal($('#fatActStndDetlPopup'));
						fatActStndMng.searchFatActStndList(true);
                	});                	
                },
                error: function (response) {
                	Swal.alert([response, 'error']);
                }
            });
		},
		changePalCd : function (){
			let $this = this;
			$this.fatActStndInfo.palNm = WebUtil.getCodeNm($this.code.palCdList, $this.fatActStndInfo.palCd);
		},
		changeCurrFatJudgCd : function (){
			let $this = this;
			$this.fatActStndInfo.currFatJudgNm = WebUtil.getCodeNm($this.code.fatJudgCdList, $this.fatActStndInfo.currFatJudgCd);
		},
		changePrdtFatJudgCd : function (){
			let $this = this;
			$this.fatActStndInfo.prdtFatJudgNm = WebUtil.getCodeNm($this.code.fatJudgCdList, $this.fatActStndInfo.prdtFatJudgCd);
		},
		resetFatActStndInfo: function() {
			this.fatActStndInfo = {
				crud				: 'C',
				currFatJudgCd   	: '' ,    // 현재_비만_판정_코드
				currFatJudgNm    	: '' ,    // 현재_비만_판정_명
				prdtFatJudgCd    	: '' ,    // 예측_비만_판정_코드
				prdtFatJudgNm    	: '' ,    // 예측_비만_판정_명
				palCd            	: '' ,    // 신체활동수준_코드
				palNm            	: '' ,    // 신체활동수준_명
				fatActRmrk       	: ''      // 비만_활동_비고
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
