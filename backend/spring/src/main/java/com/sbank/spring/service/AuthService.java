package com.sbank.spring.service;

import javax.transaction.Transactional;

import com.sbank.spring.dto.SigninDto;
import com.sbank.spring.dto.TokenDto;
import com.sbank.spring.entity.RefreshToken;
import com.sbank.spring.jwt.TokenProvider;
import com.sbank.spring.repository.RefreshTokenRepository;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final RefreshTokenRepository refreshTokenRepository;

    public AuthService(TokenProvider tokenProvider, AuthenticationManagerBuilder authenticationManagerBuilder,
                RefreshTokenRepository refreshTokenRepository) {
        this.tokenProvider = tokenProvider;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.refreshTokenRepository = refreshTokenRepository;
    }

    @Transactional
    public TokenDto signin(SigninDto signinDto) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(signinDto.getId(), signinDto.getPassword());
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication); //authentication 객체를 securitycontext에 저장
        TokenDto tokenDto = tokenProvider.createToken(authentication); //jwt token 생성
        RefreshToken refreshToken = RefreshToken.builder()
                .key(authentication.getName())
                .value(tokenDto.getRefreshToken())
                .build();
        refreshTokenRepository.save(refreshToken);
        return tokenDto;
    }
}
