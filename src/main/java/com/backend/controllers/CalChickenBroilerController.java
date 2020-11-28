package com.backend.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.boundaries.CalChickenBroilerDAO;
import com.backend.entities.CalChickenBroiler;
import com.backend.entities.CalChickenEggs;
import com.backend.entities.User;

@RestController
public class CalChickenBroilerController {

	@Autowired
	CalChickenBroilerDAO chbDAO;
	
	@CrossOrigin 
	@PostMapping("/calchickenbroiler")
	public ResponseEntity<CalChickenBroiler> newCalChickenBroiler (@RequestBody CalChickenBroiler calChickenBroiler, HttpServletRequest request) {
		final int id = (Integer) request.getAttribute("userId");
		calChickenBroiler.setUser(new User(id));
		calChickenBroiler = chbDAO.save(calChickenBroiler);
		return new ResponseEntity<CalChickenBroiler>(calChickenBroiler,HttpStatus.OK);
	}
	
	@CrossOrigin 
	@GetMapping("/calchickenbroiler/{id}")
	public ResponseEntity<CalChickenBroiler> readCalChickeneggs (@PathVariable("id") String id, HttpServletRequest request) {
		final int userId = (Integer) request.getAttribute("userId");
		CalChickenBroiler calculator = chbDAO.findById(Integer.parseInt(id)).get();
		if(calculator.getUser().getUseId()!=userId) {
			calculator = null;
		} 
		return new ResponseEntity<CalChickenBroiler>(calculator,HttpStatus.OK);		
	}
	
}
