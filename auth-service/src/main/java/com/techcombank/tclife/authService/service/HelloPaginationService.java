package com.techcombank.tclife.authService.service;

import com.techcombank.tclife.authService.model.entity.User;
import com.techcombank.tclife.authService.model.request.UserRequest;
import com.techcombank.tclife.authService.model.response.UserResponse;
import com.techcombank.tclife.common.base.BasePaginationResponse;
import com.techcombank.tclife.common.service.BaseService;
import com.techcombank.tclife.common.service.ResponseWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class HelloPaginationService implements BaseService<UserRequest, BasePaginationResponse<UserResponse>> {

    @Override
    public ResponseWrapper<BasePaginationResponse<UserResponse>> proceed(UserRequest input) {
        int page = input.getPage();
        int size = input.getSize();

        List<User> allUsers = generateDummyUsers(50);

        int start = Math.min(page * size, allUsers.size());
        int end = Math.min(start + size, allUsers.size());

        List<User> pagedUsers = allUsers.subList(start, end);

        List<UserResponse> userResponses = pagedUsers.stream()
                .map(user -> new UserResponse(user.getId(), user.getName(), user.getEmail()))
                .toList();

        Page<UserResponse> userResponsePage = new PageImpl<>(
                userResponses,
                PageRequest.of(page, size),
                allUsers.size()
        );

        BasePaginationResponse<UserResponse> response = new BasePaginationResponse<>(userResponsePage);
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

