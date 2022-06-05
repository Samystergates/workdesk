package com.project.task1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping(value = { "/", "/home", "/index" })
	public String showIndexPage() {
		return "index";
	}

	@GetMapping("/login")
	public String showLoginForm() {

		return "views/loginForm";
	}

	@GetMapping("/about")
	public String aboutUs() {

		return "views/about";
	}

}
