package com.techcombank.tclife.dataService.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BusinessCdTbl {
    @JsonProperty("@pk")
    private String id;
    @JsonProperty("CodeField")
    private String codeField;
    @JsonProperty("CodeTable")
    private String codeTable;
    @JsonProperty("DescField")
    private String descField;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("EsCodeTableFlag")
    private String esCodeTableFlag;
    @JsonProperty("GroupId")
    private String groupId;
    @JsonProperty("IdField")
    private String idField;
    @JsonProperty("IsSmall")
    private String IsSmall;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("NeedCache")
    private String needCache;
    @JsonProperty("NeedMultipleLanguage")
    private String needMultipleLanguage;
    @JsonProperty("RecordUsage")
    private String recordUsage;
    @JsonProperty("ServiceName")
    private String serviceName;
    @JsonProperty("SortType")
    private String SortType;
}
