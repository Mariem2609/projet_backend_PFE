package com.parcinfo.gestion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GestionParcInformatiqueApplication {
	public static void main(String[] args) {

		SpringApplication.run(GestionParcInformatiqueApplication.class, args);
	}

}
