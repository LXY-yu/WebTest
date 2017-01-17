package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Reader;
import com.dao.R_domain;

public class R_UpdateServlet extends HttpServlet {
	R_domain Rdo=new R_domain();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String rdID=request.getParameter("rdID");
		String rdName=request.getParameter("rdName");
		String rdSex=request.getParameter("rdSex");
		int rdType=Integer.parseInt(request.getParameter("rdType"));
		String rdDept=request.getParameter("rdDept");//rdID,rdName,rdSex,rdType,rdDept,rdPhone,rdEmail,rdPhoto,rdStatus,rdAdminRoles
		String rdPhone=request.getParameter("rdPhone");
		String rdEmail=request.getParameter("rdEmail");
		int rdBorrowQty=Integer.parseInt(request.getParameter("rdBorrowQty"));
		String rdPwd=request.getParameter("rdPwd");
		String rdPhoto=request.getParameter("rdPhoto");
		String rdStatus=request.getParameter("rdStatus");
		int rdAdminRoles=Integer.parseInt(request.getParameter("rdAdminRoles"));
		String rdDateReg=request.getParameter("rdDateReg");
		Reader R =new Reader();
		R.setRdID(rdID);
		R.setRdName(rdName);
	    R.setRdSex(rdSex);
	    R.setRdType(rdType);
	    R.setRdDept(rdDept);
	    R.setRdPhone(rdPhone);
	    R.setRdEmail(rdEmail);
	    R.setRdPhoto(rdPhoto);
	    R.setRdStatus(rdStatus);
	    R.setRdBorrowQty(rdBorrowQty);        
        R.setRdPwd(rdPwd);
		R.setRdAdminRoles(rdAdminRoles);
		R.setRdDateReg(rdDateReg);
		if(Rdo.update(R)){
			request.getRequestDispatcher("/bottom.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/R_false.jsp").forward(request, response);
		}


	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


	}



}
