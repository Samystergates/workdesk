package com.project.task1.controllers;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import com.project.task1.entities.User;
import com.project.task1.exceptions.EmailNotFoundCustEx;
import com.project.task1.services.TaskService;
import com.project.task1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

	@Autowired
	private TaskService taskService;
	@Autowired
	private UserService userService;

	@GetMapping("/userProfile")
	public String showProfilePage(Model model, Principal principal,HttpSession session, Long l) {

		session.setAttribute("ts", l);
		String email = principal.getName();
		User user = userService.findById(email).orElseThrow(()-> new EmailNotFoundCustEx("User","Id",email));
		
		 model.addAttribute("tasks", taskService.findUserTask(user));

		return "views/userProfile";
	}
	

}
