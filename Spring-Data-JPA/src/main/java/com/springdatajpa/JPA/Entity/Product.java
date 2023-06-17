package com.springdatajpa.JPA.Entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity // we use @Entity to convert POJO class to JPA Entity
@Table(name = "products",
	   schema = "ecommerce",
	   uniqueConstraints = {
			   @UniqueConstraint(
					   name = "sku_unique",
					   columnNames = "stock_keeping_unit"
				)
	   }
)
@Getter
@Setter
@NoArgsConstructor // Default Constructor
@AllArgsConstructor // Parameterized Constructor
@ToString
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
					generator = "product_generator"
	)
	@SequenceGenerator(name = "product_generator",
						sequenceName = "product_sequence_name",
						allocationSize = 1
	)
	
	private Long id;
	@Column(name = "stock_keeping_unit",nullable = false)
	private String sku;// stock keeping unit
	@Column(nullable = false)
	private String name;
	private String description;
	private BigDecimal price;
	private boolean active;
	private String imageUrl;
	
	@CreationTimestamp
	private LocalDateTime dateCreated;
	
	@UpdateTimestamp
	private LocalDateTime lastUpdated;

	public Long getId() {
		return id;
	}

	public String getSku() {
		return sku;
	}

	public String getName() {
		return name;
	}

	public String getDespcription() {
		return description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public boolean isActive() {
		return active;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public LocalDateTime getDateCreated() {
		return dateCreated;
	}

	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDespcription(String description) {
		this.description = description;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
	
	

	
}
