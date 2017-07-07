<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="css2/style.css">
    
 
 <script src="js2/jquery.min.js"></script>
<script src="js2/common.js"></script>
<!--背景图片自动更换-->
<script src="js2/supersized.3.2.7.min.js"></script>
<script src="js2/supersized-init.js"></script>
<!--表单验证-->
<script src="js2/jquery.validate.min.js?var1.14.0"></script>

 
  
 <script language="javascript">
 function check1()
 {                                                                                         
     if(document.ThisForm.userName.value=="")
	 {
	 	alert("请输入用户名");
		document.ThisForm.userName.focus();
		return false;
	 }else
	 if(document.ThisForm.userPw.value=="")
	 {
	 	alert("请输入密码");
		document.ThisForm.userPw.focus();
		return false;
	 }else if(document.getElementById('logintype').value=="")
	 {
	   alert('请选择身份！！');
	   return false;
	 }
	 if(document.getElementById('logintype').value=="admin"){
	 document.ThisForm.action="AdLoginServlet";
	document.ThisForm.submit();
	 }else if(document.getElementById('logintype').value=="user"){
	 	document.ThisForm.action="qdLoginServlet?flag=login";
	document.ThisForm.submit();
	 }
	 	
	
 }
 
 
 function reg()
  {
          var url="qd/user/reg.jsp";
          var n="newwindow";
          var h="height=500, width=400, toolbar =no, menubar=no, scrollbars=no, resizable=no, location=no, status=no";
          window.open(url,n,h);
  }
 </script>
</head>
<body>
<%
	session.removeAttribute("qduser");
	session.removeAttribute("user");
 %>
<br>
	<br>
	<br>
	<br>
	<center>
	<table width="559" height="423" border="0" align="center" cellpadding="0" cellspacing="0" >
	 <tr>
	    <td><div align="center" ><h1>欢迎来到华成农贸</h1></div></td>
	 </tr>
	 <tr>
		<td width="559">
			<form name="ThisForm" method="POST" action="">
				<table width="410" height="198" border="0" align="right" cellpadding="0" cellspacing="0">						              
				  用户名：<input name="userName"  type="text" class="input2">
				<tr>&nbsp</tr>
			           密&nbsp;&nbsp;&nbsp;&nbsp;码：
                <input name="userPw" type="password" size="21" class="input2" align="bottom" >
						<select name="type" id="logintype">
						<option value="">请选择身份</option>
						<option value="admin">管理员</option>
						<option value="user">用户</option>
						</select>
					    
					     
							
						<button id="submit"  onclick="check1()">登录</button>
							<button id="submit"  name="Submit2" type="submit"  onclick="reg()">您已有账号?</button>
						<br/><br/><br/><font color="red">${qdmsg}</font>
     <font color="red">${msg}</font>
                </table>
	        </form>
        </td>
     </tr>
    </table>
    </center>
</html>
