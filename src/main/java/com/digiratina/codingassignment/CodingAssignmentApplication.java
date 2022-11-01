package com.digiratina.codingassignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.digiratina.codingassignment.repository")
@EntityScan("com.digiratina.codingassignment.model")
@SpringBootApplication
public class CodingAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodingAssignmentApplication.class, args);
	}

}
