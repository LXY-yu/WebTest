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
		String from = request.getParameter("from"); // 发言人
		String face = request.getParameter("face"); // 表情
		String to = request.getParameter("to"); // 接收者
		String color = request.getParameter("color"); // 字体颜色
		String content = request.getParameter("content"); // 发言内容
		String sendTime = new Date().toLocaleString(); // 发言时间
		
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
