package com.incapp.AutoWirring.beans;

public class Book {
	private String name;
	private double price;
	private Author author;
	public double getPrice() {
		return price;
	}
	public String getName() {
		return name;
	}
	public Author getAuthor() {
		return author;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	
	
}