package com.example.jpa_restexam.product.repository;

import com.example.jpa_restexam.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
