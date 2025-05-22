package com.techcombank.tclife.leadService;

import com.techcombank.tclife.common.security.annotation.EnableApiSecurity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableApiSecurity
@SpringBootApplication
@ComponentScan(basePackages = {
		"com.techcombank.tclife.leadService",
		"com.techcombank.tclife.common.exception"
})
@EnableFeignClients
public class LeadServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeadServiceApplication.class, args);
	}

}
