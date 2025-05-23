package com.techcombank.tclife.dataService.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techcombank.tclife.dataService.model.dto.BusinessTblValue;
import com.techcombank.tclife.dataService.model.dto.MTPayload;
import com.techcombank.tclife.dataService.model.entity.MasterTable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DataServiceImpl implements DataService{

    private final RedisService redisService;

    @Override
    public MTPayload retrieveMasterTable(String language, String tableCd) throws IOException {
        String resource = null;
        if(tableCd.equals("TProposalStatus")) {
            resource = switch (language) {
                case "en_US" ->
                        "C:\\Users\\dsutomo\\apps\\workspace\\TCLife\\policy-service\\src\\main\\resources\\mockJson\\policyStatusMock.json";
                case "th_TH" ->
                        "C:\\Users\\dsutomo\\apps\\workspace\\TCLife\\policy-service\\src\\main\\resources\\mockJson\\policyStatusMockTH.json";
                case "zh_CN" ->
                        "C:\\Users\\dsutomo\\apps\\workspace\\TCLife\\policy-service\\src\\main\\resources\\mockJson\\policyStatusMockCN.json";
                case "zh_TW" ->
                        "C:\\Users\\dsutomo\\apps\\workspace\\TCLife\\policy-service\\src\\main\\resources\\mockJson\\policyStatusMockTW.json";
                default ->
                        "C:\\Users\\dsutomo\\apps\\workspace\\TCLife\\policy-service\\src\\main\\resources\\mockJson\\policyStatusMock.json";
            };
        }
        //later change to response from external
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(resource), MTPayload.class);
    }

    @Override
    public List<MasterTable> saveMasterTable(String language, String tableCd) {
        /*
        //need to call api mastertable from data service
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", token);
        headers.set("Lang", language);

        // Prepare payload
        JSONObject payload = new JSONObject();
        payload.put("CodeTableName", tableCode);

        // Create HTTP entity with payload and headers
        HttpEntity<String> requestEntity = new HttpEntity<>(payload.toString(), headers);

        // updateURL
        String apiUrl = "https://api.example.com/endpoint";

        try {
            return restTemplate.postForObject(apiUrl, requestEntity, String.class);
        } catch (Exception e) {
            return "Error calling API: " + e.getMessage();
        }*/

        //api will return payload --> convert the payload json to entity

        String resource = null;
        if(tableCd.equals("TProposalStatus")) {
            resource = switch (language) {
                case "en_US" ->
                        "C:\\Users\\dsutomo\\apps\\workspace\\TCLife\\policy-service\\src\\main\\resources\\mockJson\\policyStatusMock.json";
                case "th_TH" ->
                        "C:\\Users\\dsutomo\\apps\\workspace\\TCLife\\policy-service\\src\\main\\resources\\mockJson\\policyStatusMockTH.json";
                case "zh_CN" ->
                        "C:\\Users\\dsutomo\\apps\\workspace\\TCLife\\policy-service\\src\\main\\resources\\mockJson\\policyStatusMockCN.json";
                case "zh_TW" ->
                        "C:\\Users\\dsutomo\\apps\\workspace\\TCLife\\policy-service\\src\\main\\resources\\mockJson\\policyStatusMockTW.json";
                default ->
                        "C:\\Users\\dsutomo\\apps\\workspace\\TCLife\\policy-service\\src\\main\\resources\\mockJson\\policyStatusMock.json";
            };
        }
        //later change to response from external
        ObjectMapper objectMapper = new ObjectMapper();
        List<MasterTable> masterTableList = new ArrayList<>();
        try {
            MTPayload masterRaw =  objectMapper.readValue(new File(resource), MTPayload.class);
            List<BusinessTblValue> valueCode = masterRaw.getBusinessCodeTableValueListList();

            for(BusinessTblValue descValue : valueCode){
                MasterTable policyProposalStatusResponse = new MasterTable();
                policyProposalStatusResponse.setCode(descValue.getCode());
                policyProposalStatusResponse.setDesc(descValue.getDescription());
                masterTableList.add(policyProposalStatusResponse);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if(tableCd.equals("TProposalStatus")) {
            switch (language) {
                case "en_US" -> redisService.saveData("payloadStatusENG", masterTableList);
                case "th_TH" -> redisService.saveData("payloadStatusTH", masterTableList);
                case "zh_CN" -> redisService.saveData("payloadStatusCN", masterTableList);
                case "zh_TW" -> redisService.saveData("payloadStatusTW", masterTableList);
                default -> redisService.saveData("payloadStatus", masterTableList);
            };
        }

        return masterTableList;
    }
}
