package com.example.jpa_restexam.customer.dao;

import com.example.jpa_restexam.customer.model.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepo extends JpaRepository<CustomerEntity,Long> {
    List<CustomerEntity> findByPoint(int point);
}
