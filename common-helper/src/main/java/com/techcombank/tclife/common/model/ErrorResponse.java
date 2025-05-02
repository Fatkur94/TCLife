package com.techcombank.tclife.common.model;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ErrorResponse implements Serializable {
    private String code;
    private String title;
    private String message;
}

