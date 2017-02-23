package com.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bean.Command;
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

}
