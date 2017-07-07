<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.xt.pojo.Shop"%>
<%@page import="com.xt.dao.ProductDao"%>
<%@page import="com.xt.pojo.View"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.xt.dao.OrderDao"%>
<%@page import="com.xt.pojo.Order"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>前端首页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="qdcss/common.css" rel="stylesheet" type="text/css" />
	<link href="qdcss/myWacom.css" rel="stylesheet" type="text/css" />
	
	<script type="text/javascript">
	 function  ck(){
					var icount=document.getElementById('icount').value;
					if(icount.trim()!=0){
					  document.getElementById("a1").href="qd/shop/myorder.jsp?page="+icount;
					  }else{
					   document.getElementById("a1").href="qd/shop/myorder.jsp?page=1";
					  }
					}
	function seeorder(orderid){
		window.location.href="qd/shop/seeorder.jsp?orderid="+orderid;
	}
	</script>
  </head>
  
  <body>
  <!--头部star-->
<center><p><iframe style="border:0; width:100%; height:185px; margin-bottom:10px" frameborder="0" scrolling="no" src="qd/ggao/ggao.jsp"></iframe></p></center>
<!--头部end-->
<!--菜单-->
<div class="menu">
  <ul>
    <li class="on"><a href="qd/main.jsp">首页</a></li>
    <li><a href="qd/product/proindex.jsp">农产品大全</a></li>
    <li><a href="#">农业资讯</a></li>
    <li><a href="qd/advice/advice.jsp">意见反馈</a></li>
    <li><a href="qd/shop/myshopinfo.jsp">购物车</a></li>
  </ul>
</div>

<!--菜单 end-->


<div class="containers mt10">
  <!--我的商盟左边-->
  <div class="myWacomLeft">
    <div class="myWacomMenuTitle"></div>
      <table width="100%" border="0" cellspacing="0" cellpadding="0" class="myWacomSubMenu">
        <tr>
         <td><img src="qdimages/zqf_myWacomMenuIco1.png" width="18" height="18" align="absmiddle" />个人管理</td>
        </tr>
        <tr>
          <th><img src="qdimages/zqf_myWacomMenuDot.png" width="9" height="9" align="absmiddle" /><a href="我的商盟-我的资料.html">我的资料</a><br /><img src="qdimages/zqf_myWacomMenuDot.png" width="9" height="9" align="absmiddle" /><a href="#">收货地址</a>
           <br /><img src="qdimages/zqf_myWacomMenuDot.png" width="9" height="9" align="absmiddle" /><a href="我的商盟-修改密码.html">修改密码</a></th>
        </tr>
        <tr>
          <td><img src="qdimages/zqf_myWacomMenuIco2.png" width="18" height="18" align="absmiddle" />交易管理</td>
        </tr>
        <tr>
          <th><img src="qdimages/zqf_myWacomMenuDot.png" width="9" height="9" align="absmiddle" /><a href="我的商盟-我的订单.html">我的订单</a>
         </th>
        </tr>
        <tr>
          <td><img src="qdimages/zqf_myWacomMenuIco3.png" width="18" height="18" align="absmiddle" />客服服务</td>
        </tr>
        <tr>
          <th><img src="qdimages/zqf_myWacomMenuDot.png" width="9" height="9" align="absmiddle" /><a href="qd/advice/myadvice.jsp">我的反馈</a></th>
        </tr>
       
        <tr>
          <td><img src="qdimages/zqf_myWacomMenuIco5.png" width="18" height="18" align="absmiddle" />个性服务</td>
        </tr>
        <tr>
          <th><img src="qdimages/zqf_myWacomMenuDot.png" width="9" height="9" align="absmiddle" /><a href="#">我的收藏</a></th>
        </tr>
      </table>

  </div><!--我的商盟左边 end-->
  
  <!--我的商盟右边-->
  <div class="myWacomRight">
    <div class="sort palce3" >
      <div class="sortLeft"></div>
      <div class="sortRight"></div>
      <h2>当前订单</h2>
    </div>
    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="orderTitle">
      <tr>
        <td><a href="qd/shop/myorder.jsp"><font size="2">返回订单列表</font></a></td>
     </tr>
   </table>

	<% ProductDao dao1=new ProductDao();
		OrderDao dao=new OrderDao();
		String username=session.getAttribute("qduser").toString();
		String orderid=request.getParameter("orderid");
		Order order=new Order();
		order=dao.getOrder(orderid);
			List<Shop> shopli=new ArrayList<Shop>();
			int id=0;//商品id
			
	 %>
	
	 	
    <table class="orderTable" width="100%" border="0" cellspacing="0" cellpadding="0">
      <colgroup>
        <col />
        <col width="130" />
        <col width="100" />
        <col width="100" />
      </colgroup>
      <thead>
        <tr>
          <th colspan="4"><span class="fl f666">
            订单编号：<a href="商城订单中心-订单详情.html" class="fb orderNumber"><%=orderid%></a>&nbsp;&nbsp;&nbsp;&nbsp;订购时间：<%=order.getTime() %></span></th>
        </tr>
      </thead>
      <tbody>
      
      	<%
      		shopli=dao.getOrderShop(order.getOrderid());
      		for(int i=0;i<shopli.size();i++){
      		 id=shopli.get(i).getId();
      		 %>
      		
      		 <tr>
      		
          <td width="100">
           
      		 
      		
         
         <p align="center"> <a href="javascript:void(0)" class="proImg"><img src="<%=dao1.selproimg(id) %>" width="50" height="50"/></a></p></td>
          <td>
            <p><a href="javascript:void(0)"><%=dao1.selproname(id) %></a></p>
            </td>
            <td>
            <p>
            <span>数量：<strong><%=shopli.get(i).getCount() %></strong></span></p>
            </td>
            
            <td>
            <p>
            <span>该商品总价：<strong><%=(shopli.get(i).getCount())*(dao1.selproprice(id)) %></strong></span>
            </p>
            
          </td>
          
        </tr>
         <%
      		}
      		
      		%>
      </tbody>
    </table>
    
    	
      
					
</div>

</div>

<iframe style="border:0; width:100%; height:255px;" frameborder="0" scrolling="no" src="qd/foot.jsp"></iframe>
  </body>
</html>
