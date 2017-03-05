package com.service;

import java.util.ArrayList;
import java.util.List;

import com.bean.Command;
import com.bean.CommandContent;
import com.dao.CommandDao;


/*
 * 与维护相关的业务
 */
public class MaintainService {

	/*
	 * 单条删除
	 */
	public void deleteOne(String id){
		if(id !=null && !"".equals(id.trim())){
			CommandDao cd=new CommandDao();
			cd.deleteOne(Integer.valueOf(id));
		}
				
	}
	
	/*
	 * 多条删除
	 */
	public void deleteBatch(String[] ids){
		CommandDao cd=new CommandDao();
			List<Integer> idList=new ArrayList<Integer>();
			for(String id:ids){
				idList.add(Integer.valueOf(id));
			}
			cd.deleteBatch(idList);
	}
	
	/*
	 * 查找for修改
	 */
	public List<Command> findForUpdate(String id){
		
			List<Command> list=new ArrayList<Command>();
			CommandDao cd=new CommandDao();
			list=cd.findForUpdate(Integer.valueOf(id));
			return list;		
	}
	
	public void update(String id1,String id2,String command,String discription,String content){
		Command c=new Command();
		c.setId(id1);
		c.setName(command);
		c.setDiscription(discription);
		
		CommandContent cc=new CommandContent();
		cc.setId(id2);
		cc.setContent(content);
		
		CommandDao cm=new CommandDao();
		cm.updateCommand(c);
		cm.updateCommandContent(cc);
}
	
	public void add(String id,String command,String discription,String content){
		if(id!=null){
		CommandContent cc=new CommandContent();
		cc.setCommandId(id);
		cc.setContent(content);
		
		CommandDao cm=new CommandDao();
		cm.addContent(cc);
		}else{
			Command c=new Command();
			c.setName(command);
			c.setDiscription(discription);
			
			CommandDao cm=new CommandDao();
			cm.add(c, content);
		}
}
	/*public static void main(String[] args){
		List<message> list=new ArrayList<message>();
		MaintainService dm=new MaintainService();
		list=dm.findForUpdate("3");
		System.out.println(list.get(0).getCommand());
	}*/
}
