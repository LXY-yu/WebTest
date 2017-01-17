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
    
    <title>My JSP 'L_ShowBorrow.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript">
     function validate(){
	  if(document.myform.rdStatus.value!="有效"){
		  alert("该借书证已挂失，无法续借书！");
		  return false;
	  }
	  if(document.myform.IdContinueTimes.value>=document.myform.CanContinueTimes.value){
		  alert("续借次数已满，无法续借书！");
		  return false;
	  }
	  return true;
  }
  </script>

  </head>
  
  <body>
    <c:forEach var="me" items="${list}">
    <form id="myform" name="myform" method="get" action="${pageContext.request.contextPath }/L_reLendServlet" target="bfr" onSubmit="return validate()">
    <table border="1" width="40%" bordercolor="black">    
          <tr>
          <td>图书序号</td>
          <td><input style="width:100%" type="text" name="bkID" value=${me.bkID} readonly="true"></td>
          </tr>
          <tr>
          <td>图书编号</td>
          <td><input style="width:100%" type="text" name="bkCode" value=${me.bkCode} readonly="true"></td>
          </tr>
          <tr>
          <td>书名</td>
          <td><input style="width:100%" type="text" name="bkName" value=${me.bkName} readonly="true"></td>
          </tr>
          <tr>
          <td>借书证号</td>
          <td><input style="width:100%" type="text" name="rdID" value=${me.rdID} readonly="true"></td>
          </tr>
          <tr>
          <td>读者姓名</td> 
          <td><input style="width:100%" type="text" name="rdName" value=${me.rdName} readonly="true"></td>
          </tr>
          <tr>
          <td>借书证状态</td>
          <td><input style="width:100%" type="text" name="rdStatus" value=${me.rdStatus} readonly="true"></td>
          </tr>
          <tr>
          <td>可续借的次数</td>
          <td><input style="width:100%" type="text" name="CanContinueTimes" value=${me.cancontinueTimes} readonly="true"></td>
          </tr>
          <tr>
          <td>已续借次数</td>
          <td><input style="width:100%" type="text" name="IdContinueTimes" value=${me.idcontinueTimes} readonly="true"></td>
          </tr>
          <tr>
          <td>借书日期</td>
          <td><input style="width:100%" type="text" name="IdDateOut" value=${me.iddateout} readonly="true"></td>
          </tr>
          <tr>
          <td>原应还书日期</td>
          <td><input style="width:100%" type="text" name="IdDateRetPlan" value=${me.iddateretplan} readonly="true"></td>
          </tr>
          <tr>
          <td>可续借天数</td>
          <td><input style="width:100%" type="text" name="CanLendDay" value=${me.canlendday} readonly="true"></td>
          </tr>
                                     
      </table>
      <input type="submit" value="续借" name="lend">
      </form>
      </c:forEach>  
  </body>
</html>
