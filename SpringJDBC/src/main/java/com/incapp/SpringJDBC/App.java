package com.incapp.SpringJDBC;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.incapp.SpringJDBC.beans.Book;
import com.incapp.SpringJDBC.DAO.BookDAO;

public class App {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        BookDAO dao = (BookDAO) ctx.getBean("bdao");

        // Add Book (uncomment to test adding a book)
        // Book b1 = ctx.getBean("book", Book.class);
        // b1.setName("Core Python");
        // b1.setPname("APJ");
        // b1.setPrice(200);
        // b1.setAname("Ramesh");
        // String status = dao.addBook(b1);
        // System.out.println(status);

        // View All books
        List<Book> books = dao.getAllBook();
        if (!books.isEmpty()) {
            for (Book book : books) {
                System.out.println(book.getName());
                System.out.println(book.getPrice());
                System.out.println(book.getAname());
                System.out.println(book.getPname());
                System.out.println("-------");
            }
        } else {
            System.out.println("book not found!");
        }

        // View All Book Names
        List<String> names = dao.getAllBookNames();
        if (!names.isEmpty()) {
            for (String n : names) {
                System.out.println(n);
                System.out.println("-------");
            }
        } else {
            System.out.println("book not found!");
        }
    }
}
