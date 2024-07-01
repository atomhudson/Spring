package com.incapp;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import jakarta.mail.internet.MimeMessage;

public class MailServerAutowired implements CommandLineRunner {
	@Autowired
	JavaMailSender mailSender;
	
	public static void main(String[] args) {
		System.out.println("KKK");
		SpringApplication.run(MailServerAutowired.class, args);
		System.out.println("HHH");
	}
	
	@Override
	public void run(String... args) throws Exception {	
		//simple text mail
		SimpleMailMessage mailMessage=new SimpleMailMessage();
		mailMessage.setTo(MailConstants.RECEVIER_EMAIL);
		mailMessage.setSubject("Hi from INCAPP Autowired");
		mailMessage.setText("I am Spring developer.");
		mailSender.send(mailMessage);
		System.out.println("Mail Sent!");
		
		//html mail
//		MimeMessage mailMessage=mailSender.createMimeMessage();
//		boolean multiPart=true;
//		MimeMessageHelper helper=new MimeMessageHelper(mailMessage,multiPart);
//		helper.setTo(MailConstants.RECEVIER_EMAIL);
//		helper.setSubject("Hi from INCAPP html");
//		String htmlMSG="<h1>Hello HI</h1> <p>Hi INCAPP </p>";
//		helper.setText("text/html", htmlMSG);
//		mailSender.send(mailMessage);
//		System.out.println("Mail Sent!");
		
		//html mail with file attachment
//		MimeMessage mailMessage=mailSender.createMimeMessage();
//		boolean multiPart=true;
//		MimeMessageHelper helper=new MimeMessageHelper(mailMessage,multiPart);
//		helper.setTo(MailConstants.RECEVIER_EMAIL);
//		helper.setSubject("Hi from INCAPP html and file");
//		int otp=(int)(Math.random()*9000) + 1000;
//		String htmlMSG="<h1>Hello HI</h1> <p>Hi INCAPP </p> <p> "+otp+" </p>";
//		helper.setText("text/html", htmlMSG);
//		
//		FileSystemResource f1=new FileSystemResource(new File("C:\\Users\\Administrator\\Downloads\\image.png")); 
//		helper.addAttachment("Spring AOP.pdf", f1);
//		FileSystemResource f2=new FileSystemResource(new File("C:\\Users\\Administrator\\Downloads\\8d65dbaf-0087-453d-a660-ace4272bcf0e.png")); 
//		helper.addAttachment("pointcut details.png", f2);
		
		mailSender.send(mailMessage);
		System.out.println("Mail Sent!");
	}
		

}
