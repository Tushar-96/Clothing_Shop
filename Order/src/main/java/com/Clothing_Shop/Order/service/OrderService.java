package com.Clothing_Shop.Order.service;

import java.util.List;

import com.Clothing_Shop.Order.dto.OrderDTO;

public interface OrderService {
	 
    OrderDTO createOrder(OrderDTO orderDTO);
 
    OrderDTO getOrderById(Long id);
 
    List<OrderDTO> getAllOrders();
 
    OrderDTO updateOrder(Long id, OrderDTO orderDTO);
 
    void deleteOrder(Long id);
 
    List<OrderDTO> getOrdersByStatus(String status);
}