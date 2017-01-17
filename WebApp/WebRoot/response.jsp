<%@page import="java.io.PrintWriter"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>
<%
out.println("<h1>response内置对象</h1>");
out.println("<hr>");
//out.flush();//使得out内置对象的输出先于response内置对象

PrintWriter outer=response.getWriter();//获得输出流对象
outer.println("大家好，我是response对象生成的输出流outer对象");//response对象输出的内容总是先于out内置对象打印，解决方法为out.flush()方法
//请求重定向
//response.sendRedirect("request.jsp");
//请求转发
request.getRequestDispatcher("request.jsp").forward(request, response);

%>