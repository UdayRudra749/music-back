package com.niit;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.musicback.dao.SupplierDao;
import com.niit.musicback.model.Category;
import com.niit.musicback.model.Suppliers;

public class SupplierTestCase {
	static SupplierDao supplierDao;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com");
		supplierDao=(SupplierDao)context.getBean("supplierDao");
	}
	
	@Ignore
	@Test
	public void insertSupplier()
	{
		Suppliers supplier = new Suppliers();
		Category category = new Category();
		category.setCategoryname("watches");
		category.setCategorydesc("Watch Parts");
		System.out.println(category.getCategoryid());
		supplier.setSuppliername("FOSSIL");
		supplier.setSupplierstock(15);
		supplier.setCategory(category);
		assertEquals("Cannot insert data",true,supplierDao.addSupplier(supplier));
	}
	//@Ignore
	@Test
	public void listSupplier()
	{
		List<Suppliers>list=supplierDao.list();
		assertTrue("problem in listing suppliers from database",list.size()>0);
		
		for(Suppliers supplier:list)
		{
			System.out.println(supplier.getSupplierid() + "   ");
			System.out.println(supplier.getSuppliername() + "   ");
			System.out.println(supplier.getCategory().getCategorydesc()+"  "+supplier.getSupplierstock());
		}
	}
	
	//@Ignore
	@Test
	public void listSuppliersByCategory()
	{
		List<Suppliers> list=supplierDao.listSupplierByCategoryId(33);
		assertTrue("problem in listing suppliers from database",list.size()>0);
		
		for(Suppliers supplier:list)
		{
			System.out.println(supplier.getSupplierid()+"   ");
			System.out.println(supplier.getSuppliername()+"   ");
			System.out.println(supplier.getCategory().getCategorydesc()+"  "+supplier.getSupplierstock());
		}
	}
}


