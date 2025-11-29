package com.Clothing_Shop.ShoppingCart.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Clothing_Shop.ShoppingCart.dto.ShoppingCartDTO;
import com.Clothing_Shop.ShoppingCart.service.ShoppingCartService;

@RestController
@RequestMapping("/api/shopping_cart")
public class ShoppingCartController {

	

	private final ShoppingCartService service;

    public ShoppingCartController(ShoppingCartService service) {
        this.service = service;
    }

    // Create ShoppingCart
    @PostMapping
    public ShoppingCartDTO createCart(@RequestBody ShoppingCartDTO dto) {
        return service.saveCart(dto);
    }

    // Get All ShoppingCarts
    @GetMapping
    public List<ShoppingCartDTO> getAllCarts() {
        return service.getAllCarts();
    }

    // Get ShoppingCart by ID
    @GetMapping("/{id}")
    public ShoppingCartDTO getCartById(@PathVariable Long id) {
        return service.getCartById(id)
                .orElseThrow(() -> new RuntimeException("ShoppingCart not found with id: " + id));
    }

    // Update ShoppingCart
    @PutMapping("/{id}")
    public ShoppingCartDTO updateCart(@PathVariable Long id, @RequestBody ShoppingCartDTO dto) {
        return service.updateCart(id, dto);
    }

    // Delete ShoppingCart
    @DeleteMapping("/{id}")
    public void deleteCart(@PathVariable Long id) {
        service.deleteCart(id);
    }

	
}
