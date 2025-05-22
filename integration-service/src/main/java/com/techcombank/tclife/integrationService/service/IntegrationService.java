package com.techcombank.tclife.integrationService.service;

import com.techcombank.tclife.dataService.model.entity.MasterTable;

import java.util.List;

public interface IntegrationService {
    public String saveENPolicyMasterTable();
    public List<MasterTable> retrieveMasterTable (String tableCode, String language);
}
