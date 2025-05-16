package com.techcombank.tclife.authService.service;

import com.techcombank.tclife.authService.model.response.HelloResponse;
import com.techcombank.tclife.common.exception.BusinessException;
import com.techcombank.tclife.common.model.EmptyRequest;
import com.techcombank.tclife.common.service.BaseService;
import com.techcombank.tclife.common.wrapper.ResponseWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HelloService implements BaseService<EmptyRequest, HelloResponse> {

    @Override
    public ResponseWrapper<HelloResponse> proceed(EmptyRequest input) throws BusinessException {
        HelloResponse response = HelloResponse.builder()
                .cardStatus("ACTIVE")
                .isMainCard(true)
                .productCode("001")
                .postalCode("12345")
                .supplementaryOwned(true)
                .build();
        if (1 == 1) {
            throw new BusinessException(HttpStatus.BAD_REQUEST, "4009999", "ERROR_BAD_REQUEST", "Bad Request");
        }
        return successResponse(response);
    }
}
