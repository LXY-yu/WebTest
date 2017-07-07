package com.xt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xt.dao.QdUser;

public class UserManaServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
  this.doPost(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String flag=request.getParameter("flag");
		if(flag.equals("del")){
			this.del(request,response);
		}else if(flag.equals("shenhe")){
			this.shenhe(request,response);
		}
	}


	public void shenhe(HttpServletRequest request, HttpServletResponse response) {
		int id=Integer.parseInt(request.getParameter("id"));
		QdUser dao=new QdUser();
		if(dao.ShenHeUser(id)){
		try {
			response.setContentType("text/html;charset=GBK");
			PrintWriter out=response.getWriter();
			String str="审核成功！！";
			out.print(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		}
	}


	public void del(HttpServletRequest request, HttpServletResponse response) {
		int id=Integer.parseInt(request.getParameter("id"));
		QdUser dao=new QdUser();
		if(dao.delUser(id)){
			try {
				response.setContentType("text/html;charset=GBK");
				PrintWriter out=response.getWriter();
				String str="删除成功！！";
				out.print(str);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			}
	}

}
