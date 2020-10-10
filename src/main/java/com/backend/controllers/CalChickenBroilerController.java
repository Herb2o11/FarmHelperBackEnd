package com.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.boundaries.CalChickenBroilerDAO;
import com.backend.entities.CalChickenBroiler;

@RestController
public class CalChickenBroilerController {

	@Autowired
	CalChickenBroilerDAO chbDAO;
	
	@CrossOrigin 
	@PostMapping("/calchickenbroiler")
	public ResponseEntity<CalChickenBroiler> newCalChickenBroiler (@RequestBody CalChickenBroiler calChickenEggs) {
		calChickenEggs = chbDAO.save(calChickenEggs);
		return new ResponseEntity<CalChickenBroiler>(calChickenEggs,HttpStatus.OK);
	}
	
}
