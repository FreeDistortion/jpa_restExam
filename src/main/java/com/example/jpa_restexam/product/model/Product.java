package com.example.jpa_restexam.product.model;

import com.example.jpa_restexam.order.model.OrderProductEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue
    private Long productNo;
    private String productName;
    private String info;
    private int price;
    private String image;
    private LocalDateTime insertTime;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    // 굳이 안 해줘도 됨
//    @OneToMany(mappedBy = "productEntity", cascade = CascadeType.ALL)
//    private List<OrderProductEntity> orderProductEntity=new ArrayList<>();


    public Product(String productName, String info, int price, Category category) {
        this.productName = productName;
        this.info = info;
        this.price = price;
        this.category = category;
    }

    public Product(String productName, String info, int price, String image, Category category) {
        this.productName = productName;
        this.info = info;
        this.price = price;
        this.image = image;
        this.category = category;
    }
}
