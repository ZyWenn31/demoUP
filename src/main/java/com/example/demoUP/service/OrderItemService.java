package com.example.demoUP.service;

import com.example.demoUP.model.OrderItem;
import com.example.demoUP.repository.OrderItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {
    private final OrderItemRepository repository;

    public OrderItemService(OrderItemRepository repository) {
        this.repository = repository;
    }

    public List<OrderItem> getAll() {
        return repository.findAll();
    }

    public Optional<OrderItem> getById(Long id) {
        return repository.findById(id);
    }

    public OrderItem create(OrderItem orderItem) {
        return repository.save(orderItem);
    }

    public OrderItem update(Long id, OrderItem updatedItem) {
        return repository.findById(id).map(item -> {
            item.setOrder(updatedItem.getOrder());
            item.setProduct(updatedItem.getProduct());
            item.setQuantity(updatedItem.getQuantity());
            item.setUnitPrice(updatedItem.getUnitPrice());
            item.setDiscountAtTime(updatedItem.getDiscountAtTime());
            return repository.save(item);
        }).orElseThrow(() -> new RuntimeException("OrderItem not found"));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}

