package com.techcombank.tclife.dataService.controller;

import com.techcombank.tclife.common.wrapper.ClientResponseWrapper;
import com.techcombank.tclife.dataService.model.dto.UserAccessDTO;
import com.techcombank.tclife.dataService.service.AccessRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/access-role")
@RequiredArgsConstructor
public class AccessRoleController {

    private final AccessRoleService accessRoleService;

    @GetMapping("/get-user-by-cognito-sub")
    public ResponseEntity<ClientResponseWrapper<UserAccessDTO>> getUserByCognitoSub(
            @RequestParam UUID sub
    ) {
        try {
            UserAccessDTO dto = accessRoleService.getUserAccessByCognitoSub(sub);
            return ResponseEntity.ok(new ClientResponseWrapper<>(true, "Success", dto, null));
        } catch (Exception ex) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ClientResponseWrapper<>(false, ex.getMessage(), null, null));
        }
    }
}
