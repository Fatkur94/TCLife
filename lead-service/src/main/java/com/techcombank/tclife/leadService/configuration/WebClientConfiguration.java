package com.techcombank.tclife.leadService.configuration;


import com.techcombank.tclife.common.handler.WebClientErrorHandler;
import io.netty.channel.ChannelOption;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;

@Configuration
@Slf4j
public class WebClientConfiguration {

    @Value("${integration.portal.connect-timeout}")
    private Integer portalConnectionTimeout;

    @Value("${integration.portal.read-timeout}")
    private Integer portalReadTimeout;

    @Value("${integration.portal.secret-key.value}")
    private String secretKeyValue;

    @Bean(name = "portalWebClient")
    public WebClient portalWebClient() {
        HttpClient httpClient = HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, portalConnectionTimeout)
                .responseTimeout(Duration.ofMillis(portalReadTimeout));

        return WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .defaultHeader("X-Secret-Key", secretKeyValue)
                .filters(exchangeFilterFunctions -> {
                    exchangeFilterFunctions.add(logRequest());
                    exchangeFilterFunctions.add(WebClientErrorHandler.errorHandlingFilter());
                })
                .build();
    }

    @Bean
    public ExchangeFilterFunction logRequest() {
        return ExchangeFilterFunction.ofRequestProcessor(clientRequest -> {
            log.info("Request: {} {}", clientRequest.method(), clientRequest.url());
            return Mono.just(clientRequest);
        });
    }

}

