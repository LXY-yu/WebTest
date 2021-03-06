package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.bean.Command;
import com.bean.CommandContent;
import com.dao.CommandDao;
import com.entity.Page;
import com.util.Iconst;

/**
 * 查询相关的业务功能
 */
public class QueryService {
	/*public List<message> queryMessageList(String command,String description) {
		MeaasgeDao messageDao = new MeaasgeDao();
		return messageDao.find(command, description);
	}*/
	public List<Command> queryMessageList(String command,String description) {
		CommandDao commandDao = new CommandDao();
		return commandDao.queryCommandList(command, description);
	}
	
	/**
	 * 根据查询条件分页查询消息列表
	 */
	public List<Command> queryMessageListByPage(String command,String discription,Page page) {
		Map<String,Object> parameter = new HashMap<String, Object>();
		// 组织消息对象
		Command c = new Command();
		c.setName(command);
		c.setDiscription(discription);
		parameter.put("command", c);
		parameter.put("page", page);
		CommandDao commandDao = new CommandDao();
		// 分页查询并返回结果
		return commandDao.queryMessageListByPage(parameter);
	}
	
	/**
	 * 通过指令查询自动回复的内容
	 * @param command 指令
	 * @return 自动回复的内容
	 */
	public String queryByCommand(String command) {
		CommandDao commandDao = new CommandDao();
		List<Command> commandList;
		if(Iconst.HELP_COMMAND.equals(command)) {
			commandList = commandDao.queryCommandList(null, null);
			StringBuilder result = new StringBuilder();
			for(int i = 0; i < commandList.size(); i++) {
				if(i != 0) {
					result.append("<br/>");
				}
				result.append("回复[" + commandList.get(i).getName() + "]可以查看" + commandList.get(i).getDiscription());
			}
			return result.toString();
		}
		commandList = commandDao.queryCommandList(command, null);
		if(commandList.size() > 0) {
			List<CommandContent> contentList=commandList.get(0).getContentList();
			return contentList.get(new Random().nextInt(contentList.size())).getContent();
		}
		return Iconst.NO_MATCHING_CONTENT;
	}
}
