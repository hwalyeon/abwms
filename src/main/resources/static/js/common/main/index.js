const index = new Vue({
	el: '#indexApp',
	data: {
		MAX_TAB_CNT: 10,
		frameResizeObserver: null,
		menuList: [
			{ menuNm: 'Main', menuUrl: '/main.pg', menuNo: '1', active: true, interval: null}
		],	
        params : {
            userId : 'admin',
            userNm : '원격사용자'
        },
		currentTab: '1'
	},
	methods: {
		loadFrame: function (id) {
			const $target = document.querySelector("#tabFrame_" + id);

			const $content = $target.contentWindow.document.querySelector("#wrapper");
			$content.setAttribute("data-frame", $target.getAttribute("data-frame"));
			this.resetFrameContentHeight($target);
			this.frameResizeObserver.observe($content);
		},
		resetFrameContentHeight: function ($frame) {
			const $content = $frame.contentWindow.document.querySelector("#wrapper");
			let clientHeight = $content.scrollHeight + 40;
			if (document.querySelector("#tab-content").getClientRects().length !== 0) {
				let appHeight = window.innerHeight
					- (document.querySelector("#tab-content").getClientRects()[0].top
						// + document.querySelector("#tab-content > div.panel-heading").clientHeight	// 여기 버전은 없음
						+ document.querySelector(".footer").clientHeight)
				;
				if (appHeight > clientHeight) {
					clientHeight = appHeight;
				}
			}
			$frame.style.height = clientHeight + "px";
		},
		windowOpen: function (id) {
			const w = 1024;
			const h = 768;
			const currentFrameSrc = document.querySelector('#tabFrame_' + id).getAttribute('src');
			if (currentFrameSrc) {
				const name = "window_" + id;
				// 윈도우 팝업 중앙으로 열기
				openWinPop({
					name: name,
					url: currentFrameSrc,
					width: w,
					height: h
				});
			}
		},
		reloadTab: function (id) {
			const tabId = `#tabFrame_${id}`;
			const currentFrameSrc = document.querySelector(tabId).getAttribute('src');
			if (currentFrameSrc) {
				const elm = document.querySelector(tabId).contentWindow.document.querySelector("#wrapper");
				this.frameResizeObserver.unobserve(elm);

				document.querySelector(tabId).setAttribute('src', currentFrameSrc);
			}
		},
		// 기 추가된 Tab 인지 체크
		checkTab: function (menuNo) {
			if (this.menuList.find(menu => menu.menuNo === menuNo)) {
				this.currentTab = menuNo;
				return false;
			} else {
				if (this.menuList.length > this.MAX_TAB_CNT) {
					Swal.alert(['탭은 10개까지 열수 있습니다.', "info"]);
					return false;
				}
			}
			return true;
		},
		newTab: function(menu) {
			if (this.checkTab(menu.menuNo)) {
				this.currentTab = menu.menuNo;
				this.menuList.push({
					menuNm: menu.menuNm,
					menuUrl: menu.menuUrl,
					menuNo: menu.menuNo,
					active: true,
					interval: null
				});
				this.onFocusTab(menu.menuNo);
			}
		},
		onFocusTab: function (menuNo) {
			this.$nextTick(() => {
				const tabContainer = document.getElementById("tab-list");
				const tab = document.getElementById("tab-menu-" + menuNo);
				const ctxRect = tabContainer.getBoundingClientRect();
				const tabRect = tab.getBoundingClientRect();
				if (ctxRect.x > tabRect.x) {
					tabContainer.scrollBy(tabRect.x - ctxRect.x, 0);
				} else if (ctxRect.right < tabRect.right) {
					tabContainer.scrollBy(tabRect.right - ctxRect.right, 0);
				}
			});
		},
		activeTab(menuNo) {
			this.currentTab = menuNo;
			navigation.selectMenu(menuNo);
			this.onFocusTab(menuNo);
		},
		moveTab: function (direction, offset = 150) {
			const tabContainer = document.querySelector("ul#tab-list");
			if (direction === "left" && tabContainer.scrollLeft > 0) {
				tabContainer.scrollBy(-offset, 0);
			} else if (direction === "right" && (tabContainer.clientWidth + tabContainer.scrollLeft) < tabContainer.scrollWidth) {
				tabContainer.scrollBy(offset, 0);
			}
		},
		closeTab: function (menuNo) {
			const menuIndex = this.menuList.findIndex(m => m.menuNo === menuNo);
			Swal.confirm(["열려진 Tab이 삭제됩니다. 해당 메뉴에 저장하지 않으신 정보가 있으시면 저장해 주세요.\nTab을 삭제하시겠습니까?", "warning"])
				.then((value) => {
					if (value) {
						// selected menu remove in array
						this.closeAllInterval([menuNo]);
						this.menuList.splice(menuIndex, 1);

						this.activeTab(this.menuList[this.menuList.length - 1].menuNo);
						this.$nextTick(() => {
							this.moveTab('right', 0);
						});
					}
				});
		},
		closeAllTabs: function () {
			let $this = this;
			const tabs = $("#tab-list li:not(:first)");

			if (tabs.length > 0) {
				Swal.confirm(["열려진 Tab이 삭제됩니다. 해당 메뉴에 저장하지 않으신 정보가 있으시면 저장해 주세요.\nTab을 삭제하시겠습니까?", "warning"])
					.then(function (value) {
						if (value) {

							$this.closeAllInterval(
								$this.menuList
									.reduce((pv, cv) => {
										if (cv.menuNo !== '1') pv.push(cv.menuNo);
										return pv;
									}, [])
							);
							$this.menuList.splice(1);
							$this.activeTab('1');

							Swal.alert(["탭이 모두 삭제되었습니다.", "success"]);
						}
					});
			}
		},
		closeAllInterval: function (menuIndex) {
			for (var index in this.menuList) {
				if (index >= menuIndex) {
					clearInterval(this.menuList[index].interval);
					this.menuList[index].interval = null;

				}
			}
		},
		logout: function() {

			let $this = this;

			AjaxUtil.post({
				url: "/v1/auth/logout.ab",
				param: $this.params,
				success: function(response) {

					SessionUtil.initSession();

					window.location.href = "/login.pg";
				},
				error: function (response) {
					Swal.alert([response, 'info']);
				}
			});
		},
	},
	created: function () {
		let $this = this;
		$this.frameResizeObserver = new ResizeObserver(entries => {
			for (let entry of entries) {
				const $content = entry.target;
				const $frame = document.querySelector(".tab-content iframe[data-frame='" + $content.getAttribute("data-frame") + "']");
				this.resetFrameContentHeight($frame);
			}
		});

		$this.$on('SET_PARAM', function(param) {
			$this.$emit('GET_PARAM', param);
		});
	},
	mounted: function () {
		let currentFrameId = null;
		setInterval(() => {
			if (document.activeElement && document.activeElement.tagName === "IFRAME") {
				if ( document.activeElement !== currentFrameId ) {
					currentFrameId = document.activeElement;
					this.onFocusTab(currentFrameId.getAttribute("data-frame"));
				}
			}
			else {
				currentFrameId = null;
			}
		}, 100);
	},
	updated: function () {
        // updateI18NextContent();
	},
	destroyed: function () {
		if (this.frameResizeObserver !== null) {
			this.frameResizeObserver.disconnect();
		}
	},
	computed: {
		currentMenu() {
			return this.menuList.find(menu => menu.menuNo === this.currentTab);
		}
	},
});

window.index = index;