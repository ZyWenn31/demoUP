package com.example.demoUP.repository;

import com.example.demoUP.model.Product;
import com.example.demoUP.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// Products
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllBySupplier(Supplier s);
}
