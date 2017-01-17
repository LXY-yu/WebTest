package com.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.User;
import com.dao.addUser;

public class checkUserServlet extends HttpServlet {

	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username =request.getParameter("username");  
		String password = request.getParameter("password");
		String loginTime=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
		User u=new User(username,password);
		if(addUser.checkUser(u)){
			if(addUser.checkOnlineUser(u)){
			addUser.addOnlineUser(u, loginTime);
			}
			List<User> list=addUser.showOnlineUser();
			request.setAttribute("list", list);
			request.getRequestDispatcher("chatroom.jsp?myself="+username).forward(request, response);
						
		}else{
			request.getRequestDispatcher("false.jsp").forward(request, response);
		}
	}

	

}
