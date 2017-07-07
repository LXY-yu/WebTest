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
    
    <title>购物车</title>
    
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
				
	function jia(proidone){
	  var f1=document.getElementById('proForm');
	  f1.action="QdProManaServlet?flag=jia&&id="+proidone;
	  f1.submit();
	}
	
	function jian(proidtwo){
	  var f2=document.getElementById('proForm');
	  f2.action="QdProManaServlet?flag=jian&&id="+proidtwo;
	  f2.submit();
	}
	
	function jiesuan(){
		window.parent.location="qd/shop/scoder.jsp";
	}


	function shanchu(shopid){
		var f3=document.getElementById('proForm');
		f3.action="QdProManaServlet?flag=shopcardelete&&shopid="+shopid;
		f3.submit();
	}





	
		
			
			
		</script>
  </head>
  
  <body>
  <%   ProductDao dao=new ProductDao();
		List<Shop> list=new ArrayList<Shop>();
		list=dao.selshop();
		    session.setAttribute("cartItemList",list);
		    
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
    <li class="on"><a href="qd/shop/myshopinfo.jsp">购物车</a></li>
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
          <th><img src="qdimages/zqf_myWacomMenuDot.png" width="9" height="9" align="absmiddle" /><a href="qd/shop/myorder.jsp">我的订单</a>
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
    	<c:choose>
	<c:when test="${empty cartItemList }">
	<table width="95%" align="center" cellpadding="0" cellspacing="0">
		<tr>
			<td align="right">
				<img align="top" src="bookimg/images/icon_empty.png"/>
			</td>
			<td>
				<span class="spanEmpty">您的购物车中暂时没有商品</span>
			</td>
		</tr>
	</table>  
	</c:when>
	<c:otherwise>
<table width="95%" align="center" cellpadding="0" cellspacing="0">
	<thead align="center" bgcolor="#efeae5" style="height: 60px">
		<tr>
		
		
		<th>图片</th>
		<th>商品名称</th>
		<th>单价</th>
		<th>数量</th>
		<th>小计</th>
		<th>操作</th>
		</tr>
	</thead>



<c:forEach items="${cartItemList }" var="cartItem">
	<tr align="center" height="50px">
		
		<td width="70px" >
			<a class="linkImage" href="<c:url value='/jsps/book/desc.jsp'/>"><img border="0" width="54" align="top" src="${cartItem.img}"/></a>
		</td>
		<td  width="70px">
		    <a href="<c:url value='/jsps/book/desc.jsp'/>"><span><font  size="2">${cartItem.pname}</font></span></a>
		</td>
		<td><span>&yen;<span class="currPrice"><font  size="2">${cartItem.price}</font></span></span></td>
		<td>
			<a href="javascript:void(0)" onclick="jian('${cartItem.id}')"><font size="3">-</font></a>&nbsp;<input class="quantity"  id="" type="text" value="${cartItem.count }" size="1"/><a href="javascript:void(0)" onclick="jia('${cartItem.id}')"><font size="2">+</font></a>
		</td>
		
		<td width="100px">
			<span class="price_n">&yen;<span class="subTotal" id=""><font  size="2">${cartItem.price*cartItem.count}</font></span></span>
		</td>
		
		<td>
			<a href="javascript:void(0)" onclick="shanchu('${cartItem.id}')">删除</a>
		</td>
	</tr>
</c:forEach>

	<tr>
		<td colspan="7" align="right">
		<input type="button" style="background-color:red;width:142px;height:33px;border-bottom-style: none;border-left-style: none;border-right-style: none;border-top-style: none;" value="结算" onclick="jiesuan()">
		</td>
	</tr>
</table>
	

	</c:otherwise>
</c:choose>
    
  <!--我的商盟右边 end-->
</div>
</form>


<iframe style="border:0; width:100%; height:255px;" frameborder="0" scrolling="no" src="qd/foot.jsp"></iframe>
  </body>
</html>
