package com.korayakben.taxup.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"com.korayakben"})
@EntityScan(basePackages = {"com.korayakben"})
@EnableJpaRepositories(basePackages = {"com.korayakben"})
@SpringBootApplication
public class TaxupApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaxupApplication.class, args);
	}

}
