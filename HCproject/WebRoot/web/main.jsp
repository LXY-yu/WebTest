<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>生态农业后台</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/style.css" rel="stylesheet" type="text/css">
<title>生态农业后台</title>
</head>
<frameset rows="88,*,27" cols="*" frameborder="NO" border="0" framespacing="0">
		<frame src="web/top.jsp" name="topFrame" scrolling="NO" noresize>
		<frameset cols="220,*" frameborder="NO" border="0" framespacing="0"  id="contentFrameset">
			<frame src="web/left.jsp" name="leftFrame" scrolling="no" noresize>
			<frame src="web/welcome.jsp" name="mainFrame" scrolling="yes" noresize>
		</frameset>
		<frame src="web/foot.jsp" name="footFrame" scrolling="NO" noresize>
</frameset>
<noframes></noframes>
</html>
