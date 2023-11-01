package com.example.jpa_restexam.product.service;

import com.example.jpa_restexam.product.model.Product;
import com.example.jpa_restexam.product.model.ProductRespDTO;
import lombok.RequiredArgsConstructor;
import com.example.jpa_restexam.product.dao.ProductDAO;
import com.example.jpa_restexam.product.model.Category;
import com.example.jpa_restexam.product.model.ProductRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService{
    private final ProductDAO dao;
    @Override
    public List<Category> getCategory() {
        return dao.getCategory();
    }

    @Override
    @Transactional
    public void insert(ProductRequest request) {
        Product entity = new Product(
                request.getProductName(),
                request.getInfo(),
                request.getPrice(),
                request.getImage(),
                request.getCategory()
        );
        dao.insert(entity);
    }

    @Override
    public List<ProductRespDTO> list() {
        List<Product> list = dao.list();
        return list.stream()
                .map(ProductRespDTO::entity2DTO)
                .collect(Collectors.toList());
    }


}
