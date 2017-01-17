package com.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Message;
import com.bean.User;
import com.dao.addUser;

public class sendServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String from = request.getParameter("from"); // ������
		String face = request.getParameter("face"); // ����
		String to = request.getParameter("to"); // ������
		String color = request.getParameter("color"); // ������ɫ
		String content = request.getParameter("content"); // ��������
		String sendTime = new Date().toLocaleString(); // ����ʱ��
		
		Message msg=new Message();
		msg.setFrom(from);
		msg.setTo(to);
		msg.setFace(face);
		msg.setColor(color);
		msg.setContent(content);
		msg.setSendTime(sendTime);
		
		
		addUser.addMsg(msg);
		List<Message> list1=addUser.showMsg();		
		request.setAttribute("Msglist", list1);
		
		List<User> list=addUser.showOnlineUser();
		request.setAttribute("list", list);
		request.getRequestDispatcher("chatroom.jsp?myself="+from).forward(request, response);
		
	}

	

}
