package com.backend.FarmHelper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.backend.controllers","com.backend.boundaries", "com.backend.FarmHelper"})
@EntityScan("com.backend.entities")
@EnableJpaRepositories("com.backend.boundaries")
public class FarmHelperApplication {

	public static void main(String[] args) {
		SpringApplication.run(FarmHelperApplication.class, args);
		
	}
}
