package com.techcombank.tclife.common.base;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseRequest implements Serializable {

}