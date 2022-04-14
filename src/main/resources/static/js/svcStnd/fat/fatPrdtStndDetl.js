let fatPrdtStndDetl = new Vue({
    el: "#fatPrdtStndDetlPopup",
    data: {
    	params: {
			crud: 'C',
            userId          : '' ,
			fatJudgCd       : '' , //비만_판정_코드
			fatpJudgCd      : '' , //비만예측_판정_코드
			fatPrdtSmryCntn : '' , //요약_내용
			fatPrdtStatCntn : '' , //상세_내용
     	},
		summerNoteFatPrdtStnd1 : 'summerNoteFatPrdtStnd1' ,
		summerNoteFatPrdtStnd2 : 'summerNoteFatPrdtStnd2'

	},

	components: {'summer-note': summernote},
    methods: {

        initialize: function() {

        	let $this = this;

        },
        initPage: function(fatJudgCd, fatpJudgCd) {
        	
        	let $this = this;
        	$this.resetFatPrdtStndInfo();

        	if ( !WebUtil.isNull(fatJudgCd, fatpJudgCd) )
    		{	
        	
        		let params = {
        			'fatJudgCd'  : fatJudgCd   ,
        			'fatpJudgCd' : fatpJudgCd ,
        		}
        		AjaxUtil.post({
                    url: "/svcStnd/fat/fatPrdtStndMng/searchFatPrdtList.ab",
                    param: params,
                    success: function(response) {
                    	if ( !!response.rtnData.result ) {
                    		$this.params.crud = 'U';
                    		$.each(response.rtnData.result[0], function(key, val) {
            					$this.params[key] = val;
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
        	

        	
        	return true;
        },

		saveInfo: function() {

			let $this = this;

            if ( !this.isValid() ) {
                return false;
            }

			AjaxUtil.post({
                url: "/svcStnd/dgem/dgemStndMng/saveInfo.ab",
                param: $this.params,
                success: function(response) {
                	Swal.alert(['저장이 완료되었습니다.', 'success']).then(function() {
                		closeModal($('#dgemStndDetlPopup'));
						dgemStndMng.searchDgemList(true);
                	});                	
                },
                error: function (response) {
                	Swal.alert([response, 'error']);
                }
            });

		},
		searchDupCdCk: function()
        {

            let $this = this;
            let param = $this.params

            AjaxUtil.post({
                url: "/svcStnd/dgem/dgemStndMng/searchDupCdCk.ab",
                param: $this.params,
                success: function(response) {
                    if ( response.rtnData.result.existsYn === 'Y' ) {
                        return false;
                    } else {
                        return true;
                    }
                },
                error: function (response) {
                    Swal.alert([response, 'error']);
                }
            });
        },

		deleteInfo: function() {
			
			let $this = this;
			
			$this.params.crud = 'D';
			
            AjaxUtil.post({
                url: "/svcStnd/dgem/dgemStndMng/saveInfo.ab",
                param: $this.params,
                success: function(response) {
                	Swal.alert(['삭제가 완료되었습니다.', 'success']).then(function() {
                		 closeModal($('#dgemStndDetlPopup'));
                		 dgemStndMng.searchDgemList(true);
                	});                	
                },
                error: function (response) {
                	Swal.alert([response, 'error']);
                }
            });
		},
		resetFatPrdtStndInfo: function() {
			this.params = {
				crud: 'C',
				userId          : '' ,
				fatJudgCd       : '' , //비만_판정_코드
				fatpJudgCd      : '' , //비만예측_판정_코드
				fatPrdtSmryCntn : '' , //요약_내용
				fatPrdtStatCntn : '' , //상세_내용
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
