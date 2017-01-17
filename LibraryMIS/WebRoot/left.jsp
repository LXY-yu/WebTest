<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'left.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/style.css" />

    <script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="js/jquery.easing.1.3.js"></script>

<script type="text/javascript" src="js/script.js"></script>


  </head>
  
  <body>
  <%
     String rdAdminRoles=(String)request.getSession().getAttribute("rdAdminRoles");
     session.setAttribute("rdAdminRoles",rdAdminRoles);
     String rdID=(String)request.getSession().getAttribute("rdID");
     session.setAttribute("rdID",rdID);
     String rdPwd=(String)request.getSession().getAttribute("rdPwd");
     session.setAttribute("rdPwd",rdPwd);
     //System.out.println(rdID);
  %>
    <ul class="container">
		<li class="menu">
			<ul>
				<li class="button"><a href="#" class="green">读者管理 <span></span></a></li>
				<li class="dropdown" style="display:block;">
					<ul>
						<li><a href="R_HandleCard.jsp?op=<%= "handle" %>" target="tfr">办理借书证</a></li>
                        <li><a href="R_HandleCard.jsp?op=<%= "update" %>" target="tfr">借书证变更</a></li>
                        <li><a href="R_HandleCard.jsp?op=<%= "report" %>" target="tfr">借书证挂失</a></li>
                        <li><a href="R_HandleCard.jsp?op=<%= "report"%>" target="tfr">解除挂失</a></li>
                        <li><a href="R_HandleCard.jsp?op=<%= "rehandle"%>" target="tfr">补办借书证</a></li>
                        <li><a href="R_HandleCard.jsp?op=<%= "delete"%>" target="tfr">注销借书证</a></li>
					</ul>
				</li>
			</ul>
		</li>
	
		<li class="menu">
			<ul>
				<li class="button"><a href="#" class="orange">图书管理 <span></span></a></li>          	
				<li class="dropdown">
					<ul>
                        <li><a href="B_AddBook.jsp" target="bfr">新书入库</a></li>
                        <li><a href="B_SearchBook.jsp?op=<%= "update" %>" target="tfr">图书信息维护</a></li>
                        <li><a href="B_SearchBook.jsp?op=<%= "delete" %>" target="tfr">图书变卖与销毁处理</a></li>
					</ul>
				</li>
			</ul>
		</li>
	
		<li class="menu">
			<ul>
				<li class="button"><a href="#" class="blue">借阅管理 <span></span></a></li>
				<li class="dropdown">
					<ul>
						<li><a href="L_Borrow.jsp" target="tfr">借书</a></li>
                        <li><a href="L_reBorrow.jsp?op=<%= "relend" %>" target="tfr">续借</a></li>
                        <li><a href="L_reBorrow.jsp?op=<%= "return" %>" target="tfr">还书</a></li>
					</ul>
				</li>
			</ul>
		</li>
	
		<li class="menu">
			<ul>
				<li class="button"><a href="#" class="red">用户管理<span></span></a></li>
				<li class="dropdown">
					<ul>
                        <li><a href="R_AlterPwd.jsp" target="bfr">密码修改</a></li>
                        <li><a href="R_SearchCard.jsp?op=<%= "set"%>" target="tfr">用户管理</a></li>
					</ul>
				</li>
			</ul>
		</li>
	</ul>
  
  </body>
</html>
