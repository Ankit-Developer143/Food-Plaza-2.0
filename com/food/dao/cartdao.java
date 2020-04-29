package com.food.dao;

import java.util.List;

import com.food.pojo.Cart;

public interface cartdao {
	 boolean AddToCart(Cart c);
	    boolean UpdateCart(Cart c);
	    boolean DeleteFromCartByCartID(int CartID);
	   
boolean DeleteByCustomerEmail(String CustomerEmail);
List<Cart> showAllDetails();
Cart searchfromCartbyCartid(int cartid);
Cart Searchbycartid(int cartid);
}
