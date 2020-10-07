package com.backend.boundaries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.backend.entities.User;

@Controller
public class Starter {

	@Autowired
	UserDAO uDAO;
	
@GetMapping("/start")
@ResponseBody
public String start() {

	User user = new User();
	
	user.setEmailAddress("herbert@gmail.com");
	user.setPassword("123");
	uDAO.save(user);
	return "";
}
	
	
	
}
