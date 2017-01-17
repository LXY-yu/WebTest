package com.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserRegister {
	private UserBean userBean;  
    private Connection con; 
    String userName = "hcy"; // 用户名  
    String userPwd = "08042"; // 密码
    String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  
    String dbURL = "jdbc:sqlserver://localhost:1433;databasename=Users";
    //获得数据库连接。  
    public UserRegister()  
    {    

    	try {  
    		  
    	     Class.forName(driverName).newInstance();  
    	 } catch (Exception ex) {  
    	    System.out.println("驱动加载失败");  
    	     ex.printStackTrace();  
    	 }  
    	 try {  
    	     con = DriverManager.getConnection(dbURL, userName, userPwd);  
    	     System.out.println("成功连接数据库！"); 
    	 }catch (Exception e) {  
    	     e.printStackTrace();  
    	 } finally {  

    	     try {  
    	         if (con != null)  
    	             con.close();  
    	     } catch (SQLException e) {  
    	         // TODO Auto-generated catch block  
    	         e.printStackTrace();  
    	     }  
    	 }  

    	   
    }  
    //设置待注册的用户信息。  
   public  void setUserBean(UserBean userBean)  
    {  
            this.userBean=userBean;  
    }  
    //进行注册  
    public void regist() throws Exception  {
            String reg="insert into library (userid,password)  values(?,?)";
    
            try  
            {  
                    PreparedStatement pstmt=con.prepareStatement(reg);  
                    pstmt.setString(1,userBean.getUserId());  
                    pstmt.setString(2,userBean.getPassword());  
                    pstmt.executeUpdate();  
            }  
            catch(Exception e)  
            {  
                    e.printStackTrace();  
                    throw e;  
            }  


    } 

}
