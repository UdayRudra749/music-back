package com.niit;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.musicback.dao.CartDAO;
import com.niit.musicback.model.CartItems;

public class CartItemsTestCase {

	static CartDAO cartDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext("com");
		cartDAO=(CartDAO)context.getBean("CartDAO");
		
	}
	@Ignore
	@Test
	
	public void addcart() {
		CartItems cart=new CartItems();
		//cart.setCartitemid(0);
		cart.setOrderid(2);
		cart.setPrice(600);
		cart.setProductid(1);
		cart.setQuantity(2);
		cart.setUsername("rudra");
		cart.setStatus("P");
		assertEquals("New Cart Cannot be created",true,cartDAO.addCartitem(cart));
		
	}
   /*@Ignore*/
	 @Test
	 public void listCartItemsTest()
	 {
		 List<CartItems> listCart=cartDAO.listcartItems("rudra");
		 System.out.println(listCart.size());
		 assertTrue("Problem in Listing CartItems From Database",listCart.size()>0);
		 for(CartItems cart:listCart)
		 {
			 System.out.println(cart.getProductname()+ " ");
			 System.out.println(cart.getUsername() + " ");
			 System.out.println(cart.getStatus()+ " "+cart.getOrderid());
		 }
	 }
	
}
