<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'R_HandleReader.jsp' starting page</title>
    
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
    <h2>该读者尚不存在，请办理</h2>
    <script type="text/javascript">
  function validate(){
  if (document.myform.rdID.value==""){
  alert("借书证号不能为空.");
  document.myform.rdID.focus();
  return false ;
  }
  if (document.myform.rdName.value==""){
  alert("读者姓名不能为空.");
  document.myform.rdName.focus();
  return false ;
 }if (document.myform.rdDept.value==""){
  alert("单位名称不能为空.");
  document.myform.rdDept.focus();
  return false ;
  }
   
 return true;
}
</script>  
    <form method="get" action="${pageContext.request.contextPath }/R_HandleServlet" id="myform" name="myform" onSubmit="return validate()">
    <table>
    <tr>
    <td>借书证号</td>
    <td><input type="text" name="rdID"></td>
    </tr>
    <tr>
    <td>读者姓名</td>
    <td><input type="text" name="rdName"></td>
    </tr>
    <tr>
    <td>读者密码</td>
    <td><input type="text" name="rdPwd" value="123" readonly="true"></td>
    </tr>
    <tr>
    <td>性别</td>
    <td>
    <select name="rdSex">
    <option value='男'>男</option>
    <option value='女' selected="selected">女</option>
    </select>
    </td>
    </tr>
    <tr>
    <td>读者类别</td>
    <td>
    <select name="rdType">
    <option value='1'>教师</option>
    <option value='2' selected="selected">学生</option>
    </select>
    </td>
    </tr>
    <tr>
    <td>单位名称</td>
    <td><input type="text" name="rdDept"></td>
    </tr>
    <tr>
    <td>电话号码</td>
    <td><input type="text" name="rdPhone"></td>
    </tr>
    <tr>
    <td>电子邮箱</td>
    <td><input type="text" name="rdEmail"></td>
    </tr>
    <tr>
    <td>读者照片</td>
    <td><input type="file" name="rdPhoto"></td>
    <td> 
    <input type="reset" value="清除" name="clear" size="25"> 
    </td>
    </tr>
    <tr>
    <td>证件状态</td>
    <td>
    <select name="rdStatus">
    <option value='有效' selected="selected">有效</option>
    <option value='挂失'>挂失</option>
    <option value='注销'>注销</option>
    </select>
    </td>
    </tr>
    <tr>
    <td>管理角色</td>
    <td>
    <select name="rdAdminRoles">
    <option value='0' selected="selected">读者</option>
    <option value='1'>借书证管理</option>
    <option value='2'>图书管理</option>
    <option value='4'>借阅管理</option>
    <option value='8'>系统管理</option>
    </select>
    </td>
    </tr>
    
    </table>
    <input type="submit" value="添加">
    </form>
  </body>
</html>
