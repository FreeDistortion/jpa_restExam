package com.example.jpa_restexam.product.dao;

import com.example.jpa_restexam.product.model.Category;
import com.example.jpa_restexam.product.model.Product;
import com.example.jpa_restexam.product.model.ProductRequest;

import java.util.List;

public interface ProductDAO {
    List<Category> getCategory();
    void insert(Product request) ;
    List<Product> list();
}
