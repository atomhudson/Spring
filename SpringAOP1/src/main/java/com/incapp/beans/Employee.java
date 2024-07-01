package com.incapp.beans;

import org.springframework.stereotype.Component;

@Component
public class Employee {
	public void doeat() {
		System.out.println("I am Employee and do EAT.");
		System.out.println();
	}
	
	public  void doJob() {
		System.out.println("I am Employee and do JOB.");
		System.out.println();
	}
	

}
