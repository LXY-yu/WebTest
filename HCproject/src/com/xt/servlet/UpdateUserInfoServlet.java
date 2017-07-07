package com.xt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xt.dao.UserDao;
import com.xt.pojo.Admin;
import com.xt.pojo.User;

public class UpdateUserInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String tag = request.getParameter("tag");

		UserDao dao = new UserDao();
		User user = new User();
		String loginname = (String) request.getSession().getAttribute("qduser");

		System.out.println(tag + "---");
		if ("userinfo".equals(tag)) {// �����û�������Ϣ
			String username = request.getParameter("username");
			String tel = request.getParameter("tel");
			String email = request.getParameter("email");
			String address = request.getParameter("address");

			user.setLoginname(username);
			user.setTel(tel);
			user.setEmail(email);
			boolean updateUserInfo = dao.updateUserInfo(user);
			boolean updateAddress = dao.updateAddress(username, address);
			if (updateUserInfo && updateAddress) {
				request.getSession().setAttribute("msg", "���³ɹ���");
				System.out.println("----------���³ɹ�");
				response.sendRedirect("qd/user/userinfo.jsp");
			} else {
				// ����ʧ��
				request.getSession().setAttribute("msg", "����ʧ�� �Ժ����ԣ�");
				response.sendRedirect("qd/user/userinfo.jsp");
			}
		} else if ("address".equals(tag)) {// ���µ�ַ
			// System.out.println(address);

			String newAddress = request.getParameter("address");
			boolean updateAddress = dao.updateAddress(loginname, newAddress);
			System.out.println(updateAddress);
			if (updateAddress) {
				request.getSession().setAttribute("msg", "���³ɹ���");
				response.sendRedirect("qd/user/address.jsp");
			} else {
				request.getSession().setAttribute("msg", "����ʧ�ܣ�");
				response.sendRedirect("qd/user/address.jsp");
			}
		} else if ("password".equals(tag)) {// ��������
			String password = request.getParameter("password");
			String oldPass = request.getParameter("oldPass");
			boolean flag = false;
			boolean checkUser = dao.checkPass(loginname, oldPass);
			if (checkUser) {
				boolean updatePwd = dao.updateUserPass(loginname, password);
				// System.out.println("ԭ������ȷ");
				if (updatePwd) {
					request.getSession().setAttribute("msg", "���³ɹ���");
					response.sendRedirect("qd/user/password.jsp");
					flag = true;
				}
			}

			if (!flag) {
				request.getSession().setAttribute("msg", "����ʧ�ܣ�");
				response.sendRedirect("qd/user/password.jsp");
			}
		}

	}
}
