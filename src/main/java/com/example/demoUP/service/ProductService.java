package com.example.demoUP.service;

import com.example.demoUP.model.Product;
import com.example.demoUP.model.Supplier;
import com.example.demoUP.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getAll() {
        return repository.findAll();
    }


    public List<Product> getBySupplier(Supplier s){
        return repository.findAllBySupplier(s);
    }

    public Optional<Product> getById(Long id) {
        return repository.findById(id);
    }

    public Product create(Product product) {
        return repository.save(product);
    }

    public Product update(Long id, Product updatedProduct) {
        return repository.findById(id).map(product -> {
            product.setName(updatedProduct.getName());
            product.setArticle(updatedProduct.getArticle());
            product.setUnit(updatedProduct.getUnit());
            product.setPrice(updatedProduct.getPrice());
            product.setSupplier(updatedProduct.getSupplier());
            product.setManufacturer(updatedProduct.getManufacturer());
            product.setCategory(updatedProduct.getCategory());
            product.setDiscount(updatedProduct.getDiscount());
            product.setStockQty(updatedProduct.getStockQty());
            product.setDescription(updatedProduct.getDescription());
            product.setImagePath(updatedProduct.getImagePath());
            return repository.save(product);
        }).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}

