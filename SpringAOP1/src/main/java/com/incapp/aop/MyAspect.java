package com.incapp.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
//	A class Containing no. of advice is called Aspect Class
	
//	This is a Advice
 	@Before("execution(public void com.incapp.beans.Student.eat())") //point-cut expression 
	public void m() {
		System.out.println("Hello M @Before(\"execution(public void com.incapp.beans.Student.eat())\")");
		System.out.println();
	}
	
// 	This is a Advice
	@Before("execution(public void com.incapp.beans.Employee.doeat())") //point-cut expression
//	Now whenever the doeat() function of Employee is called Hello G of g() function will print first or before doeat() execution.
	public void g() {
		System.out.println("Hello G @Before(\"execution(public void com.incapp.beans.Employee.doeat())\")");
		System.out.println();
	}
	
	
//	This is a Advice
	@After("execution(public void do*())") // point-cut expression 
//	This function will run after every function which contain do like doEat(), doJob()...etc
	public void e() {
		System.out.println("Hello E @After(\"execution(public void do*())\") ");
		System.out.println();
	}
}