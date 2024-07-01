package com.incapp.DI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.incapp.DI.beans.Book;
import com.incapp.DI.beans.Book2;
import com.incapp.DI.beans.Laptop;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext conxt = new ClassPathXmlApplicationContext("beans.xml");
       
        Book b1 = conxt.getBean("b1", Book.class);
        Book b2 = conxt.getBean("b1", Book.class);
        b1.setName("Adv. JAVA");
//        if the scope is singleton then it instantiated only once and use that object again and again.
//        like if i change the book name to 'Adv. JAVA' from 'Core JAVA' it is permanent kind off.
        
//        if the scope is prototype then it instantiated every time it call.
//        like if want to change it only for b1 then we can use it.
        System.out.println();
        System.out.printf("Books 1: '%s',  '%s',  '%d' \n",b1.getName(),b1.getCname(),b1.getPrice());
        System.out.printf("Books 2: '%s',  '%s',  '%d' \n",b2.getName(),b2.getCname(),b2.getPrice());
        
        System.out.println();
        Book2 book1 = conxt.getBean("b2",Book2.class);
        System.out.printf("Book 1 by author: '%s',  '%d',   '%s',   '%s' \n",book1.getBookName(),book1.getBookPrice(),book1.getAuthor().getAuthorName(),book1.getAuthor().getAuthorPhone());
        
        System.out.println();
        Book2 book2 = conxt.getBean("b3",Book2.class);
        System.out.printf("Book 1 by author: '%s',  '%d',   '%s',   '%s' \n",book2.getBookName(),book2.getBookPrice(),book2.getAuthor().getAuthorName(),book2.getAuthor().getAuthorPhone());
       
        
        
        
        System.out.println();
        Laptop l1 = conxt.getBean("l1",Laptop.class);
        System.out.printf("Laptop 1: '%s',  '%s',  '%d'\n",l1.getLaptopName(),l1.getLaptopCompanyName(),l1.getLaptopPrice());
        
    }
}
