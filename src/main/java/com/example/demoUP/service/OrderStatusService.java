package com.example.demoUP.service;

import com.example.demoUP.model.OrderStatus;
import com.example.demoUP.repository.OrderStatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderStatusService {
    private final OrderStatusRepository repository;

    public OrderStatusService(OrderStatusRepository repository) {
        this.repository = repository;
    }

    public List<OrderStatus> getAll() {
        return repository.findAll();
    }

    public Optional<OrderStatus> getById(Long id) {
        return repository.findById(id);
    }

    public OrderStatus create(OrderStatus status) {
        return repository.save(status);
    }

    public OrderStatus update(Long id, OrderStatus updatedStatus) {
        return repository.findById(id).map(status -> {
            status.setName(updatedStatus.getName());
            return repository.save(status);
        }).orElseThrow(() -> new RuntimeException("OrderStatus not found"));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}

