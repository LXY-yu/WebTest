package com.servelet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.SongBean;
import com.dao.doMain;

public class resultServelet1 extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doMain dt=new doMain();
		try {
			ArrayList<SongBean> list=dt.result(); 
            System.out.println(list.get(0).getSongName());
            request.setAttribute("list", list);  
            request.getRequestDispatcher("/result.jsp").forward(request, response); 
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
              
	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}



}
