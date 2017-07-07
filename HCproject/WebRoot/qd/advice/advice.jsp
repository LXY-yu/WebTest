<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>意见反馈</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link href="qdcss/common.css" rel="stylesheet" type="text/css" />
<link href="qdcss/myWacom.css" rel="stylesheet" type="text/css" />

	<script type="text/javascript">
		function tijiao(){
			var t1=document.getElementById('liuyan').value;
			if(t1.trim()==0){
				alert('留言不能为空！');
			}else{
				var t2=document.getElementById('proForm');
				t2.action="QdProManaServlet?flag=advice";
				t2.submit();
			}
		}
	</script>
  </head>
  
  <body>
  
  <!--头部star-->
<iframe style="border:0; width:100%; height:185px; margin-bottom:10px" frameborder="0" scrolling="no" src="qd/ggao/ggao.jsp"></iframe>
<!--头部end-->
<!--菜单-->
<form id="proForm" method="post" action="">
<div class="menu">
  <ul>
    <li><a href="qd/main.jsp">首页</a></li>
    <li><a href="qd/product/proindex.jsp">农产品大全</a></li>
    <li class="on"><a href="qd/advice/advice.jsp">意见反馈</a></li>
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
  <div class="myWacomRight">
    <div class="sort palce3" >
      <div class="sortLeft"></div>
      <div class="sortRight"></div>
      <h2 class="fb">意见反馈</h2>
    </div>
    <div class="borGray borNoT mb10">
      <table  border="0" cellspacing="0" cellpadding="0" class="memberInput">
  <tr>
    <th>尊敬的：</th>
    <td><font size="5" color="red">${qduser }</font></td>
  </tr>
  <tr>
    <th>您可以加入我们QQ群：</th>
    <td><font size="5" color="red">62555251</font></td>
  </tr>
  
<tr>
    <th>您可以联系卖家：</th>
    <td><font size="5" color="red">13999999999</font></td>
  </tr>
  
  <tr>
    <th>或者给我们留言吧：</th>
    <td><textarea name="advice" id="liuyan" cols="45" rows="5"></textarea></td>
  </tr>
</table>
<p class="cb"></p>
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td class="tc pb30"><a href="javascript:void(0)" onclick="tijiao()"><img src="qdimages/button/zqf_btnApply.png" width="162" height="43" /></a>&nbsp;&nbsp;<a href="qd/main.jsp"><img src="qdimages/button/zqf_btnCancle.png" width="162" height="43" />
          </a><br><c:if test="${advicemsg!=null}">
          			${advicemsg}
          </c:if>
          </td>
        </tr>
      </table>
    </div>
  </div><!--我的商盟右边（会籍服务）  end-->
  
  </div>
  </form>
  </body>
</html>
