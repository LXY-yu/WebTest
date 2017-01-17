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
    
    <title>My JSP 'R_setRoles.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript">
  function validate(){
	  alert("确认设置吗？");
	  return true;
}
  </script>

  </head>
  
  <body>
    <c:forEach var="me" items="${list}">
    <form method="get" action="${pageContext.request.contextPath }/R_UpdateServlet" target="bfr" onSubmit="return validate()">
    <table border="1" width="40%" bordercolor="black">    
         
          <tr>
          <td>借书证号</td>  
          <td><input style="width:100%" type="text" name="rdID" value=${me.rdID} readonly="true"></td>
          </tr>
          <tr>
          <td>读者姓名</td>
          <td><input style="width:100%" type="text" name="rdName" value=${me.rdName} readonly="true"></td>
          </tr>
          <tr>
          <td>读者密码</td>
          <td><input style="width:100%" type="text" name="rdPwd" value=${me.rdPwd} readonly="true"></td>
          </tr>
          <tr>
          <td>性别</td> 
          <td><input style="width:100%" type="text" name="rdSex" value=${me.rdSex} readonly="true"></td>
          </tr>
          <tr>
          <td>读者类别</td>
          <td><input style="width:100%" type="text" name="rdType" value=${me.rdType} readonly="true"></td>
          </tr>
          <tr>
          <td>单位名称</td>
          <td><input style="width:100%" type="text" name="rdDept" value=${me.rdDept} readonly="true"></td>
          </tr>
          <tr>
          <td>电话号码</td>
          <td><input style="width:100%" type="text" name="rdPhone" value=${me.rdPhone} readonly="true"></td>
          </tr>
          <tr>
          <td>电子邮箱</td>
          <td><input style="width:100%" type="text" name="rdEmail" value=${me.rdEmail} readonly="true"></td>
          </tr>
          <tr>
          <td>办证日期</td>
          <td><input style="width:100%" type="text" name="rdDateReg" value=${me.rdDateReg} readonly="true"></td>
          </tr>
          <tr>
          <td>读者照片</td>
          <td><img src="img/${me.rdPhoto}" style="width:100px;height:100px">
          <input name="rdPhoto" value=${me.rdPhoto} type="hidden"></td>
          </tr>
          <tr>
          <td>证件状态</td>
          <td><input style="width:100%" type="text" name="rdStatus" value=${me.rdStatus} readonly="true"></td>
          </tr>
          <tr>
          <td>已借书数量</td>
          <td><input style="width:100%" type="text" name="rdBorrowQty" value=${me.rdBorrowQty} readonly="true"></td>
          </tr>
          <tr>
          <td>管理角色</td>
          <td>
          <select name="rdAdminRoles">
          <option value='0'>读者</option>
          <option value='1'>借书证管理</option>
          <option value='2'>图书管理</option>
          <option value='4'>借阅管理</option>
          <option value='8'>系统管理</option>
          </select>
          </td>
          </tr>                                  
      </table>
      <input type="submit" value="设置">
      </form>
      </c:forEach>
  </body>
</html>
