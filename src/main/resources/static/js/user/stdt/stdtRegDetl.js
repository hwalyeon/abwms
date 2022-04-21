let stdtRegDetl = new Vue({
    el: "#stdtRegDetlPopup",
    data: {
		params: {
    		crud: 'C' ,
			stdtNm : '',
			bandId : '',
			eorgLocNo : '',
			sgrdCd : '',
			sexCd : '',
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

			getCommonCodeList('SEX_CD',$this.code.sexCdList);
			getCommonCodeList('SGRD_CD',$this.code.sgrdCdList);
			getCommonCodeList('RACE_DIV_CD',$this.code.raceDivCdList);
        },
        initPage: function() {
        	let $this = this;
			$this.resetParam();
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

		saveStdtRegInfo : function (){
        	let $this = this;

			AjaxUtil.post({
				url: "/user/stdt/stdtInfoMng/saveStdtInfo.ab",
				param: $this.params,
				success: function(response) {
					Swal.alert(['저장이 완료되었습니다.', 'success']).then(function() {
						closeModal($('#stdtRegDetlPopup'));
						stdtInfoMng.searchStdtInfoList(true);
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
				crud : 'C',
				stdtNm : '',
				bandId : '',
				eorgLocNo : '',
				sgrdCd : '',
				sexCd : '',
				raceDivCd : '',
				hghtVal : 0,
				wghtVal : 0,
				wastVal : 0
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
