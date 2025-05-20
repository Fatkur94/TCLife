package com.techcombank.tclife.policyService.model.entity;

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
public class DataTable {
    @JsonProperty("BusinessCodeTable")
    private BusinessCodeTable businessCodeTable;
    @JsonProperty("BusinessCodeTableValueList")
    private List<BusinessCodeTableValueList> businessCodeTableValueListList;

}
