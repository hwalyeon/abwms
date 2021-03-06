let fatpQustBaseDetl = new Vue({
    el  : "#fatpQustBaseDetlPopup",
    data:
	{
    	params:
		{
			crud         : 'C' ,
			qustVer      : ''  , //설문_버전
			qustNo       : ''  , //설문_번호
			qustCntn     : ''  , //설문_내용
    	}
	},
	
    methods: {

        initialize: function() {
        	
        	let $this = this;

        },
        initPage: function(qustVer, qustNo) {

        	let $this = this;
        	$this.resetData();
        	
        	if ( !WebUtil.isNull(qustNo) )
    		{
        		let params = {
        			'qustVer' : qustVer ,
					'qustNo'  : qustNo
        		}
        		AjaxUtil.post({
                    url    : "/svcStnd/fat/fatpQustMng/searchFatpQustBaseList.ab",
                    param  : params,
					success: function(response) {
						if ( response.rtnData.result != null ) {
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
        	if ( WebUtil.isNull($this.params.qustVer) ) {
        		Swal.alert(['설문 버전은 필수 입력입니다.', 'info']);
        		return false;
        	}else if ( WebUtil.isNull($this.params.qustNo) ) {
        		Swal.alert(['설문 번호은 필수 입력입니다.', 'info']);
        		return false;
        	}else {
        			return true;
        		}
        },
		//비만예측설문_기본_정보_저장
		saveFatpQustBaseDetl: function() {
			
			let $this = this;
            if ( !this.isValid() ) {
                return false;
            }
			
			AjaxUtil.post({
                url: "/svcStnd/fat/fatpQustMng/saveFatpQustBaseDetl.ab",
                param: $this.params,
                success: function(response) {
                	Swal.alert(['저장이 완료되었습니다.', 'success']).then(function() {
                		 closeModal($('#fatpQustBaseDetlPopup'));
                		 fatpQustMng.searchFatpQustBaseList(true);
                	});                	
                },
                error: function (response) {
                	Swal.alert([response, 'error']);
                }
            });
		},
		//비만예측설문_기본_정보_삭제
		deleteFatpQustBaseDetl: function() {
			
			let $this = this;
			
			$this.params.crud = 'D';
			
			AjaxUtil.post({
                url: "/svcStnd/fat/fatpQustMng/saveFatpQustBaseDetl.ab",
                param: $this.params,
                success: function(response) {
                	Swal.alert(['삭제가 완료되었습니다.', 'success']).then(function() {
                		 closeModal($('#fatpQustBaseDetlPopup'));
                		 fatpQustMng.searchFatpQustBaseList(true);
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
				qustCntn     : ''  , //설문_내용
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
