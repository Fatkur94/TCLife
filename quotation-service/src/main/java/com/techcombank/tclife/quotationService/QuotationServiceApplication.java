package com.techcombank.tclife.quotationService;

import com.techcombank.tclife.common.annotation.EnableCommonConfig;
import com.techcombank.tclife.common.security.annotation.EnableApiSecurity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableApiSecurity
@SpringBootApplication(
		exclude = {
				DataSourceAutoConfiguration.class
		}
)
@EnableCommonConfig
@EnableFeignClients
public class QuotationServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(QuotationServiceApplication.class, args);
	}
}
