package com.techcombank.tclife.common.handler;

import ch.qos.logback.classic.util.LogbackMDCAdapter;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techcombank.tclife.common.exception.BusinessException;
import com.techcombank.tclife.common.exception.TechnicalException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import reactor.core.publisher.Mono;

import org.springframework.web.reactive.function.client.*;

import java.net.ConnectException;
import java.net.UnknownHostException;

@Slf4j
public class WebClientErrorHandler {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static ExchangeFilterFunction errorHandlingFilter() {
        return ExchangeFilterFunction.ofResponseProcessor(WebClientErrorHandler::handleHttpError)
                .andThen(ExchangeFilterFunction.ofResponseProcessor(clientResponse -> Mono.just(clientResponse)))
                .andThen(errorHandlingExceptionFilter());
    }

    private static Mono<ClientResponse> handleHttpError(ClientResponse response) {
        if (response.statusCode().is4xxClientError() || response.statusCode().is5xxServerError()) {
            return response.bodyToMono(String.class)
                    .flatMap(body -> {
                        String code = "5030000";
                        String title = "TIMEOUT";
                        String message = "Http Error Gateway Timeout";

                        log.error("HTTP error: {} - Body: {}", response.statusCode(), body);
                        if (HttpStatus.GATEWAY_TIMEOUT.equals(response.statusCode()) ||
                                HttpStatus.REQUEST_TIMEOUT.equals(response.statusCode())) {
                            log.error("Error Occurred : Timeout");
                            LogbackMDCAdapter jsonBody;
                            return Mono.error( new TechnicalException(
                                    (HttpStatus) response.statusCode(),
                                    code,
                                    title,
                                    message
                            ));
                        }
                        try {
                            JsonNode json = mapper.readTree(body);
                            if (json.has("code")) code = json.get("code").asText();
                            if (json.has("title")) title = json.get("title").asText();
                            if (json.has("message")) message = json.get("message").asText();
                        } catch (Exception e) {
                            log.warn("Failed to parse error body as JSON: {}", e.getMessage());
                        }
                        return Mono.error( new BusinessException(
                                (HttpStatus) response.statusCode(),
                                code,
                                title,
                                message
                        ));

                    });
        }
        return Mono.just(response);
    }

    private static ExchangeFilterFunction errorHandlingExceptionFilter() {
        return ExchangeFilterFunction.ofResponseProcessor(clientResponse -> Mono.just(clientResponse))
                .andThen((request, next) -> next.exchange(request)
                        .onErrorMap(throwable -> {
                            if (throwable instanceof WebClientRequestException) {
                                Throwable cause = throwable.getCause();
                                if (cause instanceof ConnectException ||
                                        cause instanceof UnknownHostException ||
                                        cause instanceof io.netty.channel.ConnectTimeoutException) {
                                    log.error("Network error: {}", cause.getMessage());
                                    return new BusinessException(
                                            HttpStatus.SERVICE_UNAVAILABLE,
                                            "5030000",
                                            "Network error",
                                            cause.getMessage()
                                    );
                                }
                            }
                            return throwable;
                        }));
    }
}


