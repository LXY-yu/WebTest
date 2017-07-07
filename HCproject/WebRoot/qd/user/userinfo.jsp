<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.xt.dao.QdUser"%>
<%@page import="com.xt.pojo.User"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>我的资料</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="qdcss/common.css" rel="stylesheet" type="text/css" />
	<link href="qdcss/myWacom.css" rel="stylesheet" type="text/css" />
</head>
<%
	QdUser qdUser = new QdUser();

	User user = qdUser.getUserInfo((String) session
			.getAttribute("qduser"));
	String address = qdUser.getUserAddress((String) session
			.getAttribute("qduser"));

%>

<body>

	<!--头部star-->
	<iframe style="border:0; width:100%; height:190px; margin-bottom:10px"
		frameborder="0" scrolling="no" src="qd/ggao/ggao.jsp"></iframe>
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
	<div class="containers mt10">
		<!--我的商盟左边-->
		<div class="myWacomLeft">
			<div class="myWacomMenuTitle"></div>
			<table width="100%" border="0" cellspacing="0" cellpadding="0"
				class="myWacomSubMenu">
				<tr>
					<td><img src="qdimages/zqf_myWacomMenuIco1.png" width="18"
						height="18" align="absmiddle" />个人管理</td>
				</tr>
				<tr>
					<th><img src="qdimages/zqf_myWacomMenuDot.png" width="9"
						height="9" align="absmiddle" />我的资料<br /> <img
						src="qdimages/zqf_myWacomMenuDot.png" width="9" height="9"
						align="absmiddle" /><a href="qd/user/address.jsp">收货地址</a> <br />
						<img src="qdimages/zqf_myWacomMenuDot.png" width="9" height="9"
						align="absmiddle" /><a href="qd/user/password.jsp">修改密码</a></th>
				</tr>
				<tr>
					<td><img src="qdimages/zqf_myWacomMenuIco2.png" width="18"
						height="18" align="absmiddle" />交易管理</td>
				</tr>
				<tr>
					<th><img src="qdimages/zqf_myWacomMenuDot.png" width="9"
						height="9" align="absmiddle" /><a href="qd/shop/myorder.jsp">我的订单</a>
				</tr>
				<tr>
					<td><img src="qdimages/zqf_myWacomMenuIco3.png" width="18"
						height="18" align="absmiddle" />客服服务</td>
				</tr>
				<tr>
					<th><img src="qdimages/zqf_myWacomMenuDot.png" width="9"
						height="9" align="absmiddle" /><a href="qd/advice/myadvice.jsp">我的反馈</a></th>
				</tr>

				<tr>
					<td><img src="qdimages/zqf_myWacomMenuIco5.png" width="18"
						height="18" align="absmiddle" />个性服务</td>
				</tr>
				<tr>
					<th><img src="qdimages/zqf_myWacomMenuDot.png" width="9"
						height="9" align="absmiddle" /><a href="qd/user/mycollection.jsp">我的收藏</a></th>
				</tr>
			</table>
		</div>
		<!--我的商盟左边 end-->
		<!--我的商盟右边（会籍服务）-->
		<div class="myWacomRight">
			<div class="sort palce3">
				<div class="sortLeft"></div>
				<div class="sortRight"></div>
				<h2 class="fb">我的资料</h2>
			</div>
			<%
				String msg = (String) session.getAttribute("msg");
			%>
			<p style="color: red">
			<%
			if(msg!=null){
			%>
			<%=msg%>
			<%
			}
			 %>
				
			</p>
			<%
				session.removeAttribute("msg");
			%>
			<form action="UpdateUserInfoServlet" method="post">
				<input type="hidden" name="tag"  value="userinfo"/>
				<div class="borGray borNoT mb10">
					<table border="0" cellspacing="0" cellpadding="0"
						class="memberInput">
						<tr>
							<th>用户名：</th>
							<td><input type="text" name="username" id="textfield"
								readonly="readonly" class="joinInput"
								value="<%=user.getLoginname()%>" /></td>
						</tr>

						<tr>
							<th>手机号码：</th>
							<td><input type="text" name="tel" id="textfield3"
								class="joinInput mb5" value="<%=user.getTel()%>" /> </td>
						</tr>

						<tr>
							<th>电子邮箱：</th>
							<td><input type="text" name="email" id="textfield5"
								class="joinInput" value="<%=user.getEmail()%>" /></td>
						</tr>
						<tr>
							<th>联系地址：</th>
							<td><input type="text" name="address" id="textfield5"
								class="joinInput" value="<%=address%>" /></td>
						</tr>

						
					</table>
					<p class="cb"></p>
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td class="tc pb30"><input type="submit" class="inforSure"
								value="确 定" />
						</tr>
					</table>
				</div>
			</form>
		</div>
		<!--我的商盟右边（会籍服务）  end-->
	</div>
	<iframe style="border:0; width:100%; height:255px;" frameborder="0"
		scrolling="no" src="qd/foot.jsp"></iframe>

</body>
</html>
