package com.journal.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.journal.app.entity.User;
import com.journal.app.repository.UserRepository;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		Optional<User> optionalUser=userRepository.findById(username);
		User user=optionalUser.get();
		if(!optionalUser.isPresent()) throw new UsernameNotFoundException("Username not found:"+username);
		UserDetails userDetails= org.springframework.security.core.userdetails.User.builder().
		username(user.getUsername()).
		password(user.getPassword()).
		roles(user.getRole()).
		build();
		
		return userDetails;
	}
	
}
