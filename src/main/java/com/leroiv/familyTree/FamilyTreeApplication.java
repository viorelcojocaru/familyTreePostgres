package com.leroiv.familyTree;

import com.leroiv.familyTree.service.CountryService;
import com.leroiv.familyTree.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FamilyTreeApplication {
	private static final Logger log = LoggerFactory.getLogger(FamilyTreeApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(FamilyTreeApplication.class, args);
	}
	@Autowired
	PersonService personService;
	@Autowired
	CountryService countryService;

	@Bean
	CommandLineRunner start(PersonService service) {
		return args -> {
			log.info("@@ findAll() call...");
			service.findAll().forEach(entry -> log.info(entry.toString()));
			countryService.findAll().forEach(entry ->log.info(entry.toString()));
		};
	}
}
