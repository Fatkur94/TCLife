package com.techcombank.tclife.dataService.service;

import com.techcombank.tclife.common.model.EmptyResponse;
import com.techcombank.tclife.common.service.BaseService;
import com.techcombank.tclife.common.util.CommonUtil;
import com.techcombank.tclife.common.wrapper.ResponseWrapper;
import com.techcombank.tclife.dataService.model.entity.Lead;
import com.techcombank.tclife.dataService.model.request.PostLeadRequest;
import com.techcombank.tclife.dataService.repository.LeadRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PostLeadService implements BaseService<PostLeadRequest, EmptyResponse> {

    private LeadRepository leadRepository;

    public PostLeadService(LeadRepository leadRepository) {
        this.leadRepository = leadRepository;
    }

    @Override
    public ResponseWrapper<EmptyResponse> proceed(PostLeadRequest input) {
        Lead lead = Lead.builder()
                .Id(CommonUtil.generateUUIDString())
                .refCode(input.getRefCode())
                .referralDate(input.getReferralDate())
                .bankStaffId(input.getBankStaffId())
                .bankStaffName(input.getBankStaffName())
                .branchCode(input.getBranchCode())
                .customerId(input.getCustomerId())
                .customerName(input.getCustomerName())
                .identityCustomerInfo(input.getIdentityCustomerInfo())
                .identityType(input.getIdentityType())
                .poDob(input.getPoDob())
                .poGender(input.getPoGender())
                .poidentityIssueDate(input.getPoidentityIssueDate())
                .poidentityExpDate(input.getPoidentityExpDate())
                .poEmail(input.getPoEmail())
                .phone(input.getPhone())
                .address(input.getAddress())
                .iOISCode(input.getIOISCode())
                .provinceCode(input.getProvinceCode())
                .districtCode(input.getDistrictCode())
                .wardCode(input.getWardCode())
                .amlInlist(input.getAmlInlist())
                .amStatus(input.getAmStatus())
                .channel(input.getChannel())
                .insPartner(input.getInsPartner())
                .build();

        lead.setCreatedBy("SYSTEM");
        lead.setUpdatedBy("SYSTEM");

        leadRepository.save(lead);
        log.info("successfully insert lead with refCode %s", lead.getRefCode());

        return successResponse(new EmptyResponse());
    }
}
