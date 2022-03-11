let strsStndCdDetl = new Vue({
    el: "#strsStndCdDetlPopup",
    data: {
		strsStndCdInfo: {
    		crud: 'C',
			cdVal:'',
			cdNm:'',
			cdDesc:'',
			sortOrd:'',
			useYn:''
    	},
		summerNoteId2 : 'summerNoteId2',
		callBack      : null,
 		code: {
			useYnList: []
		}
	},

	components: {'summer-note': summernote},
    methods: {

        initialize: function() {
        	
        	let $this = this;
        	
        	$this.initCodeList();      
        	        	
        },
        initCodeList: function() {
        	let $this = this;
			getCommonCodeList('USE_YN', this.code.useYnList);
        },
        initPage: function(cdVal, callback) {
        	
        	let $this = this;
        	if(typeof callback === 'function'){
        		$this.callBack = callback;
			}
        	$this.resetstrsStndInfo();

        	
        	if ( !WebUtil.isNull(cdVal))
    		{
        		let params = {
        			'cdVal' : cdVal
        		}
        		
        		AjaxUtil.post({
                    url: "/svcStnd/strs/strsStndMng/searchStrsStndCdInfo.ab",
                    param: params,
                    success: function(response) {
                    	if ( !!response.rtnData.result ) {
                    		$this.strsStndCdInfo.crud = 'U';
                    		$.each(response.rtnData.result, function(key, val) {
            					$this.strsStndCdInfo[key] = val;
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

        	let vueCommon = this;
        	
        	if ( WebUtil.isNull($this.strsStndCdInfo.cdVal) ) {
        		Swal.alert(['코드값을 입력하세요.', 'info']);
        		return false;
        	}
        	
        	if ( WebUtil.isNull($this.strsStndCdInfo.cdNm) ) {
        		Swal.alert(['코드명을 입력하세요.', 'info']);
        		return false;
        	}

			if ( WebUtil.isNull($this.strsStndCdInfo.cdDesc) ) {
				Swal.alert(['코드내용을 입력하세요.', 'info']);
				return false;
			}

			if ( WebUtil.isNull($this.strsStndCdInfo.sortOrd) ) {
				Swal.alert(['정렬순서를 입력하세요.', 'info']);
				return false;
			}

			if ( WebUtil.isNull($this.strsStndCdInfo.useYn) ) {
				Swal.alert(['사용여부를 입력하세요.', 'info']);
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
                url: "/svcStnd/strs/strsStndMng/saveCdInfo.ab",
                param: $this.strsStndCdInfo,
                success: function(response) {
                	Swal.alert(['저장이 완료되었습니다.', 'success']).then(function() {
                		closeModal($('#strsStndCdDetlPopup'));
						strsStndMng.searchCdSpecList(true);
						if($this.callBack != null ) $this.callBack();
                	});                	
                },
                error: function (response) {
                	Swal.alert([response, 'error']);
                }
            });

		},
		deleteInfo: function() {
			
			let $this = this;
			
			$this.strsStndCdInfo.crud = 'D';
			
            AjaxUtil.post({
                url: "/svcStnd/strs/strsStndMng/saveCdInfo.ab",
                param: $this.strsStndCdInfo,
                success: function(response) {
                	Swal.alert(['삭제가 완료되었습니다.', 'success']).then(function() {
                		 closeModal($('#strsStndCdDetlPopup'));
						 strsStndMng.searchCdSpecList(true);
						 if($this.callBack != null ) $this.callBack();
					});
                },
                error: function (response) {
                	Swal.alert([response, 'error']);
                }
            });
		},
		resetstrsStndInfo: function() {
			this.strsStndCdInfo = {
				crud: 'C',
				cdVal:'',
				cdNm:'',
				cdDesc:''
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
