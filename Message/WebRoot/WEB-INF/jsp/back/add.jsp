<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta http-equiv="X-UA-Compatible"content="IE=9; IE=8; IE=7; IE=EDGE" />
		<title>内容修改页面</title>
		<link href="<%=basePath %>resources/css/all.css" rel="stylesheet" type="text/css" />
		<script src="<%=basePath %>resources/js/jquery-1.8.0.min.js"></script>
		<script src="<%=basePath %>resources/js/list.js"></script>
	</head>
	<body style="background: #e1e9eb;">
		<form action="${pageContext.request.contextPath }/AddServlet" id="mainForm" method="get">
			<div class="right">
				<div class="current">当前位置：<a href="javascript:void(0)" style="color:#6E6E6E;">内容管理</a> &gt;<a href="${pageContext.request.contextPath }/ListServlet" style="color:#6E6E6E;"> 内容列表</a> &gt;<a style="color:#6E6E6E;">内容添加</a></div>
				<div class="rightCont">									
					<div class="zixun fix">
						<table class="tab2" width="100%">
							<tbody>
								<tr>
								    <th>指令名称</th>
								    <th>描述</th>
								    <th>指令回复</th>
								    <th>操作</th>
								</tr>
																
								<tr>									
									<td><input name="commandT" type="text" value="${command }" ></td>
									<td><input name="discriptionT" type="text" value="${discription }"></td>
									<td><input name="content" type="text"></td>
									<td>
									<input type="hidden" name="id" value="${id }"/>
									<input type="submit" value="保存">
									</td>
								</tr>
									
							</tbody>
						</table>
					</div>
				</div>
			</div>
	    </form>
	</body>
</html>