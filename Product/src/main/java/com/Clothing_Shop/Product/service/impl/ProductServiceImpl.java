package com.Clothing_Shop.Product.service.impl;


import org.springframework.stereotype.Service;

import com.Clothing_Shop.Product.entity.Product;
import com.Clothing_Shop.Product.repository.ProductRepository;
import com.Clothing_Shop.Product.service.ProductService;

import java.util.List;
 
@Service
public class ProductServiceImpl implements ProductService {
 
    private final ProductRepository repo;
 
    public ProductServiceImpl(ProductRepository repo) {
        this.repo = repo;
    }
 
    @Override
    public Product create(Product product) {
        return repo.save(product);
    }
 
    @Override
    public Product update(Long id, Product product) {
        Product existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
 
        existing.setName(product.getName());
        existing.setDescription(product.getDescription());
        existing.setPrice(product.getPrice());
        existing.setSku(product.getSku());
        existing.setStockQuantity(product.getStockQuantity());
        existing.setActive(product.getActive());
        existing.setCategoryId(product.getCategoryId());
 
        return repo.save(existing);
    }
 
    @Override
    public Product getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }
 
    @Override
    public List<Product> getAll() {
        return repo.findAll();
    }
 
    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}