package com.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.Book;
import com.domain.CartItem;
import com.service.BusinessService;
import com.service.BusinessServiceImpl;

public class ListCartServlet extends HttpServlet {

	/*public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        request.getRequestDispatcher("/WEB-INF/jsp/listcart.jsp").forward(request, response);  
    }  
  
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
        doGet(request, response);  
    }*/
	
	 BusinessService service=new BusinessServiceImpl();  
	    public void doGet(HttpServletRequest request, HttpServletResponse response)  
	            throws ServletException, IOException {  
	          
	    	try {
	            List<CartItem> list=service.getCart();  
	            request.setAttribute("list", list);  
	            request.getRequestDispatcher("/WEB-INF/jsp/listcart.jsp").forward(request, response); 
	    	} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	              
	    }  
	  
	    public void doPost(HttpServletRequest request, HttpServletResponse response)  
	            throws ServletException, IOException {  
	  
	        doGet(request, response);  
	    }  
	    
	   /* public static void main(String args[]){
	    	BusinessService service=new BusinessServiceImpl();
	    
	            List<CartItem> list=service.getCart();
	            System.out.println(list.get(0).getQuantity());
	    }*/
}
