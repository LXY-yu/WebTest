<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册成功</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script language="JavaScript" type="text/javascript">
   	function delayURL() {
	 var delay = document.getElementById("time").innerHTML;
	 if(delay > 0) {
      delay--;
     document.getElementById("time").innerHTML = delay;
     } else {
     window.close();
  }
  t = setTimeout("delayURL()", 1000);
 }
    
</script>
</head>
  <body onload="delayURL()">

    
  
  恭喜注册成功！！！等待管理员审核<span id="time" style="background: #00BFFF">5</span>秒钟后关闭

  </body>
</html>
