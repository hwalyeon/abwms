let prntInfoDetl = new Vue({
    el: "#prntInfoDetlPopup",
    data: {
    	params: {
    		crud           : 'C',
    		userId         : '' ,
    		guarNo         : '' , //보호자_번호
    		guarNm         : '' , //보호자_명
			guarTelNo      : '' , //보호자_전화_번호    		
    		guarPw         : '' , //보호자_비밀번호
			selfCertDttm   : '' , //본인_인증_일시
			autoLoginYn    : '' , //자동_로그인_여부
			devcCertVal    : '' , //장치_인증_값
    		raceDivCd      : '' , //인종_구분_코드
    		sexCd          : '' , //성별_코드
			hghtVal        : '' , //키_값
			wghtVal		   : '' , //체중_값
			bmiVal		   : '' , //BMI_값
			sposNo		   : '' , //배우자_번호
			dzoneMoinAlamYn: '' , //위험지역_진입_알림_여부
			dzoneMoutAlamYn: '' , //위험지역_이탈_알림_여부
			szoneMoinAlamYn: '' , //세이프존_진입_알림_여부
			szoneMoutAlamYn: '' , //세이프존_이탈_알림_여부
			fallOccrAlamYn : '' , //낙상_발생_알림_여부
			strsAbnmAlamYn : '' , //스트레스_이상_알림_여부
			selfCertDttm   : '' , //가입_일자
			relsResnCntn   : '' , //해지_일자
			relsResnCd     : '' , //해지_사유_코드
			relsResnCntn   : '' , //해지_사유_내용
			entrStatCd     : '' , //가입_상태_코드
			checkDupGuarNo : '' , //보호자_번호_확인_여부
			existsYn       : '' , //중복_여부
			paging         : 'Y',
			totalCoun      : 0  ,
			rowCount       : 30 ,
			currentPage    : 1  ,
			currentIndex   : 0
    	},
		code: {
			sexCdList      : [] , //성별_코드_리스트
			raceDivCdList  : [] , //인종_구분_코드_리스트
			entrStatCdList : []   //인종_구분_코드_리스트
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
			getCommonCodeList('SEX_CD', $this.code.sexCdList);          //성별_코드_리스트
			getCommonCodeList('RACE_DIV_CD', $this.code.raceDivCdList); //인종_구분_코드_리스트
			getCommonCodeList('ENTR_STAT_CD', $this.code.entrStatCdList);   //가입_상태_코드_리스트

		},
		initValue()
		{
			let $this = this;
			$this.userId = SessionUtil.getUserId();
		},
        initPage: function(guarNo) {

			let $this = this;
			$this.resetPrntDetlInfo();

			if ( !WebUtil.isNull(guarNo) )
			{
				let params = {
					'guarNo' : guarNo
				}
				AjaxUtil.post({
					url: "/user/prnt/prntInfoMng/searchPrntInfo.ab",
					param: params,
					success: function(response) {
						if ( !!response.rtnData.result )
						{
							$this.params.crud = 'U';

							$.each(response.rtnData.result.result, function(key, val) {
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
        	
        	if ( WebUtil.isNull($this.params.guarNo) ) {
        		Swal.alert(['보호자 번호는 필수 입력 값입니다.', 'info']);
        		return false;
        	}
        	if ( WebUtil.isNull($this.params.autoLoginYn) ) {
        		Swal.alert(['자동로그인 여부는 필수 입력 값입니다.', 'info']);
        		return false;
        	}
        	if ( WebUtil.isNull($this.params.hghtVal) ) {
        		Swal.alert(['키값은 필수 입력 값입니다.', 'info']);
        		return false;
        	}
        	if ( WebUtil.isNull($this.params.wghtVal) ) {
        		Swal.alert(['체중값은 여부는 필수 입력 값입니다.', 'info']);
        		return false;
        	}
        	if ( WebUtil.isNull($this.params.bmiVal) ) {
        		Swal.alert(['BMI값은 필수 입력 값입니다.', 'info']);
        		return false;
        	}
        	if ( WebUtil.isNull($this.params.dzoneMoinAlamYn) ) {
        		Swal.alert(['위험지역 진입 알림 여부는 필수 입력 값입니다.', 'info']);
        		return false;
        	}
        	if ( WebUtil.isNull($this.params.dzoneMoutAlamYn) ) {
        		Swal.alert(['위험지역 이탈 알림 여부는 필수 입력 값입니다.', 'info']);
        		return false;
        	}
        	if ( WebUtil.isNull($this.params.szoneMoinAlamYn) ) {
        		Swal.alert(['세이프존 진입 알림 여부는 필수 입력 값입니다.', 'info']);
        		return false;
        	}
        	if ( WebUtil.isNull($this.params.szoneMoutAlamYn) ) {
        		Swal.alert(['세이프존 이탈 알림 여부는 필수 입력 값입니다.', 'info']);
        		return false;
        	}
        	if ( WebUtil.isNull($this.params.fallOccrAlamYn) ) {
        		Swal.alert(['낙상 발생 알림 여부는 필수 입력 값입니다.', 'info']);
        		return false;
        	}
        	if ( WebUtil.isNull($this.params.strsAbnmAlamYn) ) {
        		Swal.alert(['스트레스 이상 알림 여부는 필수 입력 값입니다.', 'info']);
        		return false;
        	}



        	return true;
        },
		//보호자(사용자)_번호_확인
		searchDupGuarNo: function()
		{
        	let $this = this;

        	if ( WebUtil.isNull($this.params.guarNo) ) {
        		Swal.alert(['보호자 번호를 입력하세요.', 'info']);
        		return false;
        	}

			AjaxUtil.post({
                url: "/user/prnt/prntInfoMng/searchDupGuarNo.ab",
                param: $this.params,
                success: function(response) {
                	if ( response.rtnData.result.existsYn === 'N' ) {
                		$this.params.checkDupGuarNo = 'Y';
                		Swal.alert(['해당 번호는 사용할 수 있습니다.', 'success']);
                	} else {
                		$this.params.guarNo = '';
                		Swal.alert(['해당 번호는 이미 사용중입니다.', 'info']);
                	}
                },
                error: function (response) {
                	Swal.alert([response, 'error']);
                }
            });
        },
		numberingSelect: function(){
        let $this =this;
        $this.params.bandId = '';
		},
		//보호자(사용자)_번호_채번
		numberingGuarNo: function()
		{
			let $this = this;
			$this.params.checkDupGuarNo = 'N';
			$this.params.guarNo = '';

			AjaxUtil.post({
				url: "/user/prnt/pantInfoMng/numberingGuarNo.ab",
				param: $this.params,
				success: function(response) {
					if ( !!response.rtnData.result) {
					$this.params.guarNo = response.rtnData.result.guarNo;
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
			let cdNm;
			if(isNaN($this.params[name])){

				if(name=='guarNo'){
					cdNm='보호자 번호';
				}else if(name=='guarTelNo'){
					cdNm='보호자 전화번호';
				}else if(name=='selfCertDttm'){
					cdNm='본인 인증 일시';
				}else if(name=='hghtVal'){
					cdNm='키';
				}else if(name=='wghtVal'){
					cdNm='몸무게';
				}else if(name=='bmiVal'){
					cdNm='BMI';
				}else if(name=='sposNo'){
					cdNm='배우자 번호';
				}

				this.params[name] = this.params[name].replace(/\D/g,'');
				Swal.alert([cdNm+"는 숫자만 사용 가능합니다.", 'info']);
			}

			if(name=='bandId'){
				$this.params.bandYtypCd ='';
				$this.params.bandMdlCd  ='';
			}
		},
		saveprntInfoDetl: function() {
			
			let $this = this;
			
            if ( !this.isValid() ) {
                return false;
            }
            if ( $this.params.crud === 'C' ) {
	            if ( $this.params.checkDupGuarNo != 'Y' ) {
	        		Swal.alert(['보호자 번호 확인을 하지 않았습니다.', 'info']);
	        		return false;
	        	}
				if($this.params.guarNo == $this.params.guarNoTemp) {
					Swal.alert(['보호자 번호 확인을 하지 않았습니다.', 'info']);
						return false;
				}
            }

			AjaxUtil.post({
                url: "/user/prnt/prntInfoMng/savePrntInfoDetl.ab",
                param: $this.params,
                success: function(response) {
                	Swal.alert(['저장이 완료되었습니다.', 'success']).then(function() {
                		closeModal($('#prntInfoDetlPopup'));
						prntInfoMng.searchPrntInfoList(true);
                	});                	
                },
                error: function (response) {
                	Swal.alert([response, 'error']);
                }
            });
		},

		deleteUser: function() {
			
			let $this = this;
			
			$this.params.crud = 'D';
			
            AjaxUtil.post({
                url: "/user/prnt/prntInfoMng/saveBandOpenInfoDetl.ab",
                param: $this.params,
                success: function(response) {
                	Swal.alert(['삭제가 완료되었습니다.', 'success']).then(function() {
                		 closeModal($('#bandOpenInfoDetlPopup'));
						bandOpenInfoMng.searchBandOpenInfoList(true);
                	});
                },
                error: function (response) {
                	Swal.alert([response, 'error']);
                }
            });
		},
		resetPrntDetlInfo: function() {
			this.params = {
				crud           : 'C',
				userId         : '' ,
				guarNo         : '' , //보호자_번호
				guarNm         : '' , //보호자_명
				guarTelNo      : '' , //보호자_전화_번호
				guarPw         : '' , //보호자_비밀번호
				selfCertDttm   : '' , //본인_인증_일시
				autoLoginYn    : '' , //자동_로그인_여부
				devcCertVal    : '' , //장치_인증_값
				raceDivCd      : '' , //인종_구분_코드
				sexCd          : '' , //성별_코드
				checkDupGuarNo : '' , //밴드ID_확인_여부

	    	}
		},
    },
    computed: {

    },
    watch: {
    	'params.bandId': function(newVal, oldVal) {
    		this.params.checkDupGuarNo = 'N';
		},


    },
    mounted: function() {
        let self = this;
        $(document).ready(function() {
            self.initialize();
        });
    }
});
