package com.techcombank.tclife.authService.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccessRequest {
    @NotBlank
    private String resource;

    @NotBlank
    private String action;
}
