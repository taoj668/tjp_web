<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>返回信息</title>
</head>
<body>	<!-- onload="autoRun()" -->
<!-- 	<script>
		function autoRun() {
			/* alert(location.href); */
			var str = location.href;
			var name = str.split("?name=")[1]; 
			/* alert(name); */
			if(str.indexOf('?name=') == -1) return;
			var x;
			switch(name){
				case "a" : x = "anna,anny,andson" ; break;
				case "b" : x = "bobo,boder,byren" ; break;
				case "c" : x = "clier,clyn" ; break;
				case "d" : x = "dudu,double" ; break;
				case "e" : x = "exciting,exprese" ; break;
				case "f" : x = "fuck,fly,flow,flame" ; break;
				default : x = "抱歉没找到对应的匹配";
			}
			/* alert(x);  */
			document.getElementById("tj2").innerHTML=x;
			/* alert(x);  */
		}
		/* window.onload = autoRun(); */
	</script> -->
	<%
		char name = request.getParameter("name").toString().charAt(0);
		String x ;
		switch(name){
			case 'a' : x = "anna,anny,andson" ; break;
			case 'b' : x = "bobo,boder,byren" ; break;
			case 'c' : x = "clier,clyn" ; break;
			case 'd' : x = "dudu,double" ; break;
			case 'e' : x = "exciting,exprese" ; break;
			case 'f' : x = "fuck,fly,flow,flame" ; break;
			default : x = "抱歉没找到对应的匹配";
		}
	%>
	<span id="tj2" style="font-size: 30px;"><%="匹配的结果为："+x %></span>
	<!-- <button onclick="autoRun()">点我</button> -->
	<!-- <div id="tj1" style="background-color: yellow" align="center">what</div> -->
	<!-- <h4>这是界面3</h4> -->
</body>
</html>