package com.techcombank.tclife.policyService.model.response;

import com.techcombank.tclife.common.base.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetPolicyDetailResponse extends BaseResponse {
    private String policyNo;
    private String servicingBranch;
    private LocalDate issueDate;
    private String policyStatus;
    private LocalDate commenceDate;
    private LocalDate coverEndDate;
    private String productName;
    private String productCode;
    private String lifeAssured;
    private Double sumAssured;
    private Integer unit;
    private Integer level;
    private String premiumStatus;
    private Double standardPremium;
}

//{
//  "policyNo": "POL123456789",
//  "servicingBranch": "Jakarta Central",
//  "issueDate": "2025-01-15",
//  "policyStatus": "Active",
//  "commenceDate": "2025-02-01",
//  "coverEndDate": "2026-01-31",
//  "productName": "LifeSecure Plus",
//  "productCode": "LSP001",
//  "lifeAssured": "John Doe",
//  "sumAssured": 1000000.00,
//  "unit": 10,
//  "level": 2,
//  "premiumStatus": "Paid",
//  "standardPremium": 12000.50
//}