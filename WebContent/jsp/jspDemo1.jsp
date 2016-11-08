<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> <%-- page指令，控制整个页面的属性，建议放在最前面 --%>
<%@ page import="java.util.*,java.io.*" %> <%-- page指令的import属性，可同时导入多个包，也可以分别导入 --%>
<%@ page errorPage="/jsp/error.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>		<%-- HTML作为jsp的模板框架 --%>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'jspDemo1.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
	<h4>jsp注释演示</h4>
	<!-- html形式的注释，源码可见 -->
	<%
		System.out.println("jsp注释演示"); //java注释，源码不可见
	 %>
	<%-- jsp版的注释，源码也不可见 --%>
	<%!
		String s = "脚本测试" ;
		String test(){
			int i = 10086 ;
			return s+i;
		}
	 %>
	 <%=test()%>
	 <%-- <%=1/0 %> --%>   <!-- 出错演示1 -->
<%-- 	 	<%@ include file="/jsp/testInclude1.jsp"%>
	 	<%@ include file="/jsp/testInclude2.jsp"%> --%>
  </body>
</html>
