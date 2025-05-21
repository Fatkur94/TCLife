package com.techcombank.tclife.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.StdDateFormat;

public class JacksonUtil {

    private final ObjectMapper objectMapper;

    private JacksonUtil(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    // Factory method for default ObjectMapper
    public static JacksonUtil createDefault() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.setDateFormat(new StdDateFormat().withColonInTimeZone(true)); // ISO 8601
        return new JacksonUtil(mapper);
    }

    public static JacksonUtil from(ObjectMapper objectMapper) {
        return new JacksonUtil(objectMapper);
    }

    public String toJson(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to convert object to JSON", e);
        }
    }

    public <T> T fromJson(String json, Class<T> clazz) {
        try {
            return objectMapper.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to convert JSON to object", e);
        }
    }
}
