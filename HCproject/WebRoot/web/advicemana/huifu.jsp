<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.xt.dao.ProductDao"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'seeadvice.jsp' starting page</title>
    
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
   <%
   		ProductDao dao=new ProductDao();
   		int adviceid=Integer.parseInt(request.getParameter("adviceid"));
   		
    %>
   <form action="QdProManaServlet" method="post">
   <textarea rows="50" cols="60" name="huifucontent">
   
   </textarea><br>
   <input type="hidden" value="<%=adviceid %>" name="adviceid">
   <input type="hidden" value="huifu" name="flag">
   <input type="submit" value="回复">
   </form>
  </body>
</html>
