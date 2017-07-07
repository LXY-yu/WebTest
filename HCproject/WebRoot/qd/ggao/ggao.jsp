<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.xt.dao.GgaoDao"%>
<%@page import="com.xt.dao.ProductDao"%>
<%@page import="com.xt.pojo.Product"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>首页广告栏</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="qdcss/common.css" rel="stylesheet" type="text/css" />
  <link href="qdcss/index.css" rel="stylesheet" type="text/css" />

<style type="text/css">
.tag_box { width:430px; height:126px; border:1px solid #B0BEC7; font:12px Arial, Helvetica, sans-serif; margin-top:0; overflow:hidden}
.tag_box ul.menulist { width:402px; height:20px; overflow:hidden; margin:0}
.tag_box ul.menulist li { float:left; width:80px; text-align:center; height:19px; line-height:19px; background:url(tag_bg1.gif) repeat-x; position:relative; list-style-type:none}
.tag_box ul.menulist li a { color:#18397C; text-decoration:none; display:block; width:80px; background:url(tag_pipe.gif) no-repeat right 1px; border-bottom:1px solid #93A6B4;}
.tag_box ul.menulist li a:hover { text-decoration:underline;}
.tag_box ul.menulist li a.curMenu { background:url(tag_bg2.gif) repeat-x; border:1px solid #91A7B4; border-bottom:none; width:81px; position:absolute; color:#c63; font-weight:bold; left:-1px;top:-1px; height:21px; z-index:100}
.tag_box a.nonebg{ background:none;}
.tag_content { padding:6px; clear:both}
.tag_content img.bigConImg {border:1px solid #788a98; display:block; float:left}
.tag_content h5 {padding:2px 0px; margin:3px 6px; float:left; text-align:center; width:250px; background-color:#f7f7f7}
.tag_content a {text-decoration:none; color:#16387c}
.tag_content a:hover {text-decoration:underline;}
.tag_content p { margin:0; padding:2px 6px; float:left; line-height:18px}
.tag_content ul { margin:0px 3px 0px 3px; padding:0; float:left;}
.tag_content li { margin-left:20px; margin-bottom:3px}
</style>
<SCRIPT LANGUAGE="JavaScript">

        var currentTag = 1;
function fivetag(obj,id){
        selectMenu(obj);
        for (var i =1,j; j=document.getElementById("tag_content_"+i); i++){
                j.style.display="none";
        }
        document.getElementById("tag_content_"+id).style.display="block";
        currentTag++;
        if (currentTag>5)
        currentTag=1;
}
function selectMenu(obj){
        var lia = document.getElementById("menulist").getElementsByTagName("li");
        var lialen = lia.length;
        for(i=0; i<lialen; i++){
                if(lia[i].getElementsByTagName("a")[0].className=="curMenu")
                lia[i].getElementsByTagName("a")[0].className = "";
        }
        obj.className = "curMenu";
}
function init(){
        var menulist = document.getElementById("menulist");
        setInterval('fivetag(menulist.getElementsByTagName("li")[currentTag-1].getElementsByTagName("a")[0],currentTag)',2000);
}

function loginout(){
  if(confirm("您确定退出？")){
  	window.parent.location.href="http://localhost:8080/HCproject/qdlogin.jsp";
  }
}
</SCRIPT>
  </head>
  
  <body onLoad="init()">
  <% 
	int index=2;
 GgaoDao dao=new GgaoDao();
		ProductDao prodao=new ProductDao();
	  int[] proid=dao.selectggid();
		    List<Product> prolist=new ArrayList<Product>();
		    for(int i=0;i<proid.length;i++){
		    	prolist.add(prodao.selectone(proid[i]));
		    }
		    session.setAttribute("readyprolist",prolist);
	 %>
	 
	<!--最顶灰色工具条 start-->  
  <div class="toolBar">
  <div class="toolBox">
    <ul class="welcome">
      <li>您好，欢迎来到移动商盟！</li>
      <li class="fd">${qduser}</li>
    </ul>
    <ul class="topnav">
      <li><a href="qd/product/proindex.jsp">首页</a></li>
      <li><a href="javascript:void(0)">我的商盟</a></li>
      <li><a href="javascript:void(0)">邀请好友</a></li>
      <li><a href="javascript:void(0)">使用帮助</a></li>
      <li class="fd">【<a href="javascript:void(0)" onclick="loginout()">退出登录</a>】</li>
    </ul>
  </div>
</div>
<!--最顶灰色工具条 end--> 
<!--长广告-->
<div class="longBanner mt5 " style="margin-top: 0;border: 1px solid red;background-color: yellow">
	<table width="430" height="110" border="1" align="center" >
  <tr style="width: 100px;" >
    <td width="800" height="148">
    <div class="tag_box" id="tag_menu" >
		<ul class="menulist" id="menulist">
		 
		<c:forEach var="prode" items="${readyprolist}" varStatus="no">
		<c:if test="${no.count==1}">
		<li><a href="javascript:void(0)" onClick="fivetag(this,1)" onFocus="this.blur()" class="curMenu">每日特价</a></li>
		</c:if>
		<c:if test="${no.count!=1}">
		<li><a href="javascript:void(0)" onClick="fivetag(this,${no.count})" onFocus="this.blur()">${prode.type}</a></li>
		</c:if>
		
		</c:forEach>
		</ul>
		<c:forEach var="prod" items="${readyprolist}" varStatus="no">
		<div id="tag_content_${no.count}" class="tag_content">
                <img src="${prod.img}" width="100px" height="100px" class="bigConImg">
                <h5><a href="#">${prod.pname}</a></h5>
                 <ul>
                        <li>时令${prod.type} </li>
                        <li>商品编号：${prod.id} </li>
                        <li> 售价：￥${prod.price} </li>
                </ul>
        </div>
		</c:forEach>
                </div>                    
 
</td>
  </tr>
</table>
</div>
  </body>
</html>
