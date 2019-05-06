package com.niit;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.musicback.dao.UserDAO;
import com.niit.musicback.model.User;

public class UserTestCase {
	
	static UserDAO userDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext("com");
		
		userDAO = (UserDAO) context.getBean("userDAO");
	}

	@Test
	public void registerUserTest()
	{
		User userdetail = new User();
		userdetail.setEmailid("user1@gmail.com");
		userdetail.setPassword("password");
		userdetail.setRole("User");
		userdetail.setFirstname("user");
		
		assertTrue("Problem in Registering UserDetail in Database",userDAO.registerUser(userdetail));
	}

}
