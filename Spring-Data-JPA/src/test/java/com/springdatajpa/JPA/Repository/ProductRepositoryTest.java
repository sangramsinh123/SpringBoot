package com.springdatajpa.JPA.Repository;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.springdatajpa.JPA.Entity.Product;

@SpringBootTest
class ProductRepositoryTest {
	
	@Autowired
	private ProductRepository productRepository; // Field based Dependency injection
	
	
	@Test
	void saveMethod() {
		//create Product 
		Product product = new Product();
		product.setName("Guitar");
		product.setActive(true);
		product.setDespcription("Amazing Guitar");
		product.setImageUrl("image.png");
		product.setSku("1000ABC");
		product.setPrice(new BigDecimal(1000));
		// save Product
		Product ProductObj = productRepository.save(product);
		// display Product info
		System.out.println(ProductObj.getId());
		System.out.println(ProductObj.toString());
		
	}
	
	@Test
	void updateUsingSaveMathod() {
		// find or retrive an entity by id
		Long id = 1L;
		Product product = productRepository.findById(id).get();
		
		// update
		product.setDespcription("updated Guitar price");
		product.setPrice(new BigDecimal(2000));
		
		// save updated entity
		productRepository.save(product);
	}
	
	@Test
	void findByIdMethod() {
		Long id = 1L;
		Product product = productRepository.findById(id).get();
	}
	
	
	@Test
	void saveAllMethod() {
		Product product2 = new Product();
		product2.setName("Mobile");
		product2.setActive(true);
		product2.setDespcription("Amazing Mobile");
		product2.setImageUrl("image2.png");
		product2.setSku("1000ABCD");
		product2.setPrice(new BigDecimal(10000));
		
		Product product3 = new Product();
		product3.setName("Mixer");
		product3.setActive(true);
		product3.setDespcription("Mixex for House Hould");
		product3.setImageUrl("image3.png");
		product3.setSku("1000ABCDE");
		product3.setPrice(new BigDecimal(800));
		List<Product> ls = new ArrayList<>();
		ls.add(product2);
		ls.add(product3);
		productRepository.saveAll(ls);
	}
	
	@Test
	void findAllMethod() {
		List<Product> allProduct = productRepository.findAll();
		
		for(Product it : allProduct) {
			System.out.println(it.getName());
		}
	}
	
	@Test
	void deleteByIdMethod() {
		Long id = 3L;
		
		productRepository.deleteById(id);
		
	}
	
	@Test
	void deleteMethod() {
		Long id = 2L;
		Product product = productRepository.findById(id).get();
		productRepository.delete(product);
		
		
	}
	
	@Test
	void deleteAllMethod() {
//		productRepository.deleteAll();
//		Long id1 = 9L;
//		Product product1 = productRepository.findById(id1).get();
		Long id2 = 12L;
		Product product2 = productRepository.findById(id2).get();

		productRepository.deleteAll(List.of(product2));
	}
	
	@Test
	void countMethod() {
		long n = productRepository.count();
		System.out.println(n);
	}
	
	@Test
	void existsByIdMethod() {
		Long id = 25L;
		boolean f = productRepository.existsById(id);
		if(f) {
			System.out.println("Product is Present");
		}
		else {
			System.out.println("Product is Not Present");
		}
	}
	
}
