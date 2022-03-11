let strsStndDetl = new Vue({
    el: "#strsStndDetlPopup",
    data: {
    	strsStndInfo: {
    		crud: 'C',
			mentStrsStatCd:'',
			physStrsStatCd:'',
			strsJudgCntn:''
    	},
		summerNoteId1 : 'summerNoteId1',
 		code: {
			mentStrsStatCdList: []
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
			$this.code.mentStrsStatCdList = [];
			getCommonCodeList('STRS_STAT_CD',$this.code.mentStrsStatCdList);
        },
        initPage: function(mentStrsStatCd, physStrsStatCd) {
        	
        	let $this = this;
        	$this.resetstrsStndInfo();

        	
        	if ( !WebUtil.isNull(mentStrsStatCd) || !WebUtil.isNull(physStrsStatCd))
    		{
        		let params = {
        			'mentStrsStatCd' : mentStrsStatCd ,
					'physStrsStatCd' : physStrsStatCd
        		}
        		
        		AjaxUtil.post({
                    url: "/svcStnd/strs/strsStndMng/searchStrsStndInfo.ab",
                    param: params,
                    success: function(response) {
                    	if ( !!response.rtnData.result ) {
                    		$this.strsStndInfo.crud = 'U';
                    		$.each(response.rtnData.result, function(key, val) {
            					$this.strsStndInfo[key] = val;
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
        	
        	if ( WebUtil.isNull($this.strsStndInfo.mentStrsStatCd) ) {
        		Swal.alert(['정신적스트레스상태를 입력하세요.', 'info']);
        		return false;
        	}
        	
        	if ( WebUtil.isNull($this.strsStndInfo.physStrsStatCd) ) {
        		Swal.alert(['신체적스트레스상태를 입력하세요.', 'info']);
        		return false;
        	}

			if ( WebUtil.isNull($this.strsStndInfo.strsJudgCntn) ) {
				Swal.alert(['현재평가내용을 입력하세요.', 'info']);
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
                url: "/svcStnd/strs/strsStndMng/saveInfo.ab",
                param: $this.strsStndInfo,
                success: function(response) {
                	Swal.alert(['저장이 완료되었습니다.', 'success']).then(function() {
                		closeModal($('#strsStndDetlPopup'));
						strsStndMng.searchStrsList(true);
                	});                	
                },
                error: function (response) {
                	Swal.alert([response, 'error']);
                }
            });

		},
		deleteInfo: function() {
			
			let $this = this;
			
			$this.strsStndInfo.crud = 'D';
			
            AjaxUtil.post({
                url: "/svcStnd/strs/strsStndMng/saveInfo.ab",
                param: $this.strsStndInfo,
                success: function(response) {
                	Swal.alert(['삭제가 완료되었습니다.', 'success']).then(function() {
                		 closeModal($('#strsStndDetlPopup'));
						 strsStndMng.searchStrsList(true);
                	});                	
                },
                error: function (response) {
                	Swal.alert([response, 'error']);
                }
            });
		},
		resetstrsStndInfo: function() {
			this.strsStndInfo = {
				crud: 'C',
				mentStrsStatCd: '',
				physStrsStatCd: '',
				fatJudgNm: ''
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
