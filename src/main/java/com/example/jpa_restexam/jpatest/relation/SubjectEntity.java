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
@Table(name = "subject")
public class SubjectEntity {
    @Id
    @GeneratedValue
    private Long subjectId;
    private String subject;
    private String teacherName;

    @OneToMany(mappedBy = "subject")
    @ToString.Exclude
    private List<StudentSubject> studentSubjectList = new ArrayList<>();

    public SubjectEntity(String subject, String teacherName) {
        this.subject = subject;
        this.teacherName = teacherName;
    }
}
