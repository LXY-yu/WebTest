package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.L_domain;

public class L_returnServlet extends HttpServlet {

	
	L_domain Ldo=new L_domain();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String rdIDUser= (String)request.getSession().getAttribute("rdIDUser");
		String rdID=request.getParameter("rdID");
		int bkID=Integer.parseInt(request.getParameter("bkID"));
		float PunishRate=Float.parseFloat(request.getParameter("PunishRate"));
	
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		java.util.Date date=new java.util.Date();
		long now=date.getTime();
		java.sql.Date IdDateRetAct=new java.sql.Date(now);
		System.out.println(rdIDUser);
	
		
		if(Ldo.returnBook(rdID,bkID,IdDateRetAct,rdIDUser,PunishRate)){			
			request.getRequestDispatcher("/bottom.jsp").forward(request, response);
			
		}else{
			request.getRequestDispatcher("/L_false.jsp").forward(request, response);
		}
		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	
}
