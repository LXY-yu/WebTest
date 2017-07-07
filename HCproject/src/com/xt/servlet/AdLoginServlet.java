package com.xt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xt.dao.UserDao;
import com.xt.pojo.Admin;

public class AdLoginServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username=request.getParameter("userName");
		String password=request.getParameter("userPw");
		UserDao dao=new UserDao();
		if(dao.checkUser(username, password)){
			HttpSession session=request.getSession();
			session.setAttribute("user", new Admin(username,password));
			response.sendRedirect("web/main.jsp");
		}else{
			String msg="对不起，账号或者密码错误！！";
			request.setAttribute("msg",msg);
			request.setCharacterEncoding("utf-8");
			request.getRequestDispatcher("qdlogin.jsp").forward(request, response);
		}
	} 

}
