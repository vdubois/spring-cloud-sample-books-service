package io.github.vdubois;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableCircuitBreaker
@EnableEurekaClient
@EnableCaching
public class SpringCloudSampleBooksServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudSampleBooksServiceApplication.class, args);
	}
}
