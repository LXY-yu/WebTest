package com.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.User;
import com.dao.addUser;

public class addUserServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	    request.setCharacterEncoding("utf-8");
		String username =request.getParameter("username");  
		String password = request.getParameter("password");
		String password1=request.getParameter("password1");
		User u=new User(username,password);
		addUser.add(u);
		request.getRequestDispatcher("success.jsp").forward(request, response);
	
		
	}

	

}
