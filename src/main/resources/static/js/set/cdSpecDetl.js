let cdSpecDetl = new Vue({
    el: "#cdSpecDetlPopup",
    data: {
    	cdSpecInfo: {
    		crud: 'C',
    		cdGrp: '',
    		cdGrpNm: '',
    		cdVal: '',
    		cdNm: '',
    		sortOrd: '',
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
        initPage: function(crud, cdGrp, cdGrpNm, cdVal) {
        	
        	console.log(crud, cdGrp, cdGrpNm, cdVal);
        	
        	let $this = this;
        	$this.resetCdSpecInfo();
        	
        	if ( crud === 'U' )
    		{
        		let params = {
        			'cdGrp' : cdGrp,
        			'cdVal' : cdVal
        		}
        		
        		AjaxUtil.post({
                    url: "/set/cdMng/searchCdSpecList.ab",
                    param: params,
                    success: function(response) {
                    	if ( response.rtnData.result.length == 1 ) {
                    		$this.cdSpecInfo.crud = crud;
                    		$.each(response.rtnData.result[0], function(key, val) {
            					$this.cdSpecInfo[key] = val;
            				});
                    	}                    		
                    },
                    error: function (response) {
                    	Swal.alert([response, 'error']);
                    }
                });
    		}
        	else
        	{
        		$this.cdSpecInfo.cdGrp   = cdGrp;
        		$this.cdSpecInfo.cdGrpNm = cdGrpNm;
        	}
        },
        isValid: function() {
        	
        	let $this = this;
        	if ( WebUtil.isNull($this.cdSpecInfo.cdGrp) ) {
        		Swal.alert(['코드그룹을 입력하세요.', 'info']);
        		return false;
        	}
        	
        	return true;
        },
		saveCdSpec: function() {
			
			let $this = this;
			
            if ( !this.isValid() ) {
                return false;
            }
			
			AjaxUtil.post({
                url: "/set/cdMng/saveCdSpec.ab",
                param: $this.cdSpecInfo,
                success: function(response) {
                	Swal.alert(['저장이 완료되었습니다.', 'success']).then(function() {
                		 closeModal($('#cdSpecDetlPopup'));
                		 cdMng.searchCdSpecList(true);
                	});                	
                },
                error: function (response) {
                	Swal.alert([response, 'error']);
                }
            });
		},
		deleteCdSpec: function() {
			
			let $this = this;
			
			$this.cdSpecInfo.crud = 'D';	
			
			AjaxUtil.post({
                url: "/set/cdMng/saveCdSpec.ab",
                param: $this.cdSpecInfo,
                success: function(response) {
                	Swal.alert(['저장이 완료되었습니다.', 'success']).then(function() {
                		 closeModal($('#cdSpecDetlPopup'));
                		 cdMng.searchCdSpecList(true);
                	});                	
                },
                error: function (response) {
                	Swal.alert([response, 'error']);
                }
            });
		},
		resetCdSpecInfo: function() {
			this.cdSpecInfo = {
				crud: 'C',
	    		cdGrp: '',
	    		cdGrpNm: '',
	    		cdVal: '',
	    		cdNm: '',
	    		sortOrd: '',
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
