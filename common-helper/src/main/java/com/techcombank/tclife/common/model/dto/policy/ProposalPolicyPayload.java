package com.techcombank.tclife.common.model.dto.policy;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProposalPolicyPayload {
    @JsonProperty("Data")
    private List<ProposalPolicyData> data;

    @JsonProperty("Page")
    private ProposalPolicyPage page;

    @JsonProperty("Status")
    private String status;
}
