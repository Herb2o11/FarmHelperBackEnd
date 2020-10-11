package com.backend.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.FarmHelper.JwtUserDetailsService;
import com.backend.boundaries.MD5;
import com.backend.boundaries.UserDAO;
import com.backend.entities.JwtRequest;
import com.backend.entities.JwtResponse;
import com.backend.entities.User;

@RestController
public class UserController {
	
	/*
	@Autowired
	UserDAO uDAO;
	
	// Original!
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
			response.put("token", MD5.getMd5(dbUser.getEmailAddress()));
			response.put("userid", String.valueOf(dbUser.getUseId()));
		} else {
			response.put("error", "User not found or wrong password");
		}
		return response ;
		
	}
	
	*/
	
	
	
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());
		final String token = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token));
	}
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
	
}
