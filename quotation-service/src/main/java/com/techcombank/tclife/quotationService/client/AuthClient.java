package com.techcombank.tclife.quotationService.client;

import com.techcombank.tclife.authService.model.request.AccessRequest;
import com.techcombank.tclife.common.wrapper.ClientResponseWrapper;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "auth-service", url = "${integration.portal.auth-service.base-url}", path = "/api/v1/auth")
public interface AuthClient {
    @PostMapping("/authorize")
    ResponseEntity<ClientResponseWrapper<Void>> authorize(
            @RequestHeader("Authorization") String token,
            @Valid @RequestBody AccessRequest accessRequest
    );
}
