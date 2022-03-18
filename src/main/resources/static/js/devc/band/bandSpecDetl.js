let bandSpecDetl = new Vue({
    el: "#bandSpecDetlPopup",
    data: {
    	params: {
    		crud           : 'C',
			userId         : '' ,
			bandIdTemp     : '' ,
			bandId         : '' ,  //밴드_ID
			bandYtypCd     : '' ,  //밴드_출고_년월
			bandMdlCd      : '' ,  //밴드_모델_코드
			telNo          : '' ,  //밴드_전화_번호
			bandOpenStatCd : '' ,  //밴드_개통_상태_코드
			blthId         : ''    //블루투스_ID
    	},
		callBack : null,
		code: {
			bandOpenStatCdList : [] , //밴드_개통_상태_코드_리스트
			bandYtypCdList     : [] , //밴드_출고년월_리스트
			bandMdlCdList      : [] , //밴드_모델_코드_리스트
		}
	},
    methods:
		{
        initialize: function()
		{
        	let $this = this;

        	$this.initValue();
        	$this.initCodeList();
        },
        initCodeList: function()
		{
        	let $this = this;
			getCommonCodeList('BAND_MDL_CD', $this.code.bandMdlCdList);           //밴드_모델_코드_리스트
			getCommonCodeList('BAND_OPEN_STAT_CD', $this.code.bandOpenStatCdList);//밴드_개통_상태_코드_리스트
		},
		initValue()
		{
			let $this = this;
		},
        initPage: function(bandId, guarTelNo, callback)
		{
			let $this = this;

			if(typeof callback === 'function'){
				$this.callBack = callback;
			}

			$this.resetBandSpec();

			if ( !WebUtil.isNull(bandId) )
			{
				let params = {
					'bandId'    : bandId ,
					'guarTelNo' : guarTelNo
				}
				AjaxUtil.post({
					url: "/devc/band/bandOpenInfoMng/searchBandOpenInfoList.ab",
					param: params,
					success: function(response) {
						if ( !!response.rtnData.result )
						{
							console.log(response.rtnData.result);
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
		saveBandOpenInfoDetl: function() {
			
			let $this = this;

			$this.params.gridData = commonGridGetDataNew($("#growStnd_list"));


			AjaxUtil.post({
                url: "/devc/band/bandOpenInfoMng/saveBandOpenInfoDetl.ab",
                param: $this.params,
                success: function(response) {
                	Swal.alert(['저장이 완료되었습니다.', 'success']).then(function() {
                		//모달종료
                		closeModal($('#bandSpecDetlPopup'));
                		//팝업 호출한 화면으로 돌아가서 함수 실행
                		if($this.callBack != null ) $this.callBack();
                	});                	
                },
                error: function (response) {
                	Swal.alert([response, 'error']);
                }
            });
		},

		deleteUser: function() {
			
			let $this = this;
			
			$this.params.crud = 'D';
			
            AjaxUtil.post({
                url: "/devc/band/bandOpenInfoMng/saveBandOpenInfoDetl.ab",
                param: $this.params,
                success: function(response) {
                	Swal.alert(['삭제가 완료되었습니다.', 'success']).then(function() {
                		 closeModal($('#bandSpecDetlPopup'));
						if($this.callBack != null ) $this.callBack();
                	});
                },
                error: function (response) {
                	Swal.alert([response, 'error']);
                }
            });
		},
		resetBandSpec: function() {
			this.params = {
				crud           : 'C',
				userId         : '' ,
				bandIdTemp     : '' ,
				bandId         : '' ,  //밴드_ID
				bandYtypCd     : '' ,  //밴드_출고_년월
				bandMdlCd      : '' ,  //밴드_모델_코드
				telNo          : '' ,  //밴드_전화_번호
				bandOpenStatCd : '' ,  //밴드_개통_상태_코드
				blthId         : ''    //블루투스_ID
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
