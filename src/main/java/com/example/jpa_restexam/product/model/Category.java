package com.example.jpa_restexam.product.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="category")
public class Category {
    @Id
    @GeneratedValue
    private Long categoryId;
    private String categoryName;
    private String info;

    public Category(String categoryName, String info) {
        this.categoryName = categoryName;
        this.info = info;
    }
}










