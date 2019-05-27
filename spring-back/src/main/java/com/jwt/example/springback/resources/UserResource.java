package com.jwt.example.springback.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.example.springback.entities.User;
import com.jwt.example.springback.services.UserService;
import com.jwt.example.springback.utilities.EntityNotFoundException;

@RestController
@RequestMapping(value = "users")
public class UserResource {

	@Autowired
	private UserService service;

	@PutMapping(value = "/save")
	public void save(User user) {
		service.save(user);
	}

	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}

	@GetMapping(value = "/all")
	public List<User> findAll() {
		return service.findAll();
	}

	@GetMapping(value = "/{id}")
	public User findById(@PathVariable("id") Long id) {
		Optional<User> result = service.findById(id);
		if (!result.isPresent()) {
			throw new EntityNotFoundException(User.class.getName() + "- id: " + id);
		}
		return result.get();
	}
	
	
}
