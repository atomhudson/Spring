package com.incapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MyController {
	
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	@RequestMapping("/add")
	public String result(HttpServletRequest req,HttpSession ses) {
		int n1=Integer.parseInt(req.getParameter("num1"));
		int n2=Integer.parseInt(req.getParameter("num2"));
		int n=n1+n2;
		ses.setAttribute("result", n);
		return "AddResult";
	}
	@RequestMapping("/sum")
	public String sum(int num1,int num2,ModelMap m) {
		int n=num1+num2;
		m.addAttribute("result", n);
		return "SumResult";
	}
}
