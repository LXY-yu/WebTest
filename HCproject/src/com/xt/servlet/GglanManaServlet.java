             package com.xt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xt.dao.GgaoDao;
import com.xt.dao.ProductDao;

public class GglanManaServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		this.doPost(request, response);

	}



	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		String flag=request.getParameter("flag");
		if(flag.equals("tuisong")){
			this.tuisongPro(request,response);
		}else if(flag.equals("downtuisong")){
			this.downtuisongPro(request,response);
		}

	}



	public void downtuisongPro(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		

		GgaoDao dao=new GgaoDao();
		String gmsg;
		
		String[] checkid=request.getParameterValues("checkid");
		for(int i=0;i<checkid.length;i++){
			dao.downggao(Integer.parseInt(checkid[i]));
			
		}
			gmsg="取消成功！！";
			request.setAttribute("gmsg", gmsg);
			request.getRequestDispatcher("web/gglanmana/readyinput.jsp").forward(request, response);
	}



	public void tuisongPro(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		
		GgaoDao dao=new GgaoDao();
		String gmsg;
		int ggcount=dao.selectcount();
		int proid;
		String[] checkid=request.getParameterValues("checkid");
		for(int i=0;i<checkid.length;i++){
			proid=Integer.parseInt(checkid[i]);
			if(!dao.selectone(proid)){
				dao.insertggao(proid);
			}
		}
		if(ggcount+checkid.length>5){
			gmsg="推送数量超出上线";
			request.setAttribute("gmsg", gmsg);
			request.getRequestDispatcher("web/gglanmana/proinput.jsp").forward(request, response);
		}else{
			for (int i = 0; i < checkid.length; i++) {
				proid=Integer.parseInt(checkid[i]);
				dao.upggao(proid);
			}
			gmsg="推送成功！！";
			request.setAttribute("gmsg", gmsg);
			request.getRequestDispatcher("web/gglanmana/proinput.jsp").forward(request, response);
		}
		
		
	}
	}


