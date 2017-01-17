<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>图书馆信息管理系统</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <%
     String rdAdminRoles=request.getParameter("rdAdminRoles");
     session.setAttribute("rdAdminRoles",rdAdminRoles);
     String rdID=request.getParameter("rdID");
     session.setAttribute("rdID",rdID);
     String rdPwd=request.getParameter("rdPwd");
     session.setAttribute("rdPwd",rdPwd);
  %>
  <frameset cols="20%, 80%">
  <frame src="left.jsp"/>
  <frameset rows="20%, 80%">
  <frame name="tfr" src="top.jsp"/>
  <frame name="bfr" src="bottom.jsp"/>
  </frameset>      
  <noframes>
  <body>
  您的浏览器不支持框架， 请升级您的浏览器以便正常访问。
  </body>
  </noframes>
  </frameset>
</html>
