package com.sportyshoes.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.sportyshoes.models.Product;

public interface ProductDao extends JpaRepository<Product, Long> {
	
	public Optional<Product> findByName(String name);

}