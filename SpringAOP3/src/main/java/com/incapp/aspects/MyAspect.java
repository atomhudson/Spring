package com.incapp.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class MyAspect {
	
	@Around("execution(public int sum(int,int))")
	public Object advice1(ProceedingJoinPoint pj) {
		System.out.println("for sum: advice1");
		Object obj=null;
		try {
			obj=pj.proceed();
			int a=(Integer)obj;
			obj=a+20;
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("bye: advice1");
		return obj;
	}
}
