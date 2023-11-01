package com.example.jpa_restexam.customer.service;

import com.example.jpa_restexam.customer.dao.CustomerDAO;
import com.example.jpa_restexam.customer.model.CustomerEntity;
import com.example.jpa_restexam.customer.model.CustomerResDTO;
import com.example.jpa_restexam.customer.model.CustomerReqDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService{
    private final CustomerDAO customerDAO;
    @Override
    public void write(CustomerReqDTO customerReqDTO) {
        customerDAO.write(customerReqDTO);
    }

    @Override
    public List<CustomerResDTO> findAll() {

        List<CustomerEntity> entityList = customerDAO.findAll();
        return entityList.stream().map(
                CustomerResDTO::entityToDTO
        ).collect(Collectors.toList());
    }

    @Override
    public CustomerResDTO findById(Long id) {
        CustomerEntity customerEntity = customerDAO.findById(id);
        return CustomerResDTO.entityToDTO(customerEntity);
    }

    @Override
    public CustomerResDTO update(Long id, CustomerReqDTO customerReqDTO) {
        CustomerEntity resEntity = customerDAO.update(id,customerReqDTO);
        return CustomerResDTO.entityToDTO(resEntity);
    }

    @Override
    public List<CustomerResDTO> findByPoint(int point) {
        List<CustomerEntity> foundListByPoint = customerDAO.findByPoint(point);
        return foundListByPoint.stream().map(
                CustomerResDTO::entityToDTO
        ).collect(Collectors.toList());
    }

    @Override
    public String delete(Long id) {
        return customerDAO.delete(id);
    }
}
