package com.dao;

import java.util.List;
import java.util.Map;

import com.bean.Command;


/**
 * 与Command配置文件相对应的接口
 */
public interface IMessage {
	/**
	 * 根据查询条件查询消息列表
	 */
	public List<Command> queryMessageList(Map<String,Object> parameter);
	
	/**
	 * 根据查询条件查询消息列表的条数
	 */
	public int count(Command command);
	
	/**
	 * 根据查询条件分页查询消息列表
	 */
	public List<Command> queryMessageListByPage(Map<String,Object> parameter);
}

