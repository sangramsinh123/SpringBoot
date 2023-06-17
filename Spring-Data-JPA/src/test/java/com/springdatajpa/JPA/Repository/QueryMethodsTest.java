package com.springdatajpa.JPA.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springdatajpa.JPA.Entity.Product;

@SpringBootTest
public class QueryMethodsTest {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Test
	void findByNameMethod() {
		try {
			Product product = productRepository.findByName("Door").get();
			System.out.println(product.getId());
			System.out.println(product.getPrice());
		}
		catch(Exception e) {
			System.out.println("Product Not Found");
		}
	}
	
	@Test
	void findByIdMethod() {
		try {
			Long id = 3L;
			Product product = productRepository.findById(id).get();
			
			System.out.println(product.getName());
			System.out.println(product.getPrice());
		}
		catch(Exception e){
			System.out.println("Product Not Found");
		}
		
	}
	
	@Test
	void findByNameOrDescriptionMethod() {
		String name = "Mobile";
		String description = "Amazing Guitar";
		List<Product> ls = productRepository.findByNameOrDescription(name, description);
		if(ls.size() == 0) {
			System.out.println("Nothing found");
		}
		else {
			for(Product product : ls) {
				System.out.println(product.getId());
			}
		}
		
	}
	
	@Test
	void findByNameAndDescriptionMethod() {
		String name = "Mobile";
		String description = "Amazing Guitar";
		List<Product> ls = productRepository.findByNameAndDescription(name, description);
		if(ls.size() == 0) {
			System.out.println("Nothing found");
		}
		else {
			for(Product product : ls) {
				System.out.println(product.getId());
			}
		}
		
	}
	
	@Test
	void findDistinctByName() {
		String name = "Mixer";
		Product product = productRepository.findDistinctByName(name);
		if(product == null) {
			System.out.println("Product Not Found");
		}
		else {
			System.out.println(product.getId());
		}
	}
	
	@Test
	void findByPriceGreaterThanMethod() {
		BigDecimal price = new BigDecimal(100);
		List<Product> ls = productRepository.findByPriceGreaterThan(price);
		for(Product product : ls) {
			System.out.println(product.getId());
		}
	}
	
	@Test
	void findByPriceLessThanMethod() {
		BigDecimal price = new BigDecimal(2000);
		List<Product> ls = productRepository.findByPriceLessThan(price);
		for(Product product : ls) {
			System.out.println("Id " + product.getId());
		}
	}
	
	@Test
	void findByNameContainingMethod() {
		String name = "Mixer";
		List<Product> ls = productRepository.findByNameContaining(name);
		for(Product product : ls) {
			System.out.println("Id " + product.getId());
			System.out.println("Name " + product.getName());
		}
	}
	
	// same as Containing
	@Test
	void findByNameLikeMethod() {
		String name = "Mixer";
		List<Product> ls = productRepository.findByNameLike(name);
		for(Product product : ls) {
			System.out.println("Id " + product.getId());
			System.out.println("Name " + product.getName());
		}
	}
	
	@Test
	void findByPriceBetweenMethod() {
		List<Product> ls = productRepository.findByPriceBetween(new BigDecimal(500), new BigDecimal(2000));
		for(Product product : ls) {
			System.out.println("Id " + product.getId());
			System.out.println("Name " + product.getName());
		}
	}
	
	@Test
	void findByDateCreatedBetweenMethod() {
		LocalDateTime startDate = LocalDateTime.of(2023, 06, 17, 16, 16 ,03);
		LocalDateTime endDate   = LocalDateTime.of(2024, 06, 17, 16, 16,03);
		List<Product> ls = productRepository.findByDateCreatedBetween(startDate, endDate);
		for(Product product : ls) {
			System.out.println("Id " + product.getId());
			System.out.println("Name " + product.getName());
		}
	}
	
	@Test
	void findByNameInMethod() {
		List<String> names = new ArrayList<>();
		names.add("Mixer");
		names.add("Mobile");
		List<Product> ls = productRepository.findByNameIn(names);
		for(Product product : ls) {
			System.out.println("Id " + product.getId());
			System.out.println("Name " + product.getName());
		}
	}
	
	@Test
	void findFirst5ByOrderByNameAscMethod() {
		
		List<Product> ls = productRepository.findFirst5ByOrderByNameAsc();
		for(Product product : ls) {
			System.out.println("Id " + product.getId());
			System.out.println("Name " + product.getName());
		}
	}
	
}
