package com.example.jpa_restexam.product.model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class ProductRespDTO {
    private Long productNo;
    private String productName;
    private String info;
    private int price;
    private String image;
    private LocalDateTime insertTime;
    private Category category;

    public static ProductRespDTO entity2DTO(Product product){
        return new ProductRespDTO(
                product.getProductNo(),
                product.getProductName(),
                product.getInfo(),
                product.getPrice(),
                product.getImage(),
                product.getInsertTime(),
                product.getCategory()
        );
    }
}
