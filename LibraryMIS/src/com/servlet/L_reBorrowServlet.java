package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.BRB;
import com.bean.Book;
import com.dao.L_domain;

public class L_reBorrowServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	 L_domain Ldo=new L_domain();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 String rdIDUser=(String)request.getSession().getAttribute("rdID");
		 System.out.println(rdIDUser);
		String op=(String)request.getSession().getAttribute("op");
		String bkCode=request.getParameter("bkCode");
		List<BRB> list=Ldo.recheck(bkCode);
		request.setAttribute("list", list);
		if(op.equals("relend")){
		request.getRequestDispatcher("/L_ShowBorrow.jsp").forward(request, response);
		}else if(op.equals("return")){
			request.getRequestDispatcher("/L_return.jsp?rdIDUser="+rdIDUser).forward(request, response);
		}
		
	}

	

}
