package com.techcombank.tclife.dataService.model.request;

import com.techcombank.tclife.common.base.BaseRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostLeadRequest extends BaseRequest {
    private String refCode;
    private Date referralDate;
    private String bankStaffId;
    private String bankStaffName;
    private String branchCode;
    private String customerId;
    private String customerName;
    private String identityCustomerInfo;
    private String identityType;
    private Date poDob;
    private String poGender;
    private Date poidentityIssueDate;
    private Date poidentityExpDate;
    private String poEmail;
    private String phone;
    private String address;
    private String iOISCode;
    private String provinceCode;
    private String districtCode;
    private String wardCode;
    private String amlInlist;
    private String amStatus;
    private String channel;
    private String insPartner;
}
