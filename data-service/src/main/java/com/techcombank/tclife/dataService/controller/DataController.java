package com.techcombank.tclife.dataService.controller;


import com.techcombank.tclife.dataService.model.dto.MTPayload;
import com.techcombank.tclife.dataService.model.dto.Request.MasterRawRequest;
import com.techcombank.tclife.dataService.model.entity.MasterTable;
import com.techcombank.tclife.dataService.service.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
public class DataController implements  DataAPI{

    private final DataService dataService;
    @Override
    public MTPayload getMasterRaw(@RequestBody MasterRawRequest request) throws IOException {
        return dataService.retrieveMasterTable(request.getLanguage(), request.getTableCd());
    }
}
