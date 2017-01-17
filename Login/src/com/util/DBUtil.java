package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bean.SongBean;

public class DBUtil {

	private static Connection conn=null;
	private PreparedStatement ps = null;
	private ResultSet rs;
	
    public static Connection getConn(){ 
    String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  
    String dbURL = "jdbc:sqlserver://localhost:1433;databasename=Users";  
    String userName = "hcy"; // 用户名  
    String userPwd = "08042"; // 密码 
        	try {  
        	  	  
                Class.forName(driverName).newInstance();  
            } catch (Exception ex) {    
                ex.printStackTrace();  
            }  
            try { 
            conn = DriverManager.getConnection(dbURL, userName, userPwd);
            //System.out.println("成功连接数据库");
                } catch (SQLException e) {  
                    // TODO Auto-generated catch block  
                    e.printStackTrace();   
            }  
         
             
        return conn;  
          
}
    
    public static void closeDB(Connection con,PreparedStatement st,ResultSet rs){  
        if(rs!=null){  
            try {  
                rs.close();  
            } catch (SQLException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }  
        }  
        if(st!=null){  
            try {  
                st.close();  
            } catch (SQLException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }  
        }  
        if(con!=null){  
            try {  
                con.close();  
            } catch (SQLException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }  
        }  
          
    }  
    


}
