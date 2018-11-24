package com.PolicyManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EntityScan("com.pms.Entities")
@SpringBootApplication
@EnableJpaRepositories("com.pms.dao")
@ComponentScans(value= {@ComponentScan("com.PolicyManagement"),@ComponentScan("com.pms.controllers"),
		@ComponentScan("com.pms.dao"),@ComponentScan("com.pms.service"),@ComponentScan("com.pms.Entities")})
public class PolicyManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(PolicyManagementApplication.class, args);
	}
}
