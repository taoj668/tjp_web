<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>练习ajax2</title>
</head>
<body>
	<script>
		var xmlhttp;
		function loadXML(url_in,function_in) {
			if(window.XMLHttpRequest){
				xmlhttp = new XMLHttpRequest();
			}else{
				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			}
			xmlhttp.onreadystatechange=function_in;
			xmlhttp.open("GET",url_in,true);
			xmlhttp.send();
		}
		
		function load1(str) {
			loadXML("${pageContext.request.contextPath}/jsp_ajax/test_ajax3.jsp?name="+str,function(){
				document.getElementById("tj1").innerHTML = xmlhttp.responseText;
				/* alert(xmlhttp.responseText); */
			}); 
		}
		function test(str) {
			alert(str);
		}
	</script>
	<div id="tj1">
		
	</div>
	<div>
		在此输入查询信息：<input id="inpt" onkeyup="load1(this.value)"/><br>
	</div>
</body>
</html>