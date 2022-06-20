package com.project.task1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.task1.entities.Task;
import com.project.task1.entities.User;
import com.project.task1.services.TaskService;
import com.project.task1.services.UserService;

@SpringBootTest
class Task1ApplicationTests {

	@Autowired
	private UserService userService;
	@Autowired
	private TaskService taskService;

	@Before
    public void initDb() {
  	  {
  		  User newUser = new User("testUser@mail.com", "testUser", "123456");
  		  userService.createUser(newUser); 
  	  }
  	  {
  		  User newUser = new User("testAdmin@mail.com", "testAdmin", "123456");
  		  
  		  
  		  userService.createUser(newUser); 
  	  }
  	  
  	  Task userTask = new Task("03/01/2018", "00:11", "11:00", "You need to work today");
  	  Optional<User> user = userService.findById("testUser@mail.com");
  	  if(user.isPresent()) {
  		  User u = user.get();
		taskService.addTask(userTask, u);  }
	}

	@Test
	public void testUser() {
		Optional<User> user = userService.findById("testUser@mail.com");
		assertNotNull(user);
		Optional<User> admin = userService.findById("testAdmin@mail.com");
		
		 if(admin.isPresent()) {
			 User a = admin.get();
			 assertEquals(a.getEmail(), "testAdmin@mail.com");
		
		 }
		
	}


}

