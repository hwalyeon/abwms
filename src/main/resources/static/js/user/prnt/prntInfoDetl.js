let prntInfoDetl = new Vue({
    el: "#prntInfoDetlPopup",
    data: {
    	params: {
    		crud              : 'C',
    		userId            : '' ,
    		bandId            : '' ,
			stdtNo            : '' , //학생_번호
			stdtNm            : '' , //학생_이름
			guarNo            : '' , //보호자_번호
			guarNm            : '' , //보호자_이름
			prntNo            : '' , //학부모_번호
    		prntNm            : '' , //학부모_명
    		sexCd             : '' , //성별_코드
			hghtVal           : '' , //키_값
			wghtVal		      : '' , //체중_값
			bmiVal		      : '' , //BMI_값
			raceDivCd         : '' , //인종_구분_코드
    	},
		callBack : null,
		code: {
			sexCdList      : [] , //성별_코드_리스트
			raceDivCdList  : [] , //인종_구분_코드_리스트
		}
	},
    methods: {

        initialize: function()
		{
        	let $this = this;

        	$this.initValue();
        	$this.initCodeList();
        },
        initCodeList: function()
		{
        	let $this = this;
			getCommonCodeList('SEX_CD', $this.code.sexCdList);            //성별_코드_리스트
			getCommonCodeList('RACE_DIV_CD', $this.code.raceDivCdList);   //인종_구분_코드_리스트
		},
		initValue()
		{
			let $this = this;
			$this.userId = SessionUtil.getUserId();
		},
        initPage: function(prntNo, sexCd, callback)
		{
			let $this = this;

			if(typeof callback === 'function')
			{
				$this.callBack = callback;
			}

			$this.resetPrntDetlInfo();

			if (!WebUtil.isNull(sexCd))
			{
				let params =
					{
						'prntNo' : prntNo ,
						'sexCd'  : sexCd
					}
				AjaxUtil.post({
					url: "/user/prnt/prntInfoMng/searchPrntInfo.ab",
					param: params,
					success: function(response) {
						if (!!response.rtnData.result)
						{
							$.each(response.rtnData.result, function(key, val) {
								$this.params[key] = val;});

							if(response.rtnData.result.prntNm != null){
								$this.params.crud = 'U';
							}
						}
						else
						{
							$this.params.prntNo = prntNo;
							$this.params.sexCd = sexCd;
						}
					},
					error: function (response) {
						Swal.alert([response, 'error']);
					}
				});
			}
		},
		isValid: function()
		{
        	let $this = this;

			if ( WebUtil.isNull($this.params.hghtVal) ) {
				Swal.alert(['키는 필수 입력 값 입니다.', 'info']);
				return false;
			}else if ( WebUtil.isNull($this.params.wghtVal) ) {
				Swal.alert(['몸무게는 필수 입력 값 입니다.', 'info']);
				return false;
			}else if ( WebUtil.isNull($this.params.bmiVal) ) {
				Swal.alert(['BMI는 필수 입력 값 입니다.', 'info']);
				return false;
			}else {
				return true;
			}


        	return true;
        },
		savePrntInfoDetl: function() {
			
			let $this = this;
			
            if ( !this.isValid() ) {
                return false;
            }
			AjaxUtil.post({
                url: "/user/prnt/prntInfoMng/savePrntInfoDetl.ab",
                param: $this.params,
                success: function(response) {
                	Swal.alert(['저장이 완료되었습니다.', 'success']).then(function() {
                		closeModal($('#prntInfoDetlPopup'));
						if($this.callBack != null ) $this.callBack();
                	});                	
                },
                error: function (response) {
                	Swal.alert([response, '학부모 정보 저장에 실패하였습니다.']);
                }
            });
		},

		deleteUser: function() {
			
			let $this = this;
			
			$this.params.crud = 'D';
			
            AjaxUtil.post({
                url: "/user/guar/guarInfoMng/saveSposInfoDetl.ab",
                param: $this.params,
                success: function(response) {
                	Swal.alert(['삭제가 완료되었습니다.', 'success']).then(function() {
                		 closeModal($('#prntInfoDetlPopup'));
						if($this.callBack != null ) $this.callBack();
                	});
                },
                error: function (response) {
                	Swal.alert([response, 'error']);
                }
            });
		},
		resetPrntDetlInfo: function() {
			this.params = {
				crud              : 'C',
				userId            : '' ,
				stdtNo            : '' , //학생_번호
				stdtNm            : '' , //학생_이름
				guarNo            : '' , //보호자_번호
				guarNm            : '' , //보호자_이름
				prntNo            : '' , //학부모_번호
				prntNm            : '' , //학부모_명
				sexCd             : '' , //성별_코드
				hghtVal           : '' , //키_값
				wghtVal		      : '' , //체중_값
				bmiVal		      : '' , //BMI_값
				raceDivCd         : '' , //인종_구분_코드
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
