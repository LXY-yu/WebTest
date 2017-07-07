package com.xt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xt.dao.QdUser;
import com.xt.pojo.User;

public class QdRegServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
   this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String loginname=request.getParameter("loginname");
		String loginpwd=request.getParameter("loginpw");
		String tel=request.getParameter("tel");
		String realname=request.getParameter("realname");
		String email=request.getParameter("email");
		User user=new User(loginname, loginpwd, realname, tel, email);
		QdUser dao=new QdUser();
		if(dao.InsertUser(user)){
			response.sendRedirect("qd/user/regdeal.jsp");
		}
	}

}
