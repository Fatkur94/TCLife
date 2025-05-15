package com.techcombank.tclife.quotationService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
		"com.techcombank.tclife.quotationService",
		"com.techcombank.tclife.common.exception"
})
public class QuotationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuotationServiceApplication.class, args);
	}

}
