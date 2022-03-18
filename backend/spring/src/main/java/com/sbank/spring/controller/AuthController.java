package com.sbank.spring.controller;

import javax.validation.Valid;

import com.sbank.spring.dto.MemberDto;
import com.sbank.spring.dto.SigninDto;
import com.sbank.spring.dto.TokenDto;
import com.sbank.spring.service.AuthService;
import com.sbank.spring.service.MemberService;

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

@Tag(name = "AuthController", description = "회원 관리 API")
@CrossOrigin(value = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final MemberService mamberService;
    
    @Operation(summary="로그인")
    @PostMapping("/signin")
    public ResponseEntity<TokenDto> signin(@Valid @RequestBody SigninDto signinDto) {
        return ResponseEntity.ok(authService.signin(signinDto));
    }

    @Operation(summary="회원가입")
    @PostMapping("/signup")
    public ResponseEntity<MemberDto> signup(@Valid @RequestBody MemberDto memberDto) {
        return ResponseEntity.ok(mamberService.signup(memberDto));
    }

    @Operation(summary="아이디 중복 검사", description="있는 아이디라면 true, 없는 아이디라면 false 리턴")
    @GetMapping("/duplicate/id/{id}")
    public ResponseEntity<Boolean> duplicateId(@PathVariable String id) {
        return ResponseEntity.ok(mamberService.duplicateId(id));
    }

    @Operation(summary="이메일 중복 검사", description="있는 이메일라면 true, 없는 이메일라면 false 리턴")
    @GetMapping("/duplicate/email/{email}")
    public ResponseEntity<Boolean> duplicateEmail(@PathVariable String email) {
        return ResponseEntity.ok(mamberService.duplicateEmail(email));
    }
}
