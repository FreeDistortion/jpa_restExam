package com.example.jpa_restexam.product.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductRequest {
    private String productName;
    private String info;
    private int price;
    private String image;
    private Category category;

}
