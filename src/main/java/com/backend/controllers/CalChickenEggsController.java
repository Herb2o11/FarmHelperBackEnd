package com.backend.controllers;

import java.util.Optional;

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

import com.backend.boundaries.CalChickenEggsDAO;
import com.backend.entities.CalChickenEggs;
import com.backend.entities.User;

@CrossOrigin
@RestController
public class CalChickenEggsController {

	@Autowired
	CalChickenEggsDAO chkDAO;
	
 
	@PostMapping("/calchickeneggs")
	public ResponseEntity<CalChickenEggs> newCalChickeneggs (@RequestBody CalChickenEggs calChickenEggs, HttpServletRequest request) {
		final int id = (Integer) request.getAttribute("userId");
		calChickenEggs.setUser(new User(id));
		calChickenEggs = chkDAO.save(calChickenEggs);
		return new ResponseEntity<CalChickenEggs>(calChickenEggs,HttpStatus.OK);
	}
	
	@GetMapping("/calchickeneggs/{id}")
	public ResponseEntity<CalChickenEggs> readCalChickeneggs (@PathVariable("id") String id, HttpServletRequest request) {
		final int userId = (Integer) request.getAttribute("userId");
		CalChickenEggs calculator = chkDAO.findById(Integer.parseInt(id)).get();
		if(calculator.getUser().getUseId()!=userId) {
			calculator = null;
		} 
		return new ResponseEntity<CalChickenEggs>(calculator,HttpStatus.OK);	
		
		
	}
}

