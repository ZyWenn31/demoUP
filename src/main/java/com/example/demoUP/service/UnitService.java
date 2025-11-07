package com.example.demoUP.service;

import com.example.demoUP.model.Unit;
import com.example.demoUP.repository.UnitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UnitService {
    private final UnitRepository repository;

    public UnitService(UnitRepository repository) {
        this.repository = repository;
    }

    public List<Unit> getAll() {
        return repository.findAll();
    }

    public Optional<Unit> getById(Long id) {
        return repository.findById(id);
    }

    public Unit create(Unit unit) {
        return repository.save(unit);
    }

    public Unit update(Long id, Unit updatedUnit) {
        return repository.findById(id).map(unit -> {
            unit.setName(updatedUnit.getName());
            return repository.save(unit);
        }).orElseThrow(() -> new RuntimeException("Unit not found"));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}

