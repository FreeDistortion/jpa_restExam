package com.example.jpa_restexam.product.repository;

import com.example.jpa_restexam.product.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
