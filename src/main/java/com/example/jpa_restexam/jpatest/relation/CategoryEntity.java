package com.example.jpa_restexam.jpatest.relation;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Table(name = "categoryexam")
public class CategoryEntity {
    @Id
    @GeneratedValue
    private Long categoryId;

    private String categoryName;
    private String info;

    public CategoryEntity(String categoryName, String info) {
        this.categoryName = categoryName;
        this.info = info;
    }
}
