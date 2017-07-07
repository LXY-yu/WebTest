<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.xt.dao.ProductDao"%>
<%@page import="com.xt.pojo.View"%>
<%@page import="com.xt.pojo.Advice"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>反馈意见管理页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
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
					  document.getElementById("a1").href="web/advicemana/adviceinfo.jsp?page="+icount;
					  }else{
					   document.getElementById("a1").href="web/advicemana/adviceinfo?page=1";
					  }
					}			
			function huifu(huifuid){
				var url="web/advicemana/huifu.jsp?adviceid="+huifuid;
             var ret = window.showModalDialog(url,"","dialogWidth:600px; dialogHeight:400px; dialogLeft: status:no; directories:yes;scrollbars:yes;Resizable=no;");
              window.location.href="web/advicemana/adviceinfo.jsp";
			}
			function seehuifu(seehuifuid){
			var url="web/advicemana/seehuifu.jsp?adviceid="+seehuifuid;
             var ret = window.showModalDialog(url,"","dialogWidth:600px; dialogHeight:400px; dialogLeft: status:no; directories:yes;scrollbars:yes;Resizable=no;");
              window.location.href="web/advicemana/adviceinfo.jsp";
			}
		</script>
	</head>
	<body class="maintable">
	<%   ProductDao dao=new ProductDao();
		
		 String pageStr = request.getParameter("page"); 

            int currentPage = 1; 

            if (pageStr != null) { 

                currentPage = Integer.parseInt(pageStr); 

            } 

            View view = new View(3, dao.getrecordCount2(), currentPage); 

            //获取参数 

            int fromIndex = view.getFromIndex();//起始位置 

            int pageSize = view.getPageSize();//每页显示的记录数
            List<Advice> list=dao.limproduct3(fromIndex,pageSize);
		    session.setAttribute("adlist",list);
		    
	 %>
		<form id="proForm" method="post" action="">
			

			<br style="line-height: 5px;" />

			<div class="dclass_container" id="div_rela_table">
				<div class="dclass_container_header">
					<div class="dclass_container_title">
						反馈列表
					</div>
				</div>
				<div class="dclass_container_content">

					<div class="actions">
						<input  type="button" class="btn1" value="已回复"
							onclick="yihiufu()" title="查看已回复..." />
						
						<input  type="button" class="btn1" value="未回复"
							title="查看未回复..." onclick="weihuifu()"/>
					</div>

					<table class="dclass_data">
						<thead>
							<tr>
								
								<th width="133">
									反馈编号
								</th>
								<th width="133">
									用户
								</th>
								<th width="133">
									反馈内容
								</th>
								<th width="133">
									提交时间
								</th>
								<th width="87">
									状态
								</th>
								<th width="263">
									操作
								</th>
							</tr>
						</thead>
						<c:forEach var="advice" items="${adlist}">
							<tr class="dclass_data_even"
								onmouseover="DUtil.appendClass(this,'dclass_data_hover')"	onmouseout="DUtil.removeClass(this,'dclass_data_hover')">
								
								<td>
									${advice.adviceid}
								</td>
								<td>
							${advice.username}
								</td>
								<td>
									${advice.content}
								</td>
							 
								<td>
									${advice.time}
								</td>
								<c:if var="result" test="${empty advice.huifu}">
								<td>
									<font color="red">未回复</font>
								</td>
								</c:if>
								<c:if test="${!result}">
								<td>
									已回复
								</td>
								</c:if>
								<c:if var="result" test="${empty advice.huifu}">
								<td>
									<a href="javascript:void(0);" onclick="huifu('${advice.adviceid}')">回复 </a>
									
								</td>								</c:if>
								<c:if test="${!result}">
								<td>
									<a href="javascript:void(0);" onclick="seehuifu('${advice.adviceid}')">查看回复内容 </a>
									
								</td>
								</c:if>
								
							</tr>
						</c:forEach>
					</table>
					<div class="dclass_pager ">
						<span class="dclass_pager_nav">  <a href="web/advicemana/adviceinfo.jsp?page=1" >首页</a> </span>
						<%
							if ((view.getCurrentPage() - 1) <= 0) {
						 %>
						<span class="dclass_pager_nav"> <a href="web/advicemana/adviceinfo.jsp?page=1">上一页</a>  </span>
						<%}else{ %>
						 <span class="dclass_pager_nav"><a href="web/advicemana/adviceinfo.jsp?page=<%=(view.getCurrentPage() - 1)%>">上一页</a> </span>
						 <%} %>
						 <% 
						 if ((view.getCurrentPage() + 1) > view.getPageCount()) { 
						  %>
						<span class="dclass_pager_nav"> <a href="web/advicemana/adviceinfo.jsp?page=<%=view.getPageCount() %>">下一页</a>  </span>
						<%}else{ %>
						<span class="dclass_pager_nav"> <a href="web/advicemana/adviceinfo.jsp?page=<%=view.getCurrentPage()+1 %>">下一页</a>  </span>
						<%} %>
						<span class="dclass_pager_nav"> <a href="web/advicemana/adviceinfo.jsp?page=<%=view.getPageCount() %>">末页</a>  </span>
						<span class="dclass_pager_sum">共<%=view.getRecordCount()%>条记录 第<%=view.getCurrentPage()%>页/共<%=view.getPageCount()%>页 
						<input type="text" size="2"  id="icount" onmouseout="ck()"/>
						&nbsp;<a href="" id="a1">转到</a>
						</span>
					</div>


				</div>
			</div>
		</form>
  </body>
</html>
