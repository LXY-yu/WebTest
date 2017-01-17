package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;




import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.SongBean;
import com.util.DBUtil;

public class doMain {
	
	
	public void vote(String name){
		Connection conn = null;
        PreparedStatement pt = null;
        ResultSet rs=null ;
        String sql=null;
       
        conn = DBUtil.getConn();
            try { 
            	
            	sql = "select songCount from Song where songName=?";  
                pt = conn.prepareStatement(sql); 
                pt.setString(1, name);
                rs = pt.executeQuery();  
 
                
                if(rs.next()) {  
                    sql = "update Song set songCount=songCount+1 where songName='"+name+"'";  
                    pt = conn.prepareStatement(sql);
                    int  i = pt.executeUpdate();
                   } 
                } catch (Exception e) {  
                	e.printStackTrace();
                	
                	} finally {  
                		DBUtil.closeDB(conn, pt, rs);  
                		}
        }
	
	
	
	
	public ArrayList result(){
		ArrayList al = new ArrayList();
		Connection conn = null;
        PreparedStatement pt = null;
        ResultSet rs = null;
        String sql=null;
        try {  
            conn = DBUtil.getConn();  
            sql = "select * from Song order by songCount desc";  
            pt = conn.prepareStatement(sql); 
            rs = pt.executeQuery();  
  
            while(rs.next()) {  
            	SongBean song=new SongBean();
            	song.setSongName(rs.getString(1));
            	song.setSongCount(rs.getInt(2));
            	al.add(song);
            }
        }catch (SQLException e) {
        	e.printStackTrace();
        } finally {
        	 DBUtil.closeDB(conn, pt, rs);
        }
        return al;
		
		
	}

}
