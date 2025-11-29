package com.Clothing_Shop.ShoppingCart.dto;

import java.time.LocalDateTime;

public class ShoppingCartDTO {

    private Long id;
    private Long userId;  // Foreign key reference to User
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Add other fields if your ShoppingCart has more attributes like items, totalPrice, etc.

    // Constructors
    public ShoppingCartDTO() {}

    public ShoppingCartDTO(Long id, Long userId, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.userId = userId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}//public class ShoppingCartDTO {
//
//}
