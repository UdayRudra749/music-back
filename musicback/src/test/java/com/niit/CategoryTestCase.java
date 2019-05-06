package com.niit;
 
import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.musicback.dao.CategoryDAO;
import com.niit.musicback.model.Category;


public class CategoryTestCase {
static CategoryDAO categoryDao;

	@BeforeClass
	public static void initialize()
	{
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext("com");
	categoryDao=(CategoryDAO) context.getBean("categoryDao");
	}
	@Ignore
	@Test
	public void addCategory()
	{
		Category category=new Category();
		category.setCategoryid(1);
		category.setCategoryname("Watches");
		category.setCategorydesc("This has all the products related to watches");
		assertEquals("Category insertion failed",true,categoryDao.insertCategory(category));	
	}
	@Ignore
	@Test
	public void removeCategory()
	{
		Category category=categoryDao.getCategory(1);
		assertEquals("Category insertion failed",true,categoryDao.deleteCategory(category));
	}
	/*@Ignore*/
	@Test
	public void updateCategory()
	{
		Category category=categoryDao.getCategory(33);
		category.setCategorydesc("Watches");
		category.setCategorydesc("New watch Parts");
		assertEquals("Category updation failed",true,categoryDao.updateCategory(category));
	}
	@Ignore
	@Test
	public void listCategoriesTest()
	{
		List<Category> listCategories=categoryDao.getCategories();
		assertEquals("Problem in listing categories from database",listCategories.size());
		for(Category category:listCategories)
		{
			System.out.println(category.getCategoryid()+ "  ");
			System.out.println(category.getCategoryname()+ "  ");
			System.out.println(category.getCategorydesc());
		}
	}
	
}
