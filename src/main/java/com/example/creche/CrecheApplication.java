package com.example.creche;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class CrecheApplication {


@RestController
public class HomeController {

    @GetMapping("/blabla")
    public String home() {
        return "Welcome to the Creche app!";
    }
}

@RestController
public class justDoIT{

	@GetMapping("/tst")
	public String fun(){
		return "hello from adel's fun function" ;
	}
}

	public static void main(String[] args) {
		SpringApplication.run(CrecheApplication.class, args);
	}

}
