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
    
    <title>My JSP 'L_ListReader.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript">
     function validate(){
	  if(document.myform.rdStatus.value!="有效"){
		  alert("该借书证已被挂失，无法借书！");
		  return false;
	  }
	  if(document.myform.rdBorrowQty.value>=document.myform.CanLendQty.value){
		  alert("该借书证可借书数量已满，无法借书！");
		  return false;
	  }
	  if(document.myform.rdBorrowQty.value!=0){
		  
		  if(document.myform.IdOverDay.value>0){
		  alert("该借书证存在超期未归还图书，无法借书！");
		  return false;
		  }else{
		  return true;
		  }
	  }
     if(document.myform.IdPunishMoney.value!=0){
		  alert("存在罚款未缴纳，无法借书！");
		  return false;
		  }
	  return true;
  }
  </script>

  </head>
  
  <body>
  <%
  String rdIDUser=request.getParameter("rdIDUser");
  session.setAttribute("rdIDUser",rdIDUser);
  %>
    <c:forEach var="me" items="${list}">
    <form method="get" action="${pageContext.request.contextPath }/L_SearchBook.jsp" id="myform" name="myform" target="tfr" onSubmit="return validate()">
    <table border="1" width="80%" bordercolor="black">
    <tr>
    <td width="10%">读者照片</td>
     <td width="10%">借书证号</td>
     <td width="10%">读者姓名</td>
     <td width="10%">性别</td> 
     <td width="10%">单位名称</td>
     
     <td width="10%">证件状态</td>
     <td width="10%">已借书数量</td>
     </tr>
     <tr>  
          <td><img src="img/${me.rdPhoto}" style="width:100px;height:100px"></td>         
          <td><input style="width:100%" type="text" name="rdID" value=${me.rdID}  readonly="true"></td>
          <td><input style="width:100%" type="text" name="rdName" value=${me.rdName} readonly="true"></td>      
          <td><input style="width:100%" type="text" name="rdSex" value=${me.rdSex} readonly="true"></td>         
          <td><input style="width:100%" type="text" name="rdDept" value=${me.rdDept} readonly="true"></td>        
                  
          <td><input style="width:100%" type="text" name="rdStatus" value=${me.rdStatus} readonly="true"></td>     
          <td><input style="width:100%" type="text" name="rdBorrowQty" value=${me.rdBorrowQty} readonly="true"></td>
    </tr>          
                    
   <c:forEach var="b" items="${list1}">     
          <tr>
          <td>借书日期</td>
          <td>应还日期</td>
          <td>实际还书日期</td>
           <td>超期天数</td>
           <td>超期金额</td>
           <td>罚款金额</td>
           <td>是否还书</td>
           </tr>
           <tr>
          <td><input style="width:100%" type="text" name="IdDateOut" value=${b.iddateout} readonly="true"></td>
          <td><input style="width:100%" type="text" name="IdDateRetPlan" value=${b.iddateretplan} readonly="true"></td>          
          <td><input style="width:100%" type="text" name="IdDateRetAct" value=${b.iddateretact} readonly="true"></td>         
          <td><input style="width:100%" type="text" name="IdOverDay" value=${b.idoverday} readonly="true"></td>          
          <td><input style="width:100%" type="text" name="IdOverMoney" value=${b.idOvermoney} readonly="true"></td>
          <td><input style="width:100%" type="text" name="IdPunishMoney" value=${b.idpunishmoney} readonly="true"></td>         
          <td><input style="width:100%" type="text" name="IsHasReturn" value=${b.ishasreturn} readonly="true"></td>
          </tr>
   </c:forEach>
   
                                             
      </table>
      <c:forEach var="cc" items="${list2}">     
  
         <input style="width:100%" type="hidden" name="CanLendQty" value=${cc.canLendQty} readonly="true"></td>
         <input style="width:100%" type="hidden" name="CanLendDay" value=${cc.canLendDay} readonly="true"></td>
         <input style="width:100%" type="hidden" name="CanContinueTimes" value=${cc.canContinueTimes} readonly="true"></td>
     </c:forEach>
          <input style="width:100%" type="hidden" name="rdPhone" value=${me.rdPhone} readonly="true">
          <input style="width:100%" type="hidden" name="rdEmail" value=${me.rdEmail} readonly="true">
          <input style="width:100%" type="hidden" name="rdDateReg" value=${me.rdDateReg} readonly="true">       
          <input style="width:100%" type="hidden" name="rdPwd" value=${me.rdPwd} readonly="true">
           <input style="width:100%" type="hidden" name="OperatorLend" value=${b.operatorlend} >
          <input style="width:100%" type="hidden" name="OperatorRet" value=${b.operatorret} >
          <input style="width:100%" type="hidden" name="rdAdminRoles" value=${me.rdAdminRoles} readonly="true">
          <input style="width:100%" type="hidden" name="DateValid" value=${cc.dateValid} readonly="true">
          <input style="width:100%" type="hidden" name="PunishRate" value=${cc.punishRate} readonly="true">
         <input style="width:100%" type="hidden" name="BorrowID" value=${b.borrowid}  readonly="true">
         <input style="width:100%" type="hidden" name="rdID" value=${b.rdID} readonly="true">
          <input style="width:100%" type="hidden" name="bkID" value=${b.bkID} readonly="true">
         <input style="width:100%" type="hidden" name="rdType" value=${me.rdType} readonly="true">
         <input style="width:100%" type="hidden" name="rdTypeName" value=${cc.rdTypeName} readonly="true">
         <input style="width:100%" type="hidden" name="IdContinueTimes" value=${b.idcontinuetimes} readonly="true">
      <input type="submit" value="点击借书">
      </form>
      </c:forEach> 
  </body>
</html>
