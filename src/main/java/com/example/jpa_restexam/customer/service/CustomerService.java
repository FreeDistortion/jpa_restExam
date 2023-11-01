package com.example.jpa_restexam.customer.service;

import com.example.jpa_restexam.customer.model.CustomerResDTO;
import com.example.jpa_restexam.customer.model.CustomerReqDTO;
import org.springframework.stereotype.Controller;

import java.util.List;

public interface CustomerService {
    void write(CustomerReqDTO customerReqDTO);
    List<CustomerResDTO> findAll();
    CustomerResDTO findById(Long id);
    CustomerResDTO update(Long id, CustomerReqDTO customerReqDTO);
    List<CustomerResDTO> findByPoint(int point);
    String delete(Long id);
}
