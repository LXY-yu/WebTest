package com.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.service.BusinessService;  
import com.service.BusinessServiceImpl;

public class DeleteItemServlet extends HttpServlet {

	//调服务类里边的方法从购物项里删除想要删除的书  
    BusinessService service=new BusinessServiceImpl();  
  
    public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        //获取到购物项  
        String sid=request.getParameter("NO");             
        service.deleteCartItem(sid);  
        request.getRequestDispatcher("/ListCartServlet").forward(request, response);  
  
    }  
  
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
        doGet(request, response);  
    }  

}
