<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.xt.dao.GgaoDao"%>
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
    <title>已推送页</title>
    
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
					 
		
			
			function downtuisong(){
				var flag=false;
			var x=document.getElementsByName("checkid");
			  for(var j=0;j<x.length;j++){
			  	if(x[j].checked==true){
			  	  flag=true;
			  	}
			  }
			  if(flag){
				if(confirm('您确认取消推送吗?')){
				var f1=document.getElementById('proForm');
					f1.action="GglanManaServlet?flag=downtuisong";
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
			
		</script>
	</head>
	<body class="maintable">
	<%  GgaoDao dao=new GgaoDao();
		ProductDao prodao=new ProductDao();
	  int[] proid=dao.selectggid();
		    List<Product> prolist=new ArrayList<Product>();
		    for(int i=0;i<proid.length;i++){
		    	prolist.add(prodao.selectone(proid[i]));
		    }
		    session.setAttribute("readyprolist",prolist);
	 %>
		<form id="proForm" method="post" action="">
			


			<div class="dclass_container" id="div_rela_table">
				<div class="dclass_container_header">
					<div class="dclass_container_title">
						农产品已推送列表<span><font color="red">&nbsp;&nbsp;${gmsg}</font></span>
					</div>
				</div>
				<div class="dclass_container_content">

					<div class="actions">
						<input  type="button" class="btn1" value="一键取消"
							onclick="downtuisong()" title="取消推送农产品..." />
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
						<c:forEach var="pro" items="${readyprolist}">
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
									<a href="javascript:void(0);" onclick="downtuisong()">取消推送 </a>
									
								</td>
							</tr>
						</c:forEach>
					</table>
					
					


				</div>
			</div>
		</form>
  </body>
</html>
