package com.backend.controllers;

import java.util.HashMap;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.boundaries.UserDAO;
import com.backend.entities.User;

@RestController
public class UserController {
	
	
	@Autowired
	UserDAO uDAO;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@PostMapping("/authenticate")
	public ResponseEntity<Map<String, String>> createAuthenticationToken(@RequestBody User authenticationRequest) throws Exception {
		System.out.println("NO METODO =>"+authenticationRequest.getUsername()+" ("+authenticationRequest.getCleanPass()+")");
		Map<String, String> response = new HashMap<>();
		try {
			User dbUser = uDAO.findByUsername(authenticationRequest.getUsername());
			System.out.println(dbUser.toString());
			if(dbUser instanceof  User) {
				System.out.println("User =>"+dbUser.getUsername());
				dbUser.checkPassword(authenticationRequest.getCleanPass());
				System.out.println("user Good");
			} else {
				System.out.println("No User Object");
				throw new Exception("INVALID_CREDENTIALS");
			}
			final String token = jwtTokenUtil.generateToken(dbUser);
			response.put("token", token);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			response.put("error", "couldn't authenticate the user");
		}
		return new ResponseEntity<Map<String, String>>(response, HttpStatus.UNAUTHORIZED);
	}

	
}
