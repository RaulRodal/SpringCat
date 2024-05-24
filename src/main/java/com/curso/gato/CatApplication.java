package com.curso.gato;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "com.curso.gato.model")
@EnableJpaRepositories(basePackages = "com.curso.gato.dao")
@SpringBootApplication(scanBasePackages = {"com.curso.gato.controller", "com.curso.gato.service"})
public class CatApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatApplication.class, args);
	}

}
