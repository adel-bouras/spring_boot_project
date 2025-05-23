package com.example.creche;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class CrecheApplication {


@RestController
public class HomeController {

	public static void main(String[] args) {
		SpringApplication.run(CrecheApplication.class, args);
	}

}
}
