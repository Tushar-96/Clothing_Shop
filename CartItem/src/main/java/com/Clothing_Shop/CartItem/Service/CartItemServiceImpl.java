package com.Clothing_Shop.CartItem.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Clothing_Shop.CartItem.Repository.CartItemRepository;
import com.Clothing_Shop.CartItem.entity.CartItem;

@Service
public class CartItemServiceImpl implements CartItemService {

	private final CartItemRepository cartItemRepository;

	public CartItemServiceImpl(CartItemRepository cartItemRepository) {
		this.cartItemRepository = cartItemRepository;
	}

	@Override
	public CartItem addItem(CartItem item) {
		return cartItemRepository.save(item);
	}

	@Override
	public CartItem updateItem(Long id, CartItem updatedItem) {
		CartItem item = cartItemRepository.findById(id).orElseThrow(() -> new RuntimeException("CartItem not found"));

		item.setQuantity(updatedItem.getQuantity());
		item.setPrice(updatedItem.getPrice());

		return cartItemRepository.save(item);
	}

	@Override
	public void deleteItem(Long id) {
		cartItemRepository.deleteById(id);
	}

	@Override
	public List<CartItem> getItemsByCartId(Long cartId) {
		return cartItemRepository.findByCartId(cartId);
	}
}
