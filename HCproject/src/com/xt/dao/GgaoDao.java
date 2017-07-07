package com.xt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xt.pojo.Ggao;
import com.xt.util.DButil;

public class GgaoDao {

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
	//��ѯ����
	public List<Ggao> selproduct(){
		String sql="select *from guanggao";
		List<Ggao> list=new ArrayList<Ggao>();
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				list.add(new Ggao(rs.getInt(1), rs.getInt(2), rs.getString(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	
	
	
	//���ݲ�Ʒid��ѯ����
	public boolean selectone(int proid){
		String sql="select *from Guanggao where proid=?";
		boolean flag=false;
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, proid);
			rs=ps.executeQuery();
			while(rs.next()){
				if(rs.getInt(2)==proid){
					flag=true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	//��ӹ�������
	public boolean insertggao(int proid){
		String sql="insert into guanggao(proid,tuisong) values(?,?)";
		boolean flag=false;
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, proid);
			ps.setString(2,"2");
			int i=ps.executeUpdate();
			if(i==1){
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
   //���� 
	
	public boolean upggao(int proid){
			String sql="update guanggao set tuisong='1' where proid=?";
			boolean flag=false;
			try {
				ps=con.prepareStatement(sql);
				ps.setInt(1, proid);
				int i=ps.executeUpdate();
				if(i==1){
					flag=true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		   return flag;
	}
	
	
	//ȡ������ 
	
	public boolean downggao(int proid){
			String sql="update guanggao set tuisong='2' where proid=?";
			boolean flag=false;
			try {
				ps=con.prepareStatement(sql);
				ps.setInt(1, proid);
				int i=ps.executeUpdate();
				if(i==1){
					flag=true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		   return flag;
	}
	
	//��ѯ��������
	public int selectcount(){
		String sql="select count(*) from guanggao where tuisong='1'";
		int count=0;
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()){
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
		}
	//��ѯ���������Ͳ�Ʒid
	public int[] selectggid(){
		int[] i=new int[5];
		int j=0;
		String sql="select proid from guanggao where tuisong='1'";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				i[j]=rs.getInt(1);
				j++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	
}
