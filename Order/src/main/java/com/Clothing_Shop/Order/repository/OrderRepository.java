package com.Clothing_Shop.Order.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Clothing_Shop.Order.entity.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order, Long>
{
    //Find orders by shipping address 
	List<Order> findByShippingAddress(String shippingAddress);
 
    // Orders by status (e.g. "PENDING", "SHIPPED")
    List<Order> findByStatus(String status);
 
    // Orders by user + status
   // List<Order> findByUserIdAndStatus(Long userId, String status);
}
 

