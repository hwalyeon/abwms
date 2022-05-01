let bleInfoDetl = new Vue({
    el: "#bleInfoDetlPopup",
    data: {
		params: {
    		crud: 'C' ,
			bleId : '',
			bleInstDt : '',
			bleInstTm : '',			
			locNo : '',
			locNm : '',
			rmrk : '',
			idChk : 'N'
    	},
		code: {

		},
	},

    methods: {

        initialize: function() {
        	let $this = this;
        	$this.initCodeList();
			$this.setDatepicker();
        },
        initCodeList: function() {
        	let $this = this;

        },
        initPage: function(bleId) {
        	let $this = this;
			$this.resetParam();
			if(bleId != null && bleId != '') {
				$this.params.bleId = bleId;
				$this.bleInfoSearch();
			}
        },
        isValid: function() {
        	let $this = this;
        },

		locSearchPop : function (){
        	let $this = this;
			locSearchPopup.initpage( { callback : function(rowData) {
				$this.params.locNo = rowData.locNo;
				$this.params.locNm = rowData.locNm;
			}});
		},
		bleInfoSearch : function(){
			let $this = this;

			AjaxUtil.post({
				url: "/devc/band/bleInfoMng/searchBleInfo.ab",
				param: $this.params,
				success: function(response) {
					if ( !!response.rtnData.result ) {
						$this.params.crud = 'U';
						$.each(response.rtnData.result, function(key, val) {
							$this.params[key] = val;
						});
					}
				},
				error: function (response) {
					Swal.alert([response, 'error']);
				}
			});

		},
		bleDupSearch : function(){
			let $this = this;

			AjaxUtil.post({
				url: "/devc/band/bleInfoMng/searchBleDup.ab",
				param: $this.params,
				success: function(response) {
					if(response.rtnData.dupCnt > 0){
						Swal.alert(["중복된 아이디 입니다.", 'error']);
						$this.params.idChk = 'N';
						return false;
					}else {
						Swal.alert(["사용 가능한 아이디 입니다.", 'info']);
						$this.params.idChk = 'Y';
					}
				},
				error: function (response) {
					Swal.alert([response, 'error']);
				}
			});

		},

		idChange : function (){
			let $this = this;
			$this.params.idChk = 'N';
		},

		saveBleInfo : function (){
        	let $this = this;

			if(WebUtil.isNull($this.params.bleId) && $this.params.bleId == ''){
				Swal.alert(["ID를 입력하여 주시기 바랍니다. ", 'warning']);
				return false;
			}

        	if(WebUtil.isNotNull($this.params.bleInstTm) && $this.params.bleInstTm != ''){
				$this.params.bleInstTm = $this.params.bleInstTm.replaceAll( ':' , '');
			}

        	if(WebUtil.isNotNull($this.params.bleInstDt) && $this.params.bleInstDt != ''){
				$this.params.bleInstDt = $this.params.bleInstDt.replaceAll( '-' , '');
			}

        	if($this.params.crud == 'C' && $this.params.idChk == 'N'){
				Swal.alert(["ID중복 확인 하시기 바랍니다. ", 'warning']);
				return false;
			}

			AjaxUtil.post({
				url: "/devc/band/bleInfoMng/saveBleInfo.ab",
				param: $this.params,
				success: function(response) {
					Swal.alert(['저장이 완료되었습니다.', 'success']).then(function() {
						closeModal($('#bleInfoDetlPopup'));
						bleInfoMng.searchBleInfoList(true);
					});
				},
				error: function (response) {
					Swal.alert([response, 'error']);
				}
			});
		},

		deleteBleInfo : function (){
			let $this = this;
			$this.params.crud = 'D';

			AjaxUtil.post({
				url: "/devc/band/bleInfoMng/saveBleInfo.ab",
				param: $this.params,
				success: function(response) {
					Swal.alert(['삭제 처리 되었습니다.', 'success']).then(function() {
						closeModal($('#bleInfoDetlPopup'));
						bleInfoMng.searchBleInfoList(true);
					});
				},
				error: function (response) {
					Swal.alert([response, 'error']);
				}
			});
		},

		setDatepicker() {
			const $this = this;
			$('#bleInstDtPicker').datepicker({
				todayBtn: "linked",
				keyboardNavigation: false,
				forceParse: false,
				calendarWeeks: true,
				autoclose: true,
				todayHighlight: true,
			}).on("changeDate", function() {
				$this.params.bleInstDt = $('#bleInstDt').val();
			});
		},

		resetParam: function() {
			let $this = this;
			$this.params = {
				crud : 'C',
				bleId : '',
				bleInstDt : '',
				bleInstTm : '',
				locNo : '',
				locNm : '',
				rmrk : '',
				idChk : 'N'
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
