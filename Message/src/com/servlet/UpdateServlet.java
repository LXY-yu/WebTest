package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Command;
import com.service.MaintainService;

public class UpdateServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//设置编码
				request.setCharacterEncoding("utf-8");
				//接收页面传递额值
				String id=request.getParameter("id");
				MaintainService ms=new MaintainService();
				List<Command> list=new ArrayList<Command>();
				list=ms.findForUpdate(id);
				
				request.setAttribute("list", list);
				//页面跳转
				request.getRequestDispatcher("/WEB-INF/jsp/back/update.jsp").forward(request,response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	

}
