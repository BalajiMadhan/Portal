package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages="com.portal")
@EnableJpaRepositories(basePackages ="com.portal.repository")
@EntityScan(basePackages="com.portal.enitity")
public class PcfPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(PcfPortalApplication.class, args);
	}
}
