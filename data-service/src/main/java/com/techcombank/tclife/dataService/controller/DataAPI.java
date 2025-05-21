package com.techcombank.tclife.dataService.controller;

import com.techcombank.tclife.dataService.model.dto.MTPayload;
import com.techcombank.tclife.dataService.model.dto.Request.MasterRawRequest;
import com.techcombank.tclife.dataService.model.entity.MasterTable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;

@FeignClient(name = "data-master", url = "${data-master-service.url}", path = "/api/data/master")
public interface DataAPI {
    @GetMapping("masterRaw")
    MTPayload getMasterRaw(@RequestBody MasterRawRequest request) throws IOException;
}
