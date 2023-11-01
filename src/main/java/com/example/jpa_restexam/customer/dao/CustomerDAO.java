package com.example.jpa_restexam.customer.dao;


import com.example.jpa_restexam.customer.model.CustomerEntity;
import com.example.jpa_restexam.customer.model.CustomerReqDTO;

import java.util.List;

public interface CustomerDAO {
    void write(CustomerReqDTO customerReqDTO);
    List<CustomerEntity> findAll();
    CustomerEntity findById(Long id);
    CustomerEntity update(Long id, CustomerReqDTO customerReqDTO);
    List<CustomerEntity> findByPoint(int point);
    String delete(Long id);
}