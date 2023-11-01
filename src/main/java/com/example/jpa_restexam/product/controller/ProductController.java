package com.example.jpa_restexam.product.controller;

import com.example.jpa_restexam.product.model.Category;
import com.example.jpa_restexam.product.model.ProductRequest;
import com.example.jpa_restexam.product.model.ProductRespDTO;
import com.example.jpa_restexam.product.service.ProductService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/insert")
    public String insertPage(Model model){
        // 간단한 작업이므로 entity를 직접 response했지만, entity는 절대 view로 직접 보내면 안 됨. 따라서 dto로 수정해야 함.
        List<Category> categoryList = productService.getCategory();
        model.addAttribute("categorylist",categoryList);
        return "product/prdinsert";
    }


    @PostMapping("/run")
    public String insert(ProductRequest requestDTO){
        System.out.println(requestDTO);
        productService.insert(requestDTO);
        return "redirect:/product/insert";
    }

    @GetMapping("/list")
    public String list(Model model){
        List<ProductRespDTO> productRespDTOList = productService.list();
        model.addAttribute("productlist",productRespDTOList);
        return "product/prdlist";
    }
}
