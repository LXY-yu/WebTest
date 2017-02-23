package com.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bean.Command;
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

}
