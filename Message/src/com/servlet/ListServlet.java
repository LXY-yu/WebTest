package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Command;
import com.service.QueryService;


public class ListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//ListService ls=new ListService();
		//List<message> list=new ArrayList<message>();
		QueryService qs=new QueryService();
		List<Command> list=new ArrayList<Command>();
		//设置编码
		request.setCharacterEncoding("utf-8");
		//接收页面传递额值
		String command=request.getParameter("command");
		String discription=request.getParameter("discription");

		/*if(command!=null && (discription==null || "".equals(discription.trim()))){
			list=dm.find(command);
			
		}else if(discription!=null && (command==null || "".equals(command.trim()))){
			list=dm.findt(discription);
			
		}else if(command!=null && discription!=null ){
			list=dm.find(command,discription);
			
		}else{
			list=dm.find();
		}*/
		
		//查询消息列表
		//list=ls.find(command,discription);
		list=qs.queryMessageList(command, discription);
		//向页面传值
		request.setAttribute("command", command);
		request.setAttribute("discription", discription);
		request.setAttribute("list", list);
		//页面跳转
		request.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(request,response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
