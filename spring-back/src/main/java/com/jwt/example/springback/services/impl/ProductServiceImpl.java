package com.jwt.example.springback.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwt.example.springback.dao.ProductDao;
import com.jwt.example.springback.entities.Product;
import com.jwt.example.springback.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao dao;
	
	@Override
	public void save(Product product) {
		dao.save(product);
		
	}

	@Override
	public void delete(Long id) {
		dao.deleteById(id);
		
	}

	@Override
	public List<Product> findAll() {
		return dao.findAll();
	}

	@Override
	public Optional<Product> findById(Long id) {
		return dao.findById(id);
	}

}
