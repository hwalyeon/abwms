const statComponent = {
    methods : {

        setDatepicker : function() {
            let $this = this;

            $('#stndDtFrPicker').datepicker({
                todayBtn: "linked",
                keyboardNavigation: false,
                forceParse: false,
                calendarWeeks: true,
                autoclose: true,
                todayHighlight: true,
                maxDate : -1,
            }).on("changeDate", function() {
                $this.params.stndDtFr = $('#stndDtFr').val();
            });

            $('#stndDtToPicker').datepicker({
                todayBtn: "linked",
                keyboardNavigation: false,
                forceParse: false,
                calendarWeeks: true,
                autoclose: true,
                todayHighlight: true,
            }).on("changeDate", function() {
                $this.params.stndDtTo = $('#stndDtTo').val();
            });


            $('#stndMmFrPicker').datepicker({
                todayBtn: "linked",
                keyboardNavigation: false,
                forceParse: false,
                calendarWeeks: true,
                format: datepickerFormatMmPattern,
                startView: "months",
                minViewMode: "months",
                autoclose: true,
                todayHighlight: true,
            }).on("changeDate", function() {
                $this.params.stndMmFr = $('#stndMmFr').val();
            });

            $('#stndMmToPicker').datepicker({
                todayBtn: "linked",
                keyboardNavigation: false,
                forceParse: false,
                calendarWeeks: true,
                format: datepickerFormatMmPattern,
                startView: "months",
                minViewMode: "months",
                autoclose: true,
                todayHighlight: true,
                maxDate : "-1m"
            }).on("changeDate", function() {
                $this.params.stndMmTo = $('#stndMmTo').val();
            });
        },

        isValid : function (){
            let $this = this;
            if($this.params.perdDivCd === 'DAY') {
                const day = moment($this.params.stndDtTo, 'YYYY-MM-DD').diff($this.params.stndDtFr, 'days');
                if (day > 14) {
                    Swal.alert(["????????? ??????????????? ?????? 14?????? ?????? ??? ????????????.", "warning"]);
                    return false;
                }

                if ( day < 0 ) {
                    Swal.alert(['?????? ????????? ??????????????? ????????????.', 'info']);
                    return false;
                }

                if($this.params.stndDtTo != null && $this.params.stndDtTo != ''){
                    var stndDate = moment(new Date()).add(-1, "days").format(dateFormatPattern);
                    if($this.params.stndDtTo > stndDate){
                        Swal.alert(["??????????????? ?????? ???????????????.", "warning"]);
                        return false;
                    }
                }

                if(($this.params.stndDtTo == null || $this.params.stndDtTo == '') && ($this.params.stndDtFr == null || $this.params.stndDtFr == '')){
                    Swal.alert(["????????? ???????????? ????????? ????????????.", "warning"]);
                    return false;
                }

                if(($this.params.stndDtFr != null && $this.params.stndDtFr != '') && ($this.params.stndDtTo == null || $this.params.stndDtTo == '')
                    || ($this.params.stndDtTo != null && $this.params.stndDtTo != '') && ($this.params.stndDtFr == null || $this.params.stndDtFr == '') ){
                    Swal.alert(["????????? ???????????? ????????? ????????????.", "warning"]);
                    return false;
                }
            }else if($this.params.perdDivCd === 'WEEK' || $this.params.perdDivCd === 'MONTH') {

                const day = moment($this.params.stndMmTo, 'YYYY-MM').diff($this.params.stndMmFr, 'months');

                if(this.params.perdDivCd === 'MONTH'){
                    if (day > 11) {
                        Swal.alert(["?????? ??????????????? ?????? 1?????? ?????? ??? ????????????.", "warning"]);
                        return false;
                    }
                }else if ($this.params.perdDivCd === 'WEEK'){
                    if (day > 2) {
                        Swal.alert(["????????? ??????????????? ?????? 3????????? ?????? ??? ????????????.", "warning"]);
                        return false;
                    }
                }

                if ( day < 0 ) {
                    Swal.alert(['?????? ????????? ??????????????? ????????????.', 'info']);
                    return false;
                }

                if($this.params.stndMmTo != null && $this.params.stndMmTo != ''){
                    var stndMm = moment(new Date()).add(-1, "month").format(dateFormatPattern);
                    if($this.params.stndMmTo > stndMm){
                        Swal.alert(["??????????????? ?????? ???????????????.", "warning"]);
                        return false;
                    }
                }

                if(($this.params.stndMmTo == null || $this.params.stndMmTo == '') && ($this.params.stndMmFr == null || $this.params.stndMmFr == '')){
                    Swal.alert(["????????? ???????????? ????????? ????????????.", "warning"]);
                    return false;
                }

                if(($this.params.stndMmFr != null && $this.params.stndMmFr != '') && ($this.params.stndMmTo == null || $this.params.stndMmTo == '')
                    || ($this.params.stndMmTo != null && $this.params.stndMmTo != '') && ($this.params.stndMmFr == null || $this.params.stndMmFr == '') ){
                    Swal.alert(["????????? ???????????? ????????? ????????????.", "warning"]);
                    return false;
                }

            }


            if($this.params.ageYcntFr != null && $this.params.ageYcntFr != '' && $this.params.ageYcntTo != null && $this.params.ageYcntTo != '' ){
                if(WebUtil.toNumber($this.params.ageYcntFr)  < 3 || WebUtil.toNumber($this.params.ageYcntTo) < 3 ){
                    Swal.alert(["????????? 3??? ?????? ?????? ????????? ???????????????.", "warning"]);
                    return false;
                }

                if(WebUtil.toNumber($this.params.ageYcntFr) > 19 || WebUtil.toNumber($this.params.ageYcntTo) > 19 ){
                    Swal.alert(["????????? 19??? ?????? ????????? ???????????????.", "warning"]);
                    return false;
                }

                if(Number($this.params.ageYcntFr) > Number($this.params.ageYcntTo)){
                    Swal.alert(["????????? ???????????? ????????? ????????????.", "warning"]);
                    return false;
                }
            }

            if(($this.params.ageYcntFr != null && $this.params.ageYcntFr != '' && ($this.params.ageYcntTo == null || $this.params.ageYcntTo == ''))
                || ($this.params.ageYcntTo != null && $this.params.ageYcntTo != '' && ($this.params.ageYcntFr == null || $this.params.ageYcntFr == '')) ){
                Swal.alert(["????????? ??????/?????? ??? ??? ???????????? ????????? ????????????.", "warning"]);
                return false;
            }

            return true;

        },

        changePerdDiv : function (){
            let $this = this;

            $this.params.stndDtFr = '';
            $this.params.stndDtTo = '';
            $this.params.stndMmFr = '';
            $this.params.stndMmTo = '';

            $("#stndDtFrPicker").datepicker('setDate' , '');
            $("#stndDtToPicker").datepicker('setDate' , '');
            $("#stndMmFrPicker").datepicker('setDate' , '');
            $("#stndMmToPicker").datepicker('setDate' , '');
            
            if ($this.params.perdDivCd == "DAY")
        	{
                $this.params.stndDtFr =moment().add(-14, "days").format(dateFormatPattern);
                $this.params.stndDtTo =moment().add( -1, "days").format(dateFormatPattern);

                $this.params.perdDivCd = 'DAY';
                $this.params.occrDivCd = '02';
        	}
            else 
        	{
            	var tmp = -1;
            	if      ($this.params.perdDivCd == "MONTH"   ) tmp = tmp*12;
            	else if ($this.params.perdDivCd == "WEEK"    ) tmp = tmp*3;
            	else if ($this.params.perdDivCd == "WEEK_NM" ) tmp = tmp*3;
            	
            	
                $this.params.stndMmFr =moment().add(tmp, "months").format("YYYY-MM");
                $this.params.stndMmTo =moment().add(-1, "months").format("YYYY-MM");

//                $this.params.perdDivCd = 'DAY';
                $this.params.occrDivCd = '02';
        	}

        },

        statCodeList: function() {
            let $this = this;
            $this.code.perdDivList = CodeUtil.getPeriodDivList();
            getCommonCodeList('SEX_CD',$this.code.sexCdList);

        },

        // ?????? ?????? ??????
        statInitData : function (){
            let $this = this;

            var nowDate = new Date();

            $this.params.stndDtFr =moment(nowDate).add(-14, "days").format(dateFormatPattern);
            $this.params.stndDtTo =moment(nowDate).add( -1, "days").format(dateFormatPattern);

            $this.params.perdDivCd = 'DAY';
            $this.params.occrDivCd = '02';
        },
    }

}
