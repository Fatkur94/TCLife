package com.techcombank.tclife.authService.adaptor;

//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.web.client.RestTemplate;

public class ClaimServiceAdaptor {
//    @Value("${integration.tcb.claim.hello.url}")
//    private String claimHelloUrl;
//
//    private RestTemplate omniRestTemplate;
//
//    public ClaimServiceAdaptor(@Qualifier(value = "tcbRestTemplate") RestTemplate tcbRestTemplate) {
//        this.omniRestTemplate = omniRestTemplate;
//    }
//
//
//    @CentralCache(distribution = CacheDistributionType.SHARED,
//            name = "card-inquiry",
//            key = "{#cardCategory, #productCode, #pageSize}",
//            clazz = GetCardInquiryResponse.class)
//    public GetCardInquiryResponse getCardInquiry(String productCode, Integer pageSize, String cardCategory) {
//        UriComponents uriComponents = UriComponentsBuilder
//                .fromHttpUrl(cardInquiryUrl)
//                .queryParam(QUERY_PRODUCT_CODE, productCode)
//                .queryParam(QUERY_PAGE_SIZE, pageSize)
//                .queryParam(QUERY_CARD_CATEGORY, cardCategory)
//                .build();
//
//        return omniRestTemplate.exchange(uriComponents.toString(),
//                HttpMethod.GET, null, GetCardInquiryResponse.class).getBody();
//    }
//
//    public GetCardInquiryResponse getCardInquiryWithPageNumber(Integer pageNumber,
//                                                               Integer pageSize,
//                                                               String cardCategory,
//                                                               String binNumber,
//                                                               String cardType,
//                                                               String sortBy) {
//        var uriComponents = UriComponentsBuilder
//                .fromHttpUrl(cardInquiryUrl)
//                .queryParam(QUERY_PAGE_NUMBER, pageNumber)
//                .queryParam(QUERY_PAGE_SIZE, pageSize)
//                .queryParam(QUERY_CARD_CATEGORY, cardCategory)
//                .queryParam(QUERY_BIN_NUMBER, binNumber)
//                .queryParam(QUERY_CARD_TYPE, cardType)
//                .queryParam("sortBy", sortBy)
//                .build();
//
//        return omniRestTemplate.exchange(uriComponents.toString(),
//                HttpMethod.GET, null, GetCardInquiryResponse.class).getBody();
//    }
//
//    @CentralCache(distribution = CacheDistributionType.SHARED,
//            name = "admin-card-inquiry",
//            key = "{#cardCategory, #productCode, #pageSize}",
//            clazz = GetCardInquiryResponse.class)
//    public GetCardInquiryResponse getAdminCardInquiry(String productCode, Integer pageSize, String cardCategory) {
//        UriComponents uriComponents = UriComponentsBuilder
//                .fromHttpUrl(cardAdminInquiryUrl)
//                .queryParam(QUERY_PRODUCT_CODE, productCode)
//                .queryParam(QUERY_PAGE_SIZE, pageSize)
//                .queryParam(QUERY_CARD_CATEGORY, cardCategory)
//                .build();
//
//        return omniRestTemplate.exchange(uriComponents.toString(),
//                HttpMethod.GET, null, GetCardInquiryResponse.class).getBody();
//    }
//
//    public GetCardInquiryResponse getCardInquiryWithBinAndProductCode(String bin, String productCode) {
//        UriComponents uriComponents = UriComponentsBuilder
//                .fromHttpUrl(cardInquiryUrl)
//                .queryParam("bin", bin)
//                .queryParam(QUERY_PRODUCT_CODE, productCode)
//                .build();
//
//        return omniRestTemplate.exchange(uriComponents.toString(),
//                HttpMethod.GET, null, GetCardInquiryResponse.class).getBody();
//    }
//
//    public GetCardInquiryResponse getCardInquiryWithBin(String bin) {
//        UriComponents uriComponents = UriComponentsBuilder
//                .fromHttpUrl(cardInquiryUrl)
//                .queryParam("bin", bin)
//                .build();
//
//        return omniRestTemplate.exchange(uriComponents.toString(),
//                HttpMethod.GET, null, GetCardInquiryResponse.class).getBody();
//    }
//
//    public GetCardInquiryResponse getCardInquiryWithProductCode(String productCode) {
//        UriComponents uriComponents = UriComponentsBuilder
//                .fromHttpUrl(cardInquiryUrl)
//                .queryParam(QUERY_PRODUCT_CODE, productCode)
//                .build();
//
//        return omniRestTemplate.exchange(uriComponents.toString(),
//                HttpMethod.GET, null, GetCardInquiryResponse.class).getBody();
//    }
}
