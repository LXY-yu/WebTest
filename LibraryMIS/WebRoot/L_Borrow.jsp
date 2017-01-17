<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'L_Borrow.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript">
     function validate(){
	  if(document.myform.rdAdminRoles.value!="4"){
		  alert("您无此权限！");
		  return false;
	  }
	  return true;
  }
  </script>

  </head>
  
  <body>
 
 <%
 String rdIDUser=(String)request.getSession().getAttribute("rdID");
 session.setAttribute("rdIDUser",rdIDUser);
 System.out.println(rdIDUser);
 %>
  <form action="${pageContext.request.contextPath }/L_BorrowServlet" target="bfr" method="post" name="myform" id="myform" onSubmit="return validate()">
  <table>
  <tr>
    <td> 请输入借书证：<td>
    <td>
    <input type="text" name="rdID">
    </td>
    <td>
    <input type="submit" value="查找">
    </td>
    <td><input type="hidden" name="rdAdminRoles" value=<%=(String)session.getAttribute("rdAdminRoles")%> ></td>
    </tr>
    </table>
    </form>
    
  </body>
</html>
