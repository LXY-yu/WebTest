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
      <table border="1" width="80%" bordercolor="black">    
           <tr>  
           <td width="5%">借书证号</td> 
           <td width="10%">读者姓名</td>
           <td width="5%">性别</td> 
           <td width="5%">读者类别</td>     
           <td width="10%">单位名称</td>
           <td width="10%">电话号码</td>
           <td width="10%">电子邮箱</td>
           <td width="10%">办证日期</td>
           <td width="10%">读者照片</td> 
           <td width="5%">证件状态</td>     
           <td width="5%">已借书数量</td>
           <td width="5%">管理角色</td>               
        </tr>  
        
        <c:forEach var="me" items="${list}">
    
          <tr>  
          <td>${me.rdID}</td>
          <td>${me.rdName}</td>
          <td>${me.rdSex}</td>
          <td>${me.rdType}</td>
          <td>${me.rdDept}</td>
          <td>${me.rdPhone}</td>
           <td>${me.rdEmail}</td>
          <td>${me.rdDateReg}</td>
          <td><img src="img/${me.rdPhoto}" style="width:100px;height:100px"></td>
          <td>${me.rdStatus}</td>
          <td>${me.rdBorrowQty}</td>
          <td>${me.rdAdminRoles}</td>            
          </tr>  
        </c:forEach>
            
      </table>
      管理角色：0-读者、1-借书证管理、2-图书管理、4-借阅管理、8-系统管理
  </body>  
</html>
