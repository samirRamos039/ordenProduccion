package com.example.produccion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class ProduccionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProduccionApplication.class, args);
		
	}

}
