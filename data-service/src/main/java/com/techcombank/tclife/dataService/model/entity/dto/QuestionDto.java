package com.techcombank.tclife.dataService.model.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class QuestionDto {
    private String id;
    private String parentQuestionId;
    private String title;
    private String smallTitle;
    private String description;
    private String type;
    private String inputName;
    private String regex;
    private Boolean isRepeatable;
    private Boolean isRequired;
    private String prefix;
    private String suffix;
    private Integer span;
    private List<OptionDto> options;
    private List<QuestionDto> children;
    private ReferenceInfoDto referenceInfo;
}
