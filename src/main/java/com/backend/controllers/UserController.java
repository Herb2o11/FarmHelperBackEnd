package com.backend.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.boundaries.MD5;
import com.backend.boundaries.UserDAO;
import com.backend.entities.User;

@RestController
public class UserController {
	
	@Autowired
	UserDAO uDAO;
	
	/*@ModelAttribute("user")
	public User userForm() {
		return new User();
	}*/

	/**
	 * Method to show the initial HTML form
	
	 */
	
	/*@GetMapping("/login")
	public String login(Model model) {
	    User user = (User) model.addAttribute("user");
	    if(user!= null) {
	    	return "login-success";
	    }
	    return "login";
	}*/
	
	
	@CrossOrigin 
	@PostMapping("/login")
	public Map<String, String> login(@RequestBody User user) {
		Boolean chq = false;
		User dbUser = uDAO.findByEmailAddress(user.getEmailAddress());
		if(dbUser instanceof  User) {
			chq = dbUser.checkPassword(user.getCleanPass());			
		}
		Map<String, String> response = new HashMap<>();
		if(chq) {
			response.put("token", MD5.getMd5(user.getEmailAddress()));
			response.put("userid", String.valueOf(user.getUseId()));
		} else {
			response.put("error", "User not found or wrong password");
		}
		return response ;
		
	}
	
//	@PostMapping("/login") 
//	public String login(@ModelAttribute("user") User user){
//		System.out.println("User before => " + user.getEmailAddress());
//		Iterable<User> userList = uDAO.findByEmailAddress(user.getEmailAddress());
//		user = userList.iterator().next();
//		System.out.println("User after => " + user);
//		if(user==null) {
//			System.out.println("Login Fail");
//		}
//
//		if(user != null && user.getHashPassword().equals(uDAO.getUsers())) {
//			
//			System.out.println("Login Successful");
//			return "index/index";
//		}
//		return "login/login";
//	}
	
}
