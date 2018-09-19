package com.trinhhc.productstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
import org.springframework.stereotype.Service;

import com.trinhhc.productstore.exception.ProductExceptions;
import com.trinhhc.productstore.exception.ProductExceptions.ProductNotFoundException;
import com.trinhhc.productstore.model.Product;
import com.trinhhc.productstore.repository.ProductRepository;

import javassist.NotFoundException;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	public Product findProductById(int id) throws ProductNotFoundException{
		return productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
	}
	
	public Product saveOrUpdate(Product product) {
		return productRepository.save(product);
	}
	public void deleteProduct(int id) throws ProductNotFoundException{
		productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
		deleteProduct(id);
	}
}
