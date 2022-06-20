package com.project.task1.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.project.task1.entities.Task;
import com.project.task1.services.TaskService;
import com.project.task1.services.UserService;
import com.project.task1.entities.User;
import com.project.task1.exceptions.EmailNotFoundCustEx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TaskController {

	@Autowired
	private TaskService taskService;
	@Autowired
	private UserService userService;

	@GetMapping("/addTask")
	public String taskForm(String email, Model model, HttpSession session) {

		session.setAttribute("email", email);
		model.addAttribute("task", new Task());
		return "views/taskForm";

	}

	@PostMapping("/addTask")
	public String addTask(@Valid Task task, BindingResult bindingResult, HttpSession session) {
		if (bindingResult.hasErrors()) {
			return "views/taskForm";
		}
		String email = (String) session.getAttribute("email");
		User user = userService.findById(email).orElseThrow(()-> new EmailNotFoundCustEx("User","Id",email));

			taskService.addTask(task, user);

		return "redirect:/users";
	}

	@GetMapping("/delTask")
	public String delTask(@Valid Task task, BindingResult bindingResult, @RequestParam(defaultValue ="") String id) {
		taskService.deleteTask(task.getId());
		return "redirect:/userProfile";
	}

}
