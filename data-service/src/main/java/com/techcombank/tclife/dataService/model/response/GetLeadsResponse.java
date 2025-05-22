package com.techcombank.tclife.dataService.model.response;

import com.techcombank.tclife.common.base.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetLeadsResponse extends BaseResponse {
    private String leadId;
    private String fullName;
    private Date dob;
    private Date creationDate;
    private Integer leadAging;
}
