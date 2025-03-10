package com.journal.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.journal.app.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

	User findByUsername(String username);
}
