<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
		function changeImg(){
			//这里的地址最后通常加一个随机数，原因是因为GET方式等幂访问
			document.getElementById("validateCodeImg").src="Kaptcha.jpg?"+Math.random();
		}
		
	</script>

</head>
<body>
<div align="center">
	<form action="${pageContext.request.contextPath}/CheckServlet2" method="post">
            验证码：<input type="text" name="validateCode"/>
		<img alt="验证码看不清，换一张"  src="Kaptcha.jpg" id="validateCodeImg" onclick="changeImg()">  ${errorCheckCode}  
    	<br/>
        <input type="submit" value="提交">
	</form>	
</div>
</body>
</html>