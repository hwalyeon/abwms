var navigation = null;
navigation = new Vue({
	el: '#navigation',
	data: {
        searchAuthParam : {
            searchClass : '01',
            empNo : 0
        },
        currentMenu: null,
        menuTree: [],
        menuList: [
	/*
			{ menuNo: 'A', upprMenuNo: '0', menuNm: '작업정의', menuUrl: '/def', menuId: 'A', menuPath: '작업정의', menuIcon: 'fa fa-book', lev:0, child: [
                { menuNo: 'A010', upprMenuNo: 'A', menuNm: '워크스페이스관리', menuUrl: '/def/wsMng', menuId: 'A010', menuPath: '작업정의 > 워크스페이스관리', menuIcon: '', lev:1, child: []},
                { menuNo: 'A020', upprMenuNo: 'A', menuNm: '작업셋관리', menuUrl: '/def/jsetMng' , menuId: 'A020', menuPath: '작업정의 > 작업셋관리', menuIcon: '', lev:1, child: []},
                { menuNo: 'A030', upprMenuNo: 'A', menuNm: '워크플로우관리', menuUrl: '/def/jobMng' , menuId: 'A030', menuPath: '작업정의 > 단위작업관리', menuIcon: '', lev:1, child: []},
                { menuNo: 'A040', upprMenuNo: 'A', menuNm: '단위작업관리', menuUrl: '/def/schdMng' , menuId: 'A040', menuPath: '작업정의 > 스케줄러관리', menuIcon: '', lev:1, child: []}
            ]},
			{ menuNo: 'B', upprMenuNo: '0', menuNm: '작업실행', menuUrl: '/exec', menuId: 'B', menuPath: '작업실행', menuIcon: 'fa fa-clock-o', lev:0, child: [
                { menuNo: 'B010', upprMenuNo: 'B', menuNm: '종합현황', menuUrl: '/exec/totStat', menuId: 'B010', menuPath: '작업실행 > 종합현황', menuIcon: '', lev:1, child: []},
			    { menuNo: 'B020', upprMenuNo: 'B', menuNm: '워크플로우현황', menuUrl: '/exec/flowStat', menuId: 'B020', menuPath: '작업실행 > 워크플로우현황', menuIcon: '', lev:1, child: []},
                { menuNo: 'B030', upprMenuNo: 'B', menuNm: '단위작업현황', menuUrl: '/exec/jobStat', menuId: 'B030', menuPath: '작업실행 > 단위작업현황', menuIcon: '', lev:1, child: []}
            ]},
			{ menuNo: 'C', upprMenuNo: '0', menuNm: '이력/보고서', menuUrl: '/hist', menuId: 'C', menuPath: '이력/보고서', menuIcon: 'fa fa-bar-chart-o', lev:0, child: [
                { menuNo: 'C010', upprMenuNo: 'C', menuNm: '작업요약', menuUrl: '/hist/jobSumm', menuId: 'C010', menuPath: '이력/보고서 > 작업요약', menuIcon: '', lev:1, child: []},
                { menuNo: 'C020', upprMenuNo: 'C', menuNm: '작업이력', menuUrl: '/hist/jobHist', menuId: 'C020', menuPath: '이력/보고서 > 작업이력', menuIcon: '', lev:1, child: []},
                { menuNo: 'C050', upprMenuNo: 'C', menuNm: '알람이력', menuUrl: '/hist/notiHist', menuId: 'C050', menuPath: '이력/보고서 > 알람이력', menuIcon: '', lev:1, child: []}
            ]},
            { menuNo: 'D', upprMenuNo: '0', menuNm: '설정/관리', menuUrl: '/set', menuId: 'D', menuPath: '설정/관리', menuIcon: 'fa fa-cog', lev:0, child: [
                { menuNo: 'D010', upprMenuNo: 'D', menuNm: '에이전트관리', menuUrl: '/set/agntMng', menuId: 'D010', menuPath: '설정/관리 > 에이전트관리', menuIcon: '', lev:1, child: []},
                { menuNo: 'D020', upprMenuNo: 'D', menuNm: '사용자관리', menuUrl: '/set/userMng', menuId: 'D020', menuPath: '설정/관리 > 사용자관리', menuIcon: '', lev:1, child: []},
                { menuNo: 'D030', upprMenuNo: 'D', menuNm: '역할관리', menuUrl: '/set/roleMng', menuId: 'D030', menuPath: '설정/관리 > 역할관리', menuIcon: '', lev:1, child: []},
                { menuNo: 'D040', upprMenuNo: 'D', menuNm: '메뉴관리', menuUrl: 'set/menuMng', menuId: 'D040', menuPath: '설정/관리 > 메뉴관리', menuIcon: '', lev:1, child: []},
                { menuNo: 'D050', upprMenuNo: 'D', menuNm: '메뉴역할관리', menuUrl: '/set/menuRoleMng', menuId: 'D050', menuPath: '설정/관리 > 메뉴역할관리', menuIcon: '', lev:1, child: []},
                { menuNo: 'D060', upprMenuNo: 'D', menuNm: '공통코드관리', menuUrl: '/set/cdMng', menuId: 'D060', menuPath: '설정/관리 > 공통코드관리', menuIcon: '', lev:1, child: []},
                { menuNo: 'D070', upprMenuNo: 'D', menuNm: '알람관리', menuUrl: '/set/notiMng', menuId: 'D070', menuPath: '설정/관리 > 알람관리', menuIcon: '', lev:1, child: []},
                { menuNo: 'D080', upprMenuNo: 'D', menuNm: '라이센스정보', menuUrl: '/set/licMng', menuId: 'D080', menuPath: '설정/관리 > 라이센스정보', menuIcon: '', lev:1, child: []}
            ]},
//            { menuNo: 'E', menuNm: '샘플', menuUrl: '', menuId: 'E', menuPath: '샘플', menuIcon: 'fa fa-cog', lev:0, child: [
//                { menuNo: 'E010', menuNm: '전체', menuUrl: '/schd/comp/overview', menuId: 'E010', menuPath: '샘플 > 전체', menuIcon: '', lev:1, child: []},
//                { menuNo: 'E020', menuNm: '핸들', menuUrl: '/schd/comp/handle', menuId: 'E020', menuPath: '샘플 > 핸들', menuIcon: '', lev:1, child: []},
//                { menuNo: 'E030', menuNm: '이벤트', menuUrl: '/schd/comp/event', menuId: 'E030', menuPath: '샘플 > 이벤트', menuIcon: '', lev:1, child: []},
//                { menuNo: 'E040', menuNm: '함수', menuUrl: '/schd/comp/func', menuId: 'E040', menuPath: '샘플 > 함수', menuIcon: '', lev:1, child: []},
//                { menuNo: 'E050', menuNm: '커스텀', menuUrl: '/schd/comp/custom', menuId: 'E050', menuPath: '샘플 > 커스텀', menuIcon: '', lev:1, child: []}                
//            ]}*/
        ]

	},
	/* Vue Instance 내 method 정의 */
	methods: {
        getMenuList: function() {

            let $this = this;

            if ( $this.searchAuthParam.searchClass == '' || $this.searchAuthParam.empNo < 0) {
                return;
			}
            
            AjaxUtil.post({
                url: "/cmon/menu/searchMenuList.ab",
                param: $this.searchAuthParam,
                success: function(response) {

                    // 1뎁스
                    let data = response.rtnData.result;
                    data.filter(menu => menu.levl === 1).forEach(menu => {
                        const pos = $this.menuList.push({...menu, child:[], active: false, idPath: [menu.menuNo]});
                        $this.menuTree.push($this.menuList[pos - 1]);
                    });

                    // 나머지뎁스
                    data.filter(menu => menu.levl !== 1).forEach(menu => {
                        if ( !!menu.menuUrl ) {
                            menu.menuUrl = menu.menuUrl + '.pg';
                        }
                        const sub = {...menu, child:[], active: false, idPath: [menu.menuNo]};
                        $this.menuList.push(sub);

                        const parentMenu = $this.menuList.find(m => m.menuNo === sub.upprMenuNo);
                        sub.idPath.push(...parentMenu.idPath);
                        parentMenu.child.push(sub);
                    });

                    Vue.nextTick(() => {
                        document.querySelectorAll(".sidebar-collapse .nav").forEach(el => {
                            el.style.setProperty("--max-height", el.scrollHeight + "px");
                        });
                    });
                },
                error: function (response) {
                	Swal.alert([response, 'error']);
                }
            });
        },
        getSortOrd: function(menuNo) {
            let sortOrd = 0;
            if ( !!menuNo.substring(1) ) {
                sortOrd = Number(menuNo.substring(1));
            }
            return sortOrd;
        },
        // 탭에 의한 메뉴 선택
        selectMenu: function(menuNo) {
            this.menuList.filter(menu => menu.active).forEach(menu => menu.active = false);

            if (menuNo === '1') {
                this.currentMenu = null;
                return;
            }
            this.currentMenu = this.menuList.find(menu => menu.menuNo === menuNo);
            this.activeMenu(this.currentMenu);
        },

        // 선택된 메뉴 활성화
        activeMenu: function(menu) {
            let $this = this;
            if ( !!menu ) {
                menu.active = true;
                const paths = menu.idPath;
                if (paths.length > 1) {
                    for (const path of paths) {
                        const selMenu = $this.menuList.find(m => m.menuNo === path);
                        if (selMenu) {
                            selMenu.active = true;
                        }
                    }
                }
            }
        },

        // 탭 추가 또는 하위메뉴 열기
        handlerMenu: function(menu) {
            if ( !!menu.menuUrl )
            {
                this.currentMenu = menu;
                menu.active = true;
                // this.$emit('add:tab', {name: menu.menuNm, url: menu.menuUrl, id: menu.menuNo});
                this.selectMenu(menu.menuNo);
                index.newTab(menu);
            }
            else
            {
                if ( menu.active )
                {
                    menu.active = false;
                }
                else
                {
                    this.menuList.filter(menu => menu.active).forEach(menu => menu.active = false);
                    this.activeMenu(menu);
                }
            }
        },

        getMenuFromId: function(id) {
            const flatMenus = _.flatMapDeep(this.menuList);
            const menu = flatMenus.find(m => m.menuNo === parseInt(id));
            if (menu) {
                return {name: menu.menuNm, url: menu.menuUrl, id: menu.menuNo};
            }
            return null;
        },

        getMenuFromUrl: function(url, simulate = false) {
            const flatMenus = _.flatMapDeep(this.menuList);
            const menu = flatMenus.find(m => m.menuUrl === url);
            if (!menu && simulate) {
                return flatMenus.find(m => m.menuUrl.indexOf(url) === 0);
            }
            if (menu) {
                return {name: menu.menuNm, url: menu.menuUrl, id: menu.menuNo};
            }
            return null;
        }
	},
	mounted: function () {
        this.getMenuList();
	},
    updated: function () {
    	// $('#side-menu').metisMenu();
    }
})
	