<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
  <title>投票系统</title>
</head>

<body>

<form action="voteServelet"  method="get">
<table border="1" align="center">
<tr align="center">
<td><h2>选择您最希望华晨宇在演唱会上唱的安可曲并投上一票</h2></td>
</tr>
<tr>
<td><input type="checkbox" name="song" value="wnf" />Why Nobody Fights</td>
</tr>
<tr>
<td><input type="checkbox" name="song" value="小烟" />烟火里的尘埃</td>
</tr>
<tr>
<td><input type="checkbox" name="song" value="forever" />For Forever</td>
</tr>
<tr>
<td><input type="checkbox" name="song" value="国企" />国王与乞丐</td>
</tr>
<tr>
<td align="center">
<input type="submit" value=" 提交 " />
<input type="reset" value=" 重置 " />
</td>
</tr>
</table>
</form> 
</body>  
</html>  
