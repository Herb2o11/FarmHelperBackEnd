package com.backend.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.boundaries.CalChickenBroilerDAO;
import com.backend.boundaries.CalChickenEggsDAO;
import com.backend.entities.Calculator;
import com.backend.entities.User;

@RestController
public class CalculatorController {

	@Autowired
	CalChickenEggsDAO chkDAO;
	
	@Autowired
	CalChickenBroilerDAO chbDAO;
	
	@CrossOrigin 
	@GetMapping("/calculators")
	public ResponseEntity<List<Calculator>> getAllCalculators (@RequestParam String userid) {
		List<Calculator> calculators = new ArrayList<>();
		User user = new User(Integer.parseInt(userid));
		chkDAO.findAllByUser(user).forEach(calculators::add);
		chbDAO.findAllByUser(user).forEach(calculators::add);
		return new ResponseEntity<List<Calculator>>(calculators,HttpStatus.OK);
	}
	
}
