let cdSpecDetl = new Vue({
    el: "#cdSpecDetlPopup",
    data: {
    	cdSpecInfo: {
    		crud: 'C',
    		cdGrp: '',
    		cdVal: '',
    		cdNm: '',
    		cdDesc: '',
    		fltrVal1: '',
    		fltrVal2: '',
    		fltrVal3: '',
    		sortOrd: '',
    		useYn: '',
    		oldCdGrp:'',
    		oldCdVal:'',
    		newCdGrp:'',
    		newCdVal:'',
    		dataCk:'Y',
    	},
    	code : {
    		useYnList: [
    			{cdVal: 'Y', cdNm: 'Y'},
    			{cdVal: 'N', cdNm: 'N'}
    		],
    		cdGrpDivList:[]
    	}
	},
	
    methods: {
        initialize: function() {
        	
        	let $this = this;
        	$
        	$this.initCodeList();
        },
        initCodeList: function() {
        	
        	let $this = this;
        	let params = {};
        	AjaxUtil.post({
                url: "/set/cdMng/searchCdGrpDivList",
                param: params,
                success: function(response) {
                	$this.code.cdGrpDivList = [];
                	if ( !!response.rtnData.result && response.rtnData.result.length > 0 ) {
                		    $.each(response.rtnData.result, function(index, item) {
        					$this.code.cdGrpDivList.push({'cdVal':item.cdGrp});

        				});
                    }
                },
                error: function (response) {
                	Swal.alert([response, 'error']);
                }
            });
        	
        },
        initPage: function(crud, cdGrp, cdVal) {
        	
        	
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
                    		   $this.cdSpecInfo.oldCdGrp = $this.cdSpecInfo.cdGrp;
                    		   $this.cdSpecInfo.oldCdVal  = $this.cdSpecInfo.cdVal;
                    		   $this.cdSpecInfo.newCdGrp = $this.cdSpecInfo.cdGrp;
                    		   $this.cdSpecInfo.newCdVal  = $this.cdSpecInfo.cdVal;
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
        	}
        },
        changeCdSpecInfo: function(){
        	let $this = this;
       		$this.cdSpecInfo.newCdVal = $this.cdSpecInfo.cdVal ;	
       		$this.cdSpecInfo.newCdGrp = $this.cdSpecInfo.cdGrp ;	
   },
        isValid: function() {
        	
        	let $this = this;
        	if ( WebUtil.isNull($this.cdSpecInfo.cdGrp) ) {
        		Swal.alert(['코드그룹을 입력하세요.', 'info']);
        		return false;
        	}
        	
        	return true;
        },
        searchDuprCdSpec: function() {
        	let $this = this;
        	
        	if($this.cdSpecInfo.oldCdVal == $this.cdSpecInfo.newCdVal &&$this.cdSpecInfo.oldCdGrp == $this.cdSpecInfo.newCdGrp  )
            {
              		$this.cdSpecInfo.dataCk = 'N';
            }else {
            	$this.cdSpecInfo.dataCk = 'Y';
            }
        	
        	let params =  $this.cdSpecInfo;
        
			AjaxUtil.post({
                url:"/set/cdMng/searchDuprCdSpec",
                param: params,
                success: function(response) {
                	if ( response.rtnData.existsYn === 'N' )
                	{
                		
                	
                			$this.saveCdSpec();
                
                	}
                	else 
                	{
                		$this.cdSpecInfo.cdVal = '';
                		
                		Swal.alert(['해당 코드는 이미 사용중입니다.', 'info']);
                		if ( response.rtnData.sortOrdDu == 'Y')
                		{
                			$this.cdSpecInfo.sortOrd = '';
                		}else{
                			$this.cdSpecInfo.sortOrd =$this.cdSpecInfo.sortOrd ;
                		}
                	}
                },
                error: function (response) {
                	Swal.alert([response, 'error']);
                }
            });
			
        },
        
		saveCdSpec: function() {
			
			let $this = this;
			let params = $this.cdSpecInfo;
         /*   if ( !this.isValid() ) {
                return false;
            }*/
			
		  	  AjaxUtil.post({
                url: "/set/cdMng/saveCdSpec.ab",
                param: params,
                success: function(response)
                {
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
		    		cdVal: '',
		    		cdNm: '',
		    		cdDesc: '',
		    		fltrVal1: '',
		    		fltrVal2: '',
		    		fltrVal3: '',
		    		sortOrd: '',
		    		useYn: '',

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
