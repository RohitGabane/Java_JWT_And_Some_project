package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.example.*")

public class SpringSecurityFormLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityFormLoginApplication.class, args);
	}

}
