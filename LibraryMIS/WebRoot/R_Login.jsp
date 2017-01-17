<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'R_Login.jsp' starting page</title>
    
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
<form method="post" action="${pageContext.request.contextPath }/R_checkReaderServlet">  
<table>  
<tr><td> 输入用户名：</td>  
<td><input type=text name="rdID" ></td>  
</tr>  
<tr><td>输入密码：</td>  
<td><input type=password name="rdPwd"></td>  
</tr>  
<tr><td><input type=submit value=确认>  
</td></tr>  
</table>  
</form>  
  </body>
</html>
