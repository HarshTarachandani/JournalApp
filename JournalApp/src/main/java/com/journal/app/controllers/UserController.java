package com.journal.app.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.journal.app.entity.User;
import com.journal.app.service.UserService;

@RestController
@RequestMapping("user/")
public class UserController {
	@Autowired
	private UserService userService;	
	
	@DeleteMapping
	public ResponseEntity<?> deleteUser(@RequestBody User user)
	{
		userService.deleteUser(user.getUsername());
		return new ResponseEntity<>(null,HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<?> updateUser(@RequestBody User user)
	{
		userService.updateUser(user);
		return new ResponseEntity<>(null,HttpStatus.OK);
	}
}
