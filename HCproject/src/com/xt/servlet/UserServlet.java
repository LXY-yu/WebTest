package com.xt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xt.dao.UserDao;
import com.xt.pojo.Admin;

public class UserServlet extends HttpServlet {

	//管理员登录校验
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String flag=request.getParameter("flag");
		if(flag.equalsIgnoreCase("update")){
			this.updateUser( request, response);
		}
		
	}

	public void updateUser(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String pwd=request.getParameter("userPw1");
		HttpSession session=request.getSession();
		Admin admin=(Admin)session.getAttribute("user");
		String username=admin.getUsername();
		System.out.println(pwd+username);
		UserDao dao=new UserDao();
		if(dao.updatePwd(pwd, username)){
			session.removeAttribute("user");
			request.setCharacterEncoding("utf-8");
			request.getRequestDispatcher("web/admin/deal.jsp").forward(request, response);
		}

}
}
