package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Book;
import com.dao.B_domain;

public class B_UpdateServlet extends HttpServlet {

	B_domain Bdo=new B_domain();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String kind=request.getParameter("update");
		request.setCharacterEncoding("utf-8");
		if(kind.equals("¸ü¸Ä")){
			int bkID=Integer.parseInt(request.getParameter("bkID"));
			String bkCode=request.getParameter("bkCode");
			String bkName=request.getParameter("bkName");
			String bkAuthor=request.getParameter("bkAuthor");
			String bkPress=request.getParameter("bkPress");
			String bkDatePress=request.getParameter("bkDatePress");
			String bkISBN=request.getParameter("bkISBN");
			String bkCatalog=request.getParameter("bkCatalog");
			int bkLanguage=Integer.parseInt(request.getParameter("bkLanguage"));
			int bkPages=Integer.parseInt(request.getParameter("bkPages"));
			float bkPrice=Float.parseFloat(request.getParameter("bkPrice"));
			String bkDateIn=request.getParameter("bkDateIn");
			String bkBrief=request.getParameter("bkBrief");
			String bkCover=request.getParameter("bkCover");
			String bkStatus=request.getParameter("bkStatus");
			Book B=new Book();
			B.setBkAuthor(bkAuthor);
			B.setBkBrief(bkBrief);
			B.setBkCatalog(bkCatalog);
			B.setBkCode(bkCode);
			B.setBkCover(bkCover);
			B.setBkDateIn(bkDateIn);
			B.setBkDatePress(bkDatePress);
			B.setBkID(bkID);
			B.setBkISBN(bkISBN);
			B.setBkLanguage(bkLanguage);
			B.setBkName(bkName);
			B.setBkPages(bkPages);
			B.setBkPress(bkPress);
			B.setBkPrice(bkPrice);
			B.setBkStatus(bkStatus);
			if(Bdo.update(B)){
				request.getRequestDispatcher("/bottom.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("/B_false.jsp").forward(request, response);
			}
					
		}else{
			int bkID=Integer.parseInt(request.getParameter("bkID"));
			Bdo.delete(bkID);
			request.getRequestDispatcher("/bottom.jsp").forward(request, response);
		}

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	
}
