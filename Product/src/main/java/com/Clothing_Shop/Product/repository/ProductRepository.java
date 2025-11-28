package com.Clothing_Shop.Product.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.Clothing_Shop.Product.entity.Product;
 
public interface ProductRepository extends JpaRepository<Product, Long> {
}