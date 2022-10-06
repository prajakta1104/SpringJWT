package Atm_demo.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication
public class AtmApplicationJwt {

	public static void main(String[] args) {
		SpringApplication.run(AtmApplicationJwt.class, args);
	}

}

