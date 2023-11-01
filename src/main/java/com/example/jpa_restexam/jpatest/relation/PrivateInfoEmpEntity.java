package com.example.jpa_restexam.jpatest.relation;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Emp와 1:1로 mapping되는 사적 정보를 담고 있는 entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "userInfo")
@SequenceGenerator(
        name = "privateinfo_seq_gen",
        sequenceName = "privateinfo_sqq",
        allocationSize = 1,
        initialValue = 1
)
public class PrivateInfoEmpEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "privateinfo_seq_gen")
    private Long userId;

    private String info1;
    private String info2;

    @OneToOne(mappedBy = "privateInfoEmpEntity")
    private EmpEntity empEntity;

}
