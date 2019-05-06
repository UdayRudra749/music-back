package com.niit.musicback.dao;

import java.util.List;

import com.niit.musicback.model.CartItems;

public interface CartDAO {
	
	
	public boolean addCartitem(CartItems cartItem);
	public boolean deleteCartItem(CartItems cartItem);
	public boolean updateCartItem(int cartitemId);
	public CartItems getCartItem(int CartItemId);
	public List<CartItems> listcartItems(String username);

}
