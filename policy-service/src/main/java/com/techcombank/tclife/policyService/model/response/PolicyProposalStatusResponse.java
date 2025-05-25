package com.techcombank.tclife.policyService.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PolicyProposalStatusResponse {
    private String code;
    private String desc;


}
