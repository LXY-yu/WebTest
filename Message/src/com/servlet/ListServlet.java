package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Command;
import com.entity.Page;
import com.service.QueryService;


public class ListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		QueryService qs=new QueryService();
		List<Command> list=new ArrayList<Command>();
		//设置编码
		request.setCharacterEncoding("utf-8");
		//接收页面传递额值
		String command=request.getParameter("command");
		String discription=request.getParameter("discription");

		String currentPage = request.getParameter("currentPage");
		// 创建分页对象
		Page page = new Page();
		Pattern pattern = Pattern.compile("[0-9]{1,9}");
		if(currentPage == null ||  !pattern.matcher(currentPage).matches()) {
			page.setCurrentPage(1);
		} else {
			page.setCurrentPage(Integer.valueOf(currentPage));
		}
		
		//查询消息列表
		list=qs.queryMessageListByPage(command, discription,page);
		//向页面传值
		request.setAttribute("command", command);
		request.setAttribute("discription", discription);
		request.setAttribute("page", page);
		request.setAttribute("list", list);
		//页面跳转
		request.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(request,response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
