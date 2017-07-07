package com.xt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xt.dao.QdUser;

public class qdLoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


			this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
  String flag=request.getParameter("flag");
  if(flag.equals("login")){
	  this.login(request, response);
  }

}
	
	
	public void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username=request.getParameter("userName");
		String pwd=request.getParameter("userPw");
		QdUser user=new QdUser();
		boolean flag=user.IfUser(username, pwd);
		if(flag){
			request.getSession().setAttribute("qduser", username);
			response.sendRedirect("qd/main.jsp");
		}else{
			String qdmsg="’À∫≈ªÚ√‹¬Î¥ÌŒÛ£°£°";
			request.setAttribute("qdmsg", qdmsg);
			request.getRequestDispatcher("qdlogin.jsp").forward(request, response);
		}
	}

}
