package com.techcombank.tclife.dataService.service;


import com.techcombank.tclife.dataService.model.dto.MTPayload;
import com.techcombank.tclife.dataService.model.entity.MasterTable;

import java.io.IOException;

public interface DataService {
    public MTPayload retrieveMasterTable(String Language, String tableCd) throws IOException;
    public String saveMasterTable(MasterTable table);

}
