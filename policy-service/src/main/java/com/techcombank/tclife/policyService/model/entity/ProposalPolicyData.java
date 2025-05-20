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
public class ProposalPolicyData {
    @JsonProperty("BranchId")
    private long branchId;

    @JsonProperty("FruzzyCertiCode")
    private boolean fruzzyCertiCode;

    @JsonProperty("FruzzyRegisterCode")
    private boolean fruzzyRegisterCode;

    @JsonProperty("MainProduct")
    private String mainProduct;

    @JsonProperty("OperatedBy")
    private long operatedBy;

    @JsonProperty("PageIndex")
    private int pageIndex;

    @JsonProperty("PageSize")
    private int pageSize;

    @JsonProperty("PolicyHolder")
    private String policyHolder;

    @JsonProperty("PolicyHolderBirthday")
    private String policyHolderBirthday;

    @JsonProperty("PolicyHolderInsuredOrCondition")
    private boolean policyHolderInsuredOrCondition;

    @JsonProperty("PolicyInsured")
    private String policyInsured;

    @JsonProperty("PolicyNo")
    private String policyNo;

    @JsonProperty("PolicySerialId")
    private long policySerialId;

    @JsonProperty("PolicyStatus")
    private String policyStatus;

    @JsonProperty("ProposalNo")
    private String proposalNo;

    @JsonProperty("RegistrationDate")
    private String registrationDate;

    @JsonProperty("ResultContainsRiskStatus")
    private boolean resultContainsRiskStatus;

    @JsonProperty("SearchMainInsured")
    private boolean searchMainInsured;

    @JsonProperty("ServiceAgentCode")
    private String serviceAgentCode;

    @JsonProperty("SubmissionDate")
    private String submissionDate;

    @JsonProperty("UwSubStatus")
    private Integer uwSubStatus;
}
