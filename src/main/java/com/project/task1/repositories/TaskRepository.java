package com.project.task1.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.task1.entities.Task;
import com.project.task1.entities.User;

public interface TaskRepository  extends JpaRepository<Task, Long>{

	List<Task> findByUser(User user); 
	
}
