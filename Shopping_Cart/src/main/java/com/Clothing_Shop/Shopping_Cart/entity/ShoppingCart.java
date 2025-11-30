package com.Clothing_Shop.Shopping_Cart.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	
	@CreationTimestamp 
	@Column(updatable = false)
	private LocalDateTime createdAt = LocalDateTime.now();
	
	@UpdateTimestamp 
	@Column(updatable = false)
	private LocalDateTime updatedAt = LocalDateTime.now();
	
	
	@Min(value=0)
	private Integer quantity;
	
	
	@Column(precision = 19, scale=4)
	private BigDecimal unitPrice;


	public ShoppingCart(Long id, LocalDateTime createdAt, LocalDateTime updatedAt, @Min(0) Integer quantity,
			BigDecimal unitPrice) {
		super();
		this.id = id;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}


	public ShoppingCart() {
		super();
	}


	public LocalDateTime getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}


	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public BigDecimal getUnitPrice() {
		return unitPrice;
	}


	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}


	public Long getId() {
		return id;
	}
	
	
}
