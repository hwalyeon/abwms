let bandOpenInfoDetl = new Vue({
    el  : "#bandOpenInfoDetlPopup",
    data:
	{
    	params:
		{
    		crud           : 'C',
			userId         : '' ,
			bandIdTemp     : '' ,
			bandId         : '' ,  //밴드_ID
			bandYtypCd     : '' ,  //밴드_출고_년월
			bandMdlCd      : '' ,  //밴드_모델_코드
			telNo          : '' ,  //밴드_전화_번호
			bandOpenStatCd : '' ,  //밴드_개통_상태_코드
			blthId         : '' ,  //블루투스_ID
			apiUrlGramNo   : '' ,  //API_URL_전문_번호
			apiUrlDttm     : '' ,  //API_URL_일시
			openGramNo     : '' ,  //개통_전문_번호
			checkDupBandId : '' ,  //밴드ID_확인_여부
			paging         : 'Y',
			totalCoun      : 0  ,
			rowCount       : 30 ,
			currentPage    : 1  ,
			currentIndex   : 0  ,
			gridData       : []
    	},
		callBack : null,
		code:
		{
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

			getCommonCodeList('BAND_MDL_CD', $this.code.bandMdlCdList);  //밴드_모델_코드_리스트
			getCommonCodeList('BAND_OPEN_STAT_CD', $this.code.bandOpenStatCdList);//밴드_개통_상태_코드_리스트
		},
		initValue: function()
		{
			let $this = this;

			if($this.params.crud === 'C' || $this.params.crud === 'U') {
				if ($this.params.guarTelNo == '') {
					Swal.alert(['보호자 번호는 필수 입력 값 입니다.', 'info']);
					return false;
				}
				$this.initBandYtypCdValue();
				$this.userId = SessionUtil.getUserId();
			}
		},
        initPage: function(bandId, callback)
		{
			let $this = this;

			$this.resetBandOpenInfo();
			if(typeof callback === 'function')
			{
				$this.callBack = callback;
			}
			if (!WebUtil.isNull(bandId))
			{
				let params =
				{
					'bandId' : bandId
				}
				AjaxUtil.post({
					url: "/devc/band/bandOpenInfoMng/searchBandOpenInfoList.ab",
					param: params,
					success: function(response)
					{
						if (!!response.rtnData.result)
						{
							$this.params.crud = 'U';
							$.each(response.rtnData.result[0], function(key, val)
							{
								$this.params[key] = val;
							});
						}
					},
					error: function (response)
					{
						Swal.alert([response, 'error']);
					}
				});
			}
			setTimeout(function()
			{
				$this.initGrid();
				if($this.params.crud != 'C'){
					$this.searchBandOpenInfoGuarTelNoList(true);
				}
			},300);
		},
		initGrid: function()
		{
			let $this = this;
			let colModels = [
				{name: "crud"           , index: "crud"           , label: "crud"		    , hidden: true },
				{name: "bandId"         , index: "bandId"         , label: "밴드ID"         , hidden: true },
				{name: "guarTelNoTemp"  , index: "guarTelNoTemp"  , label: "보호자 전화번호" , hidden: true },
				{name: "guarNo"         , index: "guarNo"         , label: "보호자 번호"     , width: 50     , align: "center"  , formatter: function(cellValue, options, rowObject){
				        if(WebUtil.isNull(cellValue)) return ''; else return cellValue}},
				{name: "guarNm"     , index: "guarNm"    , label: "보호자 이름" 	  , width: 50 , align: "center", formatter: function(cellValue, options, rowObject){
						if(WebUtil.isNull(cellValue)) return ''; else return cellValue}},
				{name: "guarTelNo"  , index: "guarTelNo" , label: "보호자 전화번호" , width: 80 , align: "center", editable:true , editrules:{number:true}}
			];

			$("#guarTelNo_list").jqGrid("GridUnload");
			$("#guarTelNo_list").jqGrid($.extend(true, {}, commonEditGridOptions(),
				{
					datatype : "local",
					mtype    : 'post'  ,
					url      : '/devc/band/bandOpenInfoMng/searchBandOpenInfoGuarTelNoList.ab',
					pager    : '#guarTelNo_pager_list',
					colModel : colModels,
					height   : 150,
					onPaging : function(data)
					{
						onPagingCommon(data, this, function(resultMap)
						{
							$this.params.currentPage  = resultMap.currentPage;
							$this.params.rowCount     = resultMap.rowCount;
							$this.params.currentIndex = resultMap.currentIndex;
							$this.searchBandOpenInfoGuarTelNoList(false);

						})
					},
					afterSaveCell : function (rowid , colId , val, e )
					{
						if($("#guarTelNo_list").getRowData(rowid).crud != "C" && $("#guarTelNo_list").getRowData(rowid).crud != "D" )
						{
						   $("#guarTelNo_list").setRowData(rowid, {crud:"U"});
						}
					}
				}));
			resizeJqGridWidth("guarTelNo_list", "guarTelNo_list_wrapper");
		},
		searchBandOpenInfoGuarTelNoList: function(isSearch)
		{
			let $this  = this;
			let params = {'bandId': $this.params.bandId};

			if ( isSearch )
			{
				params.currentPage = 1;
				params.currentIndex = 0;
			}
			$("#guarTelNo_list").setGridParam({
				datatype    : "json",
				postData    : JSON.stringify(params),
				page        : 1,
				loadComplete: function (response)
				{
					//보호자 전화번호 목록 리스트가 0 이면서 밴드개통상태가 '보호자등록'이면 '개통'으로 변경
					if(response.rtnData.result.length==0 && $this.params.bandOpenStatCd == 'PRNT'){
						$this.params.bandOpenStatCd ='OPEN';
					}
				}
			}).trigger("reloadGrid");
		},
		btnAddRow  :  function()
		{
			let $this  = this;
			let date   = new Date(); //현재 날짜
			var cnt    = $("#guarTelNo_list").jqGrid("getGridParam", "records")+1;
			var addRow =
				{
					crud           : "C"   ,
					guarNo         : ""    ,
					guarTelNo      : ""    ,
					guarNm         : ""    ,
					regDt          : date  ,
					regTm          : date  ,
					regUserId      : $this.userId  ,
					uptDt          : date  ,
					uptTm          : date  ,
					uptUserId      : $this.userId
				};
			$("#guarTelNo_list").addRowData(cnt, addRow);
		},
		btnDelRow : function()
		{
			let checkIds = $("#guarTelNo_list").jqGrid("getGridParam","selrow") + "";  // 단건
			if ( checkIds == "" )
			{
				alert("삭제할 행을 선택해주십시요.");
				return false;
			}
			let checkId = checkIds.split(",");
			for ( var i in checkId )
			{
				if ( $("#guarTelNo_list").getRowData(checkId[i]).crud == "C" )
				{
					$("#guarTelNo_list").setRowData(checkId[i], {crud: "N"});
					$("#"+checkId[i],"#guarTelNo_list").css({display: "none"});
				}
				else
				{
					$("#guarTelNo_list").setRowData(checkId[i], {crud: "D"});
					$("#"+checkId[i],"#guarTelNo_list").css({display: "none"});
				}
			}
		},
		//출고_년월_리스트_값 세팅
		initBandYtypCdValue: function()
		{
			let $this = this;
			for (let i = 2022; i < 2032; i++)
			{
				let cdVal;
				let cdNm;
				for (let j = 1; j < 13; j++)
				{
					if (j < 10)
					{
						cdVal = i + '0'  + j;
						cdNm  = i + '-0' + j;
						$this.code.bandYtypCdList.push({'cdVal': cdVal, 'cdNm': cdNm});
					}else
					{
						cdVal = String(i) + j;
						cdNm  = i  + '-'  + j;
						$this.code.bandYtypCdList.push({'cdVal': cdVal, 'cdNm': cdNm});
					}
				}
			}
		},
		isValid: function()
		{
			let $this = this;
			let gridData = $this.params.gridData;

			if ( $this.params.crud === 'C' ) {
				if ( $this.params.checkDupBandId != 'Y' ) {
					Swal.alert(['ID 확인을 하지 않았습니다.', 'info']);
					return false;
				}
				if($this.params.bandId != $this.params.bandIdTemp) {
					Swal.alert(['ID 확인을 하지 않았습니다.', 'info']);
					return false;
				}
			}
			return true;
		},
		//밴드 ID 중복 검사
		searchDupBandId: function()
		{

        	let $this = this;

			let bandIdStr2 = $this.params.bandId.substr(1,1);
			let bandIdStr3 = $this.params.bandId.substr(2,1);

        	if ( WebUtil.isNull($this.params.bandId) ) {
        		Swal.alert(['밴드ID를 입력하세요.', 'info']);
        		return false;
        	}if($this.params.bandId.length != 10) {
        		Swal.alert(['밴드ID의 자리수는 10자리입니다.', 'info']);
        		return false;
        	}if(bandIdStr2 != 0 && bandIdStr2 != 1 ) {
				Swal.alert(['ID의 2번째 자리는 0,1 중 선택해야 합니다.', 'info']);
				return false;
			}
			if(bandIdStr2 == 0 && bandIdStr3 == 0 ) {
				Swal.alert(['ID의 2번째, 3번째 자리에 동시에 0을 입력할 수 없습니다.', 'info']);
				return false;
			}

			let params = {
				bandId : $this.params.bandId
			};
			AjaxUtil.post({
                url    : "/devc/band/bandOpenInfoMng/searchDupBandId.ab",
                param  : params,
                success: function(response)
				{
                	if ( response.rtnData.result.existsYn === 'N' )
                	{
                		$this.params.checkDupBandId = 'Y';
                		$this.params.bandIdTemp = $this.params.bandId;
                		Swal.alert(['해당 아이디는 사용할 수 있습니다.', 'success']);
                	} else
                	{
                		$this.params.BandId = '';
                		Swal.alert(['해당 아이디는 이미 사용중입니다.', 'info']);
                	}
                },
                error: function (response) {
                	Swal.alert([response, 'error']);
                }
            });
        },
		//밴드ID 입력 시 출고 년월,밴드 모델 코드 NULL
		bandIdInput: function()
		{
        	let $this = this;

			$this.params.bandYtypCd = '';   //출고_년월_코드
        	$this.params.bandMdlCd  = '';   //밴드_모델_코드
		},
		//출고 년월,밴드 모델 코드 선택 시 밴드ID NULL
		numberingSelect: function()
		{
        let $this = this;

        $this.params.bandId = '';
		},
		//밴드ID 채번
		numberingBandId: function()
		{
			let $this = this;

			if ( WebUtil.isNull($this.params.bandYtypCd) ) {
				Swal.alert(['출고년월을 선택하세요.', 'info']);
				return false;
			}if ( WebUtil.isNull($this.params.bandMdlCd) ) {
				Swal.alert(['모델타입을 선택하세요.', 'info']);
				return false;
			}
			$this.params.checkDupBandId = 'N';

			AjaxUtil.post({
				url    : "/devc/band/bandOpenInfoMng/numberingBandId.ab",
				param  : $this.params,
				success: function(response) {
					if ( !!response.rtnData.result ) {
						$this.params.bandId = response.rtnData.result.result.bandId;
					}
				},
				error: function (response) {
					Swal.alert([response, 'error']);
				}
			});
		},
		saveBandOpenInfoDetl: function() {

			let $this = this;


			//params에 gridData값 세팅
			$this.params.gridData = commonGridGetDataNew($("#guarTelNo_list"));
			let guarTelNoList = $("#guarTelNo_list").jqGrid("getRowData");


			$this.params.bandMdlCd = ($this.params.bandId).substr(3,1);

			let gridData = $this.params.gridData;


			console.log(guarTelNoList);



			let cnt = 0;
			if(guarTelNoList.indexOf('C')){
				cnt = +1;
			}

			if(guarTelNoList.length==0)

			return false;



			//값 검증
			if (!this.isValid()) {
				return false;
			}

			AjaxUtil.post({
                url     : "/devc/band/bandOpenInfoMng/saveBandOpenInfoDetl.ab",
                param   : $this.params,
                success : function(response) {
                	Swal.alert(['저장이 완료되었습니다.', 'success']).then(function()
					{
                		 closeModal($('#bandOpenInfoDetlPopup'));
                	 	 if($this.callBack != null ) $this.callBack();

					});
                },
                error: function (response) {
                	Swal.alert([response, 'error']);
                }
            });
		},
		deleteUser: function()
		{
			let $this = this;

			$this.params.crud     = 'D';
			$this.params.gridData = $("#guarTelNo_list").jqGrid("getRowData");

            //행 삭제 버튼 클릭 없이 삭제 진행 시 gridData.crud 값 삽입
			if($this.params.gridData != null)
			{
				for(var i=0; $this.params.gridData.length > i; i++ ){

					$this.params.gridData[i].crud='D';
				}
			}

            AjaxUtil.post({
                url: "/devc/band/bandOpenInfoMng/saveBandOpenInfoDetl.ab",
                param: $this.params,
                success: function(response) {
                	 Swal.alert(['삭제가 완료되었습니다.', 'success']).then(function()
					 {
                		  closeModal($('#bandOpenInfoDetlPopup'));
						  if($this.callBack != null ) $this.callBack();
					 });
                },
                error: function (response) {
                	Swal.alert([response, 'error']);
                }
            });
		},
		resetBandOpenInfo: function() {
			this.params = {
				crud           : 'C',
				userId         : '' ,
				bandIdTemp     : '' ,
				bandId         : '' ,  //밴드_ID
				bandYtypCd     : '' ,  //밴드_출고_년월
				bandMdlCd      : '' ,  //밴드_모델_코드
				telNo          : '' ,  //밴드_전화_번호
				bandOpenStatCd : '' ,  //밴드_개통_상태_코드
				blthId         : '' ,  //블루투스_ID
				apiUrlGramNo   : '' ,  //API_URL_전문_번호
				apiUrlDttm     : '' ,  //API_URL_일시
				openGramNo     : '' ,  //개통_전문_번호
				checkDupBandId : '' ,  //밴드ID_확인_여부
				paging         : 'Y',
				totalCoun      : 0  ,
				rowCount       : 30 ,
				currentPage    : 1  ,
				currentIndex   : 0
	    	}
		},
    },
    computed:
	{
    },
    watch: {
    	'params.bandId': function(newVal, oldVal) {
    		this.params.checkDupBandId = 'N';
		},
    },
    mounted: function() {
        let self = this;
        $(document).ready(function()
		{
            self.initialize();
        });
    }
});
