package com.jwt.example.springback.services;

import java.util.List;
import java.util.Optional;

import com.jwt.example.springback.entities.Product;

public interface ProductService {
	
	public void save(Product product);
	
	public void delete(Long id);
	
	public List<Product> findAll();
	
	public Optional<Product> findById(Long id);

}
