let palStndDetl = new Vue({
    el: "#palStndDetlPopup",
    data: {
    	palStndInfo: {
    		crud: 'C',
			palCd: '',
			palNm: '',
			palValFr: '',
			palValTo: '',
			palEatRmrk: ''
    	},
		code: {
			palCdList: []
		}
	},
	components: {'summer-note': summernote },
    methods: {

        initialize: function() {
        	
        	let $this = this;
        	
        	$this.initCodeList();      
        	        	
        },
        initCodeList: function() {
        	let $this = this;
			getCommonCodeList('PAL_CD',$this.code.palCdList);
        	
        },
        initPage: function(palCd) {
        	
        	let $this = this;
        	$this.resetPalStndInfo();
        	
        	if ( !WebUtil.isNull(palCd) )
    		{
        		let params = {
        			'palCd' : palCd
        		}
        		
        		AjaxUtil.post({
                    url: "/svcStnd/act/palStndMng/searchPalStndInfo.ab",
                    param: params,
                    success: function(response) {
                    	if ( !!response.rtnData.result ) {
                    		$this.palStndInfo.crud = 'U';
                    		$.each(response.rtnData.result, function(key, val) {
            					$this.palStndInfo[key] = val;
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

        	if ( WebUtil.isNull($this.palStndInfo.palCd) ) {
        		Swal.alert(['신체활동수준 코드를 입력하세요.', 'info']);
        		return false;
        	}

        	if ( WebUtil.isNull($this.palStndInfo.palNm) ) {
        		Swal.alert(['신체활동수준 명을 입력하세요.', 'info']);
        		return false;
        	}

        	if ( WebUtil.isNull($this.palStndInfo.palValFr) ) {
        		Swal.alert(['신체활동수준 값 From을 입력하세요.', 'info']);
        		return false;
        	}

			if ( WebUtil.isNull($this.palStndInfo.palValTo) ) {
				Swal.alert(['신체활동수준 값 To를 입력하세요.', 'info']);
				return false;
			}

			if ( WebUtil.isNull($this.palStndInfo.palEatRmrk) ) {
				Swal.alert(['신체활동수준 섭취 비고를 입력하세요.', 'info']);
				return false;
			}
			if (Number($this.palStndInfo.palValFr) > Number($this.palStndInfo.palValTo)) {
				Swal.alert(['신체활동수준 값 From이 TO 보다 큽니다.', 'info']);
				return false;
			}
        	return true;
        },

		saveInfo: function() {
			
			let $this = this;

            if ( !this.isValid() ) {
                return false;
            }

			AjaxUtil.post({
                url: "/svcStnd/act/palStndMng/savePalStndInfo.ab",
                param: $this.palStndInfo,
                success: function(response) {
                	Swal.alert(['저장이 완료되었습니다.', 'success']).then(function() {
                		closeModal($('#palStndDetlPopup'));
						palStndMng.searchPalStndList(true);
                	});                	
                },
                error: function (response) {
                	Swal.alert([response, 'error']);
                }
            });

		},
		deleteInfo: function() {
			
			let $this = this;
			
			$this.palStndInfo.crud = 'D';
			
            AjaxUtil.post({
                url: "/svcStnd/act/palStndMng/savePalStndInfo.ab",
                param: $this.palStndInfo,
                success: function(response) {
                	Swal.alert(['삭제가 완료되었습니다.', 'success']).then(function() {
                		 closeModal($('#palStndDetlPopup'));
                		 palStndMng.searchPalStndList(true);
                	});                	
                },
                error: function (response) {
                	Swal.alert([response, 'error']);
                }
            });
		},
		changePalCd : function (){
			let $this = this;
			$this.palStndInfo.palNm = WebUtil.getCodeNm($this.code.palCdList, $this.palStndInfo.palCd);
		},
		resetPalStndInfo: function() {
			this.palStndInfo = {
				crud: 'C',
				palCd: '',
				palNm: '',
				palValFr: '',
				palValTo: '',
				palEatRmrk: ''
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
