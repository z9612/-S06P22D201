package com.sbank.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity //DB의 테이블과 1:1 매핑되는 객체
@Table(name = "member") //테이블명 member로 지정
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member implements Serializable {
    
    @Id
    // @GeneratedValue //자동 증가
    @Column(nullable = false, unique = true)
    private String id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private Date birthDay;

    @Enumerated(EnumType.STRING)
    private Authority authority;
}
