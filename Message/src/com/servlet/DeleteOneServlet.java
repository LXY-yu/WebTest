package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.service.MaintainService;

public class DeleteOneServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//���ñ���
		request.setCharacterEncoding("utf-8");
		//����ҳ�洫�ݶ�ֵ
		String id=request.getParameter("id");
		MaintainService ms=new MaintainService();
		ms.deleteOne(id);
		//ҳ����ת
		request.getRequestDispatcher("/ListServlet").forward(request,response);
		
	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	

}
