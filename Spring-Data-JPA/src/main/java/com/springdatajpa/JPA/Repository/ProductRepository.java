package com.springdatajpa.JPA.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springdatajpa.JPA.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	/*
	 * Returns the found product entity by using its name as search criteria.
	 * If no product entry is found this method returns null
	 * 
	 * */
	public Optional<Product> findByName(String name); 
	
	public Optional<Product> findById(Long id);
	
	public List<Product> findByNameOrDescription(String name, String description);
	
	public List<Product> findByNameAndDescription(String name, String description);
	
	public Product findDistinctByName(String name);
	
	public List<Product> findByPriceGreaterThan(BigDecimal price);
	
	public List<Product> findByPriceLessThan(BigDecimal price);
	
	public List<Product> findByNameContaining(String name);
	
	public List<Product> findByNameLike(String name);
	
	public List<Product> findByPriceBetween(BigDecimal startPrice, BigDecimal endPrice );
	
	public List<Product> findByDateCreatedBetween(LocalDateTime startDate,LocalDateTime endDate);
	
	public List<Product> findByNameIn(List<String> names);
	
	public List<Product> findFirst5ByOrderByNameAsc();
}



