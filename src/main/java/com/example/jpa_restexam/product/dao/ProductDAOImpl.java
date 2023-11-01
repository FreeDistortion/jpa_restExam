package com.example.jpa_restexam.product.dao;

import com.example.jpa_restexam.product.model.ProductRequest;
import lombok.RequiredArgsConstructor;
import com.example.jpa_restexam.product.model.Category;
import com.example.jpa_restexam.product.model.Product;
import com.example.jpa_restexam.product.repository.CategoryRepository;
import com.example.jpa_restexam.product.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@RequiredArgsConstructor
@Repository
public class ProductDAOImpl implements ProductDAO{
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    @Override
    public List<Category> getCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public void insert(Product request) {
        productRepository.save(request);
    }

    @Override
    public List<Product> list() {

        return productRepository.findAll();
    }


}
