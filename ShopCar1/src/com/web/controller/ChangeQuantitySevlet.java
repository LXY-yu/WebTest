package com.web.controller;

import java.io.IOException;
import com.service.BusinessService;  
import com.service.BusinessServiceImpl; 

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangeQuantitySevlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        String sid = request.getParameter("NO"); 
        double price=Double.parseDouble(request.getParameter("price"));
        String choice=request.getParameter("choice");
        int quantity = Integer.parseInt(request.getParameter("num"));  
          
        BusinessService service = new BusinessServiceImpl();  
        service.changeQuantity(choice,sid,price,quantity);  
          
        request.getRequestDispatcher("/ListCartServlet").forward(request, response);  
  
    }  
  
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
        doGet(request, response);  
    }  
}
