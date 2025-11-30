package com.Clothing_Shop.Shopping_Cart.service;

import com.Clothing_Shop.Shopping_Cart.entity.ShoppingCart;

public interface ShoppingCartService {
	ShoppingCart createCart(ShoppingCart shoppingCart);
	ShoppingCart getCart(Long id);

}
