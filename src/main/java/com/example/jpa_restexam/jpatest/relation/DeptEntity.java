package com.example.jpa_restexam.jpatest.relation;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

// 양방향 mapping
@Table(name = "mydept")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@SequenceGenerator(
        name = "mydept_seq_generator",
        sequenceName = "mydept_seq",
        initialValue = 1,
        allocationSize = 1
)
public class DeptEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mydept_seq_generator")
    private Long deptNo;
    private String name;
    private String mgr;

    // 부서 안에 근무하는 직원 리스트
    // @OneToMany에서는 대상 table의 어떤 col과 mapping되어있는지 기준 col 명시
    // 양방향 관계(bidirectional mapping)에서는 항상 기준이 되는 entity는 FK talbe을 표현한 entity이고 관련 col을 mapping
    @OneToMany(mappedBy = "dept")
    @ToString.Exclude
    private List<EmpEntity> empEntityList=new ArrayList<>();

    public DeptEntity(String name, String mgr) {
        this.name = name;
        this.mgr = mgr;
    }
}
