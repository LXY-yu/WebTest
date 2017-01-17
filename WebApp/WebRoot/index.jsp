<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
    <h1>This is my JSP page. </h1>
    <!-- 我是HTML注释，在客户端可见 -->
    <%--我是JSP注释，在客户端不可见 --%>
    <%!
    String s="张三";//申明了一个字符串变量
    int add(int x,int y)//申明了一个函数
    {
    return x+y;
    }
     %>
    <%
    //单行注释  java代码写在这个标签里面，这是JSP脚本
    /*多行注释
    JSP申明：在JSP页面中定义变量或者方法。
             语法：<%! java代码  百分号> 
     JSP表达式：在JSP页面中执行的表达式
                 语法：<%=表达式 百分号>  注意表达式不以分号结束
             */
    out.println("大家好，欢迎大家学习JAVAEE开发");
     %>
     <br>
              你好,<%=s %><br>
    x+y=<%=add(10,5) %><br>
  </body>
</html>
