package com.techcombank.tclife.claimService.model.response;

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
public class ClaimResponse {
    private String claimNo;
    private String claimType;
    private String insured;
    private String policyNo;
    private Date notificationDate;
    private Date approvalDate;
    @JsonProperty("status")
    private String claimStatus;
}
