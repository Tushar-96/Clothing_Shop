package com.Clothing_Shop.CartItem.Service;

import java.util.List;

import com.Clothing_Shop.CartItem.entity.CartItem;

public interface CartItemService {
	CartItem addItem(CartItem item);

	CartItem updateItem(Long id, CartItem item);

	void deleteItem(Long id);

	List<CartItem> getItemsByCartId(Long cartId);
}
