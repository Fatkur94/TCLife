package com.techcombank.tclife.dataService;

import com.techcombank.tclife.common.security.annotation.EnableApiSecurity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableApiSecurity
@SpringBootApplication
@ComponentScan(basePackages = {
		"com.techcombank.tclife.dataService",
		"com.techcombank.tclife.common.exception"
})
public class DataServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataServiceApplication.class, args);
	}

}
