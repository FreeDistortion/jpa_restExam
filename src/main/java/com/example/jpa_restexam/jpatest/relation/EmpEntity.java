package com.example.jpa_restexam.jpatest.relation;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "myemp")
@DynamicUpdate
public class   EmpEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String addr;

    // 작업 중인 table 기준으로 관계 명시
    // M:1
    // join colname 명시 - 실제 join할 table의 PK name
    @ManyToOne
    @JoinColumn(name = "dept_no")
    private DeptEntity dept;

    @OneToMany(mappedBy = "empEntity", cascade = CascadeType.ALL)
    private List<HistoryEntity> historyEntityList = new ArrayList<>();

    @OneToOne
    // EmpEntity의 userId로 join
    @JoinColumn(name = "user_id")
    private PrivateInfoEmpEntity privateInfoEmpEntity;




    public EmpEntity(String name, String addr, DeptEntity dept) {
        this.name = name;
        this.addr = addr;
        this.dept = dept;
    }

    public EmpEntity(String name, String addr, DeptEntity dept, List<HistoryEntity> historyEntityList) {
        this.name = name;
        this.addr = addr;
        this.dept = dept;
        this.historyEntityList = historyEntityList;
    }


    // 연관관계가 있는 entity 수정 작업
    public void changeHsitoryList(HistoryEntity historyEntity){
        historyEntityList.add(historyEntity);
        historyEntity.setEmpEntity(this);
    }

    public static EmpEntity buildEmpEntity(String name,String addr,DeptEntity deptEntity,List<HistoryEntity> historyEntityList){
        EmpEntity empEntity = new EmpEntity(name,addr,deptEntity);
        for (HistoryEntity historyEntity :
                historyEntityList) {
            // history를 꺼내서 emplist에 반영될 수 있도록 처리
            empEntity.changeHsitoryList(historyEntity);
        }
        return empEntity;
    }

}
