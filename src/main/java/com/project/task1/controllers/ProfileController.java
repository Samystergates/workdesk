package com.project.task1.controllers;

import java.security.Principal;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import com.project.task1.entities.User;
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
		Optional<User> user = userService.findById(email);
		if (user.isPresent()) {
			User u = user.get();
			model.addAttribute("tasks", taskService.findUserTask(u));
		} else {
			System.out.println("User in ProfileController is null");
		}
		return "views/userProfile";
	}
	

}
