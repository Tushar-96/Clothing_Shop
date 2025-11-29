package com.Clothing_Shop.CartItem.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Clothing_Shop.CartItem.Service.CartItemServiceImpl;
import com.Clothing_Shop.CartItem.entity.CartItem;

@RestController
@RequestMapping("/api/cart-items")
public class CartItemController {

	private  CartItemServiceImpl cartItemService;

	public CartItemController(CartItemServiceImpl cartItemService) {
		this.cartItemService = cartItemService;
	}

	@PostMapping
	public CartItem addItem(@RequestBody CartItem item) {
		return cartItemService.addItem(item);
	}

	@PutMapping("/{id}")
	public CartItem updateItem(@PathVariable Long id, @RequestBody CartItem item) {
		return cartItemService.updateItem(id, item);
	}

	@DeleteMapping("/{id}")
	public String deleteItem(@PathVariable Long id) {
		cartItemService.deleteItem(id);
		return "Item deleted successfully";
	}

	@GetMapping("/cart/{cartId}")
	public List<CartItem> getItemsByCartId(@PathVariable Long cartId) {
		return cartItemService.getItemsByCartId(cartId);
	}
}
