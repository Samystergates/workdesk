package com.project.task1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.task1.entities.Role;

public interface RoleRepository  extends JpaRepository<Role, String>{
 
}
