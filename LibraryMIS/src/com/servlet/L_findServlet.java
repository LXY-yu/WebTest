package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Book;
import com.dao.B_domain;

public class L_findServlet extends HttpServlet {


	B_domain Bdo=new B_domain();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String bkName=request.getParameter("bkName");
		String rdID=(String) request.getSession().getAttribute("rdID");
		String rdIDUser=(String) request.getSession().getAttribute("rdIDUser");
		int CanLendDay=Integer.parseInt((String) request.getSession().getAttribute("CanLendDay"));
		List<Book> list=Bdo.find(bkName);
		request.setAttribute("list", list);
	    request.getRequestDispatcher("/L_ShowBook.jsp?rdID="+rdID+"&rdIDUser="+rdIDUser+"&CanLendDay="+CanLendDay).forward(request, response);
		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	

}
