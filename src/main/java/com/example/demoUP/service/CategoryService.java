package com.example.demoUP.service;

import com.example.demoUP.model.Category;
import com.example.demoUP.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<Category> getAll() {
        return repository.findAll();
    }

    public Optional<Category> getById(Long id) {
        return repository.findById(id);
    }

    public Category create(Category category) {
        return repository.save(category);
    }

    public Category update(Long id, Category updatedCategory) {
        return repository.findById(id).map(category -> {
            category.setName(updatedCategory.getName());
            return repository.save(category);
        }).orElseThrow(() -> new RuntimeException("Category not found"));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
