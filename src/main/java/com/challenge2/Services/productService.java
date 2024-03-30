package com.challenge2.Services;

import com.challenge2.Entity.Products;
import com.challenge2.Repository.productRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class productService {
    @Autowired
    private productRepository repository ;

    public List<Products> getAllProducts() {
        return repository.findAll();
    }

    public Products getProductById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
    }

    public Products createProduct(Products product) {
        return repository.save(product);
    }

    public Products updateProduct(int id, Products product) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Product not found with id: " + id);
        }
        product.setId(id);
        return repository.save(product);
    }

    public void deleteProduct(int id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Product not found with id: " + id);
        }
        repository.deleteById(id);
    }

    public byte[] generateProductReport() {
        List<Products> products = repository.findAll();


        String reportContent = "Sample product report content";
        return reportContent.getBytes();
    }
}
