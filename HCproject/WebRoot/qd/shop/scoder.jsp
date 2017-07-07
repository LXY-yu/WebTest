<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.xt.dao.ProductDao"%>
<%@page import="com.xt.pojo.View"%>
<%@page import="com.xt.pojo.Product"%>
<%@page import="com.xt.pojo.Shop"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>订单生产</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="qdcss/common.css" rel="stylesheet" type="text/css" />
	<link href="qdcss/myWacom.css" rel="stylesheet" type="text/css" />
	<link href="should_be_excluded/css/style.css" rel="stylesheet"
			type="text/css" />
		<script src="should_be_excluded/js/jquery/jquery.js"
			type="text/javascript"></script>
		<script src="should_be_excluded/js/dutil/DUtil.js"
			type="text/javascript"></script>
		<script src="should_be_excluded/css/css.js"
			type="text/javascript"></script>
		<link href="css/style.css" rel="stylesheet" type="text/css" />
		<script src="js/common.js" type="text/javascript"></script>
		<script>
					function tijiao(shopmony){
					if(confirm('确定提交？')){
					var f1=document.getElementById('proForm');
					f1.action="QdProManaServlet?flag=order&&totalprice="+shopmony;
					f1.submit();
					}
					
					}
					function quxiao(){
					window.parent.location="qd/shop/myshopinfo.jsp";
					}
		</script>
  </head>
  
  <body>
  <%   ProductDao dao=new ProductDao();
		  List<Shop>  shoplist=new ArrayList<Shop>();
		  shoplist= dao.selshop();
		    session.setAttribute("shoplist",shoplist);
		    String username=(String)session.getAttribute("qduser");
	 %>
  <!--头部star-->
<iframe style="border:0; width:100%; height:185px; margin-bottom:10px" frameborder="0" scrolling="no" src="qd/ggao/ggao.jsp"></iframe>
<!--头部end-->
<!--菜单-->
<form id="proForm" method="post" action="">
<div class="menu">
  <ul>
    <li><a href="qd/main.jsp">首页</a></li>
    <li><a href="qd/product/proindex.jsp">农产品大全</a></li>
    <li><a href="qd/advice/advice.jsp">意见反馈</a></li>
    <li><a href="qd/shop/myshopinfo.jsp">购物车</a></li>
  </ul>
</div>

<!--菜单 end-->


<div class="containers mt10">
  
  <!--我的商盟右边-->
  <div class="myWacomRight">
    <div class="sort palce3" >
    <!-- 搜索栏begin -->
      	<font size="10">亲，您的农产品订单生成</font><font size="5" color="red">总金额：<%=dao.CountShop() %>元</font>
      	【已经为您去掉零头】
			</div>
			<!-- 搜索栏end -->
    </div>
    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="fal-orderTitle">
    <thead>
      <tr>
        <th class="w330">商品名称</th>
         <th>单价</th>
        <th>数量</th>
        <th>小计</th>
     </tr></thead>
     <tbody>
       <c:forEach var="shop" items="${shoplist}">
              <tr>
          <td class="tc p10 botLine"> <div class="orderProInfo"> <a href="#" class="proImg"><img src="${shop.img}" /></a>
            <p class="proName2" style="padding-top: 20px">&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">${shop.pname}</a></p>
          
            
          </div> </td>
           <td class="tc botLine"><font size="2px">${shop.price}元</font></td>
          <td class="tc botLine"><font size="2px">${shop.count}</font></td>
           <td  class="tc botLine" ><font color="red">￥${shop.count*shop.price}</font></td>
        </tr>
     </c:forEach>
   </table>

       <!--翻页begin-->
       <div>
						<font size="5">收货地址:</font><input type="text" name="address" value="<%=dao.seladdress(username) %>" size="50" style="height: 25px">
					</div>
		 <div class="dclass_pager " align="right">
					<input type="button" style="background-color:red;width:142px;height:33px;border-bottom-style: none;border-left-style: none;border-right-style: none;border-top-style: none;" value="取消订单" onclick="quxiao()">	<input type="button" style="background-color:red;width:142px;height:33px;border-bottom-style: none;border-left-style: none;border-right-style: none;border-top-style: none;" value="提交订单" onclick="tijiao('<%=dao.CountShop() %>')">
					</div>
      <!--翻页 end-->    
  </div>  
  <!--我的商盟右边 end-->
</div>
</form>


<iframe style="border:0; width:100%; height:255px;" frameborder="0" scrolling="no" src="qd/foot.jsp"></iframe>
  </body>
</html>
