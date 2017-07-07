package com.xt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.xt.pojo.Ggao;
import com.xt.pojo.Order;
import com.xt.pojo.Product;
import com.xt.pojo.Shop;
import com.xt.util.DButil;
import com.xt.util.Time;

public class OrderDao {

	public static Connection con = null;
	public static PreparedStatement ps = null;
	public static ResultSet rs = null;
	static {
		try {
			con = DButil.getCon();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ��Ӷ���
	 * 
	 * @param userName
	 *            �û���
	 * @param products
	 *            �����а�������Ʒ�б�
	 * @return �Ƿ���ӳɹ�
	 */
	public boolean addOrder(String orderid,String userName, List<Shop>  shopList,
			String address, String totalPrice) {
		boolean flag = false;

		String Detail = "";
		for (Shop shop : shopList) {
			Detail += shop.getId() + ":" + shop.getCount() + ";";
		}
		String sql = "insert into t_order(orderid,username,totalprice,address,zhuangtai,detail,time) values(?,?,?,?,?,?,?) ";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, orderid);// ���ɲ��ظ��Ķ�����
			ps.setString(2, userName);
			ps.setString(3, totalPrice);
			ps.setString(4, address);
			ps.setString(5, "δ֧��");
			ps.setString(6, Detail);
			ps.setString(7, Time.getDate());
			int i = ps.executeUpdate();
			if (i == 1) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flag;
	}

	/**
	 * ���ݶ����Ų�ѯ��������Ʒ��Ϣ
	 * 
	 * @param orderId
	 * @return
	 */
	public List<Shop> getOrderShop(String orderId) {
		String sql = "select * from t_order where orderid=\'" + orderId + "\'";
		boolean flag = false;
		int id=0;//��ƷID
		String detail = "";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			// System.out.println(sql);
			while (rs.next()) {
				detail = rs.getString("detail");
				flag = true;
				break;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (!flag) {
			return null;// û�в�ѯ�����
		} else {
			List<Shop> shopList = new ArrayList<Shop>();
			String[] split = detail.split(";");// ÿһ������Ԫ�ض���һ����Ʒ
			// System.out.println("��Ʒ���ࣺ" + split.length);
			for (String item : split) {
				String[] shopInfo = item.split(":");
				Shop shop = new Shop();
				id=Integer.valueOf(shopInfo[0]);
				shop.setId(id);// ��ƷID
				shop.setCount(Integer.valueOf(shopInfo[1]));// ��Ʒ����
				// System.out.println(shop.toString());
				shopList.add(shop);
			}
			return shopList;
		}
	}

	public Order getOrder(String orderId) {
		String sql = "select * from t_order where orderid=\'" + orderId + "\'";
		boolean flag = false;
		Order order = null;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			// System.out.println(sql);
			while (rs.next()) {
				String orderid=rs.getString("orderid");
				String username = rs.getString("username");
				String totalprice = rs.getString("totalprice");
				String address = rs.getString("address");
				String zhuangtai = rs.getString("zhuangtai");
				String detail = rs.getString("detail");
				String time = rs.getString("time");
				order = new Order(orderid, username,
						totalprice, address, zhuangtai, detail,time);
				flag = true;
				break;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (!flag) {
			return null;// û�в�ѯ�����
		} else {
			return order;
		}

	}
	
	/**
	 * �����û�����ȡ�����µ����ж�������
	 * 
	 * @param userName
	 * @return
	 */
	public List<Order> getOrdercontent(String userName) {
		String sql = "select * from t_order where username=\'" + userName
				+ "\'";
		List<Order> orderIds = new ArrayList<Order>();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			// System.out.println(sql);
			while (rs.next()) {
				orderIds.add(new Order(rs.getString("orderid"), rs.getString("username"), rs.getString("totalprice"), rs.getString("address"), rs.getString("zhuangtai"), rs.getString("detail"), rs.getString("time")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return orderIds;

	}

	/**
	 * �����û�����ȡ�����µ����ж����ı��
	 * 
	 * @param userName
	 * @return
	 */
	public List<String> getOrderId(String userName) {
		String sql = "select orderid from t_order where username=\'" + userName
				+ "\'";
		List<String> orderIds = new ArrayList<String>();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			// System.out.println(sql);
			while (rs.next()) {
				orderIds.add(rs.getString("orderid"));
			}
			return orderIds;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}
	
	/**��ѯ�������ж���������
	 * 
	 * **/
	public int  countorder(String username){
		String sql="select count(*) from t_order where username=?";
		int count=0;
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, username);
			rs=ps.executeQuery();
			if(rs.next()){
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}
	

	/**
	 * �����û�����ѯ������ÿҳ��ʾ�Ĳ�Ʒ
	 * **/
	public List<Order> limorder(int fromIndex,int pageSize,String username){
		String sql="select * from t_order where username=? limit ?,?";
		List<Order> orderIds = new ArrayList<Order>();
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setInt(2, fromIndex);
			ps.setInt(3, pageSize);
			rs=ps.executeQuery();
			while(rs.next()){
				orderIds.add(new Order(rs.getString("orderid"), rs.getString("username"), rs.getString("totalprice"), rs.getString("address"), rs.getString("zhuangtai"), rs.getString("detail"), rs.getString("time")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return orderIds;
	}
	//����username�鶩�����¼����
	public Order seloderone(String username){
		String sql="select *from t_order where username=? limit 0,1";
		Order order=new Order();
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1,username);
			rs=ps.executeQuery();
			if(rs.next()){
				order.setOrderid(rs.getString(1));
				order.setUsername(rs.getString(2));
				order.setTotalprice(rs.getString(3));
				order.setAddress(rs.getString(4));
				order.setZhuangtai(rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return order;
	}
	
	//�л���������֧��״̬
	public boolean zhifu(String id){
		String sql="update t_order set zhuangtai='��֧��' where orderid=?";
		boolean flag=false;
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, id);
			if(ps.executeUpdate()==1){
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
}
