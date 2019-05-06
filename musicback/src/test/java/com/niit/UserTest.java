package com.niit;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext acac=new AnnotationConfigApplicationContext();
		acac.scan("com");
		acac.refresh();
	}

}
