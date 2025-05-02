package com.techcombank.tclife.authService.controller;

import com.techcombank.tclife.authService.model.response.HelloResponse;
import com.techcombank.tclife.authService.service.HelloService;
import com.techcombank.tclife.common.model.EmptyRequest;
import com.techcombank.tclife.common.service.BaseService;
import com.techcombank.tclife.common.service.ResponseWrapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth-service")
public class AuthController {
    public HelloService helloService;

    public AuthController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping
    public ResponseWrapper<HelloResponse> getAllForms() throws Exception {
        return helloService.proceed(new EmptyRequest());
    }
}
