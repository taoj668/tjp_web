<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>练习jQuery1</title>
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js"></script>
<script>
	$(function(){
		$("#d2").html("<h2>这是jquery插入进来的内容</h2>");
		$("#d1 > .s1").css("color","red");
		$("p").after("<span>这是新追加的内容</span>");
		$(".b1").before("<br>");
		$("#d2").hide();
		$(".b1").click(function(){
			$("#d2").show();
			$("#d2").append("<input></input>");
			$("input").attr("id","inpt");
			$("#inpt").focus(function(){
				alert("生效了，啊哈哈");
			});
		
		});
	});

</script>
</head>
<body>
	<div id="d1">
		这是div1
		<span class="s1">这是span1</span>
		<span class="s1">这还是span1</span>
		<span class="s2">这是span2</span>
		<p class="p1">这是p1</p>
		<p class="p2">这是p2</p>
		<button class="b1">这是b1</button>
	</div>
	<div id="d2">
		这是div2
	</div>
</body>
</html>