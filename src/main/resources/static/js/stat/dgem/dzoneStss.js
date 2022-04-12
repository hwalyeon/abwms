let dzoneStss = new Vue({
    el: "#dzoneStss",
    data:
    {
        params:
        {
            stndDtFr    : '' ,
            stndDtTo    : '' ,
            stndMmFr    : '' ,
            stndMmTo    : '' ,
            perdDivCd   : 'DAY',
            occrDivCd   : '1',
            sexCd       : '' ,
            ageYcntFr   : '' ,
            ageYcntTo   : '' ,
            totalCount  : 0  ,
            rowCount    : 30 ,
            currentPage : 1  ,
            currentIndex: 0
        },
        title:
        {
            text:'발생 건수'
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
                url    : "/stat/dgem/dzoneStss/searchAvalActStssColList.ab",
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
                 {name: "divCd", index: "divCd", label: "구분", width:80, align: "center" },
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
                   height   : 60,
                   url      : '/stat/dgem/dzoneStss/searchAvalActStssList.ab',
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
                         label: $this.title.text,
                         data: [],
                         borderColor : "#d6e5eb",
                         backgroundColor: "#d6e5eb",
                         order : 1
                     } ,
                     {
                         label: '',
                         data: [],
                         borderColor: "#FBD5B0",
                         backgroundColor: "#FBD5B0",
                         type: 'line',
                         order: 0
                     }
                 ]
             };

             let optionsAvalCal = {
                 responsive : false,
                 plugins: {
                     legend: {
                         position: 'top',
                         display : true
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

             if(rowId==1){
                 $this.title.text ='발생 건수'
             }else{
                 $this.title.text ='발생 학생 수'
             }

             var gridData      = $("#avalCal_list").getRowData(rowId);
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
                         label: $this.title.text,
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
         /**/
         downloadExcel: function()
         {
           let $this = this;

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
