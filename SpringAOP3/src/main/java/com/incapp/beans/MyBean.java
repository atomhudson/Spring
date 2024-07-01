package com.incapp.beans;

import org.springframework.stereotype.Component;

@Component
public class MyBean {
	public int sum(int x,int y) {
		System.out.println("starting sum");
		int s=x+y;
		System.out.println("sum done");
		return s;
	}
}
