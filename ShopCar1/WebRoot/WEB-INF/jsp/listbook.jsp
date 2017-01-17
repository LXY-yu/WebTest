<%@ page language="java" import="java.util.*,com.domain.Book" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'listbook.jsp' starting page</title>
    
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
    <h2>渊博书店</h2>  
      
      <table border="1" width="80%">  
        <tr>  
           <td>编号</td>  
           <td>名称</td>
           <td>简介</td> 
           <td>价格</td>     
           <td>操作</td>     
        </tr>  
        
         <c:forEach var="book" items="${books}">
            <tr>
                <td>${book.NO}</td>
                <td>${book.name}</td>
                <td>${book.info}</td>
                <td>${book.price}</td>
                <td>
                    <a href="${pageContext.request.contextPath }/BuyServlet?NO=${book.NO}">购买</a>
                </td>
            </tr>
        </c:forEach>
        <a href="${pageContext.request.contextPath }/ListCartServlet?">查看购物车</a>
        
      </table>  
  </body>
</html>
