<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.xt.dao.ProductDao"%>
<%@page import="com.xt.pojo.View"%>
<%@page import="com.xt.pojo.Product"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
  <base href="<%=basePath%>">
    <title>广告推送</title>
    
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
					  document.getElementById("a1").href="web/gglanmana/proinput.jsp?page="+icount;
					  }else{
					   document.getElementById("a1").href="web/gglanmana/proinput.jsp?page=1";
					  }
					}
		
			
			
			function tuisong(){
				var flag=false;
			var x=document.getElementsByName("checkid");
			  for(var j=0;j<x.length;j++){
			  	if(x[j].checked==true){
			  	  flag=true;
			  	}
			  }
			  if(flag){
				if(confirm('您确认推送吗?')){
				var f1=document.getElementById('proForm');
					f1.action="GglanManaServlet?flag=tuisong";
					f1.submit();
				}
				}else{
				 alert('未选择产品');
				}
			}
			function selectAll(ischecked){
				var list=document.getElementsByTagName('input');
				for(var i=0;i<list.length;i++){
					if(list[i].type=='checkbox'){
						list[i].checked=ischecked;
					}
				}
			}
			function chaxun(){
				var f2=document.getElementById('proForm');
				f2.action="ProManaServlet?flag=guanggaoselect"
				f2.submit();
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

            View view = new View(3, dao.getrecordCount(), currentPage); 

            //获取参数 

            int fromIndex = view.getFromIndex();//起始位置 

            int pageSize = view.getPageSize();//每页显示的记录数
            List<Product> list=dao.limproduct(fromIndex,pageSize);
            List<String> typelist=dao.selecttype();
		    session.setAttribute("prolist",list);
		    session.setAttribute("typelist",typelist);
		    
	 %>
		<form id="proForm" method="post" action="">
			<div class="dclass_container">
				<div class="dclass_container_header">
					<div class="dclass_container_title">
						农产品查询
					</div>
				</div>
				<div class="dclass_container_content">
					&nbsp;&nbsp;&nbsp;&nbsp;类别:
					<select name="protype" class="inputsearch">
						<option value="">
							==请选择==
						</option>
						<c:forEach var="type" items="${typelist}" >
						<option value="${type}">
							${type}
						</option>
						</c:forEach>
						
					</select>
					&nbsp;&nbsp;&nbsp;&nbsp; 名称:
					<input type="text" name="proname" 
						id="searchValue__merchantName__" class="inputform"
						style="width: 100px;" />
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;状态:
					<select name="prozhuangtai" class="inputsearch">
						<option value="">
							==请选择==
						</option>
						<option value="1">
							上线
						</option>
						<option value="2">
							下线
						</option>
					</select>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="javascript:void(0)" onclick="chaxun()"><img src="images/btn_search.gif" align="absbottom" border="0"
						style="cursor: pointer" /></a>
				</div>
			</div>

			<br style="line-height: 5px;" />

			<div class="dclass_container" id="div_rela_table">
				<div class="dclass_container_header">
					<div class="dclass_container_title">
						农产品推送列表<span><font color="green">&nbsp;&nbsp;注:【最多推送5个商品】</font><font color="red">&nbsp;&nbsp;${gmsg}</font></span>
					</div>
				</div>
				<div class="dclass_container_content">

					<div class="actions">
						<input  type="button" class="btn1" value="一键推送"
							onclick="tuisong()" title="推送农产品..." />
					</div>

					<table class="dclass_data">
						<thead>
							<tr>
								<th width="46" style="text-align: center">
									<input type='checkbox' name='slectAll' 
										onclick='selectAll(this.checked)' />
								</th>
								<th width="133">
									产品类别
								</th>
								<th width="133">
									产品名称
								</th>
								<th width="133">
									产品价格/元
								</th>
								<th width="133">
									图片
								</th>
								<th width="87">
									状态
								</th>
								<th width="263">
									操作
								</th>
							</tr>
						</thead>
						<c:forEach var="pro" items="${prolist}">
							<tr class="dclass_data_even"
								onmouseover="DUtil.appendClass(this,'dclass_data_hover')"	onmouseout="DUtil.removeClass(this,'dclass_data_hover')">
								<td style="text-align: center">
									<input type="checkbox" name="checkid" value="${pro.id}" />
								</td>
								<td>
									${pro.type}
								</td>
								<td>
							${pro.pname}
								</td>
								<td>
									${pro.price}
								</td>
							 
								<td>
									<img src='${pro.img}' width="50" height="50"/>
								</td>
								<c:if test="${pro.zhuangtai==1}">
								<td>
									上线
								</td>
								</c:if>
								<c:if test="${pro.zhuangtai==2}">
								<td>
									下线
								</td>
								</c:if>
								<td>
									<a href="javascript:void(0);" onclick="tuisong()">推送 </a>
									
								</td>
							</tr>
						</c:forEach>
					</table>
					<div class="dclass_pager ">
						<span class="dclass_pager_nav">  <a href="web/gglanmana/proinput.jsp?page=1" >首页</a> </span>
						<%
							if ((view.getCurrentPage() - 1) <= 0) {
						 %>
						<span class="dclass_pager_nav"> <a href="web/gglanmana/proinput.jsp?page=1">上一页</a>  </span>
						<%}else{ %>
						 <span class="dclass_pager_nav"><a href="web/gglanmana/proinput.jsp?page=<%=(view.getCurrentPage() - 1)%>">上一页</a> </span>
						 <%} %>
						 <% 
						 if ((view.getCurrentPage() + 1) > view.getPageCount()) { 
						  %>
						<span class="dclass_pager_nav"> <a href="web/gglanmana/proinput.jsp?page=<%=view.getPageCount() %>">下一页</a>  </span>
						<%}else{ %>
						<span class="dclass_pager_nav"> <a href="web/gglanmana/proinput.jsp?page=<%=view.getCurrentPage()+1 %>">下一页</a>  </span>
						<%} %>
						<span class="dclass_pager_nav"> <a href="web/gglanmana/proinput.jsp?page=<%=view.getPageCount() %>">末页</a>  </span>
						<span class="dclass_pager_sum">共<%=dao.getrecordCount()%>条记录 第<%=view.getCurrentPage()%>页/共<%=view.getPageCount()%>页 
						<input type="text" size="2"  id="icount" onmouseout="ck()"/>
						&nbsp;<a href="" id="a1">转到</a>
						</span>
					</div>


				</div>
			</div>
		</form>
  </body>
</html>
