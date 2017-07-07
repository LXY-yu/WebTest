<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.xt.dao.ProductDao"%>
<%@page import="com.xt.pojo.View"%>
<%@page import="com.xt.pojo.Product"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>农产品大全</title>
    
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
					 function  ck(){
					var icount=document.getElementById('icount').value;
					if(icount.trim()!=0){
					  document.getElementById("a1").href="qd/user/mycollection.jsp?page="+icount;
					  }else{
					   document.getElementById("a1").href="qd/user/mycollection.jsp?page=1";
					  }
					}
		
			
			
			function goumai(proid){
				var f3=document.getElementById('proForm');
				f3.action="QdProManaServlet?flag=goumai&&id="+proid;
				f3.submit();
			}
			
			function yichu(proid){
				var f5=document.getElementById('proForm');
				f5.action="QdProManaServlet?flag=yichu&&id="+proid;
				f5.submit();
				
			}
			function collect(proid){
				alert('收藏成功！');
				var f4=document.getElementById('proForm');
				f4.action="QdProManaServlet?flag=collect&&id="+proid;
				f4.submit();
				
			}
		</script>
  </head>
  
  <body>
  <%   ProductDao dao=new ProductDao();
		String username=request.getSession().getAttribute("qduser").toString();
		 String pageStr = request.getParameter("page"); 

            int currentPage = 1; 

            if (pageStr != null) { 

                currentPage = Integer.parseInt(pageStr); 

            } 

            View view = new View(3,dao.getrecordCount3(username), currentPage); 

            //获取参数 

            int fromIndex = view.getFromIndex();//起始位置 

            int pageSize = view.getPageSize();//每页显示的记录数
            List<String> colist=dao.limproduct4(fromIndex,pageSize,username);
		    session.setAttribute("colist",colist);
		    
	 %>
  <!--头部star-->
<iframe style="border:0; width:100%; height:185px; margin-bottom:10px" frameborder="0" scrolling="no" src="qd/ggao/ggao.jsp"></iframe>
<!--头部end-->
<!--菜单-->
<form id="proForm" method="post" action="">
<div class="menu">
  <ul>
    <li><a href="qd/main.jsp">首页</a></li>
    <li class="on"><a href="qd/product/proindex.jsp">农产品大全</a></li>
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
          <th><img src="qdimages/zqf_myWacomMenuDot.png" width="9" height="9" align="absmiddle" />我的收藏</th>
        </tr>
      </table>

  </div><!--我的商盟左边 end-->
  
  <!--我的商盟右边-->
  <div class="myWacomRight">
    <div class="sort palce3" >
    <!-- 搜索栏begin -->
      <div class="dclass_container">
				<div class="dclass_container_header">
					<div class="dclass_container_title">
						我的收藏&nbsp;&nbsp;&nbsp;&nbsp;
						
					</div>
				</div>
				
			</div>
			<!-- 搜索栏end -->
    </div>
    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="fal-orderTitle">
    <thead>
      <tr>
        <th class="w330">产品名称</th>
         <th>产品类别</th>
        <th>产品价格/元</th>
        <th>产品编号</th>
        <th class="w80">操作</th>
     </tr></thead>
     <tbody>
     <%
     		Product pro=new Product();
     		for(int i=0;i<colist.size();i++){
     			pro=dao.selectone(Integer.parseInt(colist.get(i)));
     			%>
     			<tr>
          <td class="tc p10 botLine"> <div class="orderProInfo"> <a href="#" class="proImg"><img src="<%=pro.getImg() %>" /></a>
            <p class="proName2" style="padding-top: 20px">&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" ><%=pro.getPname() %></a></p>
          
            
          </div> </td>
         
          <td class="tc botLine"><font size="2px"><%=pro.getType() %></font></td>
           <td  class="tc botLine" ><%=pro.getPrice() %></td>
          <td  class="tc botLine" ><%=pro.getId() %></td>
          <td  class="tc botLine" >
          <input  type="button" value="购买" class="mark" onclick="goumai('<%=pro.getId() %>')" />
          <br><input  type="button" value="移除" class="mark" onclick="yichu('<%=pro.getId() %>')" />
          
          </td>
        </tr>
        
     	<% 		
     		}
      %>
              
   </table>

       <!--翻页begin-->
       <div class="dclass_pager ">
						<span class="dclass_pager_nav">  <a href="qd/user/mycollection.jsp?page=1" ><font size="2px">首页</font></a> </span>
						<%
							if ((view.getCurrentPage() - 1) <= 0) {
						 %>
						<span class="dclass_pager_nav"> <a href="qd/user/mycollection.jsp?page=1"><font size="2px">上一页</font></a>  </span>
						<%}else{ %>
						 <span class="dclass_pager_nav"><a href="qd/user/mycollection.jsp?page=<%=(view.getCurrentPage() - 1)%>"><font size="2px">上一页</font></a> </span>
						 <%} %>
						 <% 
						 if ((view.getCurrentPage() + 1) > view.getPageCount()) { 
						  %>
						<span class="dclass_pager_nav"> <a href="qd/user/mycollection.jsp?page=<%=view.getPageCount() %>"><font size="2px">下一页</font></a>  </span>
						<%}else{ %>
						<span class="dclass_pager_nav"> <a href="qd/user/mycollection.jsp?page=<%=view.getCurrentPage()+1 %>"><font size="2px">下一页</font></a>  </span>
						<%} %>
						<span class="dclass_pager_nav"> <a href="qd/user/mycollection.jsp?page=<%=view.getPageCount() %>"><font size="2px">末页</font></a>  </span>
						<span class="dclass_pager_sum"><font size="2px">共<%=view.getRecordCount()%>条记录 第<%=view.getCurrentPage()%>页/共<%=view.getPageCount()%>页 </font>
						<input type="text" size="2"  id="icount" onmouseout="ck()"/>
						&nbsp;<a href="" id="a1"><font size="2px">转到</font></a>
						</span>
					</div>
      <!--翻页 end-->    
  </div>  
  <!--我的商盟右边 end-->
</div>
</form>


<iframe style="border:0; width:100%; height:255px;" frameborder="0" scrolling="no" src="qd/foot.jsp"></iframe>
  </body>
</html>
