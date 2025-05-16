package com.techcombank.tclife.leadService;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(
		webEnvironment = SpringBootTest.WebEnvironment.NONE,
		classes = {com.techcombank.tclife.leadService.LeadServiceApplication.class},
		properties = {
				"spring.autoconfigure.exclude=" +
						"org.springframework.boot.autoconfigure.http.client.HttpClientAutoConfiguration," +
						"org.springframework.boot.autoconfigure.ssl.SslAutoConfiguration," +
						"org.springframework.boot.autoconfigure.web.client.RestClientAutoConfiguration"
		}
)
class LeadServiceApplicationTests {

	@Test
	void contextLoads() {
	}

}
