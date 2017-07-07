package com.by.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xt.util.PaymentUtil;


public class BuyServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String p0_Cmd = "Buy";// ҵ�����ͣ��̶�ֵΪbuy��������
		String p1_MerId = "10001126856";// ���ױ�ע����̺�
		String p2_Order = request.getParameter("p2_Order");// �������
		String p3_Amt = request.getParameter("p3_Amt");// ֧���Ľ��
		String p4_Cur = "CNY";// �����ֱң��̶�ֵΪCNY����ʾ�����
		String p5_Pid = "";// ��Ʒ����
		String p6_Pcat = "";// ��Ʒ����
		String p7_Pdesc = "";// ��Ʒ����
		String p8_Url = "http://localhost:8888/HCproject/BackServlet";// ���̵ķ���ҳ�棬��֧���ɹ����ױ����ض������ҳ��
		String p9_SAF = "";// �ͻ���ַ
		String pa_MP = "";// ��Ʒ��չ��Ϣ
		String pd_FrpId = request.getParameter("pd_FrpId");// ֧��ͨ������ѡ������
		String pr_NeedResponse = "1";// Ӧ����ƣ��̶�ֵΪ1

		// ��Կ�����ױ��ṩ��ֻ���̻����ױ�֪�������Կ��
		String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl";

		// ͨ������Ĳ�������Կ�������㷨������hmacֵ
		// ������˳���Ǳ���ģ����û��ֵҲ���ܸ���null����Ӧ�ø������ַ�����
		String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt,
				p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP,
				pd_FrpId, pr_NeedResponse, keyValue);
		
		// �����в������ӵ����ص�ַ����
		String url = "https://www.yeepay.com/app-merchant-proxy/node";
		url += "?p0_Cmd=" + p0_Cmd + 
				"&p1_MerId=" + p1_MerId +
				"&p2_Order=" + p2_Order + 
				"&p3_Amt=" + p3_Amt + 
				"&p4_Cur=" + p4_Cur + 
				"&p5_Pid=" + p5_Pid + 
				"&p6_Pcat=" + p6_Pcat + 
				"&p7_Pdesc=" + p7_Pdesc + 
				"&p8_Url=" + p8_Url + 
				"&p9_SAF=" + p9_SAF + 
				"&pa_MP=" + pa_MP + 
				"&pd_FrpId=" + pd_FrpId + 
				"&pr_NeedResponse=" + pr_NeedResponse + 
				"&hmac=" + hmac;
//		System.out.println(url);
		// �ض�������
		response.sendRedirect(url);
	}
}
