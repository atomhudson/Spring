package com.incapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.incapp.beans.Book;

@SpringBootApplication
public class FirstSBappApplication {

	public static void main(String[] args) {
		ApplicationContext cont = SpringApplication.run(FirstSBappApplication.class, args);
		Book b1 = cont.getBean(Book.class);
		b1.setName("Java");
		
		System.out.println(b1.getName()+" "+b1.getPrice()+" "+b1.getAuthor().getAuthorName()+" "+b1.getAuthor().getAuthorPhone());
		
		
		Book b2 = cont.getBean(Book.class);
		System.out.println(b2.getName()+" "+b2.getPrice()+" "+b2.getAuthor().getAuthorName()+" "+b2.getAuthor().getAuthorPhone());
	}

}

