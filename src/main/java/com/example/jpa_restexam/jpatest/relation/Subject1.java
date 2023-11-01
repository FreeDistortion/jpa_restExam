package com.example.jpa_restexam.jpatest.relation;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Subject1 {
    @Id
    @GeneratedValue
    private Long subId;
    private String subject;
    private String info;

    @ManyToMany(mappedBy = "subject1List")
    // 해당 과목을 수강신청한 학생들의 정보
    private List<Student1> student1List = new ArrayList<>();

}
