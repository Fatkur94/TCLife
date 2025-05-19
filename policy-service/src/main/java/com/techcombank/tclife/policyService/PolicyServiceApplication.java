package com.techcombank.tclife.policyService;

import com.techcombank.tclife.common.security.annotation.EnableApiSecurity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableApiSecurity
@SpringBootApplication
@ComponentScan(basePackages = {
		"com.techcombank.tclife.policyService",
		"com.techcombank.tclife.common.exception"
})
public class PolicyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PolicyServiceApplication.class, args);
	}

}
