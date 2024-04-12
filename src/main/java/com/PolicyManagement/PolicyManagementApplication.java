package com.PolicyManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PolicyManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(PolicyManagementApplication.class, args);
	}

}
