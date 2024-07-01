package com.incapp.SecondSpringWithMaven;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.incapp.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        System.out.println( "Hello World!" );
        
        System.out.println();
        
        ApplicationContext ap = new ClassPathXmlApplicationContext("abc.xml");
        
//        Using Property
        Employee e = ap.getBean("emp", Employee.class);
        
        
//        Using Constructor
        Employee ee = ap.getBean("empp",Employee.class);
        
        
//        Employee e = (Employee) ap.getBean("emp");
        System.out.println(e.getEname());
        System.out.println(e.getCname());
        System.out.println(e.getSalary());
        
        System.out.println();
        
        System.out.println(ee.getEname());
        System.out.println(ee.getCname());
        System.out.println(ee.getSalary());
        
    }
}
