package com.journal.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.journal.app.entity.User;
import com.journal.app.repository.UserRepository;

@Service
@SuppressWarnings("deprecation")
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	private static final PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
	 
	 
	public Optional<User> getUser(String username)
	{
		return userRepository.findById(username);
	}
	
	public void saveUser(User user)
	{
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}
	
	public void updateUser(User user)
	{
		this.saveUser(user);
	}
	
	public void deleteUser(String username)
	{
		userRepository.delete(userRepository.getById(username));
	}
	
}
