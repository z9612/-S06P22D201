package com.sbank.spring.controller;

import com.sbank.spring.dto.AccountDto;
import com.sbank.spring.dto.DepositDto;
import com.sbank.spring.dto.HistoryDto;
import com.sbank.spring.service.AccountService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;



@Tag(name = "AccountController", description = "계좌 관리 API")
@CrossOrigin(value = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @Operation(summary="자신의 계좌 조회")
    @GetMapping(value="/lookup")
    public ResponseEntity<AccountDto> createAccount() {
        return ResponseEntity.ok(accountService.findMyAccount());
    }

    @Operation(summary = "계좌번호로 사용자 조회", description="있는 계좌번호라면 사용자 이름, 없는 계좌번호라면 no 리턴")
    @GetMapping(value = "/find/byAccount/{account}")
    public ResponseEntity<String> findUserNameByAccount(@PathVariable String account) {
        return ResponseEntity.ok(accountService.findUserNameByAccount(account));
    }

    @Operation(summary = "잔액 조회")
    @GetMapping(value="/find/account/balance/{account}")
    public ResponseEntity<Integer> findBalanceByAccountNumber(@PathVariable String account) {
        return ResponseEntity.ok(accountService.findBalanceByAccountNumber(account));
    }
    
    @Operation(summary = "계좌 이체", description="0: 입금, 1: 출금")
    @PostMapping(value="/transfer")
    public ResponseEntity<HistoryDto> transferMoney(@RequestBody DepositDto depositDto) {
        return ResponseEntity.ok(accountService.transferMoney(depositDto));
    }
}