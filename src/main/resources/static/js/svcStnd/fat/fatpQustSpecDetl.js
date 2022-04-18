let fatpQustSpecDetl = new Vue({
    el  : "#fatpQustSpecDetlPopup",
    data:
	{
    	params:
		{
			crud         : 'C' ,
			qustVer      : ''  , //설문_버전
			qustNo       : ''  , //설문_번호
			ansSeq       : ''  , //답변_순번
			ansVal       : ''  , //답변_값
			ansCntn      : ''  , //답변_내용
    	}
	},
	
    methods: {

        initialize: function() {
        	
        	let $this = this;

        },
        initPage: function(qustVer, qustNo, ansSeq) {

        	let $this = this;
        	$this.resetData();

        	if ( !WebUtil.isNull(ansSeq) )
    		{
        		let params = {
        			'qustVer' : qustVer ,
					'qustNo'  : qustNo  ,
					'ansSeq'  : ansSeq
        		}
        		AjaxUtil.post({
                    url    : "/svcStnd/fat/fatpQustMng/searchFatpQustSpecInfo.ab",
                    param  : params,
					success: function(response) {
						if ( response.rtnData.result != null ) {
							$this.params.crud= 'U'
							$.each(response.rtnData.result, function(key, val) {
								$this.params[key] = val;
							});
						}
					},
                    error: function (response) {
                    	Swal.alert([response, 'error']);
                    }
                });

    		}else
    			{
				$this.params.qustVer = qustVer;
				$this.params.qustNo  = qustNo;
			}
        },
        isValid: function() {
        	
        	let $this = this;
        	if ( WebUtil.isNull($this.params.qustVer) ) {
        		Swal.alert(['_설문 버전은 필수 입력입니다.', 'info']);
        		return false;
        	}else if ( WebUtil.isNull($this.params.qustNo) ) {
        		Swal.alert(['_설문 번호은 필수 입력입니다.', 'info']);
        		return false;
			}else if ( WebUtil.isNull($this.params.ansSeq) ) {
				Swal.alert(['답변 순번은 필수 입력입니다.', 'info']);
				return false;
        	}else {
        			return true;
        		}
        },
		//비만예측_설문_상세_정보_저장
		saveFatpQustSpecDetl: function() {
			
			let $this = this;
            if ( !this.isValid() ) {
                return false;
            }
			
			AjaxUtil.post({
                url: "/svcStnd/fat/fatpQustMng/saveFatpQustSpecDetl.ab",
                param: $this.params,
                success: function(response) {
                	Swal.alert(['저장이 완료되었습니다.', 'success']).then(function() {
                		 closeModal($('#fatpQustSpecDetlPopup'));
                		 fatpQustMng.searchFatpQustBaseList(true);
                		 fatpQustMng.searchFatpQustSpecList(true);
                	});
                },
                error: function (response) {
                	Swal.alert([response, 'error']);
                }
            });
		},
		//비만예측_설문_상세_정보_삭제
		deleteFatpQustSpecDetl: function() {
			
			let $this = this;
			
			$this.params.crud = 'D';
			
			AjaxUtil.post({
                url: "/svcStnd/fat/fatpQustMng/saveFatpQustSpecDetl.ab",
                param: $this.params,
                success: function(response) {
                	Swal.alert(['삭제가 완료되었습니다.', 'success']).then(function() {
                		 closeModal($('#fatpQustSpecDetlPopup'));
						 fatpQustMng.searchFatpQustBaseList(true);
                		 fatpQustMng.searchFatpQustSpecList(true);
                	});
                },
                error: function (response) {
                	Swal.alert([response, 'error']);
                }
            });
		},
		resetData: function() {
        	let $this = this;

			$this.params =
			{
				crud         : 'C' ,
				qustVer      : ''  , //설문_버전
				qustNo       : ''  , //설문_번호
				ansSeq       : ''  , //답변_순번
				ansVal       : ''  , //답변_값
				ansCntn      : ''  , //답변_내용
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
