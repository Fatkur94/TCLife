package com.techcombank.tclife.userProfileService.service;

import com.techcombank.tclife.common.model.EmptyRequest;
import com.techcombank.tclife.common.service.BaseService;
import com.techcombank.tclife.common.service.ResponseWrapper;
import com.techcombank.tclife.userProfileService.model.response.GetUserProfileResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Slf4j
public class GetUserProfileService implements BaseService<EmptyRequest, GetUserProfileResponse> {
    @Override
    public ResponseWrapper<GetUserProfileResponse> proceed(EmptyRequest input) {
        GetUserProfileResponse agentProfile = GetUserProfileResponse.builder()
                .fullName("Lina Susanti")
                .dob(LocalDate.of(1988, 7, 25))
                .gender("Female")
                .address("Jl. Merdeka No. 123, Jakarta")
                .mobilePhone("+6281234567890")
                .email("lina.susanti@example.com")
                .idCard("1234567890123456")
                .placeOfIssue("Jakarta")
                .dateOfIssue(LocalDate.of(2020, 6, 15))
                .expirationDate(LocalDate.of(2030, 6, 15))
                .nationality("Indonesian")
                .taxCode("987654321")
                .build();

        return successResponse(agentProfile);
    }
}
