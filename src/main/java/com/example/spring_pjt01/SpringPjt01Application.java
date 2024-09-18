package com.example.spring_pjt01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan
public class SpringPjt01Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringPjt01Application.class, args);
	}

}
