package com.DBUtil;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException; 
import java.sql.Statement;

public class DBConn {
	 

	private static Connection conn=null; 
	
    public static Connection getConn(){ 
    String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  
    String dbURL = "jdbc:sqlserver://localhost:1433;databasename=ChatRoom";  
    String userName = "hcy"; // ”√ªß√˚  
    String userPwd = "08042"; // √‹¬Î 
        	try {  
        	  	  
                Class.forName(driverName).newInstance();  
            } catch (Exception ex) {    
                ex.printStackTrace();  
            }  
            try { 
            conn = DriverManager.getConnection(dbURL, userName, userPwd);   
                } catch (SQLException e) {  
                    // TODO Auto-generated catch block  
                    e.printStackTrace();   
            }  
         
             
        return conn;  
          
}
    
    public static void closeDB(Connection con,Statement st,ResultSet rs){  
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
    
    public static void realse(Connection con, PreparedStatement pstmt) {  
        if(con!=null){  
            try {  
                con.close();  
            } catch (SQLException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }  
        }  
        if(pstmt!=null){  
            try {  
                pstmt.close();  
            } catch (SQLException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }  
        }  
    }

}
