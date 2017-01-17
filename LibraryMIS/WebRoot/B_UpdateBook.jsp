<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'B_UpdateBook.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript">
     function validate(){
	  if(document.myform.bkStatus.value!="在馆" && document.myform.bkStatus.value!="借出" && document.myform.bkStatus.value!="销毁" && document.myform.bkStatus.value!="变卖"){
		  alert("请输入在馆、借出、销毁、变卖");
		  return false;
	  }
	  return true;
  }
  </script>

  </head>
  
  <body>
    <c:forEach var="me" items="${list}">
    <form method="get" action="${pageContext.request.contextPath }/B_UpdateServlet" target="bfr" id="myform" name="myform" onSubmit="return validate()">
    <table border="1" width="40%" bordercolor="black">    
         
          <tr>
          <td>图书序号</td>  
          <td><input style="width:100%" type="text" name="bkID" value=${me.bkID}  readonly="true"></td>
          </tr>
          <tr>
          <td>图书编号</td>
          <td><input style="width:100%" type="text" name="bkCode" value=${me.bkCode}></td>
          </tr>
          <tr>
          <td>书名</td>
          <td><input style="width:100%" type="text" name="bkName" value=${me.bkName}></td>
          </tr>
          <tr>
          <td>作者</td>
          <td><input style="width:100%" type="text" name="bkAuthor" value=${me.bkAuthor}></td>
          </tr>
          <tr>
          <td>出版社</td> 
          <td><input style="width:100%" type="text" name="bkPress" value=${me.bkPress}></td>
          </tr>
          <tr>
          <td>出版日期</td>
          <td><input style="width:100%" type="text" name="bkDatePress" value=${me.bkDatePress}></td>
          </tr>
          <tr>
          <td>ISBN书号</td>
          <td><input style="width:100%" type="text" name="bkISBN" value=${me.bkISBN}></td>
          </tr>
          <tr>
          <td>分类号</td>
          <td><input style="width:100%" type="text" name="bkCatalog" value=${me.bkCatalog}></td>
          </tr>
          <tr>
          <td>语言</td>
          <td><input style="width:100%" type="text" name="bkLanguage" value=${me.bkLanguage}></td>
          </tr>
          <tr>
          <td>页数</td>
          <td><input style="width:100%" type="text" name="bkPages" value=${me.bkPages}></td>
          </tr>
          <tr>
          <td>价格(元)</td>
          <td><input style="width:100%" type="text" name="bkPrice" value=${me.bkPrice}></td>
          </tr>
          <tr>
          <td>入馆日期</td>
          <td><input style="width:100%" type="text" name="bkDateIn" value=${me.bkDateIn}></td>
          </tr>
          <tr>
          <td>内容简介</td>
          <td><input style="width:100%" type="text" name="bkBrief" value=${me.bkBrief}></td>
          </tr>
          <tr>
          <td>图书封面照片</td>
          <td><img src="img/${me.bkCover}" style="width:100px;height:150px">
          <input name="bkCover" value=${me.bkCover} type="hidden"></td>
          </tr>
          <tr>
          <td>图书状态</td>
          <td><input style="width:100%" type="text" name="bkStatus" value=${me.bkStatus}>（请输入在馆、借出、销毁、变卖）</td>
          
          </tr>                                     
      </table>
      <input type="submit" value="更改" name="update">
      
      </form>
      </c:forEach>  
  </body>
</html>
