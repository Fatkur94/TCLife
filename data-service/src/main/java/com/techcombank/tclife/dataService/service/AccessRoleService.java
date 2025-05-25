package com.techcombank.tclife.dataService.service;

import com.techcombank.tclife.dataService.model.dto.UserAccessDTO;

import java.util.UUID;

public interface AccessRoleService {
    UserAccessDTO getUserAccessByCognitoSub(UUID sub);
}
