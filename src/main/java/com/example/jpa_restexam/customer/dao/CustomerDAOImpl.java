package com.example.jpa_restexam.customer.dao;

import com.example.jpa_restexam.customer.model.CustomerEntity;
import com.example.jpa_restexam.customer.model.CustomerReqDTO;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class CustomerDAOImpl implements CustomerDAO{
    private final CustomerRepo customerRepo;
    @Override
    public void write(CustomerReqDTO customerReqDTO) {
        customerRepo.save(
                new CustomerEntity(
                        customerReqDTO.getPassword(),
                        customerReqDTO.getName(),
                        customerReqDTO.getAddr()
                )
        );
    }

    @Override
    public List<CustomerEntity> findAll() {
        return customerRepo.findAll();
    }

    @Override
    public CustomerEntity findById(Long id) {
        return customerRepo.findById(id)
                .orElseThrow(
                        ()->new IllegalArgumentException("PLEASE CHECK ID")
                );
    }

    @Transactional
    @Override
    public CustomerEntity update(Long id, CustomerReqDTO customerReqDTO) {
        CustomerEntity updateEntity = customerRepo.findById(id)
                .orElseThrow(
                        ()->new IllegalArgumentException("PLEASE CHECK ID")
                );
        updateEntity.setAddr(customerReqDTO.getAddr());
        updateEntity.setTel(customerReqDTO.getTel());
        updateEntity.setInfo(customerReqDTO.getInfo());
        updateEntity.setPassword(customerReqDTO.getPassword());
        updateEntity.setName(customerReqDTO.getName());
        updateEntity.setPoint(customerReqDTO.getPoint());
        return updateEntity;
    }

    @Override
    public List<CustomerEntity> findByPoint(int point) {
        return customerRepo.findByPoint(point);
    }

    @Override
    public String delete(Long id) {
        customerRepo.deleteById(id);
        return "DELETED";
    }
}
