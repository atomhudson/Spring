package com.incapp.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystem;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.incapp.beans.Book;
import com.incapp.repo.BookRepo;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RequestBody;




@Controller
public class MyController {
	
	@Autowired
	BookRepo bookRepo;
	
	
	@ModelAttribute
	public void commonValue(ModelMap m) {
		m.addAttribute("appName", "Incapp's BOOK APP");
	}
	
	@RequestMapping(value = {"/","home"})
	public String homedbdhfjkjg() {
		return "index";
	}
	
	@PostMapping("addBook")
	public String addBook(@ModelAttribute Book b, @RequestPart("image") Part image ,ModelMap m) {
		//TODO: process POST request
		String r=bookRepo.addBook(b,image);
		m.addAttribute("r", r);
		return "index";
	}
	
	@PostMapping("doUpdateBook")
	public String doUpdateBook(@ModelAttribute Book b,@RequestParam("oldName") String oldName, @RequestPart("image") Part image ,ModelMap m) {
		//TODO: process POST request
		String r=bookRepo.doUpdateBook(b,oldName,image);
		m.addAttribute("r", r);
		return "UpdateBook";
	}
	
	@RequestMapping("viewBooks")
	public String viewBooks(ModelMap m) {
		List<Book> b=bookRepo.getBooks();
		m.addAttribute("books",b);
		return "ViewBooks";
	}
	
	@GetMapping("searchBook")
	public String searchBook(String name,ModelMap m) {
		List<Book> b=bookRepo.getBooks(name);
		m.addAttribute("books",b);
		return "ViewBooks";
	}
	
	@PostMapping("deleteBook")
	public String deleteBook(String name,ModelMap m) {
		boolean r=bookRepo.deleteBook(name);
		if(r) {
			m.addAttribute("result", "Book Deleted Successfully!");
		}else {
			m.addAttribute("result", "Book Does Not Exist!");
		}
		List<Book> b=bookRepo.getBooks();
		m.addAttribute("books",b);
		return "ViewBooks";
	}
	@GetMapping("updateBook")
	public String updateBook(String name,ModelMap m) {
		Book b=bookRepo.getBook(name);
		m.addAttribute("book",b);
		return "UpdateBook";
	}
	
	@GetMapping("getBookImage")
	public void getBookImage(String name,HttpServletResponse response) throws IOException {
		byte[] image=bookRepo.getBookImage(name);
		if(image==null) {
			InputStream is = this.getClass().getClassLoader().getResourceAsStream("book.jpg");
			image=is.readAllBytes();
		}
		response.getOutputStream().write(image);
	}
	
}
