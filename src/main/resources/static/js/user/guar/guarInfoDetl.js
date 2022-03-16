let guarInfoDetl = new Vue({
    el: "#guarInfoDetlPopup",
    data: {
    	params: {
    		crud              : 'C',
    		userId            : '' ,
    		stdtNo            : '' , //학생_번호
    		stdtNm            : '' , //학생_명
			prntNo            : '' , //학부모_번호
			guarNo            : '' , //보호자_번호
			guarNm            : '' , //보호자_명
			guarTelNo         : '' , //보호자_전화_번호
    		guarPw            : '' , //보호자_비밀번호
			selfCertDttm      : '' , //본인_인증_일시
			autoLoginYn       : '' , //자동_로그인_여부
			dzoneAlamYn       : '' , //위험지역_알림_여부
			szoneAlamYn       : '' , //세이프존_알림_여부
			fallAlamYn	      : '' , //낙상_발생_알림_여부
			hbitAbnmAlamYn	  : '' , //심박_이상_알림_여부
			tempAbnmAlamYn    : '' , //체온_이상_알림_여부
			bodyHistAlamYn    : '' , //신체_기록_알림_여부
			mealNinpAlamYn    : '' , //식사_미입력_알림_여부
			excsNinpAlamYn    : '' , //운동_미입력_알림_여부
			cbeeUseAlamYn     : '' , //캐시비_사용_알림_여부
			batrLackAlamYn    : '' , //배터리_부족_알림_여부
			ltrmNuseAlamYn    : '' , //장기_미사용_알림_여부
			entrDt            : '' , //가입_일자
			relsDt            : '' , //해지_일자
			relsResnCd        : '' , //해지_사유_코드
			relsResnCntn      : '' , //해지_사유_내용
			entrStatCd        : '' , //가입_상태_코드
			paging            : 'Y',
			totalCoun         : 0  ,
			rowCount          : 30 ,
			currentPage       : 1  ,
			currentIndex      : 0
    	},
		code: {
			sexCdList      : [] , //성별_코드_리스트
			raceDivCdList  : [] , //인종_구분_코드_리스트
			entrStatCdList : [] , //가입_상태_코드_리스트
			relsResnCdList : [] , //해지_사유_코드_리스트
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
			getCommonCodeList('SEX_CD'      , $this.code.sexCdList);      //성별_코드_리스트
			getCommonCodeList('RACE_DIV_CD' , $this.code.raceDivCdList);  //인종_구분_코드_리스트
			getCommonCodeList('ENTR_STAT_CD', $this.code.entrStatCdList); //가입_상태_코드_리스트
			getCommonCodeList('RELS_RESN_CD', $this.code.relsResnCdList); //해지_사유_코드_리스트

		},
		initValue()
		{
			let $this = this;
			$this.userId = SessionUtil.getUserId();
		},
        initPage: function(guarNo, stdtNo) {

			let $this = this;
			$this.resetGuarDetlInfo();
			if (!WebUtil.isNull(guarNo))
			{
				let params = {
					'guarNo' : guarNo ,
					'stdtNo' : stdtNo
				}
				AjaxUtil.post({
					url: "/user/guar/guarInfoMng/searchGuarInfo.ab",
					param: params,
					success: function(response) {
						if ( !!response.rtnData.result )
						{
							$this.params.crud = 'U';

							$.each(response.rtnData.result.result, function(key, val) {
								$this.params[key] = val;
							});
						}
						$this.params.entrDt = formatDate($this.params.entrDt);
						$this.params.relsDt = formatDate($this.params.relsDt);
					},
					error: function (response) {
						Swal.alert([response, 'error']);
					}
				});
			}
		},
			isValid: function() {

        	let $this = this;        	        	

        	if ( WebUtil.isNull($this.params.autoLoginYn) ) {
        		Swal.alert(['자동로그인 여부는 필수 입력 값입니다.', 'info']);
        		return false;
        	}
        	if ( WebUtil.isNull($this.params.dzoneAlamYn) ) {
        		Swal.alert(['위험지역 알림 여부는 필수 입력 값입니다.', 'info']);
        		return false;
        	}
        	if ( WebUtil.isNull($this.params.szoneAlamYn) ) {
        		Swal.alert(['위험지역 이탈 알림 여부는 필수 입력 값입니다.', 'info']);
        		return false;
        	}
        	if ( WebUtil.isNull($this.params.fallAlamYn) ) {
        		Swal.alert(['낙상 알림 여부는 필수 입력 값입니다.', 'info']);
        		return false;
        	}
        	if ( WebUtil.isNull($this.params.hbitAbnmAlamYn) ) {
        		Swal.alert(['심박 이상 알림 여부는 필수 입력 값입니다.', 'info']);
        		return false;
        	}
        	if ( WebUtil.isNull($this.params.tempAbnmAlamYn) ) {
        		Swal.alert(['체온 이상 알림 여부는 필수 입력 값입니다.', 'info']);
        		return false;
        	}
        	if ( WebUtil.isNull($this.params.bodyHistAlamYn) ) {
        		Swal.alert(['신체 기록 알림 여부는 필수 입력 값입니다.', 'info']);
        		return false;
        	}
        	if ( WebUtil.isNull($this.params.mealNinpAlamYn) ) {
        		Swal.alert(['식사 미입력 알림 여부는 필수 입력 값입니다.', 'info']);
        		return false;
        	}
        	if ( WebUtil.isNull($this.params.excsNinpAlamYn) ) {
        		Swal.alert(['운동 미입력 알림 여부는 필수 입력 값입니다.', 'info']);
        		return false;
        	}
        	if ( WebUtil.isNull($this.params.cbeeUseAlamYn) ) {
        		Swal.alert(['캐시비 사용 알림 여부는 필수 입력 값입니다.', 'info']);
        		return false;
        	}
        	if ( WebUtil.isNull($this.params.batrLackAlamYn) ) {
        		Swal.alert(['베터리 부족 알림 여부는 필수 입력 값입니다.', 'info']);
        		return false;
        	}
        	if ( WebUtil.isNull($this.params.ltrmNuseAlamYn) ) {
        		Swal.alert(['장기 미사용 알림 여부는 필수 입력 값입니다.', 'info']);
        		return false;
        	}
        	return true;
        },
		saveguarInfoDetl: function() {
			
			let $this = this;
			
            if ( !this.isValid() ) {
                return false;
            }

			AjaxUtil.post({
                url: "/user/guar/guarInfoMng/saveGuarInfoDetl.ab",
                param: $this.params,
                success: function(response) {
                	Swal.alert(['저장이 완료되었습니다.', 'success']).then(function() {
                		closeModal($('#guarInfoDetlPopup'));
						guarInfoMng.searchGuarInfoList(true);
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
                url: "/user/guar/guarInfoMng/saveGuarInfoDetl.ab",
                param: $this.params,
                success: function(response) {
                	Swal.alert(['삭제가 완료되었습니다.', 'success']).then(function() {
                		 closeModal($('#guarInfoDetlPopup'));
						guarInfoMng.searchGuarInfoList(true);
                	});
                },
                error: function (response) {
                	Swal.alert([response, 'error']);
                }
            });
		},
		resetGuarDetlInfo: function() {
			this.params = {
				crud              : 'C',
				userId            : '' ,
				stdtNo            : '' , //학생_번호
				stdtNm            : '' , //학생_명
				guarNo            : '' , //보호자_번호
				guarNm            : '' , //보호자_명
				guarTelNo         : '' , //보호자_전화_번호
				guarPw            : '' , //보호자_비밀번호
				selfCertDttm      : '' , //본인_인증_일시
				autoLoginYn       : '' , //자동_로그인_여부
				dzoneAlamYn       : '' , //위험지역_알림_여부
				szoneAlamYn       : '' , //세이프존_알림_여부
				fallAlamYn	      : '' , //낙상_발생_알림_여부
				hbitAbnmAlamYn	  : '' , //심박_이상_알림_여부
				tempAbnmAlamYn    : '' , //체온_이상_알림_여부
				bodyHistAlamYn    : '' , //신체_기록_알림_여부
				mealNoinAlamYn    : '' , //식사_미입력_알림_여부
				excsNoinAlamYn    : '' , //운동_미입력_알림_여부
				cbeeUseAlamYn     : '' , //캐시비_사용_알림_여부
				batrLackAlamYn    : '' , //배터리_부족_알림_여부
				ltrmNuseAlamYn    : '' , //장기_미사용_알림_여부
				entrDt            : '' , //가입_일자
				relsDt            : '' , //해지_일자
				relsResnCd        : '' , //해지_사유_코드
				relsResnCntn      : '' , //해지_사유_내용
				entrStatCd        : '' , //가입_상태_코드
				paging            : 'Y',
				totalCoun         : 0  ,
				rowCount          : 30 ,
				currentPage       : 1  ,
				currentIndex      : 0
	    	}
		},
    },
    computed:
	{
    },
    watch:
	{
    },
    mounted: function() {
        let self = this;
        $(document).ready(function() {
            self.initialize();
        });
    }
});
