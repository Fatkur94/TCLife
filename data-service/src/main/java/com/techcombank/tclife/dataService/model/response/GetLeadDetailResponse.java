package com.techcombank.tclife.dataService.model.response;


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
public class GetLeadDetailResponse extends BaseResponse {
    private String fullName;
    private LocalDate dob;
    private String gender;
    private String bankSegment;
    private String insuranceSegment;
    private String occupation;
    private String mainInsured;
}