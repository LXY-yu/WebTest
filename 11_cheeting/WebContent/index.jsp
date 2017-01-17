<%@page contentType="text/html" pageEncoding="UTF-8" %>
<html>
<title>
	聊天室
</title>
<link href="CSS/style.css" rel="stylesheet">
<script language="javascript">
function check(){
	if(form1.username.value==""){
		alert("请输入用户名！");form1.username.focus();return false;	
	}else if(form1.username.value=="\'"){
		alert("请不要输入非法字符！");form1.username.focus();return false;
	}
}
</script>
<body>

<form name="form1" method="post" action="Messages?action=loginRoom" onSubmit="return check()">
    用户名：
        <input type="text" name="username" class="login">
        <input name="Submit" type="submit" class="btn_bg" value="进 入">
  		
</form>
</body>
</html>
