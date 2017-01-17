package com.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.Book;    
import com.service.BusinessServiceImpl;  

public class BuyServlet extends HttpServlet {

	BusinessServiceImpl service=new BusinessServiceImpl();  
    public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        //1.��ȡҪ�����  
        String sid=request.getParameter("NO");  
        Book book =service.findBook(sid);  
        //2.������ӵ����ﳵ��  
        service.addToCart(book);
        //response.sendRedirect("/ListCartServlet");  
        request.getRequestDispatcher("/ListCartServlet").forward(request, response);  
          
  
    }  
  
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
        doGet(request, response);  
    } 
    	
}
