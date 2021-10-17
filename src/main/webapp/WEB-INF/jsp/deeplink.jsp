<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
	<head>
		<title>GetEyes</title>
	</head>
    <body onload="action_app_geteyes()">
        <%=request.getAttribute("message") %>
    </body>

    <script>
        //var getParameter = function (param) { var returnValue; var url = location.href; var parameters = (url.slice(url.indexOf('?') + 1, url.length)).split('&'); for (var i = 0; i < parameters.length; i++) { var varName = parameters[i].split('=')[0]; if (varName.toUpperCase() == param.toUpperCase()) { returnValue = parameters[i].split('=')[1]; return decodeURIComponent(returnValue); } } };
        var userAgent = navigator.userAgent;    

        function mo_chk() {
            var os;
            var mobile = (/iphone|ipad|ipod|android/i.test(navigator.userAgent.toLowerCase()));	 
            
            if (mobile) {
                var userAgent = navigator.userAgent.toLowerCase();
                if (userAgent.search("android") > -1) {
                    return os = "android";
                } else if ((userAgent.search("iphone") > -1) || (userAgent.search("ipod") > -1) || (userAgent.search("ipad") > -1)) {
                    return os = "ios";
                } else {
                    return os = "otehr";
                }
        
            } else {
                return os = "pc";
            }
        }
            
        function action_app_geteyes() {
            var result_mo_chk = mo_chk();
        
            if ("pc" == result_mo_chk) {
                alert("PC에서는 사용할 수 없습니다");
                return;
            } else {
                if ("ios" == result_mo_chk) {
                    alert("IOS에서는 사용할 수 없습니다");
                } else if ("android" == result_mo_chk) {

                    var customUrl = "geteyes://action=<%=request.getAttribute("action") %>,seq=<%=request.getAttribute("seq") %>";

                    isMyApp();
                    location.href = customUrl;
                    
                }
            }
        }

        function isMyApp(){
            function clearTimers(){
                clearInterval(heartbeat);
                clearTimeout(timer);
            }

            function intervalHeartbeat(){
                if(document.webkitHidden || document.hidden){
                    clearTimers();
                    console.log('앱이 설치 되어 있습니다.');
                }
            }

            heartbeat = setInterval(intervalHeartbeat, 200);
            var deLay = 2000;
            timer = setTimeout(function() {
                console.log('앱이 없습니다.');
                location.href = "https://play.google.com/store/apps/details?id=com.leadwalk.geteyes";
            }, deLay);
        }
    </script>

</html>