let roleDetl = new Vue({
    el: "#roleDetlPopup",
    data: {
    	roleInfo: {
    		crud: 'C',
    		roleCd: '',
    		roleNm: '',
    		roleDivCd: '',
    		roleDesc: ''
    	},
    	code : {
    		roleDivList: []
    	}
	},
	
    methods: {

        initialize: function() {
        	
        	let $this = this;
        	
        	$this.initCodeList();
        	
        },
        initCodeList: function() {
        	
        	getCommonCodeList('ROLE_DIV_CD', this.code.roleDivList);
        	        	
        },
        initPage: function(roleCd) {
        	
        	let $this = this;
        	$this.resetRoleInfo();
        	
        	if ( !WebUtil.isNull(roleCd) )
    		{
        		let params = {
        			'roleCd' : roleCd
        		}
        		
        		AjaxUtil.post({
                    url: "/set/roleMng/searchRoleInfo.ab",
                    param: params,
                    success: function(response) {
                    	if ( !!response.rtnData.result ) {
                    		$this.roleInfo.crud = 'U';
                    		$.each(response.rtnData.result, function(key, val) {
            					$this.roleInfo[key] = val;
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
        	if ( WebUtil.isNull($this.roleInfo.roleCd) ) {
        		Swal.alert(['역할코드를 입력하세요.', 'info']);
        		return false;
        	}
        	
        	if ( WebUtil.isNull($this.roleInfo.roleNm) ) {
        		Swal.alert(['역할명을 입력하세요.', 'info']);
        		return false;
        	}
        	        	
        	if ( WebUtil.isNull($this.roleInfo.roleDivCd) ) {
        		Swal.alert(['역할구분을 입력하세요.', 'info']);
        		return false;
        	}
        	
        	return true;
        },
		saveRole: function() {
			
			let $this = this;
			
            if ( !this.isValid() ) {
                return false;
            }
			
			AjaxUtil.post({
                url: "/set/roleMng/saveRole.ab",
                param: $this.roleInfo,
                success: function(response) {
                	Swal.alert(['저장이 완료되었습니다.', 'success']).then(function() {
                		 closeModal($('#roleDetlPopup'));
                		 roleMng.searchRoleList(true);
                	});                	
                },
                error: function (response) {
                	Swal.alert([response, 'error']);
                }
            });
		},
		deleteRole: function() {
			
			let $this = this;
			
			$this.roleInfo.crud = 'D';
			
            AjaxUtil.post({
                url: "/set/roleMng/saveRole.ab",
                param: $this.roleInfo,
                success: function(response) {
                	Swal.alert(['저장이 완료되었습니다.', 'success']).then(function() {
                		 closeModal($('#roleDetlPopup'));
                		 roleMng.searchRoleList(true);
                	});                	
                },
                error: function (response) {
                	Swal.alert([response, 'error']);
                }
            });
		},
		resetRoleInfo: function() {
			this.roleInfo = {
				crud: 'C',
	    		roleCd: '',
	    		roleNm: '',
	    		roleDivCd: '',
	    		roleDesc: ''
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
