let notiDetl = new Vue({
    el: "#notiDetlPopup",
    data: {
    	blbdInfo: {
    		crud: 'C',
			blbdNo:'',
    		blbdStrtDt:'',
			blbdExprDt:'',
			blbdTypeCd:'',
			blbdTitl:'',
			blbdCntn:'',
			srchCnt:'',
			alamYn:'',
			regDt:'',
			regTm:'',
			regUserId:'',
			uptDt:'',
			uptTm:'',
			uptUserId:''
    	},
		code: {
			blbdTypeList: []
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
			getCommonCodeList('BLBD_TYPE_CD',$this.code.blbdTypeList);
        },
        initPage: function(blbdNo) {
        	
        	let $this = this;
        	$this.resetUserInfo();

        	$this.setDatepicker();

        	if ( !WebUtil.isNull(blbdNo) )
    		{
        		let params = {
        			'blbdNo' : blbdNo
        		}

        		AjaxUtil.post({
                    url: "/cmon/blbd/searchNotiInfo.ab",
                    param: params,
                    success: function(response) {
                    	if ( !!response.rtnData.result ) {
                    		console.log($this.blbdInfo);
                    		$this.blbdInfo.crud = 'U';
                    		$.each(response.rtnData.result, function(key, val) {
            					$this.blbdInfo[key] = val;
            					val.blbdExprDt = '20202020';
            					if($this.blbdInfo.blbdExprDt != null) {
            						$this.blbdInfo.blbdStrtDt = formatDate($this.blbdInfo.blbdStrtDt);
									$this.blbdInfo.blbdExprDt = formatDate($this.blbdInfo.blbdExprDt);
								}
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

        	//현재날짜 YYYY-MM-DD
			var today = new Date();
			var year = today.getFullYear();
			var month = ('0' + (today.getMonth() + 1)).slice(-2);
			var day = ('0' + today.getDate()).slice(-2);
			var dateString = year + '-' + month  + '-' + day;

			if ( $this.blbdInfo.blbdStrtDt < dateString) {
				Swal.alert(['게시시작 일자가 오늘이거나 지난일자는 입력할 수 없습니다.', 'info']);
				return false;
			}

			if ( $this.blbdInfo.blbdStrtDt >= $this.blbdInfo.blbdExprDt) {
				Swal.alert(['정확한 게시만기 일자를 입력하세요.', 'info']);
				return false;
			}
        	
        	if ( WebUtil.isNull($this.blbdInfo.blbdTypeCd) ) {
        		Swal.alert(['게시유형 코드를 입력하세요.', 'info']);
        		return false;
        	}

			if ( WebUtil.isNull($this.blbdInfo.blbdTitl) ) {
				Swal.alert(['게시제목을 입력하세요.', 'info']);
				return false;
			}

			if ( WebUtil.isNull($this.blbdInfo.blbdCntn) ) {
				Swal.alert(['게시내용을 입력하세요.', 'info']);
				return false;
			}

			if ( WebUtil.isNull($this.blbdInfo.alamYn) ) {
				Swal.alert(['알림여부를 입력하세요.', 'info']);
				return false;
			}

        	return true;
        },
		setDatepicker : function() {
			let $this = this;
			$('#blbdStrtDtFrPicker').datepicker({
				todayBtn: "linked",
				keyboardNavigation: false,
				forceParse: false,
				calendarWeeks: true,
				format: 'yyyy-mm-dd',
				autoclose: true,
				todayHighlight: true,
			}).on("changeDate", function() {
				$this.blbdInfo.blbdStrtDt = $('#blbdStrtDt').val();
			});
			$('#blbdExprDtFrPicker').datepicker({
				todayBtn: "linked",
				keyboardNavigation: false,
				forceParse: false,
				calendarWeeks: true,
				format: 'yyyy-mm-dd',
				autoclose: true,
				todayHighlight: true,
			}).on("changeDate", function() {
				$this.blbdInfo.blbdExprDt = $('#blbdExprDt').val();
			});
		},
		saveNoti: function() {
			
			let $this = this;
			
            if ( !this.isValid() ) {
                return false;
            }
			//YYYY-MM-DD 형식 YYYYMMDD로 변환
			$this.blbdInfo.blbdStrtDt = $this.blbdInfo.blbdStrtDt.replace(/\-/g,'');
			$this.blbdInfo.blbdExprDt = $this.blbdInfo.blbdExprDt.replace(/\-/g,'');
            
			AjaxUtil.post({
                url: "/cmon/blbd/saveNoti.ab",
                param: $this.blbdInfo,
                success: function(response) {
                	Swal.alert(['저장이 완료되었습니다.', 'success']).then(function() {
                		closeModal($('#notiDetlPopup'));
               		 	notiMng.searchNotiList(true);
                	});                	
                },
                error: function (response) {
                	Swal.alert([response, 'error']);
                }
            });
		},
		deleteUser: function() {
			
			let $this = this;
			
			$this.blbdInfo.crud = 'D';
			
            AjaxUtil.post({
                url: "/cmon/blbd/saveNoti.ab",
                param: $this.blbdInfo,
                success: function(response) {
                	Swal.alert(['삭제가 완료되었습니다.', 'success']).then(function() {
                		 closeModal($('#notiDetlPopup'));
						 notiMng.searchNotiList(true);
                	});                	
                },
                error: function (response) {
                	Swal.alert([response, 'error']);
                }
            });
		},
		resetUserInfo: function() {
			this.blbdInfo = {
				crud          :'C',
				blbdNo        :'',
				blbdStrtDt    :'',
				blbdExprDt    :'',
	    		checkDupUserId:'N'
	    	}
		},
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
