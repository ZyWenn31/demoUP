package com.example.demoUP.repository;

import com.example.demoUP.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Orders
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {}
