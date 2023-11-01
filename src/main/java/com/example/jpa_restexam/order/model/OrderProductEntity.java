package com.example.jpa_restexam.order.model;

import com.example.jpa_restexam.product.model.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "orderdetail")
@SequenceGenerator(
        name = "op_generator",
        sequenceName = "op_seq",
        initialValue = 1,
        allocationSize = 1

)
public class OrderProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "op_generator")
    private Long orderProductId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity orderEntity;

    @ManyToOne
    @JoinColumn(name = "product_no")
    private Product productEntity;

    // 구매 가격
    private int orderPrice;

    // 구매 수량
    private int count;

}
