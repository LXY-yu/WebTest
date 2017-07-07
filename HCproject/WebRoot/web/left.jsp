<%@ page language="java" import="java.util.*,com.xt.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>左侧菜单栏</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/style.css" rel="stylesheet" type="text/css">
<script>
var lastObj;
function loginout(){
	 if(confirm("确定要退出本系统吗??"))
		   {
			   window.parent.location="qdlogin.jsp";
		   }
}
function showlinks(o) {
obj = document.getElementById(o);
if (obj.style.display=="none") 
  obj.style.display="";
  else 
  obj.style.display="none";
}
</script>
<title>华成农贸平台</title>
</head>

<body>
  <table width="220" height="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
      <td valign="top" class="lefttable"><table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td class="leftloginmsgtalbe"><table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td height="30" class="fontblue"><img src="images/leftloginmsgicon.gif" border="0" align="absbottom"> 欢迎您:<span class="fontred"><strong>${user.username}</strong></span></td>
            </tr>
            <tr>
              <td height="25" class="fontblue">登录时间:<%=Time.getDate() %> </td>
            </tr>
            <tr>
              <td height="1" background="images/leftloginmsgline.gif"></td>
            </tr>
           <tr>
              <td height="28" align="center" valign="bottom"><a href="web/admin/userinfo.jsp" target="mainFrame"><img src="images/leftloginpwbtn.gif" width="56" height="20"></a>
			 <input type="image" src="images/leftloginoutbtn.gif" onclick="loginout()">
			 </td>
            </tr>
            
          </table></td>
        </tr>
      </table></td>
    </tr>
    
    
    <!-- 产品大全管理 -->
    <tr>
      <td height="100%" valign="top" class="lefttable">
		  <table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0" class="leftmenutable">
			<tr>
			  <td valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              
              				 <tr>
                  <td class="leftmenutd" onClick="showlinks('i1');"><img src="images/leftmenuicon.gif" width="12" height="9">&nbsp;&nbsp;产品大全管理</td>
                </tr>
				<tr style="DISPLAY:none;" id="i1">
					<td class="leftsubmenutable">
						<table width="150" border="0" cellpadding="0" cellspacing="0">
						 
						  <tr>
							<td height="20">· <a href="web/productmana/productifo.jsp" class="linkblue" target="mainFrame">农产品信息管理</a></td>
						  </tr>
					      <tr>
							<td height="20">· <a href="web/productmana/publishpro.jsp" class="linkblue" target="mainFrame">农产品信息发布</a></td>
						  </tr>
					    </table>					
					    </td>
				</tr>
				
				
                              				 <tr>
                  <td class="leftmenutd" onClick="showlinks('i7');"><img src="images/leftmenuicon.gif" width="12" height="9">&nbsp;&nbsp;广告栏管理</td>
                </tr>
				<tr style="DISPLAY:none;" id="i7">
					<td class="leftsubmenutable">
						<table width="150" border="0" cellpadding="0" cellspacing="0">
						 
						  <tr>
							<td height="20">· <a href="web/gglanmana/proinput.jsp" class="linkblue" target="mainFrame">农产品推送</a></td>
						  </tr>
					      <tr>
							<td height="20">· <a href="web/gglanmana/readyinput.jsp" class="linkblue" target="mainFrame">已推送产品</a></td>
						  </tr>
						   <tr>
							<td height="20">· <a href="web/gglanmana/middle.jsp" class="linkblue" target="mainFrame">广告预览</a></td>
						  </tr>
					    </table>					</td>
				</tr>
				
				
				 <tr>
                  <td class="leftmenutd" onClick="showlinks('i6');"><img src="images/leftmenuicon.gif" width="12" height="9">&nbsp;&nbsp;用户管理</td>
                </tr>
				<tr style="DISPLAY:none;" id="i6">
					<td class="leftsubmenutable">
						<table width="150" border="0" cellpadding="0" cellspacing="0">
						 
						  <tr>
							<td height="20">· <a href="web/admin/usermana/userdaishenhe.jsp" class="linkblue" target="mainFrame">未审核---用户</a></td>
						  </tr>
						  
						   <tr>
							<td height="20">· <a href="web/admin/usermana/useryishenhe.jsp" class="linkblue" target="mainFrame">已审核---用户</a></td>
						  </tr>
					     
					    </table></td>
				</tr>               
				
				
				
                                             				 <tr>
                  <td class="leftmenutd" onClick="showlinks('i8');"><img src="images/leftmenuicon.gif" width="12" height="9">&nbsp;&nbsp;农业资讯管理</td>
                </tr>
				<tr style="DISPLAY:none;" id="i8">
					<td class="leftsubmenutable">
						<table width="150" border="0" cellpadding="0" cellspacing="0">
						 
						  <tr>
							<td height="20">· <a href="web/citymgr/busiList.html" class="linkblue" target="mainFrame">农产品网上拍卖管理</a></td>
						  </tr>
					     
					    </table></td>
				</tr>               
              				 <tr>
                  <td class="leftmenutd" onClick="showlinks('i2');"><img src="images/leftmenuicon.gif" width="12" height="9">&nbsp;&nbsp;反馈意见管理</td>
                </tr>
				<tr style="DISPLAY:none;"  id="i2">
					<td class="leftsubmenutable">
						<table width="150" border="0" cellpadding="0" cellspacing="0">
						 
					      <tr>
							<td height="20"><a href="web/advicemana/adviceinfo.jsp" class="linkblue" target="mainFrame">查看所有意见</a></td>
						  </tr>
                           
                          
                          
					    </table>					</td>
				</tr>
                
                 <tr>
                  <td class="leftmenutd" onClick="showlinks('i3');"><img src="images/leftmenuicon.gif" width="12" height="9">&nbsp;&nbsp;消息推送管理</td>
                </tr>
                
				<tr style="DISPLAY:none;" id="i3">
					<td class="leftsubmenutable">
						<table width="150" border="0" cellpadding="0" cellspacing="0">
						 <tr>
							<td height="20">· <a href="web/paylog/busiList.html" class="linkblue" target="mainFrame">农产品生长状态更新</a></td>
						  </tr>
						  <tr>
							<td height="20">· <a href="web/codedown/busiList.html" class="linkblue" target="mainFrame">农资领用申请</a></td>
						  </tr>
						  <tr>
							<td height="20">· <a href="web/smsdown/busiList.html" class="linkblue" target="mainFrame">客户种养殖指令管理</a></td>
						  </tr>
					    </table>					
					</td>
				</tr>
                
                <tr>
                  <td class="leftmenutd" onClick="showlinks('i4');"><img src="images/leftmenuicon.gif" width="12" height="9">&nbsp;&nbsp;天气预报管理</td>
                </tr>
				<tr style="DISPLAY:none;"  id="i4">
					<td class="leftsubmenutable">
						<table width="150" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td height="20">· <a href="web/exp/busiList.html" class="linkblue"  target="mainFrame">农产品入库登记</a></td>
							</tr>
							<tr>
								<td height="20">· <a href="web/exp/busiList.html" class="linkblue"  target="mainFrame">农资入库登记</a></td>
							</tr>
							<tr>
								<td height="20">· <a href="web/exp/busiList.html" class="linkblue"  target="mainFrame">农产品出库登记</a></td>
							</tr>
							<tr>
								<td height="20">· <a href="web/exp/busiList.html" class="linkblue"  target="mainFrame">农资出库登记</a></td>
							</tr>
							<tr>
								<td height="20">· <a href="web/exp/jiesuan.html" class="linkblue" target="mainFrame">库存盘存管理</a></td>
							</tr>
						</table>					
					</td>
				</tr>	 
						</table>					
					</td>
				</tr>	 
				 
  </table>
</body>
</html>
