package com.techcombank.tclife.policyService.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProposalPolicyPage {
    @JsonProperty("PageIndex")
    private int pageIndex;

    @JsonProperty("Size")
    private int size;

    @JsonProperty("TotalElements")
    private int totalElements;

    @JsonProperty("TotalPages")
    private int totalPages;
}
