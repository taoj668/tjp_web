<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试jsp的指令之include</title>
</head>
<body>
	<div align="right" style="background-color:silver;">
		<%@ include file="/jsp4/test_include2.jspf" %>
	</div>
	<h1 style="color: red aqua;">这里是正文部分</h1>
	<img src="../img/IMG_3567.GIF" alt="oop">
	<div align="center" style="background-color: orange;">
		<%@ include file="/jsp4/test_include3.jspf" %>
	</div>
	<div align="left" style="background-color:yellow">
		<div align="left" style="background-color: red">
			<jsp:include page="/jsp4/test_include4.jsp"></jsp:include>
		</div>
		<div align="center" style="background-color: black;">
			<p style="color: white;">这是正文部分</p>
		</div>
		<div align="right" style="background-color: blue">
			<jsp:include page="/jsp4/test_include5.jsp"></jsp:include>
		</div>
	</div>
</body>
</html>