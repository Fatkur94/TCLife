package com.techcombank.tclife.opsService;

import com.techcombank.tclife.common.annotation.EnableCommonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableCommonConfig
public class OpsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpsServiceApplication.class, args);
	}

}
