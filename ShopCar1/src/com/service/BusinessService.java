package com.service;

import java.util.List;  

import com.domain.Book;  
import com.domain.CartItem;
public interface BusinessService {

	public List<Book> getAllBook();  
    //��ȡָ��id����  
    public Book findBook(String id);  
    
    public List<CartItem> getCart();
    
    public void addToCart(Book book);
    
//ɾ�������� 

    public void deleteCartItem(String sid);  
    
    public void clearCart();  
    //�ı�����  
    public void changeQuantity(String choice,String sid,double price, int quantity);
}
