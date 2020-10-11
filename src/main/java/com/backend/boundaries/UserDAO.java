package com.backend.boundaries;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.backend.entities.User;

@Component
public interface UserDAO extends CrudRepository <User, Integer>{
	User findByUsername(String username);
	
}
