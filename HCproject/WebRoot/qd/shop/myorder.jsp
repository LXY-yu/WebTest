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
    
    <title>我的订单</title>
    
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
		function zhifu(orderid1){
			window.location.href="qd/shop/ordersuccess.jsp?orderid="+orderid1;
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
          <th><img src="qdimages/zqf_myWacomMenuDot.png" width="9" height="9" align="absmiddle" /><a href="qd/user/userinfo.jsp">我的资料</a><br /><img src="qdimages/zqf_myWacomMenuDot.png" width="9" height="9" align="absmiddle" /><a href="qd/user/address.jsp">收货地址</a>
           <br /><img src="qdimages/zqf_myWacomMenuDot.png" width="9" height="9" align="absmiddle" /><a href="qd/user/password.jsp">修改密码</a></th>
        </tr>
        <tr>
          <td><img src="qdimages/zqf_myWacomMenuIco2.png" width="18" height="18" align="absmiddle" />交易管理</td>
        </tr>
        <tr>
          <th><img src="qdimages/zqf_myWacomMenuDot.png" width="9" height="9" align="absmiddle" />我的订单
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
          <th><img src="qdimages/zqf_myWacomMenuDot.png" width="9" height="9" align="absmiddle" /><a href="qd/user/mycollection.jsp">我的收藏</a></th>
        </tr>
      </table>

  </div><!--我的商盟左边 end-->
  
  <!--我的商盟右边-->
  <div class="myWacomRight">
    <div class="sort palce3" >
      <div class="sortLeft"></div>
      <div class="sortRight"></div>
      <h2>我的订单</h2>
    </div>
    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="orderTitle">
      <tr>
        <td>商品信息</td>
        <td width="130">商户</td>
        <td width="100">订单总价</td>
        <td width="100">状态</td>
     </tr>
   </table>

	<% ProductDao dao1=new ProductDao();
		OrderDao dao=new OrderDao();
		String username=session.getAttribute("qduser").toString();
		 String pageStr = request.getParameter("page"); 

            int currentPage = 1; 

            if (pageStr != null) { 

                currentPage = Integer.parseInt(pageStr); 

            } 

            View view = new View(3, dao.countorder(username), currentPage); 

            //获取参数 

            int fromIndex = view.getFromIndex();//起始位置 

            int pageSize = view.getPageSize();//每页显示的记录数
            List<Order> orderlist=dao.limorder(fromIndex,pageSize,username);
			List<Shop> shopli=new ArrayList<Shop>();
			int id=0;//商品id
			
	 %>
	 <%
	 		for(Order order:orderlist){  
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
            订单编号：<a href="javascript:void(0)" class="fb orderNumber"><%=order.getOrderid() %></a>&nbsp;&nbsp;&nbsp;&nbsp;订购时间：<%=order.getTime() %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;单位(元)</span></th>
        </tr>
      </thead>
      <tbody>
      
      	
      		
      		 <tr>
      		
          <td>
           
      		 <%
      		shopli=dao.getOrderShop(order.getOrderid());
      		 id=shopli.get(0).getId();
      		%>
          <div class="orderProInfo"> <a href="javascript:void(0)" class="proImg"><img src="<%=dao1.selproimg(id) %>" /></a>
            <p class="proName"><a href="javascript:void(0)"><%=dao1.selproname(id) %></a></p>
            <p class="proAttribute">
            <span class="span2">数量：<strong><%=shopli.get(0).getCount() %></strong></span>
            <span class="span2">该商品总价：<strong><%=(shopli.get(0).getCount())*(dao1.selproprice(id)) %></strong></span>
            </p>
            
          </div>
         
          </td>
          
           
          <td rowspan="2" ><span class="storeName">&nbsp;&nbsp;华成农贸店</span><span class="storeAdvice"><a href="qd/advice/advice.jsp">留言</a></span><span class="storeAdvice"><a href="javascript:void(0)">评价</a></span></td>
          <td rowspan="2" class="tc" >
          <p>
          <font>共计(去零头)：</font>
          </p><br/><br>
          <p>
          <font color="red" size="4">￥<%=order.getTotalprice() %></font>
          </p>
          </td>
          <td rowspan="2" class="tc" >
          <br>
          <br>
          <%
          		if(order.getZhuangtai().equals("已支付")){
          		%>
          		<strong>已支付</strong>
          		<% 
          		}else{%>
          		
          		<a href="javascript:void(0)" class="ff00" onclick="zhifu('<%=order.getOrderid() %>')"><strong>未支付</strong></a>
          		
          		<%
          		}
           %>
          </td>
        </tr>
        
        <tr>
          <td><div class="orderProInfo"> 
            <p class="proName"><a href="javascript:void(0)" onclick="seeorder('<%=order.getOrderid() %>')"><strong>查看该订单所有商品</strong></a></p>
          </div></td>
        </tr>
        
       
      
       
        
        
      </tbody>
    </table>
    
    	<%
	 		}
	  %>
       <!--翻页begin-->
       <div class="dclass_pager " align="right">
						<span class="dclass_pager_nav">  <a href="qd/shop/myorder.jsp" ><font size="2"><strong>首页</strong></font></a> </span>
						<%
							if ((view.getCurrentPage() - 1) <= 0) {
						 %>
						<span class="dclass_pager_nav"> <a href="qd/shop/myorder.jsp"><font size="2"><strong>上一页</strong></font></a>  </span>
						<%}else{ %>
						 <span class="dclass_pager_nav"><a href="qd/shop/myorder.jsp?page=<%=(view.getCurrentPage() - 1)%>"><font size="2"><strong>上一页</strong></font></a> </span>
						 <%} %>
						 <% 
						 if ((view.getCurrentPage() + 1) > view.getPageCount()) { 
						  %>
						<span class="dclass_pager_nav"> <a href="qd/shop/myorder.jsp?page=<%=view.getPageCount() %>"><font size="2"><strong>下一页</strong></font></a>  </span>
						<%}else{ %>
						<span class="dclass_pager_nav"> <a href="qd/shop/myorder.jsp?page=<%=view.getCurrentPage()+1 %>"><font size="2"><strong>下一页</strong></font></a>  </span>
						<%} %>
						<span class="dclass_pager_nav"> <a href="qd/shop/myorder.jsp?page=<%=view.getPageCount() %>"><font size="2"><strong>末页</strong></font></a>  </span>
						<span class="dclass_pager_sum"><font size="2"><strong>共<%=view.getRecordCount()%>条记录 第<%=view.getCurrentPage()%>页/共<%=view.getPageCount()%>页</strong></font> 
						<input type="text" size="2"  id="icount" onmouseout="ck()"/>
						&nbsp;<a href="" id="a1"><font size="2"><strong>转到</strong></font></a>
						</span>
					</div>
				<!--翻页end-->	
					
</div>

</div>

<iframe style="border:0; width:100%; height:255px;" frameborder="0" scrolling="no" src="qd/foot.jsp"></iframe>
  </body>
</html>
