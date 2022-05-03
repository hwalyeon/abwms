let alamDetl = new Vue({
    el: "#alamDetlPopup",
    data: {
		params: {
    		crud: 'C' ,
			guarNo:'',
			stdtNo:'',
			userId:'',
			alamTitl:'',
			etcAlamCntn:'',
			alamTypeCd:'99',
			raceDivCd : '',
			hghtVal : 0,
			wghtVal : 0,
			wastVal : 0

    	},
		code: {
		}
	},

    methods: {

        initialize: function() {

        	let $this = this;

        	//$this.initCodeList();

        },
		//학생 및 보호자 정보 search 팝업
		stdtGuarDetlPopup: function() {
			let $this = this;
			stdtGuarPopup.initPage({ callback : function(rowData) {
					$this.params.stdtNo = rowData.stdtNo;
					$this.params.stdtNm = rowData.stdtNm;
					$this.params.guarNo = rowData.guarNo;
					$this.params.guarNm = rowData.guarNm;
			}});
		},

		//알림내용 보내기
		sendData : function (){
        	let $this = this;

			AjaxUtil.post({
				url: "/stat/hc/alamDetl/sendAlamList.ab",
				param: $this.params,
				success: function(response) {
					Swal.alert(['전송이 완료되었습니다.', 'success']).then(function() {
						closeModal($('#alamDetlPopup'));
					});
				},
				error: function (response) {
					Swal.alert([response, 'error']);
				}
			});
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
