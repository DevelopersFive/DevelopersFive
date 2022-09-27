package com.co.udea.mintic.developersFive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DevelopersFiveApplication {
	/*
	se inhabilita para que la ruta google pueda usarse

	@RequestMapping("/")
	String landingPage(){
		return "BIENVENIDOS";
	}
*/
	public static void main(String[] args) {
		SpringApplication.run(DevelopersFiveApplication.class, args);
	}

}
