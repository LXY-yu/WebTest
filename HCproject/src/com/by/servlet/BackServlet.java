package com.by.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xt.dao.OrderDao;
import com.xt.dao.ProductDao;
import com.xt.pojo.Order;

public class BackServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OrderDao dao=new OrderDao();
		Order order=(Order)request.getSession().getAttribute("order");
		response.setContentType("text/html;charset=utf-8");
		/*
		 * �ױ����ṩһϵ�еĽ�����������ǻ�ȡ������Ҫ�ļ���
		 * ��ȡ֧�������r1_Code��1��ʾ֧���ɹ���
		 * ��ȡ֧����r3_Amt
		 * ��ȡ���̵Ķ����ţ�r6_Order
		 * ��ȡ����������ͣ�r9_BType��1��ʾ�ض��򷵻أ�2��ʾ��Ե㷵�أ�
		 *     ����Ե������ղ�������Ϊ���ǵ�ip���Ǿ�����ip��
		 */
		String r1_Code = request.getParameter("r1_Code");
		String r3_Amt = request.getParameter("r3_Amt");
		String r6_Order = request.getParameter("r6_Order");
		String r9_BType = request.getParameter("r9_BType");
		
		if(r1_Code.equals("1")) {
			if(r9_BType.equals("1")) {
				if(dao.zhifu(order.getOrderid())){
					response.sendRedirect("http://localhost:8888/HCproject/qd/shop/deal.jsp");
				}
				
				
			}
		}
	}
}
