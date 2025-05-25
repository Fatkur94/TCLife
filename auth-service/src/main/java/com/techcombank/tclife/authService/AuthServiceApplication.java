package com.techcombank.tclife.authService;

import com.techcombank.tclife.common.annotation.EnableCommonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(
		exclude = {
				DataSourceAutoConfiguration.class
		}
)
@EnableCommonConfig
@EnableFeignClients(basePackages = {
		"com.techcombank.tclife.authService.client"
})
public class AuthServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(AuthServiceApplication.class, args);
	}
}
