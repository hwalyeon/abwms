let bandOpenInfoDetl = new Vue({
    el: "#bandOpenInfoDetlPopup",
    data: {
    	params: {
    		crud           : 'C',
			userId         : '' ,
			bandId         : '' ,  //밴드_ID
			bandYtypCd     : '' ,  //밴드_출고_년월
			bandMdlCd      : '' ,  //밴드_모델_코드
			telNo          : '' ,  //밴드_전화_번호
			guarTelNo      : '' ,  //보호자_전화_번호
			bandOpenStatCd : '' ,  //밴드_개통_상태_코드
			checkDupBandId : '' ,  //밴드ID_확인_여부
			paging         : 'Y',
			totalCoun      : 0  ,
			rowCount       : 30 ,
			currentPage    : 1  ,
			currentIndex   : 0
    	},
		code: {
			bandOpenStatCdList : [] , //밴드_개통_상태_코드_리스트
			bandYtypCdList     : [] , //밴드_출고년월_리스트
			bandMdlCdList      : [] , //밴드_모델_코드_리스트
		}
	},
    methods: {

        initialize: function() {
        	
        	let $this = this;

        	$this.initValue();
        	$this.initCodeList();      
        	        	
        },
        initCodeList: function() {

        	let $this = this;
			getCommonCodeList('BAND_MDL_CD', $this.code.bandMdlCdList);  //밴드_모델_코드_리스트
			getCommonCodeList('BAND_OPEN_STAT_CD', $this.code.bandOpenStatCdList);//밴드_개통_상태_코드_리스트

		},
		initValue()
		{
			let $this = this;
			$this.initBandYtypCdValue();
		},
        initPage: function(bandId) {

			let $this = this;
			$this.resetBandOpenInfo();
        	/*


        	
        	if ( !WebUtil.isNull(userId) )
    		{
        		let params = {
        			'userId' : userId
        		}
        		
        		AjaxUtil.post({
                    url: "/set/userMng/searchBandOpenInfo.ab",
                    param: params,
                    success: function(response) {
                    	if ( !!response.rtnData.result ) {
                    		$this.params.crud = 'U';
                    		$.each(response.rtnData.result, function(key, val) {
            					$this.params[key] = val;
            				});
                    	}                    		
                    },
                    error: function (response) {
                    	Swal.alert([response, 'error']);
                    }
                });
    		}*/
        },

		//출고_년월_리스트_값 세팅
		initBandYtypCdValue: function() {
			let $this = this;
			for (let i = 2022; i < 2032; i++) {
				let cdVal;
				let cdNm;
				for (let j = 1; j < 13; j++) {
					if (j < 10) {
						cdVal = i + '0' + j;
						cdNm = i + '-0' + j;
						$this.code.bandYtypCdList.push({'cdVal': cdVal, 'cdNm': cdNm});
					} else {
						cdVal = String(i) + j;
						cdNm = i + '-' + j;
						$this.code.bandYtypCdList.push({'cdVal': cdVal, 'cdNm': cdNm});
					}
				}
			}
		},
			isValid: function() {
        /*
        	let $this = this;        	        	
        	
        	if ( WebUtil.isNull($this.params.userId) ) {
        		Swal.alert(['사용자ID를 입력하세요.', 'info']);
        		return false;
        	}
        	
        	if ( WebUtil.isNull($this.params.userNm) ) {
        		Swal.alert(['사용자명을 입력하세요.', 'info']);
        		return false;
        	}
        	
        	if ( WebUtil.isNull($this.params.userPw) ) {
        		Swal.alert(['비밀번호를 입력하세요.', 'info']);
        		return false;
        	}
        	
        	if ( WebUtil.isNull($this.params.blngNm) ) {
        		Swal.alert(['소속을 입력하세요.', 'info']);
        		return false;
        	}
        	
        	if ( WebUtil.isNull($this.params.telNo) ) {
        		Swal.alert(['전화번호를 입력하세요.', 'info']);
        		return false;
        	}
        	
        	if ( WebUtil.isNull($this.params.mtelNo) ) {
        		Swal.alert(['휴대전화번호를 입력하세요.', 'info']);
        		return false;
        	}
        	
        	if ( WebUtil.isNull($this.params.mailAddr) ) {
        		Swal.alert(['이메일을 입력하세요.', 'info']);
        		return false;
        	}
        	
        	if ( WebUtil.isNull($this.params.useYn) ) {
        		Swal.alert(['사용여부를 선택하세요.', 'info']);
        		return false;
        	}
*/
        	// 학원/강사/학생 여부를 라디오로 변경하고 저장시에 값을 셋팅해주어야 함
        	
        	return true;
        },
		//밴드 ID 중복 검사
		searchDupBandId: function()
		{

        	let $this = this;

			let bandIdStr = $this.params.bandId.substr(1,1);

        	if ( WebUtil.isNull($this.params.bandId) ) {
        		Swal.alert(['밴드ID를 입력하세요.', 'info']);
        		return false;
        	}if($this.params.bandId.length != 10) {
        		Swal.alert(['밴드ID의 자리수는 10자리입니다.', 'info']);
        		return false;
        	}if(bandIdStr != 0 && bandIdStr != 1 ) {
				Swal.alert(['밴드ID의 2번째 자리는 0,1 중 선택해야 합니다.', 'info']);
				return false;
			}
        	let params = {
        		bandId : $this.params.bandId
        	}
			AjaxUtil.post({
                url: "/devc/band/bandOpenInfoMng/searchDupBandId.ab",
                param: $this.params,
                success: function(response) {
                	if ( response.rtnData.result.existsYn === 'N' ) {
                		$this.params.checkDupBandId = 'Y';
                		Swal.alert(['해당 아이디는 사용할 수 있습니다.', 'success']);
                	} else {
                		$this.params.userId = '';
                		Swal.alert(['해당 아이디는 이미 사용중입니다.', 'info']);
                	}
                },
                error: function (response) {
                	Swal.alert([response, 'error']);
                }
            });
        },
		//밴드ID 채번
		numberingBandId: function()
		{
			let $this = this;

			AjaxUtil.post({
				url: "/devc/band/bandOpenInfoMng/numberingBandId.ab",
				param: $this.params,
				success: function(response) {
					if ( !!response.rtnData.result ) {
						console.log(response.rtnData.result.bandId);
					}
				},
				error: function (response) {
					Swal.alert([response, 'error']);
				}
			});
		},
		//숫자타입 체크
		nanCk : function(event)
		{
			let $this = this;

			let name  = event.target.name;

			if(isNaN($this.params[name])){

				this.params[name] = this.params[name].replace(/\D/g,'');
				Swal.alert(["숫자를 입력해주세요.", 'info']);
			}
		},
		saveBandOpenInfoDetl: function() {
			
			let $this = this;
			
            if ( !this.isValid() ) {
                return false;
            }
			
            if ( $this.params.crud === 'C' ) {
	            if ( $this.params.checkDupBandId != 'Y' ) {
	        		Swal.alert(['ID 확인을 하지 않았습니다.', 'info']);
	        		return false;
	        	}
	            if ( isValidPhoneNumber($this.params.telNo)==false) {
	            	Swal.alert(['전화번호를 형식에 맞춰 입력 하세요','info']);
	            	return false;
	            }
            }
/*
			AjaxUtil.post({
                url: "/set/userMng/saveUser.ab",
                param: $this.params,
                success: function(response) {
                	Swal.alert(['저장이 완료되었습니다.', 'success']).then(function() {
                		closeModal($('#userDetlPopup'));
               		 	userMng.searchUserList(true);
                	});                	
                },
                error: function (response) {
                	Swal.alert([response, 'error']);
                }
            });*/
		},

		deleteUser: function() {
			
			let $this = this;
			
			$this.params.crud = 'D';
			
            AjaxUtil.post({
                url: "/set/userMng/saveUser.ab",
                param: $this.params,
                success: function(response) {
                	Swal.alert(['삭제가 완료되었습니다.', 'success']).then(function() {
                		 closeModal($('#userDetlPopup'));
                		 userMng.searchUserList(true);
                	});                	
                },
                error: function (response) {
                	Swal.alert([response, 'error']);
                }
            });
		},
		resetBandOpenInfo: function() {
			this.params = {
				crud           : 'C',
				userId         : '' ,
				bandId         : '' ,  //밴드_ID
				bandYtypCd     : '' ,  //밴드_출고_년월
				bandMdlCd      : '' ,  //밴드_모델_코드
				telNo          : '' ,  //밴드_전화_번호
				guarTelNo      : '' ,  //보호자_전화_번호
				bandOpenStatCd : 'STBY' ,  //밴드_개통_상태_코드
				paging         : 'Y',
				totalCoun      : 0  ,
				rowCount       : 30 ,
				currentPage    : 1  ,
				currentIndex   : 0 ,
	    		checkDupUserId: 'N'
	    	}
		},
    },
    computed: {

    },
    watch: {
    	'params.bandId': function(newVal, oldVal) {
    		this.params.checkDupUserId = 'N';
		},

		'params.bandId':function(){
    		if(this.params.bandId != null)
    		{
    			this.params.bandYtypCd = '';
    			this.params.bandMdlCd = '';

			}},
		'params.bandYtypCd' :function(){
		if(this.params.bandYtypCd != null)
			{
				this.params.bandId = '';
			}
		},
		'params.bandMdlCd' :function(){
		if(this.params.bandMdlCd != null)
			{
				this.params.bandId = '';
			}
		}

    },
    mounted: function() {
        let self = this;
        $(document).ready(function() {
            self.initialize();
        });
    }
});
