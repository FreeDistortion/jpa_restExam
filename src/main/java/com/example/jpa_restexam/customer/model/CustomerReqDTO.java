package com.example.jpa_restexam.customer.model;

import lombok.*;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerReqDTO {
    private String password;
    private String name;
    private String addr;
    private String tel;
    private String info;
    @Setter(AccessLevel.NONE)
    private int point;
}
