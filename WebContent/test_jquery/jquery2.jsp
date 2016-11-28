<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="//ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.3.min.js"></script>
<script>
$(document).ready(function(){
  $("button").click(function(){
    /* $("p").fadeOut(2000); */
    $("p").slideUp(2000);
  });
});
</script>
</head>

<body>
<h2>这是标题</h2>
<p>这是一个段落。</p>
<p>这是另一个段落。</p>
<button>点击这里</button>
<input id="inpt"></input>
<div class="d1">获得焦点啦</div>
<script>
	$(function() {
		$(".d1").hide();
		$("#inpt").focus(function(){
			/* $(".d1").show(); */
			$(".d1").slideDown(2000);
		});
		$("#inpt").blur(function(){
			/* $(".d1").hide(); */
			$(".d1").slideUp(2000);
		});
	})
</script>
</body>
</html>
