package com.example.demoUP.repository;

import com.example.demoUP.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Order Items
@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {}
