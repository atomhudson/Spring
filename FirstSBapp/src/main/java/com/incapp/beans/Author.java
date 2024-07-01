package com.incapp.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Author {
	private String AuthorName;
	private String AuthorPhone;
//	public Author() {
//		// TODO Auto-generated constructor stub
//	}
	public Author(@Value("Ram")String authorName, @Value("9811981198")String authorPhone) {
		super();
		AuthorName = authorName;
		AuthorPhone = authorPhone;
	}
	public String getAuthorName() {
		return AuthorName;
	}
	public void setAuthorName(String authorName) {
		this.AuthorName = authorName;
	}
	public String getAuthorPhone() {
		return AuthorPhone;
	}
	public void setAuthorPhone(String authorPhone) {
		this.AuthorPhone = authorPhone;
	}
	

}
