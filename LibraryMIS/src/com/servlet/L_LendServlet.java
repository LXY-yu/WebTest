package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Borrow;
import com.dao.L_domain;

public class L_LendServlet extends HttpServlet {

	L_domain Ldo=new L_domain();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int bkID=Integer.parseInt(request.getParameter("bkID"));
		String rdID=(String) request.getSession().getAttribute("rdID");
		String rdIDUser=(String) request.getSession().getAttribute("rdIDUser");
		int CanLendDay=Integer.parseInt((String) request.getSession().getAttribute("CanLendDay"));
		Borrow br=new Borrow();
				
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		java.util.Date date=new java.util.Date();
		long now=date.getTime();
		Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.add(Calendar.DAY_OF_YEAR,CanLendDay);
		br.setIddateout(new java.sql.Date(now));
	    String retDate1=sdf.format(rightNow.getTime());
	    java.util.Date date_util = null;
		try {
			date_util = sdf.parse(retDate1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		br.setIddateretplan(new java.sql.Date(date_util.getTime()));

		br.setBkID(bkID);
		br.setOperatorlend(rdIDUser);
		br.setRdID(rdID);
		br.setIdcontinuetimes(0);
		
		if(Ldo.updateBook(bkID)){
			if(Ldo.updateReader(rdID)){
				if(Ldo.addBorrow(br)){
				request.getRequestDispatcher("/bottom.jsp").forward(request, response);
				}else{
				request.getRequestDispatcher("/L_false.jsp").forward(request, response);
				}
			}else{
			request.getRequestDispatcher("/L_false.jsp").forward(request, response);
			}
		}else{
		request.getRequestDispatcher("/L_false.jsp").forward(request, response);
		}

	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


	}


}
