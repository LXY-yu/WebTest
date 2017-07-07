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
	//��ѯũ��Ʒ��
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
	
	//��ѯũ��Ʒ����
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
	
	//���߲�Ʒ�����ѯ����
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
	//����ѡ���ѯũ��Ʒ
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
	 * ����id��ѯũ��Ʒ
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
	
	
	//��Ӳ�Ʒ
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
	
	//ɾ��ũ��Ʒ
	
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
	//��ҳ
	/**
	 * ��Ʒ���¼��
	 * **/
	public int getrecordCount(){//��Ʒ��
		 int recordCount = 0;//һ���ж��ټ�¼ 
		String sqlCount = "select count(*) from product";//�õ�һ���ж�������¼ 
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
	 * �ӱ��¼��
	 * **/
	public int getrecordCount1(String sql){
		 int recordCount = 0;//һ���ж��ټ�¼ 
		String sqlCount = "select count(*) from ("+sql+") as procount";//�õ�һ���ж�������¼ 
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
	 * �������¼��
	 * **/
	public int getrecordCount2(){//��Ʒ��
		 int recordCount = 0;//һ���ж��ټ�¼ 
		String sqlCount = "select count(*) from t_advice";//�õ�һ���ж�������¼ 
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
	 * ����userName��ѯ�ղر�������
	 * @return
	 */
	public int getrecordCount3(String userName){//��Ʒ��
		 int recordCount = 0;//һ���ж��ټ�¼ 
		String sqlCount = "select count(*) from collection where username=?";//�õ�һ���ж�������¼ 
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
	 * ��Ʒ��ÿҳ��ʾ�Ĳ�Ʒ
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
	 * ģ����ѯ��Ʒ��ʱÿҳ��ʾ�Ĳ�Ʒ
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
	 * ��������Ʒ��ÿҳ��ʾ�Ĳ�Ʒ
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
	 * ����username�ղر�
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
	 * ������ÿҳ��ʾ�Ĳ�Ʒ
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
	
	//�༭��Ʒ
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
	
	//���߲�Ʒ
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
	
	//���߲�Ʒ
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
	
	//�����Ʒ�����ﳵ��
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
	//��ѯ�����
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
	//����id���ƷͼƬ��Ϣ
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
	
	//����id���Ʒname��Ϣ
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
	
	//����id���Ʒ������Ϣ
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
	//����id���������
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
	//������1
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
	
	//������1
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
	//���㹺�����Ʒ�ܶ�
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
	//������Ʒidɾ��һ�����ﳵ����
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
	//ɾ�������
	public void deleteShop(){
		String sql="truncate  shop";
		try {
			ps=con.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//����username�ҵ�ַ
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
	//���붩��
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
	
	
	
	
	//������Ƿ���ڸ���Ʒ
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
	//�������ݵ������
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
	
	//���ҽ����
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
	
	//���һظ�����
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
	//����ظ�����
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
	 * �����ղر�
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
	 * ɾ���ղر�
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
