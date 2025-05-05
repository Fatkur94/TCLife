package com.techcombank.tclife.authService.controller;

import com.techcombank.tclife.authService.model.request.UserRequest;
import com.techcombank.tclife.authService.model.response.HelloResponse;
import com.techcombank.tclife.authService.model.response.UserResponse;
import com.techcombank.tclife.authService.service.HelloPaginationService;
import com.techcombank.tclife.authService.service.HelloService;
import com.techcombank.tclife.common.base.BasePaginationResponse;
import com.techcombank.tclife.common.model.EmptyRequest;
import com.techcombank.tclife.common.service.ResponseWrapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth-service")
public class AuthController {
    public HelloService helloService;

    public HelloPaginationService helloPaginationService;

    public AuthController(HelloService helloService, HelloPaginationService helloPaginationService) {
        this.helloService = helloService;
        this.helloPaginationService = helloPaginationService;
    }

    @GetMapping
    public ResponseWrapper<HelloResponse> getAllForms() throws Exception {
        return helloService.proceed(new EmptyRequest());
    }

    @GetMapping("/pagination")
    public ResponseWrapper<BasePaginationResponse<UserResponse>> getPagination(UserRequest userRequest) {
        return helloPaginationService.proceed(userRequest);
    }
}
