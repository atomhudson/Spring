package com.incapp;

public class Employee {
	private String Ename;
	private String Cname;
	private int Salary;
	
	public Employee() {
//		Default Constructor
	}
	public Employee(String ename, String cname, int salary) {
		super();
		Ename = ename;
		Cname = cname;
		Salary = salary;
	}
	public String getEname() {
		return Ename;
	}
	public void setEname(String ename) {
		Ename = ename;
	}
	public String getCname() {
		return Cname;
	}
	public void setCname(String cname) {
		Cname = cname;
	}
	
	public int getSalary() {
		return Salary;
	}
	public void setSalary(int salary) {
		Salary = salary;
	}
	 
}
