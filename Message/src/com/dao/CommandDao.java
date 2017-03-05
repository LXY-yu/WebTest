package com.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bean.Command;
import com.bean.CommandContent;
import com.util.DBConn;

/*
 * ��ָ����Ӧ�����ݿ������
 */
public class CommandDao {
	
	//���ݼ���������ѯ��Ӧ��ָ���б�
		public List<Command> queryCommandList(String name,String discription) {
			DBConn dbConn=new DBConn();
			SqlSession sqlSession=null;
			List<Command> commandlist = new ArrayList<Command>();
			Command command=new Command();
			command.setName(name);
			command.setDiscription(discription);
			
			try{
				sqlSession=dbConn.getSqlSession();
				//ͨ��sqlSessionִ��sql���
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
		 * ����id����Ҫ�޸ĵ���Ϣ
		 */
		public List<Command> findForUpdate(int id) {
			DBConn dbConn=new DBConn();
			SqlSession sqlSession=null;
			List<Command> list = new ArrayList<Command>();
			//Command cmd=new Command();
			
			try{
				sqlSession=dbConn.getSqlSession();
				//ͨ��sqlSessionִ��sql���
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
		 * �޸���Ϣ
		 */
		public void updateCommand(Command c){
			DBConn dbConn=new DBConn();
			SqlSession sqlSession=null;
			try{
				sqlSession=dbConn.getSqlSession();
				//ͨ��sqlSessionִ��sql���
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
				//ͨ��sqlSessionִ��sql���
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
		 * �����Ϣ
		 */
		public void add(Command c,String content){
			DBConn dbConn=new DBConn();
			SqlSession sqlSession=null;
			try{
				sqlSession=dbConn.getSqlSession();
				//ͨ��sqlSessionִ��sql���
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
				//ͨ��sqlSessionִ��sql���
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
		
		//����ɾ��
		public void deleteOne(int id){
			DBConn dbConn=new DBConn();
			SqlSession sqlSession=null;
			try{
				sqlSession=dbConn.getSqlSession();
				//ͨ��sqlSessionִ��sql���
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
		
		//����ɾ��
		public void deleteBatch(List<Integer> ids){
			DBConn dbConn=new DBConn();
			SqlSession sqlSession=null;
			try{
				sqlSession=dbConn.getSqlSession();
				//ͨ��sqlSessionִ��sql���
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
