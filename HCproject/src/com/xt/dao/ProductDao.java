package com.xt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.xt.pojo.Advice;
import com.xt.pojo.Order;
import com.xt.pojo.Product;
import com.xt.pojo.Shop;
import com.xt.util.DButil;
import com.xt.util.Time;

public class ProductDao {

	public static Connection con=null;
	public static PreparedStatement ps=null;
	public static ResultSet rs=null;
	static{
		try {
			con=DButil.getCon();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//查询农产品表
	public List<Product> selproduct(){
		String sql="select *from product";
		List<Product> list=new ArrayList<Product>();
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				list.add(new Product(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	//查询农产品种类
	public List<String> selecttype(){
		String sql="select type from product group by type";
	List<String> typelist=new ArrayList<String>();
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				typelist.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return typelist;
	}
	
	//上线产品表里查询种类
	public List<String> selecttype1(String sql1){
		String sql="select type from ("+sql1+") as t group by type ";
	List<String> typelist=new ArrayList<String>();
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				typelist.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return typelist;
	}
	//根据选项查询农产品
	public List<Product> selecttype(String sql){
		Product pro=new Product();
		List<Product> list=new ArrayList<Product>();
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				pro.setId(rs.getInt(1));
				pro.setType(rs.getString(2));
				pro.setPname(rs.getString(3));
				pro.setPrice(rs.getString(4));
				pro.setZhuangtai(rs.getString(5));
				pro.setImg(rs.getString(6));
				list.add(pro);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 根据id查询农产品
	 * **/
	public Product selectone(int id){
		String sql="select *from product where id=?";
		Product pro=new Product();
		
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next()){
				pro.setId(rs.getInt(1));
				pro.setType(rs.getString(2));
				pro.setPname(rs.getString(3));
				pro.setPrice(rs.getString(4));
				pro.setZhuangtai(rs.getString(5));
				pro.setImg(rs.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pro;
	}
	
	
	//添加产品
	public boolean insertpro(Product pro){
		String sql="insert into product(type,Pname,price,zhuangtai,img) values(?,?,?,?,?)";
		boolean flag=false;
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, pro.getType());
			ps.setString(2, pro.getPname());
			ps.setString(3, pro.getPrice());
			ps.setString(4, pro.getZhuangtai());
			ps.setString(5, pro.getImg());
			int i=ps.executeUpdate();
			if(i==1){
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	//删除农产品
	
	public boolean delpro(int id){
			String sql="delete from product where id=?";
			boolean flag=false;
			try {
				ps=con.prepareStatement(sql);
				ps.setInt(1, id);
				int i=ps.executeUpdate();
				if(i==1){
					flag=true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		   return flag;
	}
	//分页
	/**
	 * 产品表记录数
	 * **/
	public int getrecordCount(){//产品表
		 int recordCount = 0;//一共有多少记录 
		String sqlCount = "select count(*) from product";//得到一共有多少条记录 
		try {
			ps=con.prepareStatement(sqlCount);
			rs=ps.executeQuery();
			if(rs.next()){
				recordCount=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return recordCount;
	}
	
	
	
	
	/**
	 * 子表记录数
	 * **/
	public int getrecordCount1(String sql){
		 int recordCount = 0;//一共有多少记录 
		String sqlCount = "select count(*) from ("+sql+") as procount";//得到一共有多少条记录 
		try {
			ps=con.prepareStatement(sqlCount);
			rs=ps.executeQuery();
			if(rs.next()){
				recordCount=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return recordCount;
	}
	
	/**
	 * 反馈表记录数
	 * **/
	public int getrecordCount2(){//产品表
		 int recordCount = 0;//一共有多少记录 
		String sqlCount = "select count(*) from t_advice";//得到一共有多少条记录 
		try {
			ps=con.prepareStatement(sqlCount);
			rs=ps.executeQuery();
			if(rs.next()){
				recordCount=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return recordCount;
	}
	
	/**
	 * 根據userName查询收藏表数据量
	 * @return
	 */
	public int getrecordCount3(String userName){//产品表
		 int recordCount = 0;//一共有多少记录 
		String sqlCount = "select count(*) from collection where username=?";//得到一共有多少条记录 
		try {
			ps=con.prepareStatement(sqlCount);
			ps.setString(1, userName);
			rs=ps.executeQuery();
			if(rs.next()){
				recordCount=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return recordCount;
	}
	/**
	 * 商品表每页显示的产品
	 * **/
	public List<Product> limproduct(int fromIndex,int pageSize){
		String sql="select * from product limit ?,?";
		List<Product> list=new ArrayList<Product>();
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, fromIndex);
			ps.setInt(2, pageSize);
			rs=ps.executeQuery();
			while(rs.next()){
				list.add(new Product(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	/**
	 * 模糊查询商品表时每页显示的产品
	 * **/
	public List<Product> limproduct1(int fromIndex,int pageSize,String sql){
		String sql1="select * from ("+sql+") as typetable limit ?,?";
		List<Product> list=new ArrayList<Product>();
		try {
			ps=con.prepareStatement(sql1);
			ps.setInt(1, fromIndex);
			ps.setInt(2, pageSize);
			rs=ps.executeQuery();
			while(rs.next()){
				list.add(new Product(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	/**
	 * 已上线商品表每页显示的产品
	 * **/
	public List<Product> limproduct2(int fromIndex,int pageSize){
		String sql1="select * from product where zhuangtai='1' limit ?,?";
		List<Product> list=new ArrayList<Product>();
		try {
			ps=con.prepareStatement(sql1);
			ps.setInt(1, fromIndex);
			ps.setInt(2, pageSize);
			rs=ps.executeQuery();
			while(rs.next()){
				list.add(new Product(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	/**
	 * 根据username收藏表
	 * **/
	public List<String> limproduct4(int fromIndex,int pageSize,String username){
		String sql1="select projectid from collection where username=?  limit ?,?";
		List<String> colleid=new ArrayList<String>();
		try {
			ps=con.prepareStatement(sql1);
			ps.setString(1, username);
			ps.setInt(2, fromIndex);
			ps.setInt(3,pageSize );
			rs=ps.executeQuery();
			while(rs.next()){
				colleid.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return colleid;
	}
	
	/**
	 * 反馈表每页显示的产品
	 * **/
	public List<Advice> limproduct3(int fromIndex,int pageSize){
		String sql="select * from t_advice limit ?,?";
		List<Advice> list=new ArrayList<Advice>();
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, fromIndex);
			ps.setInt(2, pageSize);
			rs=ps.executeQuery();
			while(rs.next()){
				list.add(new Advice(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	//编辑产品
	public boolean updatepro(Product product) {
		boolean flag=false;
		String sql="update product set type=?,Pname=?,price=?,zhuangtai=?,img=? where id=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, product.getType());
			ps.setString(2, product.getPname());
			ps.setString(3, product.getPrice());
			ps.setString(4, product.getZhuangtai());
			ps.setString(5, product.getImg());
			ps.setInt(6, product.getId());
			if(ps.executeUpdate()==1){
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	//上线产品
	public boolean shangxianpro(int id){
		String sql="update product set zhuangtai=1 where id=?";
		boolean flag=false;
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			if(ps.executeUpdate()==1){
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	//下线产品
	public boolean xiaxianpro(int id){
		String sql="update product set zhuangtai=2 where id=?";
		boolean flag=false;
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			if(ps.executeUpdate()==1){
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	//添加商品到购物车表
	public boolean insertshop(Shop shop){
		String sql="insert into shop(username,id,pname,price,count,img) values(?,?,?,?,?,?)";
		boolean flag=false;
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, shop.getUsername());
			ps.setInt(2,shop.getId());
			ps.setString(3, shop.getPname());
			ps.setString(4, shop.getPrice());
			ps.setInt(5, shop.getCount());
			ps.setString(6, shop.getImg());
			int i=ps.executeUpdate();
			if(i==1){
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	//查询购物表
	public List<Shop> selshop(){
		String sql="select *from shop";
		List<Shop> list=new ArrayList<Shop>();
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				list.add(new Shop(rs.getInt(1),rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6),rs.getString(7)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	//根据id查产品图片信息
	public String selproimg(int id){
		String sql="select img from product where id=?";
		String img="";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next()){
				img=rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return img;
	}
	
	//根据id查产品name信息
	public String selproname(int id){
		String sql="select Pname from product where id=?";
		String pname="";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next()){
				pname=rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pname;
	}
	
	//根据id查产品单价信息
	public double selproprice(int id){
		String sql="select price from product where id=?";
		double price=0;
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next()){
				price=rs.getDouble(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return price;
	}
	//根据id购物表数量
	public int selprocount(int id){
		String sql="select count from shop where id=?";
		int count=1;
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next()){
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}
	//数量加1
	public boolean addone(int id) {
		int count=selprocount(id)+1;
		boolean flag=false;
		String sql="update shop set count=? where id=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, count);
			ps.setInt(2, id);
			if(ps.executeUpdate()==1){
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	//数量减1
	public boolean jianone(int id) {
		int count=selprocount(id)-1;
		System.out.println(count);
		if(count<=0){
			count=1;
		}
		System.out.println(count);
		boolean flag=false;
		String sql="update shop set count=? where id=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, count);
			ps.setInt(2, id);
			if(ps.executeUpdate()==1){
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	//计算购物表商品总额
	public int  CountShop(){
		String sql="select *from shop";
		int icount=0;
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				icount=icount+rs.getInt("price")*rs.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return icount;
	}
	//根据商品id删除一条购物车数据
	public boolean  deleteoneshop(int shopid){
		String sql="delete from shop where id=?";
		boolean flag=false;
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1,shopid);
			int i=ps.executeUpdate();
			System.out.println(i);
			if(i==1){
				flag=true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	//删除购物表
	public void deleteShop(){
		String sql="truncate  shop";
		try {
			ps=con.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//根据username找地址
	public String seladdress(String username){
		String sql="select address from t_address where username=?";
		String address="";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, username);
			rs=ps.executeQuery();
			if(rs.next()){
				address=rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return address;
	}
	//插入订单
	public boolean insertoder(String totalprice,String username){
		String sql="insert into t_order(username,totalprice,address,zhuangtai) values(?,?,?,?)";
		String address=seladdress(username);
		boolean flag=false;
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1,username);
			ps.setString(2, totalprice);
			ps.setString(3, address);
			ps.setString(4, "2");
			int i=ps.executeUpdate();
			if(i==1){
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	
	
	
	//购物表是否存在该商品
	public boolean IfShop(int id,String username){
		String sql="select *from shop where id=? and username=?";
		boolean flag=false;
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, username);
			rs=ps.executeQuery();
			if(rs.next()){
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	//插入数据到建议表
	public void insertadvice(String username,String advice){
		String sql="insert into t_advice(username,content,time) values(?,?,?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, advice);
			ps.setString(3, Time.getDate());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//查找建议表
	public List<Advice> selectadvice(String username){
		String sql="select *from t_advice where username=?";
		List<Advice> list=new ArrayList<Advice>();
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, username);
			rs=ps.executeQuery();
			while(rs.next()){
				list.add(new Advice(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//查找回复内容
	public String selecthuifu(int adviceid){
		String sql="select huifu from t_advice where adviceid=?";
		String content=null;
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, adviceid);
			rs=ps.executeQuery();
			if(rs.next()){
				content=rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return content;
	}
	//插入回复内容
	public boolean huifu(int adviceid,String content){
		String sql="update t_advice set huifu=? where adviceid=?";
		boolean flag=false;
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, content);
			ps.setInt(2, adviceid);
			if(ps.executeUpdate()==1){
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	/**
	 * 插入收藏表
	 * **/
	public boolean addCollect(String username, int id, String time) {
		System.out.println(time);
		String sql = "insert into collection(username,projectid,time) values(?,?,?)";
		boolean flag = false;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setInt(2, id);
			ps.setString(3, time);
			int i = ps.executeUpdate();
			if (i == 1) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	/**
	 * 删除收藏表
	 * **/
	public boolean removeCollect(String id) {
		String sql="delete from collection where projectid=?";
		boolean flag = false;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			int i = ps.executeUpdate();
			if (i == 1) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
}
