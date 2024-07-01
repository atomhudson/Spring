package com.incapp.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class MyAspect {
	@Before("execution(public void com.*.*.MyBean.add*(..))")
	//@Before("execution(public void com.incapp.beans.MyBean.add*(..))")
	public void advice1(JoinPoint j) {
		System.out.println(j.getTarget().getClass());
		System.out.println(j.getSignature());
		Object args[]=j.getArgs();
		for(Object o:args)
			System.out.println(o);
		System.out.println("for add: advice1");
	}
	@AfterReturning(pointcut = "execution(public int sum(int,int))",returning = "value")
	public void advice2(int value) {
		System.out.println("for add: advice2");
		System.out.println(value);
	}
	@AfterThrowing(pointcut = "execution(public int div(int,int))",throwing = "ex")
	public void advice3(Exception ex) {
		System.out.println("for div: advice3");
		System.out.println(ex);
	}
}
