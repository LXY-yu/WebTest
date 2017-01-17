package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bean.Reader;
import com.util.DBConn;

public class R_domain {
	
	//查找读者(借书证)
	public List<Reader> find(String rdName,int rdType,String rdDept) {
		Connection conn = null;  
        PreparedStatement pt = null;  
        ResultSet rs = null;  
        Reader R =null;
        List<Reader> list = new ArrayList<Reader>();
  
        try {  
            conn = DBConn.getConn(); 
            String sql = "select * from TB_Reader where rdName=? and rdType=? and rdDept=?";
            pt = conn.prepareStatement(sql);  
              
            pt.setString(1, rdName);
            pt.setInt(2, rdType);
            pt.setString(3, rdDept);
              
            rs = pt.executeQuery();    
            if(rs.next()){  
                R = new Reader();  
                R.setRdAdminRoles(rs.getInt("rdAdminRoles"));
                R.setRdBorrowQty(rs.getInt("rdBorrowQty"));
                R.setRdDateReg(rs.getString("rdDateReg"));
                R.setRdDept(rs.getString("rdDept"));
                R.setRdEmail(rs.getString("rdEmail"));
                R.setRdID(rs.getString("rdID"));
                R.setRdName(rs.getString("rdName"));
                R.setRdPhone(rs.getString("rdPhone"));
                R.setRdPhoto(rs.getString("rdPhoto"));
                R.setRdPwd(rs.getString("rdPwd"));
                R.setRdSex(rs.getString("rdSex"));
                R.setRdStatus(rs.getString("rdStatus"));
                R.setRdType(rs.getInt("rdType"));
                list.add(R);                  
            }   
         
        } catch (Exception e) {  
        	e.printStackTrace(); 
  
        } finally {  
            DBConn.closeDB(conn, pt, rs);  
            
        }  
        return list;
	}

	//更新借书证信息
	public boolean update(Reader R) {
		Connection conn = null;  
        PreparedStatement pstat = null;  
        ResultSet rs = null;
        String sql = null;  
  
        try {  
            conn = DBConn.getConn();  
            sql = "update TB_Reader set rdName=?,rdSex=?,rdType=?,rdDept=?,rdPhone=?,rdEmail=?,rdDateReg=?,rdPhoto=?,rdStatus=?,rdBorrowQty=?,rdPwd=?,rdAdminRoles=? where rdID=?";  
            pstat = conn.prepareStatement(sql);  
      
            pstat.setString(1, R.getRdName());
            pstat.setString(2, R.getRdSex());
            pstat.setInt(3, R.getRdType());
            pstat.setString(4,R.getRdDept());
            pstat.setString(5, R.getRdPhone());
            pstat.setString(6, R.getRdEmail());
            pstat.setString(7, R.getRdDateReg());
            pstat.setString(8, R.getRdPhoto());
            pstat.setString(9, R.getRdStatus());
            pstat.setInt(10, R.getRdBorrowQty());
            pstat.setString(11, R.getRdPwd());
            pstat.setInt(12, R.getRdAdminRoles());
            pstat.setString(13, R.getRdID());
       
            pstat.executeUpdate();  
              
            return true;
          
        } catch (Exception e) {  
        	e.printStackTrace();
        	return false;
  
        } finally {  
            DBConn.closeDB(conn, pstat, rs);              
        }  
		
	}
	
	//添加借书证
	public boolean add(Reader R){
		Connection conn = null;  
        PreparedStatement pstat = null;  
        ResultSet rs = null;
        String sql = null;  
  
        try {  
            conn = DBConn.getConn();  
            sql = "insert into TB_Reader(rdID,rdName,rdSex,rdType,rdDept,rdPhone,rdEmail,rdDateReg,rdPhoto,rdStatus,rdBorrowQty,rdPwd,rdAdminRoles) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";  
            pstat = conn.prepareStatement(sql);  
            pstat.setString(1,R.getRdID());
            pstat.setString(2, R.getRdName());
            pstat.setString(3, R.getRdSex());
            pstat.setInt(4, R.getRdType());
            pstat.setString(5,R.getRdDept());
            pstat.setString(6, R.getRdPhone());
            pstat.setString(7, R.getRdEmail());
            pstat.setString(8, R.getRdDateReg());
            pstat.setString(9, R.getRdPhoto());
            pstat.setString(10, R.getRdStatus());
            pstat.setInt(11, R.getRdBorrowQty());
            pstat.setString(12, R.getRdPwd());
            pstat.setInt(13, R.getRdAdminRoles());
       
            pstat.executeUpdate();  
              
            return true;
          
        } catch (Exception e) {  
        	e.printStackTrace();
        	return false;
  
        } finally {  
            DBConn.closeDB(conn, pstat, rs);              
        }  
		
	}
	
	//注销借书证
	public void delete(String rdID) {
		Connection conn = null;  
        PreparedStatement pstat = null;  
        String sql = null;
  
        try {   
        conn = DBConn.getConn(); 
		sql = "delete from TB_Reader where rdID=?";  
        pstat = conn.prepareStatement(sql);  
        pstat.setString(1,rdID); 
        pstat.executeUpdate(); 
        pstat.close();   
        conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
            
	}
	
	//登录验证
	public  boolean checkReader(String rdID1,String rdPwd1 ){
		Connection conn = null;  
        Statement stmt=null;
        ResultSet rs=null;
		 try {  
			 conn = DBConn.getConn();  
		     stmt = conn.createStatement() ; 
		     String sql="select * from TB_Reader where rdID='"+rdID1+"';";  
		     rs=stmt.executeQuery(sql);  
		      if(rs.next())  
		     {
    	    	  String rdID=new String(rs.getString("rdID"));		    	   
		    	  String rdPwd=new String(rs.getString("rdPwd"));
		    	  String rdStatus=rs.getString("rdStatus");
		    	  if(rdPwd.equals(rdPwd1))  
		    	  {
		    		  if(rdStatus.equals("有效")){
		    		  return true;
		    		  }
		    		  else return false;
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

	//查找权限
	public int checkRdAdminRoles(String rdID1){
		Connection conn = null;  
        Statement stmt=null;
        ResultSet rs=null;
        int rdAdminRoles = 0;
		 try {  
			 conn = DBConn.getConn();  
		     stmt = conn.createStatement() ; 
		     String sql="select * from TB_Reader where rdID='"+rdID1+"';";  
		     rs=stmt.executeQuery(sql);  
		      if(rs.next())  
		     {
		    	  rdAdminRoles=Integer.parseInt(rs.getString("rdAdminRoles"));
		    	  
		    }  		     
		 } catch (Exception e) {  
		     e.printStackTrace();  
		 } finally {  
		     DBConn.closeDB(conn, stmt, rs);
		 }
		 return rdAdminRoles;
	}
	
	//修改密码
	public  boolean alterPwd(String rdID,String rdPwd ){
		Connection conn = null;  
        PreparedStatement pstat = null;
        ResultSet rs=null;
		 try {  
			 conn = DBConn.getConn();  
		     String sql="update TB_Reader set rdPwd=? where rdID=?";
		     pstat = conn.prepareStatement(sql);  
		     pstat.setString(1, rdPwd);
		     pstat.setString(2, rdID);
		     pstat.executeUpdate();
		     return true;		       		     
		 } catch (Exception e) {  
		     e.printStackTrace();  
		 } finally {  
		     DBConn.closeDB(conn, pstat, rs);
		 }
		return false;  
	}
	
}
