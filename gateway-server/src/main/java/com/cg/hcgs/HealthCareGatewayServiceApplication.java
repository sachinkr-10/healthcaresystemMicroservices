package com.cg.hcgs;

import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class HealthCareGatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthCareGatewayServiceApplication.class, args);
	}

}
