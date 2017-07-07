/*author kongge*/
function KongGe_cs(){
KongGe_cs.prototype={
getElem:function(id){
if(document.getElementById(id)){
return document.getElementById(id);           
}else{
return null;
},
hide:function(elem){
var curDisplay=getStyle(elem,'display');
if(curDisplay!='none'){
elem.soldDisplay=curDisplay;
elem.style.display='none';
show:function(elem){
elem.style.display=elem.soldDisplay||'';
getStyle:function(elem,name){
if(elem.currentStyle){
return elem.currentStyle[name];
}else
if(document.defaultView && document.defaultView.getComputedStyle){  
name=name.replace(/([A-Z])/g,"-$1");
name=name.toLowerCase();
var s=document.defaultView.getComputedStyle(elem,"");
return s && s.getPropertyValue(name);
}else{
return null;
},
getHeight:function(elem){
return parseInt(this.getStyle(elem,'height'));
fullHeight:function(elem){
if(this.getStyle(elem,'display')!='none'){
return elem.offsetHeight||this.getHeight(elem);
var h=elem.clientHeight||this.getHeight(elem);
return h;
setOpacity:function(elem,level){
if(elem.filters){
elem.style.filter='alpha(opacity='+level+')';
}else{
elem.style.opacity=level/100;
},
slider:function(elem){
var h=this.fullHeight(elem);
elem.style.height='0px';
this.show(elem);
for(var i=0;i<=100;i+=5){
(function(){var pos=i;setTimeout(function(){elem.style.height=(pos/100)*h+"px";},(pos+1)*10);})();
},
fadeIn:function (elem){
this.setOpacity(elem,0);
this.show(elem);
var instance=this.instance;
for(var i=0;i<=100;i+=5){
(function(){var pos =i;setTimeout(function(){kg_cs.setOpacity(elem,pos);},(pos+1)*10);})();
},
scrollY:function(){
var de=document.documentElement;
return self.pageYOffset||(de && de.scrollTop)||document.body.scrollTop;
} var kg_cs=new KongGe_cs();
function FloatDiv(id,top,instance){
this.top=top;
this.old=this.top;
this.instance=instance;
this.id=id;
this.right=0;
this.init();
FloatDiv.prototype={
init:function(){
kg_cs.getElem(this.id).style.right=this.right+"px";
kg_cs.getElem(this.id).style.top=this.top+"px";
this.move();
move:function(){
var timer=50;
var pos=0;
pos=kg_cs.scrollY();
pos=pos-kg_cs.getElem(this.id).offsetTop+this.top;
pos=kg_cs.getElem(this.id).offsetTop+pos/10;
if(pos<this.top){
pos=this.top;
if(pos!=this.old){
kg_cs.getElem(this.id).style.top=pos+"px";
timer=10;
this.old=pos;
setTimeout(this.instance+".move()",timer);
floatLeft:function(){
kg_cs.getElem(this.id).style.right="auto";
kg_cs.getElem(this.id).style.left="0";
}