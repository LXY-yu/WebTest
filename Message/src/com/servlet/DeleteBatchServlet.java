package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.MaintainService;

public class DeleteBatchServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//设置编码
				request.setCharacterEncoding("utf-8");
				//接收页面传递额值
				String[] ids=request.getParameterValues("id");
				MaintainService ms=new MaintainService();
				ms.deleteBatch(ids);
				//页面跳转
				request.getRequestDispatcher("/ListServlet").forward(request,response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
