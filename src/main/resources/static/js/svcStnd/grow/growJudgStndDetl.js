let growJudgStndDetl = new Vue({
    el: "#growJudgStndDetlPopup",
    data: {
    	growJudgStndInfo: {
    		crud: 'C',
			growJudgCd: '',
			growJudgNm: '',
			gidxFr: '',
			gidxTo: '',
			smryCntn: '',
			specCntn: ''
    	},
		code: {
			mentGrowJudgCdList: []
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
			getCommonCodeList('GROW_JUDG_CD',$this.code.mentGrowJudgCdList);
        	
        },
        initPage: function(growJudgCd) {
        	
        	let $this = this;
        	$this.resetGrowJudgStndInfo();

        	
        	if ( !WebUtil.isNull(growJudgCd) )
    		{
        		let params = {
        			'growJudgCd' : growJudgCd
        		}
        		
        		AjaxUtil.post({
                    url: "/svcStnd/grow/growJudgStndMng/searchGrowJudgStndInfo.ab",
                    param: params,
                    success: function(response) {
                    	if ( !!response.rtnData.result ) {
                    		$this.growJudgStndInfo.crud = 'U';
                    		$.each(response.rtnData.result, function(key, val) {
            					$this.growJudgStndInfo[key] = val;
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
        	
        	if ( WebUtil.isNull($this.growJudgStndInfo.growJudgCd) ) {
        		Swal.alert(['성장판정코드 입력하세요.', 'info']);
        		return false;
        	}
        	
        	if ( WebUtil.isNull($this.growJudgStndInfo.gidxFr) ) {
        		Swal.alert(['성장지수_FR를 입력하세요.', 'info']);
        		return false;
        	}
        	
        	if ( WebUtil.isNull($this.growJudgStndInfo.gidxTo) ) {
        		Swal.alert(['성장지수_TO를 입력하세요.', 'info']);
        		return false;
        	}

			if ( WebUtil.isNull($this.growJudgStndInfo.smryCntn) ) {
				Swal.alert(['요약내용를 입력하세요.', 'info']);
				return false;
			}

			if ( WebUtil.isNull($this.growJudgStndInfo.specCntn) ) {
				Swal.alert(['상세내용를 입력하세요.', 'info']);
				return false;
			}

			//성장지수 FR Valid 체크
			var gidxToCheck = isValidNum($this.growJudgStndInfo.gidxTo);
			if (gidxFrCheck == false){
				Swal.alert(['성장지수_FR은 숫자 입력만 가능합니다.','info']);
				$this.growJudgStndInfo.gidxFr = '';
			}
			else{
				return true;
			}
			//성장지수 TO Valid 체크
			var gidxFrCheck = isValidNum($this.growJudgStndInfo.gidxFr);
			if (gidxToCheck == false){
				Swal.alert(['성장지수_TO는 숫자 입력만 가능합니다.','info']);
				$this.growJudgStndInfo.gidxTo = '';
			}
			else{
				return true;
			}

        },

		saveInfo: function() {
			
			let $this = this;

            if ( !this.isValid() ) {
                return false;
            }

			AjaxUtil.post({
                url: "/svcStnd/grow/growJudgStndMng/saveInfo.ab",
                param: $this.growJudgStndInfo,
                success: function(response) {
                	Swal.alert(['저장이 완료되었습니다.', 'success']).then(function() {
                		closeModal($('#growJudgStndDetlPopup'));
						growJudgStndMng.searchGrowJudgList(true);
                	});                	
                },
                error: function (response) {
                	Swal.alert([response, 'error']);
                }
            });

		},
		deleteInfo: function() {
			
			let $this = this;
			
			$this.growJudgStndInfo.crud = 'D';
			
            AjaxUtil.post({
                url: "/svcStnd/grow/growJudgStndMng/saveInfo.ab",
                param: $this.growJudgStndInfo,
                success: function(response) {
                	Swal.alert(['삭제가 완료되었습니다.', 'success']).then(function() {
                		 closeModal($('#growJudgStndDetlPopup'));
                		 growJudgStndMng.searchGrowJudgList(true);
                	});                	
                },
                error: function (response) {
                	Swal.alert([response, 'error']);
                }
            });
		},
		resetGrowJudgStndInfo: function() {
			this.growJudgStndInfo = {
				crud: 'C',
				growJudgCd: '',
				growJudgNm: '',
				gidxFr: '',
				gidxTo: '',
				smryCntn: '',
				specCntn: ''
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
