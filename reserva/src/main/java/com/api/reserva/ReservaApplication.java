package com.api.reserva;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class ReservaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservaApplication.class, args);
	}

}
