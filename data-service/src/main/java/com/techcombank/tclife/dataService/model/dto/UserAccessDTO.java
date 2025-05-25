package com.techcombank.tclife.dataService.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAccessDTO {
    private UUID userId;
    private UUID cognitoSub;
    private String email;
    private String role;
    private List<String> permissions;
}
