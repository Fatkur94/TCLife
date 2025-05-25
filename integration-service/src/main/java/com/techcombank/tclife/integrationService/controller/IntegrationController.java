package com.techcombank.tclife.integrationService.controller;

import com.techcombank.tclife.dataService.model.entity.MasterTable;
import com.techcombank.tclife.integrationService.request.MasterTableRequest;
import com.techcombank.tclife.integrationService.service.IntegrationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/integration")
@Tag(name = "Integration Service", description = "APIs for managing integration")
@RequiredArgsConstructor
@Validated
public class IntegrationController {

    private final IntegrationService integrationService;

    @PostMapping("/savePolicyProposalStatusEng")
    public String saveENMasterTablePolicyProposalStatus() {
        return ("Saved: ").concat(integrationService.saveENPolicyMasterTable());
    }

    @PostMapping("/savePolicyProposalStatusVN")
    public String saveVNMasterTablePolicyProposalStatus() {
        return ("Saved: ").concat(integrationService.saveVNPolicyMasterTable().toString());
    }

    @PostMapping("/saveOccupationEN")
    public String saveENMasterTableOccupation() {
        return ("Saved: ").concat(integrationService.saveENOccupationMasterTable().toString());
    }

    @GetMapping(value = "/rawList")
    public List<MasterTable> getPolicyProposalStatus(@RequestBody MasterTableRequest requestDTO) throws IOException {
        return integrationService.retrieveMasterTable(requestDTO.getTableCd(), requestDTO.getLanguage());
    }

}
