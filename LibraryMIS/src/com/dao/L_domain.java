package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.bean.BRB;
import com.bean.Book;
import com.bean.Borrow;
import com.bean.Reader;
import com.bean.ReaderType;
import com.util.DBConn;

public class L_domain {
	
	public List<Reader> find(String rdID) {
		Connection conn = null;  
        PreparedStatement pt = null;  
        ResultSet rs = null;  
        Reader R =null;
        List<Reader> list = new ArrayList<Reader>();
  
        try {  
            conn = DBConn.getConn(); 
            String sql = "select * from TB_Reader where rdID=?";
            pt = conn.prepareStatement(sql);  
              
            pt.setString(1, rdID);
            
              
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
	
	public List<Borrow> check(String rdID) {
		Connection conn = null;  
        PreparedStatement pt = null;  
        ResultSet rs = null;  
        List<Borrow> list = new ArrayList<Borrow>();
  
        try {  
            conn = DBConn.getConn(); 
            String sql = "select * from TB_Borrow where rdID=?";
            pt = conn.prepareStatement(sql);  
              
            pt.setString(1, rdID);
            
              
            rs = pt.executeQuery();    
            if(rs.next()){  
                Borrow B=new Borrow();
                B.setBkID(rs.getInt("bkID"));
                B.setBorrowid(rs.getInt("BorrowID"));
                B.setIdcontinuetimes(rs.getInt("IdContinueTimes"));
                B.setIddateout(rs.getDate("IdDateOut"));
                B.setIddateretact(rs.getDate("IdDateRetAct"));
                B.setIddateretplan(rs.getDate("IdDateRetPlan"));
                B.setIdoverday(rs.getInt("IdOverDay"));
                B.setIdOvermoney(rs.getFloat("IdOverMoney"));
                B.setIdpunishmoney(rs.getFloat("IdPunishMoney"));
                B.setIshasreturn(rs.getBoolean("IsHasReturn"));
                B.setOperatorlend(rs.getString("OperatorLend"));
                B.setOperatorlend(rs.getString("OperatorRet"));
                B.setRdID(rs.getString("rdID"));
                list.add(B);                  
            }   
         
        } catch (Exception e) {  
        	e.printStackTrace(); 
  
        } finally {  
            DBConn.closeDB(conn, pt, rs);  
            
        }  
        return list;
	}
	
	public List<ReaderType> search(int rdType) {
		Connection conn = null;  
        PreparedStatement pt = null;  
        ResultSet rs = null;  
        
        List<ReaderType> list = new ArrayList<ReaderType>();
       
  
        try {  
            conn = DBConn.getConn(); 
            String sql = "select * from TB_ReaderType where rdType=?";
            pt = conn.prepareStatement(sql);               
            pt.setInt(1, rdType);           
            rs = pt.executeQuery();    
            if(rs.next()){
            	 ReaderType  Rt=new ReaderType();
            	Rt.setRdType(rs.getInt("rdType"));
            	Rt.setRdTypeName(rs.getString("rdTypeName"));
            	Rt.setCanLendQty(rs.getInt("CanLendQty"));
            	Rt.setCanLendDay(rs.getInt("CanLendDay"));
                Rt.setCanContinueTimes(rs.getInt("CanContinueTimes"));
                Rt.setPunishRate(rs.getFloat("PunishRate"));
                Rt.setDateValid(rs.getInt("DateValid"));
                list.add(Rt);                  
            }   
         
        } catch (Exception e) {  
        	e.printStackTrace(); 
  
        } finally {  
            DBConn.closeDB(conn, pt, rs);  
            
        }  
        return list;
	}
	
	public boolean updateBook(int bkID) {
		Connection conn = null;  
        PreparedStatement pstat = null;  
        ResultSet rs = null;
        String sql = null;  
  
        try {  
            conn = DBConn.getConn();  
            sql = "update TB_Book set bkStatus=? where bkID=?";  
            pstat = conn.prepareStatement(sql);  
      
            pstat.setString(1, "½è³ö");
            pstat.setInt(2, bkID);
       
            pstat.executeUpdate();  
              
            return true;
          
        } catch (Exception e) {  
        	e.printStackTrace();
        	return false;
  
        } finally {  
            DBConn.closeDB(conn, pstat, rs);              
        }  
		
	}
	
	public boolean updateReader(String rdID) {
		Connection conn = null;  
        PreparedStatement pstat = null;  
        ResultSet rs = null;
        String sql = null;  
  
        try {  
            conn = DBConn.getConn();  
            sql = "update TB_Reader set rdBorrowQty=rdBorrowQty+1 where rdID=?";  
            pstat = conn.prepareStatement(sql);  
      
            pstat.setString(1, rdID);
       
            pstat.executeUpdate();  
              
            return true;
          
        } catch (Exception e) {  
        	e.printStackTrace();
        	return false;
  
        } finally {  
            DBConn.closeDB(conn, pstat, rs);              
        }  
		
	}
	
	public boolean addBorrow(Borrow br){
		Connection conn = null;  
        PreparedStatement pstat = null;  
        ResultSet rs = null;
        String sql = null;  
  
        try {  
            conn = DBConn.getConn();  
            sql = "insert into TB_Borrow(rdID,bkID,IdContinueTimes,IdDateOut,IdDateRetPlan,IdDateRetAct,IdOverDay,IdOverMoney,IdPunishMoney,IsHasReturn,OperatorLend,OperatorRet) values(?,?,0,?,?,?,?,?,?,0,?,?)";  
            pstat = conn.prepareStatement(sql);  
            pstat.setString(1,br.getRdID());
            pstat.setInt(2, br.getBkID());
            pstat.setDate(3,br.getIddateout());
            pstat.setDate(4, br.getIddateretplan());
            pstat.setDate(5,br.getIddateretact());
            pstat.setInt(6,br.getIdoverday());
            pstat.setFloat(7,br.getIdOvermoney());
            pstat.setFloat(8, br.getIdpunishmoney());
            pstat.setString(9, br.getOperatorlend());
            pstat.setString(10, br.getOperatorret());
       
            pstat.executeUpdate();  
              
            return true;
          
        } catch (Exception e) {  
        	e.printStackTrace();
        	return false;
  
        } finally {  
            DBConn.closeDB(conn, pstat, rs);              
        }  
		
	}
	
	public List<BRB> recheck(String bkCode) {
		Connection conn = null;  
        PreparedStatement pt = null;  
        ResultSet rs = null;  
        List<BRB> list = new ArrayList<BRB>();
  
        try {  
            conn = DBConn.getConn(); 
            String sql = "select * from TB_Borrow join TB_Book on TB_Book.bkCode=? and TB_Book.bkID=TB_Borrow.bkID and TB_Borrow.IsHasReturn=? "
            		+ "join TB_Reader on TB_Reader.rdID=TB_Borrow.rdID "
            		+ "join TB_ReaderType on TB_Reader.rdType=TB_ReaderType.rdType";
            pt = conn.prepareStatement(sql);  
              
            pt.setString(1, bkCode);
            pt.setBoolean(2, false);
            
              
            rs = pt.executeQuery();    
            if(rs.next()){  
                BRB B=new BRB();
                B.setBkCode(rs.getString("bkCode"));
                B.setBkID(rs.getInt("bkID"));
                B.setBkName(rs.getString("bkName"));
                B.setCancontinueTimes(rs.getInt("CanContinueTimes"));
                B.setIdcontinueTimes(rs.getInt("IdContinueTimes"));
                B.setIddateout(rs.getDate("IdDateOut"));
                B.setRdID(rs.getString("rdID"));
                B.setRdName(rs.getString("rdName"));
                B.setRdStatus(rs.getString("rdStatus"));
                B.setCanlendday(rs.getInt("CanLendDay"));
                B.setIddateretplan(rs.getDate("IdDateRetPlan"));
                B.setPunishrate(rs.getFloat("PunishRate"));
                B.setBkstatus(rs.getString("bkStatus"));
                list.add(B);                  
            }   
         
        } catch (Exception e) {  
        	e.printStackTrace(); 
  
        } finally {  
            DBConn.closeDB(conn, pt, rs);  
            
        }  
        return list;
	}

	
	public boolean updateBorrow(String rdID,int bkID,int CanLendDay) {
		Connection conn = null;  
        PreparedStatement pstat = null; 
        PreparedStatement pt = null;
        ResultSet rs = null;
        String sql = null;  
        
        
        try {  
        	conn = DBConn.getConn();  
        	String sql1 = "select * from TB_Borrow where rdID=? and bkID=?";
            pt = conn.prepareStatement(sql1);               
            pt.setString(1, rdID);
            pt.setInt(2, bkID);
            rs = pt.executeQuery();    
            if(rs.next()){
            	java.sql.Date IdDateRetPlan=rs.getDate("IdDateRetPlan");
            	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            	Calendar calendar=new GregorianCalendar();
                calendar.setTime(IdDateRetPlan);
                calendar.add(calendar.DATE,CanLendDay);
                     
            sql = "update TB_Borrow set IdContinueTimes=IdContinueTimes+1,IdDateRetPlan=? where rdID=? and bkID=?";  
            pstat = conn.prepareStatement(sql);  
            
            pstat.setDate(1,new java.sql.Date(sdf.parse(sdf.format(calendar.getTime())).getTime()));
            pstat.setString(2, rdID);
            pstat.setInt(3, bkID);
       
            pstat.executeUpdate();  
              
            return true;
            }
          
        } catch (Exception e) {  
        	e.printStackTrace();
        	return false;
  
        } finally {  
            DBConn.closeDB(conn, pstat, rs);              
        }
		return false;  
		
	}
	

	public  boolean returnBook(String rdID,int bkID,Date IdDateRetAct,String rdIDUser,float PunishRate) {
		Connection conn = null;  
        PreparedStatement pstat = null;
        PreparedStatement pstat1 = null;
        PreparedStatement pstat2 = null;
        PreparedStatement pt = null;
        ResultSet rs = null;
        String sql = null;  
        
        
        try {  
        	conn = DBConn.getConn();  
             
        	String sql1 = "select * from TB_Borrow where rdID=? and bkID=?";
            pt = conn.prepareStatement(sql1);               
            pt.setString(1, rdID);
            pt.setInt(2, bkID);
            rs = pt.executeQuery();    
            if(rs.next()){
            	java.sql.Date IdDateRetPlan=rs.getDate("IdDateRetPlan");
                int day=(int) ((IdDateRetAct.getTime()-IdDateRetPlan.getTime())/(24*60*60*1000));

              
            sql = "update TB_Borrow set IdDateRetAct=?,IdOverDay=?,IdoverMoney=?,IdPunishMoney=?,isHasReturn=1,OperatorRet=? where rdID=? and bkID=?";  
            pstat = conn.prepareStatement(sql);  
            
            pstat.setDate(1,IdDateRetAct);
            
            pstat.setString(5, rdIDUser);
            pstat.setString(6, rdID);
            pstat.setInt(7, bkID);
       
            if(day<=0){
            	pstat.setInt(2, 0);
            	pstat.setInt(3,0);
            	pstat.setFloat(4, 0);
            }else{
            	pstat.setInt(2, day);
            	pstat.setInt(3,day);
            	pstat.setFloat(4, (day*PunishRate));
            }
            
            pstat.executeUpdate(); 
            
            sql = "update TB_Reader set rdBorrowQty=rdBorrowQty-1 where rdID=?";  
            pstat1 = conn.prepareStatement(sql);  
      
            pstat1.setString(1, rdID);
       
            pstat1.executeUpdate();  
              
            
            sql = "update TB_Book set bkStatus=? where bkID=?";  
            pstat2 = conn.prepareStatement(sql);  
      
            pstat2.setString(1,"ÔÚ¹Ý");
            pstat2.setInt(2,bkID);
           
       
            pstat2.executeUpdate();  
              
            return true;
  
            }
        } catch (Exception e) {  
        	e.printStackTrace();
        	return false;
  
        } finally {  
            DBConn.closeDB(conn, pstat, rs);              
        }
		  
		return false;
		
	}
	
	/*public boolean update(int bkID) {
		Connection conn = null;  
        PreparedStatement pstat = null;  
        ResultSet rs = null;
        String sql = null;  
  
        try {  
            conn = DBConn.getConn();  
            sql = "update TB_Book set bkStatus=? where bkID=?";  
            pstat = conn.prepareStatement(sql);  
      
            pstat.setString(1,"ÔÚ¹Ý");
            pstat.setInt(2,bkID);
           
       
            pstat.executeUpdate();  
              
            return true;
          
        } catch (Exception e) {  
        	e.printStackTrace();
        	return false;
  
        } finally {  
            DBConn.closeDB(conn, pstat, rs);              
        }  
		
	}*/
	
	

}
