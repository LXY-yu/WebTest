<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>网上购物首页</title>

  </head>
  
  <body> 
    
    <a href="${pageContext.request.contextPath}/ListBookServlet"> 点击进入购买页面 </a>  
  </body>
</html>
