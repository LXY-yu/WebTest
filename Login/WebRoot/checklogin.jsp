<%@ page language="java" import="java.util.*,java.sql.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<% 
  request.setCharacterEncoding("utf-8");
request.setCharacterEncoding("utf-8");
  String userid1=request.getParameter("userid");  
  String password1=request.getParameter("password");  
  
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
     Statement stmt = dbConn.createStatement() ; 
     String sql="select * from library where userid='"+userid1+"';";  
  ResultSet rs=stmt.executeQuery(sql);  
      if(rs.next())  
      {
    	  String userid=new String(rs.getString("userid").getBytes("gbk"));
    	   
    	  String password=new String(rs.getString("password").getBytes("gbk"));
    	  
    	  if(password.equals(password1))  
    	  {
    	  session.setAttribute("userid1",userid1);
          out.println("成功");
          response.sendRedirect("success.jsp?sid="+userid);  
          }  
    	  else
      {
    		  out.println("用户名或密码错误，请从新输入");
    		  response.sendRedirect("login.jsp");
    	  }
    	  
    }  
    else  
    {
    	response.sendRedirect("login.jsp"); 
    } 
      
     rs.close();
     stmt.close();
     dbConn.close();
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
