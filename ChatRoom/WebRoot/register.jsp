<%@ page language="java" import="java.util.*,java.io.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
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
  
    <center>  
  <h1>注册新用户</h1>
  <script type="text/javascript">
  function validate(){
  if (document.myform.username.value==""){
  alert("用户名不能为空.");
  document.myform.username.focus();
  return false ;
  }
  if (document.myform.password.value==""){
  alert("密码不能为空.");
  document.myform.password.focus();
  return false ;
 }if (document.myform.password1.value==""){
  alert("请确认密码.");
  document.myform.password1.focus();
  return false ;
  }if(document.myform.password.value!=document.myform.password1.value)
  {
      alert("输入的密码不一致！");
      document.myform.password1.focus();
      return  false;
  }
   
 return true;
}
</script>  
  <form action="${pageContext.request.contextPath }/addUserServlet" method=post id="myform" name="myform" onSubmit="return validate()">  
  <table >  
    <tr>  
       <td>用户名:</td>  
       <td><input type="text" name="username">  </td>  
    </tr>  
    <tr >  
      <td>密码：</td> 
      <td><input type="password" name="password">  </td>  
    </tr> 
    <tr >  
      <td> 确认密码：</td>  
       <td> <input type="password" name="password1">  </td>  
    </tr>  
    <tr>  
      <td>  
        <input type=submit value=提交 >  
      </td>  
    </tr>  
  </table>  
  </form>  
</center>  
  </body>
</html>
