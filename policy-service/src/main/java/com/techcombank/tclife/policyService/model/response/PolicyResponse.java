package com.techcombank.tclife.policyService.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PolicyResponse {
    private String fullName;
    private String policyNo;
    private String productName;
    private Date effectiveDate;
    @JsonProperty("status")
    private String policyStatus;
}
