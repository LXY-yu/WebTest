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
	 * �������ݿ���
	 */
	public SqlSession getSqlSession() throws IOException{
		//ͨ�������ļ���ȡ���ݿ�������Ϣ
		Reader reader=Resources.getResourceAsReader("com/config/Configuration.xml");
		//ͨ��������Ϣ����һ��SqlSessionFactory
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
		//ͨ��sqlSessionFactory��һ�����ݿ�Ự
		SqlSession sqlSession=sqlSessionFactory.openSession();
		return sqlSession;
	}
	 

	private static Connection conn=null; 
	
    public static Connection getConn(){ 
    String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  
    String dbURL = "jdbc:sqlserver://localhost:1433;databasename=Message";  
    String userName = "hcy"; // �û���  
    String userPwd = "08042"; // ���� 
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
