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
		//���ñ���
		request.setCharacterEncoding("utf-8");
		//����ҳ�洫�ݶ�ֵ
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
		
		//��ѯ��Ϣ�б�
		//list=ls.find(command,discription);
		list=qs.queryMessageList(command, discription);
		//��ҳ�洫ֵ
		request.setAttribute("command", command);
		request.setAttribute("discription", discription);
		request.setAttribute("list", list);
		//ҳ����ת
		request.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(request,response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
