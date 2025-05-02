package com.techcombank.tclife.authService.controller;

import com.techcombank.tclife.authService.model.request.UserRequest;
import com.techcombank.tclife.authService.model.response.HelloResponse;
import com.techcombank.tclife.authService.model.response.UserResponse;
import com.techcombank.tclife.authService.service.HelloPaginationService;
import com.techcombank.tclife.authService.service.HelloService;
import com.techcombank.tclife.common.base.BasePaginationResponse;
import com.techcombank.tclife.common.model.EmptyRequest;
import com.techcombank.tclife.common.service.BaseService;
import com.techcombank.tclife.common.service.ResponseWrapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ResponseWrapper<BasePaginationResponse<UserResponse>> getPagination(
            @RequestParam(name="page", required = false) Integer page,
            @RequestParam(name="size",required = false) Integer size) {

        UserRequest userRequest = new UserRequest();
        userRequest.setPage(page);
        userRequest.setSize(size);

        return helloPaginationService.proceed(userRequest);
    }
}
