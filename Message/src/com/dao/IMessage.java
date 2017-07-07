package com.dao;

import java.util.List;
import java.util.Map;

import com.bean.Command;


/**
 * ��Command�����ļ����Ӧ�Ľӿ�
 */
public interface IMessage {
	/**
	 * ���ݲ�ѯ������ѯ��Ϣ�б�
	 */
	public List<Command> queryMessageList(Map<String,Object> parameter);
	
	/**
	 * ���ݲ�ѯ������ѯ��Ϣ�б������
	 */
	public int count(Command command);
	
	/**
	 * ���ݲ�ѯ������ҳ��ѯ��Ϣ�б�
	 */
	public List<Command> queryMessageListByPage(Map<String,Object> parameter);
}

