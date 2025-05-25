package com.techcombank.tclife.authService.client;

import com.techcombank.tclife.common.wrapper.ClientResponseWrapper;
import com.techcombank.tclife.dataService.model.dto.UserAccessDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.UUID;

@FeignClient(
        name = "data-service",
        url = "${integration.portal.data-service.base-url}",
        path = "/api/v1/data/access-role"
)
public interface UserDataClient {
    @GetMapping("/get-user-by-cognito-sub")
    ClientResponseWrapper<UserAccessDTO> getUserByCognitoSub(UUID sub);
}