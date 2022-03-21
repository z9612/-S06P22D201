package com.sbank.spring.repository;

import java.util.Optional;

import com.sbank.spring.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long>{
    Optional<Member> findByEmail(String email);
    Optional<Member> findById(String id);
    boolean existsByEmail(String email); //이메일 중복검사
    boolean existsById(String id); //아이디 중복검사
    Member findById(Optional<String> id); //회원정보조회
}
