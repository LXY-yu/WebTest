package com.service;

import java.util.List;

import com.dao.BookDao;  
import com.dao.BookDaoImpl;  
import com.domain.Book;   
import com.domain.CartItem; 

public class BusinessServiceImpl implements BusinessService {

	BookDao dao=new BookDaoImpl();  
    @Override  
    public List<Book> getAllBook() {  
          
        return dao.getAll();  
    }  
      
    public List<CartItem> getCart(){
    	return dao.getAllCart();
    }
    
    public void addToCart(Book book){
    	dao.add(book);
    }
    
    @Override  
    public void deleteCartItem(String sid) {  
          dao.delete(sid);
         
    }
  
  
    @Override  
    public Book findBook(String id) {  
          
        return dao.find(id);  
    }  
  
  
    @Override  
    public void clearCart() {  
        dao.clear();  
          
    }  
  
  
    public void changeQuantity(String choice,String sid,double price, int quantity) {  
       dao.change(choice,sid,price,quantity);  
          
    }  
    
  /* public static void main(String args[]){
    	BusinessServiceImpl b=new BusinessServiceImpl();
    	//System.out.println(b.getAllBook().get(0).getNO());
    	System.out.println(b.findBook("SP0001"));
    }*/

}
