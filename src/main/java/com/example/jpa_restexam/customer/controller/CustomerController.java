package com.example.jpa_restexam.customer.controller;

import com.example.jpa_restexam.customer.model.CustomerReqDTO;
import com.example.jpa_restexam.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody CustomerReqDTO customerReqDTO){
        customerService.write(customerReqDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/view")
    public ResponseEntity<?> view(){
        return ResponseEntity.ok(customerService.findAll());
    }


    @GetMapping("/search/id/{id}")
    public ResponseEntity<?> search(@PathVariable Long id){
        return ResponseEntity.ok(customerService.findById(id));
    }

    @GetMapping("/search/point/{point}")
    public ResponseEntity<?> search(@PathVariable int point){
        return ResponseEntity.ok(customerService.findByPoint(point));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody CustomerReqDTO customerReqDTO){
        return ResponseEntity.ok(customerService.update(id,customerReqDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return ResponseEntity.ok(customerService.delete(id));
    }
}
