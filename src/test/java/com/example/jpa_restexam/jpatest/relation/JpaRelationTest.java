package com.example.jpa_restexam.jpatest.relation;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class JpaRelationTest {

    @PersistenceContext
    EntityManager entityManager;

    @Test
    @Disabled
    void test(){
        DeptEntity dept1 = new DeptEntity("HR","MGR_HR");
        DeptEntity dept2 = new DeptEntity("DEV","MGR_DEV");
        DeptEntity dept3 = new DeptEntity("PLAN","MGR_PLAN");

        entityManager.persist(dept1);
        entityManager.persist(dept2);
        entityManager.persist(dept3);

        EmpEntity emp1 = new EmpEntity("Kim","Yongin",dept1);
        EmpEntity emp2 = new EmpEntity("Lee","Daegu",dept1);
        EmpEntity emp3 = new EmpEntity("Park","Suwon",dept2);
        EmpEntity emp4 = new EmpEntity("Hong","Goyang",dept2);
        EmpEntity emp5 = new EmpEntity("Jeon","Seoul",dept3);

        entityManager.persist(emp1);
        entityManager.persist(emp2);
        entityManager.persist(emp3);
        entityManager.persist(emp4);
        entityManager.persist(emp5);

        // execute SQL, reset cache
        entityManager.flush();
        entityManager.clear();

        // look up all employees
        List<EmpEntity> empEntityList = entityManager.createQuery("SELECT E FROM EmpEntity E", EmpEntity.class).getResultList();

        for (EmpEntity empEntity:empEntityList
             ) {
            System.out.println("Name: "+empEntity.getName());
            System.out.println("Dept: "+empEntity.getDept().getName());
            System.out.println("Addr: "+empEntity.getAddr());
        }

    }

    @Test
    @Disabled
    void test2(){
        DeptEntity dept = entityManager.find(DeptEntity.class,1L);
        List<EmpEntity> empEntityList = dept.getEmpEntityList();
        System.out.println("=======================================");
        for (EmpEntity emp:empEntityList
             ) {
//            System.out.println("name: "+emp.getName());
//            System.out.println("addr: "+emp.getAddr());
//            System.out.println("deptName: "+emp.getDept().getName());
            // stackoverflow
            System.out.println(emp);
        }
    }

    @Test
    void test3(){
        // 사원을 등록할 때 경력사항을 같이 등록
        // parameter로 잔달 받은 부서 코드를 이용해서 부서 정보 조회
        DeptEntity dept = entityManager.find(DeptEntity.class, 1L);

        // history
        List<HistoryEntity> historyEntityList=new ArrayList<>();
        historyEntityList.add(
                new HistoryEntity("company1","content1"));
        historyEntityList.add(
                new HistoryEntity("company2","content2"));
        historyEntityList.add(
                new HistoryEntity("company3","content3"));

        // create object of emp
//        EmpEntity emp1 = new EmpEntity("Kim","Yongin",dept,historyEntityList);
        EmpEntity emp = EmpEntity.buildEmpEntity("Kim","Yongin",dept,historyEntityList);
        entityManager.persist(emp);


    }
}