package com.sbank.spring.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.sbank.spring.entity.Authority;
import com.sbank.spring.entity.Member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@Setter
@Builder //데이터 일관성을 위해 정보들을 다 받은 후에 객체를 생성
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {
    @NotNull
    private String id; //아이디
    @NotNull
    private String password; //비밀번호
    @NotNull
    private String name; //이름
    @NotNull
    private String email; //이메일
    @NotNull
    private Date BirthDay; //생년월일
    @NotNull
    private String phone; //전화번호

    private Authority authority; //유형(사용자, 관리자)

    public static Member toEntity(MemberDto memberDto, PasswordEncoder passwordEncoder) {
        return Member.builder()
                    .id(memberDto.getId())
                    .password(passwordEncoder.encode(memberDto.getPassword()))
                    .email(memberDto.getEmail())
                    .birthDay(memberDto.getBirthDay())
                    .phone(memberDto.getPhone())
                    .authority(memberDto.getAuthority())
                    .build();
    }
}
