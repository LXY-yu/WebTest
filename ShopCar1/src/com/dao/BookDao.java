package com.dao;

import java.util.List;

import com.domain.Book;
import com.domain.CartItem;
public interface BookDao {
	 //获取所有的书  
    public List<Book> getAll();  
      
    //根据id获取书  
    public Book find(String NO);
    
    //向购物车里添加商品
    public void add(Book book);
    
    //获取购物车
    public List<CartItem> getAllCart();
    
    //删除
    public void delete(String NO);
    
    //清空
    public void clear();
    
    //更改数量
    public void change(String choice,String NO,double price,int quantity);

}
