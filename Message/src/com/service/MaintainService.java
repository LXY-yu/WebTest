package com.service;

import java.util.ArrayList;
import java.util.List;

import com.bean.message;
import com.dao.MeaasgeDao;

/*
 * 与维护相关的业务
 */
public class MaintainService {

	/*
	 * 单条删除
	 */
	public void deleteOne(String id){
		if(id !=null && !"".equals(id.trim())){
			MeaasgeDao dm=new MeaasgeDao();
			dm.deleteOne(Integer.valueOf(id));
		}
				
	}
	
	/*
	 * 单条删除
	 */
	public void deleteBatch(String[] ids){
			MeaasgeDao dm=new MeaasgeDao();
			List<Integer> idList=new ArrayList<Integer>();
			for(String id:ids){
				idList.add(Integer.valueOf(id));
			}
			dm.deleteBatch(idList);
	}
	
	/*
	 * 查找for修改
	 */
	public List<message> findForUpdate(String id){
		
			List<message> list=new ArrayList<message>();
			MeaasgeDao dm=new MeaasgeDao();
			list=dm.findForUpdate(Integer.valueOf(id));
			return list;		
	}
	
	public void update(String id,String command,String discription,String content){
		message m=new message();
		m.setId(Integer.valueOf(id));
		m.setCommand(command);
		m.setContent(content);
		m.setDiscription(discription);
		MeaasgeDao dm=new MeaasgeDao();
		dm.update(m);
}
	
	public void add(String command,String discription,String content){
		message m=new message();
		
		m.setCommand(command);
		m.setContent(content);
		m.setDiscription(discription);
		MeaasgeDao dm=new MeaasgeDao();
		dm.add(m);
}
	/*public static void main(String[] args){
		List<message> list=new ArrayList<message>();
		MaintainService dm=new MaintainService();
		list=dm.findForUpdate("3");
		System.out.println(list.get(0).getCommand());
	}*/
}
