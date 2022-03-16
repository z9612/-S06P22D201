package com.sbank.spring.service;

import javax.transaction.Transactional;

import com.sbank.spring.dto.MemberDto;
import com.sbank.spring.entity.Member;
import com.sbank.spring.repository.MemberRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public MemberService(MemberRepository memberRepository, PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }
    
    @Transactional //트랜잭션 속성 부여
    public Member signup(MemberDto memberDto) {
        return memberRepository.save(MemberDto.toEntity(memberDto, passwordEncoder));
    }
}
