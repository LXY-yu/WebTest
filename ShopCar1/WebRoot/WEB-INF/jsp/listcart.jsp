<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
<body>
    <h2>您购买了如下商品</h2>    
      <table border="1" width="80%" bordercolor="blue">    
           <tr>  
           <td>编号</td>  
           <td>名称</td>
           <td>简介</td> 
           <td>价格</td>     
           <td>数量</td>
           <td>总价格</td>
           <td>删除</td>               
        </tr>  
        
        <c:forEach var="me" items="${list}">  
          <tr>  
          <td>${me.book.getNO()}</td>
          <td>${me.book.getName()}</td>
          <td>${me.book.getInfo()}</td>
          <td>${me.book.getPrice()}</td>
          <td>${me.quantity}</td>
          <td>${me.price}￥</td>  
           <td>  
                <a href="${pageContext.request.contextPath}/DeleteItemServlet?NO=${me.book.getNO()}" >删除</a>           
           </td>                
          </tr>  
        </c:forEach>
            
      </table> 
      <a href="${pageContext.request.contextPath}/ClearCartServlet">清空购物车</a>  
      <a href="${pageContext.request.contextPath }/ListBookServlet">返回继续购物</a>   
  </body>  
</html>
