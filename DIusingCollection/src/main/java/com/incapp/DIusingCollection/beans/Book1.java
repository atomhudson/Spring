package com.incapp.DIusingCollection.beans;

import java.util.List;

public class Book1 {
	private String BookName;
	private int BookPrice;
	private List author;
	public Book1() {
		// TODO Auto-generated constructor stub
	}
	public String getBookName() {
		return BookName;
	}
	public void setBookName(String bookName) {
		this.BookName = bookName;
	}
	public int getBookPrice() {
		return BookPrice;
	}
	public void setBookPrice(int bookPrice) {
		this.BookPrice = bookPrice;
	}
	public List getAuthor() {
		return author;
	}
	public void setAuthor(List author) {
		this.author = author;
	}
	

}
