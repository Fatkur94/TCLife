package com.techcombank.tclife.policyService;

import com.techcombank.tclife.common.annotation.EnableCommonConfig;
import com.techcombank.tclife.common.security.annotation.EnableApiSecurity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableApiSecurity
@SpringBootApplication
@EnableFeignClients
@EnableCommonConfig
public class PolicyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PolicyServiceApplication.class, args);
	}

}
