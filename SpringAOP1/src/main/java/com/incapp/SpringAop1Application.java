package com.incapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.incapp.beans.Employee;
import com.incapp.beans.Student;

@SpringBootApplication
public class SpringAop1Application {

	public static void main(String[] args) {
		ApplicationContext conxt =  SpringApplication.run(SpringAop1Application.class, args);
		
		Employee e = conxt.getBean(Employee.class);
		Student s = conxt.getBean(Student.class);
		
		e.doeat();
		e.doJob();
		
		
		s.eat();
		s.walk();
		s.doStudy();
	}

}
