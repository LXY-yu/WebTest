package com.xt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.xt.dao.OrderDao;
import com.xt.dao.ProductDao;
import com.xt.pojo.Product;
import com.xt.pojo.Shop;

public class QdProManaServlet extends HttpServlet {

	private final String SAVAPATH="D://Myeclipse/workspace/HCproject/WebRoot/proimg/"; 
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
		}else if(flag.equals("goumai")){
			this.goumai(request,response);
		}else if(flag.equals("jia")){
			this.jia(request,response);
		}else if(flag.equals("jian")){
			this.jian(request,response);
		}else if(flag.equals("order")){
			this.addorder(request,response);
		}else if(flag.equals("pay")){
			this.updatezhuangtai(request,response);
		}else if(flag.equals("shopcardelete")){
			this.shopcardelete(request,response);
		}else if(flag.equals("advice")){
			this.useradvice(request,response);
		}else if(flag.equals("huifu")){
			this.huifuadvice(request,response);
		}else if(flag.equals("collect")){
			this.addCollect(request, response);
		}else if(flag.equals("yichu")){
			this.removeCollect(request, response);
		}
	}

	public void removeCollect(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		ProductDao dao = new ProductDao();
		String proid = request.getParameter("id");
		boolean flag = dao.removeCollect(proid);

		if (flag) {
			response.sendRedirect("qd/user/mycollection.jsp");
		}
		
	}


	/**
	 * 添加收藏方法
	 * **/
	public void addCollect(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		ProductDao dao = new ProductDao();
		String proid = request.getParameter("id");
		String username = (String) request.getSession().getAttribute("qduser");
		System.out.println(username);
		SimpleDateFormat dateformat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		String time = dateformat.format(new Date());
		boolean flag = dao.addCollect(username, Integer.valueOf(proid), time);

		if (flag) {
			// System.out.println("收藏成功");
			response.sendRedirect("qd/product/proindex.jsp");
		}
	}
	public void huifuadvice(HttpServletRequest request,
			HttpServletResponse response) {
		ProductDao dao=new ProductDao();
		int adviceid=Integer.parseInt(request.getParameter("adviceid"));
		
		try {
			String content = new String(request.getParameter("huifucontent").getBytes("iso-8859-1"),"utf-8");
			if(dao.huifu(adviceid, content)){
				response.sendRedirect("web/advicemana/deal.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public  void useradvice(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		ProductDao dao=new ProductDao();
		String advice=request.getParameter("advice");
		String username=(String)request.getSession().getAttribute("qduser");
		dao.insertadvice(username, new String(advice.getBytes("iso-8859-1"),"utf-8"));
		request.setAttribute("advicemsg", "反馈成功！等待管理员审核！！");
		request.getRequestDispatcher("qd/advice/advice.jsp").forward(request, response);
	}


	//购物表
	public  void shopcardelete(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		ProductDao dao=new ProductDao();
		int shopid=Integer.parseInt(request.getParameter("shopid"));
		System.out.println(shopid);
		boolean flag=dao.deleteoneshop(shopid);
		System.out.println(flag);
		if(flag){
			response.sendRedirect("qd/shop/myshopinfo.jsp");
		}
	}


	//切换订单表状态
	public void updatezhuangtai(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		OrderDao dao=new OrderDao();
		String  id=request.getParameter("oid");
		if(dao.zhifu(id)){
			request.getRequestDispatcher("BuyServlet").forward(request, response);
		}
	}


	//生成订单
	public void addorder(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		ProductDao dao1=new ProductDao();
		OrderDao dao=new OrderDao();
		List<Shop> shoplist=(List<Shop>)request.getSession().getAttribute("shoplist");
		String totalprice=request.getParameter("totalprice");
		String username=(String)request.getSession().getAttribute("qduser");
		String address=new String(request.getParameter("address").getBytes("iso-8859-1"),"utf-8");
		String orderid=UUID.randomUUID().toString().replace("-", "");
		boolean flag=dao.addOrder(orderid,username, shoplist, address, totalprice);
		dao1.deleteShop();
		System.out.println(username);
		System.out.println(flag);
		if(flag){
			response.sendRedirect("qd/shop/ordersuccess.jsp?orderid="+orderid);
		}
	}


	

	
	public void jian(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ProductDao dao=new ProductDao();
		int id=Integer.parseInt(request.getParameter("id"));
		boolean flag=dao.jianone(id);
		System.out.println(flag);
		if(flag){
			response.sendRedirect("qd/shop/myshopinfo.jsp");
		}
		
	}


	public void jia(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		ProductDao dao=new ProductDao();
		boolean flag=dao.addone(id);
		System.out.println(flag);
		if(flag){
			response.sendRedirect("qd/shop/myshopinfo.jsp");
		}
		
	}


	//购买商品，添加到购物车表中
	public void goumai(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ProductDao dao=new ProductDao();
		String id=request.getParameter("id");
		String username=(String)request.getSession().getAttribute("qduser");
		if(dao.IfShop(Integer.parseInt(id), username)){
			request.setAttribute("shopmsg", "1111");
			request.getRequestDispatcher("qd/product/proindex.jsp").forward(request, response);		
			}else{
			Product pro=dao.selectone(Integer.parseInt(id));
			boolean flag=dao.insertshop(new Shop(username,Integer.parseInt(id), pro.getPname(), pro.getPrice(), 1,pro.getImg()));
			if(flag){
				response.sendRedirect("qd/shop/myshopinfo.jsp");
			}
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
		String sql="";
		if(type.length()!=0&&name.length()==0){
			sql="select *from product where type='"+type+"' and zhuangtai='1'";
		}else if(type.length()==0&&name.length()==0){
			sql="select *from product where zhuangtai='1'";
		}else if(type.length()!=0&&name.length()!=0){
			sql="select *from product where zhuangtai='1' and Pname='"+name+"' and type='"+type+"'";
		}else if(type.length()==0&&name.length()!=0){
			sql="select *from product where Pname='"+name+"' and zhuangtai='1'";
		}
		HttpSession session=request.getSession();
		session.setAttribute("sql", sql);
		if(flag.equals("select")){
		response.sendRedirect("qd/product/selectproindex.jsp");
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
