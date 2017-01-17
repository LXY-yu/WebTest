<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'B_SearchBook.jsp' starting page</title>
    
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
     <form method="get" action="${pageContext.request.contextPath }/B_findServlet" target="bfr" name="myform" id="myform" onSubmit="return validate()">
     <%
     String op=request.getParameter("op");
     session.setAttribute("op1",op);
     String rdAdminRoles=(String)request.getSession().getAttribute("rdAdminRoles");
     session.setAttribute("rdAdminRoles",rdAdminRoles);
  %>
    <label> 书名</label>
    <input type="text" name="bkName">
    
    <input type="hidden" name="rdAdminRoles" value=<%=(String)session.getAttribute("rdAdminRoles")%>>
    <input type="submit" value="查询">
    
    </form>
  </body>
</html>
