<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.xt.dao.ProductDao"%>
<%@page import="com.xt.pojo.View"%>
<%@page import="com.xt.pojo.Product"%>
<%@page import="com.xt.pojo.Shop"%>
<%@page import="com.xt.pojo.Order"%>
<%@page import="com.xt.dao.OrderDao"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>支付界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="qdcss/common.css" rel="stylesheet" type="text/css" />
	<link href="qdcss/myWacom.css" rel="stylesheet" type="text/css" />
	<link href="should_be_excluded/css/style.css" rel="stylesheet"
			type="text/css" />
			<link rel="stylesheet" type="text/css" href="bookcss/order/pay.css">
	<script type="text/javascript" src="bookjs/jquery/jquery-1.5.1.js"></script>
			
		<script src="should_be_excluded/js/jquery/jquery.js"
			type="text/javascript"></script>
		<script src="should_be_excluded/js/dutil/DUtil.js"
			type="text/javascript"></script>
		<script src="should_be_excluded/css/css.js"
			type="text/javascript"></script>
		<link href="css/style.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" type="text/css" href="bookcss/order/ordersucc.css">
		<script src="js/common.js" type="text/javascript"></script>
		<script>
				
	$(function() {
	$("img").click(function() {
		$("#" + $(this).attr("name")).attr("checked", true);
	});
});

	
		function xiayibu(oid){
		  if(confirm("确认支付吗？")){
		  var url="qd/shop/begindeal.jsp";
             var ret = window.showModalDialog(url,"","dialogWidth:600px; dialogHeight:400px; dialogLeft: status:no; directories:yes;scrollbars:yes;Resizable=no;");
              window.location.href="qd/shop/deal.jsp";
		  
		  }
			
		}
			
			
		</script>
  </head>
  
  <body>
  <%  
  String username=(String)session.getAttribute("qduser");
  String orderid=request.getParameter("orderid");
   OrderDao dao=new OrderDao();
		Order order=new Order();
		order=dao.getOrder(orderid);
		    session.setAttribute("order",order);
		    
	 %>
  <!--头部star-->
<iframe style="border:0; width:100%; height:185px; margin-bottom:10px" frameborder="0" scrolling="no" src="qd/ggao/ggao.jsp"></iframe>
<!--头部end-->
<!--菜单-->
<div class="menu">
  <ul>
    <li><a href="qd/main.jsp">首页</a></li>
    <li><a href="qd/product/proindex.jsp">农产品大全</a></li>
    <li><a href="qd/advice/advice.jsp">意见反馈</a></li>
    <li><a href="qd/shop/myshopinfo.jsp">购物车</a></li>
  </ul>
</div>

<!--菜单 end-->



 
  
  <!--我的商盟右边-->
  <div style="padding-left: 185px">

    	<div class="divContent" align="center">
	<span class="spanPrice">支付金额：</span><span class="price_t">&yen;${order.totalprice  }</span>
	<span class="spanOid">订单编号：${order.orderid }</span>
</div>
<form action="" method="post" id="form1" target="_top">
<div class="divBank" align="center">
	<div class="divText">选择网上银行</div>
	<!--<input type="hidden" name="oid"/ value="${order.orderid}"><br/>
	<input type="hidden" name="p2_Order"/ value="123123324"><br/>
	<input type="hidden" name="p3_Amt" value="5"/><br/>
	  -->
	<input type="radio" name="pd_FrpId" value="ICBC-NET-B2C"/>工商银行
	<img src="<c:url value='/bank_img/icbc.bmp'/>" align="middle"/>
	<input type="radio" name="pd_FrpId" value="BOC-NET-B2C"/>中国银行
	<img src="<c:url value='/bank_img/bc.bmp'/>" align="middle"/><br/><br/>
	<input type="radio" name="pd_FrpId" value="ABC-NET-B2C"/>农业银行
	<img src="<c:url value='/bank_img/abc.bmp'/>" align="middle"/>
	<input type="radio" name="pd_FrpId" value="CCB-NET-B2C"/>建设银行
	<img src="<c:url value='/bank_img/ccb.bmp'/>" align="middle"/><br/><br/>
	<input type="radio" name="pd_FrpId" value="BOCO-NET-B2C"/>交通银行
	<img src="<c:url value='/bank_img/bcc.bmp'/>" align="middle"/><br/>
	<div style="margin: 40px;">
		<a href="javascript:void (0)" class="linkNext" onclick="xiayibu('${order.orderid}')">下一步</a>
	</div>
</div>
</form>

   </div> 
  <!--我的商盟右边 end-->



<iframe style="border:0; width:100%; height:255px;" frameborder="0" scrolling="no" src="qd/foot.jsp"></iframe>
  </body>
</html>
