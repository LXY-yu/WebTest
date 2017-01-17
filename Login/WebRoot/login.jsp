<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录页面</title>
    
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
   <form method="post" action="checklogin.jsp">  
<table>  
<tr><td> 输入用户名：</td>  
<td><input type=text name=userid ></td>  
</tr>  
<tr><td>输入密码：</td>  
<td><input type=password name=password></td>  
</tr>  
<tr><td><input type=submit value=确认>  
</td></tr>  
</table>  
</form>  
<form action="register.jsp">  
<input type=submit value=注册>  
</form>  
  </body>
</html>
