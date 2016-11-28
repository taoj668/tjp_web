<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>练习jquery.ajax</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/test_jquery/jquery-3.1.1.min.js"></script>
</head>
<body>
	name:<input id="i1"/>
	pass:<input id="i2"/>
	<button id="b1">点我试试</button>
	<div class="d1"></div>
	<script type="text/javascript">
		$(function() {
			$(".d1").append("<h3>导入本地jquery成功</h3>");
			$("#b1").click(function(){
				$.ajax({
					type:'POST',
					url:'${pageContext.request.contextPath}/test_jquery/test_ajax3.jsp',
					data:{
						name:$("#i1").val(),
						pass:$("#i2").val()
					},
					success:function(returnData){
						$(".d1").html(returnData);
					}
				});
			});
		});
	</script>
</body>
</html>