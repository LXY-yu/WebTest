<%@ page language="java" import="java.util.*,java.sql.*" contentType="text/html; charset=utf-8"%>
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
    <%
    String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  
    String dbURL = "jdbc:sqlserver://localhost:1433;databasename=Users";  
    String userName = "hcy"; // 用户名  
    String userPwd = "08042"; // 密码  

    Connection dbConn = null;  
    try {  

        Class.forName(driverName).newInstance();  
    } catch (Exception ex) {  
        out.println("驱动加载失败");  
        ex.printStackTrace();  
    }  
    try {  
        dbConn = DriverManager.getConnection(dbURL, userName, userPwd);  
        out.println("成功连接数据库！");  
    } catch (Exception e) {  
        e.printStackTrace();  
    } finally {  

        try {  
            if (dbConn != null)  
                dbConn.close();  
        } catch (SQLException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
    }  
    %>
  </body>
</html>
