package com.techcombank.tclife.dataService.service;

import com.techcombank.tclife.dataService.model.dto.MTPayload;
import com.techcombank.tclife.dataService.model.entity.MasterTable;

import java.io.IOException;
import java.util.List;

public interface DataService {
    MTPayload retrieveMasterTable(String language, String tableCd) throws IOException;
    List<MasterTable> saveMasterTable(String language, String tableCd);
}
