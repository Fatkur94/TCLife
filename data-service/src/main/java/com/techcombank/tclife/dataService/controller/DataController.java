package com.techcombank.tclife.dataService.controller;


import com.techcombank.tclife.common.model.dto.data.MTPayload;
import com.techcombank.tclife.common.model.dto.data.MasterRawRequest;
import com.techcombank.tclife.common.model.dto.data.MasterTable;
import com.techcombank.tclife.dataService.service.DataService;
import com.techcombank.tclife.dataService.service.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/api/v1/data_master")
public class DataController implements DataAPI{

    private final DataService dataService;
    private final RedisService redisService;
    @Override
    public MTPayload getMasterRaw(@RequestBody MasterRawRequest request) throws IOException {
        return dataService.retrieveMasterTable(request.getLanguage(), request.getTableCd());
    }

    @Override
    public List<MasterTable> saveENMasterStatus() {
        return  dataService.saveMasterTable("en_US", "TProposalStatus");
    }

    @Override
    public List<MasterTable> saveVNMasterStatus() {
        return  dataService.saveMasterTable("vn_VN", "TProposalStatus");
    }

    @Override
    public List<MasterTable> saveVNMarriage() {
        return  dataService.saveMasterTable("vn_VN", "TMarriage");
    }

    @Override
    public List<MasterTable> saveENMarriage() {
        return  dataService.saveMasterTable("en_US", "TMarriage");
    }

    @Override
    public List<MasterTable> saveVNOccupation() {
        return  dataService.saveMasterTable("vn_VN", "TOccupation");
    }

    @Override
    public List<MasterTable> saveENOccupation() {
        return  dataService.saveMasterTable("en_US", "TOccupation");
    }

    @Override
    public List<MasterTable> saveVNGender() {
        return  dataService.saveMasterTable("vn_VN", "TGender");
    }

    @Override
    public List<MasterTable> saveENGender() {
        return  dataService.saveMasterTable("en_US", "TGender");
    }

    @Override
    public List<MasterTable> saveVNGRelationshipInsured() {
        return  dataService.saveMasterTable("vn_VN", "TRelationshipToMainInsured");
    }

    @Override
    public List<MasterTable> saveENRelationshipInsured() {
        return  dataService.saveMasterTable("en_US", "TRelationshipToMainInsured");
    }

    @Override
    @GetMapping("/en_US/retrieveStatusPayload")
    public List<MasterTable> getENStatusPayload() {
        return (List<MasterTable>)redisService.getObjectByKey("payloadStatusENG");
    }

    @Override
    @GetMapping("/en_US/retrieveOccupation")
    public List<MasterTable> getENOccupationList() {
        return (List<MasterTable>) redisService.getObjectByKey("occupationENG");

    }
}
