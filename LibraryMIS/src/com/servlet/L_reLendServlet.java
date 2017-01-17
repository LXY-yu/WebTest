package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.L_domain;

public class L_reLendServlet extends HttpServlet {

	L_domain Ldo=new L_domain();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		String rdID=request.getParameter("rdID");
		int bkID=Integer.parseInt(request.getParameter("bkID"));
		int CanLendDay=Integer.parseInt(request.getParameter("CanLendDay"));
		
		
		
		if(Ldo.updateBorrow(rdID,bkID,CanLendDay)){
			request.getRequestDispatcher("/bottom.jsp").forward(request, response);
		}
		

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	

}
