<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'L_reBorrow.jsp' starting page</title>
    
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
 String rdID=(String)request.getSession().getAttribute("rdID");
 session.setAttribute("rdID",rdID);
// System.out.println(rdID);
 String op=request.getParameter("op");
 session.setAttribute("op",op);
 %>
  <form action="${pageContext.request.contextPath }/L_reBorrowServlet" target="bfr" method="post" name="myform" id="myform" onSubmit="return validate()">
  <table>
  <tr>
    <td> 请输入书号：<td>
    <td>
    <input type="text" name="bkCode">
    </td>
    <td>
    <input type="submit" value="查找">
    </td>
    <td><input type="hidden" name="rdAdminRoles" value=<%=(String)session.getAttribute("rdAdminRoles")%>></td>
    </tr>
    </table>
    </form>
    
  </body>
</html>
