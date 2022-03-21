package com.sbank.spring.controller;

import com.sbank.spring.dto.AccountDto;
import com.sbank.spring.service.AccountService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;


@Tag(name = "AccountController", description = "계좌 관리 API")
@CrossOrigin(value = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @Operation(summary="계좌 생성")
    @PostMapping(value="/create")
    public ResponseEntity<AccountDto> createAccount() {
        return ResponseEntity.ok(accountService.createAccount());
    }
    
    
}