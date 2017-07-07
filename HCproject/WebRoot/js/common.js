var flag=false;
function setsearchtr(obj){
	flag = !flag;
	if(flag){
		document.getElementById("mySearch").style.display="none";
		obj.src="../images/titletoonbtn.gif";
		obj.title="展开查询条";
	}else{
		document.getElementById("mySearch").style.display="";
		obj.src="../images/titletooffbtn.gif";
		obj.title="关闭查询条";
	}
}