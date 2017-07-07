<%@page import="com.xt.dao.QdUser"%>
<%@page import="com.xt.dao.QdUser"%>
<%@page import="com.xt.pojo.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>移动商盟</title>
<link href="qdcss/common.css" rel="stylesheet" type="text/css" />
<link href="qdcss/myWacom.css" rel="stylesheet" type="text/css" />
</head>
<body>


	<%
		QdUser qdUser = new QdUser();

		String address = qdUser.getUserAddress((String) session
				.getAttribute("qduser"));
	%>
	<iframe style="border:0; width:100%; height:198px; clear:both;"
		frameborder="0" scrolling="no" src="qd/ggao/ggao.jsp"></iframe>
	<!--头部 end-->
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
						height="9" align="absmiddle" /><a href="qd/user/userinfo.jsp">我的资料</a><br />
						<img src="qdimages/zqf_myWacomMenuDot.png" width="9" height="9"
						align="absmiddle" /><a href="qd/user/address.jsp">收货地址</a> <br />
						<img src="qdimages/zqf_myWacomMenuDot.png" width="9" height="9"
						align="absmiddle" />修改密码</th>
				</tr>
				<tr>
					<td><img src="qdimages/zqf_myWacomMenuIco2.png" width="18"
						height="18" align="absmiddle" />交易管理</td>
				</tr>
				<tr>
					<th><img src="qdimages/zqf_myWacomMenuDot.png" width="9"
						height="9" align="absmiddle" /><a href="qd/shop/myorder.jsp">我的订单</a>
					</th>
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
		<!--我的商盟右边（会籍服务）-->
		<div class="myWacomRight">
			<div class="sort palce3">
				<div class="sortLeft"></div>
				<div class="sortRight"></div>
				<h2 class="fb">修改密码</h2>
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
				<input type="hidden" name="tag" value="password" />
				<div class="borGray borNoT mb10">
					<table border="0" cellspacing="0" cellpadding="0"
						class="memberInput">
						<tr>
							<th>请输入原始密码：</th>
							<td><input type="password" name="oldPass" id="textfield"
								class="joinInput" /></td>
						</tr>
						<tr>
							<th>请输入新的密码：</th>
							<td align="left"><input type="password" name="password"
								id="textfield3" class="joinInput" /></td>
						</tr>
						<tr>
							<th>请再次确认新密码：</th>
							<td><input type="password" name="textfield3" id="password"
								class="joinInput" /></td>
						</tr>

					</table>
					<p class="cb"></p>
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td class="tc pb30"><input type="submit" class="inforSure"
								value="确 定" /><input type="reset" class="inforCanle"
								value="重 置" /></td>
						</tr>
					</table>
				</div>
			</form>
		</div>
		<!--我的商盟右边（会籍服务）  end-->
	</div>
	<!--帮助-->
	<div class="help">
		<div class="helpBox">
			<div class="help1">
				<h2>业务帮助</h2>
				<ul>
					<li><a href="#">市场合作</a></li>
					<li><a href="#">商户加盟</a></li>
					<li><a href="#">友情链接</a></li>
					<li><a href="#">了解商盟</a></li>
					<li><a href="#">优先商户</a></li>
				</ul>
			</div>
			<div class="help2">
				<h2>新手上路</h2>
				<ul>
					<li><a href="#">市场合作</a></li>
					<li><a href="#">商户加盟</a></li>
					<li><a href="#">友情链接</a></li>
					<li><a href="#">了解商盟</a></li>
					<li><a href="#">优先商户</a></li>
				</ul>
			</div>
			<div class="help3">
				<h2>商家加盟</h2>
				<ul class="lost">
					<li><a href="#">市场合作</a></li>
					<li><a href="#">商户加盟</a></li>
					<li><a href="#">友情链接</a></li>
					<li><a href="#">了解商盟</a></li>
					<li><a href="#">优先商户</a></li>
				</ul>
			</div>
		</div>
	</div>
	<!--帮助 end-->
	<!--底部版权-->
	<div class="foot">
		<p>
			<a href="#">法律声明</a>| <a href="#">帮助信息</a>| <a href="#">联系我们</a>| <a
				href="#">网站地图</a>
		</p>
		<p>中国移动通信有限公司 版权所有</p>
	</div>
	<!--底部版权-->
</body>
</html>
