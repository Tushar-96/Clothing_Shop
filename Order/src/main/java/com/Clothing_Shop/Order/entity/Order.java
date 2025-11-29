 package com.Clothing_Shop.Order.entity;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name= "orders" )
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Order {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
//	
//	@ManyToOne(fetch= FetchType.LAZY)
//	@JoinColumn(name= "user_id",nullable=false)
//	
	@Column(nullable=false)
	private String users;
	
	@Column(nullable=false)
	private String status;
	
	@Column(nullable = false ,precision=10, scale = 2)
	private BigDecimal totalAmount;
	
	@Column(nullable=false)
	private String shippingAddress;
	

}
