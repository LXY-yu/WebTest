package com.xt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.xt.dao.ProductDao;
import com.xt.pojo.Product;

public class ProManaServlet extends HttpServlet {

	private final String SAVAPATH="E://资源/WEB课程设计/HCproject/WebRoot/proimg"; 
	private final String SAVAPATH2="proimg/";
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String flag=request.getParameter("flag");
		if(flag.equals("add")){
			this.addPro(request,response);
		}else if(flag.equalsIgnoreCase("delete")){
			this.deletepro(request,response);
		}else if(flag.equals("update")){
			this.updatepro(request,response);
		}else if(flag.equals("select")||flag.equals("publishselect")||flag.equals("guanggaoselect")){
			this.selectpro(request,response);
		}else if(flag.equals("shangxian")){
			this.shangxianpro(request,response);
		}else if(flag.equals("xiaxian")){
			this.xiaxianpro(request, response);
		}
	}


	//上线产品
	public  void shangxianpro(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		ProductDao dao=new ProductDao();
		int id;
		boolean flag=false;
		String[] checkid=request.getParameterValues("checkid");
		for(int i=0;i<checkid.length;i++){
			id=Integer.parseInt(checkid[i]);
			flag=dao.shangxianpro(id);
		}
		if(flag){
			response.sendRedirect("web/productmana/publishpro.jsp");
		}
	}

	//下线产品
	public  void xiaxianpro(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		ProductDao dao=new ProductDao();
		int id;
		boolean flag=false;
		String[] checkid=request.getParameterValues("checkid");
		for(int i=0;i<checkid.length;i++){
			id=Integer.parseInt(checkid[i]);
			flag=dao.xiaxianpro(id);
		}
		if(flag){
			response.sendRedirect("web/productmana/publishpro.jsp");
		}
	}

	//查询商品
	public void selectpro(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String flag=request.getParameter("flag");
		String type=new String(request.getParameter("protype").getBytes("iso-8859-1"),"utf-8");
		String name=new String(request.getParameter("proname").getBytes("iso-8859-1"),"utf-8");
		String zhuangtai=request.getParameter("prozhuangtai");
		String sql="";
		if(type.length()!=0&&name.length()==0&&zhuangtai.length()==0){
			sql="select *from product where type='"+type+"'";
		}else if(type.length()==0&&name.length()!=0&&zhuangtai.length()==0){
			sql="select *from product where Pname='"+name+"'";
		}else if(type.length()==0&&name.length()==0&&zhuangtai.length()!=0){
			sql="select *from product where zhuangtai="+zhuangtai;
		}else if(type.length()!=0&&name.length()!=0&&zhuangtai.length()==0){
			sql="select *from product where Pname='"+name+"' and type='"+type+"'";
		}else if(type.length()!=0&&name.length()==0&&zhuangtai.length()!=0){
			sql="select *from product where type='"+type+"' and zhuangtai='"+zhuangtai+"'";
		}else if(type.length()==0&&name.length()!=0&&zhuangtai.length()!=0){
			sql="select *from product where Pname='"+name+"' and zhuangtai="+zhuangtai+"'";
		}else if(type.length()!=0&&name.length()!=0&&zhuangtai.length()!=0){
			sql="select *from product where Pname='"+name+"' and zhuangtai="+zhuangtai+" and type='"+type+"'";
		}else{
			sql="select *from product";
		}
		HttpSession session=request.getSession();
		session.setAttribute("sql", sql);
		if(flag.equals("select")){
		response.sendRedirect("web/productmana/selectpro.jsp");
		}else if(flag.equals("publishselect")){
			response.sendRedirect("web/productmana/selectpublishpro.jsp");
		}else if(flag.equals("guanggaoselect")){
			response.sendRedirect("web/gglanmana/selectinputpro.jsp");
		}
		
	}


	//编辑产品
	
	public void updatepro(HttpServletRequest request,
			HttpServletResponse response) throws ServletException {
		ProductDao dao=new ProductDao();
		SmartUpload su=new SmartUpload();
		su.initialize(this.getServletConfig(), request, response);
		//控制单个文件的上传大小(单位B)
		su.setMaxFileSize(1024*1024);
		//控制总文件上传大小
		su.setTotalMaxFileSize(1024*1024*10);
		try {
			su.upload();
			Request req=su.getRequest();
			System.out.println(req.getParameter("proid"));
			int id=Integer.parseInt(req.getParameter("proid"));
			String pname=new String(req.getParameter("proname").getBytes("gbk"),"utf-8");
			String type=new String(req.getParameter("protype").getBytes("gbk"),"utf-8");
			String price=new String(req.getParameter("proprice").getBytes("gbk"),"utf-8");
			String zhuangtai=req.getParameter("zhuangtai");
			String img=null;
			boolean flag=false;
			Files files=su.getFiles();
			for (int i = 0; i < files.getCount(); i++) {
					File file=files.getFile(i);
					 img=file.getFileName();
					file.saveAs(SAVAPATH+img);
					flag=dao.updatepro(new Product(id,type, pname, price, zhuangtai, SAVAPATH2+img));
					System.out.println(flag);
					if(flag){
						response.setCharacterEncoding("gbk");
						PrintWriter out=response.getWriter();
						out.print("编辑成功！！！");
					}
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		
	}
	}


	//删除商品
	public void deletepro(HttpServletRequest request,
			HttpServletResponse response) {
		ProductDao dao=new ProductDao();
		boolean flag=false;
		int id;
		String[]  checkid=request.getParameterValues("checkid");
		for(int i=0;i<checkid.length;i++){
			id=Integer.parseInt(checkid[i]);
			flag=dao.delpro(id);
		}
		if(flag){
			try {
				response.sendRedirect("web/productmana/productifo.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	//添加产品
	public void addPro(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		ProductDao dao=new ProductDao();
		SmartUpload su=new SmartUpload();
		su.initialize(this.getServletConfig(), request, response);
		//控制单个文件的上传大小(单位B)
		su.setMaxFileSize(1024*1024);
		//控制总文件上传大小
		su.setTotalMaxFileSize(1024*1024*10);
		try {
			su.upload();
			Request req=su.getRequest();
			String pname=new String(req.getParameter("proname").getBytes("gbk"),"utf-8");
			String type=new String(req.getParameter("protype").getBytes("gbk"),"utf-8");
			String price=new String(req.getParameter("proprice").getBytes("gbk"),"utf-8");
			String zhuangtai=req.getParameter("zhuangtai");
			String img=null;
			boolean flag=false;
			Files files=su.getFiles();
			for (int i = 0; i < files.getCount(); i++) {
					File file=files.getFile(i);
					 img=file.getFileName();
					file.saveAs(SAVAPATH+img);
					flag=dao.insertpro(new Product(type, pname, price, zhuangtai, SAVAPATH2+img));
					System.out.println(flag);
					if(flag){
						response.setCharacterEncoding("gbk");
						PrintWriter out=response.getWriter();
						out.print("添加成功！！！");
					}
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		
	}
	}
}
