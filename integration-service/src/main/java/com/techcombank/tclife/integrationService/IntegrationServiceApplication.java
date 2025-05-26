package com.techcombank.tclife.integrationService;

import com.techcombank.tclife.common.annotation.EnableCommonConfig;
import com.techcombank.tclife.common.security.annotation.EnableApiSecurity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableApiSecurity
@SpringBootApplication
@ComponentScan(basePackages = {
		"com.techcombank.tclife.integrationService",
		"com.techcombank.tclife.common.exception"
})
@EnableCommonConfig
@EnableFeignClients
public class IntegrationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntegrationServiceApplication.class, args);
	}

}
