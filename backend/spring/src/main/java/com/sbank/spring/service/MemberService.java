package com.sbank.spring.service;

import javax.transaction.Transactional;

import com.sbank.spring.dto.MemberDto;
import com.sbank.spring.entity.Member;
import com.sbank.spring.repository.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

    @Autowired
    private final MemberRepository memberRepository;
    @Autowired
    private final PasswordEncoder passwordEncoder;
    
    @Transactional //트랜잭션 속성 부여
    public Member signup(MemberDto memberDto) {
        memberDto.setAuthority("ROLE_USER"); //lombok 방식으로 해결되면 지울 것!
        return memberRepository.save(MemberDto.toEntity(memberDto, passwordEncoder));
    }

    @Transactional //아이디 중복 검사
    public boolean duplicateId(String id) {
        return memberRepository.existsById(id);
    }

    @Transactional //이메일 중복 검사
    public boolean duplicateEmail(String email) {
        return memberRepository.existsByEmail(email);
    }
}
