package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.MaintainService;

public class SaveServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//���ñ���
		request.setCharacterEncoding("utf-8");
		//����ҳ�洫�ݶ�ֵ
		String id1=request.getParameter("id1");
		String id2=request.getParameter("id2");
		String command=request.getParameter("commandT");
		String discription=request.getParameter("discriptionT");
		String content=request.getParameter("content");
		MaintainService ms=new MaintainService();
		ms.update(id1,id2, command, discription, content);
		//ҳ����ת
		request.getRequestDispatcher("/ListServlet").forward(request,response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	

}
