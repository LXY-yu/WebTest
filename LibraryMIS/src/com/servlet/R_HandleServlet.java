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

public class R_HandleServlet extends HttpServlet {

	R_domain Rdo=new R_domain();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String rdID=request.getParameter("rdID");
		String rdName=request.getParameter("rdName");
		String rdPwd=request.getParameter("rdPwd");
		String rdSex=request.getParameter("rdSex");
		int rdType=Integer.parseInt(request.getParameter("rdType"));
		String rdDept=request.getParameter("rdDept");//rdID,rdName,rdSex,rdType,rdDept,rdPhone,rdEmail,rdPhoto,rdStatus,rdAdminRoles
		String rdPhone=request.getParameter("rdPhone");
		String rdEmail=request.getParameter("rdEmail");
		String rdPhoto=request.getParameter("rdPhoto");
		String rdStatus=request.getParameter("rdStatus");
		int rdAdminRoles=Integer.parseInt(request.getParameter("rdAdminRoles"));
		Reader R =new Reader();
		R.setRdID(rdID);
		R.setRdName(rdName);
		R.setRdPwd(rdPwd);
	    R.setRdSex(rdSex);
	    R.setRdType(rdType);
	    R.setRdDept(rdDept);
	    R.setRdPhone(rdPhone);
	    R.setRdEmail(rdEmail);
	    R.setRdPhoto(rdPhoto);
	    R.setRdStatus(rdStatus);
		R.setRdAdminRoles(rdAdminRoles);
		R.setRdDateReg(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
		
		if(Rdo.add(R)){
			request.getRequestDispatcher("/bottom.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/R_HandleFalse.jsp").forward(request, response);
		}
		
        /*R.setRdBorrowQty(rs.getInt("rdBorrowQty"));
        );        
        R.setRdPwd(rs.getString("rdPwd"));*/
       
       
        
		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	

}
