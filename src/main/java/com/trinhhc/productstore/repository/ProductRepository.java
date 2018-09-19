package com.trinhhc.productstore.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.trinhhc.productstore.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	Optional<Product> findById(int id);
	
}
