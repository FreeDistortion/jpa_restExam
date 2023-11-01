package com.example.jpa_restexam.jpatest.relation;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "myhistory")
public class HistoryEntity {
    @Id
    @GeneratedValue
    private Long historyId;
    private String company;
    private String content;

    @ManyToOne
    @JoinColumn(name = "id")
    private EmpEntity empEntity;

    public HistoryEntity(String company, String content, EmpEntity empEntity) {
        this.company = company;
        this.content = content;
        this.empEntity = empEntity;
    }

    public HistoryEntity(String company, String content) {
        this.company = company;
        this.content = content;
    }
}
