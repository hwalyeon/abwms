let growActStndDetl = new Vue({
    el: "#growActStndDetlPopup",
    data: {
    	growActStndInfo: {
    		crud			 : 'C',
			growJudgCd       : '' ,    // 성장_판정_코드
			growJudgNm       : '' ,    // 성장_판정_명
			palCd            : '' ,    // 신체활동수준_코드
			palNm            : '' ,    // 신체활동수준_명
			growActRmrk      : ''      // 성장_활동_비고
    	},
		code: {
			growJudgCdList   : [],
			palCdList: []
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
			getCommonCodeList('GROW_JUDG_CD',$this.code.growJudgCdList, '');
			getCommonCodeList('PAL_CD',$this.code.palCdList, '');
        	
        },
        initPage: function(growJudgCd, palCd) {
        	
        	let $this = this;
        	$this.resetGrowActStndInfo();
        	
        	if ( !WebUtil.isNull(growJudgCd) && !WebUtil.isNull(palCd) )
    		{
        		let params = {
					'growJudgCd' 	: growJudgCd,
        			'palCd' 		: palCd
        		}
        		
        		AjaxUtil.post({
                    url: "/svcStnd/act/growActStndMng/searchGrowActStndInfo.ab",
                    param: params,
                    success: function(response) {
                    	if ( !!response["rtnData"].result ) {
                    		$this.growActStndInfo.crud = 'U';
                    		$.each(response["rtnData"].result, function(key, val) {
            					$this.growActStndInfo[key] = val;
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

			if ( WebUtil.isNull($this.growActStndInfo.growJudgCd) ) {
				Swal.alert(['성장판정 코드를 입력하세요.', 'info']);
				return false;
			}

			if ( WebUtil.isNull($this.growActStndInfo.growJudgNm) ) {
				Swal.alert(['성장판정 명을 입력하세요.', 'info']);
				return false;
			}

        	if ( WebUtil.isNull($this.growActStndInfo.palCd) ) {
        		Swal.alert(['신체활동수준 코드를 입력하세요.', 'info']);
        		return false;
        	}

        	if ( WebUtil.isNull($this.growActStndInfo.palNm) ) {
        		Swal.alert(['신체활동수준 명을 입력하세요.', 'info']);
        		return false;
        	}

			if ( WebUtil.isNull($this.growActStndInfo.growActRmrk) ) {
				Swal.alert(['성장활동 비고를 입력하세요.', 'info']);
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
                url: "/svcStnd/act/growActStndMng/saveGrowActStndInfo.ab",
                param: $this.growActStndInfo,
                success: function() {
                	Swal.alert(['저장이 완료되었습니다.', 'success']).then(function() {
                		closeModal($('#growActStndDetlPopup'));
						growActStndMng.searchGrowActStndList(true);
                	});                	
                },
                error: function (response) {
                	Swal.alert([response, 'error']);
                }
            });

		},
		deleteInfo: function() {
			
			let $this = this;
			
			$this.growActStndInfo.crud = 'D';
			
            AjaxUtil.post({
                url: "/svcStnd/act/growActStndMng/saveGrowActStndInfo.ab",
                param: $this.growActStndInfo,
                success: function() {
                	Swal.alert(['삭제가 완료되었습니다.', 'success']).then(function() {
                		 closeModal($('#growActStndDetlPopup'));
                		 growActStndMng.searchGrowActStndList(true);
                	});                	
                },
                error: function (response) {
                	Swal.alert([response, 'error']);
                }
            });
		},
		changePalCd : function (){
			let $this = this;
			$this.growActStndInfo.palNm = WebUtil.getCodeNm($this.code.palCdList, $this.growActStndInfo.palCd);
		},
		changeGrowJudgCd : function (){
			let $this = this;
			$this.growActStndInfo.growJudgNm = WebUtil.getCodeNm($this.code.growJudgCdList, $this.growActStndInfo.growJudgCd);
		},
		resetGrowActStndInfo: function() {
			this.growActStndInfo = {
				crud: 'C',
				growJudgCd       : '' ,    // 성장_판정_코드
				growJudgNm       : '' ,    // 성장_판정_명
				palCd            : '' ,    // 신체활동수준_코드
				palNm            : '' ,    // 신체활동수준_명
				growActRmrk      : ''      // 성장_활동_비고
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
