package com.incapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.incapp.beans.MyBean;

@SpringBootApplication
public class Aop3Application {

	public static void main(String[] args) {
		ApplicationContext ctx= SpringApplication.run(Aop3Application.class, args);
		MyBean m=ctx.getBean(MyBean.class);
		int result=m.sum(10,20);
		System.out.println("sum: "+result);
		
	}

}
