package com.service;

import java.util.List;  

import com.domain.Book;  
import com.domain.CartItem;
public interface BusinessService {

	public List<Book> getAllBook();  
    //获取指定id的书  
    public Book findBook(String id);  
    
    public List<CartItem> getCart();
    
    public void addToCart(Book book);
    
//删除购物项 

    public void deleteCartItem(String sid);  
    
    public void clearCart();  
    //改变数量  
    public void changeQuantity(String choice,String sid,double price, int quantity);
}
