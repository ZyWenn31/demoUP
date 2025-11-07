package com.example.demoUP.service;

import com.example.demoUP.model.Supplier;
import com.example.demoUP.repository.SupplierRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {
    private final SupplierRepository repository;

    public SupplierService(SupplierRepository repository) {
        this.repository = repository;
    }

    public List<Supplier> getAll() {
        return repository.findAll();
    }

    public Optional<Supplier> getById(Long id) {
        return repository.findById(id);
    }

    public Supplier getByName(String name){
        return repository.findByName(name);
    }

    public Supplier create(Supplier supplier) {
        return repository.save(supplier);
    }

    public Supplier update(Long id, Supplier updatedSupplier) {
        return repository.findById(id).map(supplier -> {
            supplier.setName(updatedSupplier.getName());
            return repository.save(supplier);
        }).orElseThrow(() -> new RuntimeException("Supplier not found"));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}

