package com.incapp.DIusingCollection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.incapp.DIusingCollection.beans.Book1;
import com.incapp.DIusingCollection.beans.Book2;
import com.incapp.DIusingCollection.beans.Author;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext conxt = new ClassPathXmlApplicationContext("beans.xml");
        Book1 book1 = conxt.getBean("book1", Book1.class);
        
        System.out.println("Book Name: " + book1.getBookName());
        System.out.println("Book Price: " + book1.getBookPrice());
        
        List<Author> authors = book1.getAuthor();
        for (Author author : authors) {
            System.out.println("Author Name: " + author.getAuthorName() + ", Phone: " + author.getAuthorPhone());
        }
        
        Book2 book2 = conxt.getBean("book2", Book2.class);
        System.out.println("Book Name: "+book2.getBookName());
        System.out.println("Book Price: "+book2.getBookPrice());
        
        Map map = book2.getAuthor();
        System.out.println(map);
       
        
        
    }
}
