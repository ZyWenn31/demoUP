package com.example.demoUP.repository;

import com.example.demoUP.model.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Order Status
@Repository
public interface OrderStatusRepository extends JpaRepository<OrderStatus, Long> {}
