package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Book;
import com.bean.Reader;
import com.util.DBConn;

public class B_domain {

	//添加图书
	public boolean add(Book b){
		Connection conn = null;  
        PreparedStatement pstat = null;  
        ResultSet rs = null;
        String sql = null;  
  
        try {  
            conn = DBConn.getConn();  
            sql = "insert into TB_Book(bkCode,bkName,bkAuthor,bkPress,bkDatePress,bkISBN,bkCatalog,bkLanguage,bkPages,bkPrice,bkDateIn,bkBrief,bkCover,bkStatus) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";  
            pstat = conn.prepareStatement(sql);  
            pstat.setString(1,b.getBkCode());
            pstat.setString(2, b.getBkName());
            pstat.setString(3, b.getBkAuthor());
            pstat.setString(4, b.getBkPress());
            pstat.setString(5,b.getBkDatePress());
            pstat.setString(6,b.getBkISBN());
            pstat.setString(7, b.getBkCatalog());
            pstat.setInt(8, b.getBkLanguage());
            pstat.setInt(9, b.getBkPages());
            pstat.setFloat(10,b.getBkPrice());
            pstat.setString(11, b.getBkDateIn());
            pstat.setString(12, b.getBkBrief());
            pstat.setString(13, b.getBkCover());
            pstat.setString(14, b.getBkStatus());
       
            pstat.executeUpdate();  
              
            return true;
          
        } catch (Exception e) {  
        	e.printStackTrace();
        	return false;
  
        } finally {  
            DBConn.closeDB(conn, pstat, rs);              
        }  
		
	}
	
	//查找图书
	public List<Book> find(String bkName) {
		Connection conn = null;  
        PreparedStatement pt = null;  
        ResultSet rs = null;  
        Book B =null;
        List<Book> list = new ArrayList<Book>();
  
        try {  
            conn = DBConn.getConn(); 
            String sql = "select * from TB_Book where bkName=?";
            pt = conn.prepareStatement(sql);  
              
            pt.setString(1, bkName);
              
            rs = pt.executeQuery();    
            if(rs.next()){  
                B = new Book();  
               B.setBkAuthor(rs.getString("bkAuthor"));
               B.setBkBrief(rs.getString("bkBrief"));
               B.setBkCatalog(rs.getString("bkCatalog"));
               B.setBkCode(rs.getString("bkCode"));
               B.setBkCover(rs.getString("bkCover"));
               B.setBkDateIn(rs.getString("bkDateIn"));
               B.setBkDatePress(rs.getString("bkDatePress"));
               B.setBkID(rs.getInt("bkID"));
               B.setBkISBN(rs.getString("bkISBN"));
               B.setBkLanguage(rs.getInt("bkLanguage"));
               B.setBkName(rs.getString("bkName"));
               B.setBkPages(rs.getInt("bkPages"));
               B.setBkPress(rs.getString("bkPress"));
               B.setBkPrice(rs.getFloat("bkPrice"));
               B.setBkStatus(rs.getString("bkStatus"));
                list.add(B);                  
            }   
         
        } catch (Exception e) {  
        	e.printStackTrace(); 
  
        } finally {  
            DBConn.closeDB(conn, pt, rs);  
            
        }  
        return list;
	}

	//更新图书信息
	public boolean update(Book B) {
		Connection conn = null;  
        PreparedStatement pstat = null;  
        ResultSet rs = null;
        String sql = null;  
  
        try {  
            conn = DBConn.getConn();  
            sql = "update TB_Book set bkName=?,bkAuthor=?,bkBrief=?,bkCode=?,bkCover=?,bkCatalog=?,bkDateIn=?,bkDatePress=?,bkISBN=?,bkLanguage=?,bkPages=?,bkPress=?,bkPrice=?,bkStatus=? where bkID=?";  
            pstat = conn.prepareStatement(sql);  
      
            pstat.setString(1,B.getBkName());
            pstat.setString(2,B.getBkAuthor());
            pstat.setString(3, B.getBkBrief());
            pstat.setString(4,B.getBkCode());
            pstat.setString(5,B.getBkCover());
            pstat.setString(6,B.getBkCatalog());
            pstat.setString(7,B.getBkDateIn());
            pstat.setString(8,B.getBkDatePress());
            pstat.setString(9,B.getBkISBN());
            pstat.setInt(10,B.getBkLanguage());
            pstat.setInt(11, B.getBkPages());
            pstat.setString(12, B.getBkPress());
            pstat.setFloat(13, B.getBkPrice());
            pstat.setString(14, B.getBkStatus());
            pstat.setInt(15, B.getBkID());
       
            pstat.executeUpdate();  
              
            return true;
          
        } catch (Exception e) {  
        	e.printStackTrace();
        	return false;
  
        } finally {  
            DBConn.closeDB(conn, pstat, rs);              
        }  
		
	}
	
	//删除图书
	public void delete(int bkID) {
		Connection conn = null;  
        PreparedStatement pstat = null;  
        String sql = null;
  
        try {   
        conn = DBConn.getConn();        
        sql = "delete from TB_Book where bkID=?";  
        pstat = conn.prepareStatement(sql);  
        pstat.setInt(1,bkID); 
        pstat.executeUpdate();
        pstat.close();   
        conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
            
	}
	
	
}
