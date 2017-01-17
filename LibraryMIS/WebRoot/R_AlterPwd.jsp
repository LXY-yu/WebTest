<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'R_AlterPwd.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript">
  function validate(){
  if (document.myform.oldPwd.value==""){
  alert("当前密码不能为空.");
  document.myform.oldPwd.focus();
  return false ;
  }
  if (document.myform.rdPwd.value==""){
  alert("新密码不能为空.");
  document.myform.rdPwd.focus();
  return false ;
 }
  if (document.myform.rdPwd1.value==""){
  alert("请确认密码.");
  document.myform.rdPwd1.focus();
  return false ;
  }
 if(document.myform.rdPwd.value!=document.myform.rdPwd1.value)
  {
      alert("输入的密码不一致！");
      document.myform.rdPwd1.focus();
      return  false;
  }
 if(document.myform.oldPwd.value!="<%=session.getAttribute("rdPwd")%>")
 {
     alert("密码输入错误！");
     document.myform.oldPwd.focus();
     return  false;
 }
 return true;
}
</script>  

  </head>
  
  <body>
  <% 
  String rdID=(String)request.getSession().getAttribute("rdID");
  session.setAttribute("rdID",rdID);
  String rdPwd=(String)request.getSession().getAttribute("rdPwd");
   %>
  <form action="${pageContext.request.contextPath }/R_AlterPwdServlet" method=post id="myform" name="myform" onSubmit="return validate()">
    <table >  
    <tr>  
       <td>当前密码:</td>  
       <td><input type="text" name="oldPwd">  </td>  
    </tr>  
    <tr >  
      <td>新密码：</td> 
      <td><input type="password" name="rdPwd">  </td>  
    </tr> 
    <tr >  
      <td> 确认新密码：</td>  
       <td> <input type="password" name="rdPwd1">  </td>  
    </tr>  
    <tr>  
      <td>  
        <input type=submit value=提交 >  
      </td>  
    </tr>  
  </table>  
    </form>
  </body>
</html>
