package com.incapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootApplication
public class MailAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MailAppApplication.class, args);
		
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(MailConstants.RECEVIER_EMAIL);
		mailMessage.setSubject("Hi from Riber Co. by Prashant Saini");
		mailMessage.setText("This is a Commerical Mail by Rider Co. by Prashant Saini");
		JavaMailSender mailSender = new MailServerConfig().getMailConfig();
		mailSender.send(mailMessage);
		System.out.println("Mail Sent!");
	}

}
