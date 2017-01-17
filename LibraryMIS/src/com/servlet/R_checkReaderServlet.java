package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.R_domain;

public class R_checkReaderServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	R_domain Rdo=new R_domain();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String rdID =request.getParameter("rdID");  
		String rdPwd = request.getParameter("rdPwd");
		if(Rdo.checkReader(rdID, rdPwd)){
			int rdAdminRoles=Rdo.checkRdAdminRoles(rdID);
			request.getRequestDispatcher("/index.jsp?rdAdminRoles="+rdAdminRoles+"&rdID="+rdID+"&rdPwd="+rdPwd).forward(request, response);
		}else{
			request.getRequestDispatcher("/R_Login.jsp").forward(request, response);
		}
	}


}
