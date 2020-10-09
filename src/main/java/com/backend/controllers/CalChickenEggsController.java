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

import com.backend.boundaries.CalChickenEggsDAO;
import com.backend.boundaries.MD5;
import com.backend.entities.CalChickenEggs;
import com.backend.entities.User;

@RestController
public class CalChickenEggsController {

	@Autowired
	CalChickenEggsDAO chkDAO;
	
	@CrossOrigin 
	@PostMapping("/calchickeneggs")
	public ResponseEntity<CalChickenEggs> newCalChickeneggs (@RequestBody CalChickenEggs calChickenEggs) {
		
		calChickenEggs = chkDAO.save(calChickenEggs);
		
			return new ResponseEntity<CalChickenEggs>(
					calChickenEggs,HttpStatus.OK
				);
		
	}
	
}
