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
public class ProposalResponse {
    private String customerName;
    @JsonProperty("dob")
    private Date dob;
    private String leadId;
    @JsonProperty("creationDate")
    private Date creationDate;
    private String proposalNo;
    @JsonProperty("status")
    private String proposalStatus;
}
