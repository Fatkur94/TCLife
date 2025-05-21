package com.techcombank.tclife.integrationService.service;

import com.techcombank.tclife.dataService.model.entity.MasterTable;

import java.util.List;

public interface IntegrationService {
    public String saveMasterTable (String tableCode, String language);
    public List<MasterTable> retrieveMasterTable (String tableCode, String language);
}
