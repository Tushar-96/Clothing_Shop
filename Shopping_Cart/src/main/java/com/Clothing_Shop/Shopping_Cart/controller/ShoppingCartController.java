package com.Clothing_Shop.Shopping_Cart.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Clothing_Shop.Shopping_Cart.entity.ShoppingCart;
import com.Clothing_Shop.Shopping_Cart.service.ShoppingCartService;

@RestController
@RequestMapping("/api/cart")
public class ShoppingCartController {
	private final ShoppingCartService service;
	
	public ShoppingCartController(ShoppingCartService service) {
		this.service=service;
	}
	
	@PostMapping("/create")
	public ResponseEntity<ShoppingCart> createShoppingCart(@RequestBody ShoppingCart cart) {
		if(cart == null) {
			return ResponseEntity.badRequest().build();
		}
		return  ResponseEntity.ok(cart);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ShoppingCart> getShoppingCartById(@PathVariable Long id){
		if(id == null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(service.getCart(id));
	}
}
