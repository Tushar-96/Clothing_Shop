package com.Clothing_Shop.Shopping_Cart.service.impl;

import org.springframework.stereotype.Service;

import com.Clothing_Shop.Shopping_Cart.entity.ShoppingCart;
import com.Clothing_Shop.Shopping_Cart.repository.ShoppingCartRepository;

@Service
public class ShoppingCartServiceImpl {
	
	private final ShoppingCartRepository repository;
	
	public ShoppingCartServiceImpl(ShoppingCartRepository repository) {
		this.repository=repository;
	}

	public ShoppingCart createCart(ShoppingCart shoppingCart) {
		return repository.save(shoppingCart);
	}
	
	public ShoppingCart getCart(Long id) {
		return repository.findById(id).orElseThrow(() -> new RuntimeException());
	}
}
