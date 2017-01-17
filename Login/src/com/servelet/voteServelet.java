package com.servelet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.doMain;
public class voteServelet extends HttpServlet {                                                                                                                                                                                                                                                                    

	doMain dt=new doMain();
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] name=request.getParameterValues("song");
		/*String sid=request.getParameter("id");
		System.out.println(sid);*/
		int num = name.length;
		for(int i=0;i<num;i++){		
		dt.vote(name[i]);
		}
		request.getRequestDispatcher("/servlet/resultServelet1").forward(request, response);
		/*try {
			for(int i=0;i<num;i++){
				
           if(dt.vote(name[i])){
		request.getRequestDispatcher("result.jsp").forward(request, response);
	}else{
		request.getRequestDispatcher("false.jsp").forward(request, response);	}
    }
} catch (Exception e) {
}*/
		    
		}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	/*public static void main(String string[]){
		String[] name=request.getParameterValues("song");
		String sid=request.getParameter("id");
		System.out.println(sid);
		int num = name.length;
	}*/
}
