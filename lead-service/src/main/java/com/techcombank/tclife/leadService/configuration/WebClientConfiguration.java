package com.techcombank.tclife.leadService.configuration;

//@Configuration
//@Slf4j
public class WebClientConfiguration {
//
//    @Value("${integration.portal.connect-timeout}")
//    private Integer portalConnectionTimeout;
//
//    @Value("${integration.portal.read-timeout}")
//    private Integer portalReadTimeout;
//
//    @Value("${integration.portal.secret-key.value}")
//    private String secretKeyValue;
//
//    @Bean(name = "portalWebClient")
//    public WebClient portalWebClient() {
//        HttpClient httpClient = HttpClient.create()
//                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, portalConnectionTimeout)
//                .responseTimeout(Duration.ofMillis(portalReadTimeout));
//
//        return WebClient.builder()
//                .clientConnector(new ReactorClientHttpConnector(httpClient))
//                .defaultHeader("X-Secret-Key", secretKeyValue)
//                .filters(exchangeFilterFunctions -> {
//                    exchangeFilterFunctions.add(logRequest());
//                    exchangeFilterFunctions.add(WebClientErrorHandler.errorHandlingFilter());
//                })
//                .build();
//    }
//
//    @Bean
//    public ExchangeFilterFunction logRequest() {
//        return ExchangeFilterFunction.ofRequestProcessor(clientRequest -> {
//            log.info("Request: {} {}", clientRequest.method(), clientRequest.url());
//            return Mono.just(clientRequest);
//        });
//    }

}

