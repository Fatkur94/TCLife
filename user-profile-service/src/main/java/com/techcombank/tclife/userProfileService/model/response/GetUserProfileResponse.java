package com.techcombank.tclife.userProfileService.model.response;

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
public class GetUserProfileResponse extends BaseResponse {
    private String fullName;
    private LocalDate dob;
    private String gender;
    private String address;
    private String mobilePhone;
    private String email;
    private String idCard;
    private String placeOfIssue;
    private LocalDate dateOfIssue;
    private LocalDate expirationDate;
    private String nationality;
    private String taxCode;
}
