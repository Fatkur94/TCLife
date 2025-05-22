package com.techcombank.tclife.dataService.controller;

import com.techcombank.tclife.dataService.model.dto.MTPayload;
import com.techcombank.tclife.dataService.model.dto.Request.MasterRawRequest;
import com.techcombank.tclife.dataService.model.entity.MasterTable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.util.List;

@FeignClient(name = "data-master", url = "${data-service.url}", path = "/api/data/master")
public interface DataAPI {
    @GetMapping("/masterRaw")
    public MTPayload getMasterRaw(@RequestBody MasterRawRequest request) throws IOException;

    @PostMapping("/en_US/saveMasterPolicyProposalStatus")
    public List<MasterTable> saveENMasterStatus();

    @GetMapping("/en_US/retrieveStatusPayload")
    public List<MasterTable> getENStatusPayload();

}
