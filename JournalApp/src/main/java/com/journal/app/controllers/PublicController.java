package com.journal.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.journal.app.entity.User;
import com.journal.app.service.UserService;

@RestController
@RequestMapping("/public")
public class PublicController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/createuser")
	public ResponseEntity<?> saveUser(@RequestBody User user)
	{
		User user2=userService.getUser(user.getUsername()).get();
		if(user2!=null) return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		userService.saveUser(user); 
		return new ResponseEntity<>(null,HttpStatus.CREATED);
	}
	
	@GetMapping("healthcheck")
	public String health()
	{
		return "Health is:OK";
	}

}
