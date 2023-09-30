package com.akash00028.advancedCrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin(origins = "http://localhost:4200")
public class AdvancedCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvancedCrudApplication.class, args);
		System.out.println("AdvancedCrudApplication started...");
	}

}
 