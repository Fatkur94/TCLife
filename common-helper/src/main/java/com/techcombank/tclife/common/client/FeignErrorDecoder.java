package com.techcombank.tclife.common.client;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techcombank.tclife.common.exception.BusinessException;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@Slf4j
public class FeignErrorDecoder implements ErrorDecoder {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Exception decode(String methodKey, Response response) {
        log.info("response {}", response.getClass());
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(response.body().asInputStream()))) {
            String responseBody = reader.lines().collect(Collectors.joining(""));
            JsonNode responseObj = objectMapper.readTree(responseBody);

            HttpStatus status = HttpStatus.valueOf(response.status());
            String rootCause = String.format("Status code: %s, Method: %s, URL: %s, Response Body: %s",
                    response.status(), methodKey, response.request().url(), responseBody);

            if (status.is4xxClientError() || status.is5xxServerError()) {
                if (status == HttpStatus.GATEWAY_TIMEOUT || status == HttpStatus.REQUEST_TIMEOUT) {
                    log.error("Error Occurred : Timeout");
                    return new BusinessException(
                            status,
                            "5030000",
                            responseObj.path("title").asText(""),
                            "");
                } else {
                    log.error("Error Occurred: {}", rootCause);
                    return new BusinessException(
                            status,
                            responseObj.path("code").asText(""),
                            responseObj.path("title").asText(""),
                            responseObj.path("message").asText(""));
                }
            } else {
                log.error("Unexpected Error: {}", rootCause);
                return new BusinessException("5000000", "Unexpected error: " + rootCause);
            }
        } catch (IOException e) {
            log.error("Failed to decode error response", e);
            return new BusinessException("5000000", "Failed to decode error response: " + e.getMessage());
        }
    }
}
