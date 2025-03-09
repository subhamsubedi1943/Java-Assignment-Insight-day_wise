 package com.test.spring_1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
    	
//        Vehicle obj= (Vehicle)context.getBean("bicycle");
//        obj.drive();
    	
    	Tyre t=(Tyre) context.getBean("tyre");
    	System.out.println(t);
    	
        
    }
}
