package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Borrow;
import com.bean.Reader;
import com.bean.ReaderType;
import com.dao.L_domain;

public class L_BorrowServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	L_domain Ldo=new L_domain();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 String rdIDUser=(String)request.getSession().getAttribute("rdIDUser");
		String rdID=request.getParameter("rdID");
		List<Reader> list=Ldo.find(rdID);
		request.setAttribute("list", list);
		List<Borrow> list1=Ldo.check(rdID);
		request.setAttribute("list1", list1);
		List<ReaderType> list2=Ldo.search(list.get(0).getRdType());
		request.setAttribute("list2", list2);			
		request.getRequestDispatcher("/L_ListReader.jsp?rdIDUser="+rdIDUser).forward(request, response);
		
		
		

		
	}

	
}
