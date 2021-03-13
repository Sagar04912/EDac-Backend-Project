package com.shr.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.shr.springboot.repository.UsersRepository;

@SpringBootApplication

public class EdacProjectSpringbootBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EdacProjectSpringbootBackendApplication.class, args);
	}

}
