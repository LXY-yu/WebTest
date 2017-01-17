package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.DBUtil.DBConn;
import com.bean.Message;
import com.bean.User;



public class addUser {
	
	public static void add(User u) {
		 //boolean flag = false;  
	        Connection conn = null;  
	        PreparedStatement pst = null;  
	          
	        try {                
	            conn = DBConn.getConn();  
	            String sql = "insert into UserInfo (User_name,password) values (?,?)";  
	            pst = conn.prepareStatement(sql);  
	            pst.setString(1, u.getUser_name());  
	            pst.setString(2, u.getPassword());  	            	              
	            pst.executeUpdate();

	        } catch (Exception e) {  
	            // TODO: handle exception  
	            e.printStackTrace();  
	        }finally{  
	            DBConn.realse(conn, pst);  
	        }  
	          
		
	}
	
	public static boolean checkUser(User u){
		Connection conn = null;  
        Statement stmt=null;
        ResultSet rs=null;
        String User_name1=u.getUser_name();
        String password1=u.getPassword();
		 try {  
			 conn = DBConn.getConn();  
		     stmt = conn.createStatement() ; 
		     String sql="select * from UserInfo where User_name='"+User_name1+"';";  
		     rs=stmt.executeQuery(sql);  
		      if(rs.next())  
		     {
    	    	  String User_name=new String(rs.getString("User_name").getBytes("gbk"));		    	   
		    	  String password=new String(rs.getString("password").getBytes("gbk"));		    	  
		    	  if(password.equals(password1))  
		    	  {
		    		  return true;
		          }  
		    	  else
		    	  {
		    		  return false;
		    	  }
		    	  
		    }  
		    else  
		    {
		    	return false; 
		    } 		     
		 } catch (Exception e) {  
		     e.printStackTrace();  
		 } finally {  
		     DBConn.closeDB(conn, stmt, rs);
		 }
		return false;  
	}
	
	public static void addOnlineUser(User u,String loginTime){
		 Connection conn = null;  
	        PreparedStatement pst = null;  
	          
	        try {                
	            conn = DBConn.getConn();  
	            String sql = "insert into OnlineUser (User_name,Login_time) values (?,?)";  
	            pst = conn.prepareStatement(sql);  
	            pst.setString(1, u.getUser_name());  
	            pst.setString(2, loginTime);  	            	              
	            pst.executeUpdate();

	        } catch (Exception e) {  
	            // TODO: handle exception  
	            e.printStackTrace();  
	        }finally{  
	            DBConn.realse(conn, pst);  
	        }  
	          
		
	}
	
	public static List<User> showOnlineUser(){
		Connection conn = null;  
        Statement stmt=null;
        ResultSet rs=null;
        List<User> list = new ArrayList<User>();
        
        
        
		 try {  
			 conn = DBConn.getConn();  
		     stmt = conn.createStatement() ; 
		     String sql="select top 500 * from OnlineUser";  
		     rs=stmt.executeQuery(sql);  
		      while(rs.next())  
		      {
		    	  User u=new User();
		    	  //String User_name=new String(rs.getString("User_name"));		    	   
		    	 // String Login_time=new String(rs.getString("Login_time"));
		    	  u.setUser_name(rs.getString("User_name"));
		    	  u.setLogin_time(rs.getString("Login_time"));
		    	  list.add(u);
		    }  
		    	     
		 } catch (Exception e) {  
		     e.printStackTrace();  
		 } finally {  
		     DBConn.closeDB(conn, stmt, rs);
		 }
		return list;
		  
	}
	
	public static boolean checkOnlineUser(User u){
		Connection conn = null;  
        Statement stmt=null;
        ResultSet rs=null;
        String User_name1=u.getUser_name();
        
		 try {  
			 conn = DBConn.getConn();  
		     stmt = conn.createStatement() ; 
		     String sql="select * from OnlineUser where User_name='"+User_name1+"';";  
		     rs=stmt.executeQuery(sql);  
		      if(rs.next())  
		     {
    	    	  return false;
		    	  
		    }  
		   		     
		 } catch (Exception e) {  
		     e.printStackTrace();  
		 } finally {  
		     DBConn.closeDB(conn, stmt, rs);
		 }
		return true;  
	}
		
	public static void addMsg(Message msg){
		Connection conn = null;  
        PreparedStatement pst = null;  
          
        try {                
            conn = DBConn.getConn();  
            String sql = "insert into msginfo (msgfrom,msgto,color,msgcontent,sendTime) values (?,?,?,?,?)";  
            pst = conn.prepareStatement(sql);  
            pst.setString(1,msg.getFrom() );  
            pst.setString(2, msg.getTo());
            pst.setString(3, msg.getColor());
            pst.setString(4, msg.getContent());
            pst.setString(5, msg.getSendTime());
            pst.executeUpdate();

        } catch (Exception e) {  
            // TODO: handle exception  
            e.printStackTrace();  
        }finally{  
            DBConn.realse(conn, pst);  
        }  
	}
	

	public static List<Message> showMsg(){
		Connection conn = null;  
        Statement stmt=null;
        ResultSet rs=null;
        List<Message> list = new ArrayList<Message>();
        
        
        
		 try {  
			 conn = DBConn.getConn();  
		     stmt = conn.createStatement() ; 
		     String sql="select top 500 * from msginfo";  
		     rs=stmt.executeQuery(sql);  
		      while(rs.next())  
		      {
		    	  Message msg=new Message();
		    	  
		    	  msg.setFrom(rs.getString("msgfrom"));
		    	  msg.setTo(rs.getString("msgto"));
		    	  msg.setColor(rs.getString("color"));
		    	  msg.setContent(rs.getString("msgcontent"));
		    	  msg.setSendTime(rs.getString("sendTime"));
		    	  list.add(msg);
		    }  
		    	     
		 } catch (Exception e) {  
		     e.printStackTrace();  
		 } finally {  
		     DBConn.closeDB(conn, stmt, rs);
		 }
		return list;
		  
	}
	
	public static void delete(String User_name) {
		Connection conn = null;  
        PreparedStatement pstat = null;  
        String sql = null;
  
        try {   
        conn = DBConn.getConn(); 
		sql = "delete from OnlineUser where User_name=?";  
        pstat = conn.prepareStatement(sql);  
        pstat.setString(1,User_name); 
        pstat.executeUpdate(); 
        pstat.close();   
        conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
            
	}
}
