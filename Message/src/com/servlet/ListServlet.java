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
		//���ñ���
		request.setCharacterEncoding("utf-8");
		//����ҳ�洫�ݶ�ֵ
		String command=request.getParameter("command");
		String discription=request.getParameter("discription");

		String currentPage = request.getParameter("currentPage");
		// ������ҳ����
		Page page = new Page();
		Pattern pattern = Pattern.compile("[0-9]{1,9}");
		if(currentPage == null ||  !pattern.matcher(currentPage).matches()) {
			page.setCurrentPage(1);
		} else {
			page.setCurrentPage(Integer.valueOf(currentPage));
		}
		
		//��ѯ��Ϣ�б�
		list=qs.queryMessageListByPage(command, discription,page);
		//��ҳ�洫ֵ
		request.setAttribute("command", command);
		request.setAttribute("discription", discription);
		request.setAttribute("page", page);
		request.setAttribute("list", list);
		//ҳ����ת
		request.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(request,response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
