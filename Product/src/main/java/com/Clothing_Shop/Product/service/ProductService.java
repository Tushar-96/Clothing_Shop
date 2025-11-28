package com.Clothing_Shop.Product.service;

import java.util.List;

import com.Clothing_Shop.Product.entity.Product;

public interface ProductService {
    Product create(Product product);
    Product update(Long id, Product product);
    Product getById(Long id);
    List<Product> getAll();
    void delete(Long id);
}