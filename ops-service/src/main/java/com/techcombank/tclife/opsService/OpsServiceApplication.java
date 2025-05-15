package com.techcombank.tclife.opsService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
		"com.techcombank.tclife.opsService",
		"com.techcombank.tclife.common.exception"
})
public class OpsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpsServiceApplication.class, args);
	}

}
