package com.example.Aula;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.Aula.entities.Local;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

@SpringBootApplication
public class AulaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AulaApplication.class, args);
	}
	
}
