package com.backend.controllers;

import java.util.HashMap;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.FarmHelper.JwtTokenUtil;
import com.backend.boundaries.UserDAO;
import com.backend.entities.User;

@RestController
public class UserController {
	
	
	@Autowired
	UserDAO uDAO;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@CrossOrigin 
	@PostMapping("/authenticate")
	public ResponseEntity<Map<String, String>> createAuthenticationToken(@RequestBody User authenticationRequest) throws Exception {
		// System.out.println("NO METODO =>"+authenticationRequest.getUsername()+" ("+authenticationRequest.getCleanPass()+")");
		Map<String, String> response = new HashMap<>();
		try {
			User dbUser = uDAO.findByUsername(authenticationRequest.getUsername());
			if(dbUser instanceof  User) {
				dbUser.checkPassword(authenticationRequest.getCleanPass());
			} else {
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
