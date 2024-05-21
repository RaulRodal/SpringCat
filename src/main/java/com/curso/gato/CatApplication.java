package com.curso.gato;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.curso.gato.controller")
public class CatApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatApplication.class, args);
	}

}