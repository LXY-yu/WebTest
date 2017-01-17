<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'R_HandleCard.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript">
     function validate(){
	  if(document.myform.rdAdminRoles.value!="1"){
		  alert("您无此权限！");
		  return false;
	  }
	  return true;
  }
  </script>

  </head>
  
  <body>
  
    <form method="get" name="myform" id="myform" action="${pageContext.request.contextPath }/R_findServlet" target="bfr" onSubmit="return validate()">
    <%
     String op=request.getParameter("op");
     session.setAttribute("op1",op);
     String rdAdminRoles=(String)request.getSession().getAttribute("rdAdminRoles");
     session.setAttribute("rdAdminRoles",rdAdminRoles);
     String rdID=(String)request.getSession().getAttribute("rdID");
     session.setAttribute("rdID",rdID);
 
  %>
    <label> 读者类别</label>
    <select name="rdType">
    <option value='1'>教师</option>
    <option value='2' selected="selected">学生</option>
    </select>
    
    <label>所在单位</label>
    <input type="text" name="rdDept">
    
    <label>姓名</label>
    <input type="text" name="rdName">
    
    <input type="hidden" name="rdAdminRoles" value=<%=(String)session.getAttribute("rdAdminRoles")%>>
    <input type="submit" value="查询">
    </form>
  </body>
</html>
