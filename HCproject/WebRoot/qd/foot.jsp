<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>底部版权信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="qdcss/common.css" rel="stylesheet" type="text/css" />
	<link href="qdcss/index.css" rel="stylesheet" type="text/css" />

  </head>
  
  <body>
   <!--帮助-->
<div class="help">
  <div class="helpBox">
    <div class="help1">
      <h2>业务帮助</h2>
      <ul>
        <li><a href="#">市场合作</a></li>
        <li><a href="#">商户加盟</a></li>
        <li><a href="#">友情链接</a></li>
        <li><a href="#">了解商盟</a></li>
        <li><a href="#">优先商户</a></li>
      </ul>
    </div>
    <div class="help2">
      <h2>新手上路</h2>
      <ul>
        <li><a href="#">市场合作</a></li>
        <li><a href="#">商户加盟</a></li>
        <li><a href="#">友情链接</a></li>
        <li><a href="#">了解商盟</a></li>
        <li><a href="#">优先商户</a></li>
      </ul>
    </div>
    <div class="help3">
      <h2>商家加盟</h2>
      <ul class="lost">
        <li><a href="#">市场合作</a></li>
        <li><a href="#">商户加盟</a></li>
        <li><a href="#">友情链接</a></li>
        <li><a href="#">了解商盟</a></li>
        <li><a href="#">优先商户</a></li>
      </ul>
    </div>
  </div>
</div>
<!--帮助 end--> 

<!--底部版权-->
<div class="foot">
  <p> <a href="#">法律声明</a>| <a href="#">帮助信息</a>| <a href="#">联系我们</a>| <a href="#">网站地图</a></p>
  <p>中国移动通信有限公司 版权所有</p>
</div>

<!--底部版权-->
  </body>
</html>
