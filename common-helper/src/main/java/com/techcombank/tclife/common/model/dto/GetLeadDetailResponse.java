package com.techcombank.tclife.common.model.dto;

import com.techcombank.tclife.common.base.BaseResponse;
import lombok.*;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
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
