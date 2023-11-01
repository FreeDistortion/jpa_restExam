package com.example.jpa_restexam.jpatest.relation;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student1 {

    @Id
    @GeneratedValue
    private Long stdId;
    private String name;
    private String addr;

    @ManyToMany
    @JoinTable(name = "student_subject_info")
    private List<Subject1> subject1List = new ArrayList<>();

}
