package com.techcombank.tclife.policyService.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommonStatusResponse {
    private String statusCode;
    private String statusDesc;
}
