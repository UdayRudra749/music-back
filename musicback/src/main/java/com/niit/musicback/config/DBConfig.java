package com.niit.musicback.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.musicback.model.CartItems;
import com.niit.musicback.model.Category;
import com.niit.musicback.model.OrderDetails;
import com.niit.musicback.model.Product;
import com.niit.musicback.model.Suppliers;
import com.niit.musicback.model.User;

@Configuration
@ComponentScan
@EnableTransactionManagement
public class DBConfig{

	@Bean(name="datasource")
	public DataSource getDataSource()
	{
		BasicDataSource datasource=new BasicDataSource();
	    datasource.setDriverClassName("org.h2.Driver");
	    datasource.setUrl("jdbc:h2:tcp://localhost/~/watchesdb");
		datasource.setUsername("sa");
		datasource.setPassword("sa");
		System.out.println("database started");
		return datasource;
		
	}
	
	private Properties getHibernateProperties()
	{
		Properties prop=new Properties();
		prop.put("hibernate.show_sql","true");
		prop.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		prop.put("hibernate.hbm2ddl.auto","update");
		System.out.println("hibernate properties");
		return prop;
		
	}
	@Autowired
	@Bean(name="sessionfactory")
	public SessionFactory getSessionFactory(DataSource datasource)
	{
		LocalSessionFactoryBuilder sessionfactory=new LocalSessionFactoryBuilder(datasource);
		sessionfactory.addProperties(getHibernateProperties());
		sessionfactory.addAnnotatedClass(User.class);
		sessionfactory.addAnnotatedClass(Category.class);
		sessionfactory.addAnnotatedClass(Suppliers.class);
		sessionfactory.addAnnotatedClass(Product.class);
		sessionfactory.addAnnotatedClass(CartItems.class);
		sessionfactory.addAnnotatedClass(OrderDetails.class);
		return sessionfactory.buildSessionFactory();
		
	}
	
	@Bean(name="txtManager")
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("======================HibernateTransactionManager object Created======");
		
				return new HibernateTransactionManager(sessionFactory);
	}	

}

