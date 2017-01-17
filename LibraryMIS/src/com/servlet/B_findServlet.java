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

public class B_findServlet extends HttpServlet {

	B_domain Bdo=new B_domain();
		public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String bkName=request.getParameter("bkName");
			List<Book> list=Bdo.find(bkName);
			request.setAttribute("list", list);
			String op=(String)request.getSession().getAttribute("op1");
			if(op.equals("update")){
				request.getRequestDispatcher("/B_UpdateBook.jsp").forward(request, response);
			}else if(op.equals("delete")){
				request.getRequestDispatcher("/B_DeleteBook.jsp").forward(request, response);
			}
				

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	

}
