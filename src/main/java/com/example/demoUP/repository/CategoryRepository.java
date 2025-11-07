package com.example.demoUP.repository;

import com.example.demoUP.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Categories
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {}
