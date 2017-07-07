<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>跳转界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script language="JavaScript" type="text/javascript">
  function delayURL(url) {
   var delay = document.getElementById("time").innerHTML;
  if(delay > 0) {
   delay--;
  document.getElementById("time").innerHTML = delay;
   } else {
   window.top.location.href = url;
  }
   t = setTimeout("delayURL('" + url + "')", 1000);
 }
    
</script>

  <body>

    
  </body><span id="time" style="background: #00BFFF">5</span>秒钟后请重新登录，如果不跳转，请点击下面的链接<a href="adlogin.jsp" target="_Blank">修改成功，请点击重新登录</a>
<script type="text/javascript">
delayURL("http://localhost:8080/HCproject/adlogin.jsp");
</script>
</html>
