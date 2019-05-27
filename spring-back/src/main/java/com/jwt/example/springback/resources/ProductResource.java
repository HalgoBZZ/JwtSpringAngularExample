package com.jwt.example.springback.resources;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.example.springback.entities.Product;
import com.jwt.example.springback.services.ProductService;

@RestController
@RequestMapping(value = "products")
public class ProductResource {

	@Autowired
	private ProductService service;

	@PutMapping(value = "/save")
	@PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
	public void save(@RequestBody Product product) {
		service.save(product);
	}

	@GetMapping(value = "/all")
	@PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
	public List<Product> findAll() {
		return service.findAll();
	}

	@DeleteMapping(value = "/delete/{id}")
	@PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}

	@GetMapping(value = "/{id}")
	@PreAuthorize("hasAuthority('ADMIN_USER')")
	public Product findById(@PathVariable("id") Long id) {
		Optional<Product> result = service.findById(id);
		if (!result.isPresent()) {
			throw new EntityNotFoundException("Product with id: " + id + " not found");
		}
		return result.get();
	}

}
