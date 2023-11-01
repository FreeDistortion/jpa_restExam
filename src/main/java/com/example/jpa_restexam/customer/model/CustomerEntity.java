package com.example.jpa_restexam.customer.model;

import com.example.jpa_restexam.order.model.OrderEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Table(name = "customer")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class CustomerEntity {
    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Setter
    @Column(name = "pass")
    @NonNull
    private String password;

    @Setter
    @NonNull
    private String name;

    @Setter
    @NonNull
    private String addr;

    @Setter
    private String tel;

    @Setter
    private int point;

    @Setter
    private String info;

    @CreationTimestamp
    private Date createDate;

    @UpdateTimestamp
    private Date updateDate;

    @OneToMany(mappedBy = "customerEntity", cascade = CascadeType.ALL)
    private List<OrderEntity> orderEntityList= new ArrayList<>();
}
