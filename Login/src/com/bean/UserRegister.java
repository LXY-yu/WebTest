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
    String userName = "hcy"; // �û���  
    String userPwd = "08042"; // ����
    String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  
    String dbURL = "jdbc:sqlserver://localhost:1433;databasename=Users";
    //������ݿ����ӡ�  
    public UserRegister()  
    {    

    	try {  
    		  
    	     Class.forName(driverName).newInstance();  
    	 } catch (Exception ex) {  
    	    System.out.println("��������ʧ��");  
    	     ex.printStackTrace();  
    	 }  
    	 try {  
    	     con = DriverManager.getConnection(dbURL, userName, userPwd);  
    	     System.out.println("�ɹ��������ݿ⣡"); 
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
    //���ô�ע����û���Ϣ��  
   public  void setUserBean(UserBean userBean)  
    {  
            this.userBean=userBean;  
    }  
    //����ע��  
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
