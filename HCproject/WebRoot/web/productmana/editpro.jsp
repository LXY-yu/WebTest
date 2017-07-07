<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.xt.pojo.Product"%>
<%@page import="com.xt.dao.ProductDao"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>编辑产品页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script language="javascript">
            function closeOpen()
		    {
		       window.returnValue=false;
		       window.close();
		    }
		    function check1()
		    {
		        if(document.form1.proname.value=="")
		        {
		            alert("请输入产品名称");
		            return false;
		        }
		        if(document.form1.protype.value=="")
		        {
		            alert("请输入产品类型");
		            return false;
		        }
		        document.form1.submit();
		    }
        </script>
	</head>
	 <%
	 int id=Integer.parseInt(request.getParameter("id"));
	 ProductDao dao=new ProductDao();
	 Product pro=dao.selectone(id);
	  %>
	<body>
			<form action="ProManaServlet?flag=update" name="form1" method="post" enctype="multipart/form-data">
				<table width="98%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#CCCCCC">
					<tr>
						<th height="40" colspan="2" bgcolor="#FFFFFF" class="f12b-red" style="font-size: 11px;">
							编辑产品：
						</th>
					</tr>
					<tr>
						<td width="20%" height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
							产品id：
						</td>
						<td width="80%" bgcolor="#FFFFFF">
							&nbsp;
							<input type="text" name="proid" id="userName" value="<%=pro.getId() %>" readonly="readonly" "/>
						</td>
					</tr>
					<tr>
						<td width="20%" height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
							产品类型：
						</td>
						<td width="80%" bgcolor="#FFFFFF">
							&nbsp;
							<input type="text" name="protype" id="userName" value="<%=pro.getType() %>"/>
						</td>
					</tr>
					<tr>
						<td width="20%" height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
							产品名称：
						</td>
						<td width="80%" bgcolor="#FFFFFF">
							&nbsp;
							<input type="text" name="proname" id="userName" value="<%=pro.getPname() %>"/>
						</td>
					</tr>
					<tr>
						<td height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
							产品价格：
						</td>
						<td bgcolor="#FFFFFF">
							&nbsp;
							<input type="text" name="proprice" value="<%=pro.getPrice() %>"/>
						</td>
					</tr>
					<tr>
						<td height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
							状态：
						</td>
						<td bgcolor="#FFFFFF">
							&nbsp;
							<%if(pro.getZhuangtai().equals("1")){
							%>
							上线<input type="radio" name="zhuangtai" value="1" checked>下线<input type="radio" name="zhuangtai" value="2">
							<% }else{%>
							上线<input type="radio" name="zhuangtai" value="1">下线<input type="radio" name="zhuangtai" value="2" checked>
							<% } %>
							
						</td>
					</tr>
					<tr>
						<td height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
							图片：
						</td>
						<td bgcolor="#FFFFFF">
							&nbsp;
							<img src='<%=pro.getImg() %>' width="50" height="50"/>
							<input type="file" name="imge" value="切换图片"/>
						</td>
					</tr>
					
					
					<tr>
						<td height="30" align="right" bgcolor="#F9F9F9">
							&nbsp;
						</td>
						<td bgcolor="#FFFFFF">
							&nbsp;
							<input type="button" value="确定" onclick="check1();"/>
							<input type="button" value="取消" onclick="closeOpen()"/>
						</td>
					</tr>
				</table>
			</form>
  </body>
</html>
