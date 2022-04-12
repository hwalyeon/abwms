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
			 sexCdList: []
			,sgrdCdList: []
			,raceDivCdList : []
		},
		selectItem: {
			text: '',
			value: '',
		}
	},

    methods: {

        initialize: function() {

        	let $this = this;

        	$this.initCodeList();

        },
        initCodeList: function() {
        	let $this = this;
        },
        initPage: function() {
        	let $this = this;
        },
        isValid: function() {
        	let $this = this;
        },

		eorgLocPop : function (){
        	let $this = this;
			stdtEorgLocPop.initPage( { callback : function(rowData) {
					$this.params.eorgLocNo = rowData.locNo;
					$this.params.eorgLocNm = rowData.locNm;
			}});
		},

		bandListPop : function (){
			let $this = this;
			bandPop.initPage( { callback : function(rowData) {
					$this.params.bandId = rowData.bandId;
			}});
		},

		//학생 및 보호자 정보 search 팝업
		stdtGuarDetlPopup: function() {
			stdtGuarDetl.initialize(this.setData);
		},

		//(학생 및 보호자 번호 , 학교명) 팝업 Grid 값 부모창 input 값에 삽입
		setData: function(data) {
			console.log(data);
			let $this = this;
			if(data.stdtNo !== undefined && data.stdtNm !== undefined && data.guarNo !== undefined && data.guarNm !== undefined)
			{
				$this.params.stdtNo = data.stdtNo;
				$this.params.stdtNm = data.stdtNm;
				$this.params.guarNo = data.guarNo;
				$this.params.guarNm = data.guarNm;
			}
			if(data.locNm !== undefined)
			{
				$this.params.locNm  = data.locNm;
			}
		},

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

		resetParam: function() {
			let $this = this;
			$this.params = {
				crud : 'C'
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
