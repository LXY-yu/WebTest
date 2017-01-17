package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Reader;
import com.dao.R_domain;

public class R_findServlet extends HttpServlet {

	R_domain Rdo=new R_domain();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op=(String)request.getSession().getAttribute("op1");
		String rdName=request.getParameter("rdName");
		int rdType=Integer.parseInt(request.getParameter("rdType"));
		String rdDept=request.getParameter("rdDept");
		List<Reader> list=Rdo.find(rdName, rdType, rdDept);
		request.setAttribute("list", list);
		if(list.isEmpty()){
			request.getRequestDispatcher("/R_HandleReader.jsp").forward(request, response);
			
		}else{
			if(op.equals("handle")){
			    request.getRequestDispatcher("/R_listReader.jsp").forward(request, response);
			}else if(op.equals("update")){
				request.getRequestDispatcher("/R_UpdateCard.jsp").forward(request, response);
			}else if(op.equals("report")){
				request.getRequestDispatcher("/R_ReportCard.jsp").forward(request, response);
			}else if(op.equals("delete")){
				request.getRequestDispatcher("/R_DeleteCard.jsp").forward(request, response);
			}else if(op.equals("rehandle")){				
					request.getRequestDispatcher("/R_reHandle.jsp").forward(request, response);
				
			}else if(op.equals("set")){				
				request.getRequestDispatcher("/R_setRoles.jsp").forward(request, response);
				
		}
		}


	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	
}
