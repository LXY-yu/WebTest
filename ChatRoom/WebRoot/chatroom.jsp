<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script language="javascript">

function set(select){	//自动添加聊天对象
	//if(selectPerson!="${username}"){
	
			form1.to.value=select;
	/*}else{
		alert("请重新选择聊天对象！");
	}*/
}
function send(){	//验证聊天信息并发送
	if(form1.to.value==""){
		alert("请选择聊天对象！");
	}
	if(form1.content.value==""){
		alert("发送信息不可以为空！");form1.content1.focus();
	}
}

</script>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    
    <title>聊天室</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

<script language="javascript" src="JS/AjaxRequest.js"></script>
</head>


  <body>
  <h2 style="text-align:center">聊天内容</h2>
<table width="778" height="276" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
  
    <td width="165" valign="top" bgcolor="#f6fded" id="online" style="padding:5px">在线人员列表
    <br>
    <c:forEach var="me" items="${list}">
    <input type="submit" name="select" value="${me.getUser_name()}" onclick="set('${me.getUser_name()}')"/>
    <br>
    </c:forEach>
   </td>
   <td>
   <table>
<tr>	
	<c:forEach var="msg" items="${Msglist}">
	<tr>
	<td>
    <font color='blue'><strong> ${msg.getFrom()} 
				</strong></font><font color='#CC0000'>${msg.getFace()}
				</font>对<font color="green">[ ${msg.getTo()}]</font>说：
				<font color="${msg.getColor()}">${msg.getContent()}</font>（
				${msg.getSendTime()}）				
   </td>
   </tr>
    </c:forEach>
	
</table>
   
   </td>
	
	</tr>
</table>


<form action="${pageContext.request.contextPath }/sendServlet" name="form1" method="post" >
<table width="778" height="95" border="0" align="center" cellpadding="0" cellspacing="0" bordercolor="#D6D3CE">

  <tr>
  
    <td height="37" align="left"><input name="from" type="hidden" value="<%=request.getParameter("myself")%>">[<%=request.getParameter("myself") %>]对
      <input name="to" type="text" value="" size="35" readonly="readonly">
表情
<select name="face" class="wenbenkuang">
  <option  value="无表情的">无表情的</option>
  <option value="微笑着" selected>微笑着</option>
  <option value="笑呵呵地">笑呵呵地</option>
  <option value="热情的">热情的</option>
  <option value="温柔的">温柔的</option>
  <option value="红着脸">红着脸</option>
  <option value="幸福的">幸福的</option>
  <option value="嘟着嘴">嘟着嘴</option>
  <option value="热泪盈眶的">热泪盈眶的</option>
  <option value="依依不舍的">依依不舍的</option>
  <option value="得意的">得意的</option>
  <option value="神秘兮兮的">神秘兮兮的</option>
  <option value="恶狠狠的">恶狠狠的</option>
  <option value="大声的">大声的</option>
  <option value="生气的">生气的</option>
  <option value="幸灾乐祸的">幸灾乐祸的</option>
  <option value="同情的">同情的</option>
  <option value="遗憾的">遗憾的</option>
  <option value="正义凛然的">正义凛然的</option>
  <option value="严肃的">严肃的</option>
  <option value="慢条斯理的">慢条斯理的</option>
  <option value="无精打采的">无精打采的</option>
</select>
说：
</td>

    <td width="189" align="left">字体颜色：
      <select name="color" size="1" class="wenbenkuang" id="select" style="display:inline-block;">
        <option selected>默认颜色</option>
        <option style="color:#FF0000" value="FF0000">红色热情</option>
        <option style="color:#0000FF" value="0000ff">蓝色开朗</option>
        <option style="color:#ff00ff" value="ff00ff">桃色浪漫</option>
        <option style="color:#009900" value="009900">绿色青春</option>
        <option style="color:#009999" value="009999">青色清爽</option>
        <option style="color:#990099" value="990099">紫色拘谨</option>
        <option style="color:#990000" value="990000">暗夜兴奋</option>
        <option style="color:#000099" value="000099">深蓝忧郁</option>
        <option style="color:#999900" value="999900">卡其制服</option>
        <option style="color:#ff9900" value="ff9900">镏金岁月</option>
        <option style="color:#0099ff" value="0099ff">湖波荡漾</option>
        <option style="color:#9900ff" value="9900ff">发亮蓝紫</option>
        <option style="color:#ff0099" value="ff0099">爱的暗示</option>
        <option style="color:#006600" value="006600">墨绿深沉</option>
        <option style="color:#999999" value="999999">烟雨蒙蒙</option>
      </select>
      </td>
      
  </tr>
  
  <tr>
   <td><input name="content" type="text" size="70" >
   <input name="Submit2" type="submit" class="btn_grey" value="发送" onClick="send()">
   </td>      
  </tr>

</table>
</form>

<form action="${pageContext.request.contextPath }/leaveServlet?User_name=<%=request.getParameter("myself") %>"  method="post">
<table align="right">
<tr>
<td ><input name="button_exit" type="submit" class="btn_grey" value="退出聊天室"></td> 
</tr>
</table>
 </form>
  
  </body>

</html>
