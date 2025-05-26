package com.techcombank.tclife.dataService.controller;

import com.techcombank.tclife.common.model.dto.data.MTPayload;
import com.techcombank.tclife.common.model.dto.data.MasterRawRequest;
import com.techcombank.tclife.common.model.dto.data.MasterTable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.util.List;

@FeignClient(name = "data-service", url = "${data-service.url}", path = "/api/v1/data_master")
public interface DataAPI {
    @GetMapping("/masterRaw")
    public MTPayload getMasterRaw(@RequestBody MasterRawRequest request) throws IOException;

    @PostMapping("/en_US/saveMasterPolicyProposalStatus")
    public List<MasterTable> saveENMasterStatus();

    @PostMapping("/vn_VN/saveMasterPolicyProposalStatus")
    public List<MasterTable> saveVNMasterStatus();

    @PostMapping("/vn_VN/saveMasterMarriage")
    public List<MasterTable> saveVNMarriage();

    @PostMapping("/en_US/saveMasterMarriage")
    public List<MasterTable> saveENMarriage();

    @PostMapping("/vn_VN/saveMasterOccupation")
    public List<MasterTable> saveVNOccupation();

    @PostMapping("/en_US/saveMasterOccupation")
    public List<MasterTable> saveENOccupation();

    @PostMapping("/vn_VN/saveMasterGender")
    public List<MasterTable> saveVNGender();

    @PostMapping("/en_US/saveMasterGender")
    public List<MasterTable> saveENGender();

    @PostMapping("/vn_VN/saveMasterRelationshipInsured")
    public List<MasterTable> saveVNGRelationshipInsured();

    @PostMapping("/en_US/saveMasterRelationshipInsured")
    public List<MasterTable> saveENRelationshipInsured();

    @GetMapping("/en_US/retrieveStatusPayload")
    public List<MasterTable> getENStatusPayload();

    @GetMapping("/en_US/retrieveOccupation")
    public List<MasterTable> getENOccupationList();

}
