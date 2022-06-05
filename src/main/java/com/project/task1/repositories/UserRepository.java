package com.project.task1.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.task1.entities.User;

public interface UserRepository  extends JpaRepository<User, String> {

	List<User> findByNameLike(String name); 

}
