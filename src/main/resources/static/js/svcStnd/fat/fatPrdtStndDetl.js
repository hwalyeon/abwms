let fatPrdtStndDetl = new Vue({
    el: "#fatPrdtStndDetlPopup",
    data: {
    	params: {
			crud: 'C',
            userId          : '' ,
			fatJudgCd       : '' , //비만_판정_코드
			fatpJudgCd      : '' , //비만예측_판정_코드
            fatpEvalSmry    : '' , //요약_내용
            fatpEvalCntn    : '' , //상세_내용
     	},
        code:
            {
                fatJudgCdList   : []  , //비만_판정_코드_리스트
                fatpJudgCdList  : []  , //비만예측_판정_코드_리스트
            },
        summerNoteFatpEvalSmry : 'summerNoteFatpEvalSmry' ,
        summerNoteFatpEvalCntn : 'summerNoteFatpEvalCntn'

	},

	components: {'summer-note': summernote},
    methods: {

        initialize: function() {

        	let $this = this;
            $this.initCodeList();

        },
        initCodeList : function()
        {
            let $this = this;

            getCommonCodeList('FAT_JUDG_CD',$this.code.fatJudgCdList);  //비만_판정_코드_리스트
            getCommonCodeList('FAT_JUDG_CD',$this.code.fatpJudgCdList); //비만예측_판정_코드_리스트
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

            if ( WebUtil.isNull($this.params.fatJudgCd) ) {
                Swal.alert(['비만 판정 코드는 필수 입력입니다.', 'info']);
                return false;
            }

            if ( WebUtil.isNull($this.params.fatpJudgCd) ) {
                Swal.alert(['비만 예측 판정 코드는 필수 입력입니다.', 'info']);
                return false;
            }

            return true;
        },

        saveInfo: function() {

            let $this = this;


            if (!this.isValid()) {
                return false;
            }

			AjaxUtil.post({
                url: "/svcStnd/fat/fatPrdtStndMng/saveInfo.ab",
                param: $this.params,
                success: function(response) {
                	Swal.alert(['저장이 완료되었습니다.', 'success']).then(function() {
                		closeModal($('#fatPrdtStndDetlPopup'));
						fatPrdtStndMng.searchFatPrdtList(true);
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

            let params = $this.params

            AjaxUtil.post({
                url: "/svcStnd/fat/fatPrdtStndMng/searchFatPrdtList.ab",
                param: params,
                success: function(response) {

                    if ( response.rtnData.existsYn === 'Y' ) {
                        Swal.alert(['이미 등록된 코드입니다.', 'warning']);
                        return false;
                    }else{
                        return true;
                    }
                }
            });
            return true;
        },

		deleteInfo: function() {
			
			let $this = this;
			
			$this.params.crud = 'D';
			
            AjaxUtil.post({
                url: "/svcStnd/fat/fatPrdtStndMng/saveInfo.ab",
                param: $this.params,
                success: function(response) {
                	Swal.alert(['삭제가 완료되었습니다.', 'success']).then(function() {
                        closeModal($('#fatPrdtStndDetlPopup'));
                        fatPrdtStndMng.searchFatPrdtList(true);
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
                fatpEvalSmry    : '' , //요약_내용
                fatpEvalCntn    : '' , //상세_내용
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
