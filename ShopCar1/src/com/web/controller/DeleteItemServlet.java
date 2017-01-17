package com.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.service.BusinessService;  
import com.service.BusinessServiceImpl;

public class DeleteItemServlet extends HttpServlet {

	//����������ߵķ����ӹ�������ɾ����Ҫɾ������  
    BusinessService service=new BusinessServiceImpl();  
  
    public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        //��ȡ��������  
        String sid=request.getParameter("NO");             
        service.deleteCartItem(sid);  
        request.getRequestDispatcher("/ListCartServlet").forward(request, response);  
  
    }  
  
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
        doGet(request, response);  
    }  

}
