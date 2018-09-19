package com.trinhhc.productstore.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.trinhhc.productstore.exception.ProductExceptions.ProductNotFoundException;
import com.trinhhc.productstore.model.Product;
import com.trinhhc.productstore.service.ProductService;

@RestController
public class ProductRestController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Object> findProductById(@PathVariable Integer id) {
		try {
			return ResponseEntity.status(HttpStatus.FOUND).body(productService.findProductById(id));
		} catch (ProductNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@PostMapping("/products")
	public ResponseEntity<Object> createOrUpdate(@RequestBody Product product) {
		Product productSaved = productService.saveOrUpdate(product);
		return ResponseEntity.ok().body(productSaved);
	}
	@DeleteMapping("/products/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable Integer id) {
		try {
			productService.deleteProduct(id);
			return ResponseEntity.ok().build();
		} catch (ProductNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}
