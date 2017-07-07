<%@ page language="java" import="java.util.*,com.xt.dao.*,com.xt.pojo.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户待审核</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/base.css" />
		
        <script language="javascript">
           function userDel(id)
           {
               if(confirm('您确定删除吗？'))
               {
                   var strUrl = "UserManaServlet?flag=del&&id="+id;
				   var ret = window.showModalDialog(strUrl,"","dialogWidth:300px; dialogHeight:300px; dialogLeft: status:no; directories:yes;scrollbars:yes;Resizable=no;");
              
               }
           }
           
           function userShenhe(id)
           {
                   var strUrl = "UserManaServlet?flag=shenhe&&id="+id;
				   var ret = window.showModalDialog(strUrl,"","dialogWidth:300px; dialogHeight:300px; dialogLeft: status:no; directories:yes;scrollbars:yes;Resizable=no;");
           }
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='images2/allbg.gif'>
	<%
		QdUser dao=new QdUser();
		List<User> userlist=dao.selUser();
		session.setAttribute("userlist",userlist);
	 %>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="83" background="images2/tbg.gif">&nbsp;用户管理&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="10%">ID</td>
					<td width="10%">用户名</td>
					<td width="10%">密码</td>
					<td width="10%">姓名</td>
					
					<td width="10%">电话</td>
					<td width="10%">E-mail</td>
										
					<td width="10%">状态</td>
					<td width="10%">操作</td>
		        </tr>	
				<c:forEach var="user" items="${userlist}">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
					    ${user.id}
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    ${user.loginname}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${user.loginpwd}
					</td>
					<td bgcolor="#FFFFFF" align="center">
					   ${user.realname}
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    ${user.tel}
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    ${user.email}
					</td>
					<td bgcolor="#FFFFFF" align="center">
					<c:if test='${user.zhuangtai=="b"}'>
						    审核通过
						    
						</c:if>
						<c:if test='${user.zhuangtai=="a"}'>
						     待审核
						    &nbsp;&nbsp;&nbsp;
						    <a style="color: red" href="web/admin/usermana/userdaishenhe.jsp" onclick="userShenhe(${user.id})">审核</a>
						</c:if>
					</td>
					<td  bgcolor="#FFFFFF" align="center">
						<a href="web/admin/usermana/userdaishenhe.jsp" onclick="userDel(${user.id})" class="pn-loperator">删除</a>
					</td>
				</tr>
				</c:forEach>
             </table>
	</body>
</html>
