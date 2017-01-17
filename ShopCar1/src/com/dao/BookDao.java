package com.dao;

import java.util.List;

import com.domain.Book;
import com.domain.CartItem;
public interface BookDao {
	 //��ȡ���е���  
    public List<Book> getAll();  
      
    //����id��ȡ��  
    public Book find(String NO);
    
    //���ﳵ�������Ʒ
    public void add(Book book);
    
    //��ȡ���ﳵ
    public List<CartItem> getAllCart();
    
    //ɾ��
    public void delete(String NO);
    
    //���
    public void clear();
    
    //��������
    public void change(String choice,String NO,double price,int quantity);

}
