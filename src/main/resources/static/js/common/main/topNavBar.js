var topNavBar = null;
topNavBar = new Vue({
	el: '#topNavBar',
	data: {
        userNm: ''
	},
	methods: {
        init: function() {
            this.userNm = SessionUtil.getUserNm();
        },
        totMonStatPop: function() {
            openWinPop({
                name: '종합관제현황',
                url: '/oper/cmon/totMonStat.pg',
                width: screen.width,
                height: screen.height,
            });
        },
        logout: function() {
            index.logout();
        }
	},
	mounted: function () {
		let $this = this;
        $this.init();
	}
})
	