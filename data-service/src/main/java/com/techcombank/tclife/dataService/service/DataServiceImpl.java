package com.techcombank.tclife.dataService.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techcombank.tclife.dataService.model.dto.MTPayload;
import com.techcombank.tclife.dataService.model.entity.MasterTable;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class DataServiceImpl implements DataService{

    @Override
    public MTPayload retrieveMasterTable(String language, String tableCd) throws IOException {
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
        return objectMapper.readValue(new File(resource), MTPayload.class);
    }

    @Override
    public String saveMasterTable(MasterTable table) {
        return "";
    }
}
