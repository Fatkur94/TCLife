package com.techcombank.tclife.quotationService;

import com.techcombank.tclife.common.security.annotation.EnableApiSecurity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableApiSecurity
@SpringBootApplication(
		exclude = {
				DataSourceAutoConfiguration.class
		}
)
@ComponentScan(basePackages = {
		"com.techcombank.tclife.quotationService",
		"com.techcombank.tclife.common.exception"
})
@EnableFeignClients(basePackages = "com.techcombank.tclife.dataService.controller")
public class QuotationServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(QuotationServiceApplication.class, args);
	}
}
