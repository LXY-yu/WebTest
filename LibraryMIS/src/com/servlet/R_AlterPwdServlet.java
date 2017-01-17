package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.R_domain;

public class R_AlterPwdServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	R_domain Rdo=new R_domain();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String rdID=(String)request.getSession().getAttribute("rdID");
		//String oldPwd=request.getParameter("oldPwd");
		String rdPwd=request.getParameter("rdPwd");
		if(Rdo.alterPwd(rdID, rdPwd)){
			request.getRequestDispatcher("/bottom.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/R_AlterPwdFalse.jsp").forward(request, response);
		}
	}

	

}
