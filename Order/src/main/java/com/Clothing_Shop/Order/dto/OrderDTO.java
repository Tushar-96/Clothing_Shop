package com.Clothing_Shop.Order.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public class OrderDTO {
	 
	    private Long id;
	    private String status;
	    private BigDecimal totalAmount;
	    private String shippingAddress;
	}
