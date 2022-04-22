let apiStndDetl = new Vue({
    el: "#apiStndDetlPopup",
    data: {
    	apiInfo: {
    		crud: 'C',
			svrId:'',
    		svrNm:'',
			apiUrl:'',
			gpsBaseCycl:'',
			gpsNextCycl:'',
			rdetNextCycl:'',
			rdetBaseCycl:'',
			ledSlepTcnt:'',
			msorSsngLevl:'',
			hsorIsngCycl:'',
			tsorIsngCycl:'',
			tsorEvntMinval:'',
			tsorEvntMaxval:'',
			hbitcntMdanMinval:'',
			hbitcntMdanMaxval:'',
			msorEvntMinval:'',
			msorEvntMaxval:'',
    		checkDupUserId: 'N'
    	},
		code: {
			useYnList: []
		}
	},
	
    methods: {

        initialize: function() {
        	
        	let $this = this;
        	
        	$this.initCodeList();      
        	        	
        },
        initCodeList: function() {
        },
        initPage: function(svrId) {
        	
        	let $this = this;
        	$this.resetUserInfo();

        	
        	if ( !WebUtil.isNull(svrId) )
    		{
        		let params = {
        			'svrId' : svrId
        		}
        		
        		AjaxUtil.post({
                    url: "/cmon/stnd/searchApiInfo.ab",
                    param: params,
                    success: function(response) {
                    	if ( !!response.rtnData.result ) {
                    		$this.apiInfo.crud = 'U';
                    		$.each(response.rtnData.result, function(key, val) {
            					$this.apiInfo[key] = val;
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
        	
        	if ( WebUtil.isNull($this.apiInfo.svrId) ) {
        		Swal.alert(['서버ID를 입력하세요.', 'info']);
        		return false;
        	}

			if ( WebUtil.isNull($this.apiInfo.svrNm) ) {
				Swal.alert(['서버명을 입력하세요.', 'info']);
				return false;
			}

			if ( WebUtil.isNull($this.apiInfo.apiUrl) ) {
				Swal.alert(['API-URL 입력하세요.', 'info']);
				return false;
			}

			if ( WebUtil.isNull($this.apiInfo.gpsBaseCycl) ) {
				Swal.alert(['GPS정기핑 기본 주기를 입력하세요.', 'info']);
				return false;
			}

			if ( WebUtil.isNull($this.apiInfo.gpsNextCycl) ) {
				Swal.alert(['GPS정기핑 다음 주기를 입력하세요.', 'info']);
				return false;
			}

			if ( WebUtil.isNull($this.apiInfo.rdetNextCycl) ) {
				Swal.alert(['정기판정 다음 주기를 입력하세요.', 'info']);
				return false;
			}

			if ( WebUtil.isNull($this.apiInfo.rdetBaseCycl) ) {
				Swal.alert(['정기판정 기본 주기를 입력하세요.', 'info']);
				return false;
			}

			if ( WebUtil.isNull($this.apiInfo.ledSlepTcnt) ) {
				Swal.alert(['LED슬립시간을 입력하세요.', 'info']);
				return false;
			}

			if ( WebUtil.isNull($this.apiInfo.msorSsngLevl) ) {
				Swal.alert(['모션센서 감지 레벨을 입력하세요.', 'info']);
				return false;
			}

			if ( WebUtil.isNull($this.apiInfo.hsorIsngCycl) ) {
				Swal.alert(['심박센서 내부감지 주기를 입력하세요.', 'info']);
				return false;
			}

			if ( WebUtil.isNull($this.apiInfo.tsorIsngCycl) ) {
				Swal.alert(['체온센서 내부감지 주기를 입력하세요.', 'info']);
				return false;
			}

			if ( WebUtil.isNull($this.apiInfo.tsorEvntMinval) ) {
				Swal.alert(['체온센서 이벤트 하한값을 입력하세요.', 'info']);
				return false;
			}

			if ( WebUtil.isNull($this.apiInfo.tsorEvntMaxval) ) {
				Swal.alert(['체온센서 이벤트 상한값을 입력하세요.', 'info']);
				return false;
			}

			if ( WebUtil.isNull($this.apiInfo.hbitcntMdanMinval) ) {
				Swal.alert(['심박수 중간값 하한값을 입력하세요.', 'info']);
				return false;
			}

			if ( WebUtil.isNull($this.apiInfo.hbitcntMdanMaxval) ) {
				Swal.alert(['심박수 중간값 상한값을 입력하세요.', 'info']);
				return false;
			}

			if ( WebUtil.isNull($this.apiInfo.msorEvntMinval) ) {
				Swal.alert(['모션센서 이벤트 하한값을 입력하세요.', 'info']);
				return false;
			}

			if ( WebUtil.isNull($this.apiInfo.msorEvntMaxval) ) {
				Swal.alert(['모션센서 이벤트 상한값을 입력하세요.', 'info']);
				return false;
			}
        	
        	return true;
        },
        searchDupSvrId: function() {
        	let $this = this;
			
        	if ( WebUtil.isNull($this.apiInfo.svrId) ) {
        		Swal.alert(['서버ID를 입력하세요.', 'info']);
        		return false;
        	}
			
        	let params = {
				svrId : $this.apiInfo.svrId
        	}
        	
			AjaxUtil.post({
                url: "/cmon/stnd/searchDupSvrId.ab",
                param: params,
                success: function(response) {
                	if ( response.rtnData.result.existsYn === 'N' ) {
                		$this.apiInfo.checkDupUserId = 'Y';
                		Swal.alert(['해당 아이디는 사용할 수 있습니다.', 'success']);
                	} else {
                		$this.apiInfo.svrId = '';
                		Swal.alert(['해당 아이디는 이미 사용중입니다.', 'info']);
                	}
                },
                error: function (response) {
                	Swal.alert([response, 'error']);
                }
            });
        },
		saveApi: function() {
			
			let $this = this;
			
            if ( !this.isValid() ) {
                return false;
            }
			
            if ( $this.apiInfo.crud === 'C' ) {
	            if ( $this.apiInfo.checkDupUserId != 'Y' ) {
	        		Swal.alert(['ID 중복체크를 하세요.', 'info']);
	        		return false;
	        	}
	            if ( isValidEmail($this.apiInfo.apiUrl)==false){
	            	Swal.alert(['이메일을 형식에 맞춰 입력 하세요','info']);
	            	return false;
	            }
            }
            

            
			AjaxUtil.post({
                url: "/cmon/stnd/saveApi.ab",
                param: $this.apiInfo,
                success: function(response) {
                	Swal.alert(['저장이 완료되었습니다.', 'success']).then(function() {
                		closeModal($('#apiStndDetlPopup'));
               		 	apiStndMng.searchApiList(true);
                	});                	
                },
                error: function (response) {
                	Swal.alert([response, 'error']);
                }
            });
		},
		deleteApi: function() {
			
			let $this = this;
			
			$this.apiInfo.crud = 'D';
			
            AjaxUtil.post({
                url: "/cmon/stnd/saveApi.ab",
                param: $this.apiInfo,
                success: function(response) {
                	Swal.alert(['삭제가 완료되었습니다.', 'success']).then(function() {
                		 closeModal($('#apiStndDetlPopup'));
						apiStndMng.searchApiList(true);
                	});                	
                },
                error: function (response) {
                	Swal.alert([response, 'error']);
                }
            });
		},
		resetUserInfo: function() {
			this.apiInfo = {
				crud: 'C',
				svrId:'',
				svrNm:'',
	    		checkDupUserId: 'N'
	    	}
		},
		userIdChk : function(){
	      const reg = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;

	      if(reg.exec(this.apiInfo.userId)!==null){
	    	  this.apiInfo.userId = '';
	    	  Swal.alert(["아이디에 한글은 사용할 수 없습니다.", 'info']);
	      }
		}
    },
    computed: {

    },
    watch: {
    	'apiInfo.svrId': function(newVal, oldVal) {
    		this.apiInfo.checkDupUserId = 'N';
    	}
    },
    mounted: function() {
        let self = this;
        $(document).ready(function() {
            self.initialize();
        });
    }
});
