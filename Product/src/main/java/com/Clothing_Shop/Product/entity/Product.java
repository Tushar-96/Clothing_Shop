package com.Clothing_Shop.Product.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
 
@Entity
@Table(name = "products")
public class Product {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    private String name;
    private String description;
    private BigDecimal price;
    private String sku;
    private Integer stockQuantity;
    private Boolean active = true;
    private Integer categoryId;
 
    // Getters & Setters
    public Long getId() 
    { return id; }
    
    public void setId(Long id) 
    { this.id = id; }
 
    public String getName() 
    { return name; }
    public void setName(String name) 
    { this.name = name; }
 
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
 
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
 
    public String getSku() { return sku; }
    public void setSku(String sku) { this.sku = sku; }
 
    public Integer getStockQuantity() { return stockQuantity; }
    public void setStockQuantity(Integer stockQuantity) { this.stockQuantity = stockQuantity; }
 
    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
 
    public Integer getCategoryId() { return categoryId; }
    public void setCategoryId(Integer categoryId) { this.categoryId = categoryId; }
}
 
 
