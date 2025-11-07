package com.example.demoUP.service;

import com.example.demoUP.model.PickupPoint;
import com.example.demoUP.repository.PickupPointRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PickupPointService {
    private final PickupPointRepository repository;

    public PickupPointService(PickupPointRepository repository) {
        this.repository = repository;
    }

    public List<PickupPoint> getAll() {
        return repository.findAll();
    }

    public Optional<PickupPoint> getById(Long id) {
        return repository.findById(id);
    }

    public PickupPoint create(PickupPoint pickupPoint) {
        return repository.save(pickupPoint);
    }

    public PickupPoint update(Long id, PickupPoint updatedPickupPoint) {
        return repository.findById(id).map(pp -> {
            pp.setAddress(updatedPickupPoint.getAddress());
            return repository.save(pp);
        }).orElseThrow(() -> new RuntimeException("PickupPoint not found"));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}

