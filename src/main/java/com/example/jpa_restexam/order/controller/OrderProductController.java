package com.example.jpa_restexam.order.controller;

import com.example.jpa_restexam.order.service.OrderProductService;
import com.example.jpa_restexam.product.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@Controller
@RequestMapping("/order")
public class OrderProductController {
    private final OrderProductService orderProductService;

    @GetMapping("/detail/{no}")
    public ModelAndView showDetail(@PathVariable Long no, @RequestBody Product product){
        ModelAndView modelAndView = new ModelAndView("product/prddetail");
        System.out.println(product);
        orderProductService.makeorder();

        return modelAndView;
    }

}
