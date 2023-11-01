package com.example.jpa_restexam.jpatest.relation;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class ManyToManyTest {

    @PersistenceContext
    EntityManager em;

    @Test
    void test(){
        // 과목 등록
        SubjectEntity subject1 = new SubjectEntity("subject1","tName1");
        SubjectEntity subject2 = new SubjectEntity("subject2","tName2");
        SubjectEntity subject3 = new SubjectEntity("subject3","tName3");
        // 학생 등록
        StudentEntity student1 = new StudentEntity("name1","addr1");
        StudentEntity student2 = new StudentEntity("name2","addr2");
        StudentEntity student3 = new StudentEntity("name3","addr3");
        // 수강신청
        StudentSubject studentSubject1 = new StudentSubject(student1,subject1,1100);
        StudentSubject studentSubject2 = new StudentSubject(student1,subject2,1200);
        StudentSubject studentSubject3 = new StudentSubject(student1,subject3,1300);
        StudentSubject studentSubject4 = new StudentSubject(student2,subject1,2100);
        StudentSubject studentSubject5 = new StudentSubject(student2,subject2,2200);
        StudentSubject studentSubject6 = new StudentSubject(student2,subject3,2300);
        StudentSubject studentSubject7 = new StudentSubject(student3,subject1,3100);
        StudentSubject studentSubject8 = new StudentSubject(student3,subject2,3200);
        StudentSubject studentSubject9 = new StudentSubject(student3,subject3,3300);

        em.persist(subject1);
        em.persist(subject2);
        em.persist(subject3);
        em.persist(student1);
        em.persist(student2);
        em.persist(student3);
        em.persist(studentSubject1);
        em.persist(studentSubject2);
        em.persist(studentSubject3);
        em.persist(studentSubject4);
        em.persist(studentSubject5);
        em.persist(studentSubject6);
        em.persist(studentSubject7);
        em.persist(studentSubject8);
        em.persist(studentSubject9);
        em.flush();
        em.clear();

        // session에 있는 id 기준으로 조회
        StudentEntity student = em.find(StudentEntity.class,student1.getStudentId());
        List<StudentSubject> studentSubjectList = student.getStudentSubjectList();
        for (StudentSubject studentSubject :
                studentSubjectList) {
            System.out.println("1번 학생이 신청한 과목 내역: " +studentSubject);
            System.out.println(studentSubject.getSubject().getSubject());
        }


        SubjectEntity subject = em.find(SubjectEntity.class,subject3.getSubjectId());
        List<StudentSubject> studentSubjectList2 = subject.getStudentSubjectList();
        for (StudentSubject studentSubject :
                studentSubjectList2) {
            System.out.println("3번 과목을 신청한 학생: "+studentSubject.getStudent().getName());
        }

    }

}