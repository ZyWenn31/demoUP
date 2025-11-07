package com.example.demoUP.service;

import com.example.demoUP.model.Order;
import com.example.demoUP.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public List<Order> getAll() {
        return repository.findAll();
    }

    public Optional<Order> getById(Long id) {
        return repository.findById(id);
    }

    public Order create(Order order) {
        return repository.save(order);
    }

    public Order update(Long id, Order updatedOrder) {
        return repository.findById(id).map(order -> {
            order.setNumber(updatedOrder.getNumber());
            order.setOrderDate(updatedOrder.getOrderDate());
            order.setDeliveryDate(updatedOrder.getDeliveryDate());
            order.setPickupPoint(updatedOrder.getPickupPoint());
            order.setClientFullname(updatedOrder.getClientFullname());
            order.setPickupCode(updatedOrder.getPickupCode());
            order.setStatus(updatedOrder.getStatus());
            return repository.save(order);
        }).orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
