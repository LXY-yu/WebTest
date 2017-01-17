<%@ page language="java" import="java.util.*,java.text.*" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'out.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <h1>session内置对象</h1>
    <hr>
    <%
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
    Date d=new Date(session.getCreationTime());
    session.setAttribute("username","admin");
    session.setAttribute("password", "123456");
    session.setAttribute("age",20);
    
    //设置当前session的最大生成期限单位是秒
    //session.setMaxInactiveInterval(10);//10秒,10s过后链接的页面获取不到当前页面的信息，相当于一个新的页面，而此页面相当于退出了
    %>
    Session创建时间<%=sdf.format(d) %><br>  <%--返回的是毫秒数，可以调用上面的方法规范时间，上面的方法需要导入java.text.*包 --%>
    Session的ID编号：<%=session.getId() %><br>
             从Session中获取用户名：<%=session.getAttribute("username") %>;<br>
             <%
             //session.invalidate();//销毁当前回话。
             %>
         <a href="session_page2.jsp" target="_blank">跳转到session_page2.jsp</a>     

  </body>
</html>
