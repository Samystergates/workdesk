package com.project.task1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.task1.entities.Task;
import com.project.task1.entities.User;
import com.project.task1.repositories.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;

	public void addTask(Task task, User user) {
		task.setUser(user);
		taskRepository.save(task);
	}

	public List<Task> findUserTask(User user) {

		return taskRepository.findByUser(user);
	}

	public void deleteTask(Long id) {

		taskRepository.deleteById(id);
	}
}
