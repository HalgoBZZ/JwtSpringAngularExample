package com.jwt.example.springback.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwt.example.springback.dao.UserDao;
import com.jwt.example.springback.entities.User;
import com.jwt.example.springback.services.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao dao;

	@Override
	public void save(User user) {
		dao.save(user);
		
	}

	@Override
	public void delete(Long id) {
		dao.deleteById(id);
		
	}

	@Override
	public List<User> findAll() {
		return dao.findAll();
	}

	@Override
	public Optional<User> findById(Long id) {
		return dao.findById(id);
	}

}
