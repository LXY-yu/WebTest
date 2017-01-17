<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'B_AddBook.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript">
     function validate(){
	  if(document.myform.rdAdminRoles.value!="2"){
		  alert("您无此权限！");
		  return false;
	  }
	  return true;
  }
  </script>

  </head>
  
  <body>
    <form method="get" action="${pageContext.request.contextPath }/B_AddBookServlet" id="myform" name="myform" onSubmit="return validate()">
    <%
     String rdAdminRoles=(String)request.getSession().getAttribute("rdAdminRoles");
     session.setAttribute("rdAdminRoles",rdAdminRoles);
     String rdID=(String)request.getSession().getAttribute("rdID");
     session.setAttribute("rdID",rdID);
 
  %>
    <table>
    <tr>
    <td>图书编号</td>
    <td><input type="text" name="bkCode"></td>
    </tr>
    <tr>
    <td>书名</td>
    <td><input type="text" name="bkName"></td>
    </tr>
    <tr>
    <td>作者</td>
    <td><input type="text" name="bkAuthor"></td>
    </tr>
    <tr>
    <td>出版社</td>
    <td><input type="text" name="bkPress"></td>
    </tr>
    <tr>
    <td>出版日期</td>
    <td><input type="text" name="bkDatePress"></td>
    </tr>
    <tr>
    <td>ISBN书号</td>
    <td><input type="text" name="bkISBN"></td>
    </tr>
    <tr>
    <td>分类号</td>
    <td><input type="text" name="bkCatalog"></td>
    </tr>
    <tr>
    <td>语言</td>
    <td>
    <select name="bkLanguage">
    <option value='0' selected="selected">中文</option>
    <option value='1'>英文</option>
    <option value='2'>日文</option>
    <option value='3'>俄文</option>
    <option value='4'>德文</option>
    <option value='5'>法文</option>
    </select>
    </td>
    </tr>
    <tr>
    <td>页数</td>
    <td><input type="text" name="bkPages"></td>
    </tr>
    <tr>
    <td>价格（元）</td>
    <td><input type="text" name="bkPrice"></td>
    </tr>
     <tr>
    <td>内容简介</td>
    <td><input type="text" name="bkBrief"></td>
    </tr>
    <tr>
    <td>图书封面照片</td>
    <td><input type="file" name="bkCover"></td>
    <td> 
    <input type="reset" value="清除" name="clear" size="25"> 
    </td>
    </tr>
    <tr>
    <td>图书状态</td>
    <td>
    <select name="bkStatus">
    <option value='在馆' selected="selected">在馆</option>
    <option value='借出'>借出</option>
    <option value='遗失'>遗失</option>
    <option value='变卖'>变卖</option>
    <option value='销毁'>销毁</option>
    </select>
    </td>
    </tr>
    <tr>
  
    <td><input type="hidden" name="rdAdminRoles" value=<%=(String)session.getAttribute("rdAdminRoles")%>></td>
    </tr>
    </table>
    <input type="submit" value="添加">
    
    </form>
  </body>
</html>
