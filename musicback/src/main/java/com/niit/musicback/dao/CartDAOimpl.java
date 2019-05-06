package com.niit.musicback.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.musicback.model.CartItems;
@Repository("cartDAO")
@Transactional
public class CartDAOimpl implements CartDAO {

	@Autowired
	SessionFactory sessionFactory;
	public boolean addCartitem(CartItems cartItem) {
		try
		{
			Session session=sessionFactory.getCurrentSession();
			session.save(cartItem);
			return true;	
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
	
	public boolean deleteCartItem(CartItems cartItem) {
	try
	{
		Session session=sessionFactory.getCurrentSession();
		session.delete(cartItem);
		return true;
	}
	catch(Exception e)
	{
		return false;
	}
		
	}
	
	public CartItems getCartItem(int CartItemId) {
		try
		{
			Session session=sessionFactory.openSession();
			CartItems cart=(CartItems) session.get(CartItems.class,CartItemId);
			return cart;
		}
		catch(Exception e)
		{
			return null;
		}
	}

	@Override
	public List<CartItems> listcartItems(String username) {
		try
		{
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from CartItems where username=:userName");
			query.setParameter("username",username);
			List<CartItems> listCartItems=(List<CartItems>) query.list();
			return listCartItems;
			
		}
		catch(Exception e)
		{
			return null;
				
		}
		
	}

public boolean updateCartItem(int cartitemId) {
	return false;
	
}

}