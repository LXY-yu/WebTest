package com.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bean.message;
import com.util.DBConn;

public class MeaasgeDao {

	
	//根据检索条件查询相应的数据
	/*public List<message> find() {
		Connection conn = null;  
        PreparedStatement pt = null;  
        ResultSet rs = null;  
        message m =null;
        List<message> list = new ArrayList<message>();
  
        try {  
            conn = DBConn.getConn(); 
            String sql = "select * from message";
            pt = conn.prepareStatement(sql);     
            rs = pt.executeQuery();    
           while(rs.next()){  
                m = new message();
                m.setId(rs.getInt("ID"));
                m.setCommand(rs.getString("COMMAND"));
                m.setDiscription(rs.getString("DISCRIPTION"));
                m.setContent(rs.getString("CONTENT"));           
                list.add(m);                  
            }   
         
        } catch (Exception e) {  
        	e.printStackTrace(); 
  
        } finally {  
            DBConn.closeDB(conn, pt, rs);  
            
        }  
        return list;
	}
	
	public List<message> find(String command) {
		Connection conn = null;  
        PreparedStatement pt = null;  
        ResultSet rs = null;  
        message m =null;
        List<message> list = new ArrayList<message>();
  
        try {  
            conn = DBConn.getConn(); 
            String sql = "select * from message where COMMAND=?;";
            pt = conn.prepareStatement(sql);
            pt.setString(1, command);
            rs = pt.executeQuery();    
           while(rs.next()){  
                m = new message();
                m.setId(rs.getInt("ID"));
                m.setCommand(rs.getString("COMMAND"));
                m.setDiscription(rs.getString("DISCRIPTION"));
                m.setContent(rs.getString("CONTENT"));           
                list.add(m);                  
            }   
         
        } catch (Exception e) {  
        	e.printStackTrace(); 
  
        } finally {  
            DBConn.closeDB(conn, pt, rs);  
            
        }  
        return list;
	}

	public List<message> findt(String discription) {
		Connection conn = null;  
        PreparedStatement pt = null;  
        ResultSet rs = null;  
        message m =null;
        List<message> list = new ArrayList<message>();
  
        try {  
            conn = DBConn.getConn(); 
            String sql = "select * from message where DISCRIPTION like '%'+?+'%';";
            pt = conn.prepareStatement(sql); 
            pt.setString(1, discription);
            rs = pt.executeQuery();    
           while(rs.next()){  
                m = new message();
                m.setId(rs.getInt("ID"));
                m.setCommand(rs.getString("COMMAND"));
                m.setDiscription(rs.getString("DISCRIPTION"));
                m.setContent(rs.getString("CONTENT"));           
                list.add(m);                  
            }   
         
        } catch (Exception e) {  
        	e.printStackTrace(); 
  
        } finally {  
            DBConn.closeDB(conn, pt, rs);  
            
        }  
        return list;
	}
	
	//like '%' ? '%'
	public List<message> find(String command,String discription) {
		Connection conn = null;  
        PreparedStatement pt = null;  
        ResultSet rs = null;  
        message m =null;
        List<message> list = new ArrayList<message>();
  
        try {  
            conn = DBConn.getConn(); 
            String sql = "select * from message where DISCRIPTION like '%'+?+'%' and COMMAND=? ;";
            pt = conn.prepareStatement(sql);  
            pt.setString(1, discription);
            pt.setString(2, command);
            rs = pt.executeQuery();    
           while(rs.next()){  
                m = new message();
                m.setId(rs.getInt("ID"));
                m.setCommand(rs.getString("COMMAND"));
                m.setDiscription(rs.getString("DISCRIPTION"));
                m.setContent(rs.getString("CONTENT"));           
                list.add(m);                  
            }   
         
        } catch (Exception e) {  
        	e.printStackTrace(); 
  
        } finally {  
            DBConn.closeDB(conn, pt, rs);  
            
        }  
        return list;
	}*/
	
	//根据检索条件查询相应的值精简版
	public List<message> find(String command,String discription) {
		DBConn dbConn=new DBConn();
		SqlSession sqlSession=null;
		List<message> list = new ArrayList<message>();
		message msg=new message();
		msg.setCommand(command);
		msg.setDiscription(discription);
		
		try{
			sqlSession=dbConn.getSqlSession();
			//通过sqlSession执行sql语句
			list=sqlSession.selectList("Message.find",msg);
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			if(sqlSession !=null){
				sqlSession.close();
			}
			
		}
		return list;
	}
	
	//单条删除
	public void deleteOne(int id){
		DBConn dbConn=new DBConn();
		SqlSession sqlSession=null;
		try{
			sqlSession=dbConn.getSqlSession();
			//通过sqlSession执行sql语句
			sqlSession.delete("Message.deleteOne",id);
			sqlSession.commit();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			if(sqlSession !=null){
				sqlSession.close();
			}
			
		}
		
	}
	
	//批量删除
	public void deleteBatch(List<Integer> ids){
		DBConn dbConn=new DBConn();
		SqlSession sqlSession=null;
		try{
			sqlSession=dbConn.getSqlSession();
			//通过sqlSession执行sql语句
			sqlSession.delete("Message.deleteBatch",ids);
			sqlSession.commit();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			if(sqlSession !=null){
				sqlSession.close();
			}
			
		}
		
	}

	/*
	 * 查找要修改的信息
	 */
	public List<message> findForUpdate(int id) {
		DBConn dbConn=new DBConn();
		SqlSession sqlSession=null;
		List<message> list = new ArrayList<message>();
		message msg=new message();
		
		try{
			sqlSession=dbConn.getSqlSession();
			//通过sqlSession执行sql语句
			list=sqlSession.selectList("Message.FindForUpdate",id);
			
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			if(sqlSession !=null){
				sqlSession.close();
			}
			
		}
		return list;
	}
	/*
	 * 修改信息
	 */
	public void update(message m){
		DBConn dbConn=new DBConn();
		SqlSession sqlSession=null;
		try{
			sqlSession=dbConn.getSqlSession();
			//通过sqlSession执行sql语句
			sqlSession.update("Message.update",m);
			sqlSession.commit();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			if(sqlSession !=null){
				sqlSession.close();
			}
			
		}
		
	}
	
	/*
	 * 添加信息
	 */
	public void add(message m){
		DBConn dbConn=new DBConn();
		SqlSession sqlSession=null;
		try{
			sqlSession=dbConn.getSqlSession();
			//通过sqlSession执行sql语句
			sqlSession.insert("Message.add",m);
			sqlSession.commit();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			if(sqlSession !=null){
				sqlSession.close();
			}
			
		}
	}
	/*public static void main(String[] args){
		List<message> list=new ArrayList<message>();
		domain dm=new domain();
		list=dm.update(3);
		System.out.println(list.get(0).getCommand());
	}*/
	/*public List<message> find(String command,String discription) {
		Connection conn = null;  
        PreparedStatement pt = null;  
        ResultSet rs = null;  
        message m =null;
        List<message> list = new ArrayList<message>();
  
        try {  
            conn = DBConn.getConn(); 
            StringBuilder sql =new StringBuilder("select * from message where 1=1");
            List<String> paramList=new ArrayList<String>();
            if(command !=null && !"".equals(command.trim())){
            	sql.append(" and COMMAND=?");
            	paramList.add(command);
            }
            if(discription !=null && !"".equals(discription.trim())){
            	sql.append(" and DISCRIPTION like '%'+?+'%'");
            	paramList.add(discription);
            }
            
            pt = conn.prepareStatement(sql.toString()); 
            for(int i=0;i<paramList.size();i++){
            	pt.setString(i+1, paramList.get(i));
            }      
            rs = pt.executeQuery();    
           while(rs.next()){  
                m = new message();
                m.setId(rs.getInt("ID"));
                m.setCommand(rs.getString("COMMAND"));
                m.setDiscription(rs.getString("DISCRIPTION"));
                m.setContent(rs.getString("CONTENT"));           
                list.add(m);                  
            }   
         
        } catch (Exception e) {  
        	e.printStackTrace(); 
  
        } finally {  
            DBConn.closeDB(conn, pt, rs);  
            
        }  
        return list;
	}*/

	
	

	
	
}
