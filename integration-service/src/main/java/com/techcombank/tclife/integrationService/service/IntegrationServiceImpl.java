package com.techcombank.tclife.integrationService.service;

import com.techcombank.tclife.common.model.dto.data.BusinessTblValue;
import com.techcombank.tclife.common.model.dto.data.MTPayload;
import com.techcombank.tclife.common.model.dto.data.MasterRawRequest;
import com.techcombank.tclife.common.model.dto.data.MasterTable;
import com.techcombank.tclife.integrationService.client.ProposalPolicyDataClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Service
public class IntegrationServiceImpl implements IntegrationService{
    private final ProposalPolicyDataClient proposalPolicyDataClient;
    @Override
    public String saveENPolicyMasterTable() {
        List<MasterTable> masterTables  = proposalPolicyDataClient.saveENMasterStatus();
        return masterTables.toString();
    }

    @Override
    public List<MasterTable> saveVNPolicyMasterTable() {
        return proposalPolicyDataClient.saveENMasterStatus();
    }

    @Override
    public List<MasterTable> saveENOccupationMasterTable() {
        return proposalPolicyDataClient.saveENOccupation();
    }

    @Override
    public List<MasterTable> retrieveMasterTable(String tableCode, String language) {
        List<MasterTable> masterTableList = new ArrayList<>();
        try {
            MTPayload masterRaw = proposalPolicyDataClient.getMasterRaw(new MasterRawRequest(tableCode,language));
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
