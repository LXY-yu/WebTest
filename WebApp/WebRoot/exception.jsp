<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" isErrorPage="true"%><%--isErrorPage置于true才可以 --%>
<%--errorPage="exception.jsp"当前页面发生异常，就交给exception.jsp页面处理 --%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'out.jsp' starting page</title>
    
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
    <h1>exception内置对象</h1>
    <hr>
    异常消息是：<%=exception.getMessage() %><br>
    异常的字符串描述：<%=exception.toString() %><br>
    
     
  </body>
</html>
