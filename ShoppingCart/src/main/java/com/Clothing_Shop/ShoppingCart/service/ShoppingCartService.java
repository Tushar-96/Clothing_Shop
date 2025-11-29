package com.Clothing_Shop.ShoppingCart.service;
import org.springframework.stereotype.Service;

import com.Clothing_Shop.ShoppingCart.dto.ShoppingCartDTO;
import com.Clothing_Shop.ShoppingCart.entity.Shopping_Cart;
import com.Clothing_Shop.ShoppingCart.repository.ShoppingCartRepository;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShoppingCartService {

    @Autowired
    private ShoppingCartRepository repository;

    // Convert Entity to DTO
    private ShoppingCartDTO convertToDTO(Shopping_Cart entity) {
        return new ShoppingCartDTO(
                entity.getId(),
                entity.getUser_id(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    // Convert DTO to Entity
    private Shopping_Cart convertToEntity(ShoppingCartDTO dto) {
        Shopping_Cart entity = new Shopping_Cart();
        entity.setId(dto.getId());
        entity.setUser_id(dto.getUserId());
        // createdAt and updatedAt are handled by Hibernate annotations
        return entity;
    }

    // Create or Save
    public ShoppingCartDTO saveCart(ShoppingCartDTO dto) {
        Shopping_Cart entity = convertToEntity(dto);
        Shopping_Cart saved = repository.save(entity);
        return convertToDTO(saved);
    }

    // Get All
    public List<ShoppingCartDTO> getAllCarts() {
        return repository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Get by ID
    public Optional<ShoppingCartDTO> getCartById(Long id) {
        return repository.findById(id)
                .map(this::convertToDTO);
    }

    // Update
    public ShoppingCartDTO updateCart(Long id, ShoppingCartDTO dto) {
        return repository.findById(id).map(existing -> {
            existing.setUser_id(dto.getUserId());
            Shopping_Cart updated = repository.save(existing);
            return convertToDTO(updated);
        }).orElseThrow(() -> new RuntimeException("ShoppingCart not found with id: " + id));
    }

    // Delete
    public void deleteCart(Long id) {
        repository.deleteById(id);
    }
}