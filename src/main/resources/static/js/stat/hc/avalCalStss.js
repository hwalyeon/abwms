let avalCalStss = new Vue({
    el: "#avalCalStss",
    data:
    {
        params:
        {
            stndDtFr    : '' ,
            stndDtTo    : '' ,
            stndMmFr    : '' ,
            stndMmTo    : '' ,
            perdDivCd   : 'DAY',
            occrDivCd   : '02',
            sexCd       : '' ,
            ageYcntFr   : '' ,
            ageYcntTo   : '' ,
            totalCount  : 0  ,
            rowCount    : 30 ,
            currentPage : 1  ,
            currentIndex: 0
        },
        code :
        {
            perdDivList : [] ,
            stndDtList  : [] ,
            sexCdList   : []
        },
    },
     mixins: [statComponent],
     methods:
     {

        initialize: function()
        {
            let $this = this;

            $this.initCodeList();

            $this.initChart();

            $this.setDatepicker();

            $this.initData();

            $this.initSearch();
        },
        initCodeList: function()
        {
            let $this = this;

            $this.statCodeList();
        },
         // 기본 날짜 세팅
         initData : function ()
         {
             let $this = this;

             $this.statInitData();
         },
         initSearch: function()
        {
            let $this = this;

            if(!$this.isValid())
            {
                return false;
            }

            AjaxUtil.post(
            {
                url    : "/stat/hc/avalCalStss/searchAvalCalStssColList.ab",
                param  : $this.params,
                success: function(response)
                {
                    $this.code.stndDtList = [];
                    if ( !!response.rtnData.stndDtList && response.rtnData.stndDtList.length > 0 ) {
                        $.each(response.rtnData.stndDtList, function(index, item) {
                            $this.code.stndDtList.push({'stndDt':item.stndDt});
                        });
                    }
                    // 차트초기화 및 조회
                    $this.initGrid();
                    $this.searchAvalCalStssList(true);
                },
                error: function (response) {
                    Swal.alert([response, 'error']);
                }
            });
        },
         initGrid: function()
         {
             let $this = this;

             let colModels =
             [
                 {name: "divCd", index: "divCd", label: "구분", width:80, align: "center" }
             ];

             if($this.code.stndDtList.length > 0){
                 for(var i in $this.code.stndDtList ){
                     var data = $this.code.stndDtList[i];
                     colModels.push( {name:data.stndDt , index:data.stndDt , label:data.stndDt ,  width: 80} );
                 }
             }

             $("#avalCal_list").jqGrid("GridUnload");
               $("#avalCal_list").jqGrid($.extend(true, {}, commonGridOptions(), {
                   datatype : "local",
                   mtype    : 'post',
                   pginput  : false,
                   height   : 30,
                   url      : '/stat/hc/avalCalStss/searchAvalCalStssList.ab',
                   colModel : colModels
               }));

               resizeJqGridWidth("avalCal_list", "avalCal_list_wrapper");

         },
         initChart: function ()
         {
             let $this = this;

             if ($this.chartAvalCal != null )  $this.chartAvalCal.destroy();
             let dataAvalCal = {
                 labels  : [],
                 datasets: [
                     {
                         label: '칼로리 섭취량(㎉)',
                         data: [],
                         borderColor : "#d6e5eb",
                         backgroundColor: "#d6e5eb",
                         order : 1
                     } ,
                 ]
             };

             let optionsAvalCal = {
                 responsive : false,
                 plugins: {
                     legend: {
                         position: 'top',
                         display : false
                     },
                     tooltip : {
                         enabled : true
                     }
                 }
             };

             let ctxAvalCal = document.getElementById('avalCalChart').getContext('2d');

             let configAvalCal = {
                 type   : 'bar',
                 data   : dataAvalCal,
                 options: optionsAvalCal,
                 plugins: [ChartDataLabels]
             };

             $this.chartAvalCal = new Chart(ctxAvalCal, configAvalCal);
         },
         searchAvalCalStssList: function(isSearch )
         {
              let $this  = this;
              let params = $.extend(true, {}, $this.params);

              if ( isSearch )
              {
                  params.currentPage = 1;
                  params.currentIndex = 0;
              }


              $("#avalCal_list").setGridParam
              ({
                  datatype    : "json",
                  postData    : JSON.stringify(params),
                  page        : 1,
                  loadComplete: function (response)
                  {
                      if ( response.rtnData.result == 0 )
                      {
                          Swal.alert(['조회할 내용이 없습니다.', "info"]);
                      }else
                      {
                          $this.updateAvalCalChart();
                      }
                  }
              }).trigger("reloadGrid");

         },
         // 평균 칼로리 섭취 차트
         updateAvalCalChart: function()
         {
             let $this = this;

             var gridData      = $("#avalCal_list").getRowData(1);
             let gridColModel  = $("#avalCal_list").jqGrid("getGridParam","colModel");
             var avalCalLabels = [];
             var avalCalData   = [];

             if(gridData != null)
             {
                 for (let data in gridColModel)
                 {
                     if(gridColModel[data].name != 'divCd')
                     {
                         avalCalLabels.push(gridColModel[data].name);
                         avalCalData.push(gridData[gridColModel[data].name]);
                     }
                 }
             }

             let dataAvalCal = {
                 labels : avalCalLabels,
                 datasets: [
                     {
                         label: '칼로리 섭취량(㎉)',
                         data: avalCalData,
                         borderColor : "#d6e5eb",
                         backgroundColor: "#d6e5eb",
                         order : 1,
                         datalabels:{
                             display:false
                         }
                     } ,
                     {
                         label: '',
                         data: avalCalData,
                         borderColor: "#FBD5B0",
                         backgroundColor: "#FBD5B0",
                         type: 'line',
                         order: 0,
                         datalabels:{
                             display:true
                         }
                     }
                 ]
             };

             $this.chartAvalCal.data = dataAvalCal;
             $this.chartAvalCal.update();

         },
         //평균 칼로리 섭취 통계 엑셀 다운로드
         downloadExcel: function()
         {
           let $this = this;
             let params = $.extend(true, {}, $this.params);

             AjaxUtil.post({
                 dataType: 'binary',
                 url: "/stat/hc/avalCalStss/searchAvalCalStssList/excel.ab",
                 param: params,
                 success: function(response) {
                     saveFileLocal(response, 'avalCalList.xls');
                 },
                 error: function (response) {
                     Swal.alert([response, 'error']);
                 }
             });
         },
        resetSearchParam: function()
        {
            let $this = this;

            $this.params =
            {
                stndDtFr: '',
                stndDtTo: '',
                stndMmFr: '',
                stndMmTo: '',
                perdDivCd: 'DAY',
                occrDivCd: '02',
                sexCd: '',
                ageYcntFr: '',
                ageYcntTo: '',
                totalCount: 0,
                rowCount: 30,
                currentPage: 1,
                currentIndex: 0
            }

            $this.initData();
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
