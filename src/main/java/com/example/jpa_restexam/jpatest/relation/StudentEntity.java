package com.example.jpa_restexam.jpatest.relation;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
public class StudentEntity {
    @Id
    @GeneratedValue
    private Long studentId;
    private String name;
    private String addr;

    @OneToMany(mappedBy = "student")
    @ToString.Exclude
    // 신청한 과목의 정보를 갖고 있는 entity
    private List<StudentSubject> studentSubjectList = new ArrayList<>();

    public StudentEntity(String name, String addr) {
        this.name = name;
        this.addr = addr;
    }
}
