package com.incapp.FirstSpringwithMaven;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.incapp.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
//	pom.xml ---> project object model
	
    public static void main( String[] args )
    {
    	ApplicationContext ctx=new ClassPathXmlApplicationContext("abc.xml");
		
//    	Option 1
//		Employee e1=(Employee)ctx.getBean("emp");
    	
//    	Option 2
    	Employee e1=ctx.getBean("emp",Employee.class);
		e1.setName("ABCABC");
		System.out.println(e1.getName());
		System.out.println(e1.getSalary());
		System.out.println(e1.getCname());
		
		Employee e2=ctx.getBean("emp",Employee.class);
		
		System.out.println(e2.getName());
		System.out.println(e2.getSalary());
		System.out.println(e2.getCname());
    }
}
