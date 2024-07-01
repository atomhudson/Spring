package com.incapp.DIusingCollection.beans;

public class Laptop {
	private String LaptopName;
	private String LaptopCompanyName;
	private int LaptopPrice;
	public Laptop() {
		// TODO Auto-generated constructor stub
	}
	public Laptop(String laptopName, String laptopCompanyName, int laptopPrice) {
		super();
		LaptopName = laptopName;
		LaptopCompanyName = laptopCompanyName;
		LaptopPrice = laptopPrice;
	}
	public String getLaptopName() {
		return LaptopName;
	}
	public String getLaptopCompanyName() {
		return LaptopCompanyName;
	}
	public int getLaptopPrice() {
		return LaptopPrice;
	}

}
