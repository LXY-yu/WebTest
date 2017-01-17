package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Book;
import com.dao.B_domain;

public class B_AddBookServlet extends HttpServlet {

	
	B_domain Bdo=new B_domain();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bkCode=request.getParameter("bkCode");
		String bkAuthor=request.getParameter("bkAuthor");
		String bkName=request.getParameter("bkName");
		String bkPress=request.getParameter("bkPress");
		String bkDatePress=request.getParameter("bkDatePress");
		String bkISBN=request.getParameter("bkISBN");
		String bkCatalog=request.getParameter("bkCatalog");
		int bkLanguage=Integer.parseInt(request.getParameter("bkLanguage"));
		int bkPages=Integer.parseInt(request.getParameter("bkPages"));
		float bkPrice=Float.parseFloat(request.getParameter("bkPrice"));
		String bkBrief=request.getParameter("bkBrief");
		String bkCover=request.getParameter("bkCover");
		String bkStatus=request.getParameter("bkStatus");
		Book b=new Book();
		b.setBkCode(bkCode);
		b.setBkAuthor(bkAuthor);
		b.setBkName(bkName);
		b.setBkPress(bkPress);
		b.setBkDatePress(bkDatePress);
		b.setBkISBN(bkISBN);
		b.setBkCatalog(bkCatalog);
		b.setBkLanguage(bkLanguage);
		b.setBkPages(bkPages);
		b.setBkPrice(bkPrice);
		b.setBkBrief(bkBrief);
		b.setBkCover(bkCover);
		b.setBkStatus(bkStatus);
		b.setBkDateIn(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
		
		if(Bdo.add(b)){
			request.getRequestDispatcher("/bottom.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/B_addFalse.jsp").forward(request, response);
		}

	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	

}
