package com.techcombank.tclife.quotationService;

import com.techcombank.tclife.common.security.annotation.EnableApiSecurity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableApiSecurity
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
