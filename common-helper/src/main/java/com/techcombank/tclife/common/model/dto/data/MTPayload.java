package com.techcombank.tclife.common.model.dto.data;

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
public class MTPayload {
    @JsonProperty("BusinessCodeTable")
    private BusinessCdTbl businessCodeTable;
    @JsonProperty("BusinessCodeTableValueList")
    private List<BusinessTblValue> businessCodeTableValueListList;

}

