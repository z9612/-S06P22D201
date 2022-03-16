package com.sbank.spring.dto;

import java.util.Date;

import com.sbank.spring.entity.Authority;
import com.sbank.spring.entity.Member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder //데이터 일관성을 위해 정보들을 다 받은 후에 객체를 생성
public class MemberDto {

    private String id; //아이디
    private String password; //비밀번호
    private String name; //이름
    private String email; //이메일
    private Date birthday; //생년월일
    private String phone; //전화번호
    private Authority authority; //유형(사용자, 관리자)

    public static Member toEntity(MemberDto memberDto, PasswordEncoder passwordEncoder) {
        return Member.builder()
                    .id(memberDto.getId())
                    .password(passwordEncoder.encode(memberDto.getPassword()))
                    .name(memberDto.getName())
                    .email(memberDto.getEmail())
                    .birthday(memberDto.getBirthday())
                    .phone(memberDto.getPhone())
                    .authority(memberDto.getAuthority())
                    .build();
    }

}