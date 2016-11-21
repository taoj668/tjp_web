<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>页面一</h1>
	<jsp:forward page="/jsp4/test_jspForward2.jsp">
		<jsp:param value="welcome" name="test1"/>
		<jsp:param value="to" name="test2"/>
		<jsp:param value="myjsp" name="test3"/>
	</jsp:forward>
</body>
</html>