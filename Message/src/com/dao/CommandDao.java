package com.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bean.Command;
import com.bean.CommandContent;
import com.util.DBConn;

/*
 * 与指令表对应的数据库操作类
 */
public class CommandDao {
	
	//根据检索条件查询相应的指令列表
		public List<Command> queryCommandList(String name,String discription) {
			DBConn dbConn=new DBConn();
			SqlSession sqlSession=null;
			List<Command> commandlist = new ArrayList<Command>();
			Command command=new Command();
			command.setName(name);
			command.setDiscription(discription);
			
			try{
				sqlSession=dbConn.getSqlSession();
				//通过sqlSession执行sql语句
				commandlist=sqlSession.selectList("Command.queryCommandList",command);
			}catch(IOException e){
				e.printStackTrace();
			}finally{
				if(sqlSession !=null){
					sqlSession.close();
				}
				
			}
			return commandlist;
		}

		/*
		 * 依据id查找要修改的信息
		 */
		public List<Command> findForUpdate(int id) {
			DBConn dbConn=new DBConn();
			SqlSession sqlSession=null;
			List<Command> list = new ArrayList<Command>();
			//Command cmd=new Command();
			
			try{
				sqlSession=dbConn.getSqlSession();
				//通过sqlSession执行sql语句
				list=sqlSession.selectList("Command.FindForUpdate",id);
				
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
		public void updateCommand(Command c){
			DBConn dbConn=new DBConn();
			SqlSession sqlSession=null;
			try{
				sqlSession=dbConn.getSqlSession();
				//通过sqlSession执行sql语句
				sqlSession.update("Command.updateCommand",c);
				sqlSession.commit();
			}catch(IOException e){
				e.printStackTrace();
			}finally{
				if(sqlSession !=null){
					sqlSession.close();
				}
				
			}
			
		}
		
		public void updateCommandContent(CommandContent cc){
			DBConn dbConn=new DBConn();
			SqlSession sqlSession=null;
			try{
				sqlSession=dbConn.getSqlSession();
				//通过sqlSession执行sql语句
				sqlSession.update("CommandContent.updateCommandContent",cc);
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
		public void add(Command c,String content){
			DBConn dbConn=new DBConn();
			SqlSession sqlSession=null;
			try{
				sqlSession=dbConn.getSqlSession();
				//通过sqlSession执行sql语句
				sqlSession.insert("Command.addCommand",c);
				sqlSession.commit();
				String id=c.getId();
				CommandContent cc=new CommandContent();
				cc.setCommandId(id);
				cc.setContent(content);
				sqlSession.insert("CommandContent.addCommandContent",cc);
				sqlSession.commit();
			}catch(IOException e){
				e.printStackTrace();
			}finally{
				if(sqlSession !=null){
					sqlSession.close();
				}
				
			}
		}
		
		public void addContent(CommandContent cc){
			DBConn dbConn=new DBConn();
			SqlSession sqlSession=null;
			try{
				sqlSession=dbConn.getSqlSession();
				//通过sqlSession执行sql语句
				sqlSession.insert("CommandContent.addCommandContent",cc);
				sqlSession.commit();
			}catch(IOException e){
				e.printStackTrace();
			}finally{
				if(sqlSession !=null){
					sqlSession.close();
				}
				
			}
		}
		
		//单条删除
		public void deleteOne(int id){
			DBConn dbConn=new DBConn();
			SqlSession sqlSession=null;
			try{
				sqlSession=dbConn.getSqlSession();
				//通过sqlSession执行sql语句
				sqlSession.delete("CommandContent.deleteOne",id);
				sqlSession.commit();
				sqlSession.delete("Command.deleteOne",id);
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
				sqlSession.delete("CommandContent.deleteBatch",ids);
				sqlSession.commit();
				sqlSession.delete("Command.deleteBatch",ids);
				sqlSession.commit();
			}catch(IOException e){
				e.printStackTrace();
			}finally{
				if(sqlSession !=null){
					sqlSession.close();
				}
				
			}
			
		}

}
