package com.incapp.DI.beans;

public class Book2 {
	private String BookName;
	private int BookPrice;
	private Author author;
	public Book2() {
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
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}

}
