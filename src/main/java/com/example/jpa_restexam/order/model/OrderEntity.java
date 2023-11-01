package com.example.jpa_restexam.order.model;

import com.example.jpa_restexam.customer.model.CustomerEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "myorder")
@Getter
@SequenceGenerator(
        name = "order_seq_generator",
        sequenceName = "order_seq",
        allocationSize = 1,
        initialValue = 1
)
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "order_seq_generator")
    private Long orderId;

    private Date orderDate;
    private String addr;

    // 고객이 여러 건의 주문 가능 - N:1
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customerEntity;

    // 주문 일반 1에 대해서 구매한 정보(orderDetail)
    @OneToMany(mappedBy = "orderEntity", cascade = CascadeType.ALL)
    private List<OrderProductEntity> orderProductEntityList = new ArrayList<>();

}