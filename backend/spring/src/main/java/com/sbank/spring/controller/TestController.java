package com.sbank.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api")
@Api("Test Controller API")
public class TestController {

    @ApiOperation(value = "hello 출력")
    @GetMapping("/hello1")
    public String hello1() {
        return "hello";
    }

    @ApiOperation(value = "입력 값 출력", notes = "입력 받은 값을 그대로 반환합니다.", response = String.class)
    @GetMapping("/hello2")
    public String hello2(@RequestParam String param) {
        return param;
    }
}
