<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ajax练习</title>
 <script>
	var xmlhttp;
	function loadXML(url_in,function_in){
		if (window.XMLHttpRequest)
		  {// IE7+, Firefox, Chrome, Opera, Safari 代码
		  xmlhttp=new XMLHttpRequest();
		  }
		else
		  {// IE6, IE5 代码
		  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		  }
	xmlhttp.onreadystatechange=function_in;
	xmlhttp.open("GET",url_in,true);
	xmlhttp.send();
	}
	function myfunction1(){
		/* alert("myfunction1运行"); */
		 loadXML("${pageContext.request.contextPath}/jsp5/login.jsp?"+new Date(),function(){ 
			/*  alert("执行了loadXML方法"); */
			if(xmlhttp.readyState==4 && xmlhttp.status==200){
				document.getElementById("mydiv1").innerHTML=xmlhttp.responseText;
			}
		}); 
	}
</script> 
<script>
var xmlhttp;
function loadXMLDoc(url,cfunc)
{
if (window.XMLHttpRequest)
  {// IE7+, Firefox, Chrome, Opera, Safari 代码
  xmlhttp=new XMLHttpRequest();
  }
else
  {// IE6, IE5 代码
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp.onreadystatechange=cfunc;
xmlhttp.open("GET",url,true);
xmlhttp.send();
}
function myfunction2()
{
	loadXMLDoc("${pageContext.request.contextPath}/test.txt",function()
	{
		if (xmlhttp.readyState==4 && xmlhttp.status==200)
		{
			document.getElementById("mydiv1").innerHTML=xmlhttp.responseText;
		}
	});
}
</script> 

</head>
<body>
	<div style="background-color: blue">
		<span style="color: red">这是一个span标签</span>
		<button onclick="myfunction1()">点击激活ajax</button>
	</div>
	<div id="mydiv1" style="background-color: yellow">
		hello world
	</div>
</body>
</html>