package com.example.jpa_restexam.jpatest.relation;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
// M:N에서 중간 역할을 하는 entity
public class StudentSubject {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    // 수강신청한 학생 정보 - 학생이 여러 과목을 신청할 수 있음.
    private StudentEntity student;

    @ManyToOne()
    @JoinColumn(name = "subject_id")
    // 과목 정보 - 한 과목을 여러 학생이 신청 가능.
    private SubjectEntity subject;

    private int price;
    private Date orderDateTime;

    public StudentSubject(StudentEntity student, SubjectEntity subject, int price) {
        this.student = student;
        this.subject = subject;
        this.price = price;
    }
}
