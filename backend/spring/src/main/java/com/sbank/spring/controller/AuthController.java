package com.sbank.spring.controller;

import com.sbank.spring.dto.MemberDto;
import com.sbank.spring.dto.SigninDto;
import com.sbank.spring.dto.TokenDto;
import com.sbank.spring.entity.Member;
import com.sbank.spring.service.AuthService;
import com.sbank.spring.service.MemberService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "AuthController", description = "회원 로그인, 회원가입, 토큰 재발급")
@CrossOrigin(value = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final MemberService mamberService;
    
    @GetMapping("/hello") //Test API
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("hello");
    }
    
    @PostMapping("/signin")
    public ResponseEntity<TokenDto> signin(@RequestBody SigninDto signinDto) {
        return ResponseEntity.ok(authService.signin(signinDto));
    }

    @PostMapping("/signup")
    public ResponseEntity<Member> signup(@RequestBody MemberDto memberDto) {
        return ResponseEntity.ok(mamberService.signup(memberDto));
    }
}
