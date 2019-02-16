package com.devil.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
public class DBConfiguration {
	public DBConfiguration() {
		System.out.println("Db config class is scanned");
	}
	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		   dataSource.setDriverClassName("org.h2.Driver");
		    dataSource.setUrl("jdbc:h2:tcp://localhost/~/test/Keerthana");
		    dataSource.setUsername("sa");
		    dataSource.setPassword("");
		    System.out.println("dataSource bean is created");
		   return dataSource;
	}
	@Bean
	public SessionFactory sessionFactory() {
		 LocalSessionFactoryBuilder lsf = new LocalSessionFactoryBuilder(dataSource());
		   Properties hibernateProperties=new Properties();
			hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
			hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");//create-alter
			hibernateProperties.setProperty("hibernate.show_sql", "true");//session.save(obj)-> insert into table values (..)
			lsf.addProperties(hibernateProperties);
			
			lsf.scanPackages("com.devil.models");
			//scan all entities in the package com.niit.models and map it with relational tables
			System.out.println("sessionFactory bean is created");
		   return lsf.buildSessionFactory();
	}
	
	   @Bean
	   public HibernateTransactionManager hibTransManagement(){
		   System.out.println("transactionManager bean is created..");
	   	return new HibernateTransactionManager(sessionFactory());
	   }

	   
	
}
