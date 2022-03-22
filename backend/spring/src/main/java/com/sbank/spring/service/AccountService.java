package com.sbank.spring.service;

import com.sbank.spring.repository.MemberRepository;
import com.sbank.spring.util.SecurityUtil;

import javax.transaction.Transactional;

import com.sbank.spring.dto.AccountDto;
import com.sbank.spring.entity.Account;
import com.sbank.spring.entity.Member;
import com.sbank.spring.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountService {

    @Autowired
    private final MemberRepository memberRepository;
    @Autowired
    private final AccountRepository accountRepository;

    @Transactional //계좌 생성
    public AccountDto createAccount(Member member) {
        Long memberNo = member.getNo();
        String accountNumber = "1129";
        boolean ok = false;
        while(!ok) {
            String middleNumber = Integer.toString((int)(Math.random() * 900) + 100); //100~1000 사이 숫자
            String lastNumber = Integer.toString((int)(Math.random() * 900000) + 100000); //100000~1000000 사이 숫자
            accountNumber += "-" + middleNumber + "-" + lastNumber;
            if(!accountRepository.existsByAccountNumber(accountNumber)) ok = true;
        }
        return AccountDto.from(accountRepository.save(AccountDto.toEntity(memberNo, accountNumber)));
    }

    @Transactional //자신의 계좌 조회
    public AccountDto findMyAccount() {
        Member member = memberRepository.findById(SecurityUtil.getCurrentMemberId());
        Long memberNo = member.getNo();
        return AccountDto.from(accountRepository.getById(memberNo));
    }

    @Transactional //계좌 번호로 사용자 조회
    public String findUserNameByAccount(String accountNumber) {
        if(accountRepository.existsByAccountNumber(accountNumber)) { //계좌가 존재하는 계좌인 경우
            Account account = accountRepository.findByAccountNumber(accountNumber);
            Member member = memberRepository.findByNo(account.getMemberNo());
            return member.getName();
        }else return "no";
    }

    @Transactional //잔액 조회
    public Integer findBalanceByAccountNumber(String accountNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        return account.getBalance();
    }

    
    
    
}