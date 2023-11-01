package com.example.jpa_restexam.product.service;

import com.example.jpa_restexam.product.model.ProductRequest;
import com.example.jpa_restexam.product.model.Category;
import com.example.jpa_restexam.product.model.ProductRespDTO;

import java.util.List;

public interface ProductService {
    List<Category> getCategory();
    void insert(ProductRequest request) ;

    List<ProductRespDTO> list();
}
