<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.xt.pojo.Order"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>跳转界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
<script language="JavaScript" type="text/javascript">
function tijiao(){
	document.getElementById('form1').submit();
}
</script>
</head>
  <body onload="tijiao()">
  <%
  Order order=new Order();
  order=(Order)session.getAttribute("order");
  %>
  <form method="post" action="QdProManaServlet" id="form1">
  <input type="hidden" name="flag" value="pay">
  <input type="hidden" name="p2_Order" value="2341234">
  <input type="hidden" name="p3_Amt" value="5">
  <input type="hidden" name="pd_FrpId" value="ABC-NET-B2C">
  <input type="hidden" name="oid" value="${order.orderid}">
  </form>
    
  </body>
</html>
