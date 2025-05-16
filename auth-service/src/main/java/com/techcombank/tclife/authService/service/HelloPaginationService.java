package com.techcombank.tclife.authService.service;

import com.techcombank.tclife.authService.model.entity.User;
import com.techcombank.tclife.authService.model.request.UserRequest;
import com.techcombank.tclife.authService.model.response.UserResponse;
import com.techcombank.tclife.common.base.BasePaginationResponse;
import com.techcombank.tclife.common.service.BaseService;
import com.techcombank.tclife.common.wrapper.ResponseWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class HelloPaginationService implements BaseService<UserRequest, BasePaginationResponse<UserResponse>> {

    @Override
    public ResponseWrapper<BasePaginationResponse<UserResponse>> proceed(UserRequest input) {
        Pageable pageable = input.toPageable();

        List<User> allUsers = generateDummyUsers(50);

        int start = (int) pageable.getOffset();
        int end = Math.min(start + pageable.getPageSize(), allUsers.size());
        List<UserResponse> userResponses = start < allUsers.size()
                ? allUsers.subList(start, end).stream()
                .map(user -> UserResponse.builder()
                        .id(user.getId())
                        .name(user.getName())
                        .email(user.getEmail())
                        .build())
                .toList()
                : Collections.emptyList();


        Page<UserResponse> page = new PageImpl<>(
                userResponses,
                pageable,
                allUsers.size()
        );


        BasePaginationResponse<UserResponse> response = new BasePaginationResponse<>(
                page.getContent(),
                page.getNumber() + 1,
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages()
        );

        return successResponse(response);
    }

    private List<User> generateDummyUsers(int count) {
        List<User> users = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            users.add(new User(String.valueOf(i), "User" + i, "user" + i + "@example.com"));
        }
        return users;
    }
}