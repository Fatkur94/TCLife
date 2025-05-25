package com.techcombank.tclife.integrationService.service;

import com.techcombank.tclife.dataService.controller.DataAPI;
import com.techcombank.tclife.dataService.model.dto.BusinessTblValue;
import com.techcombank.tclife.dataService.model.dto.MTPayload;
import com.techcombank.tclife.dataService.model.dto.Request.MasterRawRequest;
import com.techcombank.tclife.dataService.model.entity.MasterTable;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Service
public class IntegrationServiceImpl implements IntegrationService{
    @Autowired
    private final DataAPI dataAPI;

    @Override
    public String saveENPolicyMasterTable() {
        List<MasterTable> masterTables  = dataAPI.saveENMasterStatus();
        return "";
    }

    @Override
    public List<MasterTable> retrieveMasterTable(String tableCode, String language) {
        List<MasterTable> masterTableList = new ArrayList<>();
        try {
            MTPayload masterRaw = dataAPI.getMasterRaw(new MasterRawRequest(tableCode,language));
            List<BusinessTblValue> valueCode = masterRaw.getBusinessCodeTableValueListList();

            for(BusinessTblValue descValue : valueCode){
                MasterTable policyProposalStatusResponse = new MasterTable();
                policyProposalStatusResponse.setCode(descValue.getCode());
                policyProposalStatusResponse.setDesc(descValue.getDescription());
                masterTableList.add(policyProposalStatusResponse);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return masterTableList;
    }


}
