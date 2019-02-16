package com.devil.backend;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.devil.configuration.DBConfiguration;
import com.devil.dao.ProductDao;
import com.devil.dao.ProductDaoImpl;

public class App 
{
    public static void main( String[] args )
    {
       ApplicationContext context=
        	      new AnnotationConfigApplicationContext(DBConfiguration.class,ProductDaoImpl.class);
        	      ProductDao productDao=(ProductDao)context.getBean("productDaoImpl");
        
    }
}

