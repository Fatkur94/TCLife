package com.techcombank.tclife.claimService;

import com.techcombank.tclife.common.annotation.EnableCommonConfig;
import com.techcombank.tclife.common.security.annotation.EnableApiSecurity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableApiSecurity
@SpringBootApplication
@EnableCommonConfig
public class ClaimServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClaimServiceApplication.class, args);
	}

}
