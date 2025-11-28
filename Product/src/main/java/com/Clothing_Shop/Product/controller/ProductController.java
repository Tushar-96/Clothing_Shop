package com.Clothing_Shop.Product.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Clothing_Shop.Product.entity.Product;
import com.Clothing_Shop.Product.service.ProductService;

import java.util.List;
 
@RestController
@RequestMapping("/api/products")
public class ProductController {
 
    private final ProductService service;
 
    public ProductController(ProductService service) {
        this.service = service;
    }
 
    /**
     * CREATE PRODUCT
     * STATUS: 201 CREATED
     */
    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {
        Product created = service.create(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
 
    /**
     * GET PRODUCT BY ID
     * STATUS: 200 OK
     */
    @GetMapping("/{id}")
    public ResponseEntity<Product> get(@PathVariable Long id) {
        Product product = service.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }
 
    /**
     * GET ALL PRODUCTS
     * STATUS: 200 OK
     */
    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        List<Product> list = service.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
 
    /**
     * UPDATE PRODUCT
     * STATUS: 200 OK
     */
    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product product) {
        Product updated = service.update(id, product);
        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }
 
    /**
     * DELETE PRODUCT
     * STATUS: 200 OK
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully");
    }
}