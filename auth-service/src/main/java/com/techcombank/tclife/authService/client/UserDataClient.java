package com.techcombank.tclife.authService.client;

import com.techcombank.tclife.common.wrapper.ClientResponseWrapper;
import com.techcombank.tclife.dataService.model.dto.UserAccessDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.UUID;

@FeignClient(name = "data-service", url = "${integration.portal.data-service.base-url}")
public interface UserDataClient {

    @GetMapping("/api/v1/data/access-role/get-user-by-cognito-sub")
    ClientResponseWrapper<UserAccessDTO> getUserByCognitoSub(UUID sub);
}