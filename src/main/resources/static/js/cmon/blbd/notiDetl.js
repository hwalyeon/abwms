let notiDetl = new Vue({
    el: "#notiDetlPopup",
    data: {
    	userInfo: {
    		crud: 'C',
			blbdNo:'',
    		blbdStrtDt:'',
			blbdExprDt:'',
			blbdTypeCd:'',
			blbdTitl:'',
			blbdCntn:'',
			srchCnt:'',
			alamYn:'',
			regDt:'',
			regTm:'',
			regUserId:'',
			uptDt:'',
			uptTm:'',
			uptUserId:'',
    		checkDupUserId: 'N'
    	},
		code: {
			useYnList: []
		}
	},
	components: {'summer-note': summernote },
    methods: {

        initialize: function() {
        	
        	let $this = this;
        	
        	$this.initCodeList();      
        	        	
        },
        initCodeList: function() {
        },
        initPage: function(blbdNo) {
        	
        	let $this = this;
        	$this.resetUserInfo();

        	
        	if ( !WebUtil.isNull(blbdNo) )
    		{
        		let params = {
        			'blbdNo' : blbdNo
        		}
        		
        		AjaxUtil.post({
                    url: "/cmon/blbd/searchUserInfo.ab",
                    param: params,
                    success: function(response) {
                    	if ( !!response.rtnData.result ) {
                    		$this.userInfo.crud = 'U';
                    		$.each(response.rtnData.result, function(key, val) {
            					$this.userInfo[key] = val;
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
        	
        	if ( WebUtil.isNull($this.userInfo.svrId) ) {
        		Swal.alert(['서버ID를 입력하세요.', 'info']);
        		return false;
        	}

			if ( WebUtil.isNull($this.userInfo.svrNm) ) {
				Swal.alert(['서버명을 입력하세요.', 'info']);
				return false;
			}

			if ( WebUtil.isNull($this.userInfo.apiUrl) ) {
				Swal.alert(['API-URL 입력하세요.', 'info']);
				return false;
			}

			if ( WebUtil.isNull($this.userInfo.gpsBaseCycl) ) {
				Swal.alert(['GPS정기핑 기본 주기를 입력하세요.', 'info']);
				return false;
			}

			if ( WebUtil.isNull($this.userInfo.gpsNextCycl) ) {
				Swal.alert(['GPS정기핑 다음 주기를 입력하세요.', 'info']);
				return false;
			}

			if ( WebUtil.isNull($this.userInfo.rdetNextCycl) ) {
				Swal.alert(['정기판정 다음 주기를 입력하세요.', 'info']);
				return false;
			}

			if ( WebUtil.isNull($this.userInfo.rdetBaseCycl) ) {
				Swal.alert(['정기판정 기본 주기를 입력하세요.', 'info']);
				return false;
			}

			if ( WebUtil.isNull($this.userInfo.ledSlepTcnt) ) {
				Swal.alert(['LED슬립시간을 입력하세요.', 'info']);
				return false;
			}

			if ( WebUtil.isNull($this.userInfo.msorSsngLevl) ) {
				Swal.alert(['모션센서 감지 레벨을 입력하세요.', 'info']);
				return false;
			}

			if ( WebUtil.isNull($this.userInfo.hsorIsngCycl) ) {
				Swal.alert(['심박센서 내부감지 주기를 입력하세요.', 'info']);
				return false;
			}

			if ( WebUtil.isNull($this.userInfo.tsorIsngCycl) ) {
				Swal.alert(['체온센서 내부감지 주기를 입력하세요.', 'info']);
				return false;
			}

			if ( WebUtil.isNull($this.userInfo.tsorEvntMinval) ) {
				Swal.alert(['체온센서 이벤트 하한값을 입력하세요.', 'info']);
				return false;
			}

			if ( WebUtil.isNull($this.userInfo.tsorEvntMaxval) ) {
				Swal.alert(['체온센서 이벤트 상한값을 입력하세요.', 'info']);
				return false;
			}

			if ( WebUtil.isNull($this.userInfo.hbitcntMdanMinval) ) {
				Swal.alert(['심박수 중간값 하한값을 입력하세요.', 'info']);
				return false;
			}

			if ( WebUtil.isNull($this.userInfo.hbitcntMdanMaxval) ) {
				Swal.alert(['심박수 중간값 상한값을 입력하세요.', 'info']);
				return false;
			}

			if ( WebUtil.isNull($this.userInfo.msorEvntMinval) ) {
				Swal.alert(['모션센서 이벤트 하한값을 입력하세요.', 'info']);
				return false;
			}

			if ( WebUtil.isNull($this.userInfo.msorEvntMaxval) ) {
				Swal.alert(['모션센서 이벤트 상한값을 입력하세요.', 'info']);
				return false;
			}
        	
        	return true;
        },
        searchDupUserId: function() {
        	let $this = this;
			
        	if ( WebUtil.isNull($this.userInfo.svrId) ) {
        		Swal.alert(['서버ID를 입력하세요.', 'info']);
        		return false;
        	}
			
        	let params = {
				svrId : $this.userInfo.svrId
        	}
        	
			AjaxUtil.post({
                url: "/cmon/blbd/searchDupUserId.ab",
                param: params,
                success: function(response) {
                	if ( response.rtnData.result.existsYn === 'N' ) {
                		$this.userInfo.checkDupUserId = 'Y';
                		Swal.alert(['해당 아이디는 사용할 수 있습니다.', 'success']);
                	} else {
                		$this.userInfo.svrId = '';
                		Swal.alert(['해당 아이디는 이미 사용중입니다.', 'info']);
                	}
                },
                error: function (response) {
                	Swal.alert([response, 'error']);
                }
            });
        },
		saveUser: function() {
			
			let $this = this;
			
            if ( !this.isValid() ) {
                return false;
            }
			
            if ( $this.userInfo.crud === 'C' ) {
	            if ( $this.userInfo.checkDupUserId != 'Y' ) {
	        		Swal.alert(['ID 중복체크를 하세요.', 'info']);
	        		return false;
	        	}
	            if ( isValidEmail($this.userInfo.apiUrl)==false){
	            	Swal.alert(['이메일을 형식에 맞춰 입력 하세요','info']);
	            	return false;
	            }
            }
            

            
			AjaxUtil.post({
                url: "/cmon/blbd/saveUser.ab",
                param: $this.userInfo,
                success: function(response) {
                	Swal.alert(['저장이 완료되었습니다.', 'success']).then(function() {
                		closeModal($('#apiStndDetlPopup'));
               		 	apiStndMng.searchUserList(true);
                	});                	
                },
                error: function (response) {
                	Swal.alert([response, 'error']);
                }
            });
		},
		deleteUser: function() {
			
			let $this = this;
			
			$this.userInfo.crud = 'D';
			
            AjaxUtil.post({
                url: "/cmon/blbd/saveUser.ab",
                param: $this.userInfo,
                success: function(response) {
                	Swal.alert(['삭제가 완료되었습니다.', 'success']).then(function() {
                		 closeModal($('#apiStndDetlPopup'));
						apiStndMng.searchUserList(true);
                	});                	
                },
                error: function (response) {
                	Swal.alert([response, 'error']);
                }
            });
		},
		resetUserInfo: function() {
			this.userInfo = {
				crud: 'C',
				svrId:'',
				svrNm:'',
	    		checkDupUserId: 'N'
	    	}
		},
		userIdChk : function(){
	      const reg = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;

	      if(reg.exec(this.userInfo.userId)!==null){
	    	  this.userInfo.userId = '';
	    	  Swal.alert(["아이디에 한글은 사용할 수 없습니다.", 'info']);
	      }
		}
    },
    computed: {

    },
    watch: {
    	'userInfo.svrId': function(newVal, oldVal) {
    		this.userInfo.checkDupUserId = 'N';
    	}
    },
    mounted: function() {
        let self = this;
        $(document).ready(function() {
            self.initialize();
        });
    }
});
