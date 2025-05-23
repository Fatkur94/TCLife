package com.techcombank.tclife.leadService;

import com.techcombank.tclife.common.annotation.EnableCommonConfig;
import com.techcombank.tclife.common.security.annotation.EnableApiSecurity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableApiSecurity
@SpringBootApplication
@EnableFeignClients
@EnableCommonConfig
public class LeadServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeadServiceApplication.class, args);
	}

}
