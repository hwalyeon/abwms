let qnaDetl = new Vue({
    el: "#qnaDetlPopup",
    data: {
    	params: {
			crud         : 'U',
            userId       : '' ,
			qnaNo        : '' , //질의응답_번호
			qustGuarNo   : '' , //질문_보호자_번호
			qustDt       : '' , //질문_일자
			qustCntn     : '' , //질문_내용
			ansCntn      : '' , //답변_내용
			ansUserId    : '' , //답변_사용자_id
    	},
		ansSummerNoteId : 'ansSummerNoteId'
	},
	components: {'summer-note': summernote},
    methods: {

        initialize: function()
		{
        	let $this = this;

			$this.initValue();

        },
		initValue: function()
		{
			let $this = this;
		},

        initPage: function(qnaNo) {
        	
        	let $this = this;

			$('#qnaDetlPopup').modal();

        	$this.resetQnaDetlInfo();
        	
        	if ( !WebUtil.isNull(qnaNo))
    		{
        		let params = {
        			'qnaNo'   : qnaNo   ,
        		}
        		AjaxUtil.post({
                    url: "/cmon/blbd/qnaMng/searchQnaList.ab",
                    param: params,
                    success: function(response) {
                    	if ( !!response.rtnData.result ) {
                    		$.each(response.rtnData.result[0], function(key, val) {
            					$this.params[key] = val;
            				});
                    	}
                    	if(response.rtnData.result[0].ansUserId == '' || response.rtnData.result[0].ansUserId == null){
							$this.params.ansUserId = SessionUtil.getUserId();
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
        	
        	return true;
        },
		saveQustDetlInfo: function() {
			
			let $this = this;

			if (( $this.params.ansUserId != '' && $this.params.ansCntn =='') || ($this.params.ansUserId != null && $this.params.ansCntn ==null) )
			{
				Swal.alert(['저장 대상이 없습니다.', 'info']);
				return false;
			}else{

			AjaxUtil.post(
				{
					url    : "/cmon/blbd/qnaMng/saveInfo.ab",
					param  : $this.params,
					success: function(response) {
						Swal.alert(['저장이 완료되었습니다.', 'success']).then(function() {
							closeModal($('#qnaDetlPopup'));
							//qnaMng.searchQnaList(false);
						});
					},
					error: function (response) {
						Swal.alert([response, 'error']);
					}
				});

			}

		},
		inputCntn: function(){
			let $this = this;
			$this.params.ansUserId  = SessionUtil.getUserId();
		},
		deleteInfo: function() {
			
			let $this = this;
			
			$this.params.crud = 'D';
			
            $this.params.ansCntn   = '';
            $this.params.ansUserId = '';
		},
		resetQnaDetlInfo: function() {

        	let $this = this;

			let userId   = SessionUtil.getUserId();

			this.params = {
				crud         : 'U',
				userId       : userId ,
				qnaNo        : '' , //질의응답_번호
				qustGuarNo   : '' , //질문_보호자_번호
				qustDt       : '' , //질문_일자
				qustCntn     : '' , //질문_내용
				ansCntn      : '' , //답변_내용
				ansUserId    : '' , //답변_사용자_id
	    	}
		}
    },
    computed: {

    },
    watch: {
		'params.ansCntn': function() {
			if (this.params.ansCntn != '') {
				this.params.ansUserId = SessionUtil.getUserId();
			}
		}
    },
    mounted: function() {
        let self = this;
        $(document).ready(function() {
            self.initialize();
        });
    }
});
