package com.dao;

import java.util.List;
import java.beans.Statement;
import java.sql.Connection;  
import java.sql.DriverManager;
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;
import java.util.ArrayList;  
  
  











import com.domain.Book;  
import com.domain.CartItem;
import com.service.BusinessServiceImpl;
import com.utils.DBConn;

public class BookDaoImpl implements BookDao {

	@Override
	public List<Book> getAll() {
		  
		Connection conn = null;
        PreparedStatement pt = null;  
        ResultSet rs = null;  
        List<Book> list = new ArrayList<Book>(); 
        try {  
            conn = DBConn.getConn();  
            String sql = "select NO,����,���,�۸�  from show";  
            pt = conn.prepareStatement(sql);  
            rs = pt.executeQuery();  
  
             
  
            while (rs.next()) {  
                Book b = new Book();  
                b.setNO(rs.getString("NO"));  
                b.setName(rs.getString("����"));   
                b.setPrice(rs.getDouble("�۸�"));  
                b.setInfo(rs.getString("���"));  
  
                list.add(b);  
  
            } 
                  
  
        } catch (Exception e) {  
        	 e.printStackTrace();  
  
        } finally {  
            DBConn.closeDB(conn, pt, rs);  
        }
       
		return list;
	}

	@Override
	public Book find(String NO) {
		Connection conn = null;  
        PreparedStatement pt = null;  
        ResultSet rs = null;  
        Book b =null;
  
        try {  
            conn = DBConn.getConn(); 
            String sql = "select * from show where NO=?";  
            pt = conn.prepareStatement(sql);  
              
            pt.setString(1, NO);  
              
            rs = pt.executeQuery();  
            //Book b = null;  
            if(rs.next()){  
                b = new Book();  
                b.setNO(rs.getString("NO"));  
                b.setName(rs.getString("����"));   
                b.setPrice(rs.getDouble("�۸�"));  
                b.setInfo(rs.getString("���"));    
                 
                  
            }   
         
        } catch (Exception e) {  
        	e.printStackTrace(); 
  
        } finally {  
            DBConn.closeDB(conn, pt, rs);  
            
        }  
        return b;
	}

	
	@Override
	public void add(Book book) {
		Connection conn = null;  
        PreparedStatement pstat = null;  
        ResultSet rs = null;
        String sql = null;  
  
        try {  
            conn = DBConn.getConn(); 
            sql="select * from car where No=?";
            pstat = conn.prepareStatement(sql);
            pstat.setString(1,book.getNO());
            rs = pstat.executeQuery(); 
            if(rs.next()){
            	int num = rs.getInt("����");
            	num++;
                double price=Double.parseDouble(rs.getString("�۸�").trim());  
                sql = "update car set ���� = ?, �ܼ۸� = ? where No=?";  
                pstat = conn.prepareStatement(sql);  
                pstat.setInt(1,num);  
                pstat.setString(2,new Double(price*num).toString());
                pstat.setString(3,book.getNO());
                pstat.executeUpdate();  
                pstat.close();  
            	
            	
            }else{           
            //����ѡ����Ʒ���뵽���ﳵ��  
            sql = "insert into car(����,���,�۸�,����,�ܼ۸�,No) values(?,?,?,?,?,?)";  
            pstat = conn.prepareStatement(sql);  
            pstat.setString(1,book.getName());  
            pstat.setString(2, book.getInfo());
            pstat.setDouble(3,book.getPrice());  
            pstat.setInt(4,1);  
            pstat.setDouble(5,book.getPrice());
            pstat.setString(6,book.getNO());
            pstat.executeUpdate();  
                 
                  
            }   
         
        } catch (Exception e) {  
        	e.printStackTrace();
  
        } finally {  
            DBConn.closeDB(conn, pstat, rs);  
            
        }  
		
	}
	
	public List<CartItem> getAllCart() {
		  
		Connection conn = null;
        PreparedStatement pt = null;  
        ResultSet rs = null;  
        List<CartItem> list = new ArrayList<CartItem>(); 
        try {  
            conn = DBConn.getConn();  
            String sql = "select NO,����,���,�۸�,����,�ܼ۸�  from car";  
            pt = conn.prepareStatement(sql);  
            rs = pt.executeQuery();  
  
             
  
            while (rs.next()) {  
                CartItem cart = new CartItem();
                /*Book book=new Book();
                book.setNO(rs.getString("NO"));
                book.setName(rs.getString("����"));
                book.setInfo(rs.getString("���"));
                book.setPrice(rs.getDouble("�۸�"));*/
                BusinessServiceImpl service=new BusinessServiceImpl();
                cart.setBook(service.findBook(rs.getString("NO")));  
                cart.setQuantity(rs.getInt("����"));
                cart.setPrice(rs.getDouble("�ܼ۸�"));
  
                list.add(cart);  
  
            } 
                  
  
        } catch (Exception e) {  
        	 e.printStackTrace();  
  
        } finally {  
            DBConn.closeDB(conn, pt, rs);  
        }
       
		return list;
	}

	@Override
	public void delete(String NO) {
		Connection conn = null;  
        PreparedStatement pstat = null;  
        String sql = null;
  
        try {   
        conn = DBConn.getConn(); 
		sql = "delete from car where No=?";  
        pstat = conn.prepareStatement(sql);  
        pstat.setString(1,NO); 
        pstat.executeUpdate(); 
        pstat.close();   
        conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
            
	}

	@Override
	public void clear() {
		Connection conn = null;  
        PreparedStatement pstat = null;  
        String sql = null;
  
		 
        try {
        	conn = DBConn.getConn(); 
        	sql = "delete from car";  
            pstat = conn.prepareStatement(sql);  
            pstat.executeUpdate(); 
			pstat.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
          
        //�ر����ݿ�����  
        
          
		
	}

	public void change(String choice,String NO,double price,int quantity) {
		Connection conn = null;  
        PreparedStatement pstat = null;  
        String sql = null;
  
		if(choice.equals("add")){ 
        try {
        	conn = DBConn.getConn(); 
        	sql = "update car set ���� =����+1, �ܼ۸� = ? where No=?";
		pstat = conn.prepareStatement(sql);  
        pstat.setString(1,new Double(price*quantity).toString());  
        pstat.setString(2,NO);  
        pstat.executeUpdate();  
        pstat.close();  
		
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
		}else{
			try {
	        	conn = DBConn.getConn(); 
	        	sql = "update car set ���� =����-1, �ܼ۸� = ? where No=?";
			pstat = conn.prepareStatement(sql);  
	        pstat.setString(1,new Double(price*quantity).toString());  
	        pstat.setString(2,NO);  
	        pstat.executeUpdate();  
	        pstat.close();  
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
			
		}
		
      
	}

}
