package com.techcombank.tclife.common.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techcombank.tclife.common.exception.BusinessException;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;
import java.net.URI;
import org.springframework.http.HttpMethod;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;


@Slf4j
public class RestTemplateErrorHandler implements ResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
        return (
                clientHttpResponse.getStatusCode().is4xxClientError()
                        || clientHttpResponse.getStatusCode().is5xxServerError());
    }

    @Override
    public void handleError(URI url, HttpMethod method, ClientHttpResponse clientHttpResponse) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(clientHttpResponse.getBody()));
        String responseBody = reader.lines().collect(Collectors.joining(""));

        ObjectMapper mapper = new ObjectMapper();
        JsonNode responseObj = mapper.readTree(responseBody);

        String rootCause = String.format("Status code: %s, Method: %s, URL: %s, Response Body: %s",
                clientHttpResponse.getStatusCode(), method, url, responseBody);
        if (clientHttpResponse.getStatusCode().is4xxClientError() || clientHttpResponse.getStatusCode().is5xxServerError()){
            if (HttpStatus.GATEWAY_TIMEOUT.equals(clientHttpResponse.getStatusCode()) ||
                    HttpStatus.REQUEST_TIMEOUT.equals(clientHttpResponse.getStatusCode())) {
                log.error("Error Occurred : Timeout");
                throw new BusinessException(
                        (HttpStatus) clientHttpResponse.getStatusCode(),
                        "5030000",
                        responseObj.get("title") != null ? responseObj.get("title").asText() : "",
                        responseObj.get("message") != null ? responseObj.get("message").asText() : "");
            }else {
                log.error("Error Occurred: " + rootCause);
                throw new BusinessException(
                        (HttpStatus) clientHttpResponse.getStatusCode(),
                        responseObj.get("code") != null ? responseObj.get("code").asText() : "",
                        responseObj.get("title") != null ? responseObj.get("title").asText() : "",
                        responseObj.get("message") != null ? responseObj.get("message").asText() : "");
            }
        }else{
            log.error("Error Occurred: " + rootCause);
            throw new BusinessException("5000000", "Unexpected error : "+rootCause);
        }
    }
}

