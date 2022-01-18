let cdGrpDetl = new Vue({
    el: "#cdGrpDetlPopup",
    data: {
    	cdGrpInfo: {
    		crud: 'C',
    		cdGrp: '',
    		cdGrpNm: '',
    		useYn: ''
    	},
    	code : {
    		useYnList: [
    			{cdVal: 'Y', cdNm: 'Y'},
    			{cdVal: 'N', cdNm: 'N'}
    		]
    	}
	},
	
    methods: {

        initialize: function() {
        	
        	let $this = this;
        	
        	$this.initCodeList();
        },
        initCodeList: function() {

        },
        initPage: function(cdGrp) {
        	
        	let $this = this;
        	$this.resetCdGrpInfo();
        	
        	if ( !WebUtil.isNull(cdGrp) )
    		{
        		let params = {
        			'cdGrp' : cdGrp
        		}
        		
        		AjaxUtil.post({
                    url: "/set/cdMng/searchCdGrpList.ab",
                    param: params,
                    success: function(response) {
                    	if ( response.rtnData.result.length == 1 ) {
                    		$this.cdGrpInfo.crud = 'U';
                    		$.each(response.rtnData.result[0], function(key, val) {
            					$this.cdGrpInfo[key] = val;
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
        	if ( WebUtil.isNull($this.cdGrpInfo.cdGrp) ) {
        		Swal.alert(['코드그룹을 입력하세요.', 'info']);
        		return false;
        	}
        	
        	return true;
        },
		saveCdGrp: function() {
			
			let $this = this;
			
            if ( !this.isValid() ) {
                return false;
            }
			
			AjaxUtil.post({
                url: "/set/cdMng/saveCdGrp.ab",
                param: $this.cdGrpInfo,
                success: function(response) {
                	Swal.alert(['저장이 완료되었습니다.', 'success']).then(function() {
                		 closeModal($('#cdGrpDetlPopup'));
                		 cdMng.searchCdGrpList(true);
                	});                	
                },
                error: function (response) {
                	Swal.alert([response, 'error']);
                }
            });
		},
		deleteCdGrp: function() {
			
			let $this = this;
			
			$this.cdGrpInfo.crud = 'D';	
			
			AjaxUtil.post({
                url: "/set/cdMng/saveCdGrp.ab",
                param: $this.cdGrpInfo,
                success: function(response) {
                	Swal.alert(['저장이 완료되었습니다.', 'success']).then(function() {
                		 closeModal($('#cdGrpDetlPopup'));
                		 cdMng.searchCdGrpList(true);
                	});                	
                },
                error: function (response) {
                	Swal.alert([response, 'error']);
                }
            });
		},
		resetCdGrpInfo: function() {
			this.cdGrpInfo = {
				crud: 'C',
				cdGrp: '',
	    		cdGrpNm: '',
	    		useYn: ''
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
