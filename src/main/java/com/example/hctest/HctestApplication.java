package com.example.hctest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HctestApplication {

	public static void main(String[] args) {
		SpringApplication.run(HctestApplication.class, args);

		System.out.println("\n" + "SERVICE STARTED!" + "\n");
	}

}
