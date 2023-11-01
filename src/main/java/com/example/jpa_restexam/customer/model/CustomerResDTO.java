package com.example.jpa_restexam.customer.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Data
public class CustomerResDTO {
    @Setter(AccessLevel.NONE)
    private Long id;
    private String password;
    private String name;
    private String addr;
    private String tel;
    private String info;
    private int point;

    public static CustomerResDTO entityToDTO(CustomerEntity e){
        return new CustomerResDTO(
                e.getId(),
                e.getPassword(),
                e.getName(),
                e.getAddr(),
                e.getTel(),
                e.getInfo(),
                e.getPoint()
        );
    }
}
