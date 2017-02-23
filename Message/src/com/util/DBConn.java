package com.util;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException; 
import java.sql.Statement;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBConn {
	/*
	 * 访问数据库类
	 */
	public SqlSession getSqlSession() throws IOException{
		//通过配置文件获取数据库连接信息
		Reader reader=Resources.getResourceAsReader("com/config/Configuration.xml");
		//通过配置信息构建一个SqlSessionFactory
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
		//通过sqlSessionFactory打开一个数据库会话
		SqlSession sqlSession=sqlSessionFactory.openSession();
		return sqlSession;
	}
	 

	private static Connection conn=null; 
	
    public static Connection getConn(){ 
    String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  
    String dbURL = "jdbc:sqlserver://localhost:1433;databasename=Message";  
    String userName = "hcy"; // 用户名  
    String userPwd = "08042"; // 密码 
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
    
    public static void realse(ResultSet rs, PreparedStatement pstmt) {  
        if(rs!=null){  
            try {  
                rs.close();  
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
