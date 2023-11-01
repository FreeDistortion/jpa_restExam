package com.example.jpa_restexam.jpatest.relation;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Table(name = "productexam")
@ToString
public class ProductEntity {
    @Id
    @GeneratedValue
    private Long productNo;

    private String productName;
    private String company;
    private String price;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private CategoryEntity categoryEntity;

    public ProductEntity(String productName, String company, String price, CategoryEntity categoryEntity) {
        this.productName = productName;
        this.company = company;
        this.price = price;
        this.categoryEntity = categoryEntity;
    }
}
