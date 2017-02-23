package com.service;

import java.util.ArrayList;
import java.util.List;

import com.bean.message;
import com.dao.MeaasgeDao;

public class ListService {

	public List<message> find(String command,String discription){
		MeaasgeDao dm=new MeaasgeDao();
		List<message> list=new ArrayList<message>();
		list=dm.find(command,discription);
		return list;
		
	}
}
