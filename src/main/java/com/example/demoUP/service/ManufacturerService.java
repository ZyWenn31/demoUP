package com.example.demoUP.service;

import com.example.demoUP.model.Manufacturer;
import com.example.demoUP.repository.ManufacturerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManufacturerService {
    private final ManufacturerRepository repository;

    public ManufacturerService(ManufacturerRepository repository) {
        this.repository = repository;
    }

    public List<Manufacturer> getAll() {
        return repository.findAll();
    }

    public Optional<Manufacturer> getById(Long id) {
        return repository.findById(id);
    }

    public Manufacturer create(Manufacturer manufacturer) {
        return repository.save(manufacturer);
    }

    public Manufacturer update(Long id, Manufacturer updatedManufacturer) {
        return repository.findById(id).map(manufacturer -> {
            manufacturer.setName(updatedManufacturer.getName());
            return repository.save(manufacturer);
        }).orElseThrow(() -> new RuntimeException("Manufacturer not found"));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}

