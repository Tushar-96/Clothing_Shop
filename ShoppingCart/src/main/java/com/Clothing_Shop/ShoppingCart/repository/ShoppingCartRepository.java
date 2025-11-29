package com.Clothing_Shop.ShoppingCart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Clothing_Shop.ShoppingCart.entity.Shopping_Cart;

@Repository
public interface ShoppingCartRepository  extends JpaRepository<Shopping_Cart, Long>{
	
}
