package com.Clothing_Shop.Order.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.Clothing_Shop.Order.dto.OrderDTO;
import com.Clothing_Shop.Order.entity.Order;
import com.Clothing_Shop.Order.repository.OrderRepository;
import com.Clothing_Shop.Order.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
 
    private final OrderRepository orderRepository;
 
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
 
    // DTO → Entity
    private Order convertToEntity(OrderDTO dto) {
        Order order = new Order();
        order.setId(dto.getId());
        order.setStatus(dto.getStatus());
        order.setTotalAmount(dto.getTotalAmount());
        order.setShippingAddress(dto.getShippingAddress());
        return order;
    }
 
    // Entity → DTO
    private OrderDTO convertToDTO(Order order) {
        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setStatus(order.getStatus());
        dto.setTotalAmount(order.getTotalAmount());
        dto.setShippingAddress(order.getShippingAddress());
        return dto;
    }
 
    @Override
    public OrderDTO createOrder(OrderDTO dto) {
        Order order = convertToEntity(dto);
        Order saved = orderRepository.save(order);
        return convertToDTO(saved);
    }
 
    @Override
    public OrderDTO getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + id));
        return convertToDTO(order);
    }
 
    @Override
    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
 
    @Override
    public OrderDTO updateOrder(Long id, OrderDTO dto) {
        Order existing = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + id));
 
        existing.setStatus(dto.getStatus());
        existing.setTotalAmount(dto.getTotalAmount());
        existing.setShippingAddress(dto.getShippingAddress());
 
        Order updated = orderRepository.save(existing);
        return convertToDTO(updated);
    }
 
    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
 
    @Override
    public List<OrderDTO> getOrdersByStatus(String status) {
        return orderRepository.findByStatus(status)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}

