package com.techcombank.tclife.integrationService.service;

import com.techcombank.tclife.common.model.dto.data.MasterTable;

import java.util.List;

public interface IntegrationService {
    public String saveENPolicyMasterTable();
    public List<MasterTable> saveVNPolicyMasterTable();
    public List<MasterTable> saveENOccupationMasterTable();
    public List<MasterTable> retrieveMasterTable (String tableCode, String language);
}
