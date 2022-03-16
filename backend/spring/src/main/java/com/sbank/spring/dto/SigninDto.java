package com.sbank.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor //모든 필드 값을 파라미터로 받는 생성자 생성
@NoArgsConstructor //파라미터 없는 기본 생성자 생성
public class SigninDto {
    private String id;
    private String password;
}
