package com.example.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
	@GetMapping
	public String getHomeView() {
		return "home";
	}
	
	@GetMapping("/404.html")
	public String get404View() {
		return "error/404";
	}
	
	@GetMapping("/throw")
	public String testControllerAdvice() {
		throw new RuntimeException("Error Test In Controller.");
	}
}
