<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.xt.pojo.Advice"%>
<%@page import="com.xt.dao.ProductDao"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>我的反馈</title>
    
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
		function chakan(adviceid){
			var url="qd/advice/seeadvice.jsp?adviceid="+adviceid;
             var ret = window.showModalDialog(url,"","dialogWidth:300px; dialogHeight:200px; dialogLeft: status:no; directories:yes;scrollbars:yes;Resizable=no;");
              window.location.href="qd/advice/myadvice.jsp";
		}
	</script>
  </head>
  
  <body>
  
  <%
  		ProductDao dao=new ProductDao();
  		String username=session.getAttribute("qduser").toString();
  		List<Advice> advicelist=dao.selectadvice(username);
  		session.setAttribute("advicelist",advicelist);
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
          <th><img src="qdimages/zqf_myWacomMenuDot.png" width="9" height="9" align="absmiddle" />我的反馈</th>
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
      <h2>我的反馈</h2>
    </div>
    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="fal-orderTitle">
    <thead>
      <tr>
        <th class="w330">反馈内容</th>
        <th>反馈时间</th>
        <th>反馈单编号</th>
        <th class="w80">回复状态</th>
     </tr></thead>
     <tbody>
     	<c:forEach items="${advicelist}" var="advice">
         <tr>
          <td class="tc p10 botLine"> <div class="orderProInfo"  align="center"> 
            <p class="proName2" style="padding-left: 50px">${advice.content}</p>
          
            
          </div> </td>
         
           <td  class="tc botLine" >${advice.time}</td>
          <td  class="tc botLine" >${advice.adviceid}</td>
          <td  class="tc botLine" >
          <c:if var="result" test="${empty advice.huifu}">
       		<font size="3" color="red">未回复</font>
          </c:if>
          <c:if test="${!result}">
             <input  type="button" value="已回复" class="mark"  onclick="chakan('${advice.adviceid}')"/>
          </c:if>
          </td>
        </tr>
     </c:forEach>
   </table>

        
  </div>  
  <!--我的商盟右边 end-->
  
  </div>
  </form>
  </body>
</html>
