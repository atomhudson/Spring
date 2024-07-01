package com.incapp.AutoWirring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.incapp.AutoWirring.beans.Book;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    		ApplicationContext ctx=new ClassPathXmlApplicationContext("Beans.xml");
    		
    		Book b1=ctx.getBean("book",Book.class);
    		System.out.println(b1.getName()+" "+b1.getPrice()+" "+b1.getAuthor().getName()+" "+b1.getAuthor().getPhone()+" "+b1.getAuthor().getAge());
    		
}
}