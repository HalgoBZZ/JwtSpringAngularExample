package com.jwt.example.springback.services;

import java.util.List;
import java.util.Optional;

import com.jwt.example.springback.entities.User;

public interface UserService {
	
	public void save(User user);
	
	public void delete(Long id);
	
	public List<User> findAll();
	
	public Optional<User> findById(Long id);

}
